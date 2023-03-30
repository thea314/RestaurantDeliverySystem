package VideoProject;

import java.util.ArrayList;

public class Order {

	//properties
	private int id;
	private int restoId;
	private int clientId;
	private ArrayList<OrderItem> items;
	private String address;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private String postalCode;
	private int completed;
	private int delivered;
	
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getDelivered() {
		return delivered;
	}
	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestoId() {
		return restoId;
	}
	public void setRestoId(int restoId) {
		this.restoId = restoId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public ArrayList<OrderItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String string) {
		this.postalCode = string;
	}
	
	
	
}
