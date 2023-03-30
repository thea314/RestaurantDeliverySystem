package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class DeliveryGuyView extends JFrame{

	private JMenuItem item_disconnect;
	private JMenuItem item_deliveryView;
	private JMenuItem item_acceptDelivery;
	private JMenuItem item_deliveryDone;
	private JMenuItem item_quit;

	/**
	 * Create the application.
	 */
	public DeliveryGuyView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		item_disconnect = new JMenuItem("Disconnect");
		mnFile.add(item_disconnect);
		
		item_quit = new JMenuItem("Quit");
		mnFile.add(item_quit);
		
		JMenu mnDelivery = new JMenu("Delivery");
		menuBar.add(mnDelivery);
		
		item_deliveryView = new JMenuItem("View Deliveries");
		mnDelivery.add(item_deliveryView);
		
		item_acceptDelivery = new JMenuItem("Accept Delivery");
		mnDelivery.add(item_acceptDelivery);
		
		item_deliveryDone = new JMenuItem("Delivery Done");
		mnDelivery.add(item_deliveryDone);
		
		this.setVisible(true);
	}

	public JMenuItem getItem_disconnect() {
		return item_disconnect;
	}

	public void setItem_disconnect(JMenuItem item_disconnect) {
		this.item_disconnect = item_disconnect;
	}


	public JMenuItem getItem_quit() {
		return item_quit;
	}

	public void setItem_quit(JMenuItem item_quit) {
		this.item_quit = item_quit;
	}

	public JMenuItem getItem_deliveryView() {
		return item_deliveryView;
	}

	public void setItem_deliveryView(JMenuItem item_deliveryView) {
		this.item_deliveryView = item_deliveryView;
	}

	public JMenuItem getItem_acceptDelivery() {
		return item_acceptDelivery;
	}

	public void setItem_acceptDelivery(JMenuItem item_acceptDelivery) {
		this.item_acceptDelivery = item_acceptDelivery;
	}

	public JMenuItem getItem_deliveryDone() {
		return item_deliveryDone;
	}

	public void setItem_deliveryDone(JMenuItem item_deliveryDone) {
		this.item_deliveryDone = item_deliveryDone;
	}
}
