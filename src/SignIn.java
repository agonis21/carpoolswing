import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignIn implements ActionListener {
    //have donor and renter option
    JFrame frame = new JFrame();
    JButton donorLoginBut = new JButton("Login as Donor");
    JButton renterLoginBut = new JButton("Login as Renter");
    JButton adminLoginBut = new JButton("Login as Admin");


    JButton resetBut = new JButton("Reset");
    JButton forgotPassBut = new JButton("Forgot Password");
    JTextField userID = new JTextField();
    JPasswordField userPass = new JPasswordField();
    JLabel userIDLabel = new JLabel("user ID:");
    JLabel warning = new JLabel();
    JLabel userPassLabel = new JLabel("password:");
    JLabel createAcc = new JLabel("Not registered? Click here!");
    JButton registerDonorBut = new JButton("Register to Donate");
    JButton registerRentBut = new JButton("Register to Rent");

    JLabel message = new JLabel("Welcome to Carpool!");
    private JPanel signIn;
    private JButton logInButton;
    private JPasswordField passwordField1;


    HashMap<String, String> loginInfo = new HashMap<String, String>();
    HashMap<String, String> accountInfo = new HashMap<String, String>();

    SignIn(HashMap<String, String> loginInfo1) {

        loginInfo = loginInfo1;
        HashMap<String, String> accountInfo1 = new HashMap<String, String>();

        accountInfo = accountInfo1;

        userIDLabel.setBounds(50, 100, 75, 25);
        userIDLabel.setForeground(new java.awt.Color(168, 183, 198));
        userPassLabel.setBounds(50, 125, 75, 25);
        userPassLabel.setForeground(new java.awt.Color(168, 183, 198));
        createAcc.setBounds(50, 175, 75, 25);
        createAcc.setForeground(new java.awt.Color(168, 183, 198));
        message.setBounds(50, 50, 250, 45);
        message.setFont(new Font(null, Font.BOLD, 20));
        message.setForeground(new java.awt.Color(168, 183, 198));
        warning.setBounds(145, 160, 250, 45);
        warning.setFont(new Font(null, Font.BOLD, 14));
        warning.setForeground(new java.awt.Color(168, 183, 198));
        frame.add(userIDLabel);
        frame.add(userPassLabel);
        frame.add(message);
        frame.add(userID);
        frame.add(userPass);
        frame.add(donorLoginBut);
        frame.add(adminLoginBut);
        frame.add(renterLoginBut);
        frame.add(resetBut);
        frame.add(registerDonorBut);
        frame.add(registerRentBut);
        frame.add(createAcc);
        frame.add(forgotPassBut);
        frame.add(warning);

        createAcc.setBounds(15, 250, 250, 45);
        createAcc.setFont(new Font(null, Font.BOLD, 14));

        userID.setBounds(125, 100, 200, 25);
        userPass.setBounds(125, 125, 200, 25);
        donorLoginBut.setBounds(125, 200, 200, 25);
        adminLoginBut.setBounds(125, 400, 200, 25);
        renterLoginBut.setBounds(125, 225, 200, 25);

        donorLoginBut.addActionListener(this);
        adminLoginBut.addActionListener(this);
        renterLoginBut.addActionListener(this);
        donorLoginBut.setFocusable(false);
        adminLoginBut.setFocusable(false);
        renterLoginBut.setFocusable(false);
        resetBut.setBounds(225, 250, 100, 25);
        resetBut.addActionListener(this);
        resetBut.setFocusable(false);

        registerDonorBut.setBounds(125, 300, 200, 25);
        registerDonorBut.addActionListener(this);
        registerDonorBut.setFocusable(false);
        registerRentBut.setBounds(125, 325, 200, 25);
        registerRentBut.addActionListener(this);
        registerRentBut.setFocusable(false);
        forgotPassBut.setBounds(125, 150, 200, 25);
        forgotPassBut.addActionListener(this);
        forgotPassBut.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.getContentPane().setBackground(new java.awt.Color(11, 34, 66));

        frame.setLayout(null);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == donorLoginBut) {
            String username = userID.getText();
            String password = String.valueOf(userPass.getPassword());
            if (loginInfo.containsKey(username)) {
                if (loginInfo.get(username).equals(password)) {
                    message.setForeground(Color.blue);
                    message.setText("Login Successful!");
                    frame.dispose();
//                    HomePage welcome = new HomePage(username);
                    HomeDonor welcome = new HomeDonor();
                } else {
                    warning.setForeground(Color.red);
                    warning.setText("Incorrect Password");
                }
            } else {
                warning.setForeground(Color.red);
                warning.setText("Username not found");
            }


        }
        if (e.getSource() == renterLoginBut) {
            String username = userID.getText();
            String password = String.valueOf(userPass.getPassword());
            if (loginInfo.containsKey(username)) {
                if (loginInfo.get(username).equals(password)) {
                    message.setForeground(Color.blue);
                    message.setText("Login Successful!");
                    frame.dispose();
//                    HomePage welcome = new HomePage(username);
                    HomeRenter welcome = new HomeRenter();
                } else {
                    warning.setForeground(Color.red);
                    warning.setText("Incorrect Password");
                }
            } else {
                warning.setForeground(Color.red);
                warning.setText("Username not found");
            }


        }
        if (e.getSource() == adminLoginBut) {
            String username = userID.getText();
            String password = String.valueOf(userPass.getPassword());
            if (loginInfo.containsKey(username)) {
                if (loginInfo.get(username).equals(password)) {
                    message.setForeground(Color.blue);
                    message.setText("Login Successful!");
                    frame.dispose();
//                    HomePage welcome = new HomePage(username);
                    AdminPanel welcome = new AdminPanel();
                } else {
                    warning.setForeground(Color.red);
                    warning.setText("Incorrect Password");
                }
            } else {
                warning.setForeground(Color.red);
                warning.setText("Username not found");
            }


        }

        if (e.getSource() == resetBut) {
            userID.setText("");
            userPass.setText("");
        }

        if (e.getSource() == registerDonorBut) {
//            Register registration = new Register();

            DonerRegistrationForm myForm = new DonerRegistrationForm(null);
            DonerUser donerUser = myForm.DonerUser;
            if (donerUser != null) {
                System.out.println("Succesful registration of: " + donerUser.Fname + donerUser.Lname);
            } else {
                System.out.println("Registration cancelled");
            }

            frame.dispose();

        }
        if (e.getSource() == registerRentBut) {
//            Register registration = new Register();

            DonerRegistrationForm myForm = new DonerRegistrationForm(null);
            DonerUser donerUser = myForm.DonerUser;
            if (donerUser != null) {
                System.out.println("Succesful registration of: " + donerUser.Fname + donerUser.Lname);
            } else {
                System.out.println("Registration cancelled");
            }

            frame.dispose();

        }
        if (e.getSource() == forgotPassBut) {
            PasswordRecovery passRecov = new PasswordRecovery(accountInfo);
            frame.dispose();

        }


    }

}
