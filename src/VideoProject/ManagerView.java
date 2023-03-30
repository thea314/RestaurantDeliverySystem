package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ManagerView extends JFrame{

	private JMenuItem item_disconnect;
	private JMenuItem item_quit;
	private JMenuItem item_viewOrder;


	/**
	 * Create the application.
	 */
	public ManagerView() {
		setTitle("Manager Menu");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 515, 432);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 499, 371);
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
		
		item_viewOrder = new JMenuItem("View Restaurant's Order");
		mnOrder.add(item_viewOrder);
		
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

	public JMenuItem getItem_viewOrder() {
		return item_viewOrder;
	}

	public void setItem_viewOrder(JMenuItem item_viewOrder) {
		this.item_viewOrder = item_viewOrder;
	}

}
