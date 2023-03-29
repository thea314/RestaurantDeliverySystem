package VideoProject;

import javax.swing.JOptionPane;

public class EditDeliveryGuyModel {
	
	//properties
	private String name;
	private String areaCode;
	private String phone1;
	private String phone2;
	private String deliveryArea;
	private String username;
	
	//validate name
		public boolean validateName(String name) {

			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter delivery guy's name.", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (name.length() < 4 ) {
				JOptionPane.showMessageDialog(null, "Name must be longer than 4 characters", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else
				return true;

		}

		//validate fields are numeric
		public boolean validateNumeric(String number) {

			try {
				Integer.parseInt(number);
				return true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please ensure that only numbers are entered.", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

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

		//validate delivery area complete
		public boolean validateDeliveryArea (String deliveryArea) {

			if (deliveryArea.equals("")) {
				JOptionPane.showMessageDialog(null, "Delivery Area cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (deliveryArea.length() < 3) {
				JOptionPane.showMessageDialog(null, "Delivery area must have at least 3 characters.", "Error", JOptionPane.INFORMATION_MESSAGE);
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

	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDeliveryArea() {
		return deliveryArea;
	}
	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
