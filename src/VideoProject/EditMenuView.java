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
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditMenuView extends JFrame {
	private JTable table_menuList;
	private JTable table_restaurant;
	private JTextField txt_itemName;
	private JTextField txt_price;
	private JButton btn_edit;
	private JButton btn_cancel;
	private JButton btn_updateMenu;


	/**
	 * Create the application.
	 */
	public EditMenuView() {
		setTitle("Create Menu");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 676, 446);
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(117, 11, 549, 46);
		lbl_title.setIcon(new javax.swing.ImageIcon("./Logos/editMenu.png"));
		panel.add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("Restaurant:");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 60, 100, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scroll_menu = new JScrollPane();
		scroll_menu.setBounds(464, 86, 181, 311);
		panel.add(scroll_menu);
		
		table_menuList = new JTable();
		scroll_menu.setColumnHeaderView(table_menuList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 87, 151, 310);
		panel.add(scrollPane);
		
		table_restaurant = new JTable();
		scrollPane.setViewportView(table_restaurant);
		
		JLabel lbl_menu = new JLabel("Menu:");
		lbl_menu.setForeground(SystemColor.window);
		lbl_menu.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_menu.setBounds(472, 59, 100, 14);
		panel.add(lbl_menu);
		
		JLabel lbl_editItem = new JLabel("Edit Item");
		lbl_editItem.setForeground(SystemColor.window);
		lbl_editItem.setFont(new Font("Consolas", Font.BOLD, 20));
		lbl_editItem.setBounds(261, 136, 106, 24);
		panel.add(lbl_editItem);
		
		JLabel lbl_item = new JLabel("Item:");
		lbl_item.setForeground(SystemColor.window);
		lbl_item.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_item.setBounds(198, 193, 46, 14);
		panel.add(lbl_item);
		
		JLabel lbl_price = new JLabel("Price $:");
		lbl_price.setForeground(SystemColor.window);
		lbl_price.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_price.setBounds(198, 237, 74, 14);
		panel.add(lbl_price);
		
		txt_itemName = new JTextField();
		txt_itemName.setBounds(285, 189, 139, 20);
		panel.add(txt_itemName);
		txt_itemName.setColumns(10);
		
		txt_price = new JTextField();
		txt_price.setBounds(282, 233, 142, 20);
		panel.add(txt_price);
		txt_price.setColumns(10);
		
		btn_edit = new JButton("Edit");
		btn_edit.setBackground(new Color(244, 164, 96));
		btn_edit.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_edit.setBounds(198, 278, 89, 35);
		panel.add(btn_edit);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(335, 278, 89, 35);
		panel.add(btn_cancel);
		
		btn_updateMenu = new JButton("Update Menu");
		btn_updateMenu.setBackground(new Color(244, 164, 96));
		btn_updateMenu.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_updateMenu.setBounds(241, 337, 151, 43);
		panel.add(btn_updateMenu);
		initialize();
		
		this.setVisible(true);
	}

	public JButton getBtn_edit() {
		return btn_edit;
	}

	public void setBtn_edit(JButton btn_edit) {
		this.btn_edit = btn_edit;
	}

	public JButton getBtn_updateMenu() {
		return btn_updateMenu;
	}

	public void setBtn_updateMenu(JButton btn_updateMenu) {
		this.btn_updateMenu = btn_updateMenu;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 692, 485);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JTable getTable_menuList() {
		return table_menuList;
	}

	public void setTable_menuList(JTable table_menuList) {
		this.table_menuList = table_menuList;
	}

	public JTable getTable_restaurant() {
		return table_restaurant;
	}

	public void setTable_restaurant(JTable table_restaurant) {
		this.table_restaurant = table_restaurant;
	}

	public JTextField getTxt_itemName() {
		return txt_itemName;
	}

	public void setTxt_itemName(JTextField txt_itemName) {
		this.txt_itemName = txt_itemName;
	}

	public JTextField getTxt_price() {
		return txt_price;
	}

	public void setTxt_price(JTextField txt_price) {
		this.txt_price = txt_price;
	}

	public JButton getBtn_add() {
		return btn_edit;
	}

	public void setBtn_add(JButton btn_add) {
		this.btn_edit = btn_add;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}
	

	public JButton getBtn_createMenu() {
		return btn_updateMenu;
	}

	public void setBtn_createMenu(JButton btn_createMenu) {
		this.btn_updateMenu = btn_createMenu;
	}
}
