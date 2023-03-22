package VideoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CreateRestaurantView extends JFrame{

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateRestaurantView window = new CreateRestaurantView();
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
	public CreateRestaurantView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
