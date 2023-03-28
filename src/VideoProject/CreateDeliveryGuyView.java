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

public class CreateDeliveryGuyView extends JFrame{
	private JTextField txt_areaCode;
	private JTextField txt_phone1;
	private JTextField txt_phone2;
	private JTextField txt_driverName;
	private JTextField txt_addArea;




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
		lbl_title.setBounds(67, 11, 514, 50);
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
		
		JTextArea txtxArea_deliveryArea = new JTextArea();
		txtxArea_deliveryArea.setBounds(118, 200, 320, 78);
		panel.add(txtxArea_deliveryArea);
		
		JLabel lbl_addArea = new JLabel("Delivery Area:");
		lbl_addArea.setForeground(SystemColor.window);
		lbl_addArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_addArea.setBounds(156, 304, 123, 14);
		panel.add(lbl_addArea);
		
		txt_addArea = new JTextField();
		txt_addArea.setBounds(278, 300, 86, 20);
		panel.add(txt_addArea);
		txt_addArea.setColumns(10);
		
		JButton btn_addArea = new JButton("Add");
		btn_addArea.setBackground(new Color(244, 164, 96));
		btn_addArea.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_addArea.setBounds(395, 289, 75, 42);
		panel.add(btn_addArea);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setBackground(new Color(244, 164, 96));
		btn_delete.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_delete.setBounds(492, 289, 89, 42);
		panel.add(btn_delete);
		
		JButton btn_save = new JButton("Save");
		btn_save.setBackground(new Color(244, 164, 96));
		btn_save.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_save.setBounds(148, 350, 89, 42);
		panel.add(btn_save);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(244, 164, 96));
		btn_cancel.setFont(new Font("Consolas", Font.BOLD, 16));
		btn_cancel.setBounds(301, 347, 89, 45);
		panel.add(btn_cancel);
	}
}
