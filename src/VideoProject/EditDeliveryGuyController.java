package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		}
		//deletes last item in delivery area
		if ((JButton)e.getSource() == view.getBtn_delete()) {

			if (deliveryAreas.length() >= 3) {
				String deliveryAreasDeleted = deliveryAreas.substring(deliveryAreas.lastIndexOf(" "), deliveryAreas.length() - 4);
				view.getTxtArea_deliveryArea().setText(deliveryAreasDeleted);	
			}

		}
		//save to db
		//validate fields before confirming




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
