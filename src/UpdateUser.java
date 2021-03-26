import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UpdateUser implements ActionListener
{
	JFrame f7;
	JButton search,cancel;
	JLabel idl;
	JTextField idt;
	String idtext;
	public String name,id,phone,address,carmodel,vehicleno;
	JFrame f06;
	JLabel usernamel,useridl,userphonel,useraddresl,vehiclemodell,vehiclenol;
	JTextField usernamet,useridt,userphonet,useraddrest,vehiclemodelt,vehiclenot;
	JButton update,cancl;
	UpdateUser()
	{
		f7=new JFrame("Update User");
		try {
			f7.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f7.setSize(400,400);
		f7.setResizable(false);
		f7.pack();
		f7.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		
		idl=new JLabel("Enter User ID ");
		idl.setBounds(300,150,250,40);
		idl.setForeground(Color.BLACK);
		idl.setFont(font1);
		
		idt=new JTextField();
		idt.setBounds(300,200,320,40);
		
		try {
			search=new JButton("Search",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/search.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		search.setBounds(300,250,155,50);
		search.setForeground(Color.decode("#0F5DA6"));
		
		try {
			cancel=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/cancelico.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cancel.setBounds(475,250,155,50);
		cancel.setForeground(Color.decode("#0F5DA6"));
		
		
		f7.add(idl);
		f7.add(idt);
		f7.add(search);
		f7.add(cancel);
			
		search.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==search)
		{
			idtext=idt.getText().toString();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdc:oracle:thin:@Localhost:1521:xe","system","oracle");
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery("Select * from ADDUSER where id='"+idtext+"' ");
				Boolean b=rs.next();
				System.out.println(b);
					if(b)
					{
							name=rs.getString(1);
							id=rs.getString(2);
							phone=rs.getString(3);
							address=rs.getString(4);
							carmodel=rs.getString(5);
							vehicleno=rs.getString(6);
						
						f7.dispose();
						
						f06=new JFrame("Update User");
						try {
							f06.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
						} catch (IOException excep) {
							excep.printStackTrace();
						}
						f06.setSize(400,400);
						f06.setResizable(false);
						f06.pack();
						f06.setVisible(true);
						
						Font font1 = new Font("Arial", Font.BOLD,25);
						
						usernamel=new JLabel("Name");
						usernamel.setBounds(250,50,140,40);
						usernamel.setForeground(Color.WHITE);
						usernamel.setFont(font1);
						
						usernamet=new JTextField(name);
						usernamet.setBounds(410,50,210,30);
						
						useridl=new JLabel("ID");
						useridl.setBounds(250,100,140,40);
						useridl.setForeground(Color.WHITE);
						useridl.setFont(font1);
						
						useridt=new JTextField(id);
						useridt.setBounds(410,100,210,30);
						
						userphonel=new JLabel("Phone");
						userphonel.setBounds(250,150,140,30);
						userphonel.setForeground(Color.WHITE);
						userphonel.setFont(font1);
						
						userphonet=new JTextField(phone);
						userphonet.setBounds(410,150,210,30);
						
						useraddresl=new JLabel("Address");
						useraddresl.setBounds(250,200,140,40);
						useraddresl.setForeground(Color.WHITE);
						useraddresl.setFont(font1);
						
						useraddrest=new JTextField(address);
						useraddrest.setBounds(410,200,210,30);
						
						vehiclemodell=new JLabel("Car Model");
						vehiclemodell.setBounds(250,250,140,40);
						vehiclemodell.setForeground(Color.WHITE);
						vehiclemodell.setFont(font1);
						
						vehiclemodelt=new JTextField(carmodel);
						vehiclemodelt.setBounds(410,250,210,30);
						
						vehiclenol=new JLabel("Vehicle No");
						vehiclenol.setBounds(250,300,140,40);
						vehiclenol.setForeground(Color.WHITE);
						vehiclenol.setFont(font1);
						
						vehiclenot=new JTextField(vehicleno);
						vehiclenot.setBounds(410,300,210,30);
						
						try {
							update=new JButton("update",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/save.png"))));
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						update.setBounds(250,350,175,50);
						update.setForeground(Color.decode("#0F5DA6"));
						
						try {
							cancl=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/cancelico.png"))));
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						cancl.setBounds(445,350,175,50);
						cancl.setForeground(Color.decode("#0F5DA6"));
						
						f06.add(usernamel);
						f06.add(usernamet);
						f06.add(useridl);
						f06.add(useridt);
						f06.add(userphonel);
						f06.add(userphonet);
						f06.add(useraddresl);
						f06.add(useraddrest);
						f06.add(vehiclemodell);
						f06.add(vehiclemodelt);
						f06.add(vehiclenol);
						f06.add(vehiclenot);
						f06.add(update);
						f06.add(cancl);
						
						update.addActionListener(this);
						cancl.addActionListener(this);
						
					}else {
						JOptionPane.showMessageDialog(f7,"Incorrect ID");
					}
			}catch(Exception excep)
			{
					excep.printStackTrace();
			}
		}
		if(e.getSource()==cancel)
		{
			f7.dispose();
			if(Home.flag==1)
			{
				new Home();
			}
			else {
				new AdminHome();
			}
			
		}
		if(e.getSource()==update)
		{
			name=usernamet.getText().toString();
			id=useridt.getText().toString();
			phone=userphonet.getText().toString();
			address=useraddrest.getText().toString();
			carmodel=vehiclemodelt.getText().toString();
			vehicleno=vehiclenot.getText().toString();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdc:oracle:thin:@Localhost:1521:xe","system","oracle");
				Statement st=cn.createStatement();
				st.executeUpdate("DELETE ADDUSER where id='"+idtext+"' ");
				st.executeUpdate("Insert into ADDUSER values('"+name+"','"+id+"','"+phone+"','"+address+"','"+carmodel+"','"+vehicleno+"')");
				JOptionPane.showMessageDialog(f06,"Updated");
				f06.dispose();
				if(Home.flag==1)
				{
					new Home();
				}
				else {
					new AdminHome();
				}
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(e.getSource()==cancl)
		{
			f06.dispose();
			if(Home.flag==1)
			{
				new Home();
			}
			else {
				new AdminHome();
			}
		}
		
	}

}
