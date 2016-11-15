package cs3450.databases;

import java.sql.Connection;
import java.util.Vector;

import cs3450.resources.Item;
import cs3450.resources.User;

public interface AdvDatabaseReader{
	public Connection connectSQL(String databaseType, String tableAddress, String username, String password);
	public User getUserSQL(String databaseType, Connection db, String username, String ID);
	public Vector<User> getAllUsersSQL(String databaseType, Connection db);
	public Vector<User> deleteUserByID(String databaseType, Connection db, String ID);
	public void addUserSQL(String databaseType, Connection db, User toAdd);
	public Item getItemSQL(String databaseType, Connection db, int productID);
}
