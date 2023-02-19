import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DonerLogin  extends JDialog{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JButton signUpButton;
    private JButton cancelButton;
    private JPanel donerloginpanel;
    private JTextField textFieldemail;
    private JPasswordField passwordField;

public DonerLogin(JFrame parent){
    super(parent);
    setTitle("DonerLogin");
    setContentPane(donerloginpanel);
    setMinimumSize(new Dimension(500,600));
    setModal(true);
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    logInButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email=textFieldemail.getText();
            String password= String.valueOf(passwordField.getPassword());

            donerUser=getAuthenticated(email,password);

            if (donerUser!=null){
                dispose();
            }else{
                JOptionPane.showMessageDialog(DonerLogin.this,
                        "Email or Password invalid",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    });
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    setVisible(true);
}
public DonerUser donerUser;
private DonerUser getAuthenticated(String email,String password){
    DonerUser donerUser=null;
    String DB_URL ="jdbc:mysql://localhost:3306/software";
    final String USERNAME ="root";
    final String PASSWORD = "123";
    try {
        Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            donerUser=new DonerUser();
            donerUser.Lname=resultSet.getString("LName");
            donerUser.Fname=resultSet.getString("FName");
            donerUser.email=resultSet.getString("email");
            donerUser.password=resultSet.getString("password");


        }
        stmt.close();
        conn.close();

    } catch (SQLException e) {
       e.printStackTrace();
    }
    return donerUser;
}
    public static  void main(String[] args) {
    DonerLogin loginform=new DonerLogin(null);
    DonerUser donerUser = loginform.donerUser;
    if (donerUser!=null){
        System.out.println("Successful Authentication of: " + donerUser.Fname+" "+donerUser.Lname);
    }
        else {
        System.out.println("Authentication canceled");

    }
    }
    }

