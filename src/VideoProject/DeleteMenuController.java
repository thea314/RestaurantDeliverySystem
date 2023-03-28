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

public class DeleteMenuController implements ActionListener, ListSelectionListener {

	// properties
	DeleteMenuView view;
	DeleteMenuModel model;
	Restaurant restaurant;
	MenuItem menuItem;
	int restoId;
	JTable tempTable;
	JTable menuTable;
	DefaultTableModel menuTableModel;
	User user;
	ArrayList<MenuItem> menuId;

	// controller
	public DeleteMenuController(DeleteMenuView view, DeleteMenuModel model) {
		this.view = view;
		this.model = model;

		// actionlisteners
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_edit().addActionListener(this);

		// restaurant selection table populating
		DBManager populateTable = new DBManager();

		Object[] cols = { "Restaurant" };

		Object[] rows = populateTable.restaurantName().toArray(new Object[populateTable.restaurantName().size()]);

		tempTable = view.getTable_restaurant();
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

		// menu display table, read-only
		menuTable = view.getTable_menuList();
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == view.getBtn_cancel()) {

			view.setVisible(false);
			view.dispose();

			AdminView adminView = new AdminView();

			AdminController adminController = new AdminController(adminView, user);
		}
		
		if ((JButton)e.getSource() == view.getBtn_edit()) {
			
			//validate name and price before updating to db
			
				int menuRows = menuTable.getRowCount();

				//confirm changes
				//verify item info correct before saving
				Object[][] rows = {{}};

				Object[] cols = {
						"Item", "Price"
				};

				JTable confirmTable = new JTable(rows, cols);

				int confirmAddMenu = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

				if (confirmAddMenu == JOptionPane.YES_OPTION) {

					DBManager deleteMenu = new DBManager();
					
					int row = view.getTable_menuList().getSelectedRow();
					
					int menuIdOfSelection = (int) view.getTable_menuList().getValueAt(row, 0);

					deleteMenu.deleteMenuItem(menuIdOfSelection);

						JOptionPane.showMessageDialog(null, "Menu item deleted, have a nice day!", "Sucsess", JOptionPane.INFORMATION_MESSAGE);

						view.setVisible(false);
						view.dispose();

						AdminView adminView = new AdminView();

						AdminController adminController = new AdminController(adminView, user);

					 
				}else if (confirmAddMenu == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Please update and try again", "Canceled", JOptionPane.INFORMATION_MESSAGE);

					

				} else {
					JOptionPane.showMessageDialog(null, "Come back soon!", "Canceled", JOptionPane.INFORMATION_MESSAGE);

					view.setVisible(false);
					view.dispose();

					AdminView adminView = new AdminView();

					AdminController adminController = new AdminController(adminView, user);
				}

			}
		}
			
		

	

	@Override
	public void valueChanged(ListSelectionEvent event) {

		if (event.getSource() == view.getTable_restaurant().getSelectionModel()) {
			// takes selection from restaurant JTable
			String tableCellContent = "";

			if (event.getValueIsAdjusting()) {

				tableCellContent = tempTable.getValueAt(tempTable.getSelectedRow(), 0).toString();

				String positionOfRestoId = tableCellContent.substring(0, tableCellContent.indexOf(" "));

				restoId = Integer.parseInt(positionOfRestoId);

				DBManager menuList = new DBManager();

				menuId = menuList.menuList(restoId);

				DefaultTableModel tableModel = (DefaultTableModel) view.getTable_menuList().getModel();

				for (int i = 0; i < menuId.size(); i++) {

					tableModel.addRow(new Object[] { menuId.get(i).getMenuId(), menuId.get(i).getItemName(),
							menuId.get(i).getItemPrice() });

				}

			}

		}
		// for menu jtable
		if (event.getSource() == view.getTable_menuList().getSelectionModel()) {

			// populate jtextfields from menu jtable
			if (event.getValueIsAdjusting()) {

				DefaultTableModel tableModel = (DefaultTableModel) view.getTable_menuList().getModel();

				String name = (String) tableModel.getValueAt(event.getFirstIndex(), 1);
				String price = (String) tableModel.getValueAt(event.getFirstIndex(), 2);
				
				view.getTxt_itemName().setText(name);
				view.getTxt_price().setText(price);
				
				view.getBtn_edit().setEnabled(true);

			}

		}
	}

}
