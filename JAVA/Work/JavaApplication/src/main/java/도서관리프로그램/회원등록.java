package 도서관리프로그램;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 회원등록 extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JComboBox comboBox;
    private JLabel lblNewLabel_5;
    private JTextField textField_3;
    private JLabel lblNewLabel_6;
    private JTextField textField_4;
    private JLabel lblNewLabel_7;
    private JComboBox comboBox_1;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    회원등록 frame = new 회원등록();
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
    public 회원등록() {
        setTitle("회원가입");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 359, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLblNewLabel_2());
        contentPane.add(getLblNewLabel_3());
        contentPane.add(getLblNewLabel_4());
        contentPane.add(getTextField());
        contentPane.add(getTextField_1());
        contentPane.add(getTextField_2());
        contentPane.add(getComboBox());
        contentPane.add(getLblNewLabel_5());
        contentPane.add(getTextField_3());
        contentPane.add(getLblNewLabel_6());
        contentPane.add(getTextField_4());
        contentPane.add(getLblNewLabel_7());
        contentPane.add(getComboBox_1());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
    }
    
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("회원 정보 입력");
        	lblNewLabel.setBounds(118, 10, 88, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("이름");
        	lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_1.setBounds(12, 55, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("주민번호");
        	lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_2.setBounds(12, 87, 57, 15);
        }
        return lblNewLabel_2;
    }
    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("전화번호");
        	lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_3.setBounds(12, 121, 57, 15);
        }
        return lblNewLabel_3;
    }
    private JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("메일계정");
        	lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_4.setBounds(12, 156, 57, 15);
        }
        return lblNewLabel_4;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(84, 52, 116, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JTextField getTextField_1() {
        if (textField_1 == null) {
        	textField_1 = new JTextField();
        	textField_1.setBounds(84, 84, 116, 21);
        	textField_1.setColumns(10);
        }
        return textField_1;
    }
    private JTextField getTextField_2() {
        if (textField_2 == null) {
        	textField_2 = new JTextField();
        	textField_2.setBounds(84, 153, 116, 21);
        	textField_2.setColumns(10);
        }
        return textField_2;
    }
    private JComboBox getComboBox() {
        if (comboBox == null) {
        	comboBox = new JComboBox();
        	comboBox.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "017", "018", "019"}));
        	comboBox.setBounds(81, 121, 57, 21);
        }
        return comboBox;
    }
    private JLabel getLblNewLabel_5() {
        if (lblNewLabel_5 == null) {
        	lblNewLabel_5 = new JLabel("-");
        	lblNewLabel_5.setBounds(139, 124, 11, 15);
        }
        return lblNewLabel_5;
    }
    private JTextField getTextField_3() {
        if (textField_3 == null) {
        	textField_3 = new JTextField();
        	textField_3.setBounds(149, 121, 57, 21);
        	textField_3.setColumns(10);
        }
        return textField_3;
    }
    private JLabel getLblNewLabel_6() {
        if (lblNewLabel_6 == null) {
        	lblNewLabel_6 = new JLabel("-");
        	lblNewLabel_6.setBounds(208, 124, 11, 15);
        }
        return lblNewLabel_6;
    }
    private JTextField getTextField_4() {
        if (textField_4 == null) {
        	textField_4 = new JTextField();
        	textField_4.setBounds(218, 121, 57, 21);
        	textField_4.setColumns(10);
        }
        return textField_4;
    }
    private JLabel getLblNewLabel_7() {
        if (lblNewLabel_7 == null) {
        	lblNewLabel_7 = new JLabel("@");
        	lblNewLabel_7.setBounds(201, 156, 18, 15);
        }
        return lblNewLabel_7;
    }
    private JComboBox getComboBox_1() {
        if (comboBox_1 == null) {
        	comboBox_1 = new JComboBox();
        	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "hanmail.net", "nate.com", "직접입력"}));
        	comboBox_1.setBounds(212, 153, 94, 21);
        }
        return comboBox_1;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("가입");
        	btnNewButton.setBounds(53, 202, 97, 39);
        }
        return btnNewButton;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("취소");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	btnNewButton_1.setBounds(191, 202, 97, 39);
        }
        return btnNewButton_1;
    }
}
