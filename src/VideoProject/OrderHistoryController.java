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

public class OrderHistoryController implements ActionListener, ListSelectionListener {
	
	//properties
	private OrderHistoryView view;
	private Client client;
	private JTable orderTable;
	private JTable mealTable;
	private DefaultTableModel orderTableModel;
	private DefaultTableModel mealTableModel;
	private ArrayList<Order> orderTitle;
	private JTable tempTable;
	
	
	//constructor
	public OrderHistoryController(OrderHistoryView view, Client client) {
		this.view = view;
		this.client = client;
		
		//actionlisteners
		view.getBtn_close().addActionListener(this);
		
		DBManager db = new DBManager();
		
		Object[] cols = {"Order"};
		
		int clientId = db.getClientId(client.getLastName(), client.getFirstName());
		
		orderTitle = db.orderList(clientId);
		
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

			ClientMenuView clientMenu = new ClientMenuView();

			ClientController controlClientMenu = new ClientController(clientMenu, client);	

			
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
