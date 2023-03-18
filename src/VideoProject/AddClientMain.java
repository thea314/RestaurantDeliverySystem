package VideoProject;

public class AddClientMain {
	
	public void runCreateNewClient() {	
	CreateClientView view = new CreateClientView();
	
	CreateClientModel model = new CreateClientModel();
	
	CreateClientController controller = new CreateClientController(view, model);
	}

}
