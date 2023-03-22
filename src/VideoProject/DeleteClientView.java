package VideoProject;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteClientView extends JFrame {
	private JTextField txt_username;
	private JTextField txt_lastName;
	private JTextField txt_firstName;
	private JTextField txt_address;
	private JTextField txt_email;
	private JTextField txt_areaCode;
	private JTextField txt_phone1;
	private JTextField txt_phone2;



	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DeleteClientView window = new DeleteClientView();
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
	public DeleteClientView() {
		setTitle("Delete Client");
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 469, 381);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(0, 0, 453, 347);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(51, 11, 361, 50);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/deleteClient.png"));
		mainPanel.add(lbl_title);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setForeground(UIManager.getColor("Button.highlight"));
		lbl_username.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_username.setBounds(51, 117, 81, 14);
		mainPanel.add(lbl_username);
		
		JLabel lbl_lastName = new JLabel("Last Name:");
		lbl_lastName.setForeground(UIManager.getColor("Button.highlight"));
		lbl_lastName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_lastName.setBounds(51, 142, 81, 14);
		mainPanel.add(lbl_lastName);
		
		JLabel lbl_firstName = new JLabel("First Name:");
		lbl_firstName.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_firstName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_firstName.setBounds(51, 167, 97, 14);
		mainPanel.add(lbl_firstName);
		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_address.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_address.setBounds(51, 192, 81, 14);
		mainPanel.add(lbl_address);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_email.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_email.setBounds(51, 217, 81, 14);
		mainPanel.add(lbl_email);
		
		JLabel lbl_phone = new JLabel("Phone number:");
		lbl_phone.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_phone.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_phone.setBounds(51, 242, 114, 14);
		mainPanel.add(lbl_phone);
		
		JLabel lbl_startBracket = new JLabel("(");
		lbl_startBracket.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_startBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_startBracket.setBounds(175, 242, 8, 14);
		mainPanel.add(lbl_startBracket);
		
		JLabel lbl_closeBracket = new JLabel(")");
		lbl_closeBracket.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_closeBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_closeBracket.setBounds(214, 242, 19, 14);
		mainPanel.add(lbl_closeBracket);
		
		JLabel lbl_dash = new JLabel("-");
		lbl_dash.setForeground(UIManager.getColor("Button.disabledShadow"));
		lbl_dash.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_dash.setBounds(263, 242, 8, 14);
		mainPanel.add(lbl_dash);
		
		txt_username = new JTextField();
		txt_username.setBounds(176, 111, 143, 20);
		txt_username.setEnabled(false);
		mainPanel.add(txt_username);
		txt_username.setColumns(10);
		
		txt_lastName = new JTextField();
		txt_lastName.setBounds(176, 138, 143, 20);
		txt_lastName.setEnabled(false);
		mainPanel.add(txt_lastName);
		txt_lastName.setColumns(10);
		
		txt_firstName = new JTextField();
		txt_firstName.setBounds(176, 163, 143, 20);
		txt_firstName.setEnabled(false);
		mainPanel.add(txt_firstName);
		txt_firstName.setColumns(10);
		
		txt_address = new JTextField();
		txt_address.setBounds(176, 188, 143, 20);
		txt_address.setEnabled(false);
		mainPanel.add(txt_address);
		txt_address.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(176, 213, 143, 20);
		txt_email.setEnabled(false);
		mainPanel.add(txt_email);
		txt_email.setColumns(10);
		
		txt_areaCode = new JTextField();
		txt_areaCode.setBounds(182, 238, 33, 20);
		txt_areaCode.setEnabled(false);
		mainPanel.add(txt_areaCode);
		txt_areaCode.setColumns(10);
		
		txt_phone1 = new JTextField();
		txt_phone1.setColumns(10);
		txt_phone1.setBounds(224, 238, 33, 20);
		txt_phone1.setEnabled(false);
		mainPanel.add(txt_phone1);
		
		txt_phone2 = new JTextField();
		txt_phone2.setBounds(276, 238, 43, 20);
		txt_phone2.setEnabled(false);
		mainPanel.add(txt_phone2);
		txt_phone2.setColumns(10);
		
		JButton btnh_delete = new JButton("Close");
		btnh_delete.setFont(new Font("Consolas", Font.BOLD, 16));
		btnh_delete.setBackground(new Color(244, 164, 96));
		btnh_delete.setBounds(106, 281, 89, 35);
		mainPanel.add(btnh_delete);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(263, 281, 89, 35);
		mainPanel.add(btn_cancel);
	}

	public JTextField getTxt_username() {
		return txt_username;
	}

	public void setTxt_username(JTextField txt_username) {
		this.txt_username = txt_username;
	}

	public JTextField getTxt_lastName() {
		return txt_lastName;
	}

	public void setTxt_lastName(JTextField txt_lastName) {
		this.txt_lastName = txt_lastName;
	}

	public JTextField getTxt_firstName() {
		return txt_firstName;
	}

	public void setTxt_firstName(JTextField txt_firstName) {
		this.txt_firstName = txt_firstName;
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
}
