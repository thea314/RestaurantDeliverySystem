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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditRestaurantView extends JFrame{
	private JTextField txt_restoName;
	private JTextField txt_restoAddress;
	private JTextField txt_deliveryArea;
	private JComboBox combo_MonHrOpen;
	private JComboBox combo_MonMinOpen;
	private JComboBox combo_MonHrClose;
	private JComboBox combo_MonMinClose;
	private JComboBox combo_TuesHrOpen;
	private JComboBox combo_TuesMinOpen;
	private JComboBox combo_TuesHrClose;
	private JComboBox combo_TuesMinClose;
	private JComboBox combo_WedHrOpen;
	private JComboBox combo_WedMinOpen;
	private JComboBox combo_WedHrClose;
	private JComboBox combo_WedMinClose;
	private JComboBox combo_ThursHrOpen;
	private JComboBox combo_ThursMinOpen;
	private JComboBox combo_ThursHrClose;
	private JComboBox combo_ThursMinClose;
	private JComboBox combo_FriHrOpen;
	private JComboBox combo_FriMinOpen;
	private JComboBox combo_FriHrClose;
	private JComboBox combo_FriMinClose;
	private JComboBox combo_SatHrOpen;
	private JComboBox combo_SatMinOpen;
	private JComboBox combo_SatHrClose;
	private JComboBox combo_SatMinClose;
	private JComboBox combo_SunHrOpen;
	private JComboBox combo_SunMinOpen;
	private JComboBox combo_SunHrClose;
	private JComboBox combo_SunMinClose;
	private JButton btn_addDeliveryArea;
	private JButton btn_saveButton;
	private JButton btn_deleteDeliveryArea;
	private JButton btn_modifyAll;
	private JTextField txt_restaurantAreaCode;
	private JTextField txt_restaurantPhone1;
	private JTextField txt_restaurantPhone2;
	private JButton btn_cancel;
	private JTextArea txtA_deliveryArea;
	private JTable restoList;
	



	/**
	 * Create the application.
	 */
	public EditRestaurantView() {
		setTitle("Add New Restaurant");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//set combobox array for opening/closing hours
		String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] minutes = {"00", "30"};
	
		
		this.setBounds(100, 100, 800, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 784, 872);
		mainPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lbl_title = new JLabel();
		lbl_title.setBounds(58, 11, 453, 53);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/addRestaurant.png"));
		mainPanel.add(lbl_title);
		
		JLabel lbl_restoName = new JLabel("Restaurant Name:");
		lbl_restoName.setForeground(SystemColor.window);
		lbl_restoName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restoName.setBounds(58, 75, 147, 14);
		mainPanel.add(lbl_restoName);
		
		JLabel lbl_restoAddress = new JLabel("Restaurant Address:");
		lbl_restoAddress.setForeground(SystemColor.window);
		lbl_restoAddress.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restoAddress.setBounds(58, 111, 166, 14);
		mainPanel.add(lbl_restoAddress);
		
		txt_restoName = new JTextField();
		txt_restoName.setBounds(256, 75, 201, 20);
		mainPanel.add(txt_restoName);
		txt_restoName.setColumns(10);
		
		txt_restoAddress = new JTextField();
		txt_restoAddress.setBounds(256, 107, 201, 20);
		mainPanel.add(txt_restoAddress);
		txt_restoAddress.setColumns(10);
		
		JLabel lbl_openingTitle = new JLabel("Opening Time:");
		lbl_openingTitle.setForeground(SystemColor.window);
		lbl_openingTitle.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_openingTitle.setBounds(181, 173, 208, 30);
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
		
		combo_MonHrOpen = new JComboBox(hours);
		combo_MonHrOpen.setBounds(191, 239, 46, 22);
		mainPanel.add(combo_MonHrOpen);
		
		combo_MonMinOpen = new JComboBox(minutes);
		combo_MonMinOpen.setBounds(264, 239, 46, 22);
		mainPanel.add(combo_MonMinOpen);
		
		combo_MonHrClose = new JComboBox(hours);
		combo_MonHrClose.setBounds(359, 239, 46, 22);
		mainPanel.add(combo_MonHrClose);
		
		combo_MonMinClose = new JComboBox(minutes);
		combo_MonMinClose.setBounds(430, 239, 46, 22);
		mainPanel.add(combo_MonMinClose);
		
		combo_TuesHrOpen = new JComboBox(hours);
		combo_TuesHrOpen.setBounds(191, 274, 46, 22);
		mainPanel.add(combo_TuesHrOpen);
		
		combo_TuesMinOpen = new JComboBox(minutes);
		combo_TuesMinOpen.setBounds(264, 274, 46, 22);
		mainPanel.add(combo_TuesMinOpen);
		
		combo_TuesHrClose = new JComboBox(hours);
		combo_TuesHrClose.setBounds(359, 274, 46, 22);
		mainPanel.add(combo_TuesHrClose);
		
		combo_TuesMinClose = new JComboBox(minutes);
		combo_TuesMinClose.setBounds(430, 274, 46, 22);
		mainPanel.add(combo_TuesMinClose);
		
		combo_WedHrOpen = new JComboBox(hours);
		combo_WedHrOpen.setBounds(191, 314, 46, 22);
		mainPanel.add(combo_WedHrOpen);
		
		combo_WedMinOpen = new JComboBox(minutes);
		combo_WedMinOpen.setBounds(264, 314, 46, 22);
		mainPanel.add(combo_WedMinOpen);
		
		combo_WedHrClose = new JComboBox(hours);
		combo_WedHrClose.setBounds(359, 314, 46, 22);
		mainPanel.add(combo_WedHrClose);
		
		combo_WedMinClose = new JComboBox(minutes);
		combo_WedMinClose.setBounds(430, 314, 46, 22);
		mainPanel.add(combo_WedMinClose);
		
		combo_ThursHrOpen = new JComboBox(hours);
		combo_ThursHrOpen.setBounds(191, 353, 46, 22);
		mainPanel.add(combo_ThursHrOpen);
		
		combo_ThursMinOpen = new JComboBox(minutes);
		combo_ThursMinOpen.setBounds(264, 353, 46, 22);
		mainPanel.add(combo_ThursMinOpen);
		
		combo_ThursHrClose = new JComboBox(hours);
		combo_ThursHrClose.setBounds(359, 353, 46, 22);
		mainPanel.add(combo_ThursHrClose);
		
		combo_ThursMinClose = new JComboBox(minutes);
		combo_ThursMinClose.setBounds(430, 353, 46, 22);
		mainPanel.add(combo_ThursMinClose);
		
		combo_FriHrOpen = new JComboBox(hours);
		combo_FriHrOpen.setBounds(191, 392, 46, 22);
		mainPanel.add(combo_FriHrOpen);
		
		combo_FriMinOpen = new JComboBox(minutes);
		combo_FriMinOpen.setBounds(264, 392, 46, 22);
		mainPanel.add(combo_FriMinOpen);
		
		combo_FriHrClose = new JComboBox(hours);
		combo_FriHrClose.setBounds(360, 392, 46, 22);
		mainPanel.add(combo_FriHrClose);
		
		combo_FriMinClose = new JComboBox(minutes);
		combo_FriMinClose.setBounds(430, 392, 46, 22);
		mainPanel.add(combo_FriMinClose);
		
		combo_SatHrOpen = new JComboBox(hours);
		combo_SatHrOpen.setBounds(191, 426, 46, 22);
		mainPanel.add(combo_SatHrOpen);
		
		combo_SatMinOpen = new JComboBox(minutes);
		combo_SatMinOpen.setBounds(264, 426, 46, 22);
		mainPanel.add(combo_SatMinOpen);
		
		combo_SatHrClose = new JComboBox(hours);
		combo_SatHrClose.setBounds(360, 426, 46, 22);
		mainPanel.add(combo_SatHrClose);
		
		combo_SatMinClose = new JComboBox(minutes);
		combo_SatMinClose.setBounds(430, 426, 46, 22);
		mainPanel.add(combo_SatMinClose);
		
		combo_SunHrOpen = new JComboBox(hours);
		combo_SunHrOpen.setBounds(191, 462, 46, 22);
		mainPanel.add(combo_SunHrOpen);
		
		combo_SunMinOpen = new JComboBox(minutes);
		combo_SunMinOpen.setBounds(264, 462, 46, 22);
		mainPanel.add(combo_SunMinOpen);
		
		combo_SunHrClose = new JComboBox(hours);
		combo_SunHrClose.setBounds(359, 462, 46, 22);
		mainPanel.add(combo_SunHrClose);
		
		combo_SunMinClose = new JComboBox(minutes);
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
		
		btn_modifyAll = new JButton("Modify All Times At Once");
		btn_modifyAll.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_modifyAll.setBackground(new Color(244, 164, 96));
		btn_modifyAll.setBounds(79, 508, 397, 36);
		mainPanel.add(btn_modifyAll);
		
		JLabel lbl_deliveryArea = new JLabel("Delivery Area:");
		lbl_deliveryArea.setForeground(Color.WHITE);
		lbl_deliveryArea.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_deliveryArea.setBounds(197, 555, 208, 30);
		mainPanel.add(lbl_deliveryArea);
		
		txtA_deliveryArea = new JTextArea();
		txtA_deliveryArea.setBounds(97, 588, 362, 107);
		txtA_deliveryArea.setEditable(false);
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
		
		btn_addDeliveryArea = new JButton("Add Delivery Area");
		btn_addDeliveryArea.setBackground(new Color(244, 164, 96));
		btn_addDeliveryArea.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_addDeliveryArea.setBounds(327, 706, 185, 36);
		mainPanel.add(btn_addDeliveryArea);
		
		btn_deleteDeliveryArea = new JButton("Delete Delivery Area");
		btn_deleteDeliveryArea.setBackground(new Color(244, 164, 96));
		btn_deleteDeliveryArea.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_deleteDeliveryArea.setBounds(293, 753, 218, 30);
		mainPanel.add(btn_deleteDeliveryArea);
		
		btn_saveButton = new JButton("Save");
		btn_saveButton.setBackground(new Color(244, 164, 96));
		btn_saveButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_saveButton.setBounds(150, 816, 104, 30);
		btn_saveButton.setEnabled(false);
		mainPanel.add(btn_saveButton);
		
		JLabel lbl_restoPhone = new JLabel("Telephone Number:");
		lbl_restoPhone.setForeground(SystemColor.window);
		lbl_restoPhone.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_restoPhone.setBounds(58, 148, 147, 14);
		mainPanel.add(lbl_restoPhone);
		
		JLabel lbl_bracketLeading = new JLabel("(");
		lbl_bracketLeading.setForeground(SystemColor.window);
		lbl_bracketLeading.setFont(new Font("Consolas", Font.PLAIN, 16));
		lbl_bracketLeading.setBounds(238, 129, 16, 42);
		mainPanel.add(lbl_bracketLeading);
		
		JLabel lbl_bracketTrailing = new JLabel(")");
		lbl_bracketTrailing.setForeground(SystemColor.window);
		lbl_bracketTrailing.setFont(new Font("Consolas", Font.PLAIN, 16));
		lbl_bracketTrailing.setBounds(293, 138, 16, 24);
		mainPanel.add(lbl_bracketTrailing);
		
		JLabel lbl_dash = new JLabel("-");
		lbl_dash.setForeground(SystemColor.window);
		lbl_dash.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_dash.setBounds(351, 138, 16, 14);
		mainPanel.add(lbl_dash);
		
		txt_restaurantAreaCode = new JTextField();
		txt_restaurantAreaCode.setBounds(256, 138, 31, 20);
		mainPanel.add(txt_restaurantAreaCode);
		txt_restaurantAreaCode.setColumns(10);
		
		txt_restaurantPhone1 = new JTextField();
		txt_restaurantPhone1.setColumns(10);
		txt_restaurantPhone1.setBounds(303, 138, 38, 20);
		mainPanel.add(txt_restaurantPhone1);
		
		txt_restaurantPhone2 = new JTextField();
		txt_restaurantPhone2.setColumns(10);
		txt_restaurantPhone2.setBounds(374, 138, 83, 20);
		mainPanel.add(txt_restaurantPhone2);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(368, 816, 89, 30);
		mainPanel.add(btn_cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(543, 123, 185, 462);
		mainPanel.add(scrollPane);
		
		restoList = new JTable();
		scrollPane.setColumnHeaderView(restoList);
		
		this.setVisible(true);
	}
	
	public JTextField getTxt_restoName() {
		return txt_restoName;
	}

	public void setTxt_restoName(JTextField txt_restoName) {
		this.txt_restoName = txt_restoName;
	}

	public JTextField getTxt_restoAddress() {
		return txt_restoAddress;
	}

	public void setTxt_restoAddress(JTextField txt_restoAddress) {
		this.txt_restoAddress = txt_restoAddress;
	}

	public JTextField getTxt_deliveryArea() {
		return txt_deliveryArea;
	}

	public void setTxt_deliveryArea(JTextField txt_deliveryArea) {
		this.txt_deliveryArea = txt_deliveryArea;
	}


	public JComboBox getCombo_MonHrOpen() {
		return combo_MonHrOpen;
	}

	public void setCombo_MonHrOpen(JComboBox combo_MonHrOpen) {
		this.combo_MonHrOpen = combo_MonHrOpen;
	}

	public JComboBox getCombo_MonMinOpen() {
		return combo_MonMinOpen;
	}

	public void setCombo_MonMinOpen(JComboBox combo_MonMinOpen) {
		this.combo_MonMinOpen = combo_MonMinOpen;
	}

	public JComboBox getCombo_MonHrClose() {
		return combo_MonHrClose;
	}

	public void setCombo_MonHrClose(JComboBox combo_MonHrClose) {
		this.combo_MonHrClose = combo_MonHrClose;
	}

	public JComboBox getCombo_MonMinClose() {
		return combo_MonMinClose;
	}

	public void setCombo_MonMinClose(JComboBox combo_MonMinClose) {
		this.combo_MonMinClose = combo_MonMinClose;
	}

	public JComboBox getCombo_TuesHrOpen() {
		return combo_TuesHrOpen;
	}

	public void setCombo_TuesHrOpen(JComboBox combo_TuesHrOpen) {
		this.combo_TuesHrOpen = combo_TuesHrOpen;
	}

	public JComboBox getCombo_TuesMinOpen() {
		return combo_TuesMinOpen;
	}

	public void setCombo_TuesMinOpen(JComboBox combo_TuesMinOpen) {
		this.combo_TuesMinOpen = combo_TuesMinOpen;
	}

	public JComboBox getCombo_TuesHrClose() {
		return combo_TuesHrClose;
	}

	public void setCombo_TuesHrClose(JComboBox combo_TuesHrClose) {
		this.combo_TuesHrClose = combo_TuesHrClose;
	}

	public JComboBox getCombo_TuesMinClose() {
		return combo_TuesMinClose;
	}

	public void setCombo_TuesMinClose(JComboBox combo_TuesMinClose) {
		this.combo_TuesMinClose = combo_TuesMinClose;
	}

	public JComboBox getCombo_WedHrOpen() {
		return combo_WedHrOpen;
	}

	public void setCombo_WedHrOpen(JComboBox combo_WedHrOpen) {
		this.combo_WedHrOpen = combo_WedHrOpen;
	}

	public JComboBox getCombo_WedMinOpen() {
		return combo_WedMinOpen;
	}

	public void setCombo_WedMinOpen(JComboBox combo_WedMinOpen) {
		this.combo_WedMinOpen = combo_WedMinOpen;
	}

	public JComboBox getCombo_WedHrClose() {
		return combo_WedHrClose;
	}

	public void setCombo_WedHrClose(JComboBox combo_WedHrClose) {
		this.combo_WedHrClose = combo_WedHrClose;
	}

	public JComboBox getCombo_WedMinClose() {
		return combo_WedMinClose;
	}

	public void setCombo_WedMinClose(JComboBox combo_WedMinClose) {
		this.combo_WedMinClose = combo_WedMinClose;
	}

	public JComboBox getCombo_ThursHrOpen() {
		return combo_ThursHrOpen;
	}

	public void setCombo_ThursHrOpen(JComboBox combo_ThursHrOpen) {
		this.combo_ThursHrOpen = combo_ThursHrOpen;
	}

	public JComboBox getCombo_ThursMinOpen() {
		return combo_ThursMinOpen;
	}

	public void setCombo_ThursMinOpen(JComboBox combo_ThursMinOpen) {
		this.combo_ThursMinOpen = combo_ThursMinOpen;
	}

	public JComboBox getCombo_ThursHrClose() {
		return combo_ThursHrClose;
	}

	public void setCombo_ThursHrClose(JComboBox combo_ThursHrClose) {
		this.combo_ThursHrClose = combo_ThursHrClose;
	}

	public JComboBox getCombo_ThursMinClose() {
		return combo_ThursMinClose;
	}

	public void setCombo_ThursMinClose(JComboBox combo_ThursMinClose) {
		this.combo_ThursMinClose = combo_ThursMinClose;
	}

	public JComboBox getCombo_FriHrOpen() {
		return combo_FriHrOpen;
	}

	public void setCombo_FriHrOpen(JComboBox combo_FriHrOpen) {
		this.combo_FriHrOpen = combo_FriHrOpen;
	}

	public JComboBox getCombo_FriMinOpen() {
		return combo_FriMinOpen;
	}

	public void setCombo_FriMinOpen(JComboBox combo_FriMinOpen) {
		this.combo_FriMinOpen = combo_FriMinOpen;
	}

	public JComboBox getCombo_FriHrClose() {
		return combo_FriHrClose;
	}

	public void setCombo_FriHrClose(JComboBox combo_FriHrClose) {
		this.combo_FriHrClose = combo_FriHrClose;
	}

	public JComboBox getCombo_FriMinClose() {
		return combo_FriMinClose;
	}

	public void setCombo_FriMinClose(JComboBox combo_FriMinClose) {
		this.combo_FriMinClose = combo_FriMinClose;
	}

	public JComboBox getCombo_SatHrOpen() {
		return combo_SatHrOpen;
	}

	public void setCombo_SatHrOpen(JComboBox combo_SatHrOpen) {
		this.combo_SatHrOpen = combo_SatHrOpen;
	}

	public JComboBox getCombo_SatMinOpen() {
		return combo_SatMinOpen;
	}

	public void setCombo_SatMinOpen(JComboBox combo_SatMinOpen) {
		this.combo_SatMinOpen = combo_SatMinOpen;
	}

	public JComboBox getCombo_SatHrClose() {
		return combo_SatHrClose;
	}

	public void setCombo_SatHrClose(JComboBox combo_SatHrClose) {
		this.combo_SatHrClose = combo_SatHrClose;
	}

	public JComboBox getCombo_SatMinClose() {
		return combo_SatMinClose;
	}

	public void setCombo_SatMinClose(JComboBox combo_SatMinClose) {
		this.combo_SatMinClose = combo_SatMinClose;
	}

	public JComboBox getCombo_SunHrOpen() {
		return combo_SunHrOpen;
	}

	public void setCombo_SunHrOpen(JComboBox combo_SunHrOpen) {
		this.combo_SunHrOpen = combo_SunHrOpen;
	}

	public JComboBox getCombo_SunMinOpen() {
		return combo_SunMinOpen;
	}

	public void setCombo_SunMinOpen(JComboBox combo_SunMinOpen) {
		this.combo_SunMinOpen = combo_SunMinOpen;
	}

	public JComboBox getCombo_SunHrClose() {
		return combo_SunHrClose;
	}

	public void setCombo_SunHrClose(JComboBox combo_SunHrClose) {
		this.combo_SunHrClose = combo_SunHrClose;
	}

	public JComboBox getCombo_SunMinClose() {
		return combo_SunMinClose;
	}

	public void setCombo_SunMinClose(JComboBox combo_HumMinClose) {
		this.combo_SunMinClose = combo_HumMinClose;
	}


	public JButton getBtn_addDeliveryArea() {
		return btn_addDeliveryArea;
	}

	public void setBtn_addDeliveryArea(JButton btn_addDeliveryArea) {
		this.btn_addDeliveryArea = btn_addDeliveryArea;
	}


	public JButton getBtn_saveButton() {
		return btn_saveButton;
	}

	public void setBtn_saveButton(JButton btn_saveButton) {
		this.btn_saveButton = btn_saveButton;
	}

	public JButton getBtn_deleteDeliveryArea() {
		return btn_deleteDeliveryArea;
	}

	public void setBtn_deleteDeliveryArea(JButton btn_deleteDeliveryArea) {
		this.btn_deleteDeliveryArea = btn_deleteDeliveryArea;
	}
	
	public JButton getBtn_modifyAll() {
		return btn_modifyAll;
	}

	public void setBtn_modifyAll(JButton btn_modifyAll) {
		this.btn_modifyAll = btn_modifyAll;
	}

	public JTextField getTxt_restaurantAreaCode() {
		return txt_restaurantAreaCode;
	}

	public void setTxt_restaurantAreaCode(JTextField txt_restaurantAreaCode) {
		this.txt_restaurantAreaCode = txt_restaurantAreaCode;
	}

	public JTextField getTxt_restaurantPhone1() {
		return txt_restaurantPhone1;
	}

	public void setTxt_restaurantPhone1(JTextField txt_restaurantPhone1) {
		this.txt_restaurantPhone1 = txt_restaurantPhone1;
	}

	public JTextField getTxt_restaurantPhone2() {
		return txt_restaurantPhone2;
	}

	public void setTxt_restaurantPhone2(JTextField txt_restaurantPhone2) {
		this.txt_restaurantPhone2 = txt_restaurantPhone2;
	}
	
	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}
	
	public JTextArea getTxtA_deliveryArea() {
		return txtA_deliveryArea;
	}

	public void setTxtA_deliveryArea(JTextArea txtA_deliveryArea) {
		this.txtA_deliveryArea = txtA_deliveryArea;
	}
}
