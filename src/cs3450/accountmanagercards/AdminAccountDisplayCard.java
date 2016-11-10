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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminAccountDisplayCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"};
		
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
}
