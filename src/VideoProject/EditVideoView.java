package VideoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditVideoView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditVideoView window = new EditVideoView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public EditVideoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 801, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setForeground(Color.WHITE);
		mainPanel.setBorder(null);
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(0, 0, 824, 561);
		frame.getContentPane().add(mainPanel);
		
		JLabel lbl_NewClientLogo = new JLabel();
		lbl_NewClientLogo.setBounds(63, 11, 711, 60);
		mainPanel.add(lbl_NewClientLogo);
		
		JLabel lbl_usernameText = new JLabel("Username:");
		lbl_usernameText.setForeground(Color.WHITE);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(379, 141, 177, 20);
		mainPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(379, 180, 177, 20);
		mainPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(379, 217, 177, 20);
		mainPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(379, 257, 177, 20);
		mainPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(379, 297, 177, 20);
		mainPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(379, 340, 177, 20);
		mainPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(379, 381, 177, 20);
		mainPanel.add(textField_6);
		
		JLabel lbl_openBracket = new JLabel("(");
		lbl_openBracket.setForeground(Color.WHITE);
		lbl_openBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_openBracket.setBounds(379, 427, 14, 14);
		mainPanel.add(lbl_openBracket);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(389, 424, 38, 20);
		mainPanel.add(textField_7);
		
		JLabel lbl_closedBracket = new JLabel(")");
		lbl_closedBracket.setForeground(Color.WHITE);
		lbl_closedBracket.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_closedBracket.setBounds(426, 428, 14, 14);
		mainPanel.add(lbl_closedBracket);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(450, 424, 38, 20);
		mainPanel.add(textField_8);
		
		JLabel lbl_hyphenText = new JLabel("-");
		lbl_hyphenText.setForeground(Color.WHITE);
		lbl_hyphenText.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_hyphenText.setBounds(490, 428, 14, 14);
		mainPanel.add(lbl_hyphenText);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(503, 424, 53, 20);
		mainPanel.add(textField_9);
		
		JButton btn_save = new JButton("Save");
		btn_save.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_save.setEnabled(false);
		btn_save.setBackground(new Color(244, 164, 96));
		btn_save.setBounds(304, 493, 89, 36);
		mainPanel.add(btn_save);
		
		JButton btn_return = new JButton("Return");
		btn_return.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_return.setBackground(new Color(244, 164, 96));
		btn_return.setBounds(517, 493, 89, 36);
		mainPanel.add(btn_return);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(394, 37, 46, 14);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/editClient.png"));
		mainPanel.add(lbl_title);
	}
}
