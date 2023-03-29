package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DeleteDeliveryGuyView extends JFrame{
	private JTextField txt_areaCode;
	private JTextField txt_phone1;
	private JTextField txt_phone2;
	private JTextField txt_driverName;
	private JButton btn_save;
	private JButton btn_cancel;
	private JTextField txt_username;
	private JTextArea txtArea_deliveryArea;
	private JTable table_deliveryGuy;

	/**
	 * Create the application.
	 */
	public DeleteDeliveryGuyView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 486, 469);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 473, 430);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(104, 15, 477, 67);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/deleteDelivery.png"));
		panel.add(lbl_title);
		
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(SystemColor.window);
		lbl_name.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_name.setBounds(137, 93, 46, 14);
		panel.add(lbl_name);
		
		JLabel lbl_phone = new JLabel("Phone:");
		lbl_phone.setForeground(SystemColor.window);
		lbl_phone.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_phone.setBounds(137, 133, 57, 14);
		panel.add(lbl_phone);
		
		JLabel lbl_openBracket = new JLabel("(");
		lbl_openBracket.setForeground(SystemColor.window);
		lbl_openBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_openBracket.setBounds(204, 133, 8, 14);
		panel.add(lbl_openBracket);
		
		txt_areaCode = new JTextField();
		txt_areaCode.setEnabled(false);
		txt_areaCode.setBounds(222, 129, 33, 20);
		panel.add(txt_areaCode);
		txt_areaCode.setColumns(10);
		
		JLabel lbl_closeBracket = new JLabel(")");
		lbl_closeBracket.setForeground(SystemColor.window);
		lbl_closeBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_closeBracket.setBounds(265, 133, 16, 14);
		panel.add(lbl_closeBracket);
		
		txt_phone1 = new JTextField();
		txt_phone1.setEnabled(false);
		txt_phone1.setBounds(281, 129, 38, 20);
		panel.add(txt_phone1);
		txt_phone1.setColumns(10);
		
		JLabel lbl_dash = new JLabel("-");
		lbl_dash.setForeground(SystemColor.window);
		lbl_dash.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_dash.setBounds(329, 133, 16, 14);
		panel.add(lbl_dash);
		
		txt_phone2 = new JTextField();
		txt_phone2.setEnabled(false);
		txt_phone2.setBounds(343, 129, 57, 20);
		panel.add(txt_phone2);
		txt_phone2.setColumns(10);
		
		JLabel lbl_area = new JLabel("Delivery Area");
		lbl_area.setForeground(SystemColor.window);
		lbl_area.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_area.setBounds(224, 167, 154, 33);
		panel.add(lbl_area);
		
		txt_driverName = new JTextField();
		txt_driverName.setEnabled(false);
		txt_driverName.setBounds(217, 89, 183, 20);
		panel.add(txt_driverName);
		txt_driverName.setColumns(10);
		
		txtArea_deliveryArea = new JTextArea();
		txtArea_deliveryArea.setEditable(false);
		txtArea_deliveryArea.setEnabled(false);
		txtArea_deliveryArea.setBounds(171, 200, 229, 78);
		panel.add(txtArea_deliveryArea);
		
		btn_save = new JButton("Delete");
		btn_save.setBackground(new Color(244, 164, 96));
		btn_save.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_save.setBounds(148, 375, 89, 42);
		panel.add(btn_save);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(311, 374, 89, 45);
		panel.add(btn_cancel);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setForeground(SystemColor.window);
		lbl_username.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_username.setBounds(171, 309, 83, 14);
		panel.add(lbl_username);
		
		txt_username = new JTextField();
		txt_username.setEnabled(false);
		txt_username.setBounds(292, 305, 108, 20);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 105, 257);
		panel.add(scrollPane);
		
		table_deliveryGuy = new JTable();
		table_deliveryGuy.setBounds(10, 81, 108, 256);
		scrollPane.setColumnHeaderView(table_deliveryGuy);

		
		this.setVisible(true);
	}

	public JTextField getTxt_password() {
		return txt_password;
	}

	public void setTxt_password(JTextField txt_password) {
		this.txt_password = txt_password;
	}

	public JTable getTable_deliveryGuy() {
		return table_deliveryGuy;
	}

	public void setTable_deliveryGuy(JTable table_deliveryGuy) {
		this.table_deliveryGuy = table_deliveryGuy;
	}

	public JTextField getTxt_areaCode() {
		return txt_areaCode;
	}

	public void setTxt_areaCode(JTextField txt_areaCode) {
		this.txt_areaCode = txt_areaCode;
	}

	public JTextField getTxt_phone1() {
		return txt_phone1;
	}

	public void setTxt_phone1(JTextField txt_phone1) {
		this.txt_phone1 = txt_phone1;
	}

	public JTextField getTxt_phone2() {
		return txt_phone2;
	}

	public void setTxt_phone2(JTextField txt_phone2) {
		this.txt_phone2 = txt_phone2;
	}

	public JTextField getTxt_driverName() {
		return txt_driverName;
	}

	public void setTxt_driverName(JTextField txt_driverName) {
		this.txt_driverName = txt_driverName;
	}

	public JTextField getTxt_addArea() {
		return txt_addArea;
	}

	public void setTxt_addArea(JTextField txt_addArea) {
		this.txt_addArea = txt_addArea;
	}

	public JButton getBtn_addArea() {
		return btn_addArea;
	}

	public void setBtn_addArea(JButton btn_addArea) {
		this.btn_addArea = btn_addArea;
	}

	public JButton getBtn_delete() {
		return btn_delete;
	}

	public void setBtn_delete(JButton btn_delete) {
		this.btn_delete = btn_delete;
	}

	public JButton getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(JButton btn_save) {
		this.btn_save = btn_save;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}

	public JTextField getTxt_username() {
		return txt_username;
	}

	public void setTxt_username(JTextField txt_username) {
		this.txt_username = txt_username;
	}

	public JTextArea getTxtArea_deliveryArea() {
		return txtArea_deliveryArea;
	}

	public void setTxtArea_deliveryArea(JTextArea txtArea_deliveryArea) {
		this.txtArea_deliveryArea = txtArea_deliveryArea;
	}
}
