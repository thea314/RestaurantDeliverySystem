package VideoProject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CreateOrderModel {
	
	//properties
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;
	private String postalCode;
	private Restaurant restaurant;
	private Client client;
	private ArrayList<MenuItem> menuitems;
	private double total;
	
	//validate fields are numeric
	public boolean validateNumseric(String number) {
		
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please ensure that only numbers are entered.", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
				
	}
	
	public boolean validatePostalCode(String postalCode) {
		
		if (postalCode.length() != 3) {
			JOptionPane.showMessageDialog(null, "Postal Code must be length 3.", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			return true;
		
		
	}
	
	
	
	

	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}


	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ArrayList<MenuItem> getMenuitems() {
		return menuitems;
	}
	public void setMenuitems(ArrayList<MenuItem> menuitems) {
		this.menuitems = menuitems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
