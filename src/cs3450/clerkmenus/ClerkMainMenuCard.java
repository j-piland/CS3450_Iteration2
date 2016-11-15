package cs3450.clerkmenus;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ClerkMainMenuCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel title;
	private JPanel buttonGrid;
	
	private JButton CMcheckoutButton;
	private JButton CMupdateButton;
	private JPanel bottomBar;
	private JButton CMlogoutButton;
	private JButton CMexitButton;
	
	
	public ClerkMainMenuCard(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Administrator Main Menu", SwingConstants.CENTER);
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(2,1));
		CMcheckoutButton = new JButton("Checkout");
		CMupdateButton = new JButton("Change Password");
		buttonGrid.add(CMcheckoutButton);
		buttonGrid.add(CMupdateButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		CMlogoutButton = new JButton("Logout");
		CMexitButton = new JButton("Exit");
		bottomBar.add(CMlogoutButton);
		bottomBar.add(CMexitButton);
		
		this.add(title, BorderLayout.NORTH);
		this.add(buttonGrid, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getCMcheckoutButton(){
		return CMcheckoutButton;
	}
	
	public JButton getCMupdateButton(){
		return CMupdateButton;
	}
	
	public JButton getCMlogoutButton(){
		return CMcheckoutButton;
	}
	
	public JButton getCMexitButton(){
		return CMexitButton;
	}

}