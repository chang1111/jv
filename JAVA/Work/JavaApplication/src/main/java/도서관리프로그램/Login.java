package 도서관리프로그램;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Login extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblPw;
    private JTextField idField;
    private JTextField pwField;
    private JButton loginButton;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 359, 123);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblPw());
        contentPane.add(getIdField());
        contentPane.add(getPwField());
        contentPane.add(getLoginButton());
        contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getIdField(), getPwField(), getLoginButton()}));
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("ID");
        	lblNewLabel.setBounds(25, 18, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblPw() {
        if (lblPw == null) {
        	lblPw = new JLabel("PW");
        	lblPw.setBounds(25, 51, 57, 15);
        }
        return lblPw;
    }
    private JTextField getIdField() {
        if (idField == null) {
        	idField = new JTextField();
        	idField.setBounds(71, 18, 116, 21);
        	idField.setColumns(10);
        }
        return idField;
    }
    private JTextField getPwField() {
        if (pwField == null) {
        	pwField = new JTextField();
        	pwField.setBounds(71, 51, 116, 21);
        	pwField.setColumns(10);
        }
        return pwField;
    }
    private JButton getLoginButton() {
        if (loginButton == null) {
        	loginButton = new JButton("Log In");
        	loginButton.setBounds(214, 18, 97, 48);
        }
        return loginButton;
    }
}
