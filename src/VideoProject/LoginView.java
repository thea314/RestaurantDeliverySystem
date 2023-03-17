package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginView extends JFrame{

	private JTextField txt_username;
	private JTextField txt_password;
	
	JButton btn_connect = new JButton("Connect");
	JButton btn_newClient = new JButton("New Client");
	JButton btn_quit = new JButton("Quit");


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Login");
		this.setBounds(100, 100, 750, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 734, 461);
		mainPanel.setBackground(Color.DARK_GRAY);
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lbl_restoTitle = new JLabel("");
		lbl_restoTitle.setBounds(20, 11, 704, 46);
		lbl_restoTitle.setIcon(new javax.swing.ImageIcon("./Logos/resto.png"));
		mainPanel.add(lbl_restoTitle);
		
		JLabel lbl_PleaseLogin = new JLabel("Please Login:");
		lbl_PleaseLogin.setForeground(SystemColor.window);
		lbl_PleaseLogin.setFont(new Font("Consolas", Font.PLAIN, 20));
		lbl_PleaseLogin.setBounds(281, 108, 178, 31);
		mainPanel.add(lbl_PleaseLogin);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setForeground(SystemColor.window);
		lbl_username.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_username.setBounds(166, 214, 89, 23);
		mainPanel.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setForeground(SystemColor.window);
		lbl_password.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_password.setBounds(166, 267, 89, 14);
		mainPanel.add(lbl_password);
		
		txt_username = new JTextField();
		txt_username.setBounds(359, 214, 134, 20);
		mainPanel.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(359, 263, 134, 20);
		mainPanel.add(txt_password);
		
		
		btn_connect.setBackground(new Color(244, 164, 96));
		btn_connect.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_connect.setBounds(166, 379, 101, 31);
		mainPanel.add(btn_connect);
		
		
		btn_newClient.setBackground(new Color(244, 164, 96));
		btn_newClient.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_newClient.setBounds(319, 379, 124, 31);
		mainPanel.add(btn_newClient);
		
		
		btn_quit.setBackground(new Color(244, 164, 96));
		btn_quit.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_quit.setBounds(500, 379, 89, 31);
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

	public void setTxt_password(JTextField txt_password) {
		this.txt_password = txt_password;
	}
	
	public JButton getBtn_connect() {
		return btn_connect;
	}

	public void setBtn_connect(JButton btn_connect) {
		this.btn_connect = btn_connect;
	}

	public JButton getBtn_newClient() {
		return btn_newClient;
	}

	public void setBtn_newClient(JButton btn_newClient) {
		this.btn_newClient = btn_newClient;
	}

	public JButton getBtn_quit() {
		return btn_quit;
	}

	public void setBtn_quit(JButton btn_quit) {
		this.btn_quit = btn_quit;
	}

}
