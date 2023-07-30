/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login
extends JFrame
implements ActionListener {
    Container c = this.getContentPane();
    private JButton btnLogin;
    private JButton btnCancel;
    private JLabel lblUName;
    private JLabel lblPasswd;
    private JTextField txtUName;
    private JPasswordField txtPasswd;

    public Login() {
        super("Login ...");
        this.setSize(350, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(Settings.getScreenSize().width / 2 - 175, Settings.getScreenSize().height / 2 - 150);
        this.setDefaultCloseOperation(3);
        this.lblUName = new JLabel("Username");
        this.lblPasswd = new JLabel("Password");
        this.txtUName = new JTextField();
        this.txtPasswd = new JPasswordField();
        this.btnLogin = new JButton("Login", new ImageIcon(ClassLoader.getSystemResource("Images/login.png")));
        this.btnCancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
        this.lblUName.setBounds(50, 40, 140, 25);
        this.txtUName.setBounds(150, 40, 130, 25);
        this.lblPasswd.setBounds(50, 80, 140, 25);
        this.txtPasswd.setBounds(150, 80, 130, 25);
        this.btnLogin.setBounds(50, 120, 100, 25);
        this.btnCancel.setBounds(180, 120, 100, 25);
        this.btnLogin.addActionListener(this);
        this.btnCancel.addActionListener(this);
        this.add(this.lblUName);
        this.add(this.lblPasswd);
        this.add(this.txtUName);
        this.add(this.txtPasswd);
        this.add(this.btnLogin);
        this.add(this.btnCancel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnLogin) {
            try {
                try {
                    userMDI userMDI2 = new userMDI();
                    userMDI2.setVisible(true);
                    this.dispose();
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid", 0);
                    this.txtUName.setText("");
                    this.txtPasswd.setText("");
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Unable to connect to the database", "Connection error", 0);
            }
        }
        if (actionEvent.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }

    public static void main(String[] stringArray) {
        new Login().setVisible(true);
    }
}
