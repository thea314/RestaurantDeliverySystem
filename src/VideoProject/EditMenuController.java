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

public class EditMenuController implements ActionListener, ListSelectionListener {

	// properties
	EditMenuView view;
	EditMenuModel model;
	Restaurant restaurant;
	MenuItem menuItem;
	int restoId;
	JTable tempTable;
	JTable menuTable;
	DefaultTableModel menuTableModel;
	User user;
	ArrayList<MenuItem> menuId;

	// controller
	public EditMenuController(EditMenuView view, EditMenuModel model) {
		this.view = view;
		this.model = model;

		// actionlisteners
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_edit().addActionListener(this);
		view.getBtn_updateMenu().addActionListener(this);

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

			}

		}
	}

}
