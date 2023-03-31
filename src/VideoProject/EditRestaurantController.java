package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EditRestaurantController implements ActionListener, ListSelectionListener {
	
	private EditRestaurantView view;
	private EditRestaurantModel model;
	private String deliveryAreas = "";
	JTable tempTable;
	private int restoId;
	Restaurant restaurant;
	User user;
	
	public EditRestaurantController(EditRestaurantView view, EditRestaurantModel model, Restaurant restaurant) {
		this.view = view;
		this.model = model;

		
		//actionlisteners
		view.getBtn_addDeliveryArea().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_deleteDeliveryArea().addActionListener(this);
		view.getBtn_modifyAll().addActionListener(this);
		view.getBtn_saveButton().addActionListener(this);
		
		DBManager populateTable = new DBManager();
		
		Object[] cols = {"Restaurant"};
		
		Object[] rows = populateTable.restaurantName().toArray(new Object[populateTable.restaurantName().size()]);
		
		tempTable = view.getRestoList();
		DefaultTableModel tableModel = (DefaultTableModel) tempTable.getModel();
		tableModel.setColumnIdentifiers(cols);
		
		for (int i = 0; i < rows.length; i++) {
		tableModel.addRow(new Object[]{rows[i]});
		}
		
		tempTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = tempTable.getSelectionModel();
		
		selectionModel.addListSelectionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

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
				//updates all comboboxes based on Monday's values
				if((JButton)e.getSource() == view.getBtn_modifyAll()) {
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
				//save
				if((JButton)e.getSource() == view.getBtn_saveButton()) {
					
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
						
						//update values in db
						saveResto.updateRestaurant(restoId, view.getTxt_restoName().getText(), view.getTxt_restoAddress().getText(),  
								view.getTxt_restaurantAreaCode().getText(), view.getTxt_restaurantPhone1().getText(),
								view.getTxt_restaurantPhone2().getText(),  view.getTxtA_deliveryArea().getText(), monHrOpen, monMinOpen,
								monHrClose, monMinClose, tuesHrOpen, tuesMinOpen, tuesHrClose, tuesMinClose, wedHrOpen, wedMinOpen,
								wedHrClose, wedMinClose, thursHrOpen, thursMinOpen, thursHrClose, thursMinClose, friHrOpen,
								friMinOpen, friHrClose, friMinClose, satHrOpen, satMinOpen, satHrClose, satMinClose,
							 sunHrOpen, sunMinOpen, sunHrClose, sunMinClose);
						
						JOptionPane.showMessageDialog(null, "Update Complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						 }else if (confirmNewClient == JOptionPane.NO_OPTION) {
							 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
						 } else {
							 JOptionPane.showMessageDialog(null, "Please fill out form.", "Error", JOptionPane.INFORMATION_MESSAGE);
						 }
						 
					}
					

				}
				//cancel
				if ((JButton)e.getSource() == view.getBtn_cancel()) {
					
					view.setVisible(false);
					view.dispose();
					
					AdminView adminView = new AdminView();
					
					AdminController adminController = new AdminController(adminView, user);
					
				}
				
				
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		//takes selection from JTable
		String tableCellContent = "";
		
		if (event.getValueIsAdjusting()) {
									
			tableCellContent = tempTable.getValueAt(tempTable.getSelectedRow(), 0).toString();
			
			String positionOfRestoId = tableCellContent.substring(0, tableCellContent.indexOf(" "));
			
			restoId = Integer.parseInt(positionOfRestoId);
			
			DBManager callDB = new DBManager();
			
			restaurant = callDB.getRestautantFromId(restoId);
			
			loadData(restaurant);
		} 
		
		
		
			
	}
	
	private void loadData(Restaurant restaurant) {
		
		view.getTxt_restoName().setText(restaurant.getRestaurantName());
		view.getTxt_restoAddress().setText(restaurant.getRestaurantAddress());
		view.getTxt_restaurantAreaCode().setText(restaurant.getRestaurantAreaCode());
		view.getTxt_restaurantPhone1().setText(restaurant.getRestaurantPhone1());
		view.getTxt_restaurantPhone2().setText(restaurant.getRestaurantPhone2());
		view.getTxtA_deliveryArea().setText(restaurant.getDeliveryArea());
		comboBoxPopulator(view.getCombo_MonHrOpen(), restaurant.getCombo_MonHrOpen());
		comboBoxPopulator(view.getCombo_MonMinOpen(), restaurant.getCombo_MonMinOpen());
		comboBoxPopulator(view.getCombo_MonHrClose(), restaurant.getCombo_MonHrClose());
		comboBoxPopulator(view.getCombo_MonMinClose(), restaurant.getCombo_MonMinClose());
		comboBoxPopulator(view.getCombo_TuesHrOpen(), restaurant.getCombo_TuesHrOpen());
		comboBoxPopulator(view.getCombo_TuesMinOpen(), restaurant.getCombo_TuesMinOpen());
		comboBoxPopulator(view.getCombo_TuesHrClose(), restaurant.getCombo_TuesHrClose());
		comboBoxPopulator(view.getCombo_TuesMinClose(), restaurant.getCombo_TuesMinClose());
		comboBoxPopulator(view.getCombo_WedHrOpen(), restaurant.getCombo_WedHrOpen());
		comboBoxPopulator(view.getCombo_WedMinOpen(), restaurant.getCombo_WedMinOpen());
		comboBoxPopulator(view.getCombo_WedHrClose(), restaurant.getCombo_WedHrClose());
		comboBoxPopulator(view.getCombo_WedMinClose(), restaurant.getCombo_WedMinClose());
		comboBoxPopulator(view.getCombo_ThursHrOpen(), restaurant.getCombo_ThursHrOpen());
		comboBoxPopulator(view.getCombo_ThursMinOpen(), restaurant.getCombo_ThursMinOpen());
		comboBoxPopulator(view.getCombo_ThursHrClose(), restaurant.getCombo_ThursHrClose());
		comboBoxPopulator(view.getCombo_ThursMinClose(), restaurant.getCombo_ThursMinClose());
		comboBoxPopulator(view.getCombo_FriHrOpen(), restaurant.getCombo_FriHrOpen());
		comboBoxPopulator(view.getCombo_FriMinOpen(), restaurant.getCombo_FriMinOpen());
		comboBoxPopulator(view.getCombo_FriHrClose(), restaurant.getCombo_FriHrClose());
		comboBoxPopulator(view.getCombo_FriMinClose(), restaurant.getCombo_FriMinClose());
		comboBoxPopulator(view.getCombo_SatHrOpen(), restaurant.getCombo_SatHrOpen());
		comboBoxPopulator(view.getCombo_SatMinOpen(), restaurant.getCombo_SatMinOpen());
		comboBoxPopulator(view.getCombo_SatHrClose(), restaurant.getCombo_SatHrClose());
		comboBoxPopulator(view.getCombo_SatMinClose(), restaurant.getCombo_SatMinClose());
		comboBoxPopulator(view.getCombo_SunHrOpen(), restaurant.getCombo_SunHrOpen());
		comboBoxPopulator(view.getCombo_SunMinOpen(), restaurant.getCombo_SunMinOpen());
		comboBoxPopulator(view.getCombo_SunHrClose(), restaurant.getCombo_SunHrClose());
		comboBoxPopulator(view.getCombo_SunMinClose(), restaurant.getCombo_SunMinClose());


		
	}
	
	private void comboBoxPopulator(JComboBox combo, int set) {
		
		int temp;
		
		
		for (int i = 0; i < combo.getItemCount(); i++) {
			
			temp = Integer.parseInt((String)combo.getItemAt(i));
			
			if (temp == set) {
				combo.setSelectedIndex(i);
				break;
			}
			
		}				
		
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
		
		//function to simplify validation of textfields in view
		public boolean validateJTextFieldsSave() {
			
			if ((model.validateRestoName(view.getTxt_restoName().getText()) && (model.validateRestoAddress(view.getTxt_restoAddress().getText()) && 
					(model.validateareaCode(view.getTxt_restaurantAreaCode().getText()) && (model.validatePhone1(view.getTxt_restaurantPhone1().getText()) &&
							(model.validatePhone2(view.getTxt_restaurantPhone2().getText()))))))) {
				return true;
			} else
				return false;
						
		}

	

}
