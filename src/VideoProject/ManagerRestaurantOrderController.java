package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ManagerRestaurantOrderController implements ActionListener, ListSelectionListener{

	//properties
	private ManagerRestaurantOrderView view;
	private int managerId;
	private Restaurant restaurant;
	private ArrayList<Order> orderTitle;
	private User user;

	//constructor
	public ManagerRestaurantOrderController(ManagerRestaurantOrderView view, int managerId) {
		this.view = view;
		this.managerId = managerId;

		//actionlisteners
		view.getBtn_close().addActionListener(this);

		DBManager db = new DBManager();

		Object[] cols = {"Order"};

		int restoId = db.RestoIdFromManager(managerId);

		orderTitle = db.restoOrderList(restoId);

		DefaultTableModel tableModel = (DefaultTableModel) view.getTable_order().getModel();
		tableModel.setColumnIdentifiers(cols);

		for (int i = 0; i < orderTitle.size(); i++) {

			tableModel.addRow(new Object[] { getStringTextFromOrder(orderTitle.get(i))});

		}

		view.getTable_order().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = view.getTable_order().getSelectionModel();

		selectionModel.addListSelectionListener(this);
		
		//meal table
				Object[] colsMeal = {"name", "quantity"};
				
				DefaultTableModel tableModel2 = (DefaultTableModel) view.getTable_meal().getModel();
				tableModel2.setColumnIdentifiers(colsMeal);
	}

	public void actionPerformed(ActionEvent e) {
		//close button
		if ((JButton)e.getSource() == view.getBtn_close()) {

			view.setVisible(false);
			view.dispose();
			
			ManagerView managerView = new ManagerView();
			ManagerController managerController = new ManagerController(managerView, managerId, user);


		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		//order table onclick
		if (event.getSource() == view.getTable_order().getSelectionModel()) {
			
			String tableCellContent = "";

			if (event.getValueIsAdjusting()) {
				
				int selectedIndex = view.getTable_order().getSelectedRow();
				
				Order currentOrder = orderTitle.get(selectedIndex);
				
				DefaultTableModel populateMeal = (DefaultTableModel) view.getTable_meal().getModel();
				
				populateMeal.setRowCount(0);
				
				for (int i = 0; i < currentOrder.getItems().size(); i++) {

					OrderItem orderItem = currentOrder.getItems().get(i);
					MenuItem menuItem = (currentOrder.getItems().get(i).getMenuItem());
					populateMeal.addRow(new Object[] {menuItem.getItemName(), String.valueOf(orderItem.getQuantity())});
					
					
				}
				view.getTxt_date().setText(currentOrder.getYear() + "/" + currentOrder.getMonth() + "/" + currentOrder.getDay());
				view.getTxt_time().setText(currentOrder.getHour() + "h " + currentOrder.getMinute());
				view.getTxt_postal().setText(currentOrder.getPostalCode());
				
			}
		}
				
			}
	
	
	private String getStringTextFromOrder(Order order) {

		String displayLine = order.getYear() + "/" + order.getMonth() + "/" + order.getDay() + " - " + order.getHour() + "h " + order.getMinute();

		return displayLine;

	}

}
