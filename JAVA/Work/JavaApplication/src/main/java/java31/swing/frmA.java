package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmA extends JFrame {
    
    private JPanel contentPane;
    private JTextField aField;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private static frmA frame = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new frmA();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public frmA() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getAField());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
    }
    
    private JTextField getAField() {
        if (aField == null) {
        	aField = new JTextField();
        	aField.setBounds(84, 155, 116, 21);
        	aField.setColumns(10);
        }
        return aField;
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("새창띄우기 - 생성자");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String value = aField.getText();
        	        frmB frm = new frmB(frame, value);
        	        frm.setVisible(true);
        	    }
        	});
        	btnNewButton.setBounds(48, 98, 182, 23);
        }
        return btnNewButton;
    }
    
    public void refresh(String value) {
        aField.setText(value);
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("새창띄우기 - 세터");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        frmB frm = new frmB();
        	        frm.setVisible(true);
        	        String value = aField.getText();
        	        frm.setBField(value);
        	        frm.setParent(frame);
        	    }
        	});
        	btnNewButton_1.setBounds(48, 40, 182, 23);
        }
        return btnNewButton_1;
    }
}
