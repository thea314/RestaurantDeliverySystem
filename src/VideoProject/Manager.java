package VideoProject;

public class Manager extends User {
	
	private int restoId;
	
	//constructor
	public Manager(String username, String password, int type, int restoId) {
		super(username, password, type);
		this.restoId = restoId;
	}

	public int getRestoId() {
		return restoId;
	}

	public void setRestoId(int restoId) {
		this.restoId = restoId;
	}

}
