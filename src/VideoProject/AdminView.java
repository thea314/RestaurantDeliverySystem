package VideoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class AdminView extends JFrame {


	private JMenuItem item_Disconnect;
	private JMenuItem item_quit;
	private JMenuItem item_addResto;
	private JMenuItem item_editResto;
	private JMenuItem item_deleteResto;
	private JMenuItem item_menuCreate;
	private JMenuItem item_menuEdit;
	private JMenuItem item_menuDelete;
	private JMenuItem item_createDeliveryGuy;
	private JMenuItem item_editDeliveryGuy;
	private JMenuItem item_deleteDeliveryGuy;

	
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
		
		item_Disconnect = new JMenuItem("Disconnect");
		menu_file.add(item_Disconnect);
		
		item_quit = new JMenuItem("Quit");
		menu_file.add(item_quit);
		
		JMenu mnRestaurant = new JMenu("Restaurant");
		menuBar.add(mnRestaurant);
		
		item_addResto = new JMenuItem("Create");
		mnRestaurant.add(item_addResto);
		
		item_editResto = new JMenuItem("Edit");
		mnRestaurant.add(item_editResto);
		
		item_deleteResto = new JMenuItem("Delete");
		mnRestaurant.add(item_deleteResto);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		item_menuCreate = new JMenuItem("Create");
		mnMenu.add(item_menuCreate);
		
		item_menuEdit = new JMenuItem("Edit");
		mnMenu.add(item_menuEdit);
		
		item_menuDelete = new JMenuItem("Delete");
		mnMenu.add(item_menuDelete);
		
		JMenu mnDeliveryGuy = new JMenu("Delivery Guy");
		menuBar.add(mnDeliveryGuy);
		
		item_createDeliveryGuy = new JMenuItem("Create");
		mnDeliveryGuy.add(item_createDeliveryGuy);
		
		item_editDeliveryGuy = new JMenuItem("Edit");
		mnDeliveryGuy.add(item_editDeliveryGuy);
		
		item_deleteDeliveryGuy = new JMenuItem("Delete");
		mnDeliveryGuy.add(item_deleteDeliveryGuy);
		
		this.setVisible(true);
	}
	public JMenuItem getItem_Disconnect() {
		return item_Disconnect;
	}

	public void setItem_Disconnect(JMenuItem item_Disconnect) {
		this.item_Disconnect = item_Disconnect;
	}

	public JMenuItem getItem_quit() {
		return item_quit;
	}

	public void setItem_quit(JMenuItem item_quit) {
		this.item_quit = item_quit;
	}

	public JMenuItem getItem_addResto() {
		return item_addResto;
	}

	public void setItem_addResto(JMenuItem item_addResto) {
		this.item_addResto = item_addResto;
	}

	public JMenuItem getItem_editResto() {
		return item_editResto;
	}

	public void setItem_editResto(JMenuItem item_editResto) {
		this.item_editResto = item_editResto;
	}

	public JMenuItem getItem_deleteResto() {
		return item_deleteResto;
	}

	public void setItem_deleteResto(JMenuItem item_deleteResto) {
		this.item_deleteResto = item_deleteResto;
	}

	public JMenuItem getItem_menuCreate() {
		return item_menuCreate;
	}

	public void setItem_menuCreate(JMenuItem item_menuCreate) {
		this.item_menuCreate = item_menuCreate;
	}

	public JMenuItem getItem_menuEdit() {
		return item_menuEdit;
	}

	public void setItem_menuEdit(JMenuItem item_menuEdit) {
		this.item_menuEdit = item_menuEdit;
	}

	public JMenuItem getItem_menuDelete() {
		return item_menuDelete;
	}

	public void setItem_menuDelete(JMenuItem item_menuDelete) {
		this.item_menuDelete = item_menuDelete;
	}

	public JMenuItem getItem_createDeliveryGuy() {
		return item_createDeliveryGuy;
	}

	public void setItem_createDeliveryGuy(JMenuItem item_createDeliveryGuy) {
		this.item_createDeliveryGuy = item_createDeliveryGuy;
	}

	public JMenuItem getItem_editDeliveryGuy() {
		return item_editDeliveryGuy;
	}

	public void setItem_editDeliveryGuy(JMenuItem item_editDeliveryGuy) {
		this.item_editDeliveryGuy = item_editDeliveryGuy;
	}

	public JMenuItem getItem_deleteDeliveryGuy() {
		return item_deleteDeliveryGuy;
	}

	public void setItem_deleteDeliveryGuy(JMenuItem item_deleteDeliveryGuy) {
		this.item_deleteDeliveryGuy = item_deleteDeliveryGuy;
	}

}
