package inventorycards;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InventoryAddCard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel ADinputPrompt;
	private JTextField ADsearch;
	private JComboBox accountOptions;
	private String[] optionsList;
	private JButton AUexecute;
	private JPanel buttonGrid;

	private JPanel optionsGrid;
	private JLabel lID;
	private JLabel lName;
	private JLabel lBuyingPrice;
	private JLabel lSellingPrice;
	private JLabel lSalePrice;
	private JLabel lQuantity;
	private JLabel lTax;
	private JLabel lProviderID;

	private JTextField tID;
	private JTextField tName;
	private JTextField tBuyingPrice;
	private JTextField tSellingPrice;
	private JTextField tSalePrice;
	private JTextField tQuantity;
	private JTextField tTax;
	private JTextField tProviderID;

	private JLabel blank = new JLabel("               ");

	private JPanel bottomBar;
	private JButton ADaddButton;
	private JButton ADbackButton;

	public InventoryAddCard() {
		this.setLayout(new BorderLayout());

		optionsList = new String[] { "View All", "Search By Product ID", "Search by Product Name", "Add", "Edit",
				"Delete" };

		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1, 4));
		ADinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(3);
		ADsearch = new JTextField();
		AUexecute = new JButton("Execute");
		buttonGrid.add(ADinputPrompt);
		buttonGrid.add(ADsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AUexecute);

		optionsGrid = new JPanel();
		optionsGrid.setLayout(new GridLayout(8, 2));

		optionsGrid.add(lID = new JLabel("Product ID: "));
		optionsGrid.add(tID = new JTextField());

		optionsGrid.add(lName = new JLabel("Product Name: "));
		optionsGrid.add(tName = new JTextField());

		optionsGrid.add(lBuyingPrice = new JLabel("Buying Price: "));
		optionsGrid.add(tBuyingPrice = new JTextField());

		optionsGrid.add(lSellingPrice = new JLabel("Selling Price: "));
		optionsGrid.add(tSellingPrice = new JTextField());

		optionsGrid.add(lSalePrice = new JLabel("Sale Price: "));
		optionsGrid.add(tSalePrice = new JTextField());

		optionsGrid.add(lQuantity = new JLabel("Quantity: "));
		optionsGrid.add(tQuantity = new JTextField());

		optionsGrid.add(lTax = new JLabel("Tax: "));
		optionsGrid.add(tTax = new JTextField());

		optionsGrid.add(lProviderID = new JLabel("Provider ID: "));
		optionsGrid.add(tProviderID = new JTextField());

		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1, 2));
		ADbackButton = new JButton("Back");
		ADaddButton = new JButton("Add");
		bottomBar.add(ADaddButton);
		bottomBar.add(ADbackButton);

		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(blank, BorderLayout.WEST);
		this.add(optionsGrid, BorderLayout.CENTER);

	}

	public void setADbox(int a) {
		accountOptions.setSelectedIndex(a);
	}

	public String getADsearch() {
		return ADsearch.getText();
	}

	public void setADsearch(String t) {
		ADsearch.setText(t);
	}

	public JButton getADexecuteButton() {
		return AUexecute;
	}

	public JButton getADbackButton() {
		return ADbackButton;
	}

	public JButton getADaddButton() {
		return ADaddButton;
	}

	public int ADexecute() {
		// =======================================================
		if (accountOptions.getSelectedIndex() == 0) {
			return 0;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 1) {
			return 1;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 2) {
			return 2;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 4) {
			return 4;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 5) {
			return 5;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 3) {

			Boolean procede = false;
			String searcher = new String();
			int idfromdb = 0;

			// Update testusers
			// Set id=id, ...
			// WHERE store id =

			if (tID.getText().length() != 0 && tName.getText().length() != 0 && tBuyingPrice.getText().length() != 0
					&& tSellingPrice.getText().length() != 0 && tSalePrice.getText().length() != 0
					&& tQuantity.getText().length() != 0 && tTax.getText().length() != 0
					&& tProviderID.getText().length() != 0) {
				// Logantesting.usu.edu
				procede = true;
			}

			if (!procede) {
				JOptionPane.showMessageDialog(null, "Please Fill in All Fields.", "Alert", JOptionPane.ERROR_MESSAGE);
				return 3;
			}

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:Inventory", "postgres", "123456");

				Statement st = db.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Inventory ORDER BY ProductID DESC");

				if (rs.next()) {
					idfromdb = rs.getInt("ProductID");
				} else {
					JOptionPane.showMessageDialog(null, "Not drawing values from database.", "Alert",
							JOptionPane.ERROR_MESSAGE);
					return 3;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			idfromdb++;

			searcher = "INSERT INTO userinfo (ProductID, Name, BuyingPrice, SellingPrice, name, status, phone, address) VALUES ("
					+ idfromdb + ", \'" + tName.getText() + "\', " + tBuyingPrice.getText() + ", "
					+ tSellingPrice.getText() + ", " + tSalePrice.getText() + ", ";

			searcher += "" + tQuantity.getText() + ", " + tTax.getText() + ", " + tProviderID.getText() + ")";

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				db = DriverManager.getConnection("jdbc:postgresql:Inventory", "postgres", "123456");
				db.setAutoCommit(false);

				Statement st = db.createStatement();
				System.out.println(searcher);
				st.executeUpdate(searcher);
				db.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			JOptionPane.showMessageDialog(null, "Update Complete!", "Update Alert", JOptionPane.PLAIN_MESSAGE);
		}

		return 3;

	}

}
