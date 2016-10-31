package cs3450.databases;

import java.sql.Connection;

public interface DatabaseReader {
	public Connection connect (String databaseType, String tableAddress, String username, String password);
}
