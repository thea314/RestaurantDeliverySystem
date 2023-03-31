package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CreateDeliveryGuyView extends JFrame{
	private JTextField txt_areaCode;
	private JTextField txt_phone1;
	private JTextField txt_phone2;
	private JTextField txt_driverName;
	private JTextField txt_addArea;
	private JButton btn_addArea;
	private JButton btn_delete;
	private JButton btn_save;
	private JButton btn_cancel;
	private JTextField txt_username;
	private JPasswordField  txt_password;
	private JButton btn_validateUsername;
	private JTextArea txtArea_deliveryArea;

	/**
	 * Create the application.
	 */
	public CreateDeliveryGuyView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 653, 469);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 637, 430);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(104, 15, 477, 67);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/createDelivery.png"));
		panel.add(lbl_title);
		
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(SystemColor.window);
		lbl_name.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_name.setBounds(119, 93, 46, 14);
		panel.add(lbl_name);
		
		JLabel lbl_phone = new JLabel("Phone:");
		lbl_phone.setForeground(SystemColor.window);
		lbl_phone.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_phone.setBounds(119, 133, 57, 14);
		panel.add(lbl_phone);
		
		JLabel lbl_openBracket = new JLabel("(");
		lbl_openBracket.setForeground(SystemColor.window);
		lbl_openBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_openBracket.setBounds(194, 132, 8, 14);
		panel.add(lbl_openBracket);
		
		txt_areaCode = new JTextField();
		txt_areaCode.setBounds(204, 129, 33, 20);
		panel.add(txt_areaCode);
		txt_areaCode.setColumns(10);
		
		JLabel lbl_closeBracket = new JLabel(")");
		lbl_closeBracket.setForeground(SystemColor.window);
		lbl_closeBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_closeBracket.setBounds(240, 133, 8, 14);
		panel.add(lbl_closeBracket);
		
		txt_phone1 = new JTextField();
		txt_phone1.setBounds(256, 129, 38, 20);
		panel.add(txt_phone1);
		txt_phone1.setColumns(10);
		
		JLabel lbl_dash = new JLabel("-");
		lbl_dash.setForeground(SystemColor.window);
		lbl_dash.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_dash.setBounds(304, 132, 16, 14);
		panel.add(lbl_dash);
		
		txt_phone2 = new JTextField();
		txt_phone2.setBounds(321, 129, 57, 20);
		panel.add(txt_phone2);
		txt_phone2.setColumns(10);
		
		JLabel lbl_area = new JLabel("Delivery Area");
		lbl_area.setForeground(SystemColor.window);
		lbl_area.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_area.setBounds(194, 170, 154, 33);
		panel.add(lbl_area);
		
		txt_driverName = new JTextField();
		txt_driverName.setBounds(195, 89, 183, 20);
		panel.add(txt_driverName);
		txt_driverName.setColumns(10);
		
		txtArea_deliveryArea = new JTextArea();
		txtArea_deliveryArea.setEditable(false);
		txtArea_deliveryArea.setBounds(118, 200, 282, 78);
		panel.add(txtArea_deliveryArea);
		
		JLabel lbl_addArea = new JLabel("Delivery Area:");
		lbl_addArea.setForeground(SystemColor.window);
		lbl_addArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_addArea.setBounds(410, 206, 123, 14);
		panel.add(lbl_addArea);
		
		txt_addArea = new JTextField();
		txt_addArea.setBounds(541, 202, 86, 20);
		panel.add(txt_addArea);
		txt_addArea.setColumns(10);
		
		btn_addArea = new JButton("Add");
		btn_addArea.setBackground(new Color(244, 164, 96));
		btn_addArea.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_addArea.setBounds(420, 231, 75, 42);
		panel.add(btn_addArea);
		
		btn_delete = new JButton("Delete");
		btn_delete.setBackground(new Color(244, 164, 96));
		btn_delete.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_delete.setBounds(517, 231, 89, 42);
		panel.add(btn_delete);
		
		btn_save = new JButton("Save");
		btn_save.setEnabled(false);
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
		lbl_username.setBounds(119, 302, 83, 14);
		panel.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setForeground(SystemColor.window);
		lbl_password.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_password.setBounds(119, 338, 75, 14);
		panel.add(lbl_password);
		
		txt_username = new JTextField();
		txt_username.setBounds(204, 298, 108, 20);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JPasswordField ();
		txt_password.setEchoChar('*');
		txt_password.setBounds(204, 334, 108, 20);
		panel.add(txt_password);
		txt_password.setColumns(10);
		
		btn_validateUsername = new JButton("Validate");
		btn_validateUsername.setBackground(new Color(244, 164, 96));
		btn_validateUsername.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_validateUsername.setBounds(346, 289, 108, 43);
		panel.add(btn_validateUsername);
		
		this.setVisible(true);
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

	public JPasswordField  getTxt_password() {
		return txt_password;
	}

	public void setTxt_password(JPasswordField  txt_password) {
		this.txt_password = txt_password;
	}

	public JButton getBtn_validateUsername() {
		return btn_validateUsername;
	}

	public void setBtn_validateUsername(JButton btn_validateUsername) {
		this.btn_validateUsername = btn_validateUsername;
	}

	public JTextArea getTxtArea_deliveryArea() {
		return txtArea_deliveryArea;
	}

	public void setTxtArea_deliveryArea(JTextArea txtArea_deliveryArea) {
		this.txtArea_deliveryArea = txtArea_deliveryArea;
	}
	
	
	
}
