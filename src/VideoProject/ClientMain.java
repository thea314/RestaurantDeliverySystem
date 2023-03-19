package VideoProject;

public class ClientMain {
	
	ClientMenuView view = new ClientMenuView();
	
	ClientModel model = new ClientModel();
	
	ClientController controller = new ClientController(view, model);

}
