import javax.swing.*;
import java.awt.*;

public class Login {
    public static String username = "admin";
    public static String password = "pass";
    public static JTextField txtUsername;
    public static JPasswordField txtPassword;
    public static JFrame frame; 

    public static void createLoginPanel() {
        // Initialize the frame
        frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Panel for Form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(20);
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(20);

        formPanel.add(lblUsername);
        formPanel.add(txtUsername);
        formPanel.add(lblPassword);
        formPanel.add(txtPassword);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());

        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);

        // Add Panels to Frame
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
