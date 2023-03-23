package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CreateRestaurantController implements ActionListener {
	
	//properties
	CreateRestaurantView view = new CreateRestaurantView();
	CreateRestaurantModel model = new CreateRestaurantModel();
	private boolean managerValidated;
	private boolean restauranteurValidated;
	private String deliveryAreas;
	
	//constructor
	public CreateRestaurantController(CreateRestaurantView view, CreateRestaurantModel model) {
		this.view = view;
		this.model = model;
		
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
			
			deliveryAreas = deliveryAreas + " " + view.getTxt_deliveryArea();
			view.getTxtA_deliveryArea().setText(deliveryAreas);			
		}
		//deletes last item in delivery area
		if ((JButton)e.getSource() == view.getBtn_deleteDeliveryArea()) {
			
			if (deliveryAreas.length() >= 3) {
			String deliveryAreasDeleted = deliveryAreas.substring(deliveryAreas.lastIndexOf(" "), deliveryAreas.length() - 4);
			view.getTxtA_deliveryArea().setText(deliveryAreasDeleted);	
			}
			
		}
		if ((JButton)e.getSource() == view.getBtn_saveButton()) {
			//save to database
			if (validateJTextFieldsSave() && validateOpeningHours()) {
				
				
				
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
