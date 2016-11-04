package cs3450.iteration2.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cs3450.adminmenus.AdminMainMenuCard;
import cs3450.clerkmenus.ClerkMainMenuCard;
import cs3450.databases.DatabaseHandler;
import cs3450.login.LoginCard;
import cs3450.login.LoginFunctions;
import cs3450.resources.Global;
import cs3450.resources.User;
import cs3450.welcomescreen.WelcomeCard;

@SuppressWarnings("serial")
public class StoreManager2  extends JFrame implements ActionListener, MouseListener, ItemListener{
	
	public Global global = new Global();
	private DatabaseHandler databaseHandler = new DatabaseHandler();
	
	private Container pane;
	private JPanel deck;
	private CardLayout cl;
	
	private WelcomeCard welcomeCard = new WelcomeCard();
	private LoginCard loginCard = new LoginCard();
	private AdminMainMenuCard adminMainMenuCard = new AdminMainMenuCard();
	private ClerkMainMenuCard clerkMainMenuCard = new ClerkMainMenuCard();
	
	private LoginFunctions loginFunctions;
	
	@SuppressWarnings("static-access")
	public StoreManager2(){
		
		global.database = databaseHandler.connect("SQL", "jdbc:postgresql:iteration_2", "postgres", "123");
		
		global.currentUser = new User();
		global.currentUser.status = "none";
		
		this.setTitle("StoreManager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.setPreferredSize(new Dimension(640, 480));
		deck = new JPanel(new CardLayout());
		
		
		/**
		 * How to add a card
		 * card = new Card();
		 * card.buttonOrWhatever.addActionListener(this);
		 * deck.add(card, "StringName")
		 */
		
		welcomeCard.getWExitButton().addActionListener(this);
		welcomeCard.getWLoginButton().addActionListener(this);
		deck.add(welcomeCard, "welcome");
		
		loginCard.getLExitButton().addActionListener(this);
		loginCard.getLAcceptButton().addActionListener(this);
		deck.add(loginCard, "login");
		loginFunctions = new LoginFunctions();
		
		
		adminMainMenuCard.getAAaccountButton().addActionListener(this);
		adminMainMenuCard.getAAcheckoutButton().addActionListener(this);
		adminMainMenuCard.getAAinventoryButton().addActionListener(this);
		adminMainMenuCard.getAAhistoryButton().addActionListener(this);
		adminMainMenuCard.getAAlogoutButton().addActionListener(this);
		adminMainMenuCard.getAAexitButton().addActionListener(this);
		deck.add(adminMainMenuCard, "adminMainMenuCard");
		
		clerkMainMenuCard.getCMcheckoutButton().addActionListener(this);
		clerkMainMenuCard.getCMupdateButton().addActionListener(this);
		clerkMainMenuCard.getCMlogoutButton().addActionListener(this);
		clerkMainMenuCard.getCMexitButton().addActionListener(this);
		deck.add(clerkMainMenuCard, "clerkMainMenuCard");
		
		
		pane.add(deck, BorderLayout.CENTER);
		cl= (CardLayout)(deck.getLayout());
		cl.show(deck, "Welcome");
		
		this.pack();
		this.setLocationRelativeTo(null);	
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new StoreManager2();
	}

	
	
	
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		//The Various Exit Buttons
		if(e.getSource()==welcomeCard.getWExitButton() || e.getSource()==loginCard.getLExitButton()){
			System.exit(0);
		}
		
		//Welcome Card Login
		if(e.getSource()==welcomeCard.getWLoginButton()){
			cl.show(deck, "login");
		}
		
		//Attempt to login
		if(e.getSource()==loginCard.getLAcceptButton()){
			
			loginFunctions.attemptLogin(loginCard.getUsername(), loginCard.getPassword());
		
			if(global.currentUser.status.equalsIgnoreCase("none")){
				
			}else if(global.currentUser.status.equalsIgnoreCase("admin")){
				cl.show(deck, "adminMainMenuCard");
			}else if(global.currentUser.status.equalsIgnoreCase("clerk")){
				cl.show(deck, "clerkMainMenuCard");
			}
		}
	}
	
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
