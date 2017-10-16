import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class login_page extends JFrame{
	login_page()
	{
		JFrame frame=new JFrame("Classroom Booking System");
		frame.setSize(800,600);
		Border border=BorderFactory.createLineBorder(Color.black);
		JLabel title1=new JLabel("Welcome to IIITD Classroom",SwingConstants.CENTER);
		JLabel title2=new JLabel("Booking System",SwingConstants.CENTER);
		title1.setFont(new Font("Serif",Font.BOLD,40));
		title1.setBounds(125,10,550,80);
		title2.setFont(new Font("Serif",Font.BOLD,40));
		title2.setBounds(125,53,550,80);
		JLabel non_member_title=new JLabel("Not a Member? Sign Up!");
		JLabel member_title=new JLabel("Already a Member? Sign In!");
		non_member_title.setFont(new Font("Serif",0,26));
		non_member_title.setBounds(50,125,300,80);
		member_title.setFont(new Font("Serif",0,26));
		member_title.setBounds(450,125,800,80);
		final JTextField[] login=new JTextField[6];
		login[0]=new JTextField("Username");
		login[0].setBounds(50,200,275,26);
		login[1]=new JTextField("Type of User");
		login[1].setBounds(50,275,275,26);
		login[2]=new JTextField("Password");
		login[2].setBounds(50,350,275,26);
		login[3]=new JTextField("Username");
		login[3].setBounds(450,200,275,26);
		login[4]=new JTextField("Type of User");
		login[4].setBounds(450,275,275,26);
		login[5]=new JTextField("Password");
		login[5].setBounds(450,350,275,26);
		JButton[] button=new JButton[2];
		button[0]=new JButton("Sign Up");
		button[0].setBounds(225,400,100,30);
		button[1]=new JButton("Log In");
		button[1].setBounds(625,400,100,30);
		button[0].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		button[1].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		frame.add(title1);
		frame.add(title2);
		frame.add(non_member_title);
		frame.add(member_title);
		for(int i=0;i<6;i++)
			frame.add(login[i]);
		for(int i=0;i<2;i++)
			frame.add(button[i]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login_page a=new login_page();
	}

}
