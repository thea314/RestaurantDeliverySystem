package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EditDeliveryGuyController implements ActionListener, ListSelectionListener {

	//properties
	private EditDeliveryGuyView view;
	private EditDeliveryGuyModel model;
	private DeliveryGuy deliveryGuy;
	private String deliveryAreas = "";
	JTable tempTable;
	private int guyId;
	User user;

	//constructor
	public EditDeliveryGuyController(EditDeliveryGuyView view, EditDeliveryGuyModel model, DeliveryGuy deliveryGuy) {
		this.view = view;
		this.model = model;

		//actionlisteners
		view.getBtn_addArea().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_delete().addActionListener(this);
		view.getBtn_save().addActionListener(this);

		DBManager populateTable = new DBManager();

		Object[] cols = {"Delivery Guy"};

		Object[] rows = populateTable.deliveryGuyName().toArray(new Object[populateTable.deliveryGuyName().size()]);

		tempTable = view.getTable_deliveryGuy();
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
		//cancel button
		if ((JButton)e.getSource() == view.getBtn_cancel()) {

			view.setVisible(false);
			view.dispose();

			AdminView adminView = new AdminView();

			AdminController adminController = new AdminController(adminView, user);

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
		//save to db
		if ((JButton)e.getSource() == view.getBtn_save()) {
			
			//validate fields before confirming
			if ((model.validateareaCode(view.getTxt_areaCode().getText()) && (model.validateDeliveryArea(view.getTxtArea_deliveryArea().getText()) &&
					(model.validateName(view.getTxt_driverName().getText()) && (model.validateNumeric(view.getTxt_areaCode().getText()) &&
					(model.validateNumeric(view.getTxt_phone1().getText()) && (model.validateNumeric(view.getTxt_phone2().getText()) &&
							(model.validatePhone1(view.getTxt_phone1().getText()) && (model.validatePhone2(view.getTxt_phone2().getText())))))))))) {
				
				//is password blank (being kept)
				if (view.getTxt_password().getText().equals("")) {
					//confirm changes
					//verify item info correct before saving
					
					 Object[][] rows = {{"Name", view.getTxt_driverName().getText()}, {"Delivery Area", view.getTxtArea_deliveryArea().getText()},
							 {"Phone:", view.getTxt_areaCode().getText() + " - " + view.getTxt_phone1().getText() + " - " + view.getTxt_phone2().getText()},
							 };
					 
					 Object[] cols = {
							 "Field", "Value"
					 };
					 

					JTable confirmTable = new JTable(rows, cols);

					int confirmEditDeliveryGuy = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));

					if (confirmEditDeliveryGuy == JOptionPane.YES_OPTION) {
						
						DBManager db = new DBManager();
						
						db.updateDeliveryGuyNoPasswordChange(deliveryGuy.getUsername(), view.getTxt_driverName().getText(), view.getTxt_areaCode().getText(),
								view.getTxt_phone1().getText(), view.getTxt_phone2().getText(), view.getTxtArea_deliveryArea().getText());
						
						JOptionPane.showMessageDialog(null, "Update Complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						view.setVisible(false);
						view.dispose();
						
						AdminView adminView = new AdminView();
						
						AdminController adminController = new AdminController(adminView, user);
						
					 }else if (confirmEditDeliveryGuy == JOptionPane.NO_OPTION) {
						 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
					 } else {
						 JOptionPane.showMessageDialog(null, "Please fill out form.", "Error", JOptionPane.INFORMATION_MESSAGE);
					 }
					
				} else {
					//confirm changes
					//verify item info correct before saving
					
					 Object[][] rows = {{"Name", view.getTxt_driverName().getText()}, {"Delivery Area", view.getTxtArea_deliveryArea().getText()},
							 {"Phone:", view.getTxt_areaCode().getText() + " - " + view.getTxt_phone1().getText() + " - " + view.getTxt_phone2().getText()},
							 };
					 
					 Object[] cols = {
							 "Field", "Value"
					 };
					 

					JTable confirmTable = new JTable(rows, cols);

					int confirmEditDeliveryGuy = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));

					if (confirmEditDeliveryGuy == JOptionPane.YES_OPTION) {
						
						DBManager db = new DBManager();
						
						db.updateDeliveryGuyWithPasswordChange(deliveryGuy.getUsername(), view.getTxt_driverName().getText(), view.getTxt_areaCode().getText(),
								view.getTxt_phone1().getText(), view.getTxt_phone2().getText(), view.getTxtArea_deliveryArea().getText(), view.getTxt_password().getText());
						
						db.updateUserPasswordTable(deliveryGuy.getUsername(), view.getTxt_password().getText());
						
						JOptionPane.showMessageDialog(null, "Update Complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						view.setVisible(false);
						view.dispose();
						
						AdminView adminView = new AdminView();
						
						AdminController adminController = new AdminController(adminView, user);
						
						
				} else if (confirmEditDeliveryGuy == JOptionPane.NO_OPTION) {
					 JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
				 } else {
					 JOptionPane.showMessageDialog(null, "Please fill out form.", "Error", JOptionPane.INFORMATION_MESSAGE);
				 }
				
			}
			
			
		}
		
		}




	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		
		//takes selection from JTable
				String tableCellContent = "";
				
				if (event.getValueIsAdjusting()) {
											
					tableCellContent = tempTable.getValueAt(tempTable.getSelectedRow(), 0).toString();
					
					String positionOfGuyId = tableCellContent.substring(0, tableCellContent.indexOf(" "));
					
					guyId = Integer.parseInt(positionOfGuyId);
					
					DBManager callDB = new DBManager();
					
					deliveryGuy = callDB.getDeliveryGuyById(guyId);
					
					loadData(deliveryGuy);
				}
		
	}

	private void loadData(DeliveryGuy deliveryGuy) {
		
		view.getTxtArea_deliveryArea().setText(deliveryGuy.getDeliveryArea());
		view.getTxt_areaCode().setText(deliveryGuy.getAreaCode());
		view.getTxt_driverName().setText(deliveryGuy.getName());
		view.getTxt_phone1().setText(deliveryGuy.getPhone1());
		view.getTxt_phone2().setText(deliveryGuy.getPhone2());
		view.getTxt_username().setText(deliveryGuy.getUsername());
		
	}

}
