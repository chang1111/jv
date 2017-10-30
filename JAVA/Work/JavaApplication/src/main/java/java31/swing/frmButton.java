package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmButton extends JFrame {
    
    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JTextField textField;
    private Action action;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmButton frame = new frmButton();
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
    public frmButton() {
        setTitle("테스트 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getBtnNewButton_2());
        contentPane.add(getBtnNewButton_3());
        contentPane.add(getTextField());
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("왼쪽 버튼");
        	btnNewButton.setBounds(34, 21, 97, 66);
        }
        return btnNewButton;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("중앙 버튼");
        	btnNewButton_1.setBounds(166, 21, 97, 66);
        }
        return btnNewButton_1;
    }
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
        	btnNewButton_2 = new JButton("오른쪽 버튼");
        	btnNewButton_2.setEnabled(false);
        	btnNewButton_2.setBounds(298, 21, 97, 66);
        }
        return btnNewButton_2;
    }
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
        	btnNewButton_3 = new JButton("창닫기");
        	btnNewButton_3.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        //창 닫기 코드
//        	        dispose();
        	        System.exit(0);
        	    }
        	});
        	btnNewButton_3.setBounds(34, 182, 361, 58);
        }
        return btnNewButton_3;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(34, 128, 361, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "SwingAction");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
        }
    }
    private Action getAction() {
        if (action == null) {
        	action = new SwingAction();
        }
        return action;
    }
}
