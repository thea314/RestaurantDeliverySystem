package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class DeleteClientController implements ActionListener {
	
	private DeleteClientView view;
	private DeleteClientModel model;
	private Client client;
	
	public DeleteClientController(DeleteClientView view, DeleteClientModel model, User user) {
		this.view = view;
		this.model = model;
		
		//actionlisteners
		view.getBtn_delete().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		
		loadViewData(user);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == view.getBtn_delete()) {
			
			int confirmDelete = JOptionPane.showConfirmDialog(null, "Are you sure you want to close your account?");
			
			 if (confirmDelete == JOptionPane.YES_OPTION) {
				 
				 DBManager deleteClient = new DBManager();
				 
				 deleteClient.setAccountInactive(client.getUsername());
				 
				 JOptionPane.showMessageDialog(null,"Sorry to see you go!", "Account closed", JOptionPane.INFORMATION_MESSAGE);
				 
				 view.setVisible(false);
				 view.dispose();
				 
				 LoginView view = new LoginView();
					
				LoginModel model = new LoginModel();
					
				LoginController controlLogin = new LoginController(model, view);
				 
			 } else if (confirmDelete == JOptionPane.NO_OPTION) {
				 JOptionPane.showMessageDialog(null, "Thanks for sticking around!", "Canceled", JOptionPane.INFORMATION_MESSAGE);
			 } else {
				 JOptionPane.showMessageDialog(null, "Thanks for sticking around!", "Canceled", JOptionPane.INFORMATION_MESSAGE);
		}				
	} if ((JButton)e.getSource() == view.getBtn_cancel()) {
		
		ClientMenuView clientMenu = new ClientMenuView();
		
		ClientController controlClientMenu = new ClientController(clientMenu, client);	
		
	}
	
	}
	
private void loadViewData(User user) {
		
		DBManager callDB = new DBManager();
		
		client = callDB.populateClientInfoEdit(user.getUsername());
		
		view.getTxt_username().setText(client.getUsername());
		view.getTxt_lastName().setText(client.getLastName());
		view.getTxt_firstName().setText(client.getFirstName());
		view.getTxt_address().setText(client.getAddress());
		view.getTxt_email().setText(client.getEmail());
		view.getTxt_areaCode().setText(client.getAreaCode());
		view.getTxt_phone1().setText(client.getPhone1());
		view.getTxt_phone2().setText(client.getPhone2());
		
	}
	
}
