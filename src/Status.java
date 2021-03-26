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

public class Status implements ActionListener
{
	JFrame f8,f08,f008;
	JButton search,cancel;
	JLabel namel,idl,carmodell,vehiclenol,work,status;
	JLabel nameld,idld,carmodelld,vehiclenold,workd,statusd;
	JTextField idt;
	String idtext;
	String namedata,iddata,carmodeldata,vehiclenodata,workdata,statusdata;
	JButton ok,edit,done;
	Status()
	{
		f8=new JFrame("Status");
		try {
			f8.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f8.setSize(400,400);
		f8.setResizable(false);
		f8.pack();
		f8.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		
		idl=new JLabel("Enter User ID ");
		idl.setBounds(300,150,250,40);
		idl.setForeground(Color.BLACK);
		idl.setFont(font1);
		
		idt=new JTextField();
		idt.setBounds(300,200,320,40);
		
		try {
			search=new JButton("Check",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/schd.png"))));
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
		cancel.setBounds(476,251,156,51);
		cancel.setForeground(Color.decode("#0F5DA6"));
		
		
		f8.add(idl);
		f8.add(idt);
		f8.add(search);
		f8.add(cancel);
			
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
				if(b)
				{
					f8.dispose();
					
					namedata=rs.getString(1);
					iddata=rs.getString(2);
					carmodeldata=rs.getString(5);
					vehiclenodata=rs.getString(6);
					ResultSet rs1=st.executeQuery("Select * from ADDWORK where id='"+idtext+"' ");
					Boolean a=rs1.next();
					if(a)
					{
						workdata=rs1.getString(2);
						statusdata=rs1.getString(3);
					}
					f08=new JFrame("Status");
					try {
						f08.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-2.png")))));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					f08.setSize(400,400);
					f08.setResizable(false);
					f08.pack();
					f08.setVisible(true);
					
					Font font1 = new Font("Arial", Font.BOLD,16);
					Font font2 = new Font("Arial", Font.ITALIC+Font.BOLD,14);
					
					namel=new JLabel("Name             :");
					namel.setBounds(300,120,150,40);
					namel.setForeground(Color.BLACK);
					namel.setFont(font1);
					
					idl=new JLabel("ID                    :");
					idl.setBounds(300,160,150,40);
					idl.setForeground(Color.BLACK);
					idl.setFont(font1);
					
					carmodell=new JLabel("Car Model     :");
					carmodell.setBounds(300,200,150,40);
					carmodell.setForeground(Color.BLACK);
					carmodell.setFont(font1);
					
					vehiclenol=new JLabel("Vehicle no    :");
					vehiclenol.setBounds(300,240,150,40);
					vehiclenol.setForeground(Color.BLACK);
					vehiclenol.setFont(font1);
					
					work=new JLabel("Work              :");
					work.setBounds(300,280,150,40);
					work.setForeground(Color.BLACK);
					work.setFont(font1);
					
					status=new JLabel("Status            :");
					status.setBounds(300,320,150,40);
					status.setForeground(Color.BLACK);
					status.setFont(font1);
					
					nameld=new JLabel(namedata);
					nameld.setBounds(500,120,150,40);
					nameld.setForeground(Color.BLUE);
					nameld.setFont(font2);
					
					idld=new JLabel(iddata);
					idld.setBounds(500,160,150,40);
					idld.setForeground(Color.BLUE);
					idld.setFont(font2);
					
					carmodelld=new JLabel(carmodeldata);
					carmodelld.setBounds(500,200,150,40);
					carmodelld.setForeground(Color.BLUE);
					carmodelld.setFont(font2);
					
					vehiclenold=new JLabel(vehiclenodata);
					vehiclenold.setBounds(500,240,150,40);
					vehiclenold.setForeground(Color.BLUE);
					vehiclenold.setFont(font2);
					
					workd=new JLabel(workdata);
					workd.setBounds(500,280,150,40);
					workd.setForeground(Color.BLUE);
					workd.setFont(font2);
					
					statusd=new JLabel(statusdata);
					statusd.setBounds(500,320,150,40);
					statusd.setForeground(Color.BLUE);
					statusd.setFont(font2);
					
					try {
						ok=new JButton("Ok",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/ok.png"))));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					ok.setBounds(315,375,175,50);
					ok.setForeground(Color.decode("#0F5DA6"));
					
					try {
						edit=new JButton("Edit",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/clear.png"))));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					edit.setBounds(510,375,175,50);
					edit.setForeground(Color.decode("#0F5DA6"));
					
					f08.add(namel);
					f08.add(idl);
					f08.add(carmodell);
					f08.add(vehiclenol);
					f08.add(work);
					f08.add(status);
					f08.add(nameld);
					f08.add(idld);
					f08.add(carmodelld);
					f08.add(vehiclenold);
					f08.add(workd);
					f08.add(statusd);
					f08.add(ok);
					f08.add(edit);
					
					ok.addActionListener(this);
					edit.addActionListener(this);
					
				}else {
					JOptionPane.showMessageDialog(f8,"Incorrect ID");
				}
			}catch(Exception excep)
			{
				excep.printStackTrace();
		}
		}
		if(e.getSource()==cancel)
		{
			f8.dispose();
			if(Home.flag==1)
			{
				new Home();
			}
			else {
				new AdminHome();
			}
		}
		if(e.getSource()==ok)
		{
			f08.dispose();
			if(Home.flag==1)
			{
				new Home();
			}
			else {
				new AdminHome();
			}
		}
		if(e.getSource()==edit)
		{
			f08.dispose();
			
			f008=new JFrame("Edit Status");
			try {
				f008.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-2.png")))));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			f008.setSize(400,400);
			f008.setResizable(false);
			f008.pack();
			f008.setVisible(true);
			
			Font font1 = new Font("Arial", Font.BOLD,25);
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdc:oracle:thin:@Localhost:1521:xe","system","oracle");
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery("Select * from ADDWORK where id='"+idtext+"' ");
				Boolean b=rs.next();
				if(b)
				{
					statusdata=rs.getString(3);
				}
			}catch(Exception excep)
			{
				excep.printStackTrace();
			}
			
			idl=new JLabel("Update Status");
			idl.setBounds(300,150,250,40);
			idl.setForeground(Color.BLACK);
			idl.setFont(font1);
			
			idt=new JTextField(statusdata);
			idt.setBounds(300,200,320,40);
			
			try {
				done=new JButton("Done",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/save.png"))));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			done.setBounds(400,270,155,50);
			done.setForeground(Color.decode("#0F5DA6"));
			
			f008.add(idl);
			f008.add(idt);
			f008.add(done);
			
			done.addActionListener(this);
		}
		if(e.getSource()==done)
		{
			statusdata=idt.getText().toString();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdc:oracle:thin:@Localhost:1521:xe","system","oracle");
				Statement st=cn.createStatement();
				st.executeQuery("UPDATE ADDWORK SET status='"+statusdata+"' where id='"+idtext+"' ");
			}catch(Exception excep)
			{
				excep.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(f008,"Status Update");
			f008.dispose();
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
