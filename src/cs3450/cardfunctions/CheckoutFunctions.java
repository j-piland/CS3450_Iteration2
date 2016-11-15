package cs3450.cardfunctions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.swing.JOptionPane;

import cs3450.databases.DatabaseHandler;
import cs3450.resources.Global;
import cs3450.resources.Item;

public class CheckoutFunctions {
	//addItem
	//removeItem
	//printReceipt
	
	Global global;
	DatabaseHandler databaseHandler = new DatabaseHandler();
	
	public String display(Vector<Item> toUse){
		String toReturn = new String();
		
		for(int c=0; c<toUse.size(); c++){
			toReturn += toUse.get(c).name + " x " + toUse.get(c).currentSellQuantity + "\n";
		}
		
		return toReturn;
	}
	
	
	@SuppressWarnings("static-access")
	public Vector<Item> addItem(Vector<Item> toReturn){
		Item toAdd = new Item();
		
		int productID = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Item ID: ","Temporary Test Feature", JOptionPane.QUESTION_MESSAGE));
		int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "How many: ","Temporary Test Feature", JOptionPane.QUESTION_MESSAGE));
		
		toAdd = databaseHandler.getItem("sql", global.database, productID);
		
		if(JOptionPane.showConfirmDialog(null, "Is it on Sale") == JOptionPane.YES_OPTION){
			toAdd.sellPrice = toAdd.salePrice;
		}
		
		if(toAdd!=null){
			toReturn.addElement(toAdd);
			toReturn.lastElement().currentSellQuantity=quantity;
		}else{
			JOptionPane.showMessageDialog(null, "Failed to Find Item", "Alert", JOptionPane.ERROR_MESSAGE);
		}
		
		return toReturn;
	}

	public Vector<Item> removeItem(Vector<Item> itemList) {
		int itemId = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Item ID: ","Temporary Test Feature", JOptionPane.QUESTION_MESSAGE));
		int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "How many: ","Temporary Test Feature", JOptionPane.QUESTION_MESSAGE));
		
		boolean done = false;
		
		for (int c=0; c<itemList.size() && !done; c++){
			if(itemList.get(c).productID==itemId){
				while(itemList.get(c).currentSellQuantity>0 && quantity>0){
					itemList.get(c).currentSellQuantity--;
					quantity--;
				}
				
				if(itemList.get(c).currentSellQuantity<=0){
					itemList.remove(c);
				}
				
				if(quantity<=0){
					done=true;
				}
			}
		}
		
		return itemList;
	}


	public void printReciept(Vector<Item> itemList) {
		int recieptID = 0;
		double tax = 0;
		PrintWriter writer;
		String filename = "data/receipts/reciept" + recieptID;
		try {
			writer = new PrintWriter(filename, "UTF-8");
			
			writer.println("<insert store logo here>\n--------------------------\n\nReciept #: " + recieptID);
			
			for(int c=0; c<itemList.size(); c++){
				writer.println(itemList.get(c).name + " x " + itemList.get(c).currentSellQuantity + "\n");
			}
			
			double sum = 0;
			
			for(int c=0; c<itemList.size(); c++){
				sum+=((itemList.get(c).currentSellQuantity*itemList.get(c).sellPrice) + (itemList.get(c).currentSellQuantity*itemList.get(c).sellPrice) * itemList.get(c).tax);
				tax+= (itemList.get(c).currentSellQuantity*itemList.get(c).sellPrice) * itemList.get(c).tax;
			}
			
			writer.println("\n--------------------------\n Subtotal: " + sum + "\nTax: " + tax + "\n\nTotal: " + (sum+tax)+ "\n--------------------------\nHave a nice day!");
			
			JOptionPane.showMessageDialog(null, "Reciept Printed. Total: "+(sum+tax));
		
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
