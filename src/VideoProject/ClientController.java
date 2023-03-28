package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ClientController implements ActionListener {
	
	//properties
	private ClientMenuView view;
	private User user;
	
	//constructor
	public ClientController (ClientMenuView view, User user) {
		this.view = view;
		this.user = user;
		
		//add actionlisteners to menu items
		view.getItem_Disconnect().addActionListener(this);
		view.getItem_quit().addActionListener(this);
		view.getItem_edit().addActionListener(this);
		view.getItem_delete().addActionListener(this);
		view.getItem_orderFood().addActionListener(this);
		view.getItem_orderHistory().addActionListener(this);
		
	}
	
	//add logic for each menu item
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JMenuItem) e.getSource() == view.getItem_Disconnect()) {
			
			LoginController.loggedUser = new User("0", "0", 0);
			
			view.setVisible(false);
			view.dispose();
			
			LoginView view = new LoginView();
			
			LoginModel model = new LoginModel();
			
			LoginController controlLogin = new LoginController(model, view);
			
		} else if ((JMenuItem) e.getSource() == view.getItem_quit()) {
			
			System.exit(0);
			
		} else if ((JMenuItem)e.getSource() == view.getItem_edit()) {
			
			view.setVisible(false);
			view.dispose();
			
			EditClientView editView = new EditClientView();
			
			EditClientModel editModel = new EditClientModel();
			
			EditClientController editController = new EditClientController(editView, editModel, user);
			
		} else if ((JMenuItem)e.getSource() == view.getItem_delete()) {
			
			DeleteClientView deleteView = new DeleteClientView();
			
			DeleteClientModel deleteModel = new DeleteClientModel();
			
			DeleteClientController deleteController = new DeleteClientController(deleteView, deleteModel, user);
			
			
		} else if ((JMenuItem)e.getSource() == view.getItem_orderFood()) {
			
			CreateOrderView createOrderView = new CreateOrderView();
			
			CreateOrderModel createOrderModel = new CreateOrderModel();
			
			CreateOrderController createOrderController = new CreateOrderController(createOrderView, createOrderModel);
			
			
		}
		
		
		
	}
	
	

}
