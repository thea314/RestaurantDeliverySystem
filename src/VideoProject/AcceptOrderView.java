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

public class AcceptOrderView extends JFrame{
	private JTable table_pending;
	private JTable table_meal;
	private JTextField txt_date;
	private JTextField txt_time;
	private JTextField txt_postal;
	private JButton btn_accept;
	private JButton btn_cancel;


	/**
	 * Create the application.
	 */
	public AcceptOrderView() {
		setTitle("Accept Order");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 722, 481);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 706, 442);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(107, 11, 488, 55);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/acceptOrder.png"));
		panel.add(lbl_title);
		
		JLabel lbl_pending = new JLabel("Pending Orders");
		lbl_pending.setForeground(SystemColor.window);
		lbl_pending.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_pending.setBounds(50, 73, 119, 14);
		panel.add(lbl_pending);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 93, 155, 327);
		panel.add(scrollPane);
		
		table_pending = new JTable();
		scrollPane.setViewportView(table_pending);
		
		JLabel lbl_deliveryDate = new JLabel("(yyyy/mm/dd):");
		lbl_deliveryDate.setForeground(SystemColor.window);
		lbl_deliveryDate.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryDate.setBounds(310, 114, 119, 14);
		panel.add(lbl_deliveryDate);
		
		JLabel lbl_deliveryTime = new JLabel("Delivery Time:");
		lbl_deliveryTime.setForeground(SystemColor.window);
		lbl_deliveryTime.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryTime.setBounds(310, 145, 131, 14);
		panel.add(lbl_deliveryTime);
		
		JLabel lbl_postal = new JLabel("Postal Code:");
		lbl_postal.setForeground(SystemColor.window);
		lbl_postal.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_postal.setBounds(310, 170, 119, 14);
		panel.add(lbl_postal);
		
		JLabel lbl_meal = new JLabel("Meal In Order:");
		lbl_meal.setForeground(SystemColor.window);
		lbl_meal.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_meal.setBounds(310, 217, 155, 14);
		panel.add(lbl_meal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(310, 242, 187, 171);
		panel.add(scrollPane_1);
		
		table_meal = new JTable();
		scrollPane_1.setViewportView(table_meal);
		
		btn_accept = new JButton("Accept Order");
		btn_accept.setBackground(new Color(244, 164, 96));
		btn_accept.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_accept.setBounds(526, 328, 157, 37);
		panel.add(btn_accept);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(526, 376, 157, 37);
		panel.add(btn_cancel);
		
		txt_date = new JTextField();
		txt_date.setEnabled(false);
		txt_date.setBounds(466, 110, 119, 20);
		panel.add(txt_date);
		txt_date.setColumns(10);
		
		txt_time = new JTextField();
		txt_time.setEnabled(false);
		txt_time.setBounds(466, 141, 119, 20);
		panel.add(txt_time);
		txt_time.setColumns(10);
		
		txt_postal = new JTextField();
		txt_postal.setEnabled(false);
		txt_postal.setBounds(466, 166, 119, 20);
		panel.add(txt_postal);
		txt_postal.setColumns(10);
		
		this.setVisible(true);
	}

	public JTable getTable_pending() {
		return table_pending;
	}

	public void setTable_pending(JTable table_pending) {
		this.table_pending = table_pending;
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

	public JTextField getTxt_hr() {
		return txt_time;
	}

	public void setTxt_hr(JTextField txt_hr) {
		this.txt_time = txt_hr;
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

	public JButton getBtn_accept() {
		return btn_accept;
	}

	public void setBtn_accept(JButton btn_accept) {
		this.btn_accept = btn_accept;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}

}
