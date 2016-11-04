package cs3450.databases;

import java.sql.Connection;

import cs3450.resources.User;

public class DatabaseAdapter implements DatabaseReader {
	
	AdvDatabaseReader advDatabaseReader;
	
	public DatabaseAdapter(String databaseType){
		if(databaseType.equalsIgnoreCase("sql")){
			advDatabaseReader = new SQLReader();
		}
	}
	
	@Override
	public Connection connect(String databaseType, String tableAddress, String username, String password) {
		if(databaseType.equalsIgnoreCase("sql")){
			return advDatabaseReader.connectSQL(databaseType, tableAddress, username, password);
		}
		return null;
	}

	@Override
	public User getUser(String databaseType, Connection db, String username, String ID) {
		if(databaseType.equalsIgnoreCase("sql")){
			return advDatabaseReader.getUserSQL(databaseType, db, username, ID);
		}
		return null;
	}

}
