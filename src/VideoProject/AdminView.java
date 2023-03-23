package VideoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class AdminView extends JFrame {



	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {

		this.setBounds(100, 100, 450, 393);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_file = new JMenu("File");
		menuBar.add(menu_file);
		
		JMenuItem item_Disconnect = new JMenuItem("Disconnect");
		menu_file.add(item_Disconnect);
		
		JMenuItem item_quit = new JMenuItem("Quit");
		menu_file.add(item_quit);
		
		JMenu mnRestaurant = new JMenu("Restaurant");
		menuBar.add(mnRestaurant);
		
		JMenuItem item_addResto = new JMenuItem("Create");
		mnRestaurant.add(item_addResto);
		
		JMenuItem item_editResto = new JMenuItem("Edit");
		mnRestaurant.add(item_editResto);
		
		JMenuItem item_deleteResto = new JMenuItem("Delete");
		mnRestaurant.add(item_deleteResto);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem item_menuCreate = new JMenuItem("Create");
		mnMenu.add(item_menuCreate);
		
		JMenuItem item_menuEdit = new JMenuItem("Edit");
		mnMenu.add(item_menuEdit);
		
		JMenuItem item_menuDelete = new JMenuItem("Delete");
		mnMenu.add(item_menuDelete);
		
		JMenu mnDeliveryGuy = new JMenu("Delivery Guy");
		menuBar.add(mnDeliveryGuy);
		
		JMenuItem item_createDeliveryGuy = new JMenuItem("Create");
		mnDeliveryGuy.add(item_createDeliveryGuy);
		
		JMenuItem item_editDeliveryGuy = new JMenuItem("Edit");
		mnDeliveryGuy.add(item_editDeliveryGuy);
		
		JMenuItem item_deleteDeliveryGuy = new JMenuItem("Delete");
		mnDeliveryGuy.add(item_deleteDeliveryGuy);
		
		this.setVisible(true);
	}

}
