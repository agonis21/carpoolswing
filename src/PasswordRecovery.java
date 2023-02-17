import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PasswordRecovery implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginPageBut = new JButton("Back to Login");
    JButton submit = new JButton("Submit");
    JTextField userEmail = new JTextField();

    JLabel welcomeLabel = new JLabel("Please enter the email associated with your account.");
    JLabel recoveryEmail = new JLabel("email:");
    HashMap<String,String> accountInfo = new HashMap<String, String>();

    PasswordRecovery(HashMap<String,String> accountInfo1) {
        accountInfo = accountInfo1;
        welcomeLabel.setFont(new Font(null, Font.CENTER_BASELINE, 20));
        welcomeLabel.setBounds(0, 0, 500, 40);
        welcomeLabel.setFont(null);
        frame.add(welcomeLabel);

        recoveryEmail.setFont(new Font(null, Font.BOLD, 14));
        recoveryEmail.setBounds(15, 100, 75, 25);
        frame.add(recoveryEmail);

        loginPageBut.setBounds(125, 50, 150, 25);
        loginPageBut.addActionListener(this);
        loginPageBut.setFocusable(false);

        frame.add(submit);
        submit.setBounds(125, 150, 150, 25);
        submit.addActionListener(this);
        submit.setFocusable(false);
        frame.add(loginPageBut);

        frame.add(userEmail);
        userEmail.setBounds(125, 100, 200, 25);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        HashMap<String, String> loginInfo = new HashMap<String, String>();
        if (e.getSource() == loginPageBut) {
            frame.dispose();
        }
        if (e.getSource() == submit) {
            String email = userEmail.getText();
            HashMap<String,String> accountInfo = new HashMap<String, String>();
            if(accountInfo.containsKey(email)){
                NewPassSetup newPass = new NewPassSetup(accountInfo);
            } //should be checking the email to then open new pass setup but isnt
        }
        }
    }
