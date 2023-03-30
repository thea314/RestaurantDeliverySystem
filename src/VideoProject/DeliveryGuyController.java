package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class DeliveryGuyController implements ActionListener {
	
	private DeliveryGuyView view;
	private User user;
	
	//constructor
	public DeliveryGuyController(DeliveryGuyView view, User user) {
		this.view = view;
		this.user = user;
		
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
					
					
					
				}
				//complete delivery
				if ((JMenuItem)e.getSource() == view.getItem_deliveryDone()) {
					
					
					
				}
				//view deliveries
				if ((JMenuItem)e.getSource() == view.getItem_deliveryView()) {
					
					
					
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
