package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener {

	//properties
	private LoginModel model;
	private LoginView view;
	public static User loggedUser;
	public static Client loggedClient;
		
	
	//constructor
	public LoginController (LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;
		
		//actionlisteners to buttons
		view.getBtn_newClient().addActionListener(this);
		view.getBtn_connect().addActionListener(this);
		view.getBtn_quit().addActionListener(this);
	}
	
	//add logic for buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == view.getBtn_connect()) {
			if ((model.validateUsername(view.getTxt_username().getText())) && (model.validatePassword(view.getTxt_password().getText()))) {
				
				DBManager login = new DBManager();
				
				if (login.loginCheck(view.getTxt_username().getText(), view.getTxt_password().getText() )) {
					
					// find user type and set logged in user 
					
					if (login.checkUserType(view.getTxt_username().getText()) == 2) {
						
						view.setVisible(false);
						view.dispose();
						
						loggedUser = new User(view.getTxt_username().getText(), view.getTxt_password().getText(), 2);
												
						ClientMenuView clientMenu = new ClientMenuView();
						
						ClientController controlClientMenu = new ClientController(clientMenu, loggedUser);					
						
					}
					
					if (login.checkUserType(view.getTxt_username().getText()) == 1) {
						
						view.setVisible(false);
						view.dispose();
						
						loggedUser = new User(view.getTxt_username().getText(), view.getTxt_password().getText(), 1);
						
						AdminView adminMenu = new AdminView();
						
						AdminController adminController = new AdminController(adminMenu, loggedUser);
						
					}
					
					if (login.checkUserType(view.getTxt_username().getText()) == 3) {
						
						view.setVisible(false);
						view.dispose();
						
						loggedUser = new User(view.getTxt_username().getText(), view.getTxt_password().getText(), 3);
						
						ManagerView managerView = new ManagerView();
						
						DBManager db = new DBManager();
						
						int managerId = db.getManagerId(view.getTxt_username().getText());
						
						ManagerController managerController = new ManagerController(managerView, managerId, loggedUser);
						
					}
					//restauranteur
					if (login.checkUserType(view.getTxt_username().getText()) == 4) {
						
						view.setVisible(false);
						view.dispose();
						
						loggedUser = new User(view.getTxt_username().getText(), view.getTxt_password().getText(), 4);
						
						RestauranteurView restoView = new RestauranteurView();
						
						DBManager db = new DBManager();
						
						int restauranteurId = db.getRestauranteurId(view.getTxt_username().getText());
						
						RestauranteurController restoController = new RestauranteurController(restoView, restauranteurId, loggedUser);
						
						
					}
					
			} else {
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Error", JOptionPane.INFORMATION_MESSAGE);
				view.setTxt_username(null);
				view.setTxt_password(null);
			}
		} else if((JButton)e.getSource() == view.getBtn_quit()) {
			System.exit(0);
		} else if ((JButton)e.getSource() == view.getBtn_newClient()) {
			
			AddClientMain newClient = new AddClientMain();
			
			newClient.runCreateNewClient();
			
			view.setVisible(false);
			view.dispose();
			
		}
		
		
	}
	
	
	
}
