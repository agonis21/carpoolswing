import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CarRegistration extends JDialog {
    private JTextField textFieldmake;
    private JTextField textFieldmodel;
    private JTextField textFieldyear;
    private JTextField textFieldvin;
    private JTextField textFieldemail;
    private JCheckBox iConsentToTheCarpoolCheckBox;
    private JButton submitButton;
    private JPanel carRegPanel;
    private JButton cancelButton;

    public CarRegistration(JFrame parent) {
        super(parent);
        setTitle("CarRegistration");
        setContentPane(carRegPanel);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerCar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }

    private void registerCar() throws SQLException{
        String make = textFieldmake.getText();
        String year = textFieldyear.getText();
        String model = textFieldmodel.getText();
        String vin = textFieldvin.getText();
        String email = textFieldemail.getText();

        if (make.isEmpty() || year.isEmpty() || email.isEmpty() || model.isEmpty() || vin.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "One or more fields are missing",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        donerUser = AuthenticatedUser(email);

        if (donerUser != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(CarRegistration.this,
                    "Email Invalid",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        regcar = addcartoDB(make, model,year, vin, email);

        if (regcar != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register Doner User",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }

    }




    public Car regcar;
    private Car addcartoDB(String make,String model, String year, String vin,String email) throws SQLException{
        Car regcar=null;
        String DB_URL ="jdbc:mysql://localhost:3306/software";
        final String USERNAME ="root";
        final String PASSWORD = "123";
        try {
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql="INSERT INTO registeredcars(make,model , year, vin, email)"+ "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, make);
            preparedStatement.setString(2,model);
            preparedStatement.setString(3,year);
            preparedStatement.setString(4,vin);
            preparedStatement.setString(5,email);

            int addedRows= preparedStatement.executeUpdate();
            if (addedRows>0){
                regcar=new Car();
                regcar.make=make;
                regcar.year=year;
                regcar.model=model;
                regcar.vin=vin;
                regcar.email=email;
            }
            stmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return regcar;
    }


    public DonerUser donerUser;

    private DonerUser AuthenticatedUser(String email) {
        DonerUser donerUser = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/software";
        final String USERNAME = "root";
        final String PASSWORD = "123";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM donorusers WHERE email=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                donerUser = new DonerUser();
                donerUser.Fname = resultSet.getString("FName");
                donerUser.Lname = resultSet.getString("LName");
                donerUser.email = resultSet.getString("email");
                donerUser.password = resultSet.getString("password");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donerUser;
    }

    public static void main(String[]args){
        CarRegistration myreg=new CarRegistration(null);
        Car regcar=myreg.regcar;
        if(regcar!=null){
            System.out.println("Succesful car registration");
        }
        else {
            System.out.println("Car registration cancelled");
        }
    }
}