package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CreateClientController implements ActionListener {
	
	//properties
	private CreateClientView view;
	private CreateClientModel model;
	
	//constructor
	public CreateClientController(CreateClientView view, CreateClientModel model) {
		this.view = view;
		this.model = model;
		
		//actionlisteners for buttons on form
		view.getBtn_usernameValidate().addActionListener(this);
		view.getBtn_save().addActionListener(this);
		view.getBtn_return().addActionListener(this);
		view.getBtn_quit().addActionListener(this);
	}
	
	//add logic for buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton)e.getSource() == view.getBtn_usernameValidate()) {
			userNameCheck(view.getTxt_username().getText());
				
			} 
		 else if((JButton)e.getSource() == view.getBtn_quit()) {
			System.exit(0);
		}
	}
	
	
	public void userNameCheck(String username) {
		//function for validating non-duplicate username
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", ""); // establish connection
			
			//prepare query statement
			PreparedStatement checkUsername = connection.prepareStatement("SELECT * FROM `users` WHERE LOWER(username) =  ?;"); 
			checkUsername.setString(1, username);
			
			ResultSet resultSet = checkUsername.executeQuery();
			
			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "Username already taken, try again", "Error", JOptionPane.INFORMATION_MESSAGE);
				
			} else {
				JOptionPane.showMessageDialog(null, "Username available.", "Error", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		

		
	}
	
	public void addClient(String username, String password, String lastName, String firstName, String addressm, String email,
			String areaCode, String phone1, String phone2, int type) {
		//add new client to the db
		
		
		
		
	}
	
	

}
