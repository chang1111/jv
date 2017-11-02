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
import java.awt.Component;
import java.util.List;
import java.util.ArrayList;

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
    private JTextField 책제목;
    private JTextField 출판사;
    private JTextField 저자;
    private JTextField 가격;
    private JTextField 상품;
    private JTextField 검색;
    private JTextField 책번호;
    private JComboBox comboBox;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JTextField 이름;
    private JTextField 주민번호1;
    private JTextField 전화번호1;
    private JTextField 메일주소1;
    private JTextField 주민번호2;
    private JTextField 전화번호2;
    private JTextField 메일주소2;
    private JTextField 검색1;
    private JTextField 전화번호3;
    private JLabel label_2;
    private JLabel lblNewLabel_11;
    private JLabel label_3;
    private JLabel label_4;
    private JComboBox comboBox_1;
    private JScrollPane scrollPane_1;
    private JTable table_1;
    private JScrollPane scrollPane_2;
    private JTable table_2;
    private JScrollPane scrollPane_3;
    private JTable table_3;
    private JButton btnNewButton_8;
    private JPanel panel_1;
    private JLabel lblNewLabel_12;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnNewButton_9;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;
    private JButton button;
    private JButton btnNewButton_12;
    private static List<책정보> books = null;
    private static List<회원정보> members = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    도서관리 frame = new 도서관리();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                init회원정보();
                init책정보();
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
        	                    회원등록 frame = new 회원등록();
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
        	                    책등록 frame = new 책등록();
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
        	memberPanel.add(get이름());
        	memberPanel.add(get주민번호1());
        	memberPanel.add(get전화번호1());
        	memberPanel.add(get메일주소1());
        	memberPanel.add(get주민번호2());
        	memberPanel.add(get전화번호2());
        	memberPanel.add(get메일주소2());
        	memberPanel.add(get검색1());
        	memberPanel.add(get전화번호3());
        	memberPanel.add(getLabel_2());
        	memberPanel.add(getLblNewLabel_11());
        	memberPanel.add(getLabel_3());
        	memberPanel.add(getLabel_4());
        	memberPanel.add(getComboBox_1());
        	memberPanel.add(getScrollPane_2());
        	memberPanel.add(getBtnNewButton_9());
        	memberPanel.add(getBtnNewButton_10());
        	memberPanel.add(getBtnNewButton_11());
        	memberPanel.add(getButton());
        	memberPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{get이름(), get주민번호1(), get주민번호2(), get전화번호1(), get전화번호2(), get전화번호3(), get메일주소1(), get메일주소2(), getComboBox_1(), get검색1(), getButton(), getBtnNewButton_9(), getBtnNewButton_10(), getBtnNewButton_11()}));
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
        	bookPanel.add(get책제목());
        	bookPanel.add(get출판사());
        	bookPanel.add(get저자());
        	bookPanel.add(get가격());
        	bookPanel.add(get상품());
        	bookPanel.add(get검색());
        	bookPanel.add(get책번호());
        	bookPanel.add(getComboBox());
        	bookPanel.add(getBtnNewButton_4());
        	bookPanel.add(getBtnNewButton_5());
        	bookPanel.add(getBtnNewButton_6());
        	bookPanel.add(getBtnNewButton_7());
        	bookPanel.add(getScrollPane_1());
        	bookPanel.add(getBtnNewButton_12());
        	bookPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{get책제목(), get책번호(), get출판사(), get저자(), get가격(), get상품(), getComboBox(), get검색(), getBtnNewButton_12(), getBtnNewButton_4(), getBtnNewButton_5(), getBtnNewButton_6(), getBtnNewButton_7()}));
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
        	lblNewLabel_3 = new JLabel("상품");
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
    private JTextField get책제목() {
        if (책제목 == null) {
        	책제목 = new JTextField();
        	책제목.setBounds(338, 10, 154, 21);
        	책제목.setColumns(10);
        }
        return 책제목;
    }
    private JTextField get출판사() {
        if (출판사 == null) {
        	출판사 = new JTextField();
        	출판사.setBounds(338, 46, 154, 21);
        	출판사.setColumns(10);
        }
        return 출판사;
    }
    private JTextField get저자() {
        if (저자 == null) {
        	저자 = new JTextField();
        	저자.setBounds(338, 89, 154, 21);
        	저자.setColumns(10);
        }
        return 저자;
    }
    private JTextField get가격() {
        if (가격 == null) {
        	가격 = new JTextField();
        	가격.setBounds(338, 132, 116, 21);
        	가격.setColumns(10);
        }
        return 가격;
    }
    private JTextField get상품() {
        if (상품 == null) {
        	상품 = new JTextField();
        	상품.setBounds(338, 176, 116, 21);
        	상품.setColumns(10);
        }
        return 상품;
    }
    private JTextField get검색() {
        if (검색 == null) {
        	검색 = new JTextField();
        	검색.setBounds(440, 219, 154, 21);
        	검색.setColumns(10);
        }
        return 검색;
    }
    private JTextField get책번호() {
        if (책번호 == null) {
        	책번호 = new JTextField();
        	책번호.setBounds(607, 10, 57, 21);
        	책번호.setColumns(10);
        }
        return 책번호;
    }
    private JComboBox getComboBox() {
        if (comboBox == null) {
        	comboBox = new JComboBox();
        	comboBox.setModel(new DefaultComboBoxModel(new String[] {"책 체목", "출판사", "저자", "가격", "상품"}));
        	comboBox.setBounds(341, 219, 87, 21);
        }
        return comboBox;
    }
    private JButton getBtnNewButton_4() {
        if (btnNewButton_4 == null) {
        	btnNewButton_4 = new JButton("대여하기");
        	btnNewButton_4.setBounds(267, 260, 97, 44);
        }
        return btnNewButton_4;
    }
    private JButton getBtnNewButton_5() {
        if (btnNewButton_5 == null) {
        	btnNewButton_5 = new JButton("수정");
        	btnNewButton_5.setBounds(376, 260, 97, 44);
        }
        return btnNewButton_5;
    }
    private JButton getBtnNewButton_6() {
        if (btnNewButton_6 == null) {
        	btnNewButton_6 = new JButton("삭제");
        	btnNewButton_6.setBounds(485, 260, 97, 44);
        }
        return btnNewButton_6;
    }
    private JButton getBtnNewButton_7() {
        if (btnNewButton_7 == null) {
        	btnNewButton_7 = new JButton("취소");
        	btnNewButton_7.setBounds(594, 260, 97, 44);
        }
        return btnNewButton_7;
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
    private JTextField get이름() {
        if (이름 == null) {
        	이름 = new JTextField();
        	이름.setBounds(85, 31, 83, 21);
        	이름.setColumns(10);
        }
        return 이름;
    }
    private JTextField get주민번호1() {
        if (주민번호1 == null) {
        	주민번호1 = new JTextField();
        	주민번호1.setBounds(85, 68, 83, 21);
        	주민번호1.setColumns(10);
        }
        return 주민번호1;
    }
    private JTextField get전화번호1() {
        if (전화번호1 == null) {
        	전화번호1 = new JTextField();
        	전화번호1.setBounds(85, 107, 83, 21);
        	전화번호1.setColumns(10);
        }
        return 전화번호1;
    }
    private JTextField get메일주소1() {
        if (메일주소1 == null) {
        	메일주소1 = new JTextField();
        	메일주소1.setBounds(85, 143, 83, 21);
        	메일주소1.setColumns(10);
        }
        return 메일주소1;
    }
    private JTextField get주민번호2() {
        if (주민번호2 == null) {
        	주민번호2 = new JTextField();
        	주민번호2.setBounds(190, 68, 82, 21);
        	주민번호2.setColumns(10);
        }
        return 주민번호2;
    }
    private JTextField get전화번호2() {
        if (전화번호2 == null) {
        	전화번호2 = new JTextField();
        	전화번호2.setBounds(190, 107, 82, 21);
        	전화번호2.setColumns(10);
        }
        return 전화번호2;
    }
    private JTextField get메일주소2() {
        if (메일주소2 == null) {
        	메일주소2 = new JTextField();
        	메일주소2.setBounds(190, 143, 82, 21);
        	메일주소2.setColumns(10);
        }
        return 메일주소2;
    }
    private JTextField get검색1() {
        if (검색1 == null) {
        	검색1 = new JTextField();
        	검색1.setBounds(190, 178, 82, 21);
        	검색1.setColumns(10);
        }
        return 검색1;
    }
    private JTextField get전화번호3() {
        if (전화번호3 == null) {
        	전화번호3 = new JTextField();
        	전화번호3.setBounds(295, 107, 83, 21);
        	전화번호3.setColumns(10);
        }
        return 전화번호3;
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
    private JComboBox getComboBox_1() {
        if (comboBox_1 == null) {
        	comboBox_1 = new JComboBox();
        	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "주민번호", "전화번호", "메일주소"}));
        	comboBox_1.setBounds(85, 175, 83, 21);
        }
        return comboBox_1;
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
        if (table_1 == null) {
        	table_1 = new JTable();
        	table_1.setModel(new DefaultTableModel(
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
        return table_1;
    }
    private JScrollPane getScrollPane_2() {
        if (scrollPane_2 == null) {
        	scrollPane_2 = new JScrollPane();
        	scrollPane_2.setBounds(12, 274, 538, 268);
        	scrollPane_2.setViewportView(getTable_2());
        }
        return scrollPane_2;
    }
    private JTable getTable_2() {
        if (table_2 == null) {
        	table_2 = new JTable();
        	table_2.setModel(new DefaultTableModel(
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
        return table_2;
    }
    private JScrollPane getScrollPane_3() {
        if (scrollPane_3 == null) {
        	scrollPane_3 = new JScrollPane();
        	scrollPane_3.setBounds(12, 131, 705, 393);
        	scrollPane_3.setViewportView(getTable_3());
        }
        return scrollPane_3;
    }
    private JTable getTable_3() {
        if (table_3 == null) {
        	table_3 = new JTable();
        	table_3.setModel(new DefaultTableModel(
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
        return table_3;
    }
    private JButton getBtnNewButton_8() {
        if (btnNewButton_8 == null) {
        	btnNewButton_8 = new JButton("반납완료");
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
        	scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    private JTable getTable() {
        if (table == null) {
        	table = new JTable();
        	table.setModel(new DefaultTableModel(
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
        return table;
    }
    private JButton getBtnNewButton_9() {
        if (btnNewButton_9 == null) {
        	btnNewButton_9 = new JButton("회원삭제");
        	btnNewButton_9.setBounds(22, 219, 97, 45);
        }
        return btnNewButton_9;
    }
    private JButton getBtnNewButton_10() {
        if (btnNewButton_10 == null) {
        	btnNewButton_10 = new JButton("회원수정");
        	btnNewButton_10.setBounds(152, 219, 97, 45);
        }
        return btnNewButton_10;
    }
    private JButton getBtnNewButton_11() {
        if (btnNewButton_11 == null) {
        	btnNewButton_11 = new JButton("취소");
        	btnNewButton_11.setBounds(281, 219, 97, 45);
        }
        return btnNewButton_11;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("검색");
        	button.setBounds(284, 177, 64, 23);
        }
        return button;
    }
    private JButton getBtnNewButton_12() {
        if (btnNewButton_12 == null) {
        	btnNewButton_12 = new JButton("검색");
        	btnNewButton_12.setBounds(607, 219, 76, 23);
        }
        return btnNewButton_12;
    }
    
    public static void init회원정보() {
        members = new ArrayList<회원정보>(); 
        members.add(new 회원정보(0, "김철수", "******-*******", "010-****-****", "asdasd@naver.com"));
        members.add(new 회원정보(1, "박상아", "******-*******", "010-****-****", "qweqwe@naver.com"));
        members.add(new 회원정보(2, "이상근", "******-*******", "010-****-****", "cxvwer@hanmail.net"));
        members.add(new 회원정보(3, "존슨"  , "******-*******", "010-****-****", "gf232sdf@naver.com"));
        members.add(new 회원정보(4, "이용갑", "******-*******", "010-****-****", "aa34@naver.com"));
    }
    
    public static void init책정보() {
        books = new ArrayList<책정보>();
        books.add(new 책정보(1, "호랑이와 토끼"   , "한국미디어", "소설", "김호랑"       , 5000 , true));
        books.add(new 책정보(2, "Starcraft"       , "Brood War" , "해외", "Johnson"      , 15000, true));
        books.add(new 책정보(3, "독한사전"        , "한국미디어", "교육", "김독일 외 3명", 35000, true));
        books.add(new 책정보(4, "중학교3학년 수학", "교사사"    , "교육", "교과서팀일동" , 15000, true));
        books.add(new 책정보(5, "플레이보이 2"    , "플레이보이", "기타", "플레이보이"   , 15000, true));
    }
}
