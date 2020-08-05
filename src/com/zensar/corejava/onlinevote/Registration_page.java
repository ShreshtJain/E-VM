package com.zensar.corejava.onlinevote;
import java.time.Period;
import java.time.LocalDate;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.time.*;
public class Registration_page {
private JFrame frame;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_3;
private JTextField textField_2;
private JTextField textField_4;
private JTextField textField_5;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Registration_page window = new Registration_page();
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
public Registration_page() {
initialize();
frame.setVisible(true);
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 736, 673);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel lblNewLabel = new JLabel("New Registration");
lblNewLabel.setForeground(new Color(255, 0, 0));
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
lblNewLabel.setBounds(204, 21, 393, 122);
frame.getContentPane().add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("NAME");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_1.setBounds(58, 166, 88, 25);
frame.getContentPane().add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("AADHAAR NO");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_2.setBounds(58, 238, 140, 25);
frame.getContentPane().add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("DOB");
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_3.setBounds(58, 312, 59, 25);
frame.getContentPane().add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("MOBILE NO");
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_4.setBounds(58, 505, 140, 25);
frame.getContentPane().add(lblNewLabel_4);

textField = new JTextField();
textField.setBounds(333, 165, 264, 26);
frame.getContentPane().add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(333, 238, 264, 26);
frame.getContentPane().add(textField_1);
textField_1.setColumns(10);
//UtilDateModel model=new UtilDateModel()

textField_3 = new JTextField();
textField_3.setBounds(333, 504, 264, 26);
frame.getContentPane().add(textField_3);
textField_3.setColumns(10);

JButton btnNewButton = new JButton("REGISTER");
btnNewButton.setEnabled(false);
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String name;
String aadhar_no;
String dob;
String mobile_no;
name=textField.getText();
aadhar_no=textField_1.getText();
mobile_no=textField_3.getText();
try {
int temp=0;
Registration_page1 rp=new Registration_page1();
rp.connect(name,aadhar_no,mobile_no,temp);
frame.dispose();
Login_pages llp=new Login_pages();
}
catch(Exception e1)
{
System.out.println("there was some error in establishing connection : "+e);
}
}
});
btnNewButton.setForeground(new Color(0, 191, 255));
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
btnNewButton.setBounds(220, 572, 215, 37);
frame.getContentPane().add(btnNewButton);


JButton btnNewButton_1 = new JButton("Back");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

Login_pages window = new Login_pages();
frame.setVisible(true);
frame.dispose();
}
});
btnNewButton_1.setBounds(0, 21, 85, 21);
frame.getContentPane().add(btnNewButton_1);

JLabel lblNewLabel_6 = new JLabel("DD");
lblNewLabel_6.setBounds(295, 322, 46, 13);
frame.getContentPane().add(lblNewLabel_6);

JLabel lblNewLabel_7 = new JLabel("month");
lblNewLabel_7.setBounds(422, 322, 46, 13);
frame.getContentPane().add(lblNewLabel_7);

JLabel lblNewLabel_8 = new JLabel("YY");
lblNewLabel_8.setBounds(556, 324, 46, 13);
frame.getContentPane().add(lblNewLabel_8);


textField_2 = new JTextField();
textField_2.setBounds(271, 363, 96, 19);
frame.getContentPane().add(textField_2);
textField_2.setColumns(10);

textField_4 = new JTextField();
textField_4.setBounds(401, 363, 96, 19);
frame.getContentPane().add(textField_4);
textField_4.setColumns(10);

textField_5 = new JTextField();
textField_5.setBounds(527, 363, 96, 19);
frame.getContentPane().add(textField_5);
textField_5.setColumns(10);

JLabel lblNewLabel_9 = new JLabel("");
lblNewLabel_9.setForeground(new Color(255, 51, 0));
lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_9.setBounds(243, 433, 66, 25);
frame.getContentPane().add(lblNewLabel_9);




JButton btnNewButton_2 = new JButton("Get Age");
btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

int DD= Integer.parseInt(textField_2.getText());
int MM= Integer.parseInt(textField_4.getText());
int YY= Integer.parseInt(textField_5.getText());


LocalDate Birthdate = LocalDate.of(YY, MM, DD);

LocalDate Pdate= LocalDate.now();


int period = Period.between(Birthdate, Pdate).getYears();

lblNewLabel_9.setText(String.valueOf(period));
btnNewButton.setEnabled(true);
if(period<18)
{
JOptionPane.showMessageDialog(null,"you are not eligible");
frame.dispose();
Login_pages w = new Login_pages();

}

}

});
btnNewButton_2.setBounds(58, 425, 115, 33);
frame.getContentPane().add(btnNewButton_2);







JLabel lblNewLabel_5 = new JLabel("");
lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Sjain\\Desktop\\New folder\\pen1.jpg"));
lblNewLabel_5.setBounds(0, 0, 722, 636);
frame.getContentPane().add(lblNewLabel_5);


}
}
