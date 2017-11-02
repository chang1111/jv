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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class 책등록 extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JComboBox comboBox;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    책등록 frame = new 책등록();
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
    public 책등록() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 397, 337);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLblNewLabel_2());
        contentPane.add(getLblNewLabel_3());
        contentPane.add(getLblNewLabel_4());
        contentPane.add(getLblNewLabel_5());
        contentPane.add(getTextField());
        contentPane.add(getTextField_1());
        contentPane.add(getTextField_2());
        contentPane.add(getTextField_3());
        contentPane.add(getComboBox());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("책 정보 입력");
        	lblNewLabel.setBounds(157, 10, 68, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("책 제목");
        	lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_1.setBounds(12, 44, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("출판사");
        	lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_2.setBounds(12, 81, 57, 15);
        }
        return lblNewLabel_2;
    }
    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("저자");
        	lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_3.setBounds(12, 120, 57, 15);
        }
        return lblNewLabel_3;
    }
    private JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("가격");
        	lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_4.setBounds(12, 157, 57, 15);
        }
        return lblNewLabel_4;
    }
    private JLabel getLblNewLabel_5() {
        if (lblNewLabel_5 == null) {
        	lblNewLabel_5 = new JLabel("장르");
        	lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_5.setBounds(12, 194, 57, 15);
        }
        return lblNewLabel_5;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(95, 41, 184, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JTextField getTextField_1() {
        if (textField_1 == null) {
        	textField_1 = new JTextField();
        	textField_1.setBounds(95, 78, 184, 21);
        	textField_1.setColumns(10);
        }
        return textField_1;
    }
    private JTextField getTextField_2() {
        if (textField_2 == null) {
        	textField_2 = new JTextField();
        	textField_2.setBounds(95, 117, 184, 21);
        	textField_2.setColumns(10);
        }
        return textField_2;
    }
    private JTextField getTextField_3() {
        if (textField_3 == null) {
        	textField_3 = new JTextField();
        	textField_3.setBounds(95, 154, 85, 21);
        	textField_3.setColumns(10);
        }
        return textField_3;
    }
    private JComboBox getComboBox() {
        if (comboBox == null) {
        	comboBox = new JComboBox();
        	comboBox.setModel(new DefaultComboBoxModel(new String[] {"소설", "교육", "문학", "해외", "기타"}));
        	comboBox.setBounds(95, 191, 85, 21);
        }
        return comboBox;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("등록");
        	btnNewButton.setBounds(59, 235, 97, 40);
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
        	btnNewButton_1.setBounds(182, 235, 97, 40);
        }
        return btnNewButton_1;
    }
}
