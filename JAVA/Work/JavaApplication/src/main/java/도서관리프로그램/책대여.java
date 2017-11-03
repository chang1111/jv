package 도서관리프로그램;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class 책대여 extends JFrame {
    
    private JPanel contentPane;
    private 도서관리 parent = null;
    private List<회원정보> members = null;
    private 책정보 book = null;
    private List<대여목록> rents = null;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField txt책제목;
    private JTextField txt출판사;
    private JTextField txt저자;
    private JTextField txt검색;
    private JButton btn취소;
    private JButton btn대여;
    private JButton btn검색;
    private JScrollPane scrollPane;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    책대여 frame = new 책대여();
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
    public 책대여() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 372, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLblNewLabel_2());
        contentPane.add(getLblNewLabel_3());
        contentPane.add(getTxt책제목());
        contentPane.add(getTxt출판사());
        contentPane.add(getTxt저자());
        contentPane.add(getTxt검색());
        contentPane.add(getBtn취소());
        contentPane.add(getBtn대여());
        contentPane.add(getBtn검색());
        contentPane.add(getScrollPane());
    }
    public 책대여(도서관리 parent, 책정보 book, List<회원정보> members, List<대여목록> rents) {
        this();
        this.parent = parent;
        this.book = book;
        this.members = members;
        this.rents = rents;
        txt책제목.setText(book.get제목());
        txt출판사.setText(book.get출판사());
        txt저자.setText(book.get저자());
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("책 제목");
        	lblNewLabel.setBounds(12, 41, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
        	lblNewLabel_1 = new JLabel("출판사");
        	lblNewLabel_1.setBounds(12, 80, 57, 15);
        }
        return lblNewLabel_1;
    }
    private JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
        	lblNewLabel_2 = new JLabel("저자");
        	lblNewLabel_2.setBounds(12, 118, 57, 15);
        }
        return lblNewLabel_2;
    }
    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("회원 번호 검색");
        	lblNewLabel_3.setBounds(12, 157, 88, 15);
        }
        return lblNewLabel_3;
    }
    private JTextField getTxt책제목() {
        if (txt책제목 == null) {
        	txt책제목 = new JTextField();
        	txt책제목.setBounds(81, 38, 116, 21);
        	txt책제목.setColumns(10);
        }
        return txt책제목;
    }
    private JTextField getTxt출판사() {
        if (txt출판사 == null) {
        	txt출판사 = new JTextField();
        	txt출판사.setBounds(81, 77, 116, 21);
        	txt출판사.setColumns(10);
        }
        return txt출판사;
    }
    private JTextField getTxt저자() {
        if (txt저자 == null) {
        	txt저자 = new JTextField();
        	txt저자.setBounds(81, 115, 116, 21);
        	txt저자.setColumns(10);
        }
        return txt저자;
    }
    private JTextField getTxt검색() {
        if (txt검색 == null) {
        	txt검색 = new JTextField();
        	txt검색.setBounds(112, 154, 42, 21);
        	txt검색.setColumns(10);
        }
        return txt검색;
    }
    private JButton getBtn취소() {
        if (btn취소 == null) {
        	btn취소 = new JButton("취소");
        	btn취소.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	btn취소.setBounds(238, 89, 97, 42);
        }
        return btn취소;
    }
    private JButton getBtn대여() {
        if (btn대여 == null) {
        	btn대여 = new JButton("대여");
        	btn대여.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        Integer 대여번호 = 도서관리.대여++;
        	        String 이름 = (String) table.getValueAt(table.getSelectedRow(), 1);
        	        String 전화번호 = (String) table.getValueAt(table.getSelectedRow(), 3);
        	        String 주민번호 = (String) table.getValueAt(table.getSelectedRow(), 2);
        	        String 메일주소 = (String) table.getValueAt(table.getSelectedRow(), 4);
        	        String 책제목 = txt책제목.getText();
        	        String 출판사 = txt출판사.getText();
        	        String 장르 = book.get장르();
        	        String 저자 = txt저자.getText();
        	        Integer 책번호 = book.get책번호();
        	        Date date = new Date();
        	        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");
        	        String 대여날짜 = tf.format(date);
        	        
        	        book.set대여정보(false);
        	        
        	        rents.add(new 대여목록(대여번호, 이름, 전화번호, 주민번호, 메일주소, 책제목, 출판사, 장르, 저자, 책번호, 대여날짜));
        	        도서관리.refresh책정보(도서관리.books, 도서관리.bookTable);
        	        도서관리.refresh대여목록(rents, 도서관리.rentTable);
        	        
        	        JOptionPane.showMessageDialog(null, "대여완료");
        	        
        	        dispose();

        	    }
        	});
        	btn대여.setBounds(238, 37, 97, 42);
        }
        return btn대여;
    }

    private JButton getBtn검색() {
        if (btn검색 == null) {
        	btn검색 = new JButton("검색");
        	btn검색.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        Integer 검색 = Integer.valueOf(txt검색.getText());
        	        회원검색(members, table, 검색);
        	    }
        	});
        	btn검색.setBounds(166, 153, 67, 23);
        }
        return btn검색;
    }
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 185, 323, 195);
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
        	        "No", "\uC774\uB984", "\uC8FC\uBBFC\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C"
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
        return table;
    }
    private void 회원검색(List<회원정보> list, JTable table, Integer 검색) {
        Object[] tempObject = new Object[5];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (회원정보 obj : list) {
            if (obj.get회원번호().equals(검색)) {
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
}