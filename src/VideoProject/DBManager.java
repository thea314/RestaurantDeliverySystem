package VideoProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

			PreparedStatement newResto = connection.prepareStatement("INSERT INTO `restaurant` (`restoName`, `restoAddress`, `areaCode`, `phone1`, `phone2`, `OpenSunAmHr`, `OpenSunMin`, `CloseSunHr`, `CloseSunMin`, `OpenMonHr`, `OpenMonMin`, `CloseMonHr`, `CloseMonMin`, `OpenTuesHr`, `OpenTuesMin`, `ClosedTuesHr`, `ClosedTuesMin`, `OpenWedHr`, `OpenWedMin`, `ClosedWedHr`, `ClosedWedMin`, `OpenThursHr`, `OpenThursMin`, `ClosedThursHr`, `ClosedThursMin`, `OpenFriHr`, `OpenFriMin`, `ClosedFriHr`, `ClosedFriMin`, `OpenSatHr`, `OpenSatMin`, `ClosedSatHr`, `ClosedSatMin`, `deliveryArea`, `managerUsername`, `managerPassword`, `restauranteurUsername`, `restauranteurPassword`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			newResto.setString(1, name);
			newResto.setString(2, address);
			newResto.setString(3, areaCode);
			newResto.setString(4, phone1);
			newResto.setString(5, phone2);
			newResto.setLong(6, sunHrOpen);
			newResto.setLong(7, sunMinOpen);
			newResto.setLong(8, sunHrClose);
			newResto.setLong(9, sunMinClose);									
			newResto.setLong(10, monHrOpen);
			newResto.setLong(11, monMinOpen);
			newResto.setLong(12, monHrClose);
			newResto.setLong(13, monMinClose);
			newResto.setLong(14, tuesHrOpen);
			newResto.setLong(15, tuesMinOpen);
			newResto.setLong(16, tuesHrClose);
			newResto.setLong(17, tuesMinClose);
			newResto.setLong(18, wedHrOpen);
			newResto.setLong(19, wedMinOpen);
			newResto.setLong(20, wedHrClose);
			newResto.setLong(21, wedMinClose);
			newResto.setLong(22, thursHrOpen);
			newResto.setLong(23, thursMinOpen);
			newResto.setLong(24, thursHrClose);
			newResto.setLong(25, thursMinClose);
			newResto.setLong(26, friHrOpen);
			newResto.setLong(27, friMinOpen);
			newResto.setLong(28, friHrClose);
			newResto.setLong(29, friMinClose);
			newResto.setLong(30, satHrOpen);
			newResto.setLong(31, satMinOpen);
			newResto.setLong(32, satHrClose);
			newResto.setLong(33, satMinClose);
			newResto.setString(34, deliveryArea);
			newResto.setString(35, managerUsername);
			newResto.setString(36, managerPassword);
			newResto.setString(37, restauranteurUsername);
			newResto.setString(38, restauranteurPassword);

			String query = newResto.toString();

			newResto.executeUpdate();

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database -- Insert Resto.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Error connecting to database -- RestoId.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Add Manager", "Error", JOptionPane.INFORMATION_MESSAGE);
		}


	}

	//add restauranteur to managers table
	public void addRestauranteur(String username, String password, int restoId) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement newUser = connection.prepareStatement("INSERT INTO `restauranteur`(`username`, `password`, `restaurant_id`) VALUES (?, ?, ?);");
			newUser.setString(1,  username);
			newUser.setString(2, password);
			newUser.setLong(3, restoId);

			newUser.executeUpdate();	

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Add Restauranteur", "Error", JOptionPane.INFORMATION_MESSAGE);
		}


	}

	/**
	 * Edit Restaurant 
	 *
	 */

	//get restaurant name to put in JTable
	public ArrayList<String> restaurantName() {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement name = connection.prepareStatement("SELECT id, restoName FROM restaurant;");

			ResultSet restoNames = name.executeQuery();

			ArrayList<String> listOfRestoNames = new ArrayList<>();					

			while (restoNames.next()) {

				String restoName = restoNames.getString("restoName");
				int restoId = restoNames.getInt("id");
				String stringId = Integer.toString(restoId);

				String temp = stringId + " - " + restoName;

				listOfRestoNames.add(temp);
			}

			return listOfRestoNames;

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant Name", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

		return null;

	}

	public Restaurant getRestautantFromId(int restoId) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement getResto = connection.prepareStatement("SELECT * FROM restaurant WHERE id = ?");
			getResto.setLong(1, restoId);

			ResultSet populate = getResto.executeQuery();

			Restaurant restaurant = new Restaurant();

			populate.next();
			restaurant.setRestaurantName(populate.getString("restoName"));
			restaurant.setRestaurantAddress(populate.getString("restoAddress"));
			restaurant.setRestaurantAreaCode(populate.getString("areaCode"));
			restaurant.setRestaurantPhone1(populate.getString("phone1"));
			restaurant.setRestaurantPhone2(populate.getString("phone2"));
			restaurant.setDeliveryArea(populate.getString("deliveryArea"));
			restaurant.setCombo_MonHrOpen(populate.getInt("OpenMonHr"));
			restaurant.setCombo_MonMinOpen(populate.getInt("OpenMonMin"));
			restaurant.setCombo_MonHrClose(populate.getInt("CloseMonHr")); 
			restaurant.setCombo_MonMinClose(populate.getInt("CloseMonMin"));
			restaurant.setCombo_TuesHrOpen(populate.getInt("OpenTuesHr"));
			restaurant.setCombo_TuesMinOpen(populate.getInt("OpenTuesMin"));
			restaurant.setCombo_TuesHrClose(populate.getInt("ClosedTuesHr"));
			restaurant.setCombo_TuesMinClose(populate.getInt("ClosedTuesMin"));
			restaurant.setCombo_WedHrOpen(populate.getInt("OpenWedHr"));
			restaurant.setCombo_WedMinOpen(populate.getInt("OpenWedMin"));
			restaurant.setCombo_WedHrClose(populate.getInt("ClosedWedHr"));
			restaurant.setCombo_WedMinClose(populate.getInt("ClosedWedMin"));
			restaurant.setCombo_ThursHrOpen(populate.getInt("OpenThursHr"));
			restaurant.setCombo_ThursMinOpen(populate.getInt("OpenThursMin"));
			restaurant.setCombo_ThursHrClose(populate.getInt("ClosedThursHr"));
			restaurant.setCombo_ThursMinClose(populate.getInt("ClosedThursMin"));
			restaurant.setCombo_FriHrOpen(populate.getInt("OpenFriHr"));
			restaurant.setCombo_FriMinOpen(populate.getInt("OpenFriMin"));
			restaurant.setCombo_FriHrClose(populate.getInt("ClosedFriHr"));
			restaurant.setCombo_FriMinClose(populate.getInt("ClosedFriMin"));
			restaurant.setCombo_SatHrOpen(populate.getInt("OpenSatHr"));
			restaurant.setCombo_SatMinOpen(populate.getInt("OpenSatMin"));
			restaurant.setCombo_SatHrClose(populate.getInt("ClosedSatHr"));
			restaurant.setCombo_SatMinClose(populate.getInt("ClosedSatMin"));
			restaurant.setCombo_SunHrOpen(populate.getInt("OpenSunAmHr"));
			restaurant.setCombo_SunMinOpen(populate.getInt("OpenSunMin"));
			restaurant.setCombo_SunHrClose(populate.getInt("CloseSunHr"));
			restaurant.setCombo_SunMinClose(populate.getInt("CloseSunMin"));
			restaurant.setActive(populate.getInt("active"));

			return restaurant;


		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

		return null;

	}

	public void updateRestaurant(int id, String name, String address, String areaCode, String phone1, String phone2, String deliveryArea, int monHrOpen, int monMinOpen,
			int monHrClose, int monMinClose, int tuesHrOpen, int tuesMinOpen, int tuesHrClose, int tuesMinClose, int wedHrOpen, int wedMinOpen,
			int wedHrClose, int wedMinClose, int thursHrOpen, int thursMinOpen, int thursHrClose, int thursMinClose, int friHrOpen,
			int friMinOpen, int friHrClose, int friMinClose, int satHrOpen, int satMinOpen, int satHrClose, int satMinClose,
			int sunHrOpen, int sunMinOpen, int sunHrClose, int sunMinClose) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement updateResto = connection.prepareStatement("UPDATE `restaurant` SET `restoName`= ?,`restoAddress`=?,`areaCode`=?,`phone1`=?,`phone2`=?,`OpenSunAmHr`=?,`OpenSunMin`=?,`CloseSunHr`=?,`CloseSunMin`=?,`OpenMonHr`=?,`OpenMonMin`=?,`CloseMonHr`=?,`CloseMonMin`=?,`OpenTuesHr`=?,`OpenTuesMin`=?,`ClosedTuesHr`=?,`ClosedTuesMin`=?,`OpenWedHr`=?,`OpenWedMin`=?,`ClosedWedHr`=?,`ClosedWedMin`=?,`OpenThursHr`=?,`OpenThursMin`=?,`ClosedThursHr`=?,`ClosedThursMin`=?,`OpenFriHr`=?,`OpenFriMin`=?,`ClosedFriHr`=?,`ClosedFriMin`=?,`OpenSatHr`=?,`OpenSatMin`=?,`ClosedSatHr`=?,`ClosedSatMin`=?,`deliveryArea`=? WHERE id = ?");
			updateResto.setString(1, name);
			updateResto.setString(2, address);
			updateResto.setString(3, areaCode);
			updateResto.setString(4, phone1);
			updateResto.setString(5, phone2);
			updateResto.setLong(6, sunHrOpen);
			updateResto.setLong(7, sunMinOpen);
			updateResto.setLong(8, sunHrClose);
			updateResto.setLong(9, sunMinClose);									
			updateResto.setLong(10, monHrOpen);
			updateResto.setLong(11, monMinOpen);
			updateResto.setLong(12, monHrClose);
			updateResto.setLong(13, monMinClose);
			updateResto.setLong(14, tuesHrOpen);
			updateResto.setLong(15, tuesMinOpen);
			updateResto.setLong(16, tuesHrClose);
			updateResto.setLong(17, tuesMinClose);
			updateResto.setLong(18, wedHrOpen);
			updateResto.setLong(19, wedMinOpen);
			updateResto.setLong(20, wedHrClose);
			updateResto.setLong(21, wedMinClose);
			updateResto.setLong(22, thursHrOpen);
			updateResto.setLong(23, thursMinOpen);
			updateResto.setLong(24, thursHrClose);
			updateResto.setLong(25, thursMinClose);
			updateResto.setLong(26, friHrOpen);
			updateResto.setLong(27, friMinOpen);
			updateResto.setLong(28, friHrClose);
			updateResto.setLong(29, friMinClose);
			updateResto.setLong(30, satHrOpen);
			updateResto.setLong(31, satMinOpen);
			updateResto.setLong(32, satHrClose);
			updateResto.setLong(33, satMinClose);
			updateResto.setString(34, deliveryArea);
			updateResto.setLong(35, id);

			updateResto.executeUpdate();


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- update Restaurant", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}


	/**
	 * Delete Restaurant 
	 *
	 */

	public void inactiveResto(int id) {

		//set restaurant account status to inactive
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement setInactive = connection.prepareStatement("UPDATE `restaurant` SET `active` = 2 WHERE id = ?;");
			setInactive.setInt(1, id);

			setInactive.executeUpdate();

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- delete restaurant", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * Create Menu
	 *
	 */

	public void addMenu(MenuItem menu) {

		//add all rows from menu to database with restaurant id
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement addMenu = connection.prepareStatement("INSERT INTO `menu`(`name`, `price`, `restaurant_id`) VALUES (?,?,?);");
			addMenu.setString(1, menu.getItemName());
			addMenu.setString(2, menu.getItemPrice());
			addMenu.setInt(3, menu.getRestoId());

			addMenu.executeUpdate();


		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- delete restaurant", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Edit Menu
	 *
	 */

	public boolean hasMenu(int restoId) {

		//determine if given resto has a menu that can be edited/deleted
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement checkMenu = connection.prepareStatement("SELECT * FROM menu WHERE restaurant_id = ?;");
			checkMenu.setInt(1, restoId);

			ResultSet resultSet = checkMenu.executeQuery();

			if (resultSet.next()) {				
				return true;
			}else
				return false;


		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- edit menu", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}

	public ArrayList<MenuItem> menuList(int restoId) {

		//get list of menu strings for a given restaurant
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement menuItems = connection.prepareStatement("SELECT * FROM menu WHERE restaurant_id = ?;");
			menuItems.setInt(1, restoId);

			ResultSet menuNames = menuItems.executeQuery();

			ArrayList<MenuItem> listOfMenuNames = new ArrayList<>();					

			while (menuNames.next()) {

				MenuItem menuItem = new MenuItem();

				menuItem.setItemName(menuNames.getString("name"));
				menuItem.setItemPrice(menuNames.getString("price"));
				menuItem.setRestoId(menuNames.getInt("restaurant_id"));	
				menuItem.setMenuId(menuNames.getInt("id"));

				listOfMenuNames.add(menuItem);
			}

			return listOfMenuNames;

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant Name", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

		return null;

	}

	public void editMenuItem(int menuId, String name, String price) {

		//update menu item in database
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement updateMenu = connection.prepareStatement("UPDATE `menu` SET `name`=?,`price`=? WHERE id = ?");
			updateMenu.setString(1,name);
			updateMenu.setString(2, price);
			updateMenu.setInt(3, menuId);

			updateMenu.executeUpdate();


		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant Name", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * Delete Menu
	 *
	 */
	public void deleteMenuItem(int menuId) {

		//delete menu item in database
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement deleteMenu = connection.prepareStatement("DELETE FROM `menu` WHERE id = ?");
			deleteMenu.setInt(1, menuId);

			deleteMenu.executeUpdate();



		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant Name", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Add Delivery Guy
	 *
	 */

	public void createDeliveryGuy(String name, String areaCode, String phone1, String phone2, String deliveryArea, String username, String password) {

		//create delivery guy 

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement addDeliveryGuy = connection.prepareStatement("INSERT INTO `deliveryguy`(`name`, `areaCode`, `phone1`, `phone2`, `deliveryArea`, `username`, `password`) VALUES (?,?,?,?,?,?,?)");
			addDeliveryGuy.setString(1, name);
			addDeliveryGuy.setString(2, areaCode);
			addDeliveryGuy.setString(3, phone1);
			addDeliveryGuy.setString(4, phone2);
			addDeliveryGuy.setString(5, deliveryArea);
			addDeliveryGuy.setString(6, username);
			addDeliveryGuy.setString(7, password);

			addDeliveryGuy.executeUpdate();

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Add delivery", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Edit Delivery Guy
	 *
	 */

	public ArrayList<String> deliveryGuyName() {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement name = connection.prepareStatement("SELECT id, name FROM deliveryguy;");

			ResultSet guyNames = name.executeQuery();

			ArrayList<String> listOfGuyNames = new ArrayList<>();					

			while (guyNames.next()) {

				String dGuyName = guyNames.getString("name");
				int guyId = guyNames.getInt("id");
				String stringId = Integer.toString(guyId);

				String temp = stringId + " - " + dGuyName;

				listOfGuyNames.add(temp);
			}

			return listOfGuyNames;

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant Name", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

		return null;

	}

	public DeliveryGuy getDeliveryGuyById(int deliveryGuyId) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement getDeliveryGuy = connection.prepareStatement("SELECT * FROM deliveryguy WHERE id = ?");
			getDeliveryGuy.setLong(1, deliveryGuyId);

			ResultSet populate = getDeliveryGuy.executeQuery();

			populate.next();

			DeliveryGuy deliveryGuy = new DeliveryGuy(populate.getString("username"), populate.getString("password"), 5);

			deliveryGuy.setAreaCode(populate.getString("areaCode"));
			deliveryGuy.setDeliveryArea(populate.getString("deliveryArea"));
			deliveryGuy.setName(populate.getString("name"));
			deliveryGuy.setPhone1(populate.getString("phone1"));
			deliveryGuy.setPhone2(populate.getString("phone2"));
			deliveryGuy.setUsername(populate.getString("username"));

			return deliveryGuy;


		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- Get Restaurant Name", "Error", JOptionPane.INFORMATION_MESSAGE);
		}

		return null;
	}

	public void updateDeliveryGuyNoPasswordChange(String username, String name, String areaCode, String phone1, String phone2, String deliveryArea) {

		//update delivery guy if admin opts not to change password
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement updateDeliveryGuy = connection.prepareStatement("UPDATE `deliveryguy` SET `name`=?,`areaCode`=?,`phone1`=?,`phone2`=?,`deliveryArea`=? WHERE username = ?");
			updateDeliveryGuy.setString(1, name);
			updateDeliveryGuy.setString(2, areaCode);
			updateDeliveryGuy.setString(3, phone1);
			updateDeliveryGuy.setString(4, phone2);
			updateDeliveryGuy.setString(5, deliveryArea);
			updateDeliveryGuy.setString(6, username);
			
			updateDeliveryGuy.executeUpdate();

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- update delivery guy no password", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void updateDeliveryGuyWithPasswordChange(String username, String name, String areaCode, String phone1, String phone2, String deliveryArea, String password) {

		//update delivery guy if admin opts not to change password
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection

			PreparedStatement updateDeliveryGuy = connection.prepareStatement("UPDATE `deliveryguy` SET `name`=?,`areaCode`=?,`phone1`=?,`phone2`=?,`deliveryArea`=?, `password` = ? WHERE username = ?");
			updateDeliveryGuy.setString(1, name);
			updateDeliveryGuy.setString(2, areaCode);
			updateDeliveryGuy.setString(3, phone1);
			updateDeliveryGuy.setString(4, phone2);
			updateDeliveryGuy.setString(5, deliveryArea);
			updateDeliveryGuy.setString(6, password);
			updateDeliveryGuy.setString(7, username);
			
			updateDeliveryGuy.executeUpdate();

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database. -- update delivery guy no password", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Order food 
	 *
	 */
	
	//add new orderinfo for restaurants and deliveries
	public void addOrderInfo(int clientId, int year, int month, int day, String postalCode, int deliveryHr, int deliveryMin, String address, int restoId) {
		
		
		
	}
	
}