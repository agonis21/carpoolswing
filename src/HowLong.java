import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowLong implements ActionListener {
    JFrame frame = new JFrame("Carpool");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JLabel logoLabel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton SubmitButton;
    private JLabel HaveJobLabel;
    private JTextField textField1;
    private JLabel minutesLabel;



    HowLong(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(BackgroundPanel);
        frame.pack();

        SubmitButton.addActionListener(this);
        HomeButton.addActionListener(this);



        frame.setVisible(true);



    }

    //Method taken from https://www.baeldung.com/java-check-string-number#:~:text=Perhaps%20the%20easiest%20and%20the,Double.parseDouble(String)
    public static boolean isNumeric(String text){

        if(text== null)
        {
            return false;
        }

        try{
            int number = Integer.parseInt(text);
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;

    }




        @Override
        public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SubmitButton)
        {
            String text = textField1.getText();
            if (isNumeric(text))
            {
                int num = Integer.parseInt(text);
                if(num>0)
                {
                    /*
                    #### DATABASE IMPLEMENTATION#####
                    output number donation table as estimated use time
                     */

                    Disconnect disconnect = new Disconnect();
                    disconnect.frame.setVisible(true);
                    frame.dispose();


                }
            }
            else{
                //dialog box for invalid input
            }
        }
            if(e.getSource()==HomeButton)
            {
                HomeDonor homeDonor = new HomeDonor();
                homeDonor.frame.setVisible(true);
                frame.dispose();
            }


        }






}
