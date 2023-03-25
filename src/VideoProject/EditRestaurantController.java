package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditRestaurantController implements ActionListener {
	
	private EditRestaurantView view;
	private EditRestaurantModel model;
	private String deliveryAreas = "";
	
	public EditRestaurantController(EditRestaurantView view, EditRestaurantModel model) {
		this.view = view;
		this.model = model;
		Restaurant restaurant;

		
		//actionlisteners
		view.getBtn_addDeliveryArea().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_deleteDeliveryArea().addActionListener(this);
		view.getBtn_modifyAll().addActionListener(this);
		view.getBtn_saveButton().addActionListener(this);
		
		DBManager populateTable = new DBManager();
		
		Object[] cols = {"Restaurant"};
		
		Object[] rows = populateTable.restaurantName().toArray(new Object[populateTable.restaurantName().size()]);
		
		JTable tempTable = view.getRestoList();
		DefaultTableModel tableModel = (DefaultTableModel) tempTable.getModel();
		tableModel.setColumnIdentifiers(cols);
		
		for (int i = 0; i < rows.length; i++) {
		tableModel.addRow(new Object[]{rows[i]});
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//add delivery area to the delivery area string
				if ((JButton)e.getSource() == view.getBtn_addDeliveryArea()) {
					
					deliveryAreas = deliveryAreas + " " + view.getTxt_deliveryArea().getText();
					view.getTxtA_deliveryArea().setText(deliveryAreas);			
				}
				//deletes last item in delivery area
				if ((JButton)e.getSource() == view.getBtn_deleteDeliveryArea()) {
					
					if (deliveryAreas.length() >= 3) {
					String deliveryAreasDeleted = deliveryAreas.substring(deliveryAreas.lastIndexOf(" "), deliveryAreas.length() - 4);
					view.getTxtA_deliveryArea().setText(deliveryAreasDeleted);	
					}
					
				}
		
	}
	
	private void loadData(Restaurant restaurant) {
		
		
		
	}

}
