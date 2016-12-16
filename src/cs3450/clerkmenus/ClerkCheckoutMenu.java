package cs3450.clerkmenus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

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

public class ClerkCheckoutMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**GUI Members
	 * 
	 **/
	
	private JLabel title;
	private JPanel leftBar;
	private JButton CCaddItemButton;
	private JButton CCremoveItemButton;
	private JPanel bottomBar;
	private JButton CCprintReceiptButton;
	private JButton CCbackButton;
	private JButton CClogoutButton;
	private JTextArea CCItemDisplay;
	private JScrollPane CCScroll;
	private JButton CCfromReciept;
	/**
	 * Class Members
	 */
	private Vector<Item> itemList = new Vector<Item>(10,2);
	private Receipt receipt;
	
	private CheckoutFunctions checkoutFunctions = new CheckoutFunctions();
	
	public ClerkCheckoutMenu(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Checkout Item Display", SwingConstants.CENTER);
		
		leftBar = new JPanel();
		leftBar.setLayout(new GridLayout(3,1,0,100));
		CCaddItemButton = new JButton("Add");
		CCfromReciept = new JButton("Online Order");
		CCremoveItemButton = new JButton("Remove");
		leftBar.add(CCaddItemButton);
		leftBar.add(CCfromReciept);
		leftBar.add(CCremoveItemButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,3));
		CCprintReceiptButton = new JButton("Print");
		CCbackButton = new JButton("Back");
		CClogoutButton = new JButton("Logout");
		bottomBar.add(CCprintReceiptButton);
		bottomBar.add(CCbackButton);
		bottomBar.add(CClogoutButton);
		
		CCItemDisplay = new JTextArea(5,20);
		CCItemDisplay.setEditable(false);
		CCScroll = new JScrollPane(CCItemDisplay);
		
		this.add(title, BorderLayout.NORTH);
		this.add(leftBar, BorderLayout.WEST);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(CCScroll, BorderLayout.CENTER);
	}
	
	public JButton getCCaddItemButton(){		
		return CCaddItemButton;
	}
	
	public JButton getCCremoveItemButton(){
		return CCremoveItemButton;
	}
	
	public JButton getCCprintReceiptButton(){
		return CCprintReceiptButton;
	}
	
	public JButton getCClogoutButton(){
		return CClogoutButton;
	}
	
	public JButton getCCfromReceiptButton(){
		return CCfromReciept;
	}
	
	public JButton getCCbackButton(){
		return CCbackButton;
	}
	
	public void addItem(){
		itemList = checkoutFunctions.addItem(itemList);
		CCItemDisplay.setText(checkoutFunctions.display(itemList));
	}
	
	public void removeItem(){
		itemList = checkoutFunctions.removeItem(itemList);
		CCItemDisplay.setText(checkoutFunctions.display(itemList));
	}
	
	public void onlineOrder(){
		checkoutFunctions.onlineOrder();
	}
	
	public void printReciept(){
		checkoutFunctions.printReciept(itemList);
		CCItemDisplay.setText("");
	}
	
}
