import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Register implements ActionListener {

        //add account type option with dropdown bar and selection or button selection
        //can do button selection in SignIn to lead to page to ask which type of account then use two diff forms?
        JFrame frame = new JFrame();
        JButton loginPageBut = new JButton("Back to Login");

        JLabel welcomeLabel = new JLabel("Create your new account here!");
        JLabel newUsername = new JLabel("username:");
        JLabel newPassword = new JLabel("password:");
        JLabel email = new JLabel("email:");
        JButton submitBut = new JButton("Submit");
        JTextField newUser = new JTextField();
        JPasswordField newPass = new JPasswordField();
        JTextField newEmail = new JTextField();

    Register() {
        welcomeLabel.setFont(new Font( null , Font.CENTER_BASELINE, 20));
        newUsername.setFont(new Font( null , Font.BOLD, 14));
        newPassword.setFont(new Font( null , Font.BOLD, 14));
        email.setFont(new Font( null , Font.BOLD, 14));

       // String username1 = newUser.getText();
       // System.out.println(username1);
        newUsername.setBounds(15, 100, 75, 25);
        newPassword.setBounds(15, 125, 75, 25);
        email.setBounds(15, 150, 75, 25);
        newUser.setBounds(125,100,200,25);
        newPass.setBounds(125,125,200,25);
        newEmail.setBounds(125,150,200,25);
        frame.add(newUsername);
        frame.add(newPassword);
        frame.add(email);
        frame.add(submitBut);
        frame.add(loginPageBut);

        submitBut.setBounds(125,200,100,25);
        submitBut.addActionListener(this);
        submitBut.setFocusable(false);
        loginPageBut.setBounds(125,50,150,25);
        loginPageBut.addActionListener(this);
        loginPageBut.setFocusable(false);

        welcomeLabel.setBounds(0, 0, 200, 40);
        welcomeLabel.setFont(null);
        frame.add(newUser);
        frame.add(newPass);
        frame.add(newEmail);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitBut){
            String regUser = newUser.getText();
            HomePage welcome = new HomePage(regUser);

        }
        if(e.getSource()==loginPageBut){
            HashMap<String,String> loginInfo = new HashMap<String,String>();
            frame.dispose();
        }
    }

}
