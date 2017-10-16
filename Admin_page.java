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
public class Admin_page extends JFrame{

	Admin_page()
	{
		JFrame frame=new JFrame("Classroom Booking System");
		frame.setSize(800,600);
		Border border=BorderFactory.createLineBorder(Color.black);
		JLabel user=new JLabel("Username: ");
		user.setFont(new Font("Serif",0,17));
		user.setBounds(575,20,300,30);
		JLabel type=new JLabel("Type: ");
		type.setFont(new Font("Serif",0,17));
		type.setBounds(575,35,300,30);
		JButton[] button=new JButton[2];
		button[0]=new JButton("View Requests");
		button[0].setBounds(50,200,200,60);
		button[1]=new JButton("View Timetable");
		button[1].setBounds(50,310,200,60);
		button[0].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				final JFrame request=new JFrame("Classroom Booking System");
				request.setSize(800,600);
				JLabel user=new JLabel("Username: ");
				user.setFont(new Font("Serif",0,17));
				user.setBounds(575,20,300,30);
				JLabel type=new JLabel("Type: ");
				type.setFont(new Font("Serif",0,17));
				type.setBounds(575,35,300,30);
				JLabel title=new JLabel("All Requests",SwingConstants.CENTER);
				title.setFont(new Font("Serif",Font.BOLD,40));
				title.setBounds(125,10,550,80);
				JButton accept=new JButton("Accept");
				accept.setBounds(50,200,200,60);
				accept.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
					request.dispose();
					}
				}
				);
				JButton reject=new JButton("Reject");
				reject.setBounds(50,310,200,60);
				request.add(title);
				request.add(accept);
				request.add(reject);
				request.add(user);
				request.add(type);
				request.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				request.setLayout(null);
				request.setVisible(true);
				
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
		frame.add(user);
		frame.add(type);
		frame.add(button[0]);
		frame.add(button[1]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin_page a=new Admin_page();
	}

}
