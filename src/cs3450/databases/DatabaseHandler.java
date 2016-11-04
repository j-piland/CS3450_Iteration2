package cs3450.databases;

import java.sql.Connection;

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

}
