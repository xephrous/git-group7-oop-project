package riderfeatures;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RiderJframe extends JFrame {

	    private JPanel pnlSidebar;
	    private JPanel pnlMain;
	    private JPanel pnlHeader;
	    private JPanel pnlForm;
	    private JPanel pnlTable;

	    private JLabel lblSystemName;
	    private JLabel lblPageTitle;
	    private JLabel lblDescription;

	    private JTextField txtRiderName;
	    private JTextField txtContact;
	    private JTextField txtMaxOrders;

	    private JButton btnDashboard;
	    private JButton btnFoodManagement;
	    private JButton btnRiderManagement;
	    private JButton btnCreateOrder;
	    private JButton btnDeliveryRecords;
	    private JButton btnLogout;

	    private JButton btnAdd;
	    private JButton btnUpdate;
	    private JButton btnDelete;
	    private JButton btnClear;

	    private JTable tblRiders;

	    public RiderJframe() {
	        setTitle("Restaurant Delivery Tracker - Rider Management");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1366, 768);
	        setLocationRelativeTo(null);
	        setResizable(false);

	        getContentPane().setLayout(null);
	        getContentPane().setBackground(new Color(243, 246, 250));

	        //side navigation
	        pnlSidebar = new JPanel();
	        pnlSidebar.setLayout(null);
	        pnlSidebar.setBackground(new Color(23, 36, 58));
	        pnlSidebar.setBounds(0, 0, 245, 729);
	        getContentPane().add(pnlSidebar);

	        lblSystemName = new JLabel("<html>DELIVERY TRACKER</html>");
	        lblSystemName.setForeground(Color.WHITE);
	        lblSystemName.setFont(new Font("Arial", Font.BOLD, 22));
	        lblSystemName.setBounds(10, 28, 235, 65);
	        pnlSidebar.add(lblSystemName);

	        JLabel lblMenu = new JLabel("MAIN MENU");
	        lblMenu.setForeground(new Color(157, 170, 190));
	        lblMenu.setFont(new Font("Arial", Font.BOLD, 11));
	        lblMenu.setBounds(28, 125, 180, 25);
	        pnlSidebar.add(lblMenu);

	        btnDashboard = createNavButton("Dashboard", 165);
	        pnlSidebar.add(btnDashboard);

	        btnFoodManagement = createNavButton("Food Management", 220);
	        pnlSidebar.add(btnFoodManagement);

	        btnRiderManagement = createNavButton("Rider Management", 275);
	        btnRiderManagement.setBackground(new Color(49, 91, 145));
	        pnlSidebar.add(btnRiderManagement);

	        btnCreateOrder = createNavButton("Create Delivery Order", 330);
	        pnlSidebar.add(btnCreateOrder);

	        btnDeliveryRecords = createNavButton("Delivery Records", 385);
	        pnlSidebar.add(btnDeliveryRecords);

	        btnLogout = createNavButton("Logout", 650);
	        pnlSidebar.add(btnLogout);

	        //main content
	        pnlMain = new JPanel();
	        pnlMain.setLayout(null);
	        pnlMain.setBackground(new Color(243, 246, 250));
	        pnlMain.setBounds(245, 0, 1105, 729);
	        getContentPane().add(pnlMain);

	        pnlHeader = new JPanel();
	        pnlHeader.setLayout(null);
	        pnlHeader.setBackground(Color.WHITE);
	        pnlHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(225, 230, 237)));
	        pnlHeader.setBounds(0, 0, 1105, 75);
	        pnlMain.add(pnlHeader);

	        JLabel lblHeaderText = new JLabel("Restaurant Delivery Tracker System");
	        lblHeaderText.setFont(new Font("Arial", Font.BOLD, 15));
	        lblHeaderText.setForeground(new Color(45, 55, 72));
	        lblHeaderText.setBounds(30, 20, 450, 35);
	        pnlHeader.add(lblHeaderText);

	        JLabel lblAdmin = new JLabel("MANAGER");
	        lblAdmin.setFont(new Font("Arial", Font.BOLD, 11));
	        lblAdmin.setForeground(new Color(49, 91, 145));
	        lblAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblAdmin.setBounds(900, 20, 165, 35);
	        pnlHeader.add(lblAdmin);

	        //title
	        lblPageTitle = new JLabel("Rider Management");
	        lblPageTitle.setFont(new Font("Arial", Font.BOLD, 27));
	        lblPageTitle.setForeground(new Color(23, 36, 58));
	        lblPageTitle.setBounds(35, 100, 500, 40);
	        pnlMain.add(lblPageTitle);

	        lblDescription = new JLabel("Manage delivery riders, contact details, and order capacity.");
	        lblDescription.setFont(new Font("Arial", Font.PLAIN, 14));
	        lblDescription.setForeground(new Color(105, 116, 132));
	        lblDescription.setBounds(37, 140, 650, 28);
	        pnlMain.add(lblDescription);

	        //rider registration
	        pnlForm = new JPanel();
	        pnlForm.setLayout(null);
	        pnlForm.setBackground(Color.WHITE);
	        pnlForm.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(224, 230, 237)), BorderFactory.createEmptyBorder(8, 8, 8, 8)));
	        pnlForm.setBounds(35, 190, 1035, 190);
	        pnlMain.add(pnlForm);

	        JLabel lblFormTitle = new JLabel("Register New Rider");
	        lblFormTitle.setFont(new Font("Arial", Font.BOLD, 17));
	        lblFormTitle.setForeground(new Color(35, 48, 67));
	        lblFormTitle.setBounds(20, 12, 300, 30);
	        pnlForm.add(lblFormTitle);

	        JLabel lblRiderName = new JLabel("Rider Name");
	        lblRiderName.setFont(new Font("Arial", Font.BOLD, 12));
	        lblRiderName.setForeground(new Color(65, 75, 90));
	        lblRiderName.setBounds(22, 55, 250, 22);
	        pnlForm.add(lblRiderName);

	        txtRiderName = new JTextField();
	        txtRiderName.setFont(new Font("Arial", Font.PLAIN, 14));
	        txtRiderName.setBounds(22, 80, 285, 36);
	        pnlForm.add(txtRiderName);

	        JLabel lblContact = new JLabel("Contact Number");
	        lblContact.setFont(new Font("Arial", Font.BOLD, 12));
	        lblContact.setForeground(new Color(65, 75, 90));
	        lblContact.setBounds(335, 55, 250, 22);
	        pnlForm.add(lblContact);

	        txtContact = new JTextField();
	        txtContact.setFont(new Font("Arial", Font.PLAIN, 14));
	        txtContact.setBounds(335, 80, 285, 36);
	        pnlForm.add(txtContact);

	        JLabel lblMaxOrders = new JLabel("Maximum Active Orders");
	        lblMaxOrders.setFont(new Font("Arial", Font.BOLD, 12));
	        lblMaxOrders.setForeground(new Color(65, 75, 90));
	        lblMaxOrders.setBounds(648, 55, 250, 22);
	        pnlForm.add(lblMaxOrders);

	        txtMaxOrders = new JTextField();
	        txtMaxOrders.setFont(new Font("Arial", Font.PLAIN, 14));
	        txtMaxOrders.setBounds(648, 80, 175, 36);
	        pnlForm.add(txtMaxOrders);

	        btnAdd = new JButton("Add Rider");
	        stylePrimaryButton(btnAdd);
	        btnAdd.setBounds(22, 135, 125, 36);
	        pnlForm.add(btnAdd);

	        btnUpdate = new JButton("Edit");
	        btnUpdate.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        	}
	        });
	        styleSecondaryButton(btnUpdate);
	        btnUpdate.setBounds(158, 135, 105, 36);
	        pnlForm.add(btnUpdate);

	        btnDelete = new JButton("Delete");
	        styleSecondaryButton(btnDelete);
	        btnDelete.setBounds(274, 135, 145, 36);
	        pnlForm.add(btnDelete);

	        btnClear = new JButton("Clear");
	        styleSecondaryButton(btnClear);
	        btnClear.setBounds(430, 135, 90, 36);
	        pnlForm.add(btnClear);

	        //table of riders
	        pnlTable = new JPanel();
	        pnlTable.setLayout(null);
	        pnlTable.setBackground(Color.WHITE);
	        pnlTable.setBorder(BorderFactory.createLineBorder(new Color(224, 230, 237)));
	        pnlTable.setBounds(35, 400, 1035, 285);
	        pnlMain.add(pnlTable);

	        JLabel lblTableTitle = new JLabel("Registered Riders");
	        lblTableTitle.setFont(new Font("Arial", Font.BOLD, 17));
	        lblTableTitle.setForeground(new Color(35, 48, 67));
	        lblTableTitle.setBounds(20, 12, 300, 30);
	        pnlTable.add(lblTableTitle);

	        JLabel lblTableInfo = new JLabel("Registered Riders Lists");
	        lblTableInfo.setFont(new Font("Arial", Font.PLAIN, 12));
	        lblTableInfo.setForeground(new Color(120, 130, 145));
	        lblTableInfo.setBounds(20, 40, 400, 22);
	        pnlTable.add(lblTableInfo);

	        String[] columns = {
	            "Rider ID", "Rider Name", "Contact Number",
	            "Max Orders", "Active Orders", "Remaining", "Status"
	        };

	        //information rows to edit later
	        Object[][] rows = {
	            {"", "", "", 0, 0, 0, "Available"},
	            {"", "", "", 0, 0, 0, "Available"},
	            {"", "", "", 0, 0, 0, "Available"}
	        };

	        DefaultTableModel model = new DefaultTableModel(rows, columns) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };

	        tblRiders = new JTable(model);
	        tblRiders.setFont(new Font("Arial", Font.PLAIN, 12));
	        tblRiders.setRowHeight(32);
	        tblRiders.setForeground(new Color(55, 65, 81));
	        tblRiders.setSelectionBackground(new Color(219, 234, 254));
	        tblRiders.setSelectionForeground(new Color(23, 36, 58));
	        tblRiders.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
	        tblRiders.getTableHeader().setBackground(new Color(241, 245, 249));
	        tblRiders.getTableHeader().setForeground(new Color(55, 65, 81));
	        tblRiders.getTableHeader().setReorderingAllowed(false);

	        JScrollPane scrollRiders = new JScrollPane(tblRiders);
	        scrollRiders.setBounds(20, 72, 995, 190);
	        pnlTable.add(scrollRiders);
	    }

	    private JButton createNavButton(String text, int y) {
	        JButton button = new JButton(text);
	        button.setFont(new Font("Arial", Font.PLAIN, 14));
	        button.setForeground(Color.WHITE);
	        button.setBackground(new Color(23, 36, 58));
	        button.setHorizontalAlignment(SwingConstants.LEFT);
	        button.setFocusPainted(false);
	        button.setBorderPainted(false);
	        button.setBounds(18, y, 210, 43);
	        return button;
	    }

	    private void stylePrimaryButton(JButton button) {
	        button.setFont(new Font("Arial", Font.BOLD, 12));
	        button.setForeground(Color.WHITE);
	        button.setBackground(new Color(49, 91, 145));
	        button.setFocusPainted(false);
	        button.setBorderPainted(false);
	    }

	    private void styleSecondaryButton(JButton button) {
	        button.setFont(new Font("Arial", Font.BOLD, 12));
	        button.setForeground(new Color(45, 55, 72));
	        button.setBackground(new Color(235, 239, 245));
	        button.setFocusPainted(false);
	        button.setBorderPainted(false);
	    }

	    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	        try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (RuntimeException e) {
	        }

	        java.awt.EventQueue.invokeLater(() -> {
	            new RiderJframe().setVisible(true);
	        });
	    }
	}