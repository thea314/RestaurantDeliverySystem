package VideoProject;

import javax.swing.JOptionPane;

public class LoginModel {
	
	//properties
	private String username;
	private String password;
	
	//constructor
	
	
	//function to validate username entered
	public boolean validateUsername(String username) {
		
		if (username.equals("")) {
			JOptionPane.showMessageDialog(null, "Username cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			return true;
		
	}
	
	//validate password complete
	public boolean  validatePassword (String password) {
		
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Password cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			return true;
		
	}

}
