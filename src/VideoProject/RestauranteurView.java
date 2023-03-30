package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class RestauranteurView extends JFrame{

	private JMenuItem item_disconnect;
	private JMenuItem item_quit;
	private JMenuItem item_accept;
	private JMenuItem item_ready;
	

	/**
	 * Create the application.
	 */
	public RestauranteurView() {
		setTitle("Restauranteur");
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
		panel.setBounds(0, 0, 434, 261);
		panel.setBackground(Color.DARK_GRAY);
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
		
		JMenu mnOrder = new JMenu("Order");
		menuBar.add(mnOrder);
		
		item_accept = new JMenuItem("Accept Order");
		mnOrder.add(item_accept);
		
		item_ready = new JMenuItem("Order Ready");
		mnOrder.add(item_ready);
		
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

	public JMenuItem getItem_accept() {
		return item_accept;
	}

	public void setItem_accept(JMenuItem item_accept) {
		this.item_accept = item_accept;
	}

	public JMenuItem getItem_ready() {
		return item_ready;
	}

	public void setItem_ready(JMenuItem item_ready) {
		this.item_ready = item_ready;
	}

}
