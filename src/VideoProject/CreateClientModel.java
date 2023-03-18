package VideoProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;


public class CreateClientModel {
	
	//properties
	private String username;
	private String password;
	private String confirmPassword;
	private String lastName;
	private String firstName;
	private String address;
	private String email;
	private String areaCode;
	private String phone1;
	private String phone2;
	
	
	
	
	//confirm password and password match
	public boolean confirmPasswords(String password, String confirmPassword) {
		
		if (password.equals(confirmPassword)) {
			return true;
		} else
			return false;
	}
	
	// validate all fields are filled in
	
	//function to validate username entered
		public boolean validateUsername(String username) {
			
			if (username.equals("")) {
				JOptionPane.showMessageDialog(null, "Username cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (username.length() < 4) {
				JOptionPane.showMessageDialog(null, "Username cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}	else
				return true;
			
		}
		
		//validate password complete
		public boolean validatePassword (String password) {
			
			if (password.equals("")) {
				JOptionPane.showMessageDialog(null, "Password cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (password.length() < 4) {
				JOptionPane.showMessageDialog(null, "Password cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}	else
				return true;
			
		}
		
		//validate confirm password complete
		public boolean validateConfirmPassword (String password) {
			
			if (confirmPassword.equals("")) {
				JOptionPane.showMessageDialog(null, "Confirm password cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else
				return true;
			
		}
		
		//validate last name complete
		public boolean validateLastName (String lastName) {
			
			if (lastName.equals("")) {
				JOptionPane.showMessageDialog(null, "Last Name cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (lastName.length() < 4) {
				JOptionPane.showMessageDialog(null, "Last name cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}	else
				return true;
			
		}
		
		//validate last name complete
		public boolean validateFirstName (String firstName) {
			
			if (firstName.equals("")) {
				JOptionPane.showMessageDialog(null, "First Name cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (firstName.length() < 4) {
				JOptionPane.showMessageDialog(null, "First Name cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}	else
				return true;
			
		}
		
		//validate address complete
		public boolean validateAddress (String address) {
					
			if (address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (address.length() < 4) {
				JOptionPane.showMessageDialog(null, "Address cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}	else
				return true;
					
		}
		
		//validate email complete
			public boolean validateEmail (String email) {
							
				if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "Email cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				} else if (email.length() < 4) {
					JOptionPane.showMessageDialog(null, "Email cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}	else
					return true;
						
			}
			
			//validate areaCode complete
			public boolean validateareaCode (String areaCode) {
							
				if (areaCode.equals("")) {
					JOptionPane.showMessageDialog(null, "Area Code cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				} else if (areaCode.length() != 3) {
					JOptionPane.showMessageDialog(null, "Area Code must be 3 numbers.", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}	else
					return true;
						
			}
			
			//validate phone1 complete
			public boolean validatePhone1 (String phone1) {
							
				if (phone1.equals("")) {
					JOptionPane.showMessageDialog(null, "First part of phone number cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				} else if (phone1.length() != 3) {
					JOptionPane.showMessageDialog(null, "First part of phone number must be 3 numbers.", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}	else
					return true;
						
			}
		
			public boolean validatePhone2 (String phone2) {
				
				if (phone2.equals("")) {
					JOptionPane.showMessageDialog(null, "Second part of phone number cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				} else if (phone2.length() != 4) {
					JOptionPane.showMessageDialog(null, "Last part of phone number must have 4 numbers.", "Error", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}	else
					return true;
						
			}
		
		

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

}
