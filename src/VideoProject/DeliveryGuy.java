package VideoProject;

public class DeliveryGuy extends User {
	
	//properties
	private String name;
	private String areaCode;
	private String phone1;
	private String phone2;
	private String deliveryArea;
	
	//constructor
	public DeliveryGuy(String name, String areaCode, String phone1, String phone2, String deliveryArea, String username, String password, int type) {
		super(username, password, type);
		this.name = name;
		this.areaCode = areaCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.deliveryArea = deliveryArea;
		
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

	

}
