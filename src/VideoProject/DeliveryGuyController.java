package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class DeliveryGuyController implements ActionListener {
	
	private DeliveryGuyView view;
	private User user;
	private int deliveryGuyId;
	
	//constructor
	public DeliveryGuyController(DeliveryGuyView view, int deliveryGuyId, User user) {
		this.view = view;
		this.user = user;
		this.deliveryGuyId = deliveryGuyId;
		
		//actionlisteners
		view.getItem_acceptDelivery().addActionListener(this);
		view.getItem_deliveryDone().addActionListener(this);
		view.getItem_deliveryView().addActionListener(this);
		view.getItem_disconnect().addActionListener(this);
		view.getItem_quit().addActionListener(this);
		
	}
	
	//add logic for each menu item
			@Override
			public void actionPerformed(ActionEvent e) {
				//accept delivery
				if ((JMenuItem)e.getSource() == view.getItem_acceptDelivery()) {
					
					view.setVisible(false);
					view.dispose();
					
					AcceptDeliveryView deliveryView = new AcceptDeliveryView();
					
					AcceptDeliveryController deliveryController = new AcceptDeliveryController(deliveryView, deliveryGuyId, user);
					
				}
				//complete delivery
				if ((JMenuItem)e.getSource() == view.getItem_deliveryDone()) {
					
					view.setVisible(false);
					view.dispose();
					
					DeliveryDoneView doneView = new DeliveryDoneView();
					
					DeliveryDoneController doneController = new DeliveryDoneController(doneView, deliveryGuyId, user);
					
					
					
				}
				//view deliveries
				if ((JMenuItem)e.getSource() == view.getItem_deliveryView()) {
					
					view.setVisible(false);
					view.dispose();
					
					ViewDeliveriesView viewDeliveries = new ViewDeliveriesView();

					ViewDeliveriesController viewController = new ViewDeliveriesController(viewDeliveries, deliveryGuyId, user);
					
					
				}
				//disconnect
				if ((JMenuItem)e.getSource() == view.getItem_disconnect()) {
					
					LoginController.loggedUser = new User("0", "0", 0);
					
					view.setVisible(false);
					view.dispose();
					
					LoginView view = new LoginView();
					
					LoginModel model = new LoginModel();
					
					LoginController controlLogin = new LoginController(model, view);
					
				}
				//quit
				if ((JMenuItem)e.getSource() == view.getItem_quit()) {
					
					System.exit(0);
					
				}
				
			}

}
