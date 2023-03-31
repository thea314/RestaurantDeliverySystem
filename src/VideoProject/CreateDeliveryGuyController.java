package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CreateDeliveryGuyController implements ActionListener {

	//properties
	CreateDeliveryGuyView view;
	CreateDeliveryGuyModel model;
	User user;
	private String deliveryAreas = "";

	//constructor
	public CreateDeliveryGuyController(CreateDeliveryGuyView view, CreateDeliveryGuyModel model) {
		this.view = view;
		this.model = model;

		//actionlisteners
		view.getBtn_addArea().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_delete().addActionListener(this);
		view.getBtn_save().addActionListener(this);
		view.getBtn_validateUsername().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//cancel
		if ((JButton)e.getSource() == view.getBtn_cancel()) {

			view.setVisible(false);
			view.dispose();

			AdminView adminView = new AdminView();

			AdminController adminController = new AdminController(adminView, user);

		}
		//validate username
		if ((JButton)e.getSource() == view.getBtn_validateUsername()) {	

			DBManager newDelivery = new DBManager();

			if (newDelivery.userNameCheck(view.getTxt_username().getText())) {
				JOptionPane.showMessageDialog(null, "Username available.", "Success", JOptionPane.INFORMATION_MESSAGE);
				view.getBtn_save().setEnabled(true);
			} else
				JOptionPane.showMessageDialog(null, "Username already taken, try again", "Error", JOptionPane.INFORMATION_MESSAGE);				
		} 
		//add delivery area to the delivery area string
				if ((JButton)e.getSource() == view.getBtn_addArea()) {
					
					deliveryAreas = deliveryAreas + " " + view.getTxt_addArea().getText();
					view.getTxtArea_deliveryArea().setText(deliveryAreas);	
					
					view.getTxt_addArea().setText("");
				}
				//deletes last item in delivery area
				if ((JButton)e.getSource() == view.getBtn_delete()) {
					
					if (deliveryAreas.length() >= 3) {
						deliveryAreas = deliveryAreas.substring(0, deliveryAreas.lastIndexOf(" "));
					
					} else
						deliveryAreas = "";
					
					view.getTxtArea_deliveryArea().setText(deliveryAreas);	
				}
		//saves delivery guy to db
		if((JButton)e.getSource() == view.getBtn_save()) {
			//validate form inputs
			if((model.validateareaCode(view.getTxt_areaCode().getText()) && (model.validateDeliveryArea(view.getTxtArea_deliveryArea().getText()) &&
					(model.validateName(view.getTxt_driverName().getText()) && (model.validateNumeric(view.getTxt_areaCode().getText()) && 
							(model.validateNumeric(view.getTxt_phone1().getText()) && (model.validateNumeric(view.getTxt_phone2().getText()) &&
									(model.validatePassword(view.getTxt_password().getText()) && (model.validatePhone1(view.getTxt_phone1().getText()) &&
											(model.validatePhone2(view.getTxt_phone2().getText()))))))))))) {

				//ask user to confirm data before entry into db

				Object[][] rows = {{"Username", view.getTxt_username().getText()}, {"Name", view.getTxt_driverName().getText()},
						{"Delivery Area", view.getTxtArea_deliveryArea().getText()},						 
						{"Phone:", view.getTxt_areaCode().getText() + " - " + view.getTxt_phone1().getText() + " - " + view.getTxt_phone2().getText()}};

				Object[] cols = {
						"Field", "Value"
				};

				JTable confirmTable = new JTable(rows, cols);

				int confirmNewClient = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));

				if (confirmNewClient == JOptionPane.YES_OPTION) {
					
					//create delivery guy and corresponding user
					DBManager newDelivery = new DBManager();
					
					newDelivery.createDeliveryGuy(view.getTxt_driverName().getText(), view.getTxt_areaCode().getText(),
							view.getTxt_phone1().getText(), view.getTxt_phone2().getText(), view.getTxtArea_deliveryArea().getText(),
							view.getTxt_username().getText(), view.getTxt_password().getText());
					
					newDelivery.addUser(view.getTxt_username().getText(), view.getTxt_password().getText(), 5);
					
					JOptionPane.showMessageDialog(null, "Delivery guy successfully created, you may login.", "Success", JOptionPane.INFORMATION_MESSAGE);
					
					

				}else if (confirmNewClient == JOptionPane.NO_OPTION) {
					 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
				 } else {
					 
					 AdminView adminView = new AdminView();
					 
					 AdminController adminController = new AdminController(adminView, user);
					 
				 }
				 
				
				


			}

		}

	}
}
