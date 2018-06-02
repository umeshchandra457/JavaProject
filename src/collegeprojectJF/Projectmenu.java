package collegeprojectJF;

import javax.swing.*;
import collegeprojectJF.AuthenticationView;

public class Projectmenu {

    public static void main(String arg[]) {
        try {
            AuthenticationView frame = new AuthenticationView();
            frame.setVisible(true);
            frame.setBounds(10, 10, 1000, 750);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
