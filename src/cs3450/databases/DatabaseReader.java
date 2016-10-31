package cs3450.databases;

import java.sql.Connection;

import cs3450.resources.User;

public interface DatabaseReader {
	public Connection connect (String databaseType, String tableAddress, String username, String password);
	public User getUser(String databaseType, Connection db, String username);
}
