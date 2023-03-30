package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CreateOrderController implements ActionListener, ListSelectionListener {

	//properties
	CreateOrderView view;
	CreateOrderModel model;
	Restaurant restaurant;
	Client client;
	ArrayList<OrderItem> orderItem = new ArrayList<>();
	JTable tempTable;
	JTable menuTable;
	JTable orderTable;
	DefaultTableModel menuTableModel;
	DefaultTableModel orderTableModel;
	int restoId;
	int selectedMenuItem;
	ArrayList<MenuItem> menuId;
	double total = 0;
	int quantity;

	//constructor
	public CreateOrderController(CreateOrderView view, CreateOrderModel model, Client client) {
		this.view = view;
		this.model = model;
		this.client = client;

		//actionlisteners
		view.getBtn_add().addActionListener(this);
		view.getBtn_delete().addActionListener(this);
		view.getBtn_order().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);

		// restaurant selection table populating
		DBManager populateTable = new DBManager();

		Object[] cols = { "Restaurant" };

		Object[] rows = populateTable.restaurantName().toArray(new Object[populateTable.restaurantName().size()]);

		tempTable = view.getTable_resto();
		DefaultTableModel tableModel = (DefaultTableModel) tempTable.getModel();
		tableModel.setColumnIdentifiers(cols);

		for (int i = 0; i < rows.length; i++) {

			String positionOfRestoId = ((String) rows[i]).substring(0, ((String) rows[i]).indexOf(" "));

			restoId = Integer.parseInt(positionOfRestoId);

			if (populateTable.hasMenu(restoId)) {

				tableModel.addRow(new Object[] { rows[i] });
			}
		}

		tempTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = tempTable.getSelectionModel();

		selectionModel.addListSelectionListener(this);

		// menu display table
		menuTable = view.getTable_menu();
		menuTableModel = (DefaultTableModel) menuTable.getModel();
		menuTableModel.addColumn("Id");
		menuTableModel.addColumn("Item");
		menuTableModel.addColumn("Price");
		menuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuTable.setCellSelectionEnabled(false);
		menuTable.setColumnSelectionAllowed(false);
		menuTable.setRowSelectionAllowed(true);

		ListSelectionModel selectionModel2 = menuTable.getSelectionModel();
		selectionModel2.addListSelectionListener(this);

		//order table, read-only
		//menu display table, read-only
		orderTable = view.getTable_order();
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderTableModel = (DefaultTableModel) orderTable.getModel();
		orderTableModel.addColumn("Item");
		orderTableModel.addColumn("Price");
		orderTableModel.addColumn("Quantity");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//add an item to the order
		if((JButton)e.getSource() == view.getBtn_add()) {

			quantity = Integer.parseInt(view.getTxt_quantity().getText());
			String name = view.getTxt_meanName().getText();
			String price = view.getTxt_price().getText();
			String quantityInt = String.valueOf(quantity);
			double subtotal;

			if ((model.validateQuantity(quantity))) {

				orderTable = view.getTable_order();
				orderTableModel = (DefaultTableModel) orderTable.getModel();

				OrderItem currentOrderItem = new OrderItem();

				currentOrderItem.setQuantity(quantity);

				//find menuitem in arraylist

				for (int i = 0; i < menuId.size(); i++) {

					if (menuId.get(i).getMenuId() == selectedMenuItem) {
						name = menuId.get(i).getItemName();
						price = menuId.get(i).getItemPrice();
						currentOrderItem.setMenuItem(menuId.get(i));
						break;
					}

				}

				String item[] = {name, price, quantityInt};
				orderTableModel.addRow(item);

				orderItem.add(currentOrderItem);

				updateSubtotal();

			}


		}
		if ((JButton)e.getSource() == view.getBtn_delete()) {

			orderTable = view.getTable_order();
			orderTableModel = (DefaultTableModel) orderTable.getModel();

			int indexRow = orderTable.getSelectedRow();

			if (indexRow != -1) {
				int modelIndex = orderTable.convertRowIndexToModel(indexRow);


				String itemName = (String)orderTableModel.getValueAt(indexRow, 0);

				for (int i = 0; i < orderItem.size(); i++) {

					if (orderItem.get(i).getMenuItem().getItemName().equals(itemName)) {

						orderItem.remove(i);
						orderTableModel.removeRow(modelIndex);
						break;
					}

				}

				updateSubtotal();
			}


		}
		if ((JButton)e.getSource() == view.getBtn_cancel()) {

			view.setVisible(false);
			view.dispose();

			ClientMenuView clientMenu = new ClientMenuView();

			ClientController controlClientMenu = new ClientController(clientMenu, client);	


		}

		if ((JButton)e.getSource() == view.getBtn_order()) {

			if ((model.validateNumeric(view.getTxt_hour().getText()) && (model.validateNumeric(view.getTxt_min().getText()) &&
					(model.validateNumeric(view.getTxt_year().getText()) && (model.validateNumeric(view.getTxt_month().getText()) && 
							(model.validateNumeric(view.getTxt_day().getText()) && (model.validateAddress(view.getTxt_address().getText())) &&
									(model.validatePostalCode(view.getTxt_postalCode().getText())))))))) {

				DBManager db = new DBManager();

				int clientId = db.getClientId(client.getLastName(), client.getFirstName());

				Object[][] rows = {{"Date", view.getTxt_year().getText() + " - " + view.getTxt_month().getText() + " - " + view.getTxt_day().getText()},
						{"Time", view.getTxt_hour().getText() + "h " + view.getTxt_hour()},
						{"Address:", view.getTxt_address().getText()},
						{"Postal Code:", view.getTxt_postalCode().getText()},
						{"Total:", view.getTxt_total().getText()}
				};

				Object[] cols = {
						"Field", "Value"
				};


				JTable confirmTable = new JTable(rows, cols);

				int confirmOrder = JOptionPane.showConfirmDialog(null, new JScrollPane(confirmTable));

				if (confirmOrder == JOptionPane.YES_OPTION) {

					//create client order info in db
					db.createOrderInfo(clientId, Integer.parseInt(view.getTxt_year().getText()), Integer.parseInt(view.getTxt_month().getText()), 
							Integer.parseInt(view.getTxt_day().getText()), view.getTxt_postalCode().getText(), 
							Integer.parseInt(view.getTxt_hour().getText()), Integer.parseInt(view.getTxt_min().getText()),
							view.getTxt_address().getText(), restoId);

					int orderId = db.getOrderId(Integer.parseInt(view.getTxt_year().getText()), Integer.parseInt(view.getTxt_month().getText()),
							Integer.parseInt(view.getTxt_day().getText()), view.getTxt_address().getText(), clientId);

					//create order in db

					for (int i = 0; i < orderItem.size(); i++) {

						db.createOrderItems(orderItem.get(i).getMenuItem().getMenuId(), orderItem.get(i).getQuantity(), orderId);

					}

					JOptionPane.showMessageDialog(null, "Order Complete! Coming soon!", "Success", JOptionPane.INFORMATION_MESSAGE);

					view.setVisible(false);
					view.dispose();

					ClientMenuView clientMenu = new ClientMenuView();

					ClientController controlClientMenu = new ClientController(clientMenu, client);	

				}else if (confirmOrder == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Please make your updates and try again.", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please fill out form.", "Error", JOptionPane.INFORMATION_MESSAGE);

					view.setVisible(false);
					view.dispose();

					ClientMenuView clientMenu = new ClientMenuView();

					ClientController controlClientMenu = new ClientController(clientMenu, client);	

				}


			}


		}

	}

	@Override
	public void valueChanged(ListSelectionEvent event) {

		if (event.getSource() == view.getTable_resto().getSelectionModel()) {
			// takes selection from restaurant JTable
			String tableCellContent = "";

			if (event.getValueIsAdjusting()) {

				tableCellContent = tempTable.getValueAt(tempTable.getSelectedRow(), 0).toString();

				String positionOfRestoId = tableCellContent.substring(0, tableCellContent.indexOf(" "));

				restoId = Integer.parseInt(positionOfRestoId);

				DBManager menuList = new DBManager();

				menuId = menuList.menuList(restoId);

				DefaultTableModel tableModel = (DefaultTableModel) view.getTable_menu().getModel();

				for (int i = 0; i < menuId.size(); i++) {

					tableModel.addRow(new Object[] { menuId.get(i).getMenuId(), menuId.get(i).getItemName(),
							menuId.get(i).getItemPrice() });

				}

			}

		}
		// for menu jtable
		if (event.getSource() == view.getTable_menu().getSelectionModel()) {

			// populate jtextfields from menu jtable
			if (event.getValueIsAdjusting()) {

				DefaultTableModel tableModel = (DefaultTableModel) view.getTable_menu().getModel();

				selectedMenuItem = (int)tableModel.getValueAt(view.getTable_menu().getSelectedRow(), 0);
				String name = (String) tableModel.getValueAt(view.getTable_menu().getSelectedRow(), 1);
				String price = (String) tableModel.getValueAt(view.getTable_menu().getSelectedRow(), 2);

				view.getTxt_meanName().setText(name);
				view.getTxt_price().setText(price);



			}

		}
	}

	private void updateSubtotal() {

		//loop through OrderItems to get total
		double subtotal = 0;

		for (int i = 0; i < orderItem.size(); i++) {

			subtotal += orderItem.get(i).getTotal();

		}

		String stringSubtotal = String.valueOf(subtotal);

		view.getTxt_total().setText(stringSubtotal);

	}


}
