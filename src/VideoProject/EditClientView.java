package VideoProject;

import java.awt.EventQueue;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.SystemColor;

public class EditClientView extends JFrame{

	private JTextField txt_username;
	private JTextField txt_oldPassword;
	private JTextField txt_confirmNewPassword;
	private JTextField txt_lastname;
	private JTextField txt_firstname;
	private JTextField txt_address;
	private JTextField txt_email;
	private JTextField txt_areaCode;
	private JTextField txt_phone1;
	private JTextField txt_phone2;
	private JTextField txt_newPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditVideoView window = new EditVideoView();
//					window.this.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public EditClientView() {
		setTitle("Edit Client");
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {

		this.setBounds(100, 100, 690, 523);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setForeground(Color.WHITE);
		mainPanel.setBorder(null);
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(0, 0, 824, 561);
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lbl_usernameText = new JLabel("Username:");
		lbl_usernameText.setBounds(113, 125, 79, 14);
		lbl_usernameText.setForeground(Color.WHITE);
		lbl_usernameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_usernameText);
		
		JLabel lbl_passwordText = new JLabel("Old Password:");
		lbl_passwordText.setBounds(113, 150, 128, 14);
		lbl_passwordText.setForeground(Color.WHITE);
		lbl_passwordText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_passwordText);
		
		JLabel lbl_conformPassWordText = new JLabel("Confirm New Password:");
		lbl_conformPassWordText.setBounds(113, 200, 185, 14);
		lbl_conformPassWordText.setForeground(Color.WHITE);
		lbl_conformPassWordText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_conformPassWordText);
		
		JLabel lbl_lastNameText = new JLabel("Last Name:");
		lbl_lastNameText.setBounds(113, 225, 103, 14);
		lbl_lastNameText.setForeground(Color.WHITE);
		lbl_lastNameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_lastNameText);
		
		JLabel lbl_FirstNameText = new JLabel("First Name:");
		lbl_FirstNameText.setBounds(113, 250, 103, 14);
		lbl_FirstNameText.setForeground(Color.WHITE);
		lbl_FirstNameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_FirstNameText);
		
		JLabel lbl_AddressText = new JLabel("Address:");
		lbl_AddressText.setBounds(113, 275, 79, 14);
		lbl_AddressText.setForeground(Color.WHITE);
		lbl_AddressText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_AddressText);
		
		JLabel lbl_emailText = new JLabel("Email:");
		lbl_emailText.setBounds(113, 300, 79, 14);
		lbl_emailText.setForeground(Color.WHITE);
		lbl_emailText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_emailText);
		
		JLabel lbl_PhoneText = new JLabel("Phone Number:");
		lbl_PhoneText.setBounds(113, 325, 128, 14);
		lbl_PhoneText.setForeground(Color.WHITE);
		lbl_PhoneText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_PhoneText);
		
		txt_username = new JTextField();
		txt_username.setBounds(379, 121, 177, 20);
		txt_username.setColumns(10);
		txt_username.setEnabled(false);
		mainPanel.add(txt_username);
		
		txt_oldPassword = new JTextField();
		txt_oldPassword.setBounds(379, 146, 177, 20);
		txt_oldPassword.setColumns(10);
		mainPanel.add(txt_oldPassword);
		
		txt_confirmNewPassword = new JTextField();
		txt_confirmNewPassword.setBounds(379, 196, 177, 20);
		txt_confirmNewPassword.setColumns(10);
		mainPanel.add(txt_confirmNewPassword);
		
		txt_lastname = new JTextField();
		txt_lastname.setBounds(379, 221, 177, 20);
		txt_lastname.setColumns(10);
		mainPanel.add(txt_lastname);
		
		txt_firstname = new JTextField();
		txt_firstname.setBounds(379, 246, 177, 20);
		txt_firstname.setColumns(10);
		mainPanel.add(txt_firstname);
		
		txt_address = new JTextField();
		txt_address.setBounds(379, 271, 177, 20);
		txt_address.setColumns(10);
		mainPanel.add(txt_address);
		
		txt_email = new JTextField();
		txt_email.setBounds(379, 296, 177, 20);
		txt_email.setColumns(10);
		mainPanel.add(txt_email);
		
		JLabel lbl_openBracket = new JLabel("(");
		lbl_openBracket.setBounds(379, 325, 14, 14);
		lbl_openBracket.setForeground(Color.WHITE);
		lbl_openBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_openBracket);
		
		txt_areaCode = new JTextField();
		txt_areaCode.setBounds(389, 321, 38, 20);
		txt_areaCode.setColumns(10);
		mainPanel.add(txt_areaCode);
		
		JLabel lbl_closedBracket = new JLabel(")");
		lbl_closedBracket.setBounds(426, 325, 14, 14);
		lbl_closedBracket.setForeground(Color.WHITE);
		lbl_closedBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_closedBracket);
		
		txt_phone1 = new JTextField();
		txt_phone1.setBounds(442, 321, 38, 20);
		txt_phone1.setColumns(10);
		mainPanel.add(txt_phone1);
		
		JLabel lbl_hyphenText = new JLabel("-");
		lbl_hyphenText.setBounds(490, 325, 14, 14);
		lbl_hyphenText.setForeground(Color.WHITE);
		lbl_hyphenText.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lbl_hyphenText);
		
		txt_phone2 = new JTextField();
		txt_phone2.setBounds(503, 321, 53, 20);
		txt_phone2.setColumns(10);
		mainPanel.add(txt_phone2);
		
		JButton btn_save = new JButton("Save");
		btn_save.setBounds(258, 384, 89, 36);
		btn_save.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_save.setEnabled(false);
		btn_save.setBackground(new Color(244, 164, 96));
		mainPanel.add(btn_save);
		
		JButton btn_return = new JButton("Return");
		btn_return.setBounds(467, 384, 89, 36);
		btn_return.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_return.setBackground(new Color(244, 164, 96));
		mainPanel.add(btn_return);
		
		JLabel lbl_title = new JLabel();
		lbl_title.setBounds(116, 23, 494, 52);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/editClient.png"));
		mainPanel.add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("New Password:");
		lblNewLabel.setBounds(113, 175, 128, 14);
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		mainPanel.add(lblNewLabel);
		
		txt_newPassword = new JTextField();
		txt_newPassword.setBounds(379, 171, 177, 20);
		mainPanel.add(txt_newPassword);
		txt_newPassword.setColumns(10);
		

		
		this.setVisible(true);	
	}

	public JTextField getTxt_username() {
		return txt_username;
	}

	public void setTxt_username(JTextField txt_username) {
		this.txt_username = txt_username;
	}

	public JTextField getTxt_oldPassword() {
		return txt_oldPassword;
	}

	public void setTxt_oldPassword(JTextField txt_oldPassword) {
		this.txt_oldPassword = txt_oldPassword;
	}

	public JTextField getTxt_confirmNewPassword() {
		return txt_confirmNewPassword;
	}

	public void setTxt_confirmNewPassword(JTextField txt_confirmNewPassword) {
		this.txt_confirmNewPassword = txt_confirmNewPassword;
	}

	public JTextField getTxt_lastname() {
		return txt_lastname;
	}

	public void setTxt_lastname(JTextField txt_lastname) {
		this.txt_lastname = txt_lastname;
	}

	public JTextField getTxt_firstname() {
		return txt_firstname;
	}

	public void setTxt_firstname(JTextField txt_firstname) {
		this.txt_firstname = txt_firstname;
	}

	public JTextField getTxt_address() {
		return txt_address;
	}

	public void setTxt_address(JTextField txt_address) {
		this.txt_address = txt_address;
	}

	public JTextField getTxt_email() {
		return txt_email;
	}

	public void setTxt_email(JTextField txt_email) {
		this.txt_email = txt_email;
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

	public JTextField getTxt_newPassword() {
		return txt_newPassword;
	}

	public void setTxt_newPassword(JTextField txt_newPassword) {
		this.txt_newPassword = txt_newPassword;
	}
}
