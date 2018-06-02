package collegeprojectJF;

import collegeproject.UserF;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import collegeproject.Allcomponents;

public class AuthenticationView extends JFrame implements ActionListener {

    Container container = getContentPane();
    
    JLabel pageTitle = new JLabel("Login Form");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("Create new Account !");
    Allcomponents manager = new Allcomponents();

    AuthenticationView() {
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        container.setLayout(null);
        pageTitle.setBounds(20, 10, 150, 50);

        userLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);

        passwordLabel.setBounds(50, 220, 100, 30);
        passwordField.setBounds(150, 220, 150, 30);

        loginButton.setBounds(50, 300, 100, 30);
        registerButton.setBounds(50, 350, 400, 30);

        container.add(pageTitle);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(registerButton);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // login
        if (e.getActionCommand().equals("LOGIN")) {
            String un = userTextField.getText();
            String pw = passwordField.getText();
            System.out.println("User Name : " + un);
            System.out.println("Password : " + pw);
            UserF user = manager.getUser(un, pw);
            if (user == null) {
                UnAuthroizedView errorPage = new UnAuthroizedView("No Account found with the given details.");
                errorPage.setVisible(true);
                //this.setVisible(false);
            } else {
                if (user.isSuperAdmin()) {
                    System.out.println("Logged in as super admin.");
                    AdministerMenu adminPage = new AdministerMenu();
                    adminPage.setVisible(true);
                    this.setVisible(false);
                } else if (user.isFaculty()) {
                    System.out.println("Logged in as faculty.");
                    FacultyMenuView facultyPage = new FacultyMenuView();
                    facultyPage.setVisible(true);
                    this.setVisible(false);
                } else if (user.isStudent()) {
                    System.out.println("Logged in as student.");
                    StudentMenuView studentPage = new StudentMenuView();
                    studentPage.setVisible(true);
                    this.setVisible(false);
                }
            }
        } // register
        else if (e.getActionCommand().equals("Create new Account !")) {
            RegisterView registrationPage = new RegisterView("Student Registration", "student");
            registrationPage.setVisible(true);
        }
    }
}
