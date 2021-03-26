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
public class Login implements ActionListener
{	
	JFrame f1;
	JTextField namet,passt;
	JButton log,cancel;
	JLabel namel,passl;
	JRadioButton admin,emp;
	ButtonGroup btg;
	public String adminName="admin";
	public String adminPass="admin";
	Login()
	{
		f1=new JFrame("Login");
		try {
			f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/loginbk.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f1.setSize(300,400);
		f1.setResizable(false);
		f1.pack();
		f1.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		/*Font font2 = new Font("Arial", Font.ITALIC+Font.BOLD,14);*/
		
		namel=new JLabel("Name");
		namel.setBounds(460,96,90,40);
		namel.setFont(font1);
		namel.setForeground(Color.decode("#0F5DA6"));
		
		namet=new JTextField();
		namet.setBounds(590,100,200,30);
		namet.setBorder(new RoundedBorder(2));
		namet.setForeground(Color.decode("#0F5DA6"));
		
		passl=new JLabel("ID");
		passl.setBounds(460,136,120,40);
		passl.setFont(font1);
		passl.setForeground(Color.decode("#0F5DA6"));
		
		passt=new JTextField();
		passt.setBounds(590,140,200,30);
		passt.setBorder(new RoundedBorder(2));
		passt.setForeground(Color.decode("#0F5DA6"));
		
		admin=new JRadioButton("Admin");
		admin.setBounds(480,190,80,20);
		admin.setForeground(Color.decode("#0F5DA6"));
		
		emp=new JRadioButton("Employee");
		emp.setBounds(570,190,80,20);
		emp.setForeground(Color.decode("#0F5DA6"));
		
		btg=new ButtonGroup();
		btg.add(admin);
		btg.add(emp);
		
		try {
			log=new JButton("Login",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/loginico.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.setBounds(460,230,155,50);
		log.setForeground(Color.decode("#0F5DA6"));
		
		try {
			cancel=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/cancelico.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cancel.setBounds(635,230,155,50);
		cancel.setForeground(Color.decode("#0F5DA6"));
		
		f1.add(namel);
		f1.add(namet);
		f1.add(passl);
		f1.add(passt);
		f1.add(admin);
		f1.add(emp);
		f1.add(log);
		f1.add(cancel);
		
		log.addActionListener(this);
		cancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==log)
		{
			if(admin.isSelected()) 
			{
				if(adminValidate()) 
				{
					JOptionPane.showMessageDialog(f1,"Admin successfully logged in");
					new AdminHome();
					f1.dispose();
				}
			}
			else if(emp.isSelected()) 
			{
				if(emplyValidate())
				{
					Home.flag=1;
					new Home(); 
					f1.dispose();
				}	
			}else {
				JOptionPane.showMessageDialog(f1,"Choose account type admin or employee");
			}
			
		}
		
		if(e.getSource()==cancel)
		{
			f1.dispose();
			new Home();
		}
	}
	Boolean adminValidate() 
	{
		Boolean valid=false;
		String name,pass;
		name=namet.getText().toString();
		pass=passt.getText().toString();
		
		if(name==null||pass==null)
		{
			valid=false;
			JOptionPane.showMessageDialog(f1,"Please Fill all fields");
			return valid;
			
		}
		if(adminName.equals(name)&&adminPass.equals(pass)) {
			valid=true;
		}
		else {
			JOptionPane.showMessageDialog(f1,"Check name or password");
		}
		return valid;
	}
	
	Boolean emplyValidate()
	{
		Boolean valid=false;
		String name,pass;
		name=namet.getText().toString();
		pass=passt.getText().toString();
		if(name==null||pass==null)
		{
			valid=false;
			JOptionPane.showMessageDialog(f1,"Please Fill all fields");
			return valid;	
		}else {
			valid=true;
		}

		if(valid) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdc:oracle:thin:@Localhost:1521:xe","system","oracle");
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery("Select * from ADDEMPLY where id='"+pass+"' and name='"+name+"' ");
				Boolean b=rs.next();
				if(b)
				{
					valid=true;
				}else {
					valid=false;
					JOptionPane.showMessageDialog(f1,"Incorrect Name or Id");
					return valid;
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return valid;
	}

}
