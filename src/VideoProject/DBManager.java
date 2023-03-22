package VideoProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * This class contains all DB calls
 *
 */
public class DBManager {
	
	/**
	 * Login 
	 *
	 */
	
	public boolean loginCheck(String username , String password) {
		//establish connection with database
				
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			//prepare a statement to check username and password from users
			PreparedStatement checkCredentials = connection.prepareStatement("SELECT * FROM `users` "
					+ "WHERE LOWER(username) =  ? and LOWER(password) = ?;");
			checkCredentials.setString(1, username);
			checkCredentials.setString(2, password);
			
			ResultSet resultSet = checkCredentials.executeQuery();
			
			if (resultSet.next()) {				
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect username of password.", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return false;
	}
	
	/**
	 * Create New Client 
	 *
	 */
	
	public boolean userNameCheck(String username) {
		//function for validating non-duplicate username
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			//prepare query statement
			PreparedStatement checkUsername = connection.prepareStatement("SELECT * FROM `users` WHERE LOWER(username) =  ?;"); 
			checkUsername.setString(1, username);
			
			ResultSet resultSet = checkUsername.executeQuery();
			
			if (resultSet.next()) {			
				return false;				
			} else {				
				return true;
				
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return false;
		
	}
	
	public void addClient(String username, String password, String lastName, String firstName, String address, String email,
			String areaCode, String phone1, String phone2) {
		//add new client to the db
		
			try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			//prepare query statement
			PreparedStatement newClient = connection.prepareStatement("INSERT INTO `clients`(`username`, `password`, `lastName`, `firstName`, `address`, `email`, `areaCode`, `phone1`, `phone2`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			newClient.setString(1, username);
			newClient.setString(2, password);
			newClient.setString(3, lastName);
			newClient.setString(4, firstName);
			newClient.setString(5, address);
			newClient.setString(6, email);
			newClient.setString(7, areaCode);
			newClient.setString(8, phone1);
			newClient.setString(9, phone2);
			
			newClient.executeUpdate();	
			
			
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
					
	}
	
	public void addUser(String username, String password, int type) {
		//add user to users table
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
		
			PreparedStatement newUser = connection.prepareStatement("INSERT INTO `users`(`username`, `password`, `type`) VALUES (?, ?, ?);");
			newUser.setString(1,  username);
			newUser.setString(2, password);
			newUser.setLong(3, type);
			
			newUser.executeUpdate();	
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public int checkUserType(String username) {
		
		//determine the logged in user's type
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			PreparedStatement userType = connection.prepareStatement("SELECT type FROM `users` WHERE LOWER(username) =  ?;");
			userType.setString(1, username);
			
			ResultSet typeOfUser = userType.executeQuery();
			
			typeOfUser.next();
			
			
			int loggedUser = typeOfUser.getInt("type");
			
			return loggedUser;
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return -1;
		
	}
	
	/**
	 * Edit Client 
	 *
	 */
	
	public Client populateClientInfoEdit(String username) {
		//populate edit window with client data
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			PreparedStatement getClient = connection.prepareStatement("SELECT * FROM clients WHERE username = ?");
			getClient.setString(1, username);
			
			ResultSet populate = getClient.executeQuery();
			
			populate.next();
			String user = populate.getString("username");
			String password = populate.getString("password");
			String lastName = populate.getString("lastName");
			String firstName = populate.getString("firstName");
			String address = populate.getString("address");
			String email = populate.getString("email");
			String areaCode = populate.getString("areaCode");
			String phone1 = populate.getString("phone1");
			String phone2 = populate.getString("phone2");
			
			Client returnedClient = new Client(user, password, lastName, firstName, address, email, areaCode, phone1, phone2, 2);
			
			return returnedClient;
			
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return null;
	}
	
	public void updateUserWithPassword(String username, String password, String lastName, String firstName, String address, String email, String areaCode, String phone1, String phone2) {
		//update user including password
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			
			PreparedStatement insertEdits = connection.prepareStatement("UPDATE `clients` SET `password`= ?,`lastName`= ?,`firstName`= ?,`address`= ?,`email`= ?,`areaCode`= ?,`phone1`= ?,`phone2`= ? WHERE username = ?");
			insertEdits.setString(1, password);
			insertEdits.setString(2, lastName);
			insertEdits.setString(3, firstName);
			insertEdits.setString(4, address);
			insertEdits.setString(5, email);
			insertEdits.setString(6, areaCode);
			insertEdits.setString(7, phone1);
			insertEdits.setString(8, phone2);
			insertEdits.setString(9, username);
			
			insertEdits.executeUpdate();
				
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	public String passwordMatch(String username) {
		
		//returns the user's password so passwords can be matched
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
					
					PreparedStatement getPassword = connection.prepareStatement("SELECT `password` FROM clients WHERE username = ?");
					getPassword.setString(1, username);
					
					ResultSet populate = getPassword.executeQuery();
					
					populate.next();
					String password = populate.getString("password");
					
					return password;
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
				return null;
	}
	
	public void updateUserWithoutPassword(String username, String lastName, String firstName, String address, String email, String areaCode, String phone1, String phone2) {
		//update user including password
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			
			PreparedStatement insertEdits = connection.prepareStatement("UPDATE `clients` SET `lastName`= ?,`firstName`= ?,`address`= ?,`email`= ?,`areaCode`= ?,`phone1`= ?,`phone2`= ? WHERE username = ?;");
			insertEdits.setString(1, lastName);
			insertEdits.setString(2, firstName);
			insertEdits.setString(3, address);
			insertEdits.setString(4, email);
			insertEdits.setString(5, areaCode);
			insertEdits.setString(6, phone1);
			insertEdits.setString(7, phone2);
			insertEdits.setString(8, username);
			
			insertEdits.executeUpdate();
				
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	public void updateUserPasswordTable(String username, String password) {
		// update the password in the username table
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
						
			PreparedStatement insertPassword = connection.prepareStatement("UPDATE `users` SET `password` = ? WHERE username = ?;");
			insertPassword.setString(1, password);
			insertPassword.setString(2, username);
			
			insertPassword.executeUpdate();
						
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

		
	}
	

	

}
