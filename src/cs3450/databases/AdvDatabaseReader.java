package cs3450.databases;

import java.sql.Connection;

import cs3450.resources.User;

public interface AdvDatabaseReader{
	public Connection connectSQL(String databaseType, String tableAddress, String username, String password);
	public User getUserSQL(String databaseType, Connection db, String username);
}
