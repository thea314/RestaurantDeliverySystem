package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRestaurantController implements ActionListener {
	
	//properties
	CreateRestaurantView view = new CreateRestaurantView();
	CreateRestaurantModel model = new CreateRestaurantModel();
	
	//constructor
	public CreateRestaurantController(CreateRestaurantView view, CreateRestaurantModel model) {
		this.view = view;
		this.model = model;
		
		//add actionlisteners for buttons
		view.getBtn_addDeliveryArea().addActionListener(this);
		view.getBtn_deleteDeliveryArea().addActionListener(this);
		view.getBtn_modifyAll().addActionListener(this);
		view.getBtn_saveButton().addActionListener(this);
		view.getBtn_validateManagerUsesname().addActionListener(this);;
		view.getBtn_validateRestauranteurUsername().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
