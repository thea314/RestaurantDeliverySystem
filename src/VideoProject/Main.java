package VideoProject;

public class Main {

	public static void main(String[] args) {
		
		LoginModel model = new LoginModel();
		
		LoginView view = new LoginView();
		
		LoginController controller = new LoginController(model, view);
		

	}

}
