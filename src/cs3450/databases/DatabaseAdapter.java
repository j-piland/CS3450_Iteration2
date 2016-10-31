package cs3450.databases;

import java.sql.Connection;

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

}
