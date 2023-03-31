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

public class DeliveryDoneView extends JFrame{
	private JTable table_order;
	private JTextField txt_orderNo;
	private JTextField txt_restoNo;
	private JTextField txt_address;
	private JTextField txt_postal;
	private JButton btn_complete;
	private JButton btn_close;


	


	/**
	 * Create the application.
	 */
	public DeliveryDoneView() {
		setTitle("Accept Delivery");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 599, 486);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 589, 447);
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(38, 11, 522, 45);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/completeDelivery.png"));
		panel.add(lbl_title);
		
		JLabel lbl_order = new JLabel("Order:");
		lbl_order.setForeground(SystemColor.window);
		lbl_order.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_order.setBounds(38, 76, 86, 14);
		panel.add(lbl_order);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 103, 166, 312);
		panel.add(scrollPane);
		
		table_order = new JTable();
		scrollPane.setViewportView(table_order);
		
		JLabel lbl_orderNo = new JLabel("Order #:");
		lbl_orderNo.setForeground(SystemColor.window);
		lbl_orderNo.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_orderNo.setBounds(250, 114, 70, 14);
		panel.add(lbl_orderNo);
		
		JLabel lbl_restoNo = new JLabel("Restaurant #:");
		lbl_restoNo.setForeground(SystemColor.window);
		lbl_restoNo.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restoNo.setBounds(250, 145, 104, 14);
		panel.add(lbl_restoNo);
		
		JLabel lbl_deliveryAddress = new JLabel("Address:");
		lbl_deliveryAddress.setForeground(SystemColor.window);
		lbl_deliveryAddress.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryAddress.setBounds(250, 170, 92, 14);
		panel.add(lbl_deliveryAddress);
		
		JLabel lbl_postalCode = new JLabel("Postal Code:");
		lbl_postalCode.setForeground(SystemColor.window);
		lbl_postalCode.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_postalCode.setBounds(250, 195, 104, 14);
		panel.add(lbl_postalCode);
		
		btn_close = new JButton("Close");
		btn_close.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_close.setBackground(new Color(244, 164, 96));
		btn_close.setBounds(424, 258, 89, 35);
		panel.add(btn_close);
		
		txt_orderNo = new JTextField();
		txt_orderNo.setEnabled(false);
		txt_orderNo.setBounds(381, 110, 86, 20);
		panel.add(txt_orderNo);
		txt_orderNo.setColumns(10);
		
		txt_restoNo = new JTextField();
		txt_restoNo.setEnabled(false);
		txt_restoNo.setBounds(381, 141, 86, 20);
		panel.add(txt_restoNo);
		txt_restoNo.setColumns(10);
		
		txt_address = new JTextField();
		txt_address.setEnabled(false);
		txt_address.setBounds(381, 166, 179, 20);
		panel.add(txt_address);
		txt_address.setColumns(10);
		
		txt_postal = new JTextField();
		txt_postal.setEnabled(false);
		txt_postal.setBounds(381, 191, 86, 20);
		panel.add(txt_postal);
		txt_postal.setColumns(10);
		
		btn_complete = new JButton("Complete");
		btn_complete.setBackground(new Color(244, 164, 96));
		btn_complete.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_complete.setBounds(261, 258, 125, 35);
		panel.add(btn_complete);
		
		this.setVisible(true);
	}
	public JTable getTable_order() {
		return table_order;
	}

	public void setTable_order(JTable table_order) {
		this.table_order = table_order;
	}

	public JTextField getTxt_orderNo() {
		return txt_orderNo;
	}

	public void setTxt_orderNo(JTextField txt_orderNo) {
		this.txt_orderNo = txt_orderNo;
	}

	public JTextField getTxt_restoNo() {
		return txt_restoNo;
	}

	public void setTxt_restoNo(JTextField txt_restoNo) {
		this.txt_restoNo = txt_restoNo;
	}

	public JTextField getTxt_address() {
		return txt_address;
	}

	public void setTxt_address(JTextField txt_address) {
		this.txt_address = txt_address;
	}

	public JTextField getTxt_postal() {
		return txt_postal;
	}

	public void setTxt_postal(JTextField txt_postal) {
		this.txt_postal = txt_postal;
	}

	public JButton getBtn_complete() {
		return btn_complete;
	}

	public void setBtn_complete(JButton btn_complete) {
		this.btn_complete = btn_complete;
	}
	public JButton getBtn_close() {
		return btn_close;
	}

	public void setBtn_close(JButton btn_close) {
		this.btn_close = btn_close;
	}

}
