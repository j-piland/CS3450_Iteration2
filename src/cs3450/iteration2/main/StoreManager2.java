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

import cs3450.databases.DatabaseHandler;
import cs3450.resources.Global;

@SuppressWarnings("serial")
public class StoreManager2  extends JFrame implements ActionListener, MouseListener, ItemListener{
	
	public Global global;
	private DatabaseHandler databaseHandler = new DatabaseHandler();
	
	private Container pane;
	private JPanel deck;
	private CardLayout cl;
	
	public StoreManager2(){
		global.database = databaseHandler.connect("SQL", "placeholderaddress", "placeholderusername", "placeholderpassword");
		
		this.setTitle("StoreManager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.setPreferredSize(new Dimension(640, 480));
		deck = new JPanel(new CardLayout());
		
		
		/**
		 * How to add a card
		 * card = new Card(Global);
		 * card.buttonOrWhatever.addActionListener(this);
		 * deck.add(card, "StringName")
		 */
		
		
		
		
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
