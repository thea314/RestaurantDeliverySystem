package VideoProject;

import javax.swing.JOptionPane;

public class EditMenuModel {
	
	//properties
	private String name;
	private String price;
	private int restoId;

	//function to validate name entered
	public boolean validateName(String name) {
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Username cannot be blank", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (name.length() < 4) {
			JOptionPane.showMessageDialog(null, "Username cannot be less than 4 letters", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}	else
			return true;
		
	}


//function to validate price is a double
	public boolean validatePrice(String price) {
		
		if (price.contains("a-zA-Z]+") == false) {					
			return true;
		} else if (price.length() == 0) {
			JOptionPane.showMessageDialog(null, "Item can't be free", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			return false;
		
	}	
	
}
