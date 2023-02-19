import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class TutorialPageRenter implements ActionListener {
    JFrame frame = new JFrame();
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JLabel logoLabel;
    private JLabel RenterTutorialLabel;
    private JLabel Step1Label;
    private JLabel Step2Label;
    private JLabel Step3Label;
    private JLabel SideNoteLabel;
    private JLabel Step2ParenthLabel;
    private JPanel BackgroundPanel;


    TutorialPageRenter() {
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
            HomeRenter Home = new HomeRenter();
            Home.frame.setVisible(true);
            frame.dispose();
        }
        if(e.getSource()== AboutButton)
        {
            AboutPageRenter aboutFrame = new AboutPageRenter();
            aboutFrame.frame.setVisible(true);
            frame.dispose();
        }
    }



}
