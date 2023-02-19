import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class HomeDonor implements ActionListener {
    JFrame frame = new JFrame();

    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JButton DonateButton;
    private JLabel HaveJobLabel;
    private JPanel BackgroundPanel;


    HomeDonor() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(BackgroundPanel);
        frame.pack();

        TutorialButton.addActionListener(this);
        AboutButton.addActionListener(this);

        //Connect Asm and other's pages using these buttons
        //DonateButton.addActionListener(this);
        //AccountButton.addActionListener(this);



        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TutorialButton)
        {
            TutorialPageDonor tutorialFrame = new TutorialPageDonor();
            tutorialFrame.frame.setVisible(true);
            frame.dispose();
        }
        if(e.getSource()== AboutButton)
        {
            AboutPageDonor aboutFrame = new AboutPageDonor();
            aboutFrame.frame.setVisible(true);
            frame.dispose();
        }



    }

//tests the homepage functionality
    public static void main(String[] args) {

            /*
    example of how this page would be called, can be ammended to take account ID as constructor
    parameter in order to make changes to account information
     */
        HomeDonor Home = new HomeDonor();
        //frame.setVisible(true);
    }

}
