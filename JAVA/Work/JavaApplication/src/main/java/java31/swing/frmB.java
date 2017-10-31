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

public class frmB extends JFrame {
    
    private JPanel contentPane;
    private JTextField bField;
    private JButton btnNewButton;
    private frmA parent = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmB frame = new frmB();
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
    public frmB() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBField());
        contentPane.add(getBtnNewButton());
    }
    
    public frmB(frmA parent) {
        this();
        this.parent = parent;
    }
    
    public frmB(frmA parent, String val) {
        this();
        this.parent = parent;
        bField.setText(val);
    }
    
    public void setBField(String val) {
        bField.setText(val);
    }

    private JTextField getBField() {
        if (bField == null) {
        	bField = new JTextField();
        	bField.setBounds(84, 59, 116, 21);
        	bField.setColumns(10);
        }
        return bField;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("값 돌려주기");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String val = bField.getText();
        	        parent.refresh(val);
        	        
        	    }
        	});
        	btnNewButton.setBounds(95, 156, 97, 23);
        }
        return btnNewButton;
    }
}
