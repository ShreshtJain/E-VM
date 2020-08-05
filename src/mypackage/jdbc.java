package mypackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {

	private JFrame frmInventoryManagmentSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jdbc window = new jdbc();
					window.frmInventoryManagmentSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jdbc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventoryManagmentSystem = new JFrame();
		frmInventoryManagmentSystem.setForeground(Color.WHITE);
		frmInventoryManagmentSystem.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frmInventoryManagmentSystem.setBackground(Color.WHITE);
		frmInventoryManagmentSystem.getContentPane().setBackground(Color.WHITE);
		frmInventoryManagmentSystem.getContentPane().setForeground(SystemColor.window);
		frmInventoryManagmentSystem.setFont(new Font("Arial Black", Font.BOLD, 13));
		frmInventoryManagmentSystem.setTitle("Inventory Managment System");
		frmInventoryManagmentSystem.setBounds(100, 100, 714, 497);
		frmInventoryManagmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryManagmentSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(149, 86, 108, 40);
		frmInventoryManagmentSystem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBounds(149, 154, 135, 40);
		frmInventoryManagmentSystem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Quantity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(149, 227, 152, 40);
		frmInventoryManagmentSystem.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product Rate");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(149, 300, 152, 27);
		frmInventoryManagmentSystem.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(321, 99, 123, 19);
		frmInventoryManagmentSystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(321, 167, 123, 19);
		frmInventoryManagmentSystem.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(321, 240, 123, 19);
		frmInventoryManagmentSystem.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(321, 306, 123, 19);
		frmInventoryManagmentSystem.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnInsert= new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Hp\\eclipse-workspace\\aap\\src\\AAA.db");
					Statement stmt= conn.createStatement();
					int id=0,qty=0,rate=0;
					String name="";
					String i;
					id=Integer.parseInt(textField.getText());
					name=(textField_1.getText());
					i=(textField_1.getText());
					System.out.println(i);
					qty=Integer.parseInt(textField_2.getText());
					rate=Integer.parseInt(textField_3.getText());
					stmt.executeUpdate("INSERT INTO jdbc VALUES ("+id+" ,'"+name+"',  "+qty+" ,  "+rate+") ");
					lblNewLabel.setText("Successfully Inserted");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnInsert.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnInsert.setBounds(88, 378, 85, 21);
		frmInventoryManagmentSystem.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Hp\\eclipse-workspace\\aap\\src\\AAA.db");
					Statement stmt= conn.createStatement();
					int id=0,qty=0,rate=0;
					String name="";
					id=Integer.parseInt(textField.getText());
					name=(textField_1.getText());
					qty=Integer.parseInt(textField_2.getText());
					rate=Integer.parseInt(textField_3.getText());
					stmt.executeUpdate("   UPDATE jdbc SET Name='"+name+"',Quantity="+qty+" ,  Rate="+rate+" WHERE Id="+id+" ");
					lblNewLabel.setText("Successfully Updated");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	    btnUpdate.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
	    btnUpdate.setBounds(229, 378, 85, 21);
		frmInventoryManagmentSystem.getContentPane().add( btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Hp\\eclipse-workspace\\aap\\src\\AAA.db");
					Statement stmt= conn.createStatement();
					int id=0,qty=0,rate=0;
					String name="";
					id=Integer.parseInt(textField.getText());
					name=(textField_1.getText());
					qty=Integer.parseInt(textField_2.getText());
					rate=Integer.parseInt(textField_3.getText());
					stmt.executeUpdate(" DELETE FROM jdbc WHERE  Id="+id+"");
					lblNewLabel.setText("Successfully Deleted");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnDelete.setBounds(367, 378, 85, 21);
		frmInventoryManagmentSystem.getContentPane().add(btnDelete);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Hp\\eclipse-workspace\\aap\\src\\AAA.db");
					Statement stmt= conn.createStatement();
					int id=0,qty=0,rate=0;
					String i;
					String name="";
					id=Integer.parseInt(textField.getText());
					name=(textField_1.getText());
					i=(textField_1.getText());
					System.out.println(i);
					qty=Integer.parseInt(textField_2.getText());
					rate=Integer.parseInt(textField_3.getText());
					stmt.executeUpdate("   UPDATE jdbc SET Name='"+name+"', Quantity="+qty+" , Rate="+rate+" WHERE Id="+id+" ");
					lblNewLabel.setText("Successfully Updated");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnDisplay.setBounds(500, 380, 85, 21);
		frmInventoryManagmentSystem.getContentPane().add(btnDisplay);
	}
}
