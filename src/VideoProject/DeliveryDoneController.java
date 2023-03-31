package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DeliveryDoneController implements ActionListener, ListSelectionListener {

	//properties
	private DeliveryDoneView view;
	private int deliveryGuyId;
	private ArrayList<Order> orderTitle;
	private Order order;
	private User user;
	private Order currentOrder;


	//constructor
	public DeliveryDoneController(DeliveryDoneView view, int deliveryGuyId, User user) {
		this.view = view;
		this.deliveryGuyId = deliveryGuyId;
		this.user = user;

		//actionListeners
		view.getBtn_close().addActionListener(this);
		view.getBtn_complete().addActionListener(this);

		String tableCellContent = "";

		DBManager db = new DBManager();

		orderTitle = db.assignedOrders(deliveryGuyId);

		DefaultTableModel tableModel = (DefaultTableModel) view.getTable_order().getModel();
		
		Object[] cols = {"Order"};
		tableModel.setColumnIdentifiers(cols);

		for (int i = 0; i < orderTitle.size(); i++) {
			
			String title = orderTitle.get(i).getYear() + "/" + orderTitle.get(i).getMonth() + "/" + orderTitle.get(i).getDay() + " - " + orderTitle.get(i).getHour() + "h " + orderTitle.get(i).getMinute();

			tableModel.addRow(new Object[] {title});


		}
		
		view.getTable_order().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = view.getTable_order().getSelectionModel();

		selectionModel.addListSelectionListener(this);
	}


	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getSource() == view.getTable_order().getSelectionModel()) {
			
			String tableCellContent = "";

			if (event.getValueIsAdjusting()) {
				
				int selectedIndex = view.getTable_order().getSelectedRow();
				
				currentOrder = orderTitle.get(selectedIndex);
				
				view.getTxt_address().setText(String.valueOf(currentOrder.getAddress()));
				view.getTxt_restoNo().setText(String.valueOf(currentOrder.getRestoId()));
				view.getTxt_postal().setText(currentOrder.getPostalCode());
				view.getTxt_orderNo().setText(String.valueOf(currentOrder.getId()));
				
			}
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == view.getBtn_close()) {

			view.setVisible(false);
			view.dispose();

			DeliveryGuyView viewDelivery = new DeliveryGuyView();

			DeliveryGuyController viewController = new DeliveryGuyController(viewDelivery, deliveryGuyId, user);

		}
		if((JButton)e.getSource() == view.getBtn_complete()) {
			
			int confirmAddMenu = JOptionPane.showConfirmDialog(null, "Do you wish to complete this order?");

			if (confirmAddMenu == JOptionPane.YES_OPTION) {
				
				DBManager db = new DBManager();
				
				db.completeDelivery(currentOrder.getId(), deliveryGuyId);
				JOptionPane.showMessageDialog(null, "Get back to work!", "Complete", JOptionPane.INFORMATION_MESSAGE);
				
				view.setVisible(false);
				view.dispose();
				
				DeliveryGuyView dGView = new DeliveryGuyView();
				
				DeliveryGuyController dGController = new DeliveryGuyController(dGView, deliveryGuyId, user);
			}else if (confirmAddMenu == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Try again when you're ready", "Complete", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Come back soon!", "Complete", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
