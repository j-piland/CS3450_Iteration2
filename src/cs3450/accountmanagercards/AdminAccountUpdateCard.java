package cs3450.accountmanagercards;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cs3450.cardfunctions.AccountFunctions;

public class AdminAccountUpdateCard extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel AUinputPrompt;
	private JTextField AUsearch;
	@SuppressWarnings("rawtypes")
	private JComboBox accountOptions;
	private String [] optionsList;
	private JButton AUexecute;
	private JPanel buttonGrid;
	
	
	private JPanel optionsGrid;
	private JCheckBox cbID;
	private JCheckBox cbName;
	private JCheckBox cbPhone;
	private JCheckBox cbAddress;
	private JCheckBox cbUser;
	private JCheckBox cbPassword;
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

	
	private JPanel cbgPanel;
	private JLabel cbgLabel;
	private CheckboxGroup cbg;
	private Checkbox AUadmin;
	private Checkbox AUclerk;
	private Checkbox AUnochange;
	
	private JPanel bottomBar;
	private JButton AUupdateButton;
	private JButton AUbackButton;
	
	private AccountFunctions accountFunctions = new AccountFunctions();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminAccountUpdateCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"};
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		AUinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(3);
		AUsearch = new JTextField();
		AUexecute = new JButton("Execute");
		buttonGrid.add(AUinputPrompt);
		buttonGrid.add(AUsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AUexecute);	
		
		cbgPanel = new JPanel();
		cbgPanel.setLayout(new GridLayout(3,1));
		cbg = new CheckboxGroup();
		cbgPanel.add(cbgLabel = new JLabel("Status: "));
		cbgPanel.add(AUadmin = new Checkbox("Administrator", cbg, false));
		cbgPanel.add(AUclerk = new Checkbox("Clerk", cbg, false));
		cbgPanel.add(AUnochange = new Checkbox("No Change", cbg, true));
		
		optionsGrid = new JPanel();
		optionsGrid.setLayout(new GridLayout(7,4));
		optionsGrid.add(cbID = new JCheckBox());
		optionsGrid.add(lID = new JLabel("Store ID: "));
		optionsGrid.add(tID = new JTextField());
		optionsGrid.add(cbName = new JCheckBox());
		optionsGrid.add(lName = new JLabel("Full Name: "));
		optionsGrid.add(tName = new JTextField());
		optionsGrid.add(cbPhone = new JCheckBox());
		optionsGrid.add(lPhone = new JLabel("Phone: "));
		optionsGrid.add(tPhone = new JTextField());
		optionsGrid.add(cbAddress = new JCheckBox());
		optionsGrid.add(lAddress = new JLabel("Address: "));
		optionsGrid.add(tAddress = new JTextField());
		optionsGrid.add(cbUser = new JCheckBox());
		optionsGrid.add(lUser = new JLabel("User: "));
		optionsGrid.add(tUser = new JTextField());
		optionsGrid.add(cbPassword = new JCheckBox());
		optionsGrid.add(lPassword = new JLabel("Password: "));
		optionsGrid.add(tPassword = new JTextField());
		optionsGrid.add(cbgPanel);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		AUbackButton = new JButton("Back");
		AUupdateButton = new JButton("Update");
		bottomBar.add(AUupdateButton);
		bottomBar.add(AUbackButton);
		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(blank, BorderLayout.WEST);
		this.add(optionsGrid, BorderLayout.CENTER);
	}
	
	public void setAUbox(int a){
		accountOptions.setSelectedIndex(a);
	}
	
	public String getAUsearch(){
		return AUsearch.getText();
	}
	
	public void setAUsearch(String t){
		AUsearch.setText(t);
	}
	
	public JButton getAUexecuteButton(){
		return AUexecute;
	}
	
	public JButton getAUbackButton(){
		return AUbackButton;
	}
	
	public JButton getAUupdateButton(){
		return AUupdateButton;
	}
	
	public JCheckBox getCBID(){
		return cbID;
	}
	
	public JCheckBox getCBName(){
		return cbName;
	}
	
	public JCheckBox getCBPhone(){
		return cbPhone;
	}
	
	public JCheckBox getCBAddress(){
		return cbAddress;
	}
	
	public JCheckBox getCBUser(){
		return cbUser;
	}
	
	public JCheckBox getCBPassword(){
		return cbPassword;
	}
	
	public String getTID(){
		return tID.getText();
	}
	
	public String getTName(){
		return tName.getText();
	}
	
	public String getTPhone(){
		return tPhone.getText();
	}
	
	public String getTAddress(){
		return tAddress.getText();
	}
	
	public String getTUsername(){
		return tUser.getText();
	}
	
	public String getTPassword(){
		return tPassword.getText();
	}
	
	public CheckboxGroup getcbg(){
		return cbg;
	}
	
	public Checkbox getAdmin(){
		return AUadmin;
	}
	
	public Checkbox getClerk(){
		return AUclerk;
	}
	
	public int getAUbox(){
		return accountOptions.getSelectedIndex();
	}
	
	public void updateUser(){
		accountFunctions.updateUser(this);
	}
}
