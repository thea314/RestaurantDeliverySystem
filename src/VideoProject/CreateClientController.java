package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CreateClientController implements ActionListener {
	
	//properties
	private CreateClientView view;
	private CreateClientModel model;
	
	DBManager newClient = new DBManager();
	
	//constructor
	public CreateClientController(CreateClientView view, CreateClientModel model) {
		this.view = view;
		this.model = model;
		
		//actionlisteners for buttons on form
		view.getBtn_usernameValidate().addActionListener(this);
		view.getBtn_save().addActionListener(this);
		view.getBtn_return().addActionListener(this);
		view.getBtn_quit().addActionListener(this);
	}
	
	//add logic for buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		//button to validate unique username
		if ((JButton)e.getSource() == view.getBtn_usernameValidate()) {		
			if (newClient.userNameCheck(view.getTxt_username().getText())) {
				JOptionPane.showMessageDialog(null, "Username available.", "Success", JOptionPane.INFORMATION_MESSAGE);
				view.btn_save.setEnabled(true);
			} else
				JOptionPane.showMessageDialog(null, "Username already taken, try again", "Error", JOptionPane.INFORMATION_MESSAGE);				
			} 
		// quit button
		 else if((JButton)e.getSource() == view.getBtn_quit()) {
			System.exit(0);
		}
		//return button
		 else if ((JButton)e.getSource() == view.getBtn_return()) {
			
			 Main main = new Main();
			 
			 main.main(null);
			 
				view.setVisible(false);
				view.dispose();
		//add new client button	 
		 } else if ((JButton)e.getSource() == view.getBtn_save()) {
			 if (newClient.userNameCheck(view.getTxt_username().getText())) {				 
				 if ((model.confirmPasswords(view.getTxt_password().getText(), view.getTxt_confirmPassword().getText()))) {
					 if ((model.validateUsername(view.getTxt_username().getText()) && (model.validatePassword(view.getTxt_password().getText()) && (model.validateLastName(view.getTxt_lastname().getText()) && (model.validateFirstName(view.getTxt_firstname().getText()) && (model.validateAddress(view.getTxt_address().getText()) && (model.validateEmail(view.getTxt_email().getText()) && (model.validateareaCode(view.getTxt_areacode().getText()) && (model.validatePhone1(view.getTxt_phone1().getText()) && (model.validatePhone2(view.getTxt_phone2().getText()))))))))))){
						 
						 //verify client info correct before saving
						 Object[][] rows = {{"Username", view.getTxt_username().getText()}, {"Last Name", view.getTxt_lastname().getText()},
								 {"First name", view.getTxt_firstname().getText()}, {"Address", view.getTxt_address().getText()},
								 {"Email", view.getTxt_email().getText()},
								 {"Phone:", view.getTxt_areacode().getText() + " - " + view.getTxt_phone1().getText() + " - " + view.getTxt_phone2().getText()}};
						 
						 Object[] cols = {
								 "Field", "Value"
						 };
						 
						 JTable confirmTable = new JTable(rows, cols);
						 
						 int confirmNewClient = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));
						 
						 if (confirmNewClient == JOptionPane.YES_OPTION) {
							//add new client to client and user tables in database
							 newClient.addClient(view.getTxt_username().getText(), view.getTxt_password().getText(), view.getTxt_lastname().getText(), view.getTxt_firstname().getText(), view.getTxt_address().getText(), view.getTxt_email().getText(), view.getTxt_areacode().getText(), view.getTxt_phone1().getText(), view.getTxt_phone2().getText());
							 newClient.addUser(view.getTxt_username().getText(), view.getTxt_password().getText(), 2);		
							 JOptionPane.showMessageDialog(null, "Client successfully created, you may login..", "Success", JOptionPane.INFORMATION_MESSAGE);
						 } else if (confirmNewClient == JOptionPane.NO_OPTION) {
							 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
						 } else {
							 Main main = new Main();
							 
							 main.main(null);
						 }
 
					 } else
						 JOptionPane.showMessageDialog(null, "Please fill out form.", "Error", JOptionPane.INFORMATION_MESSAGE);	
					 
			 }
		 }
				 
			 
		 }
	}
	
	
	
	
	

}
