package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CreateMenuController implements ActionListener, ListSelectionListener {

	private CreateMenuView view;
	private CreateMenuModel model;
	User user;
	Restaurant restaurant;
	JTable tempTable;
	JTable menuTable;
	private int restoId;
	DefaultTableModel menuTableModel;
	MenuItem menuItem;

	public CreateMenuController(CreateMenuView view, CreateMenuModel model) {
		this.view = view;
		this.model = model;

		//actionlisteners
		view.getBtn_add().addActionListener(this);
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_createMenu().addActionListener(this);

		//restaurant selection table populating
		DBManager populateTable = new DBManager();

		Object[] cols = {"Restaurant"};

		Object[] rows = populateTable.restaurantName().toArray(new Object[populateTable.restaurantName().size()]);

		tempTable = view.getTable_restaurant();
		DefaultTableModel tableModel = (DefaultTableModel) tempTable.getModel();
		tableModel.setColumnIdentifiers(cols);

		for (int i = 0; i < rows.length; i++) {
			tableModel.addRow(new Object[]{rows[i]});
		}

		tempTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = tempTable.getSelectionModel();

		selectionModel.addListSelectionListener(this);

		//menu display table, read-only
		menuTable = view.getTable_menuList();
		menuTableModel = (DefaultTableModel) menuTable.getModel();
		menuTableModel.addColumn("Item");
		menuTableModel.addColumn("Price");


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ((JButton)e.getSource() == view.getBtn_add()) {


			String name = view.getTxt_itemName().getText();
			String price = view.getTxt_price().getText();

			if ((model.validateName(name)) && model.validatePrice(price)) {

				menuTable = view.getTable_menuList();
				menuTableModel = (DefaultTableModel) menuTable.getModel();


				String item[] = {name, price};
				menuTableModel.addRow(item);
			}
		}
		//save menu to db
		if ((JButton)e.getSource() == view.getBtn_createMenu()) {

			if ((model.validatePrice(view.getTxt_price().getText()) && (model.validateName(view.getTxt_itemName().getText())))) {
				int menuRows = menuTable.getRowCount();

				//confirm changes
				//verify client info correct before saving
				Object[][] rows = {{}};

				Object[] cols = {
						"Item", "Price"
				};

				JTable confirmTable = new JTable(rows, cols);

				int confirmAddMenu = JOptionPane.showConfirmDialog(null, new JScrollPane(menuTable));

				if (confirmAddMenu == JOptionPane.YES_OPTION) {

					DBManager addMenu = new DBManager();

					for (int i = 0; i < menuRows; i++) {

						menuItem = new MenuItem();

						menuItem.setItemName((String)view.getTable_menuList().getValueAt(i, 0)); 
						menuItem.setItemPrice((String)view.getTable_menuList().getValueAt(i, 1));
						menuItem.setRestoId(restoId);

						addMenu.addMenu(menuItem);

						JOptionPane.showMessageDialog(null, "Menu added, have a nice day!", "Complete", JOptionPane.INFORMATION_MESSAGE);

						view.setVisible(false);
						view.dispose();

						AdminView adminView = new AdminView();

						AdminController adminController = new AdminController(adminView, user);

					} 
				}else if (confirmAddMenu == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Please update and try again", "Canceled", JOptionPane.INFORMATION_MESSAGE);

					view.setVisible(false);
					view.dispose();

					AdminView adminView = new AdminView();

					AdminController adminController = new AdminController(adminView, user);

				} else {
					JOptionPane.showMessageDialog(null, "Come back soon!", "Canceled", JOptionPane.INFORMATION_MESSAGE);

					view.setVisible(false);
					view.dispose();

					AdminView adminView = new AdminView();

					AdminController adminController = new AdminController(adminView, user);
				}

			}
		}
		if((JButton)e.getSource() == view.getBtn_cancel()) {

			view.setVisible(false);
			view.dispose();

			AdminView adminView = new AdminView();

			AdminController adminController = new AdminController(adminView, user);

		}
	}


	@Override
	public void valueChanged(ListSelectionEvent event) {
		//takes selection from JTable
		String tableCellContent = "";

		if (event.getValueIsAdjusting()) {

			tableCellContent = tempTable.getValueAt(tempTable.getSelectedRow(), 0).toString();

			String positionOfRestoId = tableCellContent.substring(0, tableCellContent.indexOf(" "));

			restoId = Integer.parseInt(positionOfRestoId);

		}
	}
}
