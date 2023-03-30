package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
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
	
	
	//constructor
	public OrderHistoryController(OrderHistoryView view, Client client) {
		this.view = view;
		this.client = client;
		
		//actionlisteners
		view.getBtn_close().addActionListener(this);
		
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
				
				
				
			}
			
		}
		
		
	}

}
