package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RestauranteurController implements ActionListener {
	
	//properties
	private RestauranteurView view;
	private User user;
	private int restauranteurId;
	
	//constructor
	public RestauranteurController(RestauranteurView view, int restauranteurId, User user) {
		this.view = view;
		this.user = user;
		this.restauranteurId = restauranteurId;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//disconnect
		if((JMenuItem)e.getSource() == view.getItem_disconnect()) {
			
			LoginController.loggedUser = new User("0", "0", 0);
			
			view.setVisible(false);
			view.dispose();
			
			LoginView view = new LoginView();
			
			LoginModel model = new LoginModel();
			
			LoginController controlLogin = new LoginController(model, view);
			
		}
		//exit
		if((JMenuItem)e.getSource() == view.getItem_quit()) {
			
			System.exit(0);
			
		}
		//accept order
		if((JMenuItem)e.getSource() == view.getItem_accept()) {
			
			view.setVisible(false);
			view.dispose();
			
			
			
		}
		
		
	}

}
