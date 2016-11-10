package cs3450.clerkmenus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

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
	/**
	 * Class Members
	 */
	private Vector<String> displayV = new Vector<String>(10,2);
	private Vector<Integer> itemTracker = new Vector<Integer>(10,2);
	private Vector<Integer> itemQuanity	= new Vector<Integer>(10,2);
	private Vector<Double> itemPrice = new Vector<Double>(10,2);
	
	public ClerkCheckoutMenu(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Checkout Item Display", SwingConstants.CENTER);
		
		leftBar = new JPanel();
		leftBar.setLayout(new GridLayout(2,1,0,100));
		CCaddItemButton = new JButton("Add");
		CCremoveItemButton = new JButton("Remove");
		leftBar.add(CCaddItemButton);
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
	
	public JButton getCCbackButton(){
		return CCbackButton;
	}
}
