import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class TutorialPageDonor implements ActionListener{
    JFrame frame = new JFrame();
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JLabel DonorTutorialLabel;
    private JLabel Step1Label;
    private JLabel Step2Label;
    private JLabel Step1parenthLabel;
    private JLabel Step3Label;
    private JLabel Step4Label;
    private JPanel BackgroundPanel;


    TutorialPageDonor() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(BackgroundPanel);
        frame.pack();

        HomeButton.addActionListener(this);
        AboutButton.addActionListener(this);
        //AccountButton.addActionListener(this);




        frame.setVisible(true);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == HomeButton)
        {
            HomeDonor Home = new HomeDonor();
            Home.frame.setVisible(true);
            frame.dispose();
        }
        if(e.getSource()== AboutButton)
        {
            AboutPageDonor aboutFrame = new AboutPageDonor();
            aboutFrame.frame.setVisible(true);
            frame.dispose();
        }
    }

}
