import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Student_page extends JFrame {
	Student_page(){
		JFrame frame=new JFrame("Classroom Booking System");
		frame.setSize(800,600);
		Border border=BorderFactory.createLineBorder(Color.black);
		JLabel user=new JLabel("Username: ");
		user.setFont(new Font("Serif",0,17));
		user.setBounds(575,20,300,30);
		JLabel type=new JLabel("Type: ");
		type.setFont(new Font("Serif",0,17));
		type.setBounds(575,35,300,30);
		TextField search_box=new TextField();
		search_box.setText("Search your Course here");
		search_box.setBounds(20, 20, 400, 60);
		JButton[] buttons = new JButton[6];
		buttons[0] =new JButton("View Room Status");
		buttons[0].setBounds(50, 110, 200, 60);
		buttons[0].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame Room_Status=new JFrame("Classroom Booking System");
				Room_Status.setSize(800,600);
				JLabel user=new JLabel("Username: ");
				user.setFont(new Font("Serif",0,17));
				user.setBounds(575,20,300,30);
				JLabel type=new JLabel("Type: ");
				type.setFont(new Font("Serif",0,17));
				type.setBounds(575,35,300,30);
				JLabel title=new JLabel("Room Availability",SwingConstants.CENTER);
				title.setFont(new Font("Serif",Font.BOLD,40));
				title.setBounds(125,10,550,80);
				
				TextField room_number=new TextField();
				room_number.setText("Enter Room Number Here");
				room_number.setBounds(20, 150, 300, 60);
				
				JLabel status=new JLabel();
				status.setBounds(500, 150, 200, 60);
				status.setText("Room Status");
				
				JButton go=new JButton("Get Status");
				go.setBounds(125, 250, 200, 60);
				go.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						status.setText("Update the room Status");
					}
				}
				);
				JButton back=new JButton("Back");
				back.setBounds(125, 350, 200, 60);
				back.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Room_Status.dispose();
					}
				}
				);
				Room_Status.add(title);
				Room_Status.add(user);
				Room_Status.add(type);
				Room_Status.add(back);
				Room_Status.add(go);
				Room_Status.add(status);
				Room_Status.add(room_number);
				Room_Status.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Room_Status.setLayout(null);
				Room_Status.setVisible(true);
				
			}
		}
		);
		buttons[1]=new JButton("Request");
		buttons[1].setBounds(50,200,200,60);
		buttons[1].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame Request=new JFrame("Classroom Booking System");
				Request.setSize(800,600);
				JLabel user=new JLabel("Username: ");
				user.setFont(new Font("Serif",0,17));
				user.setBounds(575,20,300,30);
				JLabel type=new JLabel("Type: ");
				type.setFont(new Font("Serif",0,17));
				type.setBounds(575,35,300,30);
				JLabel title=new JLabel("Requests",SwingConstants.CENTER);
				title.setFont(new Font("Serif",Font.BOLD,40));
				title.setBounds(125,60,550,80);
				
				JButton new_request=new JButton("Make new request");
				new_request.setBounds(20, 200, 200, 60);
				new_request.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				}
				);
				JButton cancel_request=new JButton("Cancel existing requests");
				cancel_request.setBounds(20, 300, 200, 60);
				cancel_request.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				}
				);
				JButton back=new JButton("Back");
				back.setBounds(125, 450, 200, 60);
				back.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Request.dispose();
					}
				}
				);
				Request.add(title);
				Request.add(user);
				Request.add(type);
				Request.add(back);
				Request.add(new_request);
				Request.add(cancel_request);
				Request.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Request.setLayout(null);
				Request.setVisible(true);
			}
		}
		);
		buttons[2]=new JButton("OK");
		buttons[2].setBounds(410, 20, 100, 60);
		buttons[2].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		buttons[3]=new JButton("View Timetable");
		buttons[3].setBounds(50,290,200,60);
		buttons[3].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		buttons[4]=new JButton("View Personalized Timetable");
		buttons[4].setBounds(50,380,200,60);
		buttons[4].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		buttons[5]=new JButton("Edit Course");
		buttons[5].setBounds(50,470,200,60);
		buttons[5].addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame Course=new JFrame("Classroom Booking System");
				Course.setSize(800,600);
				JLabel user=new JLabel("Username: ");
				user.setFont(new Font("Serif",0,17));
				user.setBounds(575,20,300,30);
				JLabel type=new JLabel("Type: ");
				type.setFont(new Font("Serif",0,17));
				type.setBounds(575,35,300,30);
				JLabel title=new JLabel("Courses",SwingConstants.CENTER);
				title.setFont(new Font("Serif",Font.BOLD,40));
				title.setBounds(125,60,550,80);
				JLabel l1=new JLabel("Enter course name :",SwingConstants.CENTER);
				l1.setBounds(20, 150, 300, 60);
				TextField course_name=new TextField();
				course_name.setBounds(450, 150, 200, 60);
				course_name.setText("Enter Course name here.");
				
				JButton add=new JButton("Add Course");
				add.setBounds(20, 250, 200, 60);
				add.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				}
				);
				JButton del=new JButton("Delete Course");
				del.setBounds(20, 350, 200, 60);
				del.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				}
				);
				JButton back=new JButton("Back");
				back.setBounds(125, 450, 200, 60);
				back.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Course.dispose();
					}
				}
				);
				Course.add(title);
				Course.add(user);
				Course.add(type);
				Course.add(back);
				Course.add(add);
				Course.add(del);
				Course.add(l1);
				Course.add(course_name);
				Course.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Course.setLayout(null);
				Course.setVisible(true);

			}
		}
		);
		
		frame.add(search_box);
		frame.add(user);
		frame.add(type);
		frame.add(buttons[0]);
		frame.add(buttons[1]);
		frame.add(buttons[2]);
		frame.add(buttons[3]);
		frame.add(buttons[4]);
		frame.add(buttons[5]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Student_page();
	}

}
