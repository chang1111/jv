package 도서관리프로그램;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
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
    private JTextField txt책제목;
    private JTextField txt출판사;
    private JTextField txt저자;
    private JTextField txt가격;
    private JComboBox cb장르;
    private JButton btn등록;
    private JButton btn취소;
    private 도서관리 parent = null;
    private List<책정보> books = null;
    private JTable table = null;
    
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
        contentPane.add(getTxt책제목());
        contentPane.add(getTxt출판사());
        contentPane.add(getTxt저자());
        contentPane.add(getTxt가격());
        contentPane.add(getCb장르());
        contentPane.add(getBtn등록());
        contentPane.add(getBtn취소());
    }
    
    public 책등록(도서관리 parent, List<책정보> books, JTable table) {
        this();
        this.parent = parent;
        this.books = books;
        this.table = table;
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
    private JTextField getTxt책제목() {
        if (txt책제목 == null) {
        	txt책제목 = new JTextField();
        	txt책제목.setBounds(95, 41, 184, 21);
        	txt책제목.setColumns(10);
        }
        return txt책제목;
    }
    private JTextField getTxt출판사() {
        if (txt출판사 == null) {
        	txt출판사 = new JTextField();
        	txt출판사.setBounds(95, 78, 184, 21);
        	txt출판사.setColumns(10);
        }
        return txt출판사;
    }
    private JTextField getTxt저자() {
        if (txt저자 == null) {
        	txt저자 = new JTextField();
        	txt저자.setBounds(95, 117, 184, 21);
        	txt저자.setColumns(10);
        }
        return txt저자;
    }
    private JTextField getTxt가격() {
        if (txt가격 == null) {
        	txt가격 = new JTextField();
        	txt가격.setBounds(95, 154, 85, 21);
        	txt가격.setColumns(10);
        }
        return txt가격;
    }
    private JComboBox getCb장르() {
        if (cb장르 == null) {
        	cb장르 = new JComboBox();
        	cb장르.setModel(new DefaultComboBoxModel(new String[] {"소설", "교육", "문학", "해외", "기타"}));
        	cb장르.setBounds(95, 191, 85, 21);
        }
        return cb장르;
    }
    private JButton getBtn등록() {
        if (btn등록 == null) {
        	btn등록 = new JButton("등록");
        	btn등록.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        Integer 책번호 = 도서관리.책++;
        	        String 책제목 = txt책제목.getText();
        	        String 출판사 = txt출판사.getText();
        	        String 저자 = txt저자.getText();
        	        Integer 가격 = Integer.valueOf(txt가격.getText());
        	        String 장르 = (String)cb장르.getSelectedItem();
        	        Boolean 대여정보 = true;
        	        
        	        books.add(new 책정보(책번호, 책제목, 출판사, 장르, 저자, 가격, 대여정보));
        	        
        	        도서관리.refresh책정보(books, table);
        	        
        	    }
        	});
        	btn등록.setBounds(59, 235, 97, 40);
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
        	btn취소.setBounds(182, 235, 97, 40);
        }
        return btn취소;
    }
}
