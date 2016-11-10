package cs3450.databases;

import java.sql.Connection;
import java.util.Vector;

import cs3450.resources.User;

public class DatabaseHandler implements DatabaseReader {
	
	DatabaseAdapter databaseAdapter;
	
	public Connection connect(String databaseType, String tableAddress, String username, String password) {
		
		if(databaseType.equalsIgnoreCase("sql")){
			databaseAdapter = new DatabaseAdapter("sql");
			return databaseAdapter.connect(databaseType, tableAddress, username, password);
		}
		return null;
	}

	@Override
	public User getUser(String databaseType, Connection db, String username, String ID) {
		if(databaseType.equalsIgnoreCase("sql")){
			databaseAdapter = new DatabaseAdapter("sql");
			return databaseAdapter.getUser(databaseType, db, username, ID);
		}
		return null;
	}
	
	@Override
	public Vector<User> getAllUsersSQL(String databaseType, Connection db){
		if(databaseType.equalsIgnoreCase("sql")){
			databaseAdapter = new DatabaseAdapter("sql");
			return databaseAdapter.getAllUsersSQL(databaseType, db);
		}
		return null;
	}
	
	@Override
	public Vector<User> deleteUserByID(String databaseType, Connection db, String ID){
		if(databaseType.equalsIgnoreCase("sql")){
			databaseAdapter = new DatabaseAdapter("sql");
			return databaseAdapter.deleteUserByID(databaseType, db, ID);
		}
		return null;
	}
	
	@Override
	public void addUserSQL(String databaseType, Connection db, User toAdd){
		if(databaseType.equalsIgnoreCase("sql")){
			databaseAdapter = new DatabaseAdapter("sql");
			databaseAdapter.addUserSQL(databaseType, db, toAdd);
			System.out.println("User added");
		}
	}

}
