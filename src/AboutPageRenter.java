import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class AboutPageRenter implements ActionListener {
    JFrame frame = new JFrame();
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JLabel AboutUSLabel;
    private JLabel carpoolUsersLabel;
    private JLabel DonorsLabel;
    private JLabel freeParkingLabel;
    private JLabel carsComputerLabel;
    private JLabel RentersLabel;
    private JLabel submitInformationLabel;
    private JLabel filesAndJobLabel;
    private JLabel poolOfResourcesLabel;
    private JPanel BackgroundPanel;
    private JPanel textPanel;


    AboutPageRenter(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(BackgroundPanel);
        frame.pack();

        HomeButton.addActionListener(this);
        TutorialButton.addActionListener(this);
//        AccountButton.addActionListener(this);



        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TutorialButton)
        {
            TutorialPageRenter tutorialFrame = new TutorialPageRenter();
            tutorialFrame.frame.setVisible(true);
            frame.dispose();
        }
        if (e.getSource() == HomeButton) {
            HomeRenter Home = new HomeRenter();
            Home.frame.setVisible(true);
            frame.dispose();
        }
    }





}
