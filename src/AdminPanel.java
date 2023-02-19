import entity.User;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AdminPanel extends JFrame {
    private JLabel adminID_label;
    private JLabel adminName_label;
    private JLabel currentDate_label;
    private JLabel currentTime_label;
    private JPanel adminDetails_panel;
    private JPanel adminContent_panel;
    private JTabbedPane adminTabbed_pane;
    private JTabbedPane jobs_tabbed;
    private JTabbedPane tabbedPane3;
    private JPanel jobs_panel;
    private JPanel users_panel;
    private JPanel vehicles_panel;
    private JTabbedPane tabbedPane1;
    private JPanel jobsCurrent_panel;
    private JPanel jobsPast_panel;
    private JPanel jobsPending_panel;
    private JPanel main_panel;
    private JTable table1;
    private JLabel adminView_label;
    private JPanel carpoolLogo_panel;
    private JPanel footer_panel;

    public static void main(String[] args){







        AdminPanel adminPanel = new AdminPanel();
        adminPanel.setContentPane(adminPanel.main_panel);
        adminPanel.setTitle("Carpool Administrator View");
        adminPanel.setSize(800,800);
        adminPanel.setVisible(true);
        adminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        List<User> users = new ArrayList<>();
        List<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        users.add(new User("0001", "Asm Goni", "Admin", cars));
        users.add(new User("0001", "Asm Goni", "Admin", cars));
        users.add(new User("0001", "Asm Goni", "Admin", cars));
        users.add(new User("0001", "Asm Goni", "Admin", cars));

        UserTableModel userTableModel = new UserTableModel(users);
        table1.setModel(userTableModel);
        table1.setAutoCreateRowSorter(true);
    }

    private static class UserTableModel extends AbstractTableModel {

        private final String[] COLUMNS = {"ID", "NAME", "TYPE", "VEHICLES"};
        private List<User> users;

        private UserTableModel(List<User> users) {
            this.users = users;
        }

        @Override
        public int getRowCount() {
            return users.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> users.get(rowIndex).getUserID();
                case 1 -> users.get(rowIndex).getUserName();
                case 2 -> users.get(rowIndex).getUserType();
                case 3 -> users.get(rowIndex).getUserVehicles();
                default -> "Not Found...";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            } else {
                return Object.class;
            }
        }
    }
}
