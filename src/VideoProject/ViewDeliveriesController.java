package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewDeliveriesController implements ActionListener, ListSelectionListener {
	
	//properties
	private ViewDeliveriesView view;
	private int deliveryGuyId;
	private ArrayList<Order> orderTitle;
	private Order order;
	
	
	//constructor
	public ViewDeliveriesController(ViewDeliveriesView view, int deliveryGuyId) {
		this.view = view;
		this.deliveryGuyId = deliveryGuyId;
		
		//actionListeners
		view.getBtn_close().addActionListener(this);
	}


	@Override
	public void valueChanged(ListSelectionEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource() == view.getBtn_close()) {
			
			view.setVisible(false);
			view.dispose();
			
			ViewDeliveriesView viewDelivery = new ViewDeliveriesView();
			
			ViewDeliveriesController viewController = new ViewDeliveriesController(viewDelivery, deliveryGuyId);
			
		}
		
	}

}
