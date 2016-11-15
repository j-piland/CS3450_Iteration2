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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InventoryManager extends JPanel {

	private JLabel IMinputPrompt;
	private JButton executeBtn;
	private JTextField IMSearch;
	private JPanel buttonBar;
	private JButton IMbackButton;
	private String[] optionsList;
	private JComboBox inventoryOptions;
	private JTextArea display;
	private JScrollPane IMscroll;

	private JLabel blank;
	private JPanel bottomBar;

	public InventoryManager() {
		this.setLayout(new BorderLayout());
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(4, 1));

		optionsList = new String[] { "View All", "Search By Product ID", "Search by Product Name", "Add", "Edit",
				"Delete" };
		IMinputPrompt = new JLabel("Input Here: ");
		executeBtn = new JButton("Execute");
		inventoryOptions = new JComboBox(optionsList);
		inventoryOptions.setSelectedIndex(0);

		IMSearch = new JTextField();

		buttonBar.add(IMinputPrompt);
		buttonBar.add(IMSearch);
		buttonBar.add(inventoryOptions);
		buttonBar.add(executeBtn);

		display = new JTextArea();
		display.setEditable(false);
		IMscroll = new JScrollPane(display);

		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1, 2));
		blank = new JLabel("");
		IMbackButton = new JButton("Back");
		bottomBar.add(blank);
		bottomBar.add(IMbackButton);

		this.add(buttonBar, BorderLayout.NORTH);
		this.add(IMscroll, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);

	}

	public JButton getIMbackButton() {
		return IMbackButton;
	}

	public JButton getexecuteBtn() {
		return executeBtn;
	}

	public void setIMbox(int a) {
		inventoryOptions.setSelectedIndex(a);
	}

	public String getIMsearch() {
		return IMSearch.getText();
	}

	public void setOutputBox(String t) {
		IMSearch.setText(t);
	}

	public int execute() {
		if (inventoryOptions.getSelectedIndex() == 0) {
			String searchid = IMSearch.getText();
			int rID = 0;// 2
			String rBuyingPrice = new String();// 3
			String rSellingPrice = new String();// 4
			String rSalePrice = new String();// 5
			// int rStatus=0;//6
			String rTax = new String();// 7
			String rProviderID = new String();// 8
			String results = new String();
			String rQuantity = new String();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:testusers", "postgres", "123456");

				Statement st = db.createStatement();

				ResultSet rs = st.executeQuery("SELECT * FROM Inventory ORDER BY ProductID ASC");
				if (rs.next()) {
					do {
						if (rs.next()) {
							rSalePrice = rs.getString(5);
							rSellingPrice = rs.getString(4);
							rID = rs.getInt(2);
							rBuyingPrice = rs.getString(3);
							rTax = rs.getString(7);
							rProviderID = rs.getString(8);

							results = "Product ID: " + rID + "\n" + "Selling Price: " + rSellingPrice + "\n"
									+ "Sale Price: " + rSalePrice + "\n" + "Buying Price: " + rBuyingPrice + "\n"
									+ "Quantity: " + rQuantity + "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID
									+ "\n\n";

						} else {
							results = "No results found";
						}
					} while (rs.next());
				} else {
					results = "No Employees listed";
				}
				display.setText(results);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// =================================================================
		} else if (inventoryOptions.getSelectedIndex() == 1) {
			String searchid = IMSearch.getText();
			int rID = 0;// 2
			String rBuyingPrice = new String();// 3
			String rSellingPrice = new String();// 4
			String rSalePrice = new String();// 5
			// int rStatus=0;//6
			String rTax = new String();// 7
			String rProviderID = new String();// 8
			String results = new String();
			String rQuantity = new String();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:Inventory", "postgres", "123456");

				Statement st = db.createStatement();

				ResultSet rs = st.executeQuery(
						"SELECT * FROM Inventory WHERE ProductID = " + searchid + " ORDER BY storeid ASC");

				if (rs.next()) {
					rSalePrice = rs.getString(5);
					rSellingPrice = rs.getString(4);
					rID = rs.getInt(2);
					rBuyingPrice = rs.getString(3);
					rTax = rs.getString(7);
					rProviderID = rs.getString(8);

					results = "Product ID: " + rID + "\n" + "Selling Price: " + rSellingPrice + "\n" + "Sale Price: "
							+ rSalePrice + "\n" + "Buying Price: " + rBuyingPrice + "\n" + "Quantity: " + rQuantity
							+ "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID + "\n\n";

				} else {
					results = "No results found";
				}

				display.setText(results);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ================================================================
		} else if (inventoryOptions.getSelectedIndex() == 2) {
			String searchName = IMSearch.getText();
			int rID = 0;// 2
			String rBuyingPrice = new String();// 3
			String rSellingPrice = new String();// 4
			String rSalePrice = new String();// 5
			// int rStatus=0;//6
			String rTax = new String();// 7
			String rProviderID = new String();// 8
			String results = new String();
			String rQuantity = new String();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:Inventory", "postgres", "123456");

				Statement st = db.createStatement();

				ResultSet rs = st
						.executeQuery("SELECT * FROM Inventory WHERE name = " + searchName + " ORDER BY storeid ASC");

				if (rs.next()) {
					rSalePrice = rs.getString(5);
					rSellingPrice = rs.getString(4);
					rID = rs.getInt(2);
					rBuyingPrice = rs.getString(3);
					rTax = rs.getString(7);
					rProviderID = rs.getString(8);

					results = "Product ID: " + rID + "\n" + "Selling Price: " + rSellingPrice + "\n" + "Sale Price: "
							+ rSalePrice + "\n" + "Buying Price: " + rBuyingPrice + "\n" + "Quantity: " + rQuantity
							+ "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID + "\n\n";

				} else {
					results = "No results found";
				}

				display.setText(results);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (inventoryOptions.getSelectedIndex() == 3) {
			return 1;// add
			// ================================================================
		} else if (inventoryOptions.getSelectedIndex() == 4) {
			return 2;// update
			// ================================================================
		} else if (inventoryOptions.getSelectedIndex() == 5) {
			String searchid = IMSearch.getText();

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:Inventory", "postgres", "123456");
				db.setAutoCommit(false);

				Statement st = db.createStatement();

				if ((JOptionPane.showConfirmDialog(null, "Are you sure you want to delete product: " + searchid + "?",
						"Delete Warning", JOptionPane.OK_CANCEL_OPTION)) == JOptionPane.OK_OPTION) {
					st.executeUpdate("DELETE FROM Inventory * WHERE ProductID = \'" + searchid + "\'");
					db.commit();
					JOptionPane.showMessageDialog(null, "Product has been deleted", "User Deleted",
							JOptionPane.WARNING_MESSAGE);
					st.executeUpdate("DELETE FROM Inventory * WHERE ProductID = \'" + searchid + "\'");
					System.out.println("DELETE FROM Inventory * WHERE ProductID = \'" + searchid + "\'");
					db.commit();
					JOptionPane.showMessageDialog(null, "Product has been deleted", "Product Deleted",
							JOptionPane.WARNING_MESSAGE);
				}

				int rID = 0;// 2
				String rBuyingPrice = new String();// 3
				String rSellingPrice = new String();// 4
				String rSalePrice = new String();// 5
				// int rStatus=0;//6
				String rTax = new String();// 7
				String rProviderID = new String();// 8
				String results = new String();
				String rQuantity = new String();
				ResultSet rs = st.executeQuery("SELECT * FROM Inventory ORDER BY ProductID ASC");
				if (rs.next()) {
					do {
						rSalePrice = rs.getString(5);
						rSellingPrice = rs.getString(4);
						rID = rs.getInt(2);
						rBuyingPrice = rs.getString(3);
						rTax = rs.getString(7);
						rProviderID = rs.getString(8);

						results = "Product ID: " + rID + "\n" + "Selling Price: " + rSellingPrice + "\n"
								+ "Sale Price: " + rSalePrice + "\n" + "Buying Price: " + rBuyingPrice + "\n"
								+ "Quantity: " + rQuantity + "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID
								+ "\n\n";

					} while (rs.next());
				} else {
					results = "No Employees listed";
				}
				display.setText(results);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}

	public void IMclearBoard() {
		display.setText("");
	}

}
