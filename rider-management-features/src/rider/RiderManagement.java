package rider;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class RiderManagement extends JFrame{

    private final Color NAVY = new Color(22, 34, 58);
    private final Color BLUE = new Color(45, 105, 190);
    private final Color LIGHT_BG = new Color(245, 247, 250);
    private final Color TEXT = new Color(45, 55, 72);

    private JTextField nameField;
    private JTextField contactField;
    private JTextField maxOrdersField;

    private JTable riderTable;
    private DefaultTableModel tableModel;

    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    private String selectedRiderId = null;

    public RiderManagement(){
        //our title insert here
        setTitle("Delivery Rider Tracker System - Rider Management");
        setSize(1366, 768);
        setMinimumSize(new Dimension(1100, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createSidebar(), BorderLayout.WEST);
        add(createMainContent(), BorderLayout.CENTER);

//        refreshTable();
    }

    private JPanel createSidebar(){
        JPanel sidebar = new JPanel();
        sidebar.setBackground(NAVY);
        sidebar.setPreferredSize(new Dimension(225, 0));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createEmptyBorder(25, 15, 20, 15));

        JLabel appName = new JLabel("<html>DELIVERY<br>TRACKER</html>");
        appName.setForeground(Color.WHITE);
        appName.setFont(new Font("Arial", Font.BOLD, 21));
        appName.setBorder(BorderFactory.createEmptyBorder(0, 10, 35, 0));
        sidebar.add(appName);

        //side of the frame to connect each parts (navigation)
        addNavButton(sidebar, "Dashboard", false);
        addNavButton(sidebar, "Food Management", false);
        addNavButton(sidebar, "Rider Management", true);
        addNavButton(sidebar, "Create Delivery Order", false);
        addNavButton(sidebar, "Delivery Records", false);

        sidebar.add(Box.createVerticalGlue());

        JLabel managerLabel = new JLabel("Manager Account");
        managerLabel.setForeground(new Color(190, 200, 215));
        managerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        managerLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        sidebar.add(managerLabel);

        //when manager to logout
        JButton logoutButton = new JButton("Logout");
        styleNavButton(logoutButton, false);
        logoutButton.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to close this page?", "Logout", JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION){
                dispose();
            }
        });
        sidebar.add(logoutButton);
                        
        return sidebar; //to return the sidear nav in the frame
    }

    //navigation part at the side (needs to have complete parts to connect)
    private void addNavButton(JPanel sidebar, String title, boolean active){
        JButton button = new JButton(title);
        styleNavButton(button, active);

        if (!active) {
            button.addActionListener(e -> JOptionPane.showMessageDialog(this, title + " will be connected by the Dashboard member later.",
                    "Page Not Connected Yet", JOptionPane.INFORMATION_MESSAGE));
        }
        sidebar.add(button);
        sidebar.add(Box.createVerticalStrut(7));
    }

    private void styleNavButton(JButton button, boolean active){
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(active ? BLUE : NAVY);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 13, 12, 8));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
    }

    private JPanel createMainContent(){
        JPanel main = new JPanel(new BorderLayout(0, 20));
        main.setBackground(LIGHT_BG);
        main.setBorder(BorderFactory.createEmptyBorder(28, 30, 25, 30));

        JPanel heading = new JPanel();
        heading.setBackground(LIGHT_BG);
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Rider Management");
        title.setFont(new Font("Arial", Font.BOLD, 27));
        title.setForeground(TEXT);

        JLabel subtitle = new JLabel("Register riders and manage their delivery capacity.");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(115, 125, 140));

        heading.add(title);
        heading.add(Box.createVerticalStrut(6));
        heading.add(subtitle);

        JPanel topArea = new JPanel(new BorderLayout(18, 0));
        topArea.setBackground(LIGHT_BG);
        topArea.add(createRegisterPanel(), BorderLayout.CENTER);
//        topArea.add(createCapacityPanel(), BorderLayout.EAST);

        JPanel center = new JPanel(new BorderLayout(0, 15));
        center.setBackground(LIGHT_BG);
        center.add(topArea, BorderLayout.NORTH);
        center.add(createTablePanel(), BorderLayout.CENTER);

        main.add(heading, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);

        return main;
    }

    private JPanel createRegisterPanel(){
        JPanel panel = createWhitePanel();
        panel.setPreferredSize(new Dimension(650, 220));
        panel.setLayout(new BorderLayout(10, 12));

        JLabel title = new JLabel("Register New Rider");
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setForeground(TEXT);

        JPanel fields = new JPanel(new GridLayout(3, 2, 12, 9));
        fields.setBackground(Color.WHITE);

        nameField = new JTextField();
        contactField = new JTextField();
        maxOrdersField = new JTextField();

        addFormField(fields, "Rider Name", nameField);
        addFormField(fields, "Contact Number", contactField);
        addFormField(fields, "Maximum Active Orders", maxOrdersField);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.WHITE);
        buttons.setLayout(new GridLayout(1, 3, 9, 0));

        addButton = new JButton("Add Rider");
        updateButton = new JButton("Update Rider");
        deleteButton = new JButton("Delete Selected");
        JButton clearButton = new JButton("Clear");

        styleActionButton(addButton, BLUE, Color.WHITE);
        styleActionButton(updateButton, new Color(35, 145, 105), Color.WHITE);
        styleActionButton(deleteButton, new Color(190, 65, 65), Color.WHITE);
        styleActionButton(clearButton, new Color(235, 238, 243), TEXT);

        //buttons later for the action listener to functions
        addButton.addActionListener(e -> addRider());
        updateButton.addActionListener(e -> updateRider());
        deleteButton.addActionListener(e -> deleteRider());
        clearButton.addActionListener(e -> clearForm());

        buttons.add(addButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);

        JPanel lower = new JPanel(new BorderLayout(8, 0));
        lower.setBackground(Color.WHITE);
        lower.add(buttons, BorderLayout.CENTER);
        lower.add(clearButton, BorderLayout.EAST);

        panel.add(title, BorderLayout.NORTH);
        panel.add(fields, BorderLayout.CENTER);
        panel.add(lower, BorderLayout.SOUTH);

        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);

        return panel;
    }

    private void addFormField(JPanel panel, String labelText, JTextField field){
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        label.setForeground(TEXT);

        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setPreferredSize(new Dimension(180, 32));
        field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(215, 220, 228)), BorderFactory.createEmptyBorder(5, 8, 5, 8)));

        panel.add(label);
        panel.add(field);
    }

//    private JPanel createCapacityPanel(){
//        JPanel panel = createWhitePanel();
//        panel.setPreferredSize(new Dimension(300, 220));
//        panel.setLayout(new BorderLayout(0, 12));
//
//        JLabel title = new JLabel("Delivery Capacity");
//        title.setFont(new Font("Arial", Font.BOLD, 17));
//        title.setForeground(TEXT);
//
//        JLabel explanation = new JLabel("<html><div style='width:230px'>"
//                + "<b>Maximum Active Orders</b><br>"
//                + "The highest number of unfinished orders a rider can handle."
//                + "<br><br><b>Active Orders</b><br>"
//                + "Orders that are not yet delivered or cancelled."
//                + "<br><br><b>Remaining Capacity</b><br>"
//                + "Maximum Orders minus Active Orders."
//                + "</div></html>");
//        explanation.setFont(new Font("Arial", Font.PLAIN, 13));
//        explanation.setForeground(new Color(100, 110, 125));
//
//        panel.add(title, BorderLayout.NORTH);
//        panel.add(explanation, BorderLayout.CENTER);
//
//        return panel;
//    }

    private JPanel createTablePanel(){
        JPanel panel = createWhitePanel();
        panel.setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("Registered Riders");
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setForeground(TEXT);

        String[] columns = {"Rider ID", "Rider Name", "Contact", "Max Orders", "Active Orders", "Remaining", "Status"};
        tableModel = new DefaultTableModel(columns, 0){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        riderTable = new JTable(tableModel);
        riderTable.setFont(new Font("Arial", Font.PLAIN, 13));
        riderTable.setRowHeight(32);
        riderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        riderTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        riderTable.getTableHeader().setBackground(new Color(239, 242, 247));
        riderTable.getTableHeader().setForeground(TEXT);
        riderTable.setGridColor(new Color(230, 233, 238));
        riderTable.setSelectionBackground(new Color(220, 235, 252));

        riderTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
//                showSelectedRider();
            }
        });

        JScrollPane scrollPane = new JScrollPane(riderTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(225, 229, 235)));

        JLabel note = new JLabel("Select a rider from the table to edit or delete their information.");
        note.setFont(new Font("Arial", Font.PLAIN, 12));
        note.setForeground(new Color(120, 128, 140));

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(note, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createWhitePanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(230, 233, 238)), BorderFactory.createEmptyBorder(17, 18, 17, 18)));
        return panel;
    }

    private void styleActionButton(JButton button, Color background, Color foreground){
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(9, 10, 9, 10));
    }
    
    private void clearForm(){
        selectedRiderId = null;
        nameField.setText("");
        contactField.setText("");
        maxOrdersField.setText("");

        riderTable.clearSelection();

        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    //button "functions" ui
    private void addRider(){
    }

    //edit things
    private void updateRider(){
    }

    private void deleteRider(){
    }

    private void showSelectedRider(){
    }

    private void refreshTable(){
    }

    //error message using throws maybe? instead of sout
    private void showError(){
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> {
            new RiderManagement().setVisible(true); 
        });
    }
}