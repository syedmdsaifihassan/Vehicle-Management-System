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
public class DeleteEmply implements ActionListener  
{
	JFrame f5;
	JButton search,cancel;
	JLabel idl;
	JTextField idt;
	String idtext;
	DeleteEmply()
	{
		f5=new JFrame("Delete Employee");
		try {
			f5.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Md Irshad/eclipse-workspace/Vehicle Management System/src/images/adminback-1.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f5.setSize(400,400);
		f5.setResizable(false);
		f5.pack();
		f5.setVisible(true);
		
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
		
		
		f5.add(idl);
		f5.add(idt);
		f5.add(search);
		f5.add(cancel);
		
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
				st.executeUpdate("DELETE ADDEMPLY where id='"+idtext+"' ");
				JOptionPane.showMessageDialog(f5,"Deleted");
				f5.dispose();
				new AdminHome();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		if(e.getSource()==cancel)
		{
			f5.dispose();
			new AdminHome();
		}
	}

}
