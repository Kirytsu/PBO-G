import java.awt.event.*;

public class CancelListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        // Reset all values on field
        Login.txtUsername.setText("");
        Login.txtPassword.setText("");
        Login.txtUsername.requestFocus();
    }
}
