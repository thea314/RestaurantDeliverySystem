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
	
	//properties
	EditMenuView view;
	EditMenuModel model;
	Restaurant restaurant;
	MenuItem menuItem;
	int restoId;
	JTable tempTable;
	JTable menuTable;
	DefaultTableModel menuTableModel;
	User user;
	
	//controller
	public EditMenuController(EditMenuView view, EditMenuModel model) {
		this.view = view;
		this.model = model;
		
		//actionlisteners
		view.getBtn_cancel().addActionListener(this);
		view.getBtn_edit().addActionListener(this);
		view.getBtn_updateMenu().addActionListener(this);
		
		//restaurant selection table populating
				DBManager populateTable = new DBManager();
				
				Object[] cols = {"Restaurant"};
				
				Object[] rows = populateTable.restaurantName().toArray(new Object[populateTable.restaurantName().size()]);
				
				tempTable = view.getTable_restaurant();
				DefaultTableModel tableModel = (DefaultTableModel) tempTable.getModel();
				tableModel.setColumnIdentifiers(cols);
				
				
				
				for (int i = 0; i < rows.length; i++) {
					
					String positionOfRestoId = ((String) rows[i]).substring(0, ((String) rows[i]).indexOf(" "));
					
					restoId = Integer.parseInt(positionOfRestoId);
					
					if (populateTable.hasMenu(restoId)) {
						
						
						tableModel.addRow(new Object[]{rows[i]});
					}
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
		if ((JButton)e.getSource() == view.getBtn_cancel()) {
			
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
