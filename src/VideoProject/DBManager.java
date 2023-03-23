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
	
	/**
	 * Delete Client 
	 *
	 */
	
	public void setAccountInactive(String username) {
	
		//set user's account status to inactive
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			PreparedStatement setInactive = connection.prepareStatement("UPDATE `users` SET `active` = 2 WHERE username = ?;");
			setInactive.setString(1, username);
			
			setInactive.executeUpdate();
	
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	
	}
	
	
	/**
	 * Create Restaurant 
	 *
	 */
	
	public void createRestaurant(String name, String address, String areaCode, String phone1, String phone2, String managerUsername, 
			String managerPassword, String restauranteurUsername, String restauranteurPassword, String deliveryArea, int monHrOpen, int monMinOpen,
			int monHrClose, int monMinClose, int tuesHrOpen, int tuesMinOpen, int tuesHrClose, int tuesMinClose, int wedHrOpen, int wedMinOpen,
			int wedHrClose, int wedMinClose, int thursHrOpen, int thursMinOpen, int thursHrClose, int thursMinClose, int friHrOpen,
			int friMinOpen, int friHrClose, int friMinClose, int satHrOpen, int satMinOpen, int satHrClose, int satMinClose,
			int sunHrOpen, int sunMinOpen, int sunHrClose, int sunMinClose) {
		
		//create restaurant in db
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
		
					PreparedStatement newResto = connection.prepareStatement("INSERT INTO `restaurant`(`restoName`, `restoAddress`, `areaCode`, `phone1`, `phone2`, `OpenSunAmHr`, `OpenSunMin`, `CloseSunHr`, `CloseSunMin`, `OpenMonHr`, `OpenMonMin`, `CloseMonHr`, `CloseMonMin`, `OpenTuesHr`, `OpenTuesMin`, `ClosedTuesHr`, `ClosedTuesMin`, `OpenWedHr`, `OpenWedMin`, `ClosedWedHr`, `ClosedWedMin`, `OpenThursHr`, `OpenThursMin`, `ClosedThursHr`, `ClosedThursMin`, `OpenFriHr`, `OpenFriMin`, `ClosedFriHr`, `ClosedFriMin`, `OpenSatHr`, `OpenSatMin`, `ClosedSatHr`, `ClosedSatMin`, `deliveryArea`, `managerUsername`, `managerPassword`, `restauranteurUsername`, `restauranteurPassword`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?;");
					newResto.setString(1, name);
					newResto.setString(2, address);
					newResto.setString(3, areaCode);
					newResto.setString(4, phone1);
					newResto.setString(5, phone2);
					newResto.setString(6, managerUsername);
					newResto.setString(7, managerPassword);
					newResto.setString(8, restauranteurUsername);
					newResto.setString(9, restauranteurPassword);
					newResto.setString(10, deliveryArea);
					newResto.setLong(11, monHrOpen);
					newResto.setLong(12, monMinOpen);
					newResto.setLong(13, monHrClose);
					newResto.setLong(14, monMinClose);
					newResto.setLong(15, tuesHrOpen);
					newResto.setLong(16, tuesMinOpen);
					newResto.setLong(17, tuesHrClose);
					newResto.setLong(18, tuesMinClose);
					newResto.setLong(19, wedHrOpen);
					newResto.setLong(20, wedMinOpen);
					newResto.setLong(21, wedHrClose);
					newResto.setLong(22, wedMinClose);
					newResto.setLong(23, thursHrOpen);
					newResto.setLong(24, thursMinOpen);
					newResto.setLong(25, thursHrClose);
					newResto.setLong(26, thursMinClose);
					newResto.setLong(27, friHrOpen);
					newResto.setLong(28, friMinOpen);
					newResto.setLong(29, friHrClose);
					newResto.setLong(30, friMinClose);
					newResto.setLong(31, satHrOpen);
					newResto.setLong(32, satMinOpen);
					newResto.setLong(33, satHrClose);
					newResto.setLong(34, satMinClose);
					newResto.setLong(35, sunHrOpen);
					newResto.setLong(36, sunMinOpen);
					newResto.setLong(37, sunHrClose);
					newResto.setLong(38, sunMinClose);
					
					newResto.executeUpdate();
		
				}catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
		
	}
	
	//return restaurant id 
	public int getRestaurantId(String restoName, String restoAddress, String restoAreaCode) {
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement getId = connection.prepareStatement("SELECT id FROM restaurant WHERE restoName = ? AND restoAddress = ? AND areaCode = ?;");
			getId.setString(1, restoName);
			getId.setString(2, restoAddress);
			getId.setString(3, restoAreaCode);
					
			ResultSet restoId = getId.executeQuery();
			
			restoId.next();
			
			
			int id = restoId.getInt("id");
			
			return id;
		
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
			return -1;
			
	}
	
	//add manager to managers table
	public void addManager(String username, String password, int restoId) {
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
		
			PreparedStatement newUser = connection.prepareStatement("INSERT INTO `manager`(`username`, `password`, `restaurant_id`) VALUES (?, ?, ?);");
			newUser.setString(1,  username);
			newUser.setString(2, password);
			newUser.setLong(3, restoId);
			
			newUser.executeUpdate();	
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	//add restauranteur to managers table
		public void addRestauranteur(String username, String password, int restoId) {
			
			try {
				
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
				PreparedStatement newUser = connection.prepareStatement("INSERT INTO `manager`(`username`, `password`, `restaurant_id`) VALUES (?, ?, ?);");
				newUser.setString(1,  username);
				newUser.setString(2, password);
				newUser.setLong(3, restoId);
				
				newUser.executeUpdate();	
				
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
}
