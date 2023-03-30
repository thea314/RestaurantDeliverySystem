package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteurController implements ActionListener {
	
	//properties
	private RestauranteurView view;
	private User user;
	
	//constructor
	public RestauranteurController(RestauranteurView view, User user) {
		this.view = view;
		this.user = user;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
