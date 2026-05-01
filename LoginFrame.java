package libraryseatreservationswing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	JTextField username;
    JPasswordField password;
    JButton loginBtn;

    public LoginFrame() {
        setTitle("Library Login");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Username:"));
        username = new JTextField();
        add(username);

        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);

        loginBtn = new JButton("Login");
        add(loginBtn);

        loginBtn.addActionListener(e -> login());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void login() {
        String u = username.getText();
        String p = new String(password.getPassword());

        int adminId = UserDAO.login(u, p, "ADMIN");
        int studentId = UserDAO.login(u, p, "STUDENT");

        if (adminId != -1) {
            new AdminFrame();
            dispose();
        } else if (studentId != -1) {
            new StudentFrame(studentId);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }


}
