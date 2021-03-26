import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
public class Home implements ActionListener 
{
	public JButton status,addUser,updateUser,carWash,repair,servicing,modify,login,exit;
	public JFrame f;
	JButton logout;
	public static int flag=0;
	public static String key;
	Home()
	{
		f=new JFrame("Home");
		try {
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/home.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.setSize(400,410);
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		Font font2 = new Font("Arial", Font.ITALIC+Font.BOLD,14);
		
		repair=new JButton("Repair");
		repair.setBounds(240,170,200,60);
		repair.setBorder(new RoundedBorder(15));
		repair.setBackground(Color.decode("#0F5DA6"));
		repair.setForeground(Color.WHITE);
		repair.setFont(font1);
		
		addUser=new JButton("Add User");
		addUser.setBounds(500,185,200,60);
		addUser.setBorder(new RoundedBorder(15));
		addUser.setBackground(Color.decode("#0F5DA6"));
		addUser.setForeground(Color.WHITE);
		addUser.setFont(font1);
		
		modify=new JButton("Modify");
		modify.setBounds(760,170,200,60);
		modify.setBorder(new RoundedBorder(15));
		modify.setBackground(Color.decode("#0F5DA6"));
		modify.setForeground(Color.WHITE);
		modify.setFont(font1);
		
		carWash=new JButton("Car Wash");
		carWash.setBounds(240,380,200,60);
		carWash.setBorder(new RoundedBorder(15));
		carWash.setBackground(Color.decode("#0F5DA6"));
		carWash.setForeground(Color.WHITE);
		carWash.setFont(font1);
		
		updateUser=new JButton("Update User");
		updateUser.setBounds(500,270,200,60);
		updateUser.setBorder(new RoundedBorder(15));
		updateUser.setBackground(Color.decode("#0F5DA6"));
		updateUser.setForeground(Color.WHITE);
		updateUser.setFont(font1);
		
		servicing=new JButton("Servicing");
		servicing.setBounds(760,380,200,60);
		servicing.setBorder(new RoundedBorder(15));
		servicing.setBackground(Color.decode("#0F5DA6"));
		servicing.setForeground(Color.WHITE);
		servicing.setFont(font1);
		
		status=new JButton("Status");
		status.setBounds(500,360,200,60);
		status.setBorder(new RoundedBorder(15));
		status.setBackground(Color.decode("#0F5DA6"));
		status.setForeground(Color.WHITE);
		status.setFont(font1);
		
		login=new JButton("Login");
		login.setBounds(1138,6,65,20);
		login.setBorder(new RoundedBorder(2));
		login.setForeground(Color.WHITE);
		login.setBackground(Color.GRAY);
		login.setFont(font2);
		
		
		if(flag==1) {
			logout=new JButton("Logout");
			logout.setBounds(1138,6,65,20);
			logout.setBorder(new RoundedBorder(2));
			logout.setForeground(Color.WHITE);
			logout.setBackground(Color.GRAY);
			logout.setFont(font2);
			f.add(logout);
		}
		
		exit=new JButton("Exit");
		exit.setBounds(1138,495,65,20);
		exit.setBorder(new RoundedBorder(2));
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.GRAY);
		exit.setFont(font2);
		
		f.add(status);
		f.add(addUser);
		f.add(updateUser);
		f.add(carWash);
		f.add(repair);
		f.add(servicing);
		f.add(modify);
		f.add(login);
		f.add(exit);
		
		login.addActionListener(this);
		exit.addActionListener(this);
		if(flag==1)
		{
			logout.addActionListener(this);
			addUser.addActionListener(this);
			updateUser.addActionListener(this);
			status.addActionListener(this);
			repair.addActionListener(this);
			carWash.addActionListener(this);
			servicing.addActionListener(this);
			modify.addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==login) {
			f.dispose();
			new Login();
		}
		if(e.getSource()==exit)
		{
			f.dispose();
		}
		if(e.getSource()==logout)
		{
			Home.flag=0;
			f.dispose();
			new Home();
		}
		if(e.getSource()==addUser)
		{
			f.dispose();
			new AddUser();
		}
		if(e.getSource()==updateUser)
		{
			f.dispose();
			new UpdateUser();
		}
		if(e.getSource()==status)
		{
			f.dispose();
			new Status();
		}
		if(e.getSource()==repair)
		{
			Home.key=repair.getText();
			f.dispose();
			new Work();
		}
		if(e.getSource()==carWash)
		{
			Home.key=carWash.getText();
			f.dispose();
			new Work();
		}
		if(e.getSource()==servicing)
		{
			Home.key=servicing.getText();
			f.dispose();
			new Work();
		}
		if(e.getSource()==modify)
		{
			Home.key=modify.getText();
			f.dispose();
			new Work();
		}
	}

}
