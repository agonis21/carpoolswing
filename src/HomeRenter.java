import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class HomeRenter implements ActionListener {
    JFrame frame = new JFrame("Home");
    private JButton RentButton;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JLabel logoLabel;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel HaveJobLabel;
    private JToolBar Navbar;

    HomeRenter() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(BackgroundPanel);
        frame.pack();

        RentButton.addActionListener(this);
        TutorialButton.addActionListener(this);
        AboutButton.addActionListener(this);

        //Connect Asm and other's pages using these buttons
        //RentButton.addActionListener(this);
        //AccountButton.addActionListener(this);



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

        if(e.getSource()== AboutButton)
        {
            AboutPageRenter aboutFrame = new AboutPageRenter();
            aboutFrame.frame.setVisible(true);
            frame.dispose();
        }

        if(e.getSource()== RentButton)
        {
            System.out.println("ffff");
            JobDetails jobFrame = new JobDetails();
            jobFrame.frame.setVisible(true);

            //AboutPageRenter aboutFrame = new AboutPageRenter();

            frame.dispose();
        }



    }

//tests the homepage functionality
    public static void main(String[] args) {

        /*
        example of how this page would be called, can be ammended to take account ID as constructor
        parameter in order to make changes to account information
         */
        HomeRenter Home = new HomeRenter();
        //frame.setVisible(true);
    }





}
