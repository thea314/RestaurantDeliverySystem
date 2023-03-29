package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class AdminController implements ActionListener {
	
	//properties
	private AdminView view;
	private User user;
	private Restaurant restaurant;
	private DeliveryGuy deliveryGuy;
	
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
				
				view.setVisible(false);
				view.dispose();
				
				EditRestaurantView editRestoView = new EditRestaurantView();
				
				EditRestaurantModel editRestoModel = new EditRestaurantModel();
				
				EditRestaurantController editRestoController = new EditRestaurantController(editRestoView, editRestoModel, restaurant);
				
				
			}
			//delete resto button
			if((JMenuItem)e.getSource() == view.getItem_deleteResto()) {
				
				view.setVisible(false);
				view.dispose();
				
				DeleteRestaurantView deleteRestoView = new DeleteRestaurantView();
				
				DeleteRestaurantModel deleteRestoModel = new DeleteRestaurantModel();
				
				DeleteRestaurantController deleteRestoController = new DeleteRestaurantController(deleteRestoView, deleteRestoModel, restaurant);
			}
			//create menu
			if((JMenuItem)e.getSource() == view.getItem_menuCreate()) {
				
				view.setVisible(false);
				view.dispose();
				
				CreateMenuView createMenuView = new CreateMenuView();
				
				CreateMenuModel createMenuModel = new CreateMenuModel();
				
				CreateMenuController createMenuController = new CreateMenuController(createMenuView, createMenuModel);
				
			}
			//edit menu
			if ((JMenuItem)e.getSource() == view.getItem_menuEdit()) {
				
				view.setVisible(false);
				view.dispose();
				
				EditMenuView editMenuView = new EditMenuView();
				
				EditMenuModel editMenuModel = new EditMenuModel();
				
				EditMenuController editMenuController = new EditMenuController(editMenuView, editMenuModel);
				
			}
			//delete menu
			if ((JMenuItem)e.getSource() == view.getItem_menuDelete()) {
				
				view.setVisible(false);
				view.dispose();
				
				DeleteMenuView deleteMenuView = new DeleteMenuView();
				
				DeleteMenuModel deleteMenuModel = new DeleteMenuModel();
				
				DeleteMenuController deleteMenuController = new DeleteMenuController(deleteMenuView, deleteMenuModel);
				
				
			}
			//add delivery guy
			if ((JMenuItem)e.getSource() == view.getItem_createDeliveryGuy()) {
				
				view.setVisible(false);
				view.dispose();
				
				CreateDeliveryGuyView createDeliveryView = new CreateDeliveryGuyView();
				
				CreateDeliveryGuyModel createDeliveryModel = new CreateDeliveryGuyModel();
				
				CreateDeliveryGuyController createDeliveryController = new CreateDeliveryGuyController(createDeliveryView, createDeliveryModel);
				
			}
			//edit delivery guy
			if((JMenuItem)e.getSource() == view.getItem_editDeliveryGuy()) {
				
				view.setVisible(false);
				view.dispose();
				
				EditDeliveryGuyView editDeliveryGuyView = new EditDeliveryGuyView();
				
				EditDeliveryGuyModel editDeliveryGuyModel = new EditDeliveryGuyModel();
				
				EditDeliveryGuyController editDeliveryGuyController = new EditDeliveryGuyController(editDeliveryGuyView, editDeliveryGuyModel, deliveryGuy);
				
			}
			//delete delivery guy
			
			view.setVisible(false);
			view.dispose();
			
			DeleteDeliveryGuyView deleteDeliveryGuyView = new DeleteDeliveryGuyView();
			
			DeleteDeliveryGuyModel deleteDeliveryGuyModel = new DeleteDeliveryGuyModel();
			
			DeleteDeliveryGuyController deleteDeliveryGuyController = new DeleteDeliveryGuyController(deleteDeliveryGuyView, deleteDeliveryGuyModel, deliveryGuy);
			
			
		}

}
