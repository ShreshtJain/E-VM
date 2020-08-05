package com.zensar.corejava.onlinevote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Admin_login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login window = new Admin_login();
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
	public Admin_login() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_id;
				String passwor;
				user_id=textField.getText();
				passwor=passwordField.getText();
				if((user_id.equals("shresht"))&&(passwor.equals("shresht")))
				{
					try	{
						 admin_login1 al=new admin_login1();
						 al.connect();
						 frame.dispose();
						 Login_pages lop=new Login_pages();
						 Login_pages.main(null);
						}
					catch(Exception e1)
					
						{
						 System.out.println("there was some error in establishing connection : "+e);
						}
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid user and password");
				}
			}
		});
		
		
		btnNewButton.setForeground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(149, 190, 134, 42);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(149, 78, 134, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(21, 130, 92, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(21, 72, 97, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(93, 10, 249, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(149, 134, 134, 19);
		frame.getContentPane().add(passwordField);
		

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login_pages lp=new Login_pages();
			}
		});
		btnNewButton_2.setBounds(0, 10, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Backgroundimage");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\sys.jpg"));
		lblNewLabel_3.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel_3);
		
	}
}
