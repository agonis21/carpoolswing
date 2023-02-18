import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Register extends JFrame implements ActionListener {

        //add account type option with dropdown bar and selection or button selection
        //can do button selection in SignIn to lead to page to ask which type of account then use two diff forms?
        JFrame frame = new JFrame();
        JButton loginPageBut = new JButton("Back to Login");
        JComboBox comboBox;
        JLabel welcomeLabel = new JLabel("Create your new account here!");
        JLabel newUsername = new JLabel("username:");
        JLabel newPassword = new JLabel("password:");
        JLabel email = new JLabel("email:");
        JLabel securityResp = new JLabel("Security Reponse:");



    //add security question for user

        JButton submitBut = new JButton("Submit");
        JTextField newUser = new JTextField();
    JTextField securityQues = new JTextField();

    JPasswordField newPass = new JPasswordField();
        JTextField newEmail = new JTextField();

    Register() {
        welcomeLabel.setFont(new Font( null , Font.CENTER_BASELINE, 20));
        newUsername.setFont(new Font( null , Font.BOLD, 14));
        newPassword.setFont(new Font( null , Font.BOLD, 14));
        email.setFont(new Font( null , Font.BOLD, 14));
        securityResp.setFont(new Font( null , Font.BOLD, 14));

       // String username1 = newUser.getText();
       // System.out.println(username1);
        newUsername.setBounds(15, 100, 75, 25);
        newPassword.setBounds(15, 125, 75, 25);
        email.setBounds(15, 150, 75, 25);

        securityResp.setBounds(15, 175, 500, 25);
        newUser.setBounds(125,100,200,25);
        securityQues.setBounds(125,200,200,25);
        newPass.setBounds(125,125,200,25);
        newEmail.setBounds(125,150,200,25);
        frame.add(securityQues);
        frame.add(securityResp);
        frame.add(newUsername);
        frame.add(newPassword);
        frame.add(email);
        frame.add(submitBut);
        frame.add(loginPageBut);

        submitBut.setBounds(125,300,100,25);
        submitBut.addActionListener(this);
        submitBut.setFocusable(false);
        loginPageBut.setBounds(125,50,150,25);
        loginPageBut.addActionListener(this);
        loginPageBut.setFocusable(false);

        welcomeLabel.setBounds(0, 0, 200, 40);
        welcomeLabel.setFont(null);
        frame.add(newUser);
        frame.add(securityQues);
        frame.add(newPass);
        frame.add(newEmail);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout((new FlowLayout()));

        String[] choices = {
                "Q1: What's your mother's maiden name?",
                "Q2: What is your favorite movie?",
                "Q3: What elementary school did you attend?"
                };

        int[] choicesID = {1,2,3};

        comboBox = new JComboBox(choices);
        comboBox.addActionListener(this);

        //comboBox.location() = new Point(327, 77);

        this.add(comboBox);
        this.pack();
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            System.out.println(comboBox.getSelectedItem());
            String choice = (String) comboBox.getSelectedItem();
            securityResp.setText(choice);
            //add stuff for databases
        }
        if(e.getSource()==submitBut){
            String regUser = newUser.getText();
            HomePage welcome = new HomePage(regUser);
            frame.dispose();


        }
        if(e.getSource()==loginPageBut){
            HashMap<String,String> loginInfo = new HashMap<String,String>();
            frame.dispose();
        }
    }

}
