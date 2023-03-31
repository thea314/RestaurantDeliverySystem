package VideoProject;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateClientView extends JFrame{

	private JTextField txt_username;
	private JPasswordField  txt_password;
	private JPasswordField  txt_confirmPassword;
	private JTextField txt_lastname;
	private JTextField txt_firstname;
	private JTextField txt_address;
	private JTextField txt_email;
	private JTextField txt_areacode;
	private JTextField txt_phone1;
	private JTextField txt_phone2;
	
	JButton btn_usernameValidate = new JButton("Validate");
	JButton btn_save = new JButton("Save");
	JButton btn_return = new JButton("Return");
	JButton btn_quit = new JButton("Quit");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateClientView window = new CreateClientView();
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
	public CreateClientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBackground(UIManager.getColor("Button.disabledForeground"));
		this.setTitle("Create New Client");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setForeground(UIManager.getColor("Button.highlight"));
		mainPanel.setBorder(null);
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(0, 0, 784, 561);
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lbl_NewClientLogo = new JLabel();
		lbl_NewClientLogo.setIcon(new javax.swing.ImageIcon("./Logos/createNewClientJavaFinal.png"));
		lbl_NewClientLogo.setBounds(63, 11, 711, 60);
		mainPanel.add(lbl_NewClientLogo);
		
		JLabel lbl_usernameText = new JLabel("Username:");
		lbl_usernameText.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_usernameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_usernameText.setBounds(113, 145, 79, 14);
		mainPanel.add(lbl_usernameText);
		
		JLabel lbl_passwordText = new JLabel("Password:");
		lbl_passwordText.setForeground(Color.WHITE);
		lbl_passwordText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_passwordText.setBounds(113, 184, 79, 14);
		mainPanel.add(lbl_passwordText);
		
		JLabel lbl_conformPassWordText = new JLabel("Confirm Password:");
		lbl_conformPassWordText.setForeground(Color.WHITE);
		lbl_conformPassWordText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_conformPassWordText.setBounds(113, 221, 144, 14);
		mainPanel.add(lbl_conformPassWordText);
		
		JLabel lbl_lastNameText = new JLabel("Last Name:");
		lbl_lastNameText.setForeground(Color.WHITE);
		lbl_lastNameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_lastNameText.setBounds(113, 261, 103, 14);
		mainPanel.add(lbl_lastNameText);
		
		JLabel lbl_FirstNameText = new JLabel("First Name:");
		lbl_FirstNameText.setForeground(Color.WHITE);
		lbl_FirstNameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_FirstNameText.setBounds(113, 301, 103, 14);
		mainPanel.add(lbl_FirstNameText);
		
		JLabel lbl_AddressText = new JLabel("Address:");
		lbl_AddressText.setForeground(Color.WHITE);
		lbl_AddressText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_AddressText.setBounds(113, 344, 79, 14);
		mainPanel.add(lbl_AddressText);
		
		JLabel lbl_emailText = new JLabel("Email:");
		lbl_emailText.setForeground(Color.WHITE);
		lbl_emailText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_emailText.setBounds(113, 385, 79, 14);
		mainPanel.add(lbl_emailText);
		
		JLabel lbl_PhoneText = new JLabel("Phone Number:");
		lbl_PhoneText.setForeground(Color.WHITE);
		lbl_PhoneText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_PhoneText.setBounds(113, 428, 128, 14);
		mainPanel.add(lbl_PhoneText);
		
		txt_username = new JTextField();
		txt_username.setBounds(379, 141, 177, 20);
		mainPanel.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JPasswordField ();
		txt_password.setColumns(10);
		txt_password.setEchoChar('*');
		txt_password.setBounds(379, 180, 177, 20);
		mainPanel.add(txt_password);
		
		txt_confirmPassword = new JPasswordField ();
		txt_confirmPassword.setColumns(10);
		txt_confirmPassword.setEchoChar('*');
		txt_confirmPassword.setBounds(379, 217, 177, 20);
		mainPanel.add(txt_confirmPassword);
		
		txt_lastname = new JTextField();
		txt_lastname.setColumns(10);
		txt_lastname.setBounds(379, 257, 177, 20);
		mainPanel.add(txt_lastname);
		
		txt_firstname = new JTextField();
		txt_firstname.setColumns(10);
		txt_firstname.setBounds(379, 297, 177, 20);
		mainPanel.add(txt_firstname);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(379, 340, 177, 20);
		mainPanel.add(txt_address);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(379, 381, 177, 20);
		mainPanel.add(txt_email);
		
		JLabel lbl_openBracket = new JLabel("(");
		lbl_openBracket.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_openBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_openBracket.setBounds(379, 427, 14, 14);
		mainPanel.add(lbl_openBracket);
		
		txt_areacode = new JTextField();
		txt_areacode.setBounds(389, 424, 38, 20);
		mainPanel.add(txt_areacode);
		txt_areacode.setColumns(10);
		
		JLabel lbl_closedBracket = new JLabel(")");
		lbl_closedBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_closedBracket.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_closedBracket.setBounds(426, 428, 14, 14);
		mainPanel.add(lbl_closedBracket);
		
		txt_phone1 = new JTextField();
		txt_phone1.setColumns(10);
		txt_phone1.setBounds(450, 424, 38, 20);
		mainPanel.add(txt_phone1);
		
		JLabel lbl_hyphenText = new JLabel("-");
		lbl_hyphenText.setForeground(UIManager.getColor("Button.highlight"));
		lbl_hyphenText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_hyphenText.setBounds(490, 428, 14, 14);
		mainPanel.add(lbl_hyphenText);
		
		txt_phone2 = new JTextField();
		txt_phone2.setBounds(503, 424, 53, 20);
		mainPanel.add(txt_phone2);
		txt_phone2.setColumns(10);
		
		
		btn_usernameValidate.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_usernameValidate.setBackground(new Color(244, 164, 96));
		btn_usernameValidate.setBounds(603, 135, 118, 36);
		mainPanel.add(btn_usernameValidate);
		
		
		btn_save.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_save.setBackground(new Color(244, 164, 96));
		btn_save.setBounds(246, 493, 89, 36);
		btn_save.setEnabled(false);
		mainPanel.add(btn_save);
		
		
		btn_return.setBackground(new Color(244, 164, 96));
		btn_return.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_return.setBounds(379, 493, 89, 36);
		mainPanel.add(btn_return);
		
		
		btn_quit.setBackground(new Color(244, 164, 96));
		btn_quit.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_quit.setBounds(514, 493, 89, 36);
		mainPanel.add(btn_quit);
		
		this.setVisible(true);
	}


	public JTextField getTxt_username() {
		return txt_username;
	}

	public void setTxt_username(JTextField txt_username) {
		this.txt_username = txt_username;
	}

	public JTextField getTxt_password() {
		return txt_password;
	}

	public void setTxt_password(JPasswordField  txt_password) {
		this.txt_password = txt_password;
	}

	public JTextField getTxt_confirmPassword() {
		return txt_confirmPassword;
	}

	public void setTxt_confirmPassword(JPasswordField  txt_confirmPassword) {
		this.txt_confirmPassword = txt_confirmPassword;
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

	public JTextField getTxt_areacode() {
		return txt_areacode;
	}

	public void setTxt_areacode(JTextField txt_areacode) {
		this.txt_areacode = txt_areacode;
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
	
	public JButton getBtn_usernameValidate() {
		return btn_usernameValidate;
	}

	public void setBtn_usernameValidate(JButton btn_usernameValidate) {
		this.btn_usernameValidate = btn_usernameValidate;
	}

	public JButton getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(JButton btn_save) {
		this.btn_save = btn_save;
	}

	public JButton getBtn_return() {
		return btn_return;
	}

	public void setBtn_return(JButton btn_return) {
		this.btn_return = btn_return;
	}

	public JButton getBtn_quit() {
		return btn_quit;
	}

	public void setBtn_quit(JButton btn_quit) {
		this.btn_quit = btn_quit;
	}

}
