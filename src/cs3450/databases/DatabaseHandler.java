package cs3450.databases;

import java.sql.Connection;

public class DatabaseHandler implements DatabaseReader {

	public Connection connect(String databaseType, String tableAddress, String username, String password) {
		
		DatabaseAdapter databaseAdapter;
		
		if(databaseType.equalsIgnoreCase("sql")){
			databaseAdapter = new DatabaseAdapter("sql");
			databaseAdapter.connect(databaseType, tableAddress, username, password);
		}
		return null;
	}

}
