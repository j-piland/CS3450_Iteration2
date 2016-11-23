package cs3450.cardfunctions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cs3450.accountmanagercards.AdminAccountUpdateCard;
import cs3450.databases.DatabaseHandler;
import cs3450.resources.Global;
import cs3450.resources.User;

public class AccountFunctions {
	public Global global;
	public DatabaseHandler databaseHandler = new DatabaseHandler();
	
	public String getAllUsers() {
		String results = "";
		Vector<User> toProcess = new Vector<User>();
		
		toProcess = databaseHandler.getAllUsersSQL("SQL", global.database);
		
		if(toProcess != null){
			for(int c=0; c<toProcess.size(); c++){
				results +=   "Employee: " + toProcess.get(c).name + "\n" +
							"Store ID Number: " + toProcess.get(c).ID + "\n" +
							"Status: " + toProcess.get(c).status + "\n" +
							"Username: " + toProcess.get(c).username + "\n" + 
							"Phone: " + toProcess.get(c).phone + "\n" +
							"Address: " + toProcess.get(c).address + "\n\n";
			}
		}else{
			results = "No Users to Display.";
		}
		return results;
	}

	public String getByID(String id) {
		String results = "";
		User temp = new User();
		temp = databaseHandler.getUser("SQL", global.database, null, id);
		if(temp !=null){
			results +=   "Employee: " + temp.name + "\n" +
					"Store ID Number: " + temp.ID + "\n" +
					"Status: " + temp.status + "\n" +
					"Username: " + temp.username + "\n" + 
					"Phone: " + temp.phone + "\n" +
					"Address: " + temp.address + "\n\n";
		}else{
			results = "No matching User Found.";
		}
		
		return results;
	}

	public String getByName(String name) {
		String results = "";
		User temp = new User();
		temp = databaseHandler.getUser("SQL", global.database, name, null);
		if(temp !=null){
			results +=   "Employee: " + temp.name + "\n" +
					"Store ID Number: " + temp.ID + "\n" +
					"Status: " + temp.status + "\n" +
					"Username: " + temp.username + "\n" + 
					"Phone: " + temp.phone + "\n" +
					"Address: " + temp.address + "\n\n";
		}else{
			results = "No matching User Found.";
		}
		
		return results;
	}
	
	public String deleteByID(String ID){
		
		String results = "";
		Vector<User> toProcess = new Vector<User>();
		
		toProcess = databaseHandler.deleteUserByID("sql", global.database, ID);
		
		for(User user : toProcess){
			results +=   "Employee: " + user.name + "\n" +
						"Store ID Number: " + user.ID + "\n" +
						"Status: " + user.status + "\n" +
						"Username: " + user.username + "\n" + 
						"Phone: " + user.phone + "\n" +
						"Address: " + user.address + "\n\n";
		}
		return results;
	}
	
	public String addUser(User toAdd){
		databaseHandler.addUserSQL("sql", global.database, toAdd);
		
		return getAllUsers();
	}
	
	public String updateUser(AdminAccountUpdateCard toUp){
		User temp = new User();
		User toReplace = new User();
		
		toReplace = databaseHandler.getUser("sql", global.database, null, toUp.getAUsearch());
		
		if(toUp.getCBID() != null){
			temp.ID=toUp.getTID();
		}else{
			temp.ID=toReplace.ID;
		}
		
		if(toUp.getCBUser() != null){
			temp.username=toUp.getTUsername();
		}else{
			temp.username=toReplace.username;
		}
		
		if(toUp.getcbg().getSelectedCheckbox()==toUp.getAdmin()){
			temp.status = "admin";
		}else if(toUp.getcbg().getSelectedCheckbox()==toUp.getClerk()){
			temp.status = "clerk";
		}else{
			temp.status=toReplace.status;
		}
		
		if(toUp.getCBName() != null){
			temp.name = toUp.getTName();
		}else{
			temp.name = toReplace.name;
		}
		
		if(toUp.getCBAddress() != null){
			temp.address=toUp.getTAddress();
		}else{
			temp.address=toReplace.address;
		}
		
		if(toUp.getCBPhone() != null){
			temp.phone=toUp.getTPhone();
		}else{
			temp.phone=toReplace.phone;
		}
		
		if(toUp.getCBPassword() != null){
			temp.currentPassword=toUp.getTPassword();
		}else{
			temp.currentPassword=toReplace.currentPassword;
		}
		
		databaseHandler.deleteUserByID("sql", global.database, toReplace.ID);
		
		databaseHandler.addUserSQL("sql", global.database, temp);
		
		return getAllUsers();
	}

}
