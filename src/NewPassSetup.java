import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NewPassSetup implements ActionListener {


    JButton submitChanges = new JButton("Submit");
    JPasswordField newUserPass = new JPasswordField();

    JLabel newPassLabel = new JLabel("Please select a security question:");
    //add something to retrieve specific security questions


    HashMap<String,String> accountInfo = new HashMap<String, String>();

    NewPassSetup(HashMap<String,String> accountInfo1) {
        accountInfo = accountInfo1;

        newPassLabel.setBounds(50, 125, 75, 25);
        newUserPass.setBounds(125, 125, 200, 25);

        submitChanges.setBounds(125, 100, 150, 25);
        submitChanges.addActionListener(this);
        submitChanges.setFocusable(false);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitChanges) {
        newPassLabel.setText("Please select the answer to your security question below:");
//add info from registrations selection
        }
    }
}
