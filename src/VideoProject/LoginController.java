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
					System.out.println("database works");
				} else {
					System.out.println("error");
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
