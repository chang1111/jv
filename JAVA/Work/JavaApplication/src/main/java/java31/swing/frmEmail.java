package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class frmEmail extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_3;
    private JTextField textField_2;
    private JLabel lblNewLabel_4;
    private JTextField textField_3;
    private JList list;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JLabel lblNewLabel_5;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmEmail frame = new frmEmail();
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
    public frmEmail() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 570);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLblNewLabel_2());
        contentPane.add(getTextField());
        contentPane.add(getTextField_1());
        contentPane.add(getLblNewLabel_3());
        contentPane.add(getTextField_2());
        contentPane.add(getLblNewLabel_4());
        contentPane.add(getTextField_3());
        contentPane.add(getList());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getBtnNewButton_2());
        contentPane.add(getBtnNewButton_3());
        contentPane.add(getLblNewLabel_5());
        contentPane.add(getRdbtnNewRadioButton());
        contentPane.add(getRdbtnNewRadioButton_1());
        contentPane.add(getRdbtnNewRadioButton_2());
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("Name");
        	lblNewLabel.setBounds(36, 36, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("이름");
        	lblNewLabel_1.setBounds(36, 73, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("직책");
        	lblNewLabel_2.setBounds(36, 109, 57, 15);
        }
        return lblNewLabel_2;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(100, 70, 82, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JTextField getTextField_1() {
        if (textField_1 == null) {
        	textField_1 = new JTextField();
        	textField_1.setBounds(100, 106, 82, 21);
        	textField_1.setColumns(10);
        }
        return textField_1;
    }
    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("아이디");
        	lblNewLabel_3.setBounds(218, 109, 57, 15);
        }
        return lblNewLabel_3;
    }
    private JTextField getTextField_2() {
        if (textField_2 == null) {
        	textField_2 = new JTextField();
        	textField_2.setBounds(287, 106, 82, 21);
        	textField_2.setColumns(10);
        }
        return textField_2;
    }
    private JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("이메일주소");
        	lblNewLabel_4.setBounds(36, 211, 73, 15);
        }
        return lblNewLabel_4;
    }
    private JTextField getTextField_3() {
        if (textField_3 == null) {
        	textField_3 = new JTextField();
        	textField_3.setBounds(100, 208, 202, 21);
        	textField_3.setColumns(10);
        }
        return textField_3;
    }
    private JList getList() {
        if (list == null) {
        	list = new JList();
        	list.setBounds(36, 251, 266, 132);
        }
        return list;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("Add");
        	btnNewButton.setBounds(314, 207, 97, 31);
        }
        return btnNewButton;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("Edit");
        	btnNewButton_1.setBounds(314, 248, 97, 33);
        }
        return btnNewButton_1;
    }
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
        	btnNewButton_2 = new JButton("Remove");
        	btnNewButton_2.setBounds(314, 291, 97, 31);
        }
        return btnNewButton_2;
    }
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
        	btnNewButton_3 = new JButton("Default");
        	btnNewButton_3.setBounds(314, 332, 97, 31);
        }
        return btnNewButton_3;
    }
    private JLabel getLblNewLabel_5() {
        if (lblNewLabel_5 == null) {
        	lblNewLabel_5 = new JLabel("New label");
        	lblNewLabel_5.setBounds(36, 393, 57, 15);
        }
        return lblNewLabel_5;
    }
    private JRadioButton getRdbtnNewRadioButton() {
        if (rdbtnNewRadioButton == null) {
        	rdbtnNewRadioButton = new JRadioButton("HTML");
        	buttonGroup.add(rdbtnNewRadioButton);
        	rdbtnNewRadioButton.setBounds(29, 414, 64, 23);
        }
        return rdbtnNewRadioButton;
    }
    private JRadioButton getRdbtnNewRadioButton_1() {
        if (rdbtnNewRadioButton_1 == null) {
        	rdbtnNewRadioButton_1 = new JRadioButton("Plain Text");
        	buttonGroup.add(rdbtnNewRadioButton_1);
        	rdbtnNewRadioButton_1.setBounds(110, 414, 82, 23);
        }
        return rdbtnNewRadioButton_1;
    }
    private JRadioButton getRdbtnNewRadioButton_2() {
        if (rdbtnNewRadioButton_2 == null) {
        	rdbtnNewRadioButton_2 = new JRadioButton("Custom");
        	buttonGroup.add(rdbtnNewRadioButton_2);
        	rdbtnNewRadioButton_2.setBounds(196, 414, 82, 23);
        }
        return rdbtnNewRadioButton_2;
    }
}
