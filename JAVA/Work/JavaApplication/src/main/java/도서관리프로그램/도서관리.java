package 도서관리프로그램;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java31.st2table.Book;

import java.awt.Component;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 도서관리 extends JFrame {
    
    private JPanel contentPane;
    private JPanel panel;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JTabbedPane tabbedPane;
    private JPanel rentPanel;
    private JPanel memberPanel;
    private JPanel bookPanel;
    private JLabel label_1;
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
    private JTextField txt장르;
    private JTextField txt책검색;
    private JTextField txt책번호;
    private JComboBox cbBook;
    private JButton btn대여하기;
    private JButton btn책수정;
    private JButton btn책삭제;
    private JButton btn책취소;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JTextField txt이름;
    private JTextField txt주민번호0;
    private JTextField txt전화번호0;
    private JTextField txt메일주소0;
    private JTextField txt주민번호1;
    private JTextField txt전화번호1;
    private JTextField txt메일주소1;
    private JTextField txt회원검색;
    private JTextField txt전화번호2;
    private JLabel label_2;
    private JLabel lblNewLabel_11;
    private JLabel label_3;
    private JLabel label_4;
    private JComboBox cbMember;
    private JScrollPane scrollPane_1;
    static JTable bookTable;
    private JScrollPane scrollPane_2;
    private static JTable memberTable;
    private JScrollPane scrollPane_3;
    static JTable rentTable;
    private JButton btnNewButton_8;
    private JPanel panel_1;
    private JLabel lblNewLabel_12;
    private JScrollPane scrollPane;
    static JTable frontTable;
    private JButton btn회원삭제;
    private JButton btn회원수정;
    private JButton btn회원취소;
    private JButton button;
    private JButton btnNewButton_12;
    static 도서관리 frame = null;
    static List<책정보> books = null;
    static List<회원정보> members = null;
    static List<대여목록> rents = null;
    static Integer 책 = 0;
    static Integer 회원 = 0;
    static Integer 대여 = 0;
    private static int bookRow = 0;
    private static int memberRow = 0;
    private static int rentRow = 0;
    private JTree tree;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new 도서관리();
                    frame.setVisible(true);
                    init책정보();
                    refresh책정보(books, bookTable);
                    init회원정보();
                    refresh회원정보(members, memberTable);
                    rents = new ArrayList<대여목록>();
                    refresh대여목록(rents, rentTable);
                    refresh대출상황(rents, frontTable);
                    String 책번호 = bookTable.getValueAt(bookRow, 0).toString();
                    String 책제목 = bookTable.getValueAt(bookRow, 1).toString();
                    String 출판사 = bookTable.getValueAt(bookRow, 2).toString();
                    String 장르 = bookTable.getValueAt(bookRow, 3).toString();
                    String 저자 = bookTable.getValueAt(bookRow, 4).toString();
                    String 가격 = bookTable.getValueAt(bookRow, 5).toString();
                    
                    frame.txt책번호.setText(책번호);
                    frame.txt책제목.setText(책제목);
                    frame.txt출판사.setText(출판사);
                    frame.txt저자.setText(저자);
                    frame.txt가격.setText(가격);
                    frame.txt장르.setText(장르);

                    String 이름 = memberTable.getValueAt(memberRow, 1).toString();
                    String[] 주민번호 = new String[2];
                    주민번호 = memberTable.getValueAt(memberRow, 2).toString().split("-");
                    String[] 전화번호 = new String[3];
                    전화번호 = memberTable.getValueAt(memberRow, 3).toString().split("-");
                    String[] 메일주소 = new String[2];
                    메일주소 = memberTable.getValueAt(memberRow, 4).toString().split("@");
                    
                    frame.txt이름.setText(이름);
                    frame.txt주민번호0.setText(주민번호[0]);
                    frame.txt주민번호1.setText(주민번호[1]);
                    frame.txt전화번호0.setText(전화번호[0]);
                    frame.txt전화번호1.setText(전화번호[1]);
                    frame.txt전화번호2.setText(전화번호[2]);
                    frame.txt메일주소0.setText(메일주소[0]);
                    frame.txt메일주소1.setText(메일주소[1]);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public 도서관리() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1101, 723);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getPanel());
        contentPane.add(getTabbedPane());
        contentPane.add(getPanel_1());
    }
    
    private JPanel getPanel() {
        if (panel == null) {
        	panel = new JPanel();
        	panel.setBounds(12, 10, 487, 58);
        	panel.setLayout(null);
        	panel.add(getBtnNewButton());
        	panel.add(getBtnNewButton_1());
        	panel.add(getBtnNewButton_2());
        	panel.add(getBtnNewButton_3());
        	panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getBtnNewButton(), getBtnNewButton_1(), getBtnNewButton_2(), getBtnNewButton_3()}));
        }
        return panel;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("회원등록");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        EventQueue.invokeLater(new Runnable() {
        	            public void run() {
        	                try {
        	                    회원등록 frame = new 회원등록(도서관리.frame, members, memberTable);
        	                    frame.setVisible(true);
        	                    
        	                } catch (Exception e) {
        	                    e.printStackTrace();
        	                }
        	            }
        	        });
        	    }
        	});
        	btnNewButton.setBounds(14, 10, 97, 38);
        }
        return btnNewButton;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("책 등록");
        	btnNewButton_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        EventQueue.invokeLater(new Runnable() {
        	            public void run() {
        	                try {
        	                    책등록 frame = new 책등록(도서관리.frame, books, bookTable);
        	                    frame.setVisible(true);
        	                } catch (Exception e) {
        	                    e.printStackTrace();
        	                }
        	            }
        	        });
        	    }
        	});
        	btnNewButton_1.setBounds(125, 10, 97, 38);
        }
        return btnNewButton_1;
    }
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
        	btnNewButton_2 = new JButton("새로고침");
        	btnNewButton_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    refresh대출상황(rents, frontTable);
        	        refresh책정보(books, bookTable);
        	        refresh회원정보(members, memberTable);
        	        refresh대여목록(rents, rentTable);
        	    }
        	});
        	btnNewButton_2.setBounds(236, 10, 97, 38);
        }
        return btnNewButton_2;
    }
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
        	btnNewButton_3 = new JButton("프로그램 종료");
        	btnNewButton_3.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        System.exit(0);
        	    }
        	});
        	btnNewButton_3.setBounds(347, 10, 124, 38);
        }
        return btnNewButton_3;
    }
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.setBounds(310, 94, 734, 581);
        	tabbedPane.addTab("책 정보", null, getBookPanel(), null);
        	tabbedPane.addTab("회원 정보", null, getMemberPanel(), null);
        	tabbedPane.addTab("대여 목록", null, getRentPanel(), null);
        }
        return tabbedPane;
    }
    private JPanel getRentPanel() {
        if (rentPanel == null) {
        	rentPanel = new JPanel();
        	rentPanel.setLayout(null);
        	rentPanel.add(getScrollPane_3());
        	rentPanel.add(getBtnNewButton_8());
        	rentPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getBtnNewButton_8()}));
        }
        return rentPanel;
    }
    private JPanel getMemberPanel() {
        if (memberPanel == null) {
        	memberPanel = new JPanel();
        	memberPanel.setBackground(new Color(100, 149, 237));
        	memberPanel.setLayout(null);
        	memberPanel.add(getLblNewLabel_6());
        	memberPanel.add(getLblNewLabel_7());
        	memberPanel.add(getLblNewLabel_8());
        	memberPanel.add(getLblNewLabel_9());
        	memberPanel.add(getLblNewLabel_10());
        	memberPanel.add(getTxt이름());
        	memberPanel.add(getTxt주민번호0());
        	memberPanel.add(getTxt전화번호0());
        	memberPanel.add(getTxt메일주소0());
        	memberPanel.add(getTxt주민번호1());
        	memberPanel.add(getTxt전화번호1());
        	memberPanel.add(getTxt메일주소1());
        	memberPanel.add(getTxt회원검색());
        	memberPanel.add(getTxt전화번호2());
        	memberPanel.add(getLabel_2());
        	memberPanel.add(getLblNewLabel_11());
        	memberPanel.add(getLabel_3());
        	memberPanel.add(getLabel_4());
        	memberPanel.add(getCbMember());
        	memberPanel.add(getScrollPane_2());
        	memberPanel.add(getBtn회원삭제());
        	memberPanel.add(getBtn회원수정());
        	memberPanel.add(getBtn회원취소());
        	memberPanel.add(getButton());
        	memberPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getTxt이름(), getTxt주민번호0(), getTxt주민번호1(), getTxt전화번호0(), getTxt전화번호1(), getTxt전화번호2(), getTxt메일주소0(), getTxt메일주소1(), getCbMember(), getTxt회원검색(), getButton(), getBtn회원삭제(), getBtn회원수정(), getBtn회원취소()}));
        }
        return memberPanel;
    }
    private JPanel getBookPanel() {
        if (bookPanel == null) {
        	bookPanel = new JPanel();
        	bookPanel.setBackground(new Color(100, 149, 237));
        	bookPanel.setLayout(null);
        	bookPanel.add(getLabel_1());
        	bookPanel.add(getLblNewLabel());
        	bookPanel.add(getLblNewLabel_1());
        	bookPanel.add(getLblNewLabel_2());
        	bookPanel.add(getLblNewLabel_3());
        	bookPanel.add(getLblNewLabel_4());
        	bookPanel.add(getLblNewLabel_5());
        	bookPanel.add(getTxt책제목());
        	bookPanel.add(getTxt출판사());
        	bookPanel.add(getTxt저자());
        	bookPanel.add(getTxt가격());
        	bookPanel.add(getTxt장르());
        	bookPanel.add(getTxt책검색());
        	bookPanel.add(getTxt책번호());
        	bookPanel.add(getCbBook());
        	bookPanel.add(getBtn대여하기());
        	bookPanel.add(getBtn책수정());
        	bookPanel.add(getBtn책삭제());
        	bookPanel.add(getBtn책취소());
        	bookPanel.add(getScrollPane_1());
        	bookPanel.add(getBtnNewButton_12());
        	bookPanel.add(getTree());
        	bookPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getTxt책제목(), getTxt책번호(), getTxt출판사(), getTxt저자(), getTxt가격(), getTxt장르(), getCbBook(), getTxt책검색(), getBtnNewButton_12(), getBtn대여하기(), getBtn책수정(), getBtn책삭제(), getBtn책취소()}));
        }
        return bookPanel;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("책 제목");
        	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	label_1.setBounds(256, 10, 57, 15);
        }
        return label_1;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("출판사");
        	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel.setBounds(256, 46, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("저자");
        	lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_1.setBounds(256, 89, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("가격");
        	lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_2.setBounds(256, 132, 57, 15);
        }
        return lblNewLabel_2;
    }
    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("장르");
        	lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_3.setBounds(256, 176, 57, 15);
        }
        return lblNewLabel_3;
    }
    private JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("검색");
        	lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_4.setBounds(256, 219, 57, 15);
        }
        return lblNewLabel_4;
    }
    private JLabel getLblNewLabel_5() {
        if (lblNewLabel_5 == null) {
        	lblNewLabel_5 = new JLabel("책 번호");
        	lblNewLabel_5.setBounds(520, 13, 57, 15);
        }
        return lblNewLabel_5;
    }
    private JTextField getTxt책제목() {
        if (txt책제목 == null) {
        	txt책제목 = new JTextField();
        	txt책제목.setBounds(338, 10, 154, 21);
        	txt책제목.setColumns(10);
        }
        return txt책제목;
    }
    private JTextField getTxt출판사() {
        if (txt출판사 == null) {
        	txt출판사 = new JTextField();
        	txt출판사.setBounds(338, 46, 154, 21);
        	txt출판사.setColumns(10);
        }
        return txt출판사;
    }
    private JTextField getTxt저자() {
        if (txt저자 == null) {
        	txt저자 = new JTextField();
        	txt저자.setBounds(338, 89, 154, 21);
        	txt저자.setColumns(10);
        }
        return txt저자;
    }
    private JTextField getTxt가격() {
        if (txt가격 == null) {
        	txt가격 = new JTextField();
        	txt가격.setBounds(338, 132, 116, 21);
        	txt가격.setColumns(10);
        }
        return txt가격;
    }
    private JTextField getTxt장르() {
        if (txt장르 == null) {
        	txt장르 = new JTextField();
        	txt장르.setBounds(338, 176, 116, 21);
        	txt장르.setColumns(10);
        }
        return txt장르;
    }
    private JTextField getTxt책검색() {
        if (txt책검색 == null) {
        	txt책검색 = new JTextField();
        	txt책검색.setBounds(440, 219, 154, 21);
        	txt책검색.setColumns(10);
        }
        return txt책검색;
    }
    private JTextField getTxt책번호() {
        if (txt책번호 == null) {
        	txt책번호 = new JTextField();
        	txt책번호.setBounds(607, 10, 57, 21);
        	txt책번호.setColumns(10);
        }
        return txt책번호;
    }
    private JComboBox getCbBook() {
        if (cbBook == null) {
        	cbBook = new JComboBox();
        	cbBook.setModel(new DefaultComboBoxModel(new String[] {"책 체목", "출판사", "저자", "장르", "가격"}));
        	cbBook.setBounds(341, 219, 87, 21);
        }
        return cbBook;
    }
    private JButton getBtn대여하기() {
        if (btn대여하기 == null) {
        	btn대여하기 = new JButton("대여하기");
        	btn대여하기.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        int row = 0;
        	        for (int i = 0;i < books.size();i++) {
        	            if (bookTable.getValueAt(bookTable.getSelectedRow(), 0).equals(books.get(i).get책번호())) {
        	                row = i;
        	                break;
        	            }
        	        }
        	        if (books.get(row).get대여정보()) {
            	        책대여 frame = new 책대여(도서관리.frame, books.get(row), members, rents);
            	        frame.setVisible(true);
        	        }
        	        else {
        	            JOptionPane.showMessageDialog(null, "대여불가");
        	        }
        	    }
        	});
        	btn대여하기.setBounds(267, 260, 97, 44);
        }
        return btn대여하기;
    }
    private JButton getBtn책수정() {
        if (btn책수정 == null) {
        	btn책수정 = new JButton("수정");
        	btn책수정.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    int row = 0;
                    for (int i = 0;i < books.size();i++) {
                        if (bookTable.getValueAt(bookTable.getSelectedRow(), 0).equals(books.get(i).get책번호())) {
                            row = i;
                            break;
                        }
                    }
                    if (!books.get(row).get대여정보()) {
                        JOptionPane.showMessageDialog(null, "수정불가");
                        return;
                    }
        	        
        	        Integer 책번호 = Integer.valueOf(txt책번호.getText());
                    String 책제목 = txt책제목.getText();
                    String 출판사 = txt출판사.getText();
                    String 장르 = txt장르.getText();
                    String 저자 = txt저자.getText();
                    Integer 가격 = Integer.valueOf(txt가격.getText());
                    Boolean 대여정보 = true;
        	        
                    books.set(row, new 책정보(책번호, 책제목, 출판사, 장르, 저자, 가격, 대여정보));
                    
                    refresh책정보(books, bookTable);
                    
                    JOptionPane.showMessageDialog(null, "수정완료");
        	    }
        	});
        	btn책수정.setBounds(376, 260, 97, 44);
        }
        return btn책수정;
    }
    private JButton getBtn책삭제() {
        if (btn책삭제 == null) {
        	btn책삭제 = new JButton("삭제");
        	btn책삭제.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    int row = 0;
                    for (int i = 0;i < books.size();i++) {
                        if (bookTable.getValueAt(bookTable.getSelectedRow(), 0).equals(books.get(i).get책번호())) {
                            row = i;
                            break;
                        }
                    }
                    if (!books.get(row).get대여정보()) {
                        JOptionPane.showMessageDialog(null, "삭제불가");
                        return;
                    }
                    
                    books.remove(row);
                    
                    refresh책정보(books, bookTable);
                    
                    JOptionPane.showMessageDialog(null, "삭제완료");
        	    }
        	});
        	btn책삭제.setBounds(485, 260, 97, 44);
        }
        return btn책삭제;
    }
    private JButton getBtn책취소() {
        if (btn책취소 == null) {
        	btn책취소 = new JButton("취소");
        	btn책취소.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    refresh책정보(books, bookTable);
        	    }
        	});
        	btn책취소.setBounds(594, 260, 97, 44);
        }
        return btn책취소;
    }
    private JLabel getLblNewLabel_6() {
        if (lblNewLabel_6 == null) {
        	lblNewLabel_6 = new JLabel("이름");
        	lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_6.setBounds(12, 31, 57, 15);
        }
        return lblNewLabel_6;
    }
    private JLabel getLblNewLabel_7() {
        if (lblNewLabel_7 == null) {
        	lblNewLabel_7 = new JLabel("주민번호");
        	lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_7.setBounds(12, 68, 57, 15);
        }
        return lblNewLabel_7;
    }
    private JLabel getLblNewLabel_8() {
        if (lblNewLabel_8 == null) {
        	lblNewLabel_8 = new JLabel("전화번호");
        	lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_8.setBounds(12, 107, 57, 15);
        }
        return lblNewLabel_8;
    }
    private JLabel getLblNewLabel_9() {
        if (lblNewLabel_9 == null) {
        	lblNewLabel_9 = new JLabel("메일주소");
        	lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_9.setBounds(12, 143, 57, 15);
        }
        return lblNewLabel_9;
    }
    private JLabel getLblNewLabel_10() {
        if (lblNewLabel_10 == null) {
        	lblNewLabel_10 = new JLabel("검색");
        	lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
        	lblNewLabel_10.setBounds(12, 178, 57, 15);
        }
        return lblNewLabel_10;
    }
    private JTextField getTxt이름() {
        if (txt이름 == null) {
        	txt이름 = new JTextField();
        	txt이름.setBounds(85, 31, 83, 21);
        	txt이름.setColumns(10);
        }
        return txt이름;
    }
    private JTextField getTxt주민번호0() {
        if (txt주민번호0 == null) {
        	txt주민번호0 = new JTextField();
        	txt주민번호0.setBounds(85, 68, 83, 21);
        	txt주민번호0.setColumns(10);
        }
        return txt주민번호0;
    }
    private JTextField getTxt전화번호0() {
        if (txt전화번호0 == null) {
        	txt전화번호0 = new JTextField();
        	txt전화번호0.setBounds(85, 107, 83, 21);
        	txt전화번호0.setColumns(10);
        }
        return txt전화번호0;
    }
    private JTextField getTxt메일주소0() {
        if (txt메일주소0 == null) {
        	txt메일주소0 = new JTextField();
        	txt메일주소0.setBounds(85, 143, 83, 21);
        	txt메일주소0.setColumns(10);
        }
        return txt메일주소0;
    }
    private JTextField getTxt주민번호1() {
        if (txt주민번호1 == null) {
        	txt주민번호1 = new JTextField();
        	txt주민번호1.setBounds(190, 68, 82, 21);
        	txt주민번호1.setColumns(10);
        }
        return txt주민번호1;
    }
    private JTextField getTxt전화번호1() {
        if (txt전화번호1 == null) {
        	txt전화번호1 = new JTextField();
        	txt전화번호1.setBounds(190, 107, 82, 21);
        	txt전화번호1.setColumns(10);
        }
        return txt전화번호1;
    }
    private JTextField getTxt메일주소1() {
        if (txt메일주소1 == null) {
        	txt메일주소1 = new JTextField();
        	txt메일주소1.setBounds(190, 143, 82, 21);
        	txt메일주소1.setColumns(10);
        }
        return txt메일주소1;
    }
    private JTextField getTxt회원검색() {
        if (txt회원검색 == null) {
        	txt회원검색 = new JTextField();
        	txt회원검색.setBounds(190, 178, 82, 21);
        	txt회원검색.setColumns(10);
        }
        return txt회원검색;
    }
    private JTextField getTxt전화번호2() {
        if (txt전화번호2 == null) {
        	txt전화번호2 = new JTextField();
        	txt전화번호2.setBounds(295, 107, 83, 21);
        	txt전화번호2.setColumns(10);
        }
        return txt전화번호2;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("-");
        	label_2.setHorizontalAlignment(SwingConstants.CENTER);
        	label_2.setBounds(168, 71, 21, 15);
        }
        return label_2;
    }
    private JLabel getLblNewLabel_11() {
        if (lblNewLabel_11 == null) {
        	lblNewLabel_11 = new JLabel("-");
        	lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        	lblNewLabel_11.setBounds(168, 110, 21, 15);
        }
        return lblNewLabel_11;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("@");
        	label_3.setHorizontalAlignment(SwingConstants.CENTER);
        	label_3.setBounds(168, 146, 21, 15);
        }
        return label_3;
    }
    private JLabel getLabel_4() {
        if (label_4 == null) {
        	label_4 = new JLabel("-");
        	label_4.setHorizontalAlignment(SwingConstants.CENTER);
        	label_4.setBounds(273, 110, 21, 15);
        }
        return label_4;
    }
    private JComboBox getCbMember() {
        if (cbMember == null) {
        	cbMember = new JComboBox();
        	cbMember.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "주민번호", "전화번호", "메일주소"}));
        	cbMember.setBounds(85, 175, 83, 21);
        }
        return cbMember;
    }
    private JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
        	scrollPane_1 = new JScrollPane();
        	scrollPane_1.setBounds(22, 322, 682, 208);
        	scrollPane_1.setViewportView(getTable_1_2());
        }
        return scrollPane_1;
    }
    private JTable getTable_1_2() {
        if (bookTable == null) {
        	bookTable = new JTable();
        	bookTable.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
                    // 선택한 row를 리턴
                    bookRow = bookTable.getSelectedRow();
                    
                    String 책번호 = bookTable.getValueAt(bookRow, 0).toString();
                    String 책제목 = bookTable.getValueAt(bookRow, 1).toString();
                    String 출판사 = bookTable.getValueAt(bookRow, 2).toString();
                    String 장르 = bookTable.getValueAt(bookRow, 3).toString();
                    String 저자 = bookTable.getValueAt(bookRow, 4).toString();
                    String 가격 = bookTable.getValueAt(bookRow, 5).toString();
                    
                    txt책번호.setText(책번호);
                    txt책제목.setText(책제목);
                    txt출판사.setText(출판사);
                    txt저자.setText(저자);
                    txt가격.setText(가격);
                    txt장르.setText(장르);
        	    }
        	});
        	bookTable.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "No", "\uC81C\uBAA9", "\uCD9C\uD310\uC0AC", "\uC7A5\uB974", "\uC800\uC790", "\uAC00\uACA9", "\uB300\uC5EC\uC815\uBCF4"
        	    }
        	) {
        	    Class[] columnTypes = new Class[] {
        	        String.class, String.class, String.class, String.class, String.class, String.class, String.class
        	    };
        	    public Class getColumnClass(int columnIndex) {
        	        return columnTypes[columnIndex];
        	    }
        	});
        }
        return bookTable;
    }
    private JScrollPane getScrollPane_2() {
        if (scrollPane_2 == null) {
        	scrollPane_2 = new JScrollPane();
        	scrollPane_2.setBounds(12, 274, 538, 268);
        	scrollPane_2.setViewportView(getMemberTable());
        }
        return scrollPane_2;
    }
    private JTable getMemberTable() {
        if (memberTable == null) {
        	memberTable = new JTable();
        	memberTable.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
                    // 선택한 row를 리턴
                    memberRow = memberTable.getSelectedRow();
                    
                    String 이름 = memberTable.getValueAt(memberRow, 1).toString();
                    String[] 주민번호 = new String[2];
                    주민번호 = memberTable.getValueAt(memberRow, 2).toString().split("-");
                    String[] 전화번호 = new String[3];
                    전화번호 = memberTable.getValueAt(memberRow, 3).toString().split("-");
                    String[] 메일주소 = new String[2];
                    메일주소 = memberTable.getValueAt(memberRow, 4).toString().split("@");
                    
                    txt이름.setText(이름);
                    txt주민번호0.setText(주민번호[0]);
                    txt주민번호1.setText(주민번호[1]);
                    txt전화번호0.setText(전화번호[0]);
                    txt전화번호1.setText(전화번호[1]);
                    txt전화번호2.setText(전화번호[2]);
                    txt메일주소0.setText(메일주소[0]);
                    txt메일주소1.setText(메일주소[1]);
        	    }
        	});
        	memberTable.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "\uD68C\uC6D0\uBC88\uD638", "\uC774\uB984", "\uC8FC\uBBFC\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C"
        	    }
        	) {
        	    Class[] columnTypes = new Class[] {
        	        String.class, String.class, String.class, String.class, String.class
        	    };
        	    public Class getColumnClass(int columnIndex) {
        	        return columnTypes[columnIndex];
        	    }
        	});
        }
        return memberTable;
    }
    private JScrollPane getScrollPane_3() {
        if (scrollPane_3 == null) {
        	scrollPane_3 = new JScrollPane();
        	scrollPane_3.setBounds(12, 131, 705, 393);
        	scrollPane_3.setViewportView(getRentTable());
        }
        return scrollPane_3;
    }
    private JTable getRentTable() {
        if (rentTable == null) {
        	rentTable = new JTable();
        	rentTable.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "No", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uBBFC\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C", "\uCC45 \uC81C\uBAA9", "\uCD9C\uD310\uC0AC", "\uC7A5\uB974", "\uC800\uC790", "\uCC45 \uBC88\uD638", "\uB300\uC5EC\uB0A0\uC9DC"
        	    }
        	) {
        	    Class[] columnTypes = new Class[] {
        	        String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
        	    };
        	    public Class getColumnClass(int columnIndex) {
        	        return columnTypes[columnIndex];
        	    }
        	});
        }
        return rentTable;
    }
    private JButton getBtnNewButton_8() {
        if (btnNewButton_8 == null) {
        	btnNewButton_8 = new JButton("반납완료");
        	btnNewButton_8.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        
        	        int row = 0;
        	        for (int i = 0; i < books.size();i++) {
        	            if (books.get(i).get책번호().equals(rents.get(rentRow).get책번호())) {
        	                row = i;
        	                break;
        	            }
        	        }
        	        books.get(row).set대여정보(true);
        	        rents.remove(rentRow);
        	        refresh책정보(books, bookTable);
        	        refresh대여목록(rents, rentTable);
        	        refresh대출상황(rents, frontTable);
        	        JOptionPane.showMessageDialog(null, "반납완료");
        	    }
        	});
        	btnNewButton_8.setBounds(537, 58, 180, 55);
        }
        return btnNewButton_8;
    }
    private JPanel getPanel_1() {
        if (panel_1 == null) {
        	panel_1 = new JPanel();
        	panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        	panel_1.setBounds(12, 94, 286, 581);
        	panel_1.setLayout(null);
        	panel_1.add(getLblNewLabel_12());
        	panel_1.add(getScrollPane());
        }
        return panel_1;
    }
    private JLabel getLblNewLabel_12() {
        if (lblNewLabel_12 == null) {
        	lblNewLabel_12 = new JLabel("대출상황");
        	lblNewLabel_12.setBounds(113, 10, 57, 15);
        }
        return lblNewLabel_12;
    }
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(0, 28, 286, 553);
        	scrollPane.setViewportView(getFrontTable());
        }
        return scrollPane;
    }
    private JTable getFrontTable() {
        if (frontTable == null) {
        	frontTable = new JTable();
        	frontTable.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "\uC774\uB984", "\uCC45 \uC81C\uBAA9", "\uB300\uC5EC\uB0A0\uC9DC"
        	    }
        	) {
        	    Class[] columnTypes = new Class[] {
        	        String.class, String.class, String.class
        	    };
        	    public Class getColumnClass(int columnIndex) {
        	        return columnTypes[columnIndex];
        	    }
        	});
        }
        return frontTable;
    }
    private JButton getBtn회원삭제() {
        if (btn회원삭제 == null) {
        	btn회원삭제 = new JButton("회원삭제");
        	btn회원삭제.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    int row = 0;
                    for (int i = 0;i < members.size();i++) {
                        if (memberTable.getValueAt(memberTable.getSelectedRow(), 0).equals(members.get(i).get회원번호())) {
                            row = i;
                            break;
                        }
                    }
                    boolean del = false;
                    for (int i = 0;i < rents.size();i++) {
                        if (members.get(row).get회원번호().equals(rents.get(i).get회원번호())) {
                            del = true;
                        }
                    }
                    if (del) {
                        JOptionPane.showMessageDialog(null, "삭제불가");
                        return;
                    }
                    members.remove(row);
                    
                    refresh회원정보(members, memberTable);
                    JOptionPane.showMessageDialog(null, "삭제완료");
        	    }
        	});
        	btn회원삭제.setBounds(22, 219, 97, 45);
        }
        return btn회원삭제;
    }
    private JButton getBtn회원수정() {
        if (btn회원수정 == null) {
        	btn회원수정 = new JButton("회원수정");
        	btn회원수정.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    int row = 0;
                    for (int i = 0;i < books.size();i++) {
                        if (bookTable.getValueAt(bookTable.getSelectedRow(), 0).equals(books.get(i).get책번호())) {
                            row = i;
                            break;
                        }
                    }
                    
                    Integer 회원번호 = members.get(row).get회원번호();
                    String 이름 = txt이름.getText();
                    String 주민번호 = txt주민번호0.getText() + "-" + txt주민번호1.getText();
                    String 전화번호 = txt전화번호0.getText() + "-" + txt전화번호1.getText() + "-" + txt전화번호2.getText();
                    String 메일주소 = txt메일주소0.getText() + "@" + txt메일주소1.getText();
                    
                    members.set(row, new 회원정보(회원번호, 이름, 주민번호, 전화번호, 메일주소));
                    
                    refresh회원정보(members, memberTable);
                    JOptionPane.showMessageDialog(null, "수정완료");
        	    }
        	});
        	btn회원수정.setBounds(152, 219, 97, 45);
        }
        return btn회원수정;
    }
    private JButton getBtn회원취소() {
        if (btn회원취소 == null) {
        	btn회원취소 = new JButton("취소");
        	btn회원취소.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    refresh회원정보(members, memberTable);
        	    }
        	});
        	btn회원취소.setBounds(281, 219, 97, 45);
        }
        return btn회원취소;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("검색");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    Integer index = cbMember.getSelectedIndex();
                    String 회원검색 = txt회원검색.getText();
                    
                    회원검색(members, memberTable, index, 회원검색);
        	        
        	    }
        	});
        	button.setBounds(284, 177, 64, 23);
        }
        return button;
    }
    private JButton getBtnNewButton_12() {
        if (btnNewButton_12 == null) {
        	btnNewButton_12 = new JButton("검색");
        	btnNewButton_12.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        Integer index = cbBook.getSelectedIndex();
        	        String 책검색 = txt책검색.getText();
        	        
        	        책검색(books, bookTable, index, 책검색);
        	    }
        	});
        	btnNewButton_12.setBounds(607, 219, 76, 23);
        }
        return btnNewButton_12;
    }
    
    public static void init책정보() {
        books = new ArrayList<책정보>();
        books.add(new 책정보(1, "호랑이와 토끼"   , "한국미디어", "소설", "김호랑"       , 5000 , true));
        books.add(new 책정보(2, "Starcraft"       , "Brood War" , "해외", "Johnson"      , 15000, true));
        books.add(new 책정보(3, "독한사전"        , "한국미디어", "교육", "김독일 외 3명", 35000, true));
        books.add(new 책정보(4, "중학교3학년 수학", "교사사"    , "교육", "교과서팀일동" , 15000, true));
        books.add(new 책정보(5, "JAVA의 정석"     , "더조은"    , "기타", "더조은"       , 15000, true));
        책 = books.size() + 1;
    }
    public static void init회원정보() {
        members = new ArrayList<회원정보>(); 
        members.add(new 회원정보(0, "김철수", "******-*******", "010-****-****", "asdasd@naver.com"));
        members.add(new 회원정보(1, "박상아", "******-*******", "010-****-****", "qweqwe@naver.com"));
        members.add(new 회원정보(2, "이상근", "******-*******", "010-****-****", "cxvwer@hanmail.net"));
        members.add(new 회원정보(3, "존슨"  , "******-*******", "010-****-****", "gf232sdf@naver.com"));
        members.add(new 회원정보(4, "이용갑", "******-*******", "010-****-****", "aa34@naver.com"));
        회원 = members.size();
    }
    public static void refresh책정보(List<책정보> list, JTable table) {
        Object[] tempObject = new Object[7];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (책정보 obj : list) {
            tempObject[0] = obj.get책번호();
            tempObject[1] = obj.get제목();
            tempObject[2] = obj.get출판사();
            tempObject[3] = obj.get장르();
            tempObject[4] = obj.get저자();
            tempObject[5] = obj.get가격();
            if (obj.get대여정보()) {
                tempObject[6] = "대여가능";
            }
            else {
                tempObject[6] = "대여불가";
            }
            model.addRow(tempObject);
        }
        // JTable 첫번쨰 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
            table.setModel(model);
        }
    }
    public static void refresh회원정보(List<회원정보> list, JTable table) {
        Object[] tempObject = new Object[5];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (회원정보 obj : list) {
            tempObject[0] = obj.get회원번호();
            tempObject[1] = obj.get이름();
            tempObject[2] = obj.get주민번호();
            tempObject[3] = obj.get전화번호();
            tempObject[4] = obj.get메일주소();
            model.addRow(tempObject);
        }
        // JTable 첫번쨰 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
            table.setModel(model);
        }
    }
    public static void refresh대여목록(List<대여목록> list, JTable table) {
        Object[] tempObject = new Object[11];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (대여목록 obj : list) {
            tempObject[0] = obj.get대여번호();
            tempObject[1] = obj.get이름();
            tempObject[2] = obj.get전화번호();
            tempObject[3] = obj.get주민번호();
            tempObject[4] = obj.get메일주소();
            tempObject[5] = obj.get책제목();
            tempObject[6] = obj.get출판사();
            tempObject[7] = obj.get장르();
            tempObject[8] = obj.get저자();
            tempObject[9] = obj.get책번호();
            tempObject[10] = obj.get대여날짜();
            
            model.addRow(tempObject);
        }
        // JTable 첫번쨰 로우에 focus 주기
//        if (model.getRowCount() > 0) {
//            table.setRowSelectionInterval(0, 0);
//            table.setModel(model);
//        }
    }
    public static void refresh대출상황(List<대여목록> list, JTable table) {
        Object[] tempObject = new Object[3];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (대여목록 obj : list) {
            tempObject[0] = obj.get이름();
            tempObject[1] = obj.get책제목();
            tempObject[2] = obj.get대여날짜();
            
            model.addRow(tempObject);
        }
        // JTable 첫번쨰 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
            table.setModel(model);
        }
    }
    public static void 책검색(List<책정보> list, JTable table, Integer cbSelection, String 검색) {
        Object[] tempObject = new Object[7];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (책정보 obj : list) {
            if (cbSelection == 0 && obj.get제목().equals(검색)) {
                tempObject[0] = obj.get책번호();
                tempObject[1] = obj.get제목();
                tempObject[2] = obj.get출판사();
                tempObject[3] = obj.get장르();
                tempObject[4] = obj.get저자();
                tempObject[5] = obj.get가격();
                if (obj.get대여정보()) {
                    tempObject[6] = "대여가능";
                }
                else {
                    tempObject[6] = "대여불가";
                }
                model.addRow(tempObject);
            }
            else if (cbSelection == 1 && obj.get출판사().equals(검색)) {
                tempObject[0] = obj.get책번호();
                tempObject[1] = obj.get제목();
                tempObject[2] = obj.get출판사();
                tempObject[3] = obj.get장르();
                tempObject[4] = obj.get저자();
                tempObject[5] = obj.get가격();
                if (obj.get대여정보()) {
                    tempObject[6] = "대여가능";
                }
                else {
                    tempObject[6] = "대여불가";
                }
                model.addRow(tempObject);
            }
            else if (cbSelection == 2 && obj.get저자().equals(검색)) {
                tempObject[0] = obj.get책번호();
                tempObject[1] = obj.get제목();
                tempObject[2] = obj.get출판사();
                tempObject[3] = obj.get장르();
                tempObject[4] = obj.get저자();
                tempObject[5] = obj.get가격();
                if (obj.get대여정보()) {
                    tempObject[6] = "대여가능";
                }
                else {
                    tempObject[6] = "대여불가";
                }
                model.addRow(tempObject);
            }
            else if (cbSelection == 3 && obj.get장르().equals(검색)) {
                tempObject[0] = obj.get책번호();
                tempObject[1] = obj.get제목();
                tempObject[2] = obj.get출판사();
                tempObject[3] = obj.get장르();
                tempObject[4] = obj.get저자();
                tempObject[5] = obj.get가격();
                if (obj.get대여정보()) {
                    tempObject[6] = "대여가능";
                }
                else {
                    tempObject[6] = "대여불가";
                }
                model.addRow(tempObject);
            }
            else if (cbSelection == 4 && obj.get가격().equals(Integer.valueOf(검색))) {
                tempObject[0] = obj.get책번호();
                tempObject[1] = obj.get제목();
                tempObject[2] = obj.get출판사();
                tempObject[3] = obj.get장르();
                tempObject[4] = obj.get저자();
                tempObject[5] = obj.get가격();
                if (obj.get대여정보()) {
                    tempObject[6] = "대여가능";
                }
                else {
                    tempObject[6] = "대여불가";
                }
                model.addRow(tempObject);
            }
        }
        // JTable 첫번쨰 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
            table.setModel(model);
        }
    }
    public static void 회원검색(List<회원정보> list, JTable table, Integer cbSelection, String 검색) {
        Object[] tempObject = new Object[5];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (회원정보 obj : list) {
            if (cbSelection == 0 && obj.get회원번호().equals(Integer.valueOf(검색))) {
                tempObject[0] = obj.get회원번호();
                tempObject[1] = obj.get이름();
                tempObject[2] = obj.get주민번호();
                tempObject[3] = obj.get전화번호();
                tempObject[4] = obj.get메일주소();
                model.addRow(tempObject);
            }
            else if (cbSelection == 1 && obj.get이름().equals(검색)) {
                tempObject[0] = obj.get회원번호();
                tempObject[1] = obj.get이름();
                tempObject[2] = obj.get주민번호();
                tempObject[3] = obj.get전화번호();
                tempObject[4] = obj.get메일주소();
                model.addRow(tempObject);
            }
            else if (cbSelection == 2 && obj.get주민번호().equals(검색)) {
                tempObject[0] = obj.get회원번호();
                tempObject[1] = obj.get이름();
                tempObject[2] = obj.get주민번호();
                tempObject[3] = obj.get전화번호();
                tempObject[4] = obj.get메일주소();
                model.addRow(tempObject);
            }
            else if (cbSelection == 3 && obj.get전화번호().equals(검색)) {
                tempObject[0] = obj.get회원번호();
                tempObject[1] = obj.get이름();
                tempObject[2] = obj.get주민번호();
                tempObject[3] = obj.get전화번호();
                tempObject[4] = obj.get메일주소();
                model.addRow(tempObject);
            }
            else if (cbSelection == 4 && obj.get메일주소().equals(검색)) {
                tempObject[0] = obj.get회원번호();
                tempObject[1] = obj.get이름();
                tempObject[2] = obj.get주민번호();
                tempObject[3] = obj.get전화번호();
                tempObject[4] = obj.get메일주소();
                model.addRow(tempObject);
            }
        }
        // JTable 첫번쨰 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
            table.setModel(model);
        }
    }
    private JTree getTree() {
        if (tree == null) {
        	tree = new JTree();
        	tree.setModel(new DefaultTreeModel(
        	    new DefaultMutableTreeNode("장르") {
        	        {
        	            add(new DefaultMutableTreeNode("소설"));
        	            add(new DefaultMutableTreeNode("교육"));
        	            add(new DefaultMutableTreeNode("문학"));
        	            add(new DefaultMutableTreeNode("해외"));
        	            add(new DefaultMutableTreeNode("기타"));
        	        }
        	    }
        	));
        	tree.setBounds(22, 10, 222, 294);
        }
        return tree;
    }
}

