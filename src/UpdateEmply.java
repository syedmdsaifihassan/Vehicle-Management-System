import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class UpdateEmply implements ActionListener 
{
	JFrame f4;
	JButton search,cancel;
	JLabel idl;
	JTextField idt;
	String idtext;
	public String name,id,phone,address;
	JFrame f03;
	JButton update,cancl;
	JLabel empnamel,empidl,empphonel,empaddresl;
	JTextField empnamet,empidt,empphonet,empaddrest;
	UpdateEmply()
	{
		f4=new JFrame("Update Employee");
		try {
			f4.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f4.setSize(400,400);
		f4.setResizable(false);
		f4.pack();
		f4.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		
		idl=new JLabel("Enter Employee ID ");
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
		
		
		f4.add(idl);
		f4.add(idt);
		f4.add(search);
		f4.add(cancel);
		
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
				ResultSet rs=st.executeQuery("Select * from ADDEMPLY where id='"+idtext+"' ");
				Boolean b=rs.next();
				System.out.println(b);
				if(b)
				{
						name=rs.getString(1);
						id=rs.getString(2);
						phone=rs.getString(3);
						address=rs.getString(4);
					
					f4.dispose();
					
					
					f03=new JFrame("Update Employee");
					try {
						f03.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					f03.setSize(400,400);
					f03.setResizable(false);
					f03.pack();
					f03.setVisible(true);
					
					Font font1 = new Font("Arial", Font.BOLD,25);/*
					Font font2 = new Font("Arial", Font.ITALIC+Font.BOLD,14);*/
					
					empnamel=new JLabel("Name");
					empnamel.setBounds(250,100,100,40);
					empnamel.setForeground(Color.WHITE);
					empnamel.setFont(font1);
					
					empnamet=new JTextField(name);
					empnamet.setBounds(370,100,210,30);
					
					empidl=new JLabel("ID");
					empidl.setBounds(250,150,100,40);
					empidl.setForeground(Color.WHITE);
					empidl.setFont(font1);
					
					empidt=new JTextField(id);
					empidt.setBounds(370,150,210,30);
					
					empphonel=new JLabel("Phone");
					empphonel.setBounds(250,200,100,30);
					empphonel.setForeground(Color.WHITE);
					empphonel.setFont(font1);
					
					empphonet=new JTextField(phone);
					empphonet.setBounds(370,200,210,30);
					
					empaddresl=new JLabel("Address");
					empaddresl.setBounds(250,250,100,40);
					empaddresl.setForeground(Color.WHITE);
					empaddresl.setFont(font1);
					
					empaddrest=new JTextField(address);
					empaddrest.setBounds(370,250,210,30);
					
					try {
						update=new JButton("Update",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/save.png"))));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					update.setBounds(250,330,155,50);
					update.setForeground(Color.decode("#0F5DA6"));
					
					try {
						cancl=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/cancelico.png"))));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					cancl.setBounds(425,330,155,50);
					cancl.setForeground(Color.decode("#0F5DA6"));
					
					f03.add(empnamel);
					f03.add(empnamet);
					f03.add(empidl);
					f03.add(empidt);
					f03.add(empphonel);
					f03.add(empphonet);
					f03.add(empaddresl);
					f03.add(empaddrest);
					f03.add(update);
					f03.add(cancl);
					
					update.addActionListener(this);
					cancl.addActionListener(this);
				}else {
					JOptionPane.showMessageDialog(f4,"Incorrect ID");
				}
			}catch(Exception excp) 
			{
				excp.printStackTrace();
			}
			
		}
		if(e.getSource()==cancel)
		{
			f4.dispose();
			new AdminHome();
		}
		if(e.getSource()==update)
		{
			name=empnamet.getText().toString();
			id=empidt.getText().toString();
			phone=empphonet.getText().toString();
			address=empaddrest.getText().toString();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdc:oracle:thin:@Localhost:1521:xe","system","oracle");
				Statement st=cn.createStatement();
				st.executeUpdate("DELETE ADDEMPLY where id='"+idtext+"' ");
				st.executeUpdate("Insert into ADDEMPLY values('"+name+"','"+id+"','"+phone+"','"+address+"')");
				JOptionPane.showMessageDialog(f03,"Updated");
				f03.dispose();
				new AdminHome();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(e.getSource()==cancl)
		{
			f03.dispose();
			new AdminHome();
		}
	}
}
