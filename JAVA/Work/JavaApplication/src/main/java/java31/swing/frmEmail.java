package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class frmEmail extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JTextField textName;
    private JTextField textJob;
    private JLabel lblNewLabel_3;
    private JTextField textId;
    private JLabel lblNewLabel_4;
    private JTextField textEmail;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JLabel lblNewLabel_5;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JLabel lblEmail;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JTextArea textArea;
    
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
        contentPane.add(getTextName());
        contentPane.add(getTextJob());
        contentPane.add(getLblNewLabel_3());
        contentPane.add(getTextId());
        contentPane.add(getLblNewLabel_4());
        contentPane.add(getTextEmail());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getBtnNewButton_2());
        contentPane.add(getBtnNewButton_3());
        contentPane.add(getLblNewLabel_5());
        contentPane.add(getRdbtnNewRadioButton());
        contentPane.add(getRdbtnNewRadioButton_1());
        contentPane.add(getRdbtnNewRadioButton_2());
        contentPane.add(getLblEmail());
        contentPane.add(getBtnNewButton_4());
        contentPane.add(getBtnNewButton_5());
        contentPane.add(getTextArea());
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
    private JTextField getTextName() {
        if (textName == null) {
        	textName = new JTextField();
        	textName.setBounds(100, 70, 82, 21);
        	textName.setColumns(10);
        }
        return textName;
    }
    private JTextField getTextJob() {
        if (textJob == null) {
        	textJob = new JTextField();
        	textJob.setBounds(100, 106, 82, 21);
        	textJob.setColumns(10);
        }
        return textJob;
    }
    private JLabel getLblNewLabel_3() {
        if (lblNewLabel_3 == null) {
        	lblNewLabel_3 = new JLabel("아이디");
        	lblNewLabel_3.setBounds(218, 109, 57, 15);
        }
        return lblNewLabel_3;
    }
    private JTextField getTextId() {
        if (textId == null) {
        	textId = new JTextField();
        	textId.setBounds(287, 106, 82, 21);
        	textId.setColumns(10);
        }
        return textId;
    }
    private JLabel getLblNewLabel_4() {
        if (lblNewLabel_4 == null) {
        	lblNewLabel_4 = new JLabel("이메일주소");
        	lblNewLabel_4.setBounds(36, 211, 73, 15);
        }
        return lblNewLabel_4;
    }
    private JTextField getTextEmail() {
        if (textEmail == null) {
        	textEmail = new JTextField();
        	textEmail.setBounds(109, 208, 193, 21);
        	textEmail.setColumns(10);
        }
        return textEmail;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("Add");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String text = textArea.getText() + textEmail.getText() + "\n"; 
        	        textArea.setText(text);
        	    }
        	});
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
        	lblNewLabel_5 = new JLabel("Mail Format");
        	lblNewLabel_5.setBounds(36, 393, 73, 15);
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
    private JLabel getLblEmail() {
        if (lblEmail == null) {
        	lblEmail = new JLabel("E-mail");
        	lblEmail.setBounds(36, 186, 57, 15);
        }
        return lblEmail;
    }
    private JButton getBtnNewButton_4() {
        if (btnNewButton_4 == null) {
        	btnNewButton_4 = new JButton("OK");
        	btnNewButton_4.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        String msg = "";
        	        msg += textArea.getText() + "\r\n";
        	        JOptionPane.showMessageDialog(null, msg);
        	    }
        	});
        	btnNewButton_4.setBounds(178, 475, 97, 47);
        }
        return btnNewButton_4;
    }
    private JButton getBtnNewButton_5() {
        if (btnNewButton_5 == null) {
        	btnNewButton_5 = new JButton("Cancel");
        	btnNewButton_5.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        System.exit(0);
//        	        dispose();
        	    }
        	});
        	btnNewButton_5.setBounds(314, 475, 97, 47);
        }
        return btnNewButton_5;
    }
    private JTextArea getTextArea() {
        if (textArea == null) {
        	textArea = new JTextArea();
        	textArea.setBounds(36, 236, 264, 135);
        }
        return textArea;
    }
}
