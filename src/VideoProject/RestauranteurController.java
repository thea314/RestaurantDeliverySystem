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
		
		//actionlisteners
		view.getItem_accept().addActionListener(this);
		view.getItem_disconnect().addActionListener(this);
		view.getItem_quit().addActionListener(this);
		view.getItem_ready().addActionListener(this);
		
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
			
			AcceptOrderView acceptView = new AcceptOrderView();
			
			DBManager db = new DBManager();
			
			restauranteurId = db.getRestauranteurId(user.getUsername());
			
			AcceptOrderController acceptController = new AcceptOrderController(acceptView, restauranteurId, user);
			
		}
		//order ready
		if((JMenuItem)e.getSource() == view.getItem_ready()) {
			
			view.setVisible(false);
			view.dispose();
			
			OrderReadyView readyView = new OrderReadyView();
			
			DBManager db = new DBManager();
			
			restauranteurId = db.getRestauranteurId(user.getUsername());
			
			OrderReadyController readyController = new OrderReadyController(readyView, restauranteurId, user);
			
		}
		
		
	}

}
