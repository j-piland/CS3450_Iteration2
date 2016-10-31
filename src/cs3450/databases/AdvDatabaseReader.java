package cs3450.databases;

import java.sql.Connection;

public interface AdvDatabaseReader{
	public Connection connectSQL(String databaseType, String tableAddress, String username, String password);
}
