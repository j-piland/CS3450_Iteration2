package cs3450.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLReader implements AdvDatabaseReader{
	
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
}
