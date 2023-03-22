package VideoProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CreateRestaurantView extends JFrame{
	private JTextField txt_restoName;
	private JTextField textField_1;
	private JTextField txt_deliveryArea;
	private JTextField txt_managerUsername;
	private JTextField textField;
	private JTextField txt_restaraunteurUsername;
	private JTextField txt_restauranteurPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateRestaurantView window = new CreateRestaurantView();
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
	public CreateRestaurantView() {
		setTitle("Add New Restaurant");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 567, 1059);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 11, 551, 1009);
		mainPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lbl_title = new JLabel();
		lbl_title.setBounds(58, 29, 453, 53);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/deleteClient.png"));
		mainPanel.add(lbl_title);
		
		JLabel lbl_restoName = new JLabel("Restaurant Name:");
		lbl_restoName.setForeground(SystemColor.window);
		lbl_restoName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restoName.setBounds(58, 115, 147, 14);
		mainPanel.add(lbl_restoName);
		
		JLabel lbl_restoAddress = new JLabel("Restaurant Address:");
		lbl_restoAddress.setForeground(SystemColor.window);
		lbl_restoAddress.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restoAddress.setBounds(58, 148, 166, 14);
		mainPanel.add(lbl_restoAddress);
		
		txt_restoName = new JTextField();
		txt_restoName.setBounds(256, 111, 201, 20);
		mainPanel.add(txt_restoName);
		txt_restoName.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 144, 201, 20);
		mainPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lbl_openingTitle = new JLabel("Opening Time:");
		lbl_openingTitle.setForeground(SystemColor.window);
		lbl_openingTitle.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_openingTitle.setBounds(181, 178, 208, 30);
		mainPanel.add(lbl_openingTitle);
		
		JLabel lbl_day_title = new JLabel("Day:");
		lbl_day_title.setForeground(SystemColor.activeCaption);
		lbl_day_title.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title.setBounds(79, 214, 46, 14);
		mainPanel.add(lbl_day_title);
		
		JLabel lbl_opening = new JLabel("Opening Time:");
		lbl_opening.setForeground(SystemColor.activeCaption);
		lbl_opening.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_opening.setBounds(181, 214, 129, 14);
		mainPanel.add(lbl_opening);
		
		JLabel lbl_closing = new JLabel("Closing Time:");
		lbl_closing.setForeground(SystemColor.activeCaption);
		lbl_closing.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_closing.setBounds(360, 214, 116, 14);
		mainPanel.add(lbl_closing);
		
		JLabel lbl_day_title_1 = new JLabel("Monday:");
		lbl_day_title_1.setForeground(Color.WHITE);
		lbl_day_title_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_1.setBounds(79, 239, 65, 14);
		mainPanel.add(lbl_day_title_1);
		
		JLabel lbl_day_title_2 = new JLabel("Tuesday:");
		lbl_day_title_2.setForeground(Color.WHITE);
		lbl_day_title_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_2.setBounds(79, 279, 65, 14);
		mainPanel.add(lbl_day_title_2);
		
		JLabel lbl_day_title_3 = new JLabel("Wednesday:");
		lbl_day_title_3.setForeground(Color.WHITE);
		lbl_day_title_3.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_3.setBounds(79, 319, 80, 14);
		mainPanel.add(lbl_day_title_3);
		
		JLabel lbl_day_title_4 = new JLabel("Thursday:");
		lbl_day_title_4.setForeground(Color.WHITE);
		lbl_day_title_4.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_4.setBounds(79, 358, 80, 14);
		mainPanel.add(lbl_day_title_4);
		
		JLabel lbl_day_title_5 = new JLabel("Friday:");
		lbl_day_title_5.setForeground(Color.WHITE);
		lbl_day_title_5.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_5.setBounds(79, 397, 80, 14);
		mainPanel.add(lbl_day_title_5);
		
		JLabel lbl_day_title_6 = new JLabel("Saturday:");
		lbl_day_title_6.setForeground(Color.WHITE);
		lbl_day_title_6.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_6.setBounds(79, 431, 80, 14);
		mainPanel.add(lbl_day_title_6);
		
		JLabel lbl_day_title_7 = new JLabel("Sunday:");
		lbl_day_title_7.setForeground(Color.WHITE);
		lbl_day_title_7.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_day_title_7.setBounds(79, 467, 65, 14);
		mainPanel.add(lbl_day_title_7);
		
		JComboBox combo_MonHrOpen = new JComboBox();
		combo_MonHrOpen.setBounds(191, 239, 46, 22);
		mainPanel.add(combo_MonHrOpen);
		
		JComboBox combo_MonMinOpen = new JComboBox();
		combo_MonMinOpen.setBounds(264, 239, 46, 22);
		mainPanel.add(combo_MonMinOpen);
		
		JComboBox combo_MonHrClose = new JComboBox();
		combo_MonHrClose.setBounds(359, 239, 46, 22);
		mainPanel.add(combo_MonHrClose);
		
		JComboBox combo_MonMinClose = new JComboBox();
		combo_MonMinClose.setBounds(430, 239, 46, 22);
		mainPanel.add(combo_MonMinClose);
		
		JComboBox combo_TuesHrOpen = new JComboBox();
		combo_TuesHrOpen.setBounds(191, 274, 46, 22);
		mainPanel.add(combo_TuesHrOpen);
		
		JComboBox combo_TuesMinOpen = new JComboBox();
		combo_TuesMinOpen.setBounds(264, 274, 46, 22);
		mainPanel.add(combo_TuesMinOpen);
		
		JComboBox combo_TuesHrClose = new JComboBox();
		combo_TuesHrClose.setBounds(359, 274, 46, 22);
		mainPanel.add(combo_TuesHrClose);
		
		JComboBox combo_TuesMinClose = new JComboBox();
		combo_TuesMinClose.setBounds(430, 274, 46, 22);
		mainPanel.add(combo_TuesMinClose);
		
		JComboBox combo_WedHrOpen = new JComboBox();
		combo_WedHrOpen.setBounds(191, 314, 46, 22);
		mainPanel.add(combo_WedHrOpen);
		
		JComboBox combo_WedMinOpen = new JComboBox();
		combo_WedMinOpen.setBounds(264, 314, 46, 22);
		mainPanel.add(combo_WedMinOpen);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(264, 314, 46, 22);
		mainPanel.add(comboBox_10);
		
		JComboBox combo_WedHrClose = new JComboBox();
		combo_WedHrClose.setBounds(359, 314, 46, 22);
		mainPanel.add(combo_WedHrClose);
		
		JComboBox combo_WedMinClose = new JComboBox();
		combo_WedMinClose.setBounds(430, 314, 46, 22);
		mainPanel.add(combo_WedMinClose);
		
		JComboBox combo_ThursHrOpen = new JComboBox();
		combo_ThursHrOpen.setBounds(191, 353, 46, 22);
		mainPanel.add(combo_ThursHrOpen);
		
		JComboBox combo_ThursMinOpen = new JComboBox();
		combo_ThursMinOpen.setBounds(264, 353, 46, 22);
		mainPanel.add(combo_ThursMinOpen);
		
		JComboBox combo_ThursHrClose = new JComboBox();
		combo_ThursHrClose.setBounds(359, 353, 46, 22);
		mainPanel.add(combo_ThursHrClose);
		
		JComboBox combo_ThursMinClose = new JComboBox();
		combo_ThursMinClose.setBounds(430, 353, 46, 22);
		mainPanel.add(combo_ThursMinClose);
		
		JComboBox combo_FriHrOpen = new JComboBox();
		combo_FriHrOpen.setBounds(191, 392, 46, 22);
		mainPanel.add(combo_FriHrOpen);
		
		JComboBox combo_FriMinOpen = new JComboBox();
		combo_FriMinOpen.setBounds(264, 392, 46, 22);
		mainPanel.add(combo_FriMinOpen);
		
		JComboBox combo_FridayHrClose = new JComboBox();
		combo_FridayHrClose.setBounds(360, 392, 46, 22);
		mainPanel.add(combo_FridayHrClose);
		
		JComboBox combo_FridayMinClose = new JComboBox();
		combo_FridayMinClose.setBounds(430, 392, 46, 22);
		mainPanel.add(combo_FridayMinClose);
		
		JComboBox combo_SatHrOpen = new JComboBox();
		combo_SatHrOpen.setBounds(191, 426, 46, 22);
		mainPanel.add(combo_SatHrOpen);
		
		JComboBox combo_SatMinOpen = new JComboBox();
		combo_SatMinOpen.setBounds(264, 426, 46, 22);
		mainPanel.add(combo_SatMinOpen);
		
		JComboBox combo_SatHrClose = new JComboBox();
		combo_SatHrClose.setBounds(360, 426, 46, 22);
		mainPanel.add(combo_SatHrClose);
		
		JComboBox combo_SatMinClose = new JComboBox();
		combo_SatMinClose.setBounds(430, 426, 46, 22);
		mainPanel.add(combo_SatMinClose);
		
		JComboBox combo_SunHrOpen = new JComboBox();
		combo_SunHrOpen.setBounds(191, 462, 46, 22);
		mainPanel.add(combo_SunHrOpen);
		
		JComboBox combo_SunMinOpen = new JComboBox();
		combo_SunMinOpen.setBounds(264, 462, 46, 22);
		mainPanel.add(combo_SunMinOpen);
		
		JComboBox combo_SunHrClose = new JComboBox();
		combo_SunHrClose.setBounds(359, 462, 46, 22);
		mainPanel.add(combo_SunHrClose);
		
		JComboBox combo_SunMinClose = new JComboBox();
		combo_SunMinClose.setBounds(430, 462, 46, 22);
		mainPanel.add(combo_SunMinClose);
		
		JLabel lbl_h = new JLabel("h");
		lbl_h.setForeground(Color.WHITE);
		lbl_h.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h.setBounds(238, 243, 16, 14);
		mainPanel.add(lbl_h);
		
		JLabel lbl_h_1 = new JLabel("h");
		lbl_h_1.setForeground(Color.WHITE);
		lbl_h_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_1.setBounds(238, 278, 16, 14);
		mainPanel.add(lbl_h_1);
		
		JLabel lbl_h_2 = new JLabel("h");
		lbl_h_2.setForeground(Color.WHITE);
		lbl_h_2.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_2.setBounds(238, 318, 16, 14);
		mainPanel.add(lbl_h_2);
		
		JLabel lbl_h_3 = new JLabel("h");
		lbl_h_3.setForeground(Color.WHITE);
		lbl_h_3.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_3.setBounds(238, 357, 16, 14);
		mainPanel.add(lbl_h_3);
		
		JLabel lbl_h_4 = new JLabel("h");
		lbl_h_4.setForeground(Color.WHITE);
		lbl_h_4.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_4.setBounds(238, 396, 16, 14);
		mainPanel.add(lbl_h_4);
		
		JLabel lbl_h_5 = new JLabel("h");
		lbl_h_5.setForeground(Color.WHITE);
		lbl_h_5.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_5.setBounds(238, 430, 16, 14);
		mainPanel.add(lbl_h_5);
		
		JLabel lbl_h_6 = new JLabel("h");
		lbl_h_6.setForeground(Color.WHITE);
		lbl_h_6.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_6.setBounds(238, 466, 16, 14);
		mainPanel.add(lbl_h_6);
		
		JLabel lbl_h_7 = new JLabel("h");
		lbl_h_7.setForeground(Color.WHITE);
		lbl_h_7.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_7.setBounds(415, 244, 16, 14);
		mainPanel.add(lbl_h_7);
		
		JLabel lbl_h_8 = new JLabel("h");
		lbl_h_8.setForeground(Color.WHITE);
		lbl_h_8.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_8.setBounds(415, 279, 16, 14);
		mainPanel.add(lbl_h_8);
		
		JLabel lbl_h_9 = new JLabel("h");
		lbl_h_9.setForeground(Color.WHITE);
		lbl_h_9.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_9.setBounds(415, 319, 16, 14);
		mainPanel.add(lbl_h_9);
		
		JLabel lbl_h_10 = new JLabel("h");
		lbl_h_10.setForeground(Color.WHITE);
		lbl_h_10.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_10.setBounds(414, 358, 16, 14);
		mainPanel.add(lbl_h_10);
		
		JLabel lbl_h_11 = new JLabel("h");
		lbl_h_11.setForeground(Color.WHITE);
		lbl_h_11.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_11.setBounds(414, 397, 16, 14);
		mainPanel.add(lbl_h_11);
		
		JLabel lbl_h_12 = new JLabel("h");
		lbl_h_12.setForeground(Color.WHITE);
		lbl_h_12.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_12.setBounds(414, 430, 16, 14);
		mainPanel.add(lbl_h_12);
		
		JLabel lbl_h_13 = new JLabel("h");
		lbl_h_13.setForeground(Color.WHITE);
		lbl_h_13.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_h_13.setBounds(415, 466, 16, 14);
		mainPanel.add(lbl_h_13);
		
		JButton btn_modifyAll = new JButton("Modify All Times At Once");
		btn_modifyAll.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_modifyAll.setBackground(new Color(244, 164, 96));
		btn_modifyAll.setBounds(79, 508, 397, 36);
		mainPanel.add(btn_modifyAll);
		
		JLabel lbl_deliveryArea = new JLabel("Delivery Area:");
		lbl_deliveryArea.setForeground(Color.WHITE);
		lbl_deliveryArea.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_deliveryArea.setBounds(197, 555, 208, 30);
		mainPanel.add(lbl_deliveryArea);
		
		JTextArea txtA_deliveryArea = new JTextArea();
		txtA_deliveryArea.setBounds(97, 588, 362, 107);
		mainPanel.add(txtA_deliveryArea);
		
		JLabel lbl_deliveryAreaTitle = new JLabel("Delivery Area:");
		lbl_deliveryAreaTitle.setForeground(SystemColor.window);
		lbl_deliveryAreaTitle.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_deliveryAreaTitle.setBounds(98, 714, 126, 14);
		mainPanel.add(lbl_deliveryAreaTitle);
		
		txt_deliveryArea = new JTextField();
		txt_deliveryArea.setBounds(220, 710, 86, 20);
		mainPanel.add(txt_deliveryArea);
		txt_deliveryArea.setColumns(10);
		
		JButton btn_addDeliveryArea = new JButton("Add Delivery Area");
		btn_addDeliveryArea.setBackground(new Color(244, 164, 96));
		btn_addDeliveryArea.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_addDeliveryArea.setBounds(327, 706, 185, 36);
		mainPanel.add(btn_addDeliveryArea);
		
		JButton btn_deleteDeliveryArea = new JButton("Delete Delivery Area");
		btn_deleteDeliveryArea.setBackground(new Color(244, 164, 96));
		btn_deleteDeliveryArea.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_deleteDeliveryArea.setBounds(293, 753, 218, 30);
		mainPanel.add(btn_deleteDeliveryArea);
		
		JButton btn_saveButton = new JButton("Save");
		btn_saveButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_saveButton.setBounds(430, 964, 104, 30);
		mainPanel.add(btn_saveButton);
		
		JLabel lbl_managerUsername = new JLabel("Manager Username:");
		lbl_managerUsername.setForeground(SystemColor.window);
		lbl_managerUsername.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_managerUsername.setBounds(79, 820, 158, 14);
		mainPanel.add(lbl_managerUsername);
		
		txt_managerUsername = new JTextField();
		txt_managerUsername.setBounds(238, 816, 129, 20);
		mainPanel.add(txt_managerUsername);
		txt_managerUsername.setColumns(10);
		
		JButton btn_validateManagerUsesname = new JButton("Validate");
		btn_validateManagerUsesname.setBackground(new Color(244, 164, 96));
		btn_validateManagerUsesname.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_validateManagerUsesname.setBounds(387, 808, 124, 30);
		mainPanel.add(btn_validateManagerUsesname);
		
		JLabel lbl_managerPassword = new JLabel("Manager Password:");
		lbl_managerPassword.setForeground(SystemColor.window);
		lbl_managerPassword.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_managerPassword.setBounds(79, 855, 145, 14);
		mainPanel.add(lbl_managerPassword);
		
		textField = new JTextField();
		textField.setBounds(238, 851, 129, 20);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_restuaranteurUsername = new JLabel("Restauranteur:");
		lbl_restuaranteurUsername.setForeground(SystemColor.window);
		lbl_restuaranteurUsername.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restuaranteurUsername.setBounds(79, 892, 145, 14);
		mainPanel.add(lbl_restuaranteurUsername);
		
		txt_restaraunteurUsername = new JTextField();
		txt_restaraunteurUsername.setBounds(238, 888, 129, 20);
		mainPanel.add(txt_restaraunteurUsername);
		txt_restaraunteurUsername.setColumns(10);
		
		JButton btn_validateManagerUsesname_1 = new JButton("Validate");
		btn_validateManagerUsesname_1.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_validateManagerUsesname_1.setBackground(new Color(244, 164, 96));
		btn_validateManagerUsesname_1.setBounds(387, 887, 124, 30);
		mainPanel.add(btn_validateManagerUsesname_1);
		
		JLabel lbl_restauranteurPassword = new JLabel("Rest. Password:");
		lbl_restauranteurPassword.setForeground(SystemColor.window);
		lbl_restauranteurPassword.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restauranteurPassword.setBounds(79, 932, 190, 14);
		mainPanel.add(lbl_restauranteurPassword);
		
		txt_restauranteurPassword = new JTextField();
		txt_restauranteurPassword.setBounds(238, 928, 129, 20);
		mainPanel.add(txt_restauranteurPassword);
		txt_restauranteurPassword.setColumns(10);
	}
}
