package com.zensar.corejava.onlinevote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;
import java.util.Random;

import javax.swing.JOptionPane; 
public class Otp_generator {
	public static  int otp;
	 String no;
	public String sendSms(String no) {
		
		try {
			this.no=no;
			Random rand=new Random();
			otp=rand.nextInt(9999);
			String apiKey = "apikey=" + URLEncoder.encode("QkyrPZzLZ/M-pd0NTYvTCSsdzqrFWkJSKbenuRbjsb", "UTF-8");
			String message = "&message=" + URLEncoder.encode("your otp is "+otp+"\n"+"do not share this", "UTF-8");
			String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
			String numbers = "&numbers=" + URLEncoder.encode(no, "UTF-8");
			
			// Send data
			String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult="";
			while ((line = rd.readLine()) != null) {
			// Process line...
				sResult=sResult+line+" ";
			}
			rd.close();
			JOptionPane.showMessageDialog(null, "otp sent successfully");
			
			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
