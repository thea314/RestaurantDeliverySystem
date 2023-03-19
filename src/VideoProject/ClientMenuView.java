package VideoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class ClientMenuView {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu_client = new JMenuBar();
		frame.setJMenuBar(menu_client);
		
		JMenu mnFile = new JMenu("File");
		menu_client.add(mnFile);
		
		JMenuItem item_Disconnect = new JMenuItem("Disconnect");
		mnFile.add(item_Disconnect);
		
		JMenuItem item_quit = new JMenuItem("Quit");
		mnFile.add(item_quit);
		
		JMenu mnAccount = new JMenu("Account");
		menu_client.add(mnAccount);
		
		JMenuItem item_edit = new JMenuItem("Edit Account");
		mnAccount.add(item_edit);
		
		JMenuItem item_delete = new JMenuItem("Delete Account");
		mnAccount.add(item_delete);
		
		JMenu mnOrder = new JMenu("Order");
		menu_client.add(mnOrder);
		
		JMenuItem item_orderFood = new JMenuItem("Order Food");
		mnOrder.add(item_orderFood);
		
		JMenuItem item_orderHistory = new JMenuItem("Order History");
		mnOrder.add(item_orderHistory);
	}

}
