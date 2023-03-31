package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AcceptOrderController implements ActionListener, ListSelectionListener {

	//properties
	private AcceptOrderView view;
	private int restauranteurId;
	private Restaurant restaurant;
	private User user;
	private ArrayList<Order> orderTitle;
	private Order currentOrder;

	//constructor
	public AcceptOrderController(AcceptOrderView view, int restauranteurId, User user) {
		this.view = view;
		this.restauranteurId = restauranteurId;
		this.user = user;

		//actionlisteners
		view.getBtn_accept().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);

		//load jtables
		DBManager db = new DBManager();

		Object[] cols = {"Order"};

		int restoId = db.restoIdFromRestauranteur(restauranteurId);

		orderTitle = db.restoOrderListPending(restoId);

		DefaultTableModel tableModel = (DefaultTableModel) view.getTable_pending().getModel();
		tableModel.setColumnIdentifiers(cols);

		for (int i = 0; i < orderTitle.size(); i++) {

			tableModel.addRow(new Object[] { getStringTextFromOrder(orderTitle.get(i))});

		}

		view.getTable_pending().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = view.getTable_pending().getSelectionModel();

		selectionModel.addListSelectionListener(this);

		//meal table
		Object[] colsMeal = {"name", "quantity"};

		DefaultTableModel tableModel2 = (DefaultTableModel) view.getTable_meal().getModel();
		tableModel2.setColumnIdentifiers(colsMeal);



	}
	
	

	private String getStringTextFromOrder(Order order) {

		String displayLine = order.getYear() + "/" + order.getMonth() + "/" + order.getDay() + " - " + order.getHour() + "h " + order.getMinute();

		return displayLine;

	}



	@Override
	public void valueChanged(ListSelectionEvent event) {
		//order table onclick
				if (event.getSource() == view.getTable_pending().getSelectionModel()) {
					
					String tableCellContent = "";

					if (event.getValueIsAdjusting()) {
						
						int selectedIndex = view.getTable_pending().getSelectedRow();
						
						currentOrder = orderTitle.get(selectedIndex);
						
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
		
	



	@Override
	public void actionPerformed(ActionEvent e) {
		//accept order
		if ((JButton)e.getSource() == view.getBtn_accept()) {
			
			int confirmAddMenu = JOptionPane.showConfirmDialog(null, "Do you wish to accept this order?");

			if (confirmAddMenu == JOptionPane.YES_OPTION) {
				
				DBManager db = new DBManager();
				
				db.acceptOrder(currentOrder.getId());
				JOptionPane.showMessageDialog(null, "Order accepted, get cooking!!", "Complete", JOptionPane.INFORMATION_MESSAGE);
				
				view.setVisible(false);
				view.dispose();
				
				RestauranteurView restoView = new RestauranteurView();

				RestauranteurController restoController = new RestauranteurController(restoView, restauranteurId, user);
			}else if (confirmAddMenu == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Try again when you're ready", "Complete", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Come back soon!", "Complete", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		//leave screen
		if ((JButton)e.getSource() == view.getBtn_cancel()) {
			
			view.setVisible(false);
			
			
			RestauranteurView restoView = new RestauranteurView();

			RestauranteurController restoController = new RestauranteurController(restoView, restauranteurId, user);
			
			view.dispose();
						
		}
	}
}
