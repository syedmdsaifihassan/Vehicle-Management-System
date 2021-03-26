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

public class AddEmply implements ActionListener
{
	JFrame f3;
	JButton add,cancel;
	JLabel empnamel,empidl,empphonel,empaddresl;
	JTextField empnamet,empidt,empphonet,empaddrest;
	AddEmply()
	{
		f3=new JFrame("Add Employee");
		try {
			f3.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f3.setSize(410,410);
		f3.setResizable(false);
		f3.pack();
		f3.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);/*
		Font font2 = new Font("Arial", Font.ITALIC+Font.BOLD,14);*/
		
		empnamel=new JLabel("Name");
		empnamel.setBounds(250,100,100,40);
		empnamel.setForeground(Color.WHITE);
		empnamel.setFont(font1);
		
		empnamet=new JTextField();
		empnamet.setBounds(370,100,210,30);
		
		empidl=new JLabel("ID");
		empidl.setBounds(250,150,100,40);
		empidl.setForeground(Color.WHITE);
		empidl.setFont(font1);
		
		empidt=new JTextField();
		empidt.setBounds(370,150,210,30);
		
		empphonel=new JLabel("Phone");
		empphonel.setBounds(250,200,100,30);
		empphonel.setForeground(Color.WHITE);
		empphonel.setFont(font1);
		
		empphonet=new JTextField();
		empphonet.setBounds(370,200,210,30);
		
		empaddresl=new JLabel("Address");
		empaddresl.setBounds(250,250,100,40);
		empaddresl.setForeground(Color.WHITE);
		empaddresl.setFont(font1);
		
		empaddrest=new JTextField();
		empaddrest.setBounds(370,250,210,30);
		
		try {
			add=new JButton("Add",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/addnew.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		add.setBounds(250,330,155,50);
		add.setForeground(Color.decode("#0F5DA6"));
		
		try {
			cancel=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/cancelico.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cancel.setBounds(425,330,155,50);
		cancel.setForeground(Color.decode("#0F5DA6"));
		
		f3.add(empnamel);
		f3.add(empnamet);
		f3.add(empidl);
		f3.add(empidt);
		f3.add(empphonel);
		f3.add(empphonet);
		f3.add(empaddresl);
		f3.add(empaddrest);
		f3.add(add);
		f3.add(cancel);
		
		add.addActionListener(this);
		cancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==add) 
		{
			String name=empnamet.getText().toString();
			String id=empidt.getText().toString();
			String phone=empphonet.getText().toString();
			String address=empaddrest.getText().toString();
			if(validate()) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","oracle");
					Statement st=cn.createStatement();
					st.executeUpdate("Insert into ADDEMPLY values('"+name+"','"+id+"','"+phone+"','"+address+"')");
					JOptionPane.showMessageDialog(f3,"Added");
					f3.dispose();
					new AdminHome();
				}catch(Exception excep) {
					excep.printStackTrace();
				}
			}
		}
		if(e.getSource()==cancel) 
		{
			f3.dispose();
			new AdminHome();
		}
	}
	
	public Boolean validate()
	{
		Boolean check=false;
		String name=empnamet.getText().toString();
		String id=empidt.getText().toString();
		String phone=empphonet.getText().toString();
		String address=empaddrest.getText().toString();
		if(name.length()<5) 
		{
			check=false;
			JOptionPane.showMessageDialog(f3,"Fill all the fields");
			return check;
		}else {
			check=true;
		}
		if(id.length()<(6-1)) {
			check=false;
			JOptionPane.showMessageDialog(f3,"Fill all the fields");
			return check;
		}else {
			check=true;
		}	
		if(address.length()<1) {
			check=false;
			JOptionPane.showMessageDialog(f3,"Fill all the fields");
			return check;
		}else {
			check=true;
		}
		if(phone.length()<10||name.length()>10) {
			check=false;
			JOptionPane.showMessageDialog(f3,"Enter valid phone no");
			return check;
		}else {
			check=true;
		}
		return check;
	}
}
