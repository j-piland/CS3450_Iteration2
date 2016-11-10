package cs3450.accountmanagercards;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cs3450.resources.User;

public class AdminAccountNewCard extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/**
	 * GUI components
	 */
	
	private JLabel ADinputPrompt;
	private JTextField ADsearch;
	private JComboBox accountOptions;
	private String [] optionsList;
	private JButton AUexecute;
	private JPanel buttonGrid;

	
	private JPanel cbgPanel;
	private JLabel cbgLabel;
	private CheckboxGroup cbg;
	private Checkbox ADadmin;
	private Checkbox ADclerk;
	
	private JPanel optionsGrid;
	private JLabel lID;
	private JLabel lName;
	private JLabel lPhone;
	private JLabel lAddress;
	private JLabel lUser;
	private JLabel lPassword;
	private JTextField tID;
	private JTextField tName;
	private JTextField tPhone;
	private JTextField tAddress;
	private JTextField tUser;
	private JTextField tPassword;
	private JLabel blank = new JLabel("               ");
	
	private JPanel bottomBar;
	private JButton ADaddButton;
	private JButton ADbackButton;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminAccountNewCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"};
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		ADinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(3);
		ADsearch = new JTextField();
		AUexecute = new JButton("Execute");
		buttonGrid.add(ADinputPrompt);
		buttonGrid.add(ADsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AUexecute);	
		
		cbgPanel = new JPanel();
		cbgPanel.setLayout(new GridLayout(3,1));
		cbg = new CheckboxGroup();
		cbgPanel.add(cbgLabel = new JLabel("Status: "));
		cbgPanel.add(ADadmin = new Checkbox("Administrator", cbg, false));
		cbgPanel.add(ADclerk = new Checkbox("Clerk", cbg, true));
		
		optionsGrid = new JPanel();
		optionsGrid.setLayout(new GridLayout(7,2));
		optionsGrid.add(lID = new JLabel("Store ID: "));
		optionsGrid.add(tID = new JTextField());
		optionsGrid.add(lName = new JLabel("Full Name: "));
		optionsGrid.add(tName = new JTextField());
		optionsGrid.add(lPhone = new JLabel("Phone: "));
		optionsGrid.add(tPhone = new JTextField());
		optionsGrid.add(lAddress = new JLabel("Address: "));
		optionsGrid.add(tAddress = new JTextField());
		optionsGrid.add(lUser = new JLabel("User: "));
		optionsGrid.add(tUser = new JTextField());
		optionsGrid.add(lPassword = new JLabel("Password: "));
		optionsGrid.add(tPassword = new JTextField());
		optionsGrid.add(cbgPanel);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		ADbackButton = new JButton("Back");
		ADaddButton = new JButton("Add");
		bottomBar.add(ADaddButton);
		bottomBar.add(ADbackButton);
		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(blank, BorderLayout.WEST);
		this.add(optionsGrid, BorderLayout.CENTER);
	}
	
	public void setADbox(int a){
		accountOptions.setSelectedIndex(a);
	}
	
	public String getADsearch(){
		return ADsearch.getText();
	}
	
	public void setADsearch(String t){
		ADsearch.setText(t);
	}
	
	public JButton getADexecuteButton(){
		return AUexecute;
	}
	
	public JButton getADbackButton(){
		return ADbackButton;
	}
	
	public JButton getADaddButton(){
		return ADaddButton;
	}
	
	public User getNewUser(){
		User temp = new User();
		Boolean procede = false;
		
		if( tID.getText().length()!=0 &&
			tName.getText().length()!=0 &&
			tPhone.getText().length()!=0 &&
			tAddress.getText().length()!=0 &&
			tUser.getText().length()!=0 &&
			tPassword.getText().length()!=0){
			procede = true;
		}
			
		if(!procede){
			JOptionPane.showMessageDialog(null, "Please Fill in All Fields.", "Alert", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		temp.ID = tID.getText();
		temp.name = tName.getText();
		temp.phone = tPhone.getText();
		temp.address = tAddress.getText();
		temp.username = tUser.getText();
		temp.currentPassword = tPassword.getText();
		if(cbg.getSelectedCheckbox()==ADadmin){
			temp.status = "admin";
		}
		if(cbg.getSelectedCheckbox()==ADclerk){
			temp.status = "Clerk";
		}
		
		return temp;
	}
}