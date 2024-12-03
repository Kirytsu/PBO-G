import javax.swing.*;
import java.awt.event.*;

public class LoginListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        String inputUsername = Login.txtUsername.getText();
        String inputPassword = new String(Login.txtPassword.getPassword());

        if (Login.username.equals(inputUsername) && Login.password.equals(inputPassword)) {
            JOptionPane.showMessageDialog(null, "Login Success!");
            Login.frame.dispose(); // Close login window
            ImageViewer.openImageViewer();
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is wrong!");
        }
    }
}
