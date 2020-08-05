package com.zensar.corejava.onlinevote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Login_pages {
String str;
	private JFrame frame;
	private JTextField textField;
	static Connection con;
	static Statement st1;
	static ResultSet rs1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_pages window = new Login_pages();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_pages () {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setForeground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			str=textField.getText();
			try	{
					login_page lp=new login_page();
					lp.connect(str);
					frame.dispose();
			}
			catch(Exception e1)
				{
				 System.out.println("there was some error in establishing connection : "+e1);
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(31, 235, 120, 38);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ENTER VOTER ID");
		lblNewLabel.setForeground(new Color(102, 0, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 113, 257, 57);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 180, 224, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New User Registration");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registration_page rp =new Registration_page();
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("Label.disabledShadow"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(427, 174, 257, 38);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_login al=new Admin_login();
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 514, 175, 38);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Online Voting Portal");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(56, 0, 591, 61);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Need Help?");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				need_help nh=new need_help();
				frame.dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(516, 520, 131, 32);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\18637.jpg"));
		lblNewLabel_2.setBounds(0, 0, 684, 573);
		panel.add(lblNewLabel_2);
	}
}
