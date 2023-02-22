import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disconnect implements ActionListener{
    JFrame frame = new JFrame("Disconnect");

    private JPanel BackgroundPanel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton AccountButton;
    private JButton DisconnectButton;
    private JLabel ThankYouLabel;
    private JLabel DisconnectConfirmationLabel;

    public Disconnect() {


        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        DisconnectButton.addActionListener(this);
        HomeButton.addActionListener(this);






        //DisconnectButton.addActionListener(new ActionListener() {
          //  @Override
           //public void actionPerformed(ActionEvent e) {
             //   DisconnectConfirmationLabel.setText("Vehicle Disconnected Successfully");
       //     }
        //});






    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==DisconnectButton)
        {
            /*
            ####DATABASE IMPLEMENTATION###
            in donation table update the actual elapsed time that they were in the lot
             */
            DisconnectConfirmationLabel.setText("Vehicle Disconnected Successfully");

            HomeDonor Home = new HomeDonor();
            frame.dispose();
        }
        if(e.getSource()== HomeButton)
        {
            HomeDonor Home = new HomeDonor();
            frame.dispose();

        }



    }
    public static void main(String[] args) {
//        JFrame frame = new JFrame("Disconnect");
//        frame.setContentPane(new Disconnect().BackgroundPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        Disconnect disconnect = new Disconnect();
        disconnect.frame.setVisible(true);

    }
}