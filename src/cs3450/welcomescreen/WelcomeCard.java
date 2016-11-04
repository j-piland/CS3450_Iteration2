package cs3450.welcomescreen;
	
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cs3450.resources.Global;

public class WelcomeCard extends JPanel{
	private static final long serialVersionUID = 1L;

	Global global;
	
	private JPanel bottomBar;
	private JLabel logo;
	private JButton wExit = new JButton("Exit");
	private JButton wlogin = new JButton("Login");
		
	public WelcomeCard(){
		setLayout(new BorderLayout());
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,3));
			
			
		logo = new JLabel(new ImageIcon("data/welcome1.png"));	
		this.add(logo, BorderLayout.CENTER);
			
		bottomBar.add(wlogin);
		bottomBar.add(wExit);
		this.add(bottomBar, BorderLayout.SOUTH);
	
	}
	
	public JButton getWExitButton(){
		return wExit;
	}
		
	public JButton getWLoginButton(){
		return wlogin;
	}

}

