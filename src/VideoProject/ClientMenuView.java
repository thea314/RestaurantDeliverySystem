package VideoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class ClientMenuView extends JFrame {
	
	private JMenuItem item_Disconnect;
	private JMenuItem item_quit;
	private JMenuItem item_edit;
	private JMenuItem item_delete;
	private JMenuItem item_orderFood;
	private JMenuItem item_orderHistory;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientMenuView window = new ClientMenuView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ClientMenuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu_client = new JMenuBar();
		this.setJMenuBar(menu_client);
		
		JMenu mnFile = new JMenu("File");
		menu_client.add(mnFile);
		
		item_Disconnect = new JMenuItem("Disconnect");
		mnFile.add(item_Disconnect);
		
		item_quit = new JMenuItem("Quit");
		mnFile.add(item_quit);
		
		JMenu mnAccount = new JMenu("Account");
		menu_client.add(mnAccount);
		
		item_edit = new JMenuItem("Edit Account");
		mnAccount.add(item_edit);
		
		item_delete = new JMenuItem("Delete Account");
		mnAccount.add(item_delete);
		
		JMenu mnOrder = new JMenu("Order");
		menu_client.add(mnOrder);
		
		item_orderFood = new JMenuItem("Order Food");
		mnOrder.add(item_orderFood);
		
		item_orderHistory = new JMenuItem("Order History");
		mnOrder.add(item_orderHistory);
		
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

	public JMenuItem getItem_edit() {
		return item_edit;
	}

	public void setItem_edit(JMenuItem item_edit) {
		this.item_edit = item_edit;
	}

	public JMenuItem getItem_delete() {
		return item_delete;
	}

	public void setItem_delete(JMenuItem item_delete) {
		this.item_delete = item_delete;
	}

	public JMenuItem getItem_orderFood() {
		return item_orderFood;
	}

	public void setItem_orderFood(JMenuItem item_orderFood) {
		this.item_orderFood = item_orderFood;
	}

	public JMenuItem getItem_orderHistory() {
		return item_orderHistory;
	}

	public void setItem_orderHistory(JMenuItem item_orderHistory) {
		this.item_orderHistory = item_orderHistory;
	}

}
