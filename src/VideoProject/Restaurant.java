package VideoProject;

import javax.swing.JComboBox;

public class Restaurant {
	
	//properties
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantAreaCode;
	private String restaurantPhone1;
	private String restaurantPhone2;
	private String deliveryArea;
	private int combo_MonHrOpen;
	private int combo_MonMinOpen;
	private int combo_MonHrClose;
	private int combo_MonMinClose;
	private int combo_TuesHrOpen;
	private int combo_TuesMinOpen;
	private int combo_TuesHrClose;
	private int combo_TuesMinClose;
	private int combo_WedHrOpen;
	private int combo_WedMinOpen;
	private int combo_WedHrClose;
	private int combo_WedMinClose;
	private int combo_ThursHrOpen;
	private int combo_ThursMinOpen;
	private int combo_ThursHrClose;
	private int combo_ThursMinClose;
	private int combo_FriHrOpen;
	private int combo_FriMinOpen;
	private int combo_FriHrClose;
	private int combo_FriMinClose;
	private int combo_SatHrOpen;
	private int combo_SatMinOpen;
	private int combo_SatHrClose;
	private int combo_SatMinClose;
	private int combo_SunHrOpen;
	private int combo_SunMinOpen;
	private int combo_SunHrClose;
	private int combo_SunMinClose;
	
	//constructor
	public Restaurant (String restaurantName, String restaurantAddress, String restaurantAreaCode, String restaurantPhone1, String restaurantPhone2,
			String deliveryArea, int combo_MonHrOpen, int combo_MonMinOpen, int combo_MonHrClose, int c, int combo_TuesHrOpen,
			int combo_TuesMinOpen, int combo_TuesHrClose, int combo_TuesMinClose, int combo_WedHrOpen, int combo_WedMinOpen, int combo_WedHrClose,
			int combo_WedMinClose, int combo_ThursHrOpen, int combo_ThursMinOpen, int combo_ThursHrClose, int combo_ThursMinClose,
			int combo_FriHrOpen, int combo_FriMinOpen, int combo_FriHrClose, int combo_FriMinClose, int combo_SatHrOpen, int combo_SatMinOpen,
			int combo_SatHrClose, int combo_SatMinClose, int combo_SunHrOpen, int combo_SunMinOpen, int combo_SunHrClose, int combo_SunMinClose) {
		
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantAreaCode = restaurantAreaCode;
		this.restaurantPhone1 = restaurantPhone1;
		this.restaurantPhone2 = restaurantPhone2;
		this.deliveryArea = deliveryArea;
		this.combo_MonHrOpen = combo_MonHrOpen;
		this.combo_MonMinOpen = combo_MonMinOpen;
		this.combo_MonHrClose = combo_MonHrClose;
		this.combo_MonHrClose = combo_MonHrClose;
		this.combo_TuesHrOpen = combo_TuesHrOpen;
		this.combo_TuesMinOpen = combo_TuesMinOpen;
		this.combo_TuesHrClose = combo_TuesHrClose;
		this.combo_TuesMinClose = combo_TuesMinClose;
		this.combo_WedHrOpen = combo_WedHrOpen;
		this.combo_WedMinOpen = combo_WedMinOpen;
		this.combo_WedHrClose = combo_WedHrClose;
		this.combo_WedMinClose = combo_WedMinClose;
		this.combo_ThursHrOpen = combo_ThursHrOpen;
		this.combo_ThursMinOpen = combo_ThursMinOpen;
		this.combo_ThursHrClose = combo_ThursHrClose;
		this.combo_ThursMinClose = combo_ThursMinClose;
		this.combo_FriHrOpen = combo_FriHrOpen;
		this.combo_FriMinOpen = combo_FriMinOpen;
		this.combo_FriHrClose = combo_FriHrClose;
		this.combo_FriMinClose = combo_FriMinClose;
		this.combo_SatHrOpen = combo_SatHrOpen;
		this.combo_SatMinOpen = combo_SatMinOpen;
		this.combo_SatHrClose = combo_SatHrClose;
		this.combo_SatMinClose = combo_SatMinClose;
		this.combo_SunHrOpen = combo_SunHrOpen;
		this.combo_SunMinOpen = combo_SunMinOpen;
		this.combo_SunHrClose = combo_SunHrClose;
		this.combo_SunMinClose = combo_SunMinClose;
		
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

	public int getCombo_MonHrOpen() {
		return combo_MonHrOpen;
	}

	public void setCombo_MonHrOpen(int combo_MonHrOpen) {
		this.combo_MonHrOpen = combo_MonHrOpen;
	}

	public int getCombo_MonMinOpen() {
		return combo_MonMinOpen;
	}

	public void setCombo_MonMinOpen(int combo_MonMinOpen) {
		this.combo_MonMinOpen = combo_MonMinOpen;
	}

	public int getCombo_MonHrClose() {
		return combo_MonHrClose;
	}

	public void setCombo_MonHrClose(int combo_MonHrClose) {
		this.combo_MonHrClose = combo_MonHrClose;
	}

	public int getCombo_MonMinClose() {
		return combo_MonMinClose;
	}

	public void setCombo_MonMinClose(int combo_MonMinClose) {
		this.combo_MonMinClose = combo_MonMinClose;
	}

	public int getCombo_TuesHrOpen() {
		return combo_TuesHrOpen;
	}

	public void setCombo_TuesHrOpen(int combo_TuesHrOpen) {
		this.combo_TuesHrOpen = combo_TuesHrOpen;
	}

	public int getCombo_TuesMinOpen() {
		return combo_TuesMinOpen;
	}

	public void setCombo_TuesMinOpen(int combo_TuesMinOpen) {
		this.combo_TuesMinOpen = combo_TuesMinOpen;
	}

	public int getCombo_TuesHrClose() {
		return combo_TuesHrClose;
	}

	public void setCombo_TuesHrClose(int combo_TuesHrClose) {
		this.combo_TuesHrClose = combo_TuesHrClose;
	}

	public int getCombo_TuesMinClose() {
		return combo_TuesMinClose;
	}

	public void setCombo_TuesMinClose(int combo_TuesMinClose) {
		this.combo_TuesMinClose = combo_TuesMinClose;
	}

	public int getCombo_WedHrOpen() {
		return combo_WedHrOpen;
	}

	public void setCombo_WedHrOpen(int combo_WedHrOpen) {
		this.combo_WedHrOpen = combo_WedHrOpen;
	}

	public int getCombo_WedMinOpen() {
		return combo_WedMinOpen;
	}

	public void setCombo_WedMinOpen(int combo_WedMinOpen) {
		this.combo_WedMinOpen = combo_WedMinOpen;
	}

	public int getCombo_WedHrClose() {
		return combo_WedHrClose;
	}

	public void setCombo_WedHrClose(int combo_WedHrClose) {
		this.combo_WedHrClose = combo_WedHrClose;
	}

	public int getCombo_WedMinClose() {
		return combo_WedMinClose;
	}

	public void setCombo_WedMinClose(int combo_WedMinClose) {
		this.combo_WedMinClose = combo_WedMinClose;
	}

	public int getCombo_ThursHrOpen() {
		return combo_ThursHrOpen;
	}

	public void setCombo_ThursHrOpen(int combo_ThursHrOpen) {
		this.combo_ThursHrOpen = combo_ThursHrOpen;
	}

	public int getCombo_ThursMinOpen() {
		return combo_ThursMinOpen;
	}

	public void setCombo_ThursMinOpen(int combo_ThursMinOpen) {
		this.combo_ThursMinOpen = combo_ThursMinOpen;
	}

	public int getCombo_ThursHrClose() {
		return combo_ThursHrClose;
	}

	public void setCombo_ThursHrClose(int combo_ThursHrClose) {
		this.combo_ThursHrClose = combo_ThursHrClose;
	}

	public int getCombo_ThursMinClose() {
		return combo_ThursMinClose;
	}

	public void setCombo_ThursMinClose(int combo_ThursMinClose) {
		this.combo_ThursMinClose = combo_ThursMinClose;
	}

	public int getCombo_FriHrOpen() {
		return combo_FriHrOpen;
	}

	public void setCombo_FriHrOpen(int combo_FriHrOpen) {
		this.combo_FriHrOpen = combo_FriHrOpen;
	}

	public int getCombo_FriMinOpen() {
		return combo_FriMinOpen;
	}

	public void setCombo_FriMinOpen(int combo_FriMinOpen) {
		this.combo_FriMinOpen = combo_FriMinOpen;
	}

	public int getCombo_FriHrClose() {
		return combo_FriHrClose;
	}

	public void setCombo_FriHrClose(int combo_FriHrClose) {
		this.combo_FriHrClose = combo_FriHrClose;
	}

	public int getCombo_FriMinClose() {
		return combo_FriMinClose;
	}

	public void setCombo_FriMinClose(int combo_FriMinClose) {
		this.combo_FriMinClose = combo_FriMinClose;
	}

	public int getCombo_SatHrOpen() {
		return combo_SatHrOpen;
	}

	public void setCombo_SatHrOpen(int combo_SatHrOpen) {
		this.combo_SatHrOpen = combo_SatHrOpen;
	}

	public int getCombo_SatMinOpen() {
		return combo_SatMinOpen;
	}

	public void setCombo_SatMinOpen(int combo_SatMinOpen) {
		this.combo_SatMinOpen = combo_SatMinOpen;
	}

	public int getCombo_SatHrClose() {
		return combo_SatHrClose;
	}

	public void setCombo_SatHrClose(int combo_SatHrClose) {
		this.combo_SatHrClose = combo_SatHrClose;
	}

	public int getCombo_SatMinClose() {
		return combo_SatMinClose;
	}

	public void setCombo_SatMinClose(int combo_SatMinClose) {
		this.combo_SatMinClose = combo_SatMinClose;
	}

	public int getCombo_SunHrOpen() {
		return combo_SunHrOpen;
	}

	public void setCombo_SunHrOpen(int combo_SunHrOpen) {
		this.combo_SunHrOpen = combo_SunHrOpen;
	}

	public int getCombo_SunMinOpen() {
		return combo_SunMinOpen;
	}

	public void setCombo_SunMinOpen(int combo_SunMinOpen) {
		this.combo_SunMinOpen = combo_SunMinOpen;
	}

	public int getCombo_SunHrClose() {
		return combo_SunHrClose;
	}

	public void setCombo_SunHrClose(int combo_SunHrClose) {
		this.combo_SunHrClose = combo_SunHrClose;
	}

	public int getCombo_SunMinClose() {
		return combo_SunMinClose;
	}

	public void setCombo_SunMinClose(int combo_SunMinClose) {
		this.combo_SunMinClose = combo_SunMinClose;
	}
	

}
