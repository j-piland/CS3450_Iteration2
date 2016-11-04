package cs3450.login;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import cs3450.databases.DatabaseHandler;
import cs3450.resources.Global;
import cs3450.resources.User;

public class LoginFunctions {
	private int logins; 
	Global global;
	DatabaseHandler databaseHandler;
	
	public LoginFunctions(){
		logins = 0;
		databaseHandler = new DatabaseHandler();
	}
	
	@SuppressWarnings("static-access")
	public void attemptLogin(String handedUsername, String password){
	

		User temp = databaseHandler.getUser("SQL", global.database, handedUsername, null);
		
		
		if(temp.currentPassword != null){
			if(temp.currentPassword.equals(password)){
				global.currentUser=temp;
			}else{
				timeout();
			}
		}else{
			timeout();
		}
	}
	
	public void timeout(){
		logins++;
		
		if (logins >= 5){
			JOptionPane.showMessageDialog(null, "Login has failed 5 times. Please wait 30 seconds.", "Login Timeout", JOptionPane.WARNING_MESSAGE);
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logins=0;
		}else{
			JOptionPane.showMessageDialog(null, "Login Failed\nPassword or Username incorrect", "Login Failure", JOptionPane.WARNING_MESSAGE);
		}
	}

}
