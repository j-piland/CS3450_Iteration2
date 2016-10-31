package cs3450.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cs3450.resources.User;

public class SQLReader implements AdvDatabaseReader{
	
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
			db = DriverManager.getConnection(tableAddress,username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The SQL connection failed and I am sad\n");
		}
		
		return db;
	}
	
	
	
	
	public User getUserSQL(String databaseType, Connection db, String username){
		User toReturn = new User();
		
		try{
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT " + username + " FROM users");
			
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
			
			st = db.createStatement();
			rs = st.executeQuery("SELECT " + username + " FROM passwords");
			
			if (rs.next()){
				do{
					toReturn.passwords.addElement(rs.getString(PASSWORD));
				}while(rs.next());
			}
			
		}catch(SQLException e){
			
		}
		
		return toReturn;
	}
	
	
	
	
}
