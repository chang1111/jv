package java31.st2table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmBooks extends JFrame {
    
    //List
    private List<Book> books = null;
    
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JLabel lblNewLabel;
    private JTextField txtbookid;
    private JLabel lblBookname;
    private JTextField txtbookname;
    private JLabel lblPublisher;
    private JTextField txtpublisher;
    private JLabel lblYear;
    private JTextField txtyear;
    private JLabel lblPrice;
    private JTextField txtprice;
    private JLabel lblUseyn;
    private JTextField txtuse_yn;
    private JLabel lblAuthid;
    private JTextField txtauthid;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmBooks frame = new frmBooks();
                    frame.setVisible(true);
                    
                    // 기초 데이터 생성
                    frame.books = initDate(frame.books);
                    
                    // 데이터 바인딩
                    frame.refreshTable(frame.books, frame.table);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static List<Book> initDate(List<Book> list) {
        list = new ArrayList<Book>();
        list.add(new Book(1, "operating system", "wiley"   , "2003", 30700, false, 1 )) ;
        list.add(new Book(2, "mysql"           , "oreilly" , "2009", 58700, true , 2 )) ;
        list.add(new Book(3, "java"            , "hall"    , "2013", 40000, true , 3 )) ;
        list.add(new Book(4, "first sql"       , "wiley"   , "2015", 57700, true , 4 )) ;
        return list;
    }
    
    /**
     * Create the frame.
     */
    public frmBooks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 758, 535);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getScrollPane());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getBtnNewButton_2());
        contentPane.add(getBtnNewButton_3());
        contentPane.add(getLblNewLabel());
        contentPane.add(getTxtbookid());
        contentPane.add(getLblBookname());
        contentPane.add(getTxtbookname());
        contentPane.add(getLblPublisher());
        contentPane.add(getTxtpublisher());
        contentPane.add(getLblYear());
        contentPane.add(getTxtyear());
        contentPane.add(getLblPrice());
        contentPane.add(getTxtprice());
        contentPane.add(getLblUseyn());
        contentPane.add(getTxtuse_yn());
        contentPane.add(getLblAuthid());
        contentPane.add(getTxtauthid());
    }
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 10, 718, 152);
        	scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    private JTable getTable() {
        if (table == null) {
        	table = new JTable();
        	table.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	        // 선택한 row를 리턴
        	        int row = table.getSelectedRow();
        	        
        	        String bookid = table.getValueAt(row, 0).toString();
        	        String bookname = table.getValueAt(row, 1).toString();
        	        String publisher = table.getValueAt(row, 2).toString();
        	        String year = table.getValueAt(row, 3).toString();
        	        String price = table.getValueAt(row, 4).toString();
        	        String use_yn = table.getValueAt(row, 5).toString();
        	        String authid = table.getValueAt(row, 6).toString();
        	        
        	        txtbookid.setText(bookid);
        	        txtbookname.setText(bookname);
        	        txtpublisher.setText(publisher);
        	        txtyear.setText(year);
        	        txtprice.setText(price);
        	        txtuse_yn.setText(use_yn);
        	        txtauthid.setText(authid);
        	    }
        	});
        	table.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "bookid", "bookname", "publisher", "year", "price", "use_yn", "authid"
        	    }
        	) {
        	    Class[] columnTypes = new Class[] {
        	        Integer.class, String.class, String.class, String.class, Integer.class, Boolean.class, Integer.class
        	    };
        	    public Class getColumnClass(int columnIndex) {
        	        return columnTypes[columnIndex];
        	    }
        	});
        	table.getColumnModel().getColumn(0).setPreferredWidth(54);
        	table.getColumnModel().getColumn(1).setPreferredWidth(156);
        	table.getColumnModel().getColumn(2).setPreferredWidth(147);
        	table.getColumnModel().getColumn(3).setPreferredWidth(70);
        	table.getColumnModel().getColumn(5).setPreferredWidth(45);
        }
        return table;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("조회");
        	btnNewButton.setBounds(12, 185, 97, 23);
        }
        return btnNewButton;
    }
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
        	btnNewButton_1 = new JButton("추가");
        	btnNewButton_1.setBounds(144, 185, 97, 23);
        }
        return btnNewButton_1;
    }
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
        	btnNewButton_2 = new JButton("수정");
        	btnNewButton_2.setBounds(271, 185, 97, 23);
        }
        return btnNewButton_2;
    }
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
        	btnNewButton_3 = new JButton("삭제");
        	btnNewButton_3.setBounds(399, 185, 97, 23);
        }
        return btnNewButton_3;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("bookid");
        	lblNewLabel.setBounds(12, 231, 57, 15);
        }
        return lblNewLabel;
    }
    private JTextField getTxtbookid() {
        if (txtbookid == null) {
        	txtbookid = new JTextField();
        	txtbookid.setBounds(107, 228, 116, 21);
        	txtbookid.setColumns(10);
        }
        return txtbookid;
    }
    private JLabel getLblBookname() {
        if (lblBookname == null) {
        	lblBookname = new JLabel("bookname");
        	lblBookname.setBounds(12, 262, 57, 15);
        }
        return lblBookname;
    }
    private JTextField getTxtbookname() {
        if (txtbookname == null) {
        	txtbookname = new JTextField();
        	txtbookname.setColumns(10);
        	txtbookname.setBounds(107, 259, 116, 21);
        }
        return txtbookname;
    }
    private JLabel getLblPublisher() {
        if (lblPublisher == null) {
        	lblPublisher = new JLabel("publisher");
        	lblPublisher.setBounds(12, 296, 57, 15);
        }
        return lblPublisher;
    }
    private JTextField getTxtpublisher() {
        if (txtpublisher == null) {
        	txtpublisher = new JTextField();
        	txtpublisher.setColumns(10);
        	txtpublisher.setBounds(107, 293, 116, 21);
        }
        return txtpublisher;
    }
    private JLabel getLblYear() {
        if (lblYear == null) {
        	lblYear = new JLabel("year");
        	lblYear.setBounds(12, 332, 57, 15);
        }
        return lblYear;
    }
    private JTextField getTxtyear() {
        if (txtyear == null) {
        	txtyear = new JTextField();
        	txtyear.setColumns(10);
        	txtyear.setBounds(107, 329, 116, 21);
        }
        return txtyear;
    }
    private JLabel getLblPrice() {
        if (lblPrice == null) {
        	lblPrice = new JLabel("price");
        	lblPrice.setBounds(12, 360, 57, 15);
        }
        return lblPrice;
    }
    private JTextField getTxtprice() {
        if (txtprice == null) {
        	txtprice = new JTextField();
        	txtprice.setColumns(10);
        	txtprice.setBounds(107, 357, 116, 21);
        }
        return txtprice;
    }
    private JLabel getLblUseyn() {
        if (lblUseyn == null) {
        	lblUseyn = new JLabel("use_yn");
        	lblUseyn.setBounds(12, 394, 57, 15);
        }
        return lblUseyn;
    }
    private JTextField getTxtuse_yn() {
        if (txtuse_yn == null) {
        	txtuse_yn = new JTextField();
        	txtuse_yn.setColumns(10);
        	txtuse_yn.setBounds(107, 391, 116, 21);
        }
        return txtuse_yn;
    }
    private JLabel getLblAuthid() {
        if (lblAuthid == null) {
        	lblAuthid = new JLabel("authid");
        	lblAuthid.setBounds(12, 432, 57, 15);
        }
        return lblAuthid;
    }
    private JTextField getTxtauthid() {
        if (txtauthid == null) {
        	txtauthid = new JTextField();
        	txtauthid.setColumns(10);
        	txtauthid.setBounds(107, 429, 116, 21);
        }
        return txtauthid;
    }
    
    public void refreshTable(List<Book> list, JTable table) {
        Object[] tempObject = new Object[7];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // 테이블의 위치를 0부터 시작하도록 설정
        
        for (Book obj : list) {
            tempObject[0] = obj.getBookid();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getPublisher();
            tempObject[3] = obj.getYear();
            tempObject[4] = obj.getPrice();
            tempObject[5] = obj.getUse_yn();
            tempObject[6] = obj.getAuthid();
            model.addRow(tempObject);
        }
        // JTable 첫번쨰 로우에 focus 주기
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
            table.setModel(model);
        }
    }
}
