package VideoProject;

/**
 * Class that creates a client when a new client logs in
 *
 */
public class Client extends User {
	
	//properties
	private String lastName;
	private String firstName;
	private String address;
	private String email;
	private String areaCode;
	private String phone1;
	private String phone2;
	
	//constructor
	public Client(String username, String password, String lastName, String firstName, String address, String email,
			String areaCode, String phone1, String phone2, int type) {
		super(username, password, type);
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
		this.areaCode = areaCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		
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
