package historycards;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HistoryManager extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel HMinputPrompt;
	private JTextField HMSearch;
	private JComboBox historyOptions;
	private String[] optionsList;
	private JButton executeBtn;
	private JPanel buttonGrid;

	private JTextArea display;
	private JScrollPane AVscroll;

	private JLabel blank;
	private JButton HMbackButton;
	private JPanel bottomBar;

	public HistoryManager() {
		this.setLayout(new BorderLayout());

		optionsList = new String[] { "All Sales" };

		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1, 4));
		HMinputPrompt = new JLabel("Input Here: ");
		historyOptions = new JComboBox(optionsList);
		historyOptions.setSelectedIndex(0);
		HMSearch = new JTextField();
		executeBtn = new JButton("Execute");
		buttonGrid.add(HMinputPrompt);
		buttonGrid.add(HMSearch);
		buttonGrid.add(historyOptions);
		buttonGrid.add(executeBtn);

		display = new JTextArea();
		display.setEditable(false);
		AVscroll = new JScrollPane(display);

		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1, 2));
		blank = new JLabel("");
		HMbackButton = new JButton("Back");
		bottomBar.add(blank);
		bottomBar.add(HMbackButton);

		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(AVscroll, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}

	public JButton getHMbackButton() {
		return HMbackButton;
	}

	public JButton getexecuteBtn() {
		return executeBtn;
	}

	public void setHMbox(int a) {
		historyOptions.setSelectedIndex(a);
	}

	public String getHMsearch() {
		return HMSearch.getText();
	}

	public void setOutputBox(String t) {
		HMSearch.setText(t);
	}

	public int execute() {
		if (historyOptions.getSelectedIndex() == 0) {
			String searchid = HMSearch.getText();
			int hID = 0;// 1
			String hCustomer = new String();// 2
			String hPayment = new String();// 3
			String hEmployeeID = new String();// 4
			String hPaymentTotal = new String();// 5
			String hTime = new String();// 6
			String results = new String();

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
							hEmployeeID = rs.getString(4);
							hPayment = rs.getString(3);
							hID = rs.getInt(1);
							hCustomer = rs.getString(2);
							hPaymentTotal = rs.getString(5);
							hTime = rs.getString(6);

							results = "History ID: " + hID + "\n" + "Customer: " + hCustomer + "\n" + "Payment: "
									+ hPayment + "\n" + "Employee ID: " + hEmployeeID + "\n" + "Payment Total: "
									+ hPaymentTotal + "\n" + "Time: " + hTime + "\n\n";

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
		} /*
			 * else if (historyOptions.getSelectedIndex() == 1) { String
			 * searchid = IMSearch.getText(); int rID = 0;// 2 String
			 * rBuyingPrice = new String();// 3 String rSellingPrice = new
			 * String();// 4 String rSalePrice = new String();// 5 // int
			 * rStatus=0;//6 String rTax = new String();// 7 String rProviderID
			 * = new String();// 8 String results = new String(); String
			 * rQuantity = new String();
			 * 
			 * try { Class.forName("org.postgresql.Driver"); } catch
			 * (ClassNotFoundException e) { e.printStackTrace(); }
			 * 
			 * Connection db; try { db =
			 * DriverManager.getConnection("jdbc:postgresql:Inventory",
			 * "postgres", "123456");
			 * 
			 * Statement st = db.createStatement();
			 * 
			 * ResultSet rs = st.executeQuery(
			 * "SELECT * FROM Inventory WHERE ProductID = " + searchid +
			 * " ORDER BY storeid ASC");
			 * 
			 * if (rs.next()) { rSalePrice = rs.getString(5); rSellingPrice =
			 * rs.getString(4); rID = rs.getInt(2); rBuyingPrice =
			 * rs.getString(3); rTax = rs.getString(7); rProviderID =
			 * rs.getString(8);
			 * 
			 * results = "Product ID: " + rID + "\n" + "Selling Price: " +
			 * rSellingPrice + "\n" + "Sale Price: " + rSalePrice + "\n" +
			 * "Buying Price: " + rBuyingPrice + "\n" + "Quantity: " + rQuantity
			 * + "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID + "\n\n";
			 * 
			 * } else { results = "No results found"; }
			 * 
			 * display.setText(results); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } //
			 * ================================================================
			 * } else if (inventoryOptions.getSelectedIndex() == 2) { String
			 * searchName = IMSearch.getText(); int rID = 0;// 2 String
			 * rBuyingPrice = new String();// 3 String rSellingPrice = new
			 * String();// 4 String rSalePrice = new String();// 5 // int
			 * rStatus=0;//6 String rTax = new String();// 7 String rProviderID
			 * = new String();// 8 String results = new String(); String
			 * rQuantity = new String();
			 * 
			 * try { Class.forName("org.postgresql.Driver"); } catch
			 * (ClassNotFoundException e) { e.printStackTrace(); }
			 * 
			 * Connection db; try { db =
			 * DriverManager.getConnection("jdbc:postgresql:Inventory",
			 * "postgres", "123456");
			 * 
			 * Statement st = db.createStatement();
			 * 
			 * ResultSet rs = st .executeQuery(
			 * "SELECT * FROM Inventory WHERE name = " + searchName +
			 * " ORDER BY storeid ASC");
			 * 
			 * if (rs.next()) { rSalePrice = rs.getString(5); rSellingPrice =
			 * rs.getString(4); rID = rs.getInt(2); rBuyingPrice =
			 * rs.getString(3); rTax = rs.getString(7); rProviderID =
			 * rs.getString(8);
			 * 
			 * results = "Product ID: " + rID + "\n" + "Selling Price: " +
			 * rSellingPrice + "\n" + "Sale Price: " + rSalePrice + "\n" +
			 * "Buying Price: " + rBuyingPrice + "\n" + "Quantity: " + rQuantity
			 * + "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID + "\n\n";
			 * 
			 * } else { results = "No results found"; }
			 * 
			 * display.setText(results); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } } else if
			 * (inventoryOptions.getSelectedIndex() == 3) { return 1;// add //
			 * ================================================================
			 * } else if (inventoryOptions.getSelectedIndex() == 4) { return
			 * 2;// update //
			 * ================================================================
			 * } else if (inventoryOptions.getSelectedIndex() == 5) { String
			 * searchid = IMSearch.getText();
			 * 
			 * try { Class.forName("org.postgresql.Driver"); } catch
			 * (ClassNotFoundException e) { e.printStackTrace(); }
			 * 
			 * Connection db; try { db =
			 * DriverManager.getConnection("jdbc:postgresql:Inventory",
			 * "postgres", "123456"); db.setAutoCommit(false);
			 * 
			 * Statement st = db.createStatement();
			 * 
			 * if ((JOptionPane.showConfirmDialog(null,
			 * "Are you sure you want to delete product: " + searchid + "?",
			 * "Delete Warning", JOptionPane.OK_CANCEL_OPTION)) ==
			 * JOptionPane.OK_OPTION) { st.executeUpdate(
			 * "DELETE FROM Inventory * WHERE ProductID = \'" + searchid +
			 * "\'"); db.commit(); JOptionPane.showMessageDialog(null,
			 * "Product has been deleted", "User Deleted",
			 * JOptionPane.WARNING_MESSAGE); st.executeUpdate(
			 * "DELETE FROM Inventory * WHERE ProductID = \'" + searchid +
			 * "\'"); System.out.println(
			 * "DELETE FROM Inventory * WHERE ProductID = \'" + searchid +
			 * "\'"); db.commit(); JOptionPane.showMessageDialog(null,
			 * "Product has been deleted", "Product Deleted",
			 * JOptionPane.WARNING_MESSAGE); }
			 * 
			 * int rID = 0;// 2 String rBuyingPrice = new String();// 3 String
			 * rSellingPrice = new String();// 4 String rSalePrice = new
			 * String();// 5 // int rStatus=0;//6 String rTax = new String();//
			 * 7 String rProviderID = new String();// 8 String results = new
			 * String(); String rQuantity = new String(); ResultSet rs =
			 * st.executeQuery("SELECT * FROM Inventory ORDER BY ProductID ASC"
			 * ); if (rs.next()) { do { rSalePrice = rs.getString(5);
			 * rSellingPrice = rs.getString(4); rID = rs.getInt(2); rBuyingPrice
			 * = rs.getString(3); rTax = rs.getString(7); rProviderID =
			 * rs.getString(8);
			 * 
			 * results = "Product ID: " + rID + "\n" + "Selling Price: " +
			 * rSellingPrice + "\n" + "Sale Price: " + rSalePrice + "\n" +
			 * "Buying Price: " + rBuyingPrice + "\n" + "Quantity: " + rQuantity
			 * + "\n" + "Tax: " + rTax + "Provider ID: " + rProviderID + "\n\n";
			 * 
			 * } while (rs.next()); } else { results = "No Employees listed"; }
			 * display.setText(results); } catch (SQLException e) {
			 * e.printStackTrace(); } }
			 */

		return 0;

	}

	public void HMclearBoard() {
		display.setText("");
	}

}
