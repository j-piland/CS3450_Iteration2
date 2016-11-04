package cs3450.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cs3450.resources.Global;

public class LoginCard extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	Global global;
	
	private JButton lExitButton;
	private JButton lAcceptButton;
	private JTextField username = new JTextField();
	private JPasswordField password;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JPanel middleGrid;
	private JPanel bottomBar;
	
	public LoginCard(){
		
		this.setLayout(new BorderLayout());
		
		middleGrid = new JPanel();
		middleGrid.setLayout(new GridLayout(2,2,20,50));
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		password = new JPasswordField();
		password.setEchoChar('*');
		lAcceptButton = new JButton("Accept");
		lExitButton = new JButton("Exit");
		
		middleGrid.add(usernameLabel);
		middleGrid.add(username);
		middleGrid.add(passwordLabel);
		middleGrid.add(password);
		bottomBar.add(lAcceptButton);
		bottomBar.add(lExitButton);
		
		this.add(middleGrid, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getLExitButton(){
		return lExitButton;
	}
	
	public JButton getLAcceptButton(){
		return lAcceptButton;
	}
	
	public String getUsername(){
		return username.getText();
	}
	
	public String getPassword(){
		char [] temp = password.getPassword();
		String toReturn = new String(temp);		
		return toReturn;
	}
}
