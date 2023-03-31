package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ManagerController implements ActionListener{
	
	private ManagerView view;
	private User user;
	private int managerId;
	
	//constructor
	public ManagerController(ManagerView view, int managerId, User user) {
		this.view = view;
		this.managerId = managerId;
		this.user = user;
		
		//actionlisteners
		view.getItem_disconnect().addActionListener(this);
		view.getItem_quit().addActionListener(this);
		view.getItem_viewOrder().addActionListener(this);
		
	}
	
	//add logic for each menu item
		@Override
		public void actionPerformed(ActionEvent e) {
			if ((JMenuItem)e.getSource() == view.getItem_disconnect()) {
				
				LoginController.loggedUser = new User("0", "0", 0);
				
				view.setVisible(false);
				view.dispose();
				
				LoginView view = new LoginView();
				
				LoginModel model = new LoginModel();
				
				LoginController controlLogin = new LoginController(model, view);
				
			}
			else if ((JMenuItem)e.getSource() == view.getItem_quit()) {
				
				System.exit(0);
				
			}
			else if ((JMenuItem)e.getSource() == view.getItem_viewOrder()) {
				
				view.setVisible(false);
				view.dispose();
				
				DBManager db = new DBManager();
				
				int managerId = db.getManagerId(user.getUsername());
				
				ManagerRestaurantOrderView manageView = new ManagerRestaurantOrderView();
				
				ManagerRestaurantOrderController manageController = new ManagerRestaurantOrderController(manageView, managerId);
				
			}
			
			
		}

}
