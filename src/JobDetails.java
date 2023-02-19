import javax.swing.*;
import java.awt.event.*;

public class JobDetails {
    private JPanel BackgroundPanel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton AccountButton;
    private JButton UploadButton;
    private JButton SubmitButton;
    private JComboBox JobType;
    private JLabel SelectJobTypeLabel;
    private JPanel HeaderPanel;
    private JLabel SubmissionLabel;
    private JLabel UploadFileConfirmation;

    public JobDetails() {
        UploadButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (JobType.getSelectedItem().equals("Select Job Type")) {
                UploadFileConfirmation.setText(" File Type Not Selected");

            } else {

                UploadFileConfirmation.setText(JobType.getSelectedItem().toString() + " File Uploaded");
            }
        }
    });
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JobType.getSelectedItem().equals("Select Job Type")) {
                    SubmissionLabel.setText(" Select File Type");

                } else {
                    SubmissionLabel.setText("Submission Complete");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JobDetails");
        frame.setContentPane(new JobDetails().BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

