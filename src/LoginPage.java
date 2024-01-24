import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    // class variables
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();

    HashMap<String, String> copyOfLoginInfo = new HashMap<>();

    // constructor
    public LoginPage(HashMap<String, String> loginInfo){

        //creating the lables
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        // creating the fields - where the user enters their information
        userIdField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 35);

        // creating the login button
        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false); // this is true by default and adds weird surrounding to the buttons
        loginButton.addActionListener(this);

        // creating the reset button
        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        // adding the components
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        // creating the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    // to handle events
    @Override
    public void actionPerformed(ActionEvent e) {

        // clears the fields
        if (e.getSource() == resetButton) {
            userIdField.setText("");
            userPasswordField.setText("");
        }

        // logins in the user by getting the username and password
        if(e.getSource()==loginButton) {
            String userID = userIdField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            // validating the information
            if(copyOfLoginInfo.containsKey(userID)) {
                if (copyOfLoginInfo.get(userID).equals(password)) {
                    messageLabel.setText("Login was successful! :) ");
                    // takes the user to the welcome page
                    WelcomePage welcomePage = new WelcomePage();
                } else {
                    // the credentials are not correct - incorrect password
                    messageLabel.setText("Incorrect Password!");

                }
            } else {
                messageLabel.setText("Incorrect username!");
            }


        }

    }
}
