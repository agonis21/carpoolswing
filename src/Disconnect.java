import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disconnect {
    private JPanel BackgroundPanel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton AccountButton;
    private JButton DisconnectButton;
    private JLabel ThankYouLabel;
    private JLabel DisconnectConfirmationLabel;

    public Disconnect() {
        DisconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisconnectConfirmationLabel.setText("Vehicle Disconnected Successfully");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Disconnect");
        frame.setContentPane(new Disconnect().BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}