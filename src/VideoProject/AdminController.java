package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class AdminController implements ActionListener {
	
	//properties
	private AdminView view;
	private User user;
	private Restaurant restaurant;
	
	//constructor
	public AdminController(AdminView view, User user) {
		this.view = view;
		this.user = user;
		
		//add actionlisteners to menu items
		view.getItem_createDeliveryGuy().addActionListener(this);
		view.getItem_createDeliveryGuy().addActionListener(this);
		view.getItem_deleteDeliveryGuy().addActionListener(this);
		view.getItem_deleteResto().addActionListener(this);
		view.getItem_Disconnect().addActionListener(this);
		view.getItem_editDeliveryGuy().addActionListener(this);
		view.getItem_editResto().addActionListener(this);
		view.getItem_menuCreate().addActionListener(this);
		view.getItem_menuDelete().addActionListener(this);
		view.getItem_menuEdit().addActionListener(this);
		view.getItem_quit().addActionListener(this);
		view.getItem_addResto().addActionListener(this);

		
	}
	
	//add logic for each menu item
		@Override
		public void actionPerformed(ActionEvent e) {
			if((JMenuItem)e.getSource() == view.getItem_addResto()) {
				
				view.setVisible(false);
				view.dispose();
				
				CreateRestaurantView viewCreateResto = new CreateRestaurantView();
				
				CreateRestaurantModel modelCreateResto = new CreateRestaurantModel();
				
				CreateRestaurantController controllerCreateResto = new CreateRestaurantController(viewCreateResto, modelCreateResto);
				
			}
			//edit resto button
			if((JMenuItem)e.getSource() == view.getItem_editResto()) {
				
				EditRestaurantView editRestoView = new EditRestaurantView();
				
				EditRestaurantModel editRestoModel = new EditRestaurantModel();
				
				EditRestaurantController editRestoController = new EditRestaurantController(editRestoView, editRestoModel, restaurant);
				
				
			}
			
			
			
		}

}
