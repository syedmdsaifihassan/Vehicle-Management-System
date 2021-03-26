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
public class Work implements ActionListener 
{
	JFrame f9;
	JLabel idl;
	JTextField idt;
	JButton add,cancel;
	String status="Request Placed";
	String idtext;
	Work()
	{
		f9=new JFrame(Home.key);
		try {
			f9.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/loginbk.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f9.setSize(300,400);
		f9.setResizable(false);
		f9.pack();
		f9.setVisible(true);
		
		Font font1 = new Font("Arial", Font.BOLD,25);
		
		idl=new JLabel("Enter User ID to place work request");
		idl.setBounds(400,150,450,40);
		idl.setForeground(Color.BLACK);
		idl.setFont(font1);
		
		idt=new JTextField();
		idt.setBounds(450,200,330,40);
		
		try {
			add=new JButton("Add",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/ok.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		add.setBounds(450,250,155,50);
		add.setForeground(Color.decode("#0F5DA6"));
		
		try {
			cancel=new JButton("Cancel",new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/clear.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cancel.setBounds(625,250,155,50);
		cancel.setForeground(Color.decode("#0F5DA6"));
		
		
		f9.add(idl);
		f9.add(idt);
		f9.add(add);
		f9.add(cancel);
		
		add.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add)
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
					st.executeUpdate("Insert into ADDWORK values('"+idtext+"','"+Home.key+"','"+status+"')");
					JOptionPane.showMessageDialog(f9,Home.key+" request placed!");
				}else {
					JOptionPane.showMessageDialog(f9,"Incorrect ID! Add user first to place work request");
				}
			}catch(Exception excep)
			{
				excep.printStackTrace();
			}
			f9.dispose();
			new Home();
		}
	}

});
		cancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==cancel)
		{
			f9.dispose();
			new Home();
		}
		
	}

}
