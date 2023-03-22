package VideoProject;

import javax.swing.JOptionPane;

public class CreateRestaurantModel {
	
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantAreaCode;
	private String restaurantPhone1;
	private String restaurantPhone2;
	private String deliveryArea;
	
	//validate restaurant name complete
	public boolean validateRestoName (String restoName) {
		
		if (restoName.equals("")) {
			JOptionPane.showMessageDialog(null, "Restaurant Name cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (restoName.length() < 4) {
			JOptionPane.showMessageDialog(null, "Restaurant name cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}	else
			return true;
		
	}
	
	//validate address complete
	public boolean validateRestoAddress (String restoAddress) {
				
		if (restoAddress.equals("")) {
			JOptionPane.showMessageDialog(null, "Address cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (restoAddress.length() < 4) {
			JOptionPane.showMessageDialog(null, "Address cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
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
	
	//validate phone2 complete
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public String getRestaurantAreaCode() {
		return restaurantAreaCode;
	}
	public void setRestaurantAreaCode(String restaurantAreaCode) {
		this.restaurantAreaCode = restaurantAreaCode;
	}
	public String getRestaurantPhone1() {
		return restaurantPhone1;
	}
	public void setRestaurantPhone1(String restaurantPhone1) {
		this.restaurantPhone1 = restaurantPhone1;
	}
	public String getRestaurantPhone2() {
		return restaurantPhone2;
	}
	public void setRestaurantPhone2(String restaurantPhone2) {
		this.restaurantPhone2 = restaurantPhone2;
	}
	public String getDeliveryArea() {
		return deliveryArea;
	}
	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}
	
	

}
