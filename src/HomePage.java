import javax.swing.*;

public class HomePage {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("WELCOME!");//

    HomePage(String username){
        welcomeLabel.setBounds(0,0,200,40);
        welcomeLabel.setFont(null);
        welcomeLabel.setText("Hello "+username);
        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

}
