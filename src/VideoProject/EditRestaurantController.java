package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
				}
				//deletes last item in delivery area
				if ((JButton)e.getSource() == view.getBtn_deleteDeliveryArea()) {
					
					if (deliveryAreas.length() >= 3) {
					String deliveryAreasDeleted = deliveryAreas.substring(deliveryAreas.lastIndexOf(" "), deliveryAreas.length() - 4);
					view.getTxtA_deliveryArea().setText(deliveryAreasDeleted);	
					}
					
				}
				//takes selection from JTable
				
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		
		String tableCellContent = "";
		
		if (event.getValueIsAdjusting()) {
									
			tableCellContent = tempTable.getValueAt(tempTable.getSelectedRow(), 0).toString();
			
			String positionOfRestoId = tableCellContent.substring(0, tableCellContent.indexOf(" "));
			
			int restoId = Integer.parseInt(positionOfRestoId);
			
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
	

}
