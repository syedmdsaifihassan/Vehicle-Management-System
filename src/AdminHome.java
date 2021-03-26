import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
public class AdminHome implements ActionListener 
{
	JButton status,addUser,updateUser,updateEmp,addemp,delEmp,homebt,exit;
	JFrame f2;
	JLabel text;
	AdminHome()
	{
		f2=new JFrame("Admin Home");
		try {
			f2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f2.setSize(400,400);
		f2.setResizable(false);
		f2.pack();
		f2.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		Font font2 = new Font("Arial", Font.ITALIC+Font.BOLD,14);
		
		addemp=new JButton("Add Emply");
		addemp.setBounds(50,90,200,60);
		addemp.setBorder(new RoundedBorder(15));
		addemp.setBackground(Color.decode("#0F5DA6"));
		addemp.setForeground(Color.WHITE);
		addemp.setFont(font1);
		
		addUser=new JButton("Add User");
		addUser.setBounds(50,300,200,60);
		addUser.setBorder(new RoundedBorder(15));
		addUser.setBackground(Color.decode("#0F5DA6"));
		addUser.setForeground(Color.WHITE);
		addUser.setFont(font1);
		
		delEmp=new JButton("Delete Emply");
		delEmp.setBounds(540,90,200,60);
		delEmp.setBorder(new RoundedBorder(15));
		delEmp.setBackground(Color.decode("#0F5DA6"));
		delEmp.setForeground(Color.WHITE);
		delEmp.setFont(font1);
		
		updateEmp=new JButton("Update Emply");
		updateEmp.setBounds(300,150,200,60);
		updateEmp.setBorder(new RoundedBorder(15));
		updateEmp.setBackground(Color.decode("#0F5DA6"));
		updateEmp.setForeground(Color.WHITE);
		updateEmp.setFont(font1);
		
		updateUser=new JButton("Update User");
		updateUser.setBounds(300,230,200,60);
		updateUser.setBorder(new RoundedBorder(15));
		updateUser.setBackground(Color.decode("#0F5DA6"));
		updateUser.setForeground(Color.WHITE);
		updateUser.setFont(font1);
		
		status=new JButton("Status");
		status.setBounds(540,300,200,60);
		status.setBorder(new RoundedBorder(15));
		status.setBackground(Color.decode("#0F5DA6"));
		status.setForeground(Color.WHITE);
		status.setFont(font1);
		
		text=new JLabel("ADMIN");
		text.setBounds(890,6,65,20);
		text.setBorder(new RoundedBorder(2));
		text.setForeground(Color.WHITE);
		text.setBackground(Color.GRAY);
		text.setFont(font2);
		
		homebt=new JButton("Home");
		homebt.setBounds(890,440,65,20);
		homebt.setBorder(new RoundedBorder(2));
		homebt.setForeground(Color.WHITE);
		homebt.setBackground(Color.GRAY);
		homebt.setFont(font2);
		
		exit=new JButton("Exit");
		exit.setBounds(890,465,65,20);
		exit.setBorder(new RoundedBorder(2));
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.GRAY);
		exit.setFont(font2);
		
		f2.add(status);
		f2.add(addUser);
		f2.add(updateUser);
		f2.add(updateEmp);
		f2.add(addemp);
		f2.add(delEmp);
		f2.add(exit);
		f2.add(text);
		f2.add(homebt);
		
		addemp.addActionListener(this);
		updateEmp.addActionListener(this);
		delEmp.addActionListener(this);
		addUser.addActionListener(this);
		updateUser.addActionListener(this);
		status.addActionListener(this);
		exit.addActionListener(this);
		homebt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==exit)
		{
			f2.dispose();
		}
		if(e.getSource()==homebt)
		{
			f2.dispose();    
			new Home();
		}
		if(e.getSource()==addemp) 
		{
			f2.dispose();
			new AddEmply();
		}
		if(e.getSource()==updateEmp) 
		{
			f2.dispose();
			new UpdateEmply();
		}
		if(e.getSource()==delEmp)
		{
			f2.dispose();
			new DeleteEmply();
		}
		if(e.getSource()==addUser)
		{
			f2.dispose();
			new AddUser();
		}
		if(e.getSource()==updateUser)
		{
			f2.dispose();
			new UpdateUser();
		}
		if(e.getSource()==status)
		{
			f2.dispose();
			new Status();
		}
	}
}
