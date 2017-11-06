package 도서관리프로그램;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.springframework.jdbc.core.JdbcOperations;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class 회원등록 extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField txt이름;
    private JTextField txt주민번호0;
    private JTextField txt메일주소0;
    private JComboBox cb전화번호0;
    private JLabel lblNewLabel_5;
    private JTextField txt전화번호1;
    private JLabel lblNewLabel_6;
    private JTextField txt전화번호2;
    private JLabel lblNewLabel_7;
    private JComboBox cb메일주소1;
    private JButton btn등록;
    private JButton btn취소;
    private JTextField txt주민번호1;
    private JLabel lblNewLabel_8;
    private 도서관리 parent = null;
    private List<회원정보> members = null;
    private JTable table = null;
    
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
        contentPane.add(getTxt이름());
        contentPane.add(getTxt주민번호0());
        contentPane.add(getTxt메일주소0());
        contentPane.add(getCb전화번호0());
        contentPane.add(getLblNewLabel_5());
        contentPane.add(getTxt전화번호1());
        contentPane.add(getLblNewLabel_6());
        contentPane.add(getTxt전화번호2());
        contentPane.add(getLblNewLabel_7());
        contentPane.add(getCb메일주소1());
        contentPane.add(getBtn등록());
        contentPane.add(getBtn취소());
        contentPane.add(getTextField_5());
        contentPane.add(getLblNewLabel_8());
    }

    public 회원등록(도서관리 parent, List<회원정보> members, JTable table) {
        this();
        this.parent = parent;
        this.members = members;
        this.table = table;
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
    private JTextField getTxt이름() {
        if (txt이름 == null) {
        	txt이름 = new JTextField();
        	txt이름.setBounds(84, 52, 116, 21);
        	txt이름.setColumns(10);
        }
        return txt이름;
    }
    private JTextField getTxt주민번호0() {
        if (txt주민번호0 == null) {
        	txt주민번호0 = new JTextField();
        	txt주민번호0.setBounds(84, 84, 65, 21);
        	txt주민번호0.setColumns(10);
        }
        return txt주민번호0;
    }
    private JTextField getTxt메일주소0() {
        if (txt메일주소0 == null) {
        	txt메일주소0 = new JTextField();
        	txt메일주소0.setBounds(84, 153, 116, 21);
        	txt메일주소0.setColumns(10);
        }
        return txt메일주소0;
    }
    private JComboBox getCb전화번호0() {
        if (cb전화번호0 == null) {
        	cb전화번호0 = new JComboBox();
        	cb전화번호0.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "017", "018", "019"}));
        	cb전화번호0.setBounds(81, 121, 57, 21);
        }
        return cb전화번호0;
    }
    private JLabel getLblNewLabel_5() {
        if (lblNewLabel_5 == null) {
        	lblNewLabel_5 = new JLabel("-");
        	lblNewLabel_5.setBounds(139, 124, 11, 15);
        }
        return lblNewLabel_5;
    }
    private JTextField getTxt전화번호1() {
        if (txt전화번호1 == null) {
        	txt전화번호1 = new JTextField();
        	txt전화번호1.setBounds(149, 121, 57, 21);
        	txt전화번호1.setColumns(10);
        }
        return txt전화번호1;
    }
    private JLabel getLblNewLabel_6() {
        if (lblNewLabel_6 == null) {
        	lblNewLabel_6 = new JLabel("-");
        	lblNewLabel_6.setBounds(208, 124, 11, 15);
        }
        return lblNewLabel_6;
    }
    private JTextField getTxt전화번호2() {
        if (txt전화번호2 == null) {
        	txt전화번호2 = new JTextField();
        	txt전화번호2.setBounds(218, 121, 57, 21);
        	txt전화번호2.setColumns(10);
        }
        return txt전화번호2;
    }
    private JLabel getLblNewLabel_7() {
        if (lblNewLabel_7 == null) {
        	lblNewLabel_7 = new JLabel("@");
        	lblNewLabel_7.setBounds(201, 156, 18, 15);
        }
        return lblNewLabel_7;
    }
    private JComboBox getCb메일주소1() {
        if (cb메일주소1 == null) {
        	cb메일주소1 = new JComboBox();
        	cb메일주소1.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "hanmail.net", "nate.com"}));
        	cb메일주소1.setBounds(212, 153, 94, 21);
        }
        return cb메일주소1;
    }
    private JButton getBtn등록() {
        if (btn등록 == null) {
        	btn등록 = new JButton("등록");
        	btn등록.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        if (txt이름.getText().length() != 0 && txt주민번호0.getText().length() != 0 && txt주민번호1.getText().length() != 0) {
            	        Integer 회원번호 = 도서관리.회원++;
            	        String 이름 = txt이름.getText();
            	        String 주민번호 = txt주민번호0.getText() + "-" + txt주민번호1.getText();
            	        String 전화번호 = null;
            	        if (txt전화번호1.getText().length() != 0 && txt전화번호2.getText().length() != 0) {
                	        전화번호 = (String)cb전화번호0.getSelectedItem() + "-" + txt전화번호1.getText() + "-" + txt전화번호2.getText();
            	        }
            	        else {
            	            전화번호 = "";
            	        }
            	        String 메일주소 = null;
                        if (txt메일주소0.getText().length() != 0) {
                            메일주소 = txt메일주소0.getText() + "@" + (String)cb메일주소1.getSelectedItem();
                        }
                        else {
                            메일주소 = "";
                        }
                	        
            	        
            	        members.add(new 회원정보(회원번호, 이름, 주민번호, 전화번호, 메일주소));
            	        
            	        도서관리.refresh회원정보(members, table);
            	        
            	        JOptionPane.showMessageDialog(null, "등록완료");
            	        dispose();
        	        }
        	        else {
        	            JOptionPane.showMessageDialog(null, "잘못된 입력");
        	        }
        	    }
        	});
        	btn등록.setBounds(53, 202, 97, 39);
        }
        return btn등록;
    }
    private JButton getBtn취소() {
        if (btn취소 == null) {
        	btn취소 = new JButton("취소");
        	btn취소.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	btn취소.setBounds(191, 202, 97, 39);
        }
        return btn취소;
    }
    private JTextField getTextField_5() {
        if (txt주민번호1 == null) {
        	txt주민번호1 = new JTextField();
        	txt주민번호1.setBounds(167, 84, 79, 21);
        	txt주민번호1.setColumns(10);
        }
        return txt주민번호1;
    }
    private JLabel getLblNewLabel_8() {
        if (lblNewLabel_8 == null) {
        	lblNewLabel_8 = new JLabel("-");
        	lblNewLabel_8.setBounds(154, 87, 11, 15);
        }
        return lblNewLabel_8;
    }
}
