package com.zensar.corejava.onlinevote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Otp_verification_page {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String no;
	private int getotp,gototp;
	private String op;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otp_verification_page window = new Otp_verification_page();
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
	public Otp_verification_page() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 566, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MOBILE NO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(54, 73, 128, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OTP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(54, 174, 128, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(238, 70, 217, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 171, 217, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				op=textField_1.getText();
				getotp=Integer.parseInt(op);
				Otp_generator otg=new Otp_generator ();
				int l=Otp_generator.otp;
				if(l==getotp)
				{
					frame.dispose();
					Voting_page vp=new Voting_page();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter correct otp");
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(207, 271, 128, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("send OTP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				no=textField.getText();
				try	{
				
					Otp_verification1 op=new Otp_verification1();
					op.connect(no);
					btnNewButton_1.setEnabled(true);
					 /*if(st1.execute("select mobile_no from Voter where  mobile_no like'"+no+"'")==true)
					 {
						 Otp_generator og =new Otp_generator();
							og.sendSms(no);
							btnNewButton_1.setEnabled(true);
	 				 }
					 else
					 {
						 JOptionPane.showMessageDialog(null,"this Mobile no is not registered");
					 }*/
					
					}
				catch(Exception e1)
					{
					 System.out.println("there was some error in establishing connection : "+e);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBounds(389, 271, 140, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_pages window = new Login_pages();
				frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_2.setBounds(33, 271, 101, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\ooo.png"));
		lblNewLabel_2.setBounds(0, 0, 552, 375);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
