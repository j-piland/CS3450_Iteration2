package cs3450.resources;

import java.util.Vector;

public class User {
	public String ID;
	public String username;
	public String status;
	public String name;
	public String address;
	public String phone;
	public String currentPassword;
	
	public Vector<String> passwords = new Vector<String>();
}
