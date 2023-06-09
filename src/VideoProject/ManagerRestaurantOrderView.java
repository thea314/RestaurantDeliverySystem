package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ManagerRestaurantOrderView extends JFrame {
	private JTable table_order;
	private JTable table_meal;
	private JTextField txt_date;
	private JTextField txt_time;
	private JTextField txt_postal;
	private JButton btn_close;



	/**
	 * Create the application.
	 */
	public ManagerRestaurantOrderView() {
		setTitle("Order History");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 631, 482);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 620, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_tableHistory = new JLabel("Your Orders:");
		lbl_tableHistory.setForeground(SystemColor.window);
		lbl_tableHistory.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_tableHistory.setBounds(45, 83, 96, 14);
		panel.add(lbl_tableHistory);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/orders.png"));
		lbl_title.setBounds(178, 11, 262, 61);
		panel.add(lbl_title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 105, 135, 302);
		panel.add(scrollPane);
		
		table_order = new JTable();
		scrollPane.setColumnHeaderView(table_order);
		
		JLabel lbl_deliveryTime = new JLabel("(yyyy/mm/dd):");
		lbl_deliveryTime.setForeground(SystemColor.window);
		lbl_deliveryTime.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryTime.setBounds(250, 99, 112, 14);
		panel.add(lbl_deliveryTime);
		
		JLabel lbl_deliveryTimeHrMin = new JLabel("Delivery Time:");
		lbl_deliveryTimeHrMin.setForeground(SystemColor.window);
		lbl_deliveryTimeHrMin.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryTimeHrMin.setBounds(250, 135, 112, 14);
		panel.add(lbl_deliveryTimeHrMin);
		
		JLabel lbl_postalCode = new JLabel("Postal Code:");
		lbl_postalCode.setForeground(SystemColor.window);
		lbl_postalCode.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_postalCode.setBounds(250, 169, 96, 14);
		panel.add(lbl_postalCode);
		
		JLabel lbl_meal = new JLabel("Meal in Order:");
		lbl_meal.setForeground(SystemColor.window);
		lbl_meal.setFont(new Font("Consolas", Font.BOLD, 14));
		lbl_meal.setBounds(250, 194, 112, 14);
		panel.add(lbl_meal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 219, 195, 188);
		panel.add(scrollPane_1);
		
		table_meal = new JTable();
		scrollPane_1.setViewportView(table_meal);
		
		btn_close = new JButton("Close");
		btn_close.setBackground(new Color(244, 164, 96));
		btn_close.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_close.setBounds(499, 347, 89, 35);
		panel.add(btn_close);
		
		txt_date = new JTextField();
		txt_date.setEnabled(false);
		txt_date.setBounds(449, 95, 139, 20);
		panel.add(txt_date);
		txt_date.setColumns(10);
		
		txt_time = new JTextField();
		txt_time.setEnabled(false);
		txt_time.setBounds(447, 131, 141, 20);
		panel.add(txt_time);
		txt_time.setColumns(10);
		
		txt_postal = new JTextField();
		txt_postal.setEnabled(false);
		txt_postal.setBounds(449, 165, 139, 20);
		panel.add(txt_postal);
		txt_postal.setColumns(10);
		
		this.setVisible(true);
	}
	
	public JTable getTable_order() {
		return table_order;
	}

	public void setTable_order(JTable table_order) {
		this.table_order = table_order;
	}

	public JTable getTable_meal() {
		return table_meal;
	}

	public void setTable_meal(JTable table_meal) {
		this.table_meal = table_meal;
	}

	public JTextField getTxt_date() {
		return txt_date;
	}

	public void setTxt_date(JTextField txt_date) {
		this.txt_date = txt_date;
	}

	public JTextField getTxt_time() {
		return txt_time;
	}

	public void setTxt_time(JTextField txt_time) {
		this.txt_time = txt_time;
	}

	public JTextField getTxt_postal() {
		return txt_postal;
	}

	public void setTxt_postal(JTextField txt_postal) {
		this.txt_postal = txt_postal;
	}

	public JButton getBtn_close() {
		return btn_close;
	}

	public void setBtn_close(JButton btn_close) {
		this.btn_close = btn_close;
	}

}
