package inventorycards;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InventoryUpdateCard extends JPanel {
	private JLabel AUinputPrompt;
	private JTextField AUsearch;
	private JComboBox accountOptions;
	private String[] optionsList;
	private JButton AUexecute;
	private JPanel buttonGrid;

	private JPanel optionsGrid;
	private JCheckBox cbID;
	private JCheckBox cbName;
	private JCheckBox cbBuyingPrice;
	private JCheckBox cbSellingPrice;
	private JCheckBox cbSalePrice;
	private JCheckBox cbQuantity;
	private JCheckBox cbTax;
	private JCheckBox cbProviderID;

	private JLabel lName;
	private JLabel lBuyingPrice;
	private JLabel lSellingPrice;
	private JLabel lSalePrice;
	private JLabel lQuantity;
	private JLabel lTax;
	private JLabel lProviderID;

	private JTextField tName;
	private JTextField tBuyingPrice;
	private JTextField tSellingPrice;
	private JTextField tSalePrice;
	private JTextField tQuantity;
	private JTextField tTax;
	private JTextField tProviderID;

	private JLabel blank = new JLabel("               ");

	private JPanel bottomBar;
	private JButton AUupdateButton;
	private JButton AUbackButton;

	public InventoryUpdateCard() {
		this.setLayout(new BorderLayout());

		optionsList = new String[] { "View All", "Search By Product ID", "Search by Product Name", "Add", "Edit",
				"Delete" };

		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1, 4));
		AUinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(3);
		AUsearch = new JTextField();
		AUexecute = new JButton("Execute");
		buttonGrid.add(AUinputPrompt);
		buttonGrid.add(AUsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AUexecute);

		optionsGrid = new JPanel();
		optionsGrid.setLayout(new GridLayout(7, 4));

		optionsGrid.add(cbName = new JCheckBox());
		optionsGrid.add(lName = new JLabel("Product Name: "));
		optionsGrid.add(tName = new JTextField());

		optionsGrid.add(cbBuyingPrice = new JCheckBox());
		optionsGrid.add(lBuyingPrice = new JLabel("Buying Price: "));
		optionsGrid.add(tBuyingPrice = new JTextField());

		optionsGrid.add(cbSellingPrice = new JCheckBox());
		optionsGrid.add(lSellingPrice = new JLabel("Selling Price: "));
		optionsGrid.add(tSellingPrice = new JTextField());

		optionsGrid.add(cbSalePrice = new JCheckBox());
		optionsGrid.add(lSalePrice = new JLabel("Sale Price: "));
		optionsGrid.add(tSalePrice = new JTextField());

		optionsGrid.add(cbQuantity = new JCheckBox());
		optionsGrid.add(lQuantity = new JLabel("Quantity: "));
		optionsGrid.add(tQuantity = new JTextField());

		optionsGrid.add(cbTax = new JCheckBox());
		optionsGrid.add(lTax = new JLabel("Tax: "));
		optionsGrid.add(tTax = new JTextField());

		optionsGrid.add(cbProviderID = new JCheckBox());
		optionsGrid.add(lProviderID = new JLabel("Provider ID: "));
		optionsGrid.add(tProviderID = new JTextField());

		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1, 2));
		AUbackButton = new JButton("Back");
		AUupdateButton = new JButton("Update");
		bottomBar.add(AUupdateButton);
		bottomBar.add(AUbackButton);

		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(blank, BorderLayout.WEST);
		this.add(optionsGrid, BorderLayout.CENTER);
	}

	public void setAUbox(int a) {
		accountOptions.setSelectedIndex(a);
	}

	public String getAUsearch() {
		return AUsearch.getText();
	}

	public void setAUsearch(String t) {
		AUsearch.setText(t);
	}

	public JButton getAUexecuteButton() {
		return AUexecute;
	}

	public JButton getAUbackButton() {
		return AUbackButton;
	}

	public JCheckBox getCBID() {
		return cbID;
	}

	public JCheckBox getCBName() {
		return cbName;
	}

	public JCheckBox getCBBuyingPrice() {
		return cbBuyingPrice;
	}

	public JCheckBox getCBSellingPrice() {
		return cbSellingPrice;
	}

	public JCheckBox getCBSalePrice() {
		return cbSalePrice;
	}

	public JCheckBox getCBQuantity() {
		return cbQuantity;
	}

	public JCheckBox getCBTax() {
		return cbTax;
	}

	public JCheckBox getCBProviderID() {
		return cbProviderID;
	}

	public JButton getAUupdateButton() {
		return AUupdateButton;
	}

	public int AUexecute() {
		// =======================================================
		if (accountOptions.getSelectedIndex() == 0) {
			return 0;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 1) {
			return 1;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 3) {
			return 3;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 5) {
			return 5;
		}
		// =======================================================
		if (accountOptions.getSelectedIndex() == 4) {
			if ((JOptionPane.showConfirmDialog(null, "Are you sure you want to make these updates?", "Update Warning",
					JOptionPane.OK_CANCEL_OPTION)) == JOptionPane.CANCEL_OPTION) {
				return 4;
			}

			Boolean procede = false;
			String searcher = new String("Update Inventory SET ");

			// Update testusers
			// Set id=id, ...
			// WHERE store id =

			if (cbName.isSelected() && tName.getText().length() != 0) {
				searcher += "Name = \'" + tName.getText() + "\', ";
				procede = true;
			}
			if (cbBuyingPrice.isSelected() && tBuyingPrice.getText().length() != 0) {
				searcher += "BuyingPrice = " + tBuyingPrice.getText() + ", ";
				procede = true;
			}
			if (cbSellingPrice.isSelected() && tSellingPrice.getText().length() != 0) {
				searcher += "SellingPrice = " + tSellingPrice.getText() + ", ";
				procede = true;
			}
			if (cbSalePrice.isSelected() && tSalePrice.getText().length() != 0) {
				searcher += "SalePrice = " + tSalePrice.getText() + ", ";
				procede = true;
			}
			if (cbQuantity.isSelected() && tQuantity.getText().length() != 0) {
				searcher += "Quantity = " + tQuantity.getText().hashCode() + ", ";
				procede = true;
			}
			if (cbTax.isSelected() && tTax.getText().length() != 0) {
				searcher += "Tax = " + tTax.getText().hashCode() + ", ";
				procede = true;
			}
			if (cbProviderID.isSelected() && tProviderID.getText().length() != 0) {
				searcher += "ProviderID = " + tProviderID.getText().hashCode() + ", ";
				procede = true;
			}

			if (!procede || AUsearch.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "No changes made.", "Alert", JOptionPane.ERROR_MESSAGE);
				return 4;
			}

			searcher = searcher.substring(0, searcher.length() - 2);
			searcher += " WHERE ProductID = " + AUsearch.getText();

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
				System.out.println(searcher);
				st.executeUpdate(searcher);
				db.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			JOptionPane.showMessageDialog(null, "Update Complete!", "Update Alert", JOptionPane.PLAIN_MESSAGE);
		}

		return 4;

	}
}
