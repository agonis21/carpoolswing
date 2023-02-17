import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignIn implements ActionListener {
//have donor and renter option
    JFrame frame = new JFrame();
    JButton loginBut = new JButton("Login");
    JButton resetBut = new JButton("Reset");
    JButton forgotPassBut  = new JButton("Forgot Password");
    JTextField userID = new JTextField();
    JPasswordField userPass = new JPasswordField();
    JLabel userIDLabel = new JLabel("user ID:");
    JLabel userPassLabel = new JLabel("password:");
    JLabel createAcc = new JLabel("Not registered? Click here!");
    JButton registerBut = new JButton("Register");
    JLabel message = new JLabel("Welcome to Carpool!");



    HashMap<String,String> loginInfo = new HashMap<String,String>();
    HashMap<String,String> accountInfo = new HashMap<String, String>();

    SignIn(HashMap<String,String> loginInfo1){

        loginInfo = loginInfo1;
        HashMap<String,String> accountInfo1 = new HashMap<String, String>();

        accountInfo=accountInfo1;

        userIDLabel.setBounds(50,100,75,25);
        userPassLabel.setBounds(50,125,75,25);
        createAcc.setBounds(50,175,75,25);
        message.setBounds(50,50,250,45);
        message.setFont(new Font( null , Font.BOLD, 20));
        frame.add(userIDLabel);
        frame.add(userPassLabel);
        frame.add(message);
        frame.add(userID);
        frame.add(userPass);
        frame.add(loginBut);
        frame.add(resetBut);
        frame.add(registerBut);
        frame.add(createAcc);
        frame.add(forgotPassBut);

        createAcc.setBounds(15,250,250,45);
        createAcc.setFont(new Font( null , Font.BOLD, 14));

        userID.setBounds(125,100,200,25);
        userPass.setBounds(125,125,200,25);
        loginBut.setBounds(125,200,100,25);

        loginBut.addActionListener(this);
        loginBut.setFocusable(false);
        resetBut.setBounds(225,200,100,25);
        resetBut.addActionListener(this);
        resetBut.setFocusable(false);

        registerBut.setBounds(225,250,100,25);
        registerBut.addActionListener(this);
        registerBut.setFocusable(false);
        forgotPassBut.setBounds(125,150,200,25);
        forgotPassBut.addActionListener(this);
        forgotPassBut.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    private JPanel signIn;
    private JButton logInButton;
    private JPasswordField passwordField1;

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==loginBut){
           String username = userID.getText();
           String password = String.valueOf(userPass.getPassword());
           if(loginInfo.containsKey(username)){
               if(loginInfo.get(username).equals(password)){
                   message.setForeground(Color.blue);
                   message.setText("Login Successful!");
                   frame.dispose();
                   HomePage welcome = new HomePage(username);
               }
               else{
                   message.setForeground(Color.red);
                   message.setText("Incorrect Password");
               }
           }
           else{
               message.setForeground(Color.red);
               message.setText("Username not found");
           }



        }

        if(e.getSource()==resetBut){
            userID.setText("");
            userPass.setText("");
        }

        if(e.getSource()==registerBut){
            Register registration = new Register();
        }
        if(e.getSource()==forgotPassBut){
            PasswordRecovery passRecov = new PasswordRecovery(accountInfo);
        }



    }
}
