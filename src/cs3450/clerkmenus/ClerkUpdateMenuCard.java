package cs3450.clerkmenus;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cs3450.databases.DatabaseHandler;
import cs3450.resources.Global;

public class ClerkUpdateMenuCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Global global;
	private DatabaseHandler databaseHandler = new DatabaseHandler();
	
	private JLabel title;
	private JPanel buttonGrid;
	
	private JLabel CUupdateLabel;
	private JTextField CUupdateFeild;
	private JLabel CUupdateLabel2;
	private JTextField CUupdateFeild2;
	private JButton CUupdateButton;
	private JPanel bottomBar;
	private JButton CUlogoutButton;
	private JButton CUbackButton;
	
	
	public ClerkUpdateMenuCard(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Change Password Menu", SwingConstants.CENTER);
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(3,2));
		CUupdateLabel = new JLabel("New Password:");
		CUupdateFeild = new JTextField();
		CUupdateLabel2 = new JLabel("Confirm Password: ");
		CUupdateFeild2 = new JTextField();
		CUupdateButton = new JButton("Update");
		buttonGrid.add(CUupdateLabel);
		buttonGrid.add(CUupdateFeild);
		buttonGrid.add(CUupdateLabel2);
		buttonGrid.add(CUupdateFeild2);
		buttonGrid.add(CUupdateButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		CUlogoutButton = new JButton("Logout");
		CUbackButton = new JButton("Button");
		bottomBar.add(CUbackButton);
		bottomBar.add(CUlogoutButton);
		
		this.add(title, BorderLayout.NORTH);
		this.add(buttonGrid, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getCUupdateButton(){
		return CUupdateButton;
	}
	
	public JButton getCUbackButton(){
		return CUbackButton;
	}
	
	public JButton getCUlogoutButton(){
		return CUlogoutButton;
	}
	
	@SuppressWarnings("static-access")
	public void changePassword(){
		if(CUupdateFeild.getText().equals(CUupdateFeild2.getText())){
			databaseHandler.deleteUserByID("sql", global.database, global.currentUser.ID);
			global.currentUser.currentPassword=CUupdateFeild.getText();
			databaseHandler.addUserSQL("sql", global.database, global.currentUser);
			JOptionPane.showMessageDialog(null, "Password Changed","Change", JOptionPane.PLAIN_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "Passwords Don't Match", "Alert", JOptionPane.WARNING_MESSAGE);
		}
	}
}
