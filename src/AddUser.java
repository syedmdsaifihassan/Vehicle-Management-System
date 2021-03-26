import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AddUser implements ActionListener
{
	JFrame f6;
	JLabel usernamel,useridl,userphonel,useraddresl,vehiclemodell,vehiclenol;
	JTextField usernamet,useridt,userphonet,useraddrest,vehiclemodelt,vehiclenot;
	JButton add,cancel;
	public String name,id,phone,address,carmodel,vehicleno;
	AddUser()
	{
		f6=new JFrame("Add User");
		try {
			f6.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
		} catch (IOException excep) {
			excep.printStackTrace();
		}
		f6.setSize(400,400);
		f6.setResizable(false);
		f6.pack();
		f6.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		
		usernamel=new JLabel("Name");
		usernamel.setBounds(250,50,140,40);
		usernamel.setForeground(Color.WHITE);
		usernamel.setFont(font1);
		
		usernamet=new JTextField();
		usernamet.setBounds(410,50,210,30);
		
		useridl=new JLabel("ID");
		useridl.setBounds(250,100,140,40);
		useridl.setForeground(Color.WHITE);
		useridl.setFont(font1);
		
		useridt=new JTextField();
		useridt.setBounds(410,100,210,30);
		
		userphonel=new JLabel("Phone");
		userphonel.setBounds(250,150,140,30);
		userphonel.setForeground(Color.WHITE);
		userphonel.setFont(font1);
		
		userphonet=new JTextField();
		userphonet.setBounds(410,150,210,30);
		
		useraddresl=new JLabel("Address");
		useraddresl.setBounds(250,200,140,40);
		useraddresl.setForeground(Color.WHITE);
		useraddresl.setFont(font1);
		
		useraddrest=new JTextField();
		useraddrest.setBounds(410,200,210,30);
		
		vehiclemodell=new JLabel("Car Model");
		vehiclemodell.setBounds(250,250,140,40);
		vehiclemodell.setForeground(Color.WHITE);
		vehiclemodell.setFont(font1);
		
		vehiclemodelt=new JTextField();
		vehiclemodelt.setBounds(410,250,210,30);
		
		vehiclenol=new JLabel("Vehicle No");
		vehiclenol.setBounds(250,300,140,40);
		vehiclenol.setForeground(Color.WHITE);
		vehiclenol.setFont(font1);
		
		vehiclenot=new JTextField();
		vehiclenot.setBounds(410,300,210,30);
		
		try {
			add=new JButton("Add",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/addnew.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		add.setBounds(250,350,175,50);
		add.setForeground(Color.decode("#0F5DA6"));
		
		try {
			cancel=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/cancelico.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cancel.setBounds(445,350,175,50);
		cancel.setForeground(Color.decode("#0F5DA6"));
		
		f6.add(usernamel);
		f6.add(usernamet);
		f6.add(useridl);
		f6.add(useridt);
		f6.add(userphonel);
		f6.add(userphonet);
		f6.add(useraddresl);
		f6.add(useraddrest);
		f6.add(vehiclemodell);
		f6.add(vehiclemodelt);
		f6.add(vehiclenol);
		f6.add(vehiclenot);
		f6.add(add);
		f6.add(cancel);
		
		add.addActionListener(this);
		cancel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==add)
		{
			name=usernamet.getText().toString();
			id=useridt.getText().toString();
			phone=userphonet.getText().toString();
			address=useraddrest.getText().toString();
			carmodel=vehiclemodelt.getText().toString();
			vehicleno=vehiclenot.getText().toString();
			
			if(validate())
			{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","oracle");
					Statement st=cn.createStatement();
					st.executeUpdate("Insert into ADDUSER values('"+name+"','"+id+"','"+phone+"','"+address+"','"+carmodel+"','"+vehicleno+"')");
					JOptionPane.showMessageDialog(f6,"Added");
					f6.dispose();
					if(Home.flag==1)
					{
						new Home();
					}
					else {
						new AdminHome();
					}
				}catch(Exception excep) {
					excep.printStackTrace();
				}
			}
		}
		if(e.getSource()==cancel)
		{
			f6.dispose();
			if(Home.flag==1)
			{
				new Home();
			}
			else {
				new AdminHome();
			}
		}
		
	}
	public Boolean validate()
	{
		Boolean check=false;
		if(name.length()<5) 
		{
			check=false;
			JOptionPane.showMessageDialog(f6,"Fill all the fields");
			return check;
		}else {
			check=true;
		}
		if(id.length()<5) {
			check=false;
			JOptionPane.showMessageDialog(f6,"Fill all the fields");
			return check;
		}else {
			check=true;
		}	
		if(address.length()<1) {
			check=false;
			JOptionPane.showMessageDialog(f6,"Fill all the fields");
			return check;
		}else {
			check=true;
		}
		if(phone.length()<10||name.length()>10) {
			check=false;
			JOptionPane.showMessageDialog(f6,"Enter valid phone no");
			return check;
		}
		else {
			check=true;
		}
		if(carmodel.length()<1){
			check=false;
			JOptionPane.showMessageDialog(f6,"Fill all the fields");
			return check;
		}
		else {
		check=true;
		}
		if(vehicleno.length()<8||vehicleno.length()>8){
			check=false;
			JOptionPane.showMessageDialog(f6,"Enter valid vehical no");
			return check;
		}
		else {
		check=true;
		}
		return check;
	}
}
