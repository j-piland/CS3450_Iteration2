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

import cs3450.accountmanagercards.AdminAccountDisplayCard;
import cs3450.accountmanagercards.AdminAccountNewCard;
import cs3450.accountmanagercards.AdminAccountUpdateCard;
import cs3450.adminmenus.AdminCheckoutCard;
import cs3450.adminmenus.AdminMainMenuCard;
import cs3450.clerkmenus.ClerkCheckoutMenu;
import cs3450.clerkmenus.ClerkMainMenuCard;
import cs3450.clerkmenus.ClerkUpdateMenuCard;
import cs3450.databases.DatabaseHandler;
import cs3450.login.LoginCard;
import cs3450.login.LoginFunctions;
import cs3450.resources.Global;
import cs3450.resources.User;
import cs3450.welcomescreen.WelcomeCard;
import historycards.HistoryManager;
import inventorycards.InventoryAddCard;
import inventorycards.InventoryManager;
import inventorycards.InventoryUpdateCard;

@SuppressWarnings("serial")
public class StoreManager2 extends JFrame implements ActionListener, MouseListener, ItemListener {
	// "View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"
	private static final int VIEWALL = 0;
	private static final int SEARCHBYID = 1;
	private static final int SEARCHBYNAME = 2;
	private static final int ADD = 3;
	private static final int UPDATE = 4;
	private static final int DELETE = 5;

	public Global global = new Global();
	private DatabaseHandler databaseHandler = new DatabaseHandler();

	private Container pane;
	private JPanel deck;
	private CardLayout cl;

	private WelcomeCard welcomeCard = new WelcomeCard();
	private LoginCard loginCard = new LoginCard();
	private AdminMainMenuCard adminMainMenuCard = new AdminMainMenuCard();
	private ClerkMainMenuCard clerkMainMenuCard = new ClerkMainMenuCard();
	private AdminCheckoutCard adminCheckoutCard = new AdminCheckoutCard();
	private ClerkCheckoutMenu clerkCheckoutCard = new ClerkCheckoutMenu();
	private ClerkUpdateMenuCard	clerkUpdateMenuCard = new ClerkUpdateMenuCard();

	private AdminAccountDisplayCard adminAccountDisplayCard = new AdminAccountDisplayCard();
	private AdminAccountNewCard adminAccountNewCard = new AdminAccountNewCard();
	private AdminAccountUpdateCard adminAccountUpdateCard = new AdminAccountUpdateCard();

	private InventoryManager inventoryDisplayCard = new InventoryManager();
	private InventoryAddCard inventoryAddCard = new InventoryAddCard();
	private InventoryUpdateCard inventoryUpdateCard = new InventoryUpdateCard();

	private HistoryManager historyDisplayCard = new HistoryManager();

	private LoginFunctions loginFunctions;

	@SuppressWarnings("static-access")
	public StoreManager2() {

		global.database = databaseHandler.connect("SQL", "jdbc:postgresql:iteration3", "postgres", "123");

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
		 * How to add a card card = new Card();
		 * card.buttonOrWhatever.addActionListener(this); deck.add(card,
		 * "StringName")
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

		adminCheckoutCard.getACaddItemButton().addActionListener(this);
		adminCheckoutCard.getACbackButton().addActionListener(this);
		adminCheckoutCard.getAClogoutButton().addActionListener(this);
		adminCheckoutCard.getACremoveItemButton().addActionListener(this);
		adminCheckoutCard.getACprintReceiptButton().addActionListener(this);
		adminCheckoutCard.getACfromRecieptButton().addActionListener(this);
		deck.add(adminCheckoutCard, "adminCheckoutCard");

		clerkCheckoutCard.getCCaddItemButton().addActionListener(this);
		clerkCheckoutCard.getCCremoveItemButton().addActionListener(this);
		clerkCheckoutCard.getCCprintReceiptButton().addActionListener(this);
		clerkCheckoutCard.getCClogoutButton().addActionListener(this);
		clerkCheckoutCard.getCCbackButton().addActionListener(this);
		clerkCheckoutCard.getCCfromReceiptButton().addActionListener(this);
		deck.add(clerkCheckoutCard, "clerkCheckoutCard");
		
		clerkUpdateMenuCard.getCUupdateButton().addActionListener(this);
		clerkUpdateMenuCard.getCUbackButton().addActionListener(this);
		clerkUpdateMenuCard.getCUlogoutButton().addActionListener(this);
		deck.add(clerkUpdateMenuCard, "clerkUpdateMenuCard");
		
		adminAccountDisplayCard.getAMbackButton().addActionListener(this);
		adminAccountDisplayCard.getAMexecute().addActionListener(this);
		deck.add(adminAccountDisplayCard, "adminAccountDisplayCard");

		adminAccountNewCard.getADaddButton().addActionListener(this);
		adminAccountNewCard.getADbackButton().addActionListener(this);
		adminAccountNewCard.getADexecuteButton().addActionListener(this);
		deck.add(adminAccountNewCard, "adminAccountNewCard");

		adminAccountUpdateCard.getAUbackButton().addActionListener(this);
		adminAccountUpdateCard.getAUexecuteButton().addActionListener(this);
		adminAccountUpdateCard.getAUupdateButton().addActionListener(this);
		deck.add(adminAccountUpdateCard, "adminAccountUpdateCard");

		inventoryDisplayCard.getIMbackButton().addActionListener(this);
		inventoryDisplayCard.getexecuteBtn().addActionListener(this);
		deck.add(inventoryDisplayCard, "inventoryDisplayCard");

		inventoryUpdateCard.getAUexecuteButton().addActionListener(this);
		inventoryUpdateCard.getAUbackButton().addActionListener(this);
		inventoryUpdateCard.getAUupdateButton().addActionListener(this);
		deck.add(inventoryUpdateCard, "inventoryUpdateCard");

		inventoryAddCard.getADaddButton().addActionListener(this);
		inventoryAddCard.getADbackButton().addActionListener(this);
		inventoryAddCard.getADexecuteButton().addActionListener(this);
		deck.add(inventoryAddCard, "inventoryAddCard");

		historyDisplayCard.getHMbackButton().addActionListener(this);
		historyDisplayCard.getexecuteBtn().addActionListener(this);
		deck.add(historyDisplayCard, "historyDisplayCard");

		pane.add(deck, BorderLayout.CENTER);
		cl = (CardLayout) (deck.getLayout());
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
		// The Various Exit Buttons
		if (e.getSource() == welcomeCard.getWExitButton() || e.getSource() == loginCard.getLExitButton()
				|| e.getSource() == clerkMainMenuCard.getCMexitButton()
				|| e.getSource() == adminMainMenuCard.getAAexitButton()) {
			System.exit(0);
		}

		// Welcome Card Login
		if (e.getSource() == welcomeCard.getWLoginButton()) {
			cl.show(deck, "login");
		}

		// Attempt to login
		if (e.getSource() == loginCard.getLAcceptButton()) {

			loginFunctions.attemptLogin(loginCard.getUsername(), loginCard.getPassword());

			if (global.currentUser.status.equalsIgnoreCase("none")) {

			} else if (global.currentUser.status.equalsIgnoreCase("admin")) {
				cl.show(deck, "adminMainMenuCard");
			} else if (global.currentUser.status.equalsIgnoreCase("clerk")) {
				cl.show(deck, "clerkMainMenuCard");
			}
		}

		// Admin menu functions
		if (e.getSource() == adminMainMenuCard.getAAcheckoutButton()) {
			cl.show(deck, "adminCheckoutCard");
		}

		if (e.getSource() == adminMainMenuCard.getAAaccountButton()) {
			adminAccountDisplayCard.setAMbox(VIEWALL);
			adminAccountDisplayCard.setAMsearch("");
			cl.show(deck, "adminAccountDisplayCard");
		}
		if (e.getSource() == adminMainMenuCard.getAAhistoryButton()) {
			cl.show(deck, "historyDisplayCard");
		}
		if (e.getSource() == adminMainMenuCard.getAAinventoryButton()) {
			cl.show(deck, "inventoryDisplayCard");
		}
		if (e.getSource() == adminMainMenuCard.getAAlogoutButton()) {
			cl.show(deck, "login");
		}

		// Clerk menu functions
		if (e.getSource() == clerkMainMenuCard.getCMcheckoutButton()) {
			cl.show(deck, "clerkCheckoutCard");
		}
		if (e.getSource() == clerkMainMenuCard.getCMupdateButton()) {

		}
		if (e.getSource() == clerkMainMenuCard.getCMlogoutButton()) {
			cl.show(deck, "login");
		}

		// Admin Checkout Functions
		if (e.getSource() == adminCheckoutCard.getACaddItemButton()) {
			adminCheckoutCard.addItem();
		}
		if (e.getSource() == adminCheckoutCard.getACremoveItemButton()) {
			adminCheckoutCard.removeItem();
		}
		if (e.getSource() == adminCheckoutCard.getACprintReceiptButton()) {
			adminCheckoutCard.printReciept();
		}
		if (e.getSource() == adminCheckoutCard.getAClogoutButton()) {
			cl.show(deck, "login");
		}
		if (e.getSource() == adminCheckoutCard.getACbackButton()) {
			cl.show(deck, "adminMainMenuCard");
		}
		if(e.getSource() == adminCheckoutCard.getACfromRecieptButton()){
			adminCheckoutCard.onlineOrder();
		}

		// Clerk Checkout Functions
		if (e.getSource() == clerkCheckoutCard.getCCaddItemButton()) {
			clerkCheckoutCard.addItem();
		}
		if (e.getSource() == clerkCheckoutCard.getCCremoveItemButton()) {
			clerkCheckoutCard.removeItem();
		}
		if (e.getSource() == clerkCheckoutCard.getCCprintReceiptButton()) {
			clerkCheckoutCard.printReciept();
		}
		if (e.getSource() == clerkCheckoutCard.getCCbackButton()) {
			cl.show(deck, "clerkMainMenuCard");
		}
		if (e.getSource() == clerkCheckoutCard.getCClogoutButton()) {
			cl.show(deck, "login");
		}
		if(e.getSource()==clerkCheckoutCard.getCCfromReceiptButton()){
			clerkCheckoutCard.onlineOrder();
		}

		// Admin Account Functions
		if (e.getSource() == inventoryDisplayCard.getIMbackButton()) {
			cl.show(deck, "adminMainMenuCard");
		}

		if (e.getSource() == inventoryDisplayCard.getexecuteBtn()) {
			int execReturn = inventoryDisplayCard.execute();
			if (execReturn == 1) { // add
				cl.show(deck, "inventoryAddCard");
			} else if (execReturn == 2) { // update
				cl.show(deck, "inventoryUpdateCard");
			}
		}
		
		//Admin Account Functions
		if(e.getSource()==adminAccountDisplayCard.getAMbackButton()){
			cl.show(deck, "adminMainMenuCard");
		}
		
		if(e.getSource()==adminAccountDisplayCard.getAMexecute()){
			if(adminAccountDisplayCard.getAMbox()==UPDATE){
				adminAccountUpdateCard.setAUbox(adminAccountDisplayCard.getAMbox());
				adminAccountUpdateCard.setAUsearch(adminAccountDisplayCard.getAMsearch());
				cl.show(deck, "adminAccountUpdateCard");
			}else if(adminAccountDisplayCard.getAMbox()==ADD){
				adminAccountNewCard.setADbox(adminAccountDisplayCard.getAMbox());
				adminAccountNewCard.setADsearch(adminAccountDisplayCard.getAMsearch());
				cl.show(deck, "adminAccountNewCard");
			}else{
				adminAccountDisplayCard.display();
			}
		}
		
		if(e.getSource()==adminAccountNewCard.getADexecuteButton()){
			if(adminAccountNewCard.getADbox()==UPDATE){
				adminAccountUpdateCard.setAUbox(adminAccountNewCard.getADbox());
				adminAccountUpdateCard.setAUsearch(adminAccountNewCard.getADsearch());
				cl.show(deck, "adminAccountUpdateCard");
			}else if(adminAccountNewCard.getADbox()==ADD){
				adminAccountNewCard.addNewUser();
			}else{
				adminAccountDisplayCard.setAMbox(adminAccountNewCard.getADbox());
				adminAccountDisplayCard.setAMsearch(adminAccountNewCard.getADsearch());
				cl.show(deck, "adminAccountDisplayCard");
				adminAccountDisplayCard.display();
			}
		}
		
		if(e.getSource()==adminAccountNewCard.getADaddButton()){
			adminAccountNewCard.addNewUser();
		}
		
		if(e.getSource()==adminAccountUpdateCard.getAUexecuteButton()){
			if(adminAccountUpdateCard.getAUbox()==UPDATE){
				adminAccountUpdateCard.updateUser();
			}else if(adminAccountUpdateCard.getAUbox()==ADD){
				adminAccountNewCard.setADbox(adminAccountUpdateCard.getAUbox());
				adminAccountNewCard.setADsearch(adminAccountUpdateCard.getAUsearch());
				cl.show(deck, "adminAccountNewCard");
			}else{
				adminAccountDisplayCard.setAMbox(adminAccountUpdateCard.getAUbox());
				adminAccountDisplayCard.setAMsearch(adminAccountUpdateCard.getAUsearch());
				cl.show(deck, "adminAccountDisplayCard");
				adminAccountDisplayCard.display();
			}
		}
		
		if(e.getSource()==adminAccountUpdateCard.getAUupdateButton()){
			adminAccountUpdateCard.updateUser();
		}
		//Clerk Update Menu
		if(e.getSource()==clerkUpdateMenuCard.getCUbackButton()){
			cl.show(deck, "clerkMainMenuCard");
		}
		
		if(e.getSource()==clerkUpdateMenuCard.getCUlogoutButton()){
			cl.show(deck, "login");
		}
		
		if(e.getSource()==clerkUpdateMenuCard.getCUupdateButton()){
			clerkUpdateMenuCard.changePassword();
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
