package cs3450.adminmenus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import cs3450.cardfunctions.CheckoutFunctions;
import cs3450.resources.Item;
import cs3450.resources.Receipt;

public class AdminCheckoutCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel title;
	private JPanel leftBar;
	private JButton CCaddItemButton;
	private JButton CCremoveItemButton;
	private JPanel bottomBar;
	private JButton ACprintReceiptButton;
	private JButton ACbackButton;
	private JButton AClogoutButton;
	private JTextArea ACItemDisplay;
	private JScrollPane ACScroll;
	private JButton ACfromReciept;
	
	private Vector<Item> itemList = new Vector<Item>(10,2);
	private Receipt receipt;
	
	private CheckoutFunctions checkoutFunctions = new CheckoutFunctions();
	
	public AdminCheckoutCard(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Checkout Item Display", SwingConstants.CENTER);
		
		leftBar = new JPanel();
		leftBar.setLayout(new GridLayout(3,1,0,100));
		CCaddItemButton = new JButton("Add");
		ACfromReciept = new JButton("Online Order");
		CCremoveItemButton = new JButton("Remove");
		leftBar.add(CCaddItemButton);
		leftBar.add(ACfromReciept);
		leftBar.add(CCremoveItemButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,3));
		ACprintReceiptButton = new JButton("Print");
		ACbackButton = new JButton("Back");
		AClogoutButton = new JButton("Logout");
		bottomBar.add(ACprintReceiptButton);
		bottomBar.add(ACbackButton);
		bottomBar.add(AClogoutButton);
		
		ACItemDisplay = new JTextArea(5,20);
		ACItemDisplay.setEditable(false);
		ACScroll = new JScrollPane(ACItemDisplay);
		
		this.add(title, BorderLayout.NORTH);
		this.add(leftBar, BorderLayout.WEST);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(ACScroll, BorderLayout.CENTER);
	}
	
	public JButton getACaddItemButton(){
		return CCaddItemButton;
	}
	
	public JButton getACremoveItemButton(){
		return CCremoveItemButton;
	}
	
	public JButton getACprintReceiptButton(){
		return ACprintReceiptButton;
	}
	
	public JButton getACbackButton(){
		return ACbackButton;
	}
	
	public JButton getAClogoutButton(){
		return AClogoutButton;
	}
	
	public void addItem(){
		itemList = checkoutFunctions.addItem(itemList);
		ACItemDisplay.setText(checkoutFunctions.display(itemList));
	}
	
	public void removeItem(){
		itemList = checkoutFunctions.removeItem(itemList);
		ACItemDisplay.setText(checkoutFunctions.display(itemList));
	}
	
	public void onlineOrder(){
		checkoutFunctions.onlineOrder();
	}
	
	public void printReciept(){
		checkoutFunctions.printReciept(itemList);
		ACItemDisplay.setText("");
	}

	public JButton getACfromRecieptButton() {
		return ACfromReciept;
	}

}
