package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditClientController implements ActionListener {
	
	//properties
	private EditClientView view;
	private EditClientModel model;
	private Client client;
	
	//contructor
	public EditClientController(EditClientView view, EditClientModel model, User user) {
		this.view = view;
		this.model = model;

		
		//add actionlisteners
		view.getBtn_return().addActionListener(this);
		view.getBtn_save().addActionListener(this);
		
		loadViewData(user);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton)e.getSource() == view.getBtn_save()) {
			// for edit client without password update
			if ((view.getTxt_newPassword().getText().equals("") && view.getTxt_confirmNewPassword().getText().equals(""))) {
				if ((validateUserWithoutPasswords())) {
					//confirm old password
					DBManager askPassword = new DBManager();
					String oldPassword = view.getTxt_oldPassword().getText();
					String oldPasswordFromDB = askPassword.passwordMatch(view.getTxt_username().getText());
					
					if (oldPasswordFromDB.equals(oldPassword)) {
						
						//verify client info correct before saving
						 Object[][] rows = {{"Username", view.getTxt_username().getText()}, {"Last Name", view.getTxt_lastname().getText()},
								 {"First name", view.getTxt_firstname().getText()}, {"Address", view.getTxt_address().getText()},
								 {"Email", view.getTxt_email().getText()},
								 {"Phone:", view.getTxt_areaCode().getText() + " - " + view.getTxt_phone1().getText() + " - " + view.getTxt_phone2().getText()}};
						 
						 Object[] cols = {
								 "Field", "Value"
						 };
						 
						 JTable confirmTable = new JTable(rows, cols);
						 
						 int confirmNewClient = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));
						 
						 if (confirmNewClient == JOptionPane.YES_OPTION) {
							//update DB after confirmation
							 	askPassword.updateUserWithoutPassword(view.getTxt_username().getText(), view.getTxt_lastname().getText(), view.getTxt_firstname().getText(), view.getTxt_address().getText(), 
										view.getTxt_email().getText(), view.getTxt_areaCode().getText(), view.getTxt_phone1().getText(), view.getTxt_phone2().getText());
								JOptionPane.showMessageDialog(null, "Update Sucsessful!", "Success", JOptionPane.INFORMATION_MESSAGE);			
							 } else if (confirmNewClient == JOptionPane.NO_OPTION) {
								 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
							 } else {
								 
									view.setVisible(false);
									view.dispose();
									
									ClientMenuView clientMenu = new ClientMenuView();
									
									ClientController controlClientMenu = new ClientController(clientMenu, client);	
							 }												
					}	
			//determine if all fields are completed with old/new password for edit with password update
			}else if ((validateUserWithPasswords())) {
				//verify new passwords are identical
				if (model.confirmPasswords(view.getTxt_newPassword().getText(), view.getTxt_confirmNewPassword().getText())) {
					//confirm the old password
					DBManager askPassword = new DBManager();
					String oldPassword = view.getTxt_oldPassword().getText();
					String oldPasswordFromDB = askPassword.passwordMatch(view.getTxt_username().getText());
					
					if (oldPasswordFromDB.equals(oldPassword)) {
						
						Object[][] rows = {{"Username", view.getTxt_username().getText()}, {"Last Name", view.getTxt_lastname().getText()},
								 {"First name", view.getTxt_firstname().getText()}, {"Address", view.getTxt_address().getText()},
								 {"Email", view.getTxt_email().getText()},
								 {"Phone:", view.getTxt_areaCode().getText() + " - " + view.getTxt_phone1().getText() + " - " + view.getTxt_phone2().getText()}};
						 
						 Object[] cols = {
								 "Field", "Value"
						 };
						 
						 JTable confirmTable = new JTable(rows, cols);
						 
						 int confirmNewClient = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));
						 
						 if (confirmNewClient == JOptionPane.YES_OPTION) {
						//update db
						askPassword.updateUserWithPassword(view.getTxt_username().getText(), view.getTxt_newPassword().getText(), view.getTxt_lastname().getText(),
								view.getTxt_firstname().getText(), view.getTxt_address().getText(), view.getTxt_email().getText(), 
								view.getTxt_areaCode().getText(), view.getTxt_phone1().getText(), view.getTxt_phone2().getText());
						askPassword.updateUserPasswordTable(view.getTxt_username().getText(), view.getTxt_newPassword().getText());
						JOptionPane.showMessageDialog(null, "Update Sucsessful!", "Succes", JOptionPane.INFORMATION_MESSAGE);
						 }else if (confirmNewClient == JOptionPane.NO_OPTION) {
							 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
						 } else {
							 
								view.setVisible(false);
								view.dispose();
								
								ClientMenuView clientMenu = new ClientMenuView();
								
								ClientController controlClientMenu = new ClientController(clientMenu, client);	
						 }
					} 
				}				
			}  					
				}
			
			
		} if ((JButton)e.getSource() == view.getBtn_return()) {
			
			view.setVisible(false);
			view.dispose();
			
			ClientMenuView clientMenu = new ClientMenuView();
			
			ClientController controlClientMenu = new ClientController(clientMenu, client);	
			
		}
			}
		
		
		
	
	
	private void loadViewData(User user) {
		
		DBManager callDB = new DBManager();
		
		client = callDB.populateClientInfoEdit(user.getUsername());
		
		view.getTxt_username().setText(client.getUsername());
		view.getTxt_lastname().setText(client.getLastName());
		view.getTxt_firstname().setText(client.getFirstName());
		view.getTxt_address().setText(client.getAddress());
		view.getTxt_email().setText(client.getEmail());
		view.getTxt_areaCode().setText(client.getAreaCode());
		view.getTxt_phone1().setText(client.getPhone1());
		view.getTxt_phone2().setText(client.getPhone2());
		
	}
	
	private boolean validateUserWithPasswords() {
		
		if ((model.validatePassword(view.getTxt_oldPassword().getText()) && (model.validatePassword(view.getTxt_newPassword().getText())) && 
				(model.validateConfirmNewPassword(view.getTxt_confirmNewPassword().getText())) && (model.validateLastName(view.getTxt_lastname().getText())) &&
				(model.validateFirstName(view.getTxt_firstname().getText())) && (model.validateAddress(view.getTxt_address().getText())) &&
				(model.validateEmail(view.getTxt_email().getText())) && (model.validateareaCode(view.getTxt_areaCode().getText())) && 
				(model.validatePhone1(view.getTxt_phone1().getText())) && (model.validatePhone2(view.getTxt_phone2().getText())))) {
			return true;
		} else
			return false;
				
	}
	
	private boolean validateUserWithoutPasswords() {
		
		if ((model.validateOldPassword(view.getTxt_oldPassword().getText()) && (model.validateLastName(view.getTxt_lastname().getText())) &&
				(model.validateFirstName(view.getTxt_firstname().getText())) && (model.validateAddress(view.getTxt_address().getText())) &&
				(model.validateEmail(view.getTxt_email().getText())) && (model.validateareaCode(view.getTxt_areaCode().getText())) && 
				(model.validatePhone1(view.getTxt_phone1().getText())) && (model.validatePhone2(view.getTxt_phone2().getText())))) {
			return true;
		} else
			return false;
		
		
	}
	
	

}
