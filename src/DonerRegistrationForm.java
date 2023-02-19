import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DonerRegistrationForm extends JDialog {
    private JTextField TextFieldFName;
    private JTextField TextFieldLName;
    private JTextField textFieldEmail;
    private JPasswordField passwordField;
    private JPasswordField confirmpasswordField;
    private JButton singUpButton;
    private JButton cancelButton;
    private JPanel DonerSignUpPanel;

    public DonerRegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Create Doner Account");
        setContentPane(DonerSignUpPanel);
        setMinimumSize(new Dimension(450, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        singUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerDonerUser();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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

    private void registerDonerUser() throws SQLException {
        String Fname = TextFieldFName.getText();
        String Lname = TextFieldLName.getText();
        String email = textFieldEmail.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPassword = String.valueOf(confirmpasswordField.getPassword());

        if (Fname.isEmpty() || Lname.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "One or more fields are missing",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;

        }
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        DonerUser = addDonerToDB(Fname, Lname, email, password);
        if (DonerUser != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register Doner User",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public DonerUser DonerUser;

    private DonerUser addDonerToDB(String Fname, String Lname, String email, String password) throws SQLException {
        DonerUser DonerUser = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/software";
        final String USERNAME = "root";
        final String PASSWORD = "123";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO donerusers(FName,LName,email,password)" + "VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, Fname);
            preparedStatement.setString(2, Lname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                DonerUser = new DonerUser();
                DonerUser.Fname = Fname;
                DonerUser.Lname = Lname;
                DonerUser.email = email;
                DonerUser.password = password;
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DonerUser;
    }

    public static void main(String[] args) {
        DonerRegistrationForm myForm = new DonerRegistrationForm(null);
        DonerUser donerUser = myForm.DonerUser;
        if (donerUser != null) {
            System.out.println("Succesful registration of: " + donerUser.Fname + donerUser.Lname);
        } else {
            System.out.println("Registration cancelled");
        }

    }

}
