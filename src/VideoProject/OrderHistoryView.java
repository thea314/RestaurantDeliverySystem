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

public class OrderHistoryView extends JFrame {
	private JTable table_order;
	private JTable table_meal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btn_close;



	/**
	 * Create the application.
	 */
	public OrderHistoryView() {
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
		lbl_tableHistory.setBounds(43, 72, 96, 14);
		panel.add(lbl_tableHistory);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/orderHistory.png"));
		lbl_title.setBounds(130, 11, 468, 50);
		panel.add(lbl_title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 97, 162, 308);
		panel.add(scrollPane);
		
		table_order = new JTable();
		scrollPane.setColumnHeaderView(table_order);
		
		JLabel lbl_deliveryTime = new JLabel("(yyyy/mm/dd):");
		lbl_deliveryTime.setForeground(SystemColor.window);
		lbl_deliveryTime.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryTime.setBounds(268, 99, 187, 14);
		panel.add(lbl_deliveryTime);
		
		JLabel lbl_deliveryTimeHrMin = new JLabel("Delivery Time:");
		lbl_deliveryTimeHrMin.setForeground(SystemColor.window);
		lbl_deliveryTimeHrMin.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryTimeHrMin.setBounds(268, 135, 112, 14);
		panel.add(lbl_deliveryTimeHrMin);
		
		JLabel lbl_postalCode = new JLabel("Postal Code:");
		lbl_postalCode.setForeground(SystemColor.window);
		lbl_postalCode.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_postalCode.setBounds(268, 169, 96, 14);
		panel.add(lbl_postalCode);
		
		JLabel lbl_meal = new JLabel("Meal in Order:");
		lbl_meal.setForeground(SystemColor.window);
		lbl_meal.setFont(new Font("Consolas", Font.BOLD, 14));
		lbl_meal.setBounds(268, 194, 112, 14);
		panel.add(lbl_meal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(268, 219, 195, 188);
		panel.add(scrollPane_1);
		
		table_meal = new JTable();
		scrollPane_1.setViewportView(table_meal);
		
		btn_close = new JButton("Close");
		btn_close.setBackground(new Color(244, 164, 96));
		btn_close.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_close.setBounds(499, 370, 89, 35);
		panel.add(btn_close);
		
		textField = new JTextField();
		textField.setBounds(406, 95, 139, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(404, 131, 141, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(406, 165, 139, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
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

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JButton getBtn_close() {
		return btn_close;
	}

	public void setBtn_close(JButton btn_close) {
		this.btn_close = btn_close;
	}

}
