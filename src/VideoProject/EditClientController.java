package VideoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditClientController implements ActionListener {
	
	//properties
	private EditClientView view;
	private EditClientModel model;
	
	//contructor
	public EditClientController(EditClientView view, EditClientModel model) {
		this.view = view;
		this.model = model;
		
		//add actionlisteners
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton)e.getSource() == view.getBtn_save()) {
			
		}
		
		
	}
	
	

}
