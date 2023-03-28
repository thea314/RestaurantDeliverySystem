package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateOrderView extends JFrame{
	private JTable table_resto;
	private JTable table_menu;
	private JTable table_order;
	private JTextField txt_hour;
	private JTextField txt_min;
	private JTextField txt_postalCode;
	private JTextField txt_meanName;
	private JTextField txt_price;
	private JTextField txt_quantity;
	private JTextField txt_total;
	private JButton btn_add;
	private JButton btn_delete;
	private JButton btn_order;
	private JLabel lbl_year;
	private JTextField txt_year;
	private JLabel lbl_month;
	private JTextField txt_month;
	private JLabel lbl_day;
	private JTextField txt_day;
	private JLabel lbl_resto;
	private JLabel lbl_menu;
	private JLabel lbl_order;
	private JButton btn_cancel;


	/**
	 * Create the application.
	 */
	public CreateOrderView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 606, 472);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 590, 433);
		panel.setBackground(Color.darkGray);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(112, 11, 303, 42);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/createOrder.png"));
		panel.add(lbl_title);
		
		JScrollPane scrollPane_resto = new JScrollPane();
		scrollPane_resto.setBounds(24, 173, 123, 230);
		panel.add(scrollPane_resto);
		
		table_resto = new JTable();
		scrollPane_resto.setViewportView(table_resto);
		
		JScrollPane scrollPane_menu = new JScrollPane();
		scrollPane_menu.setBounds(157, 173, 123, 230);
		panel.add(scrollPane_menu);
		
		table_menu = new JTable();
		scrollPane_menu.setViewportView(table_menu);
		
		JScrollPane scrollPane_order = new JScrollPane();
		scrollPane_order.setBounds(444, 173, 136, 190);
		panel.add(scrollPane_order);
		
		table_order = new JTable();
		scrollPane_order.setViewportView(table_order);
		
		JLabel lbl_deliveryDate = new JLabel("Delivery Date:");
		lbl_deliveryDate.setForeground(SystemColor.window);
		lbl_deliveryDate.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryDate.setBounds(112, 64, 136, 14);
		panel.add(lbl_deliveryDate);
		
		JLabel lbl_deliveryTime = new JLabel("Delivery Time:");
		lbl_deliveryTime.setForeground(SystemColor.window);
		lbl_deliveryTime.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryTime.setBounds(112, 103, 123, 14);
		panel.add(lbl_deliveryTime);
		
		JLabel lbl_postalCode = new JLabel("Postal Code:");
		lbl_postalCode.setForeground(SystemColor.window);
		lbl_postalCode.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_postalCode.setBounds(112, 128, 99, 14);
		panel.add(lbl_postalCode);
		
		txt_hour = new JTextField();
		txt_hour.setBounds(279, 94, 28, 20);
		panel.add(txt_hour);
		txt_hour.setColumns(10);
		
		JLabel lbl_h = new JLabel("h");
		lbl_h.setForeground(SystemColor.window);
		lbl_h.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h.setBounds(313, 98, 17, 14);
		panel.add(lbl_h);
		
		txt_min = new JTextField();
		txt_min.setBounds(329, 94, 38, 20);
		panel.add(txt_min);
		txt_min.setColumns(10);
		
		txt_postalCode = new JTextField();
		txt_postalCode.setBounds(281, 124, 86, 20);
		panel.add(txt_postalCode);
		txt_postalCode.setColumns(10);
		
		JLabel lbl_meal = new JLabel("Meal:");
		lbl_meal.setForeground(SystemColor.window);
		lbl_meal.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_meal.setBounds(290, 175, 46, 14);
		panel.add(lbl_meal);
		
		JLabel lbl_price = new JLabel("Price:");
		lbl_price.setForeground(SystemColor.window);
		lbl_price.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_price.setBounds(290, 200, 58, 14);
		panel.add(lbl_price);
		
		JLabel lbl_quantity = new JLabel("Quantity:");
		lbl_quantity.setForeground(SystemColor.window);
		lbl_quantity.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_quantity.setBounds(290, 225, 83, 14);
		panel.add(lbl_quantity);
		
		JLabel lbl_quantityMax = new JLabel("*max 10");
		lbl_quantityMax.setForeground(SystemColor.window);
		lbl_quantityMax.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_quantityMax.setBounds(290, 236, 77, 14);
		panel.add(lbl_quantityMax);
		
		btn_add = new JButton("Add");
		btn_add.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_add.setBackground(new Color(244, 164, 96));
		btn_add.setBounds(300, 250, 115, 35);
		panel.add(btn_add);
		
		btn_delete = new JButton("Delete");
		btn_delete.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_delete.setBackground(new Color(244, 164, 96));
		btn_delete.setBounds(300, 291, 115, 35);
		panel.add(btn_delete);
		
		JLabel lbl_total = new JLabel("Total:");
		lbl_total.setForeground(SystemColor.window);
		lbl_total.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_total.setBounds(290, 337, 58, 14);
		panel.add(lbl_total);
		
		btn_order = new JButton("Order");
		btn_order.setBackground(new Color(244, 164, 96));
		btn_order.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_order.setBounds(313, 368, 89, 35);
		panel.add(btn_order);
		
		txt_meanName = new JTextField();
		txt_meanName.setEnabled(false);
		txt_meanName.setBounds(348, 171, 86, 20);
		panel.add(txt_meanName);
		txt_meanName.setColumns(10);
		
		txt_price = new JTextField();
		txt_price.setEnabled(false);
		txt_price.setBounds(348, 196, 86, 20);
		panel.add(txt_price);
		txt_price.setColumns(10);
		
		txt_quantity = new JTextField();
		txt_quantity.setBounds(376, 221, 58, 20);
		panel.add(txt_quantity);
		txt_quantity.setColumns(10);
		
		txt_total = new JTextField();
		txt_total.setEditable(false);
		txt_total.setEnabled(false);
		txt_total.setBounds(348, 333, 86, 20);
		panel.add(txt_total);
		txt_total.setColumns(10);
		
		lbl_year = new JLabel("yyyy:");
		lbl_year.setForeground(SystemColor.window);
		lbl_year.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_year.setBounds(234, 63, 46, 14);
		panel.add(lbl_year);
		
		txt_year = new JTextField();
		txt_year.setBounds(290, 60, 46, 20);
		panel.add(txt_year);
		txt_year.setColumns(10);
		
		lbl_month = new JLabel("mm:");
		lbl_month.setForeground(SystemColor.window);
		lbl_month.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_month.setBounds(348, 63, 28, 14);
		panel.add(lbl_month);
		
		txt_month = new JTextField();
		txt_month.setBounds(376, 60, 28, 20);
		panel.add(txt_month);
		txt_month.setColumns(10);
		
		lbl_day = new JLabel("dd:");
		lbl_day.setForeground(SystemColor.window);
		lbl_day.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day.setBounds(414, 63, 28, 14);
		panel.add(lbl_day);
		
		txt_day = new JTextField();
		txt_day.setBounds(444, 58, 28, 20);
		panel.add(txt_day);
		txt_day.setColumns(10);
		
		lbl_resto = new JLabel("Restaurant:");
		lbl_resto.setForeground(SystemColor.window);
		lbl_resto.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_resto.setBounds(24, 159, 99, 14);
		panel.add(lbl_resto);
		
		lbl_menu = new JLabel("Menu:");
		lbl_menu.setForeground(SystemColor.window);
		lbl_menu.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_menu.setBounds(157, 158, 46, 14);
		panel.add(lbl_menu);
		
		lbl_order = new JLabel("Order:");
		lbl_order.setForeground(SystemColor.window);
		lbl_order.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_order.setBounds(443, 158, 77, 14);
		panel.add(lbl_order);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(491, 387, 89, 35);
		panel.add(btn_cancel);
		
		this.setVisible(true);
	}

	public JLabel getLbl_resto() {
		return lbl_resto;
	}

	public void setLbl_resto(JLabel lbl_resto) {
		this.lbl_resto = lbl_resto;
	}

	public JLabel getLbl_menu() {
		return lbl_menu;
	}

	public void setLbl_menu(JLabel lbl_menu) {
		this.lbl_menu = lbl_menu;
	}

	public JLabel getLbl_order() {
		return lbl_order;
	}

	public void setLbl_order(JLabel lbl_order) {
		this.lbl_order = lbl_order;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}

	public JLabel getLbl_year() {
		return lbl_year;
	}

	public void setLbl_year(JLabel lbl_year) {
		this.lbl_year = lbl_year;
	}

	public JTextField getTxt_year() {
		return txt_year;
	}

	public void setTxt_year(JTextField txt_year) {
		this.txt_year = txt_year;
	}

	public JLabel getLbl_month() {
		return lbl_month;
	}

	public void setLbl_month(JLabel lbl_month) {
		this.lbl_month = lbl_month;
	}

	public JTextField getTxt_month() {
		return txt_month;
	}

	public void setTxt_month(JTextField txt_month) {
		this.txt_month = txt_month;
	}

	public JLabel getLbl_day() {
		return lbl_day;
	}

	public void setLbl_day(JLabel lbl_day) {
		this.lbl_day = lbl_day;
	}

	public JTextField getTxt_day() {
		return txt_day;
	}

	public void setTxt_day(JTextField txt_day) {
		this.txt_day = txt_day;
	}

	public JTable getTable_resto() {
		return table_resto;
	}

	public void setTable_resto(JTable table_resto) {
		this.table_resto = table_resto;
	}

	public JTable getTable_menu() {
		return table_menu;
	}

	public void setTable_menu(JTable table_menu) {
		this.table_menu = table_menu;
	}

	public JTable getTable_order() {
		return table_order;
	}

	public void setTable_order(JTable table_order) {
		this.table_order = table_order;
	}

	public JTextField getTxt_hour() {
		return txt_hour;
	}

	public void setTxt_hour(JTextField txt_hour) {
		this.txt_hour = txt_hour;
	}

	public JTextField getTxt_min() {
		return txt_min;
	}

	public void setTxt_min(JTextField txt_min) {
		this.txt_min = txt_min;
	}

	public JTextField getTxt_postalCode() {
		return txt_postalCode;
	}

	public void setTxt_postalCode(JTextField txt_postalCode) {
		this.txt_postalCode = txt_postalCode;
	}

	public JTextField getTxt_meanName() {
		return txt_meanName;
	}

	public void setTxt_meanName(JTextField txt_meanName) {
		this.txt_meanName = txt_meanName;
	}

	public JTextField getTxt_price() {
		return txt_price;
	}

	public void setTxt_price(JTextField txt_price) {
		this.txt_price = txt_price;
	}

	public JTextField getTxt_quantity() {
		return txt_quantity;
	}

	public void setTxt_quantity(JTextField txt_quantity) {
		this.txt_quantity = txt_quantity;
	}

	public JTextField getTxt_total() {
		return txt_total;
	}

	public void setTxt_total(JTextField txt_total) {
		this.txt_total = txt_total;
	}

	public JButton getBtn_add() {
		return btn_add;
	}

	public void setBtn_add(JButton btn_add) {
		this.btn_add = btn_add;
	}

	public JButton getBtn_delete() {
		return btn_delete;
	}

	public void setBtn_delete(JButton btn_delete) {
		this.btn_delete = btn_delete;
	}

	public JButton getBtn_order() {
		return btn_order;
	}

	public void setBtn_order(JButton btn_order) {
		this.btn_order = btn_order;
	}
	
}
