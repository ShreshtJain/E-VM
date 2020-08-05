package com.zensar.corejava.onlinevote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Voting_page {

	String to;
	int num1,numt;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voting_page window = new Voting_page();
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
	public Voting_page() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		ButtonGroup G1=new ButtonGroup();
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 707, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BJP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(41, 88, 85, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONGRESS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(41, 170, 105, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AAP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(41, 252, 57, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NOTA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(41, 325, 57, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Vote");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int bjp=0;
				bjp++;
			to="bjp";
			num1=bjp;
			}
		});
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 51));
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(400, 84, 105, 21);
		
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Vote");
rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int CONGRESS=0;
				CONGRESS ++;
			to="CONGRESS";
			num1=CONGRESS;
			}
		});
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 51));
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(400, 321, 105, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Vote");
rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int aap=0;
				aap++;
				to="aap";
				num1=aap;
			}
		});
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 51));
		rdbtnNewRadioButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton_2.setBounds(400, 248, 105, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Vote");
rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nota=0;
				nota++;
				to="nota";
				num1=nota;
			}
		});
		rdbtnNewRadioButton_3.setBackground(new Color(255, 255, 51));
		rdbtnNewRadioButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton_3.setBounds(400, 166, 105, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		
		G1.add(rdbtnNewRadioButton);
		G1.add(rdbtnNewRadioButton_1);
		G1.add(rdbtnNewRadioButton_2);
		G1.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("VOTING PANEL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4.setBounds(218, 10, 217, 32);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try	{
				
					database db= new database();
					db.connect(to,num1);
				JOptionPane.showMessageDialog(null,"Thank you for voting");
				frame.dispose();
				Login_pages lgp= new Login_pages();
				}
				catch(Exception e1)
					{
					 System.out.println("there was some error in establishing connection : "+e1);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(257, 402, 127, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\bjp.jpg"));
		lblNewLabel_5.setBounds(192, 80, 39, 32);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\c.png"));
		lblNewLabel_6.setBounds(192, 163, 39, 31);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\aap.jpg"));
		lblNewLabel_7.setBounds(192, 244, 39, 32);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\no.jpg"));
		lblNewLabel_8.setBounds(192, 317, 39, 32);
		frame.getContentPane().add(lblNewLabel_8);
	}
}
