package cs3450.accountmanagercards;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cs3450.cardfunctions.AccountFunctions;

public class AdminAccountDisplayCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel AMinputPrompt;
	private JTextField AMsearch;
	@SuppressWarnings("rawtypes")
	private JComboBox accountOptions;
	private String [] optionsList;
	private JButton AMexecute;
	private JPanel buttonGrid;
	
	private JTextArea display;
	private JScrollPane AVscroll;
	
	private JLabel blank;
	private JButton AMbackButton;
	private JPanel bottomBar;
	
	private AccountFunctions accountFunctions = new AccountFunctions();
	
	private static final int VIEWALL = 0;
	private static final int SEARCHBYID = 1;
	private static final int SEARCHBYNAME = 2;
	private static final int ADD = 3;
	private static final int UPDATE = 4;
	private static final int DELETE = 5;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminAccountDisplayCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete by ID"};
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		AMinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(0);
		AMsearch = new JTextField();
		AMexecute = new JButton("Execute");
		buttonGrid.add(AMinputPrompt);
		buttonGrid.add(AMsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AMexecute);
		
		display = new JTextArea();
		display.setEditable(false);
		AVscroll = new JScrollPane(display);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		blank = new JLabel("");
		AMbackButton = new JButton("Back");
		bottomBar.add(blank);
		bottomBar.add(AMbackButton);

		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(AVscroll, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getAMbackButton(){
		return AMbackButton;
	}
	
	public JButton getAMexecute(){
		return AMexecute;
	}
	
	public void setAMbox(int a){
		accountOptions.setSelectedIndex(a);
	}
	
	public String getAMsearch(){
		return AMsearch.getText();
	}
	
	public void setAMsearch(String t){
		AMsearch.setText(t);
	}
	
	public int getAMbox(){
		return accountOptions.getSelectedIndex();
	}
	
	public void display(){
		display.setText("");
		if(accountOptions.getSelectedIndex()==VIEWALL){
			display.setText(accountFunctions.getAllUsers());
		}
		if(accountOptions.getSelectedIndex()==SEARCHBYID){
			display.setText(accountFunctions.getByID(AMsearch.getText()));
		}
		if(accountOptions.getSelectedIndex()==SEARCHBYNAME){
			display.setText(accountFunctions.getByName(AMsearch.getText()));
		}
		if(accountOptions.getSelectedIndex()==DELETE){
			display.setText(accountFunctions.deleteByID(AMsearch.getText()));
		}
	}
}
