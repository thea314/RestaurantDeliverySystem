package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CreateRestaurantController implements ActionListener {
	
	//properties
	CreateRestaurantView view;
	CreateRestaurantModel model;
	private boolean managerValidated;
	private boolean restauranteurValidated;
	private String deliveryAreas = "";
	private User user;
	
	//constructor
	public CreateRestaurantController(CreateRestaurantView view, CreateRestaurantModel model, User user) {
		this.view = view;
		this.model = model;
		this.user = user;
		
		//add actionlisteners for buttons
		view.getBtn_addDeliveryArea().addActionListener(this);
		view.getBtn_deleteDeliveryArea().addActionListener(this);
		view.getBtn_modifyAll().addActionListener(this);
		view.getBtn_saveButton().addActionListener(this);
		view.getBtn_validateManagerUsesname().addActionListener(this);
		view.getBtn_validateRestauranteurUsername().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		
	}
	
	DBManager validateUsernames = new DBManager();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//validate manager username to unlock restaurant validation button
		if ((JButton)e.getSource() == view.getBtn_validateManagerUsesname()) {
			managerValidated = validateUsernames.userNameCheck(view.getTxt_managerUsername().getText());
			if (managerValidated) {
				view.getBtn_validateRestauranteurUsername().setEnabled(true);
				view.getTxt_managerUsername().setEditable(false);
			}
			
		}
		// validate restauranteur username to unlock save button
		if ((JButton)e.getSource() == view.getBtn_validateRestauranteurUsername()) {
			managerValidated = validateUsernames.userNameCheck(view.getTxt_restaraunteurUsername().getText());
			if (managerValidated) {
				view.getBtn_saveButton().setEnabled(true);
				view.getTxt_restaraunteurUsername().setEditable(false);
			}
			
		}
		//modify all jcomboboxes based on Monday's hours
		if ((JButton)e.getSource() == view.getBtn_modifyAll()) {
			
			//get selected indices from Monday's data
			int mondayOpenHrIndex = view.getCombo_MonHrOpen().getSelectedIndex();
			int mondayOpenMinIndex = view.getCombo_MonMinOpen().getSelectedIndex();
			int mondayCloseHrIndex = view.getCombo_MonHrClose().getSelectedIndex();
			int mondayCloseMinIndex = view.getCombo_MonMinClose().getSelectedIndex();
			
			view.getCombo_TuesHrOpen().setSelectedIndex(mondayOpenHrIndex);
			view.getCombo_TuesMinOpen().setSelectedIndex(mondayOpenMinIndex);
			view.getCombo_TuesHrClose().setSelectedIndex(mondayCloseHrIndex);
			view.getCombo_TuesMinClose().setSelectedIndex(mondayCloseMinIndex);
			
			view.getCombo_WedHrOpen().setSelectedIndex(mondayOpenHrIndex);
			view.getCombo_WedMinOpen().setSelectedIndex(mondayOpenMinIndex);
			view.getCombo_WedHrClose().setSelectedIndex(mondayCloseHrIndex);
			view.getCombo_WedMinClose().setSelectedIndex(mondayCloseMinIndex);
			
			view.getCombo_ThursHrOpen().setSelectedIndex(mondayOpenHrIndex);
			view.getCombo_ThursMinOpen().setSelectedIndex(mondayOpenMinIndex);
			view.getCombo_ThursHrClose().setSelectedIndex(mondayCloseHrIndex);
			view.getCombo_ThursMinClose().setSelectedIndex(mondayCloseMinIndex);
			
			view.getCombo_FriHrOpen().setSelectedIndex(mondayOpenHrIndex);
			view.getCombo_FriMinOpen().setSelectedIndex(mondayOpenMinIndex);
			view.getCombo_FriHrClose().setSelectedIndex(mondayCloseHrIndex);
			view.getCombo_FriMinClose().setSelectedIndex(mondayCloseMinIndex);
			
			view.getCombo_SatHrOpen().setSelectedIndex(mondayOpenHrIndex);
			view.getCombo_SatMinOpen().setSelectedIndex(mondayOpenMinIndex);
			view.getCombo_SatHrClose().setSelectedIndex(mondayCloseHrIndex);
			view.getCombo_SatMinClose().setSelectedIndex(mondayCloseMinIndex);
			
			view.getCombo_SunHrOpen().setSelectedIndex(mondayOpenHrIndex);
			view.getCombo_SunMinOpen().setSelectedIndex(mondayOpenMinIndex);
			view.getCombo_SunHrClose().setSelectedIndex(mondayCloseHrIndex);
			view.getCombo_SunMinClose().setSelectedIndex(mondayCloseMinIndex);
			
		}
		//add delivery area to the delivery area string
		if ((JButton)e.getSource() == view.getBtn_addDeliveryArea()) {
			
			deliveryAreas = deliveryAreas + " " + view.getTxt_deliveryArea().getText();
			view.getTxtA_deliveryArea().setText(deliveryAreas);	
			
			view.getTxt_deliveryArea().setText("");
		}
		//deletes last item in delivery area
		if ((JButton)e.getSource() == view.getBtn_deleteDeliveryArea()) {
			
			if (deliveryAreas.length() >= 3) {
				deliveryAreas = deliveryAreas.substring(0, deliveryAreas.lastIndexOf(" "));
			
			} else
				deliveryAreas = "";
			
			view.getTxtA_deliveryArea().setText(deliveryAreas);	
			
		}
		if ((JButton)e.getSource() == view.getBtn_cancel()) {
			
			view.setVisible(false);
			view.dispose();
			
			 AdminView adminView = new AdminView();
			 
			 AdminController adminController = new AdminController(adminView, user);
			
		}
		
		if ((JButton)e.getSource() == view.getBtn_saveButton()) {
			//save to database
			if (validateJTextFieldsSave() && validateOpeningHours()) {				
				
				//define combobox values so they can be inserted into method
				
				int monHrOpen = Integer.parseInt((String)view.getCombo_MonHrOpen().getSelectedItem());						
				int monMinOpen = Integer.parseInt((String)view.getCombo_MonMinOpen().getSelectedItem());						
				int monHrClose = Integer.parseInt((String)view.getCombo_MonHrClose().getSelectedItem());						
				int monMinClose = Integer.parseInt((String)view.getCombo_MonMinClose().getSelectedItem());
										
				int tuesHrOpen = Integer.parseInt((String)view.getCombo_TuesHrOpen().getSelectedItem());						
				int tuesMinOpen = Integer.parseInt((String)view.getCombo_TuesMinOpen().getSelectedItem());						
				int tuesHrClose = Integer.parseInt((String)view.getCombo_TuesHrClose().getSelectedItem());						
				int tuesMinClose = Integer.parseInt((String)view.getCombo_TuesMinClose().getSelectedItem());
										
				int wedHrOpen = Integer.parseInt((String)view.getCombo_WedHrOpen().getSelectedItem());						
				int wedMinOpen = Integer.parseInt((String)view.getCombo_WedMinOpen().getSelectedItem());						
				int wedHrClose = Integer.parseInt((String)view.getCombo_WedHrClose().getSelectedItem());						
				int wedMinClose = Integer.parseInt((String)view.getCombo_WedMinClose().getSelectedItem());
										
				int thursHrOpen = Integer.parseInt((String)view.getCombo_ThursHrOpen().getSelectedItem());						
				int thursMinOpen = Integer.parseInt((String)view.getCombo_ThursMinOpen().getSelectedItem());						
				int thursHrClose = Integer.parseInt((String)view.getCombo_ThursHrClose().getSelectedItem());						
				int thursMinClose = Integer.parseInt((String)view.getCombo_ThursMinClose().getSelectedItem());
										
				int friHrOpen = Integer.parseInt((String)view.getCombo_FriHrOpen().getSelectedItem());						
				int friMinOpen = Integer.parseInt((String)view.getCombo_FriMinOpen().getSelectedItem());						
				int friHrClose = Integer.parseInt((String)view.getCombo_FriHrClose().getSelectedItem());						
				int friMinClose = Integer.parseInt((String)view.getCombo_FriMinClose().getSelectedItem());
										
				int satHrOpen = Integer.parseInt((String)view.getCombo_SatHrOpen().getSelectedItem());						
				int satMinOpen = Integer.parseInt((String)view.getCombo_SatMinOpen().getSelectedItem());						
				int satHrClose = Integer.parseInt((String)view.getCombo_SatHrClose().getSelectedItem());						
				int satMinClose = Integer.parseInt((String)view.getCombo_SatMinClose().getSelectedItem());
										
				int sunHrOpen = Integer.parseInt((String)view.getCombo_SunHrOpen().getSelectedItem());						
				int sunMinOpen = Integer.parseInt((String)view.getCombo_SunMinOpen().getSelectedItem());						
				int sunHrClose = Integer.parseInt((String)view.getCombo_SunHrClose().getSelectedItem());						
				int sunMinClose = Integer.parseInt((String)view.getCombo_SunMinClose().getSelectedItem());
				
				//confirm before saving
				//verify client info correct before saving
				 Object[][] rows = {{"Name", view.getTxt_restoName().getText()}, {"Address", view.getTxt_restoAddress().getText()},
						 {"Phone:", view.getTxt_restaurantAreaCode().getText() + " - " + view.getTxt_restaurantPhone1().getText() + " - " + view.getTxt_restaurantPhone2().getText()},
						 {"Monday Open", monHrOpen + "h" + monMinOpen}, {"Monday Close", monHrClose + "h" + monMinClose},
						 {"Tuesday Open", tuesHrOpen + "h" + tuesMinOpen}, {"Tuesday Close", tuesHrClose + "h" + tuesMinClose},
						 {"Wednesday Open", wedHrOpen + "h" + wedMinOpen}, {"Wednesday Close", wedHrClose + "h" + wedMinClose},
						 {"Thursday Open", thursHrOpen + "h" + thursMinOpen}, {"Thursday Close", thursHrClose + "h" + thursMinClose},
						 {"Friday Open", friHrOpen + "h" + friMinOpen}, {"Friday Close", friHrClose + "h" + friMinClose},
						 {"Saturday Open", satHrOpen + "h" + satMinOpen}, {"Saturday Close", satHrClose + "h" + satMinClose},
						 {"Sunday Open", sunHrOpen + "h" + sunMinOpen}, {"Sunday Close", sunHrClose + "h" + sunMinClose},
						 {"Delivery", view.getTxtA_deliveryArea().getText()}};
				 
				 Object[] cols = {
						 "Field", "Value"
				 };
				 
				 JTable confirmTable = new JTable(rows, cols);
				 
				 int confirmNewClient = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));
				 
				 if (confirmNewClient == JOptionPane.YES_OPTION) {
				
				DBManager saveResto = new DBManager();
				
				//save to restaurants table
				saveResto.createRestaurant(view.getTxt_restoName().getText(), view.getTxt_restoAddress().getText(),  
						view.getTxt_restaurantAreaCode().getText(), view.getTxt_restaurantPhone1().getText(),
						view.getTxt_restaurantPhone2().getText(), view.getTxt_managerUsername().getText(), 
						 view.getTxt_managerPassword().getText(),  view.getTxt_restaraunteurUsername().getText(), 
						 view.getTxt_restauranteurPassword().getText(),  view.getTxtA_deliveryArea().getText(), monHrOpen, monMinOpen,
						monHrClose, monMinClose, tuesHrOpen, tuesMinOpen, tuesHrClose, tuesMinClose, wedHrOpen, wedMinOpen,
						wedHrClose, wedMinClose, thursHrOpen, thursMinOpen, thursHrClose, thursMinClose, friHrOpen,
						friMinOpen, friHrClose, friMinClose, satHrOpen, satMinOpen, satHrClose, satMinClose,
					 sunHrOpen, sunMinOpen, sunHrClose, sunMinClose);
				
				//add manager and restauranteur to users menu
				saveResto.addUser(view.getTxt_managerUsername().getText(), view.getTxt_managerPassword().getText(), 3);
				saveResto.addUser(view.getTxt_restaraunteurUsername().getText(), view.getTxt_restauranteurPassword().getText(), 4);
				
				//get restautantId
				int restoId = saveResto.getRestaurantId(view.getTxt_restoName().getText(), view.getTxt_restoAddress().getText(),
						view.getTxt_restaurantAreaCode().getText());
				
				//create manager
				saveResto.addManager(view.getTxt_managerUsername().getText(), view.getTxt_managerPassword().getText(), restoId);
				
				//create restauranteur
				saveResto.addRestauranteur(view.getTxt_restaraunteurUsername().getText(), view.getTxt_restauranteurPassword().getText(), restoId);
				 JOptionPane.showMessageDialog(null, "Restaurant successfully created, you may take orders.", "Success", JOptionPane.INFORMATION_MESSAGE);
				 
				 view.setVisible(false);
					view.dispose();
					
					 AdminView adminView = new AdminView();
					 
					 AdminController adminController = new AdminController(adminView, user);
				 
				 
				 } else if (confirmNewClient == JOptionPane.NO_OPTION) {
					 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
				 } else {
					 JOptionPane.showMessageDialog(null, "Please fill out form.", "Error", JOptionPane.INFORMATION_MESSAGE);
				 }
			}
			
		}
		
	}
	
	//function to simplify validation of textfields in view
	public boolean validateJTextFieldsSave() {
		
		if ((model.validateRestoName(view.getTxt_restoName().getText()) && (model.validateRestoAddress(view.getTxt_restoAddress().getText()) && 
				(model.validateareaCode(view.getTxt_restaurantAreaCode().getText()) && (model.validatePhone1(view.getTxt_restaurantPhone1().getText()) &&
						(model.validatePhone2(view.getTxt_restaurantPhone2().getText()) && (model.validateUsername(view.getTxt_managerUsername().getText()) &&
								(model.validateUsername(view.getTxt_restaraunteurUsername().getText()) &&
										(model.validatePassword(view.getTxt_managerPassword().getText()) && 
												(model.validatePassword(view.getTxt_restauranteurPassword().getText()))))))))))) {
			return true;
		} else
			return false;
		
		
	}
	
	//function to simplify validation of comboboxes
	public boolean validateOpeningHours() {
		
		//get integer values from comboboxes
		
		int monHrOpen = (Integer)(view.getCombo_MonHrOpen().getSelectedIndex());
		int monHrClose = (Integer)(view.getCombo_MonHrClose().getSelectedIndex());
		
		int tuesHrOpen = (Integer)(view.getCombo_TuesHrOpen().getSelectedIndex());
		int tuesHrClose = (Integer)(view.getCombo_TuesHrClose().getSelectedIndex());
		
		int wedHrOpen = (Integer)(view.getCombo_WedHrOpen().getSelectedIndex());
		int wedHrClose = (Integer)(view.getCombo_WedHrClose().getSelectedIndex());
		
		int thursHrOpen = (Integer)(view.getCombo_ThursHrOpen().getSelectedIndex());
		int thursHrClose = (Integer)(view.getCombo_ThursHrClose().getSelectedIndex());
		
		int friHrOpen = (Integer)(view.getCombo_FriHrOpen().getSelectedIndex());
		int friHrClose = (Integer)(view.getCombo_FriHrClose().getSelectedIndex());
		
		int satHrOpen = (Integer)(view.getCombo_SatHrOpen().getSelectedIndex());
		int satHrClose = (Integer)(view.getCombo_SatHrClose().getSelectedIndex());
		
		int sunHrOpen = (Integer)(view.getCombo_SunHrOpen().getSelectedIndex());
		int sunHrClose = (Integer)(view.getCombo_SunHrClose().getSelectedIndex());
		
		if ((model.compareHoursofOpening(monHrOpen, monHrClose)) && (model.compareHoursofOpening(tuesHrOpen, tuesHrClose)) && 
				(model.compareHoursofOpening(wedHrOpen, wedHrClose)) && (model.compareHoursofOpening(thursHrOpen, thursHrClose)) &&
				(model.compareHoursofOpening(friHrOpen, friHrClose)) && (model.compareHoursofOpening(satHrOpen, satHrClose)) &&
				(model.compareHoursofOpening(sunHrOpen, sunHrClose))) {
			return true;
		} else
			return false;
	}

}
