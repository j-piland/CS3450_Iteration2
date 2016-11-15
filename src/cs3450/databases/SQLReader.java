package cs3450.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import cs3450.resources.Global;
import cs3450.resources.Item;
import cs3450.resources.User;

public class SQLReader implements AdvDatabaseReader{
	Global global;

	//For user table
	public static int STOREID = 1;
	public static int USERNAME = 2;
	public static int STATUS = 3;
	public static int NAME = 4;
	public static int ADDRESS = 5;
	public static int PHONE = 6;
	public static int CURRENTPASSWORD = 7;
	
	//For passwords table
	public static int PASSWORD = 2;
	
	
	
	
	public Connection connectSQL(String databaseType, String tableAddress, String username, String password){
	
		Connection db = null;
		
		try {
			db = DriverManager.getConnection(tableAddress, username, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The SQL connection failed and I am sad\n");
		}
		
		return db;
	}
	
	
	
	
	
	
	public User getUserSQL(String databaseType, Connection db, String username, String ID){		
		User toReturn = new User();
		String toSearch = new String();
		String searchValue = new String();
		
		if(username != null){
			toSearch = "username";
			searchValue = username;
		}else{
			toSearch = "ID";
			searchValue = ID;
		}
		
		try{			
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users WHERE " + toSearch + " = '" + searchValue + "'");
			
			if (rs.next()){
				toReturn.ID =				rs.getString(STOREID);
				toReturn.username =			rs.getString(USERNAME);
				toReturn.status =			rs.getString(STATUS);
				toReturn.name = 			rs.getString(NAME);
				toReturn.address = 			rs.getString(ADDRESS);
				toReturn.phone = 			rs.getString(PHONE);
				toReturn.currentPassword = 	rs.getString(CURRENTPASSWORD);
			
			}else{
				System.out.println("No matching user found.");
			}
			
			/*
			st = db.createStatement();
			rs = st.executeQuery("SELECT " + toReturn.username + " FROM passwords");
			
			if (rs.next()){
				do{
					toReturn.passwords.addElement(rs.getString(PASSWORD));
				}while(rs.next());
			}
			*/
		}catch(SQLException e){
			System.out.println("get User exception");
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public Vector<User> getAllUsersSQL(String databaseType, Connection db){		
		Vector<User> toReturn = new Vector<User>();
		User temp = new User();
		
		try{			
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users");
			
			if (rs.next()){
				do{
					temp.ID =				rs.getString(STOREID);
					temp.username =			rs.getString(USERNAME);
					temp.status =			rs.getString(STATUS);
					temp.name = 			rs.getString(NAME);
					temp.address = 			rs.getString(ADDRESS);
					temp.phone = 			rs.getString(PHONE);
					temp.currentPassword = 	rs.getString(CURRENTPASSWORD);
				
					toReturn.addElement(temp);
				}while(rs.next());
			}else{
				System.out.println("No users in database.");
			}
			
		}catch(SQLException e){
			System.out.println("get User exception");
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public Vector<User> deleteUserByID(String databaseType, Connection db, String ID){
		Vector<User> toReturn = new Vector<User>();
		
		try {
			db.setAutoCommit(false);
			
			Statement st = db.createStatement();
			
			if((JOptionPane.showConfirmDialog(null, "Are you sure you want to delete user: " + ID + "?", "Delete Warning", JOptionPane.OK_CANCEL_OPTION))==JOptionPane.OK_OPTION){
				st.executeUpdate("DELETE FROM users * WHERE storeid = \'" + ID +"\'");
				db.commit();
				JOptionPane.showMessageDialog(null, "User has been deleted", "User Deleted", JOptionPane.WARNING_MESSAGE);
				//st.executeUpdate("DELETE FROM passwords * WHERE name = \'" + ID + "\'");
				//db.commit();
			}
			
			toReturn = getAllUsersSQL(databaseType, db);
			
			db.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public void addUserSQL(String databaseType, Connection db, User toAdd){
		String searcher = "INSERT INTO userinfo (id, username, status, name, address, phone, currentpassword) VALUES (\'" + toAdd.ID
				+ "\', \'" + toAdd.username + "\', \'" + toAdd.status + "\', \'" +
				toAdd.name + "\', \'" + toAdd.address + "\', \'" + toAdd.phone + "\', \'" + toAdd.currentPassword + "\')";
		try {
			db.setAutoCommit(false);
	
			Statement st = db.createStatement();
			System.out.println(searcher);
			st.executeUpdate(searcher);
			db.commit();
			
			db.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Item getItemSQL(String databaseType, Connection db, int productID){
		Item toReturn = new Item();
		
		try{
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Inventory WHERE productID = " + productID);
			
			if(rs.next()){
				toReturn.productID = rs.getInt(1);
				toReturn.name = rs.getString(2);
				toReturn.buyPrice = rs.getDouble(3);
				toReturn.sellPrice = rs.getDouble(4);
				toReturn.salePrice = rs.getDouble(5);
				toReturn.quantity = rs.getInt(6);
				toReturn.tax = rs.getDouble(7);
				toReturn.providerID = rs.getInt(8);
			} else {
				System.out.println("No Item Found");
				toReturn = null;
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
}
