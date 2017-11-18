package APproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import com.csvreader.CsvReader;

/**
 * Management knows everything about the all the rooms, all courses , all users i.e.  all Admins,
 * all Faculty members and all students, it also has the information about all the Booked rooms.
 *@author Prateek and Vaibhav
 */
public class Management implements Serializable{
	private ArrayList<Room> rooms;
	private ArrayList<Courses> courses;
	private ArrayList<Person> users;
	private ArrayList<Booked_rooms> bookedrooms;
	/**
	 * Constructor to instantiate the object of class Management
	 */
	Management(){
		rooms=new ArrayList<Room>();
		courses=new ArrayList<Courses>();
		users=new ArrayList<Person>();
		bookedrooms=new ArrayList<Booked_rooms>();
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public ArrayList<Courses> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Courses> courses) {
		this.courses = courses;
	}
	public ArrayList<Person> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<Person> users) {
		this.users = users;
	}
	public Room getRoom(String s) {
		Iterator<Room> it=rooms.iterator();
		while(it.hasNext()) {
			Room temp=it.next();
			if(temp.getName().equals(s)) {
				return temp;
			}
		}
		return null;
	}
	public ArrayList<Booked_rooms> getBookedrooms() {
		return bookedrooms;
	}
	public void setBookedrooms(ArrayList<Booked_rooms> bookedrooms) {
		this.bookedrooms = bookedrooms;
	}
	public int get_day(String s) {
		if(s.equals("Monday")) {
			return 0;
		}
		else if(s.equals("Tuesday")) {
			return 1;
		}
		else if(s.equals("Wednesday")) {
			return 2;
		}
		else if(s.equals("Thursday")) {
			return 3;
		}
		else if(s.equals("Friday")) {
			return 4;
		}
		else if(s.equals("Saturday")) {
			return 5;
		}
		else if(s.equals("Sunday")) {
			return 6;
		}
		return -1;
	}
	public void deserialize() {
				
		try {
			CsvReader inputroom=new CsvReader("C:\\Users\\Vaibhav\\Desktop\\room.csv");
			inputroom.readHeaders();
			while(inputroom.readRecord()) {
				rooms.add(new Room(inputroom.get(0),Integer.parseInt(inputroom.get(1))));
			}
			inputroom.close();
		}
		catch(Exception e) {
			System.out.println("Room error");
		}
//		try {
//			CsvReader inputrequest=new CsvReader("C:\\Users\\prateekjain\\Desktop\\Request.csv");
//			inputrequest.readHeaders();
//			while(inputrequest.readRecord()) {
//				Admin.add(new Request(inputrequest.get(0),inputrequest.get(1),getRoom(inputrequest.get(2)),
//						Integer.parseInt(inputrequest.get(3)),inputrequest.get(4),inputrequest.get(5),
//						inputrequest.get(6),inputrequest.get(7),inputrequest.get(8)));
//			}
//			inputrequest.close();
//		}
//		catch(Exception e) {
//			System.out.println("request error");
//			e.printStackTrace();
//		}
		try {
			CsvReader inputcourse=new CsvReader("C:\\Users\\Vaibhav\\Desktop\\courses.csv");
			inputcourse.readHeaders();
			while(inputcourse.readRecord()) {
				String m_e=inputcourse.get(0);
				String c_n=inputcourse.get(1);
				String c_c=inputcourse.get(2);
				String i=inputcourse.get(3);
				String c=inputcourse.get(4);
				String acry=inputcourse.get(5);
				String[] time=new String[7];
				time[0]=inputcourse.get(6);
				time[1]=inputcourse.get(7);
				time[2]=inputcourse.get(8);
				time[3]=inputcourse.get(9);
				time[4]=inputcourse.get(10);
				time[5]=inputcourse.get(11);//tut
				time[6]=inputcourse.get(12);//lab
				String pre=inputcourse.get(13);
				String post=inputcourse.get(14);
				ArrayList<String> pre_list=new ArrayList(Arrays.asList(pre.split("\n")));
				ArrayList<String> post_list=new ArrayList(Arrays.asList(post.split("\n")));
//				System.out.println(c_n + "  " + c);
				Courses temp=new Courses(m_e,c_n,c_c,i,acry,c,pre_list,post_list);
//				System.out.println(temp.getclass_start().size());
				// i have to set time of classes and their venues
				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				for(int j=0;j<5;++j) {
					if(time[j].equals("")) {
						continue;
					}
					String[] s1=time[j].split("\\$");
//					System.out.println(s1[0]);
					String[] s2=s1[0].split("-");
//					System.out.println("date");
//					System.out.println(s2[0]);
//					
//					System.out.println(s2[1]);
//					
					Date start=sdf.parse(s2[0]+":00");
					Date end=sdf.parse(s2[1]+":00");
//					System.out.println(j);
					temp.getclass_start().set(j, start);
					temp.getclass_end().set(j, end);
					Room room=getRoom(s1[1]);
					room.getStart_time().get(j);
					room.getStart_time().get(j).add(start);
					room.getEnd_time().get(j).add(end);
					temp.getClassrooms().set(j, room);
					
				}
				if(!time[5].equals("")) {
					String[] s1=time[5].split("\\$");
					temp.setTut_day(s1[0]);
					
					String[] s2=s1[1].split("-");
					Date start=sdf.parse(s2[0]+":00");
					Date end=sdf.parse(s2[1]+":00");
					temp.getclass_start().set(5, start);
					temp.getclass_end().set(5, end);
					String[] s3=s1[2].split(";");
					String[] s4=s3[s3.length-1].split(" ");
					for(int j=0;j<s3.length-1;++j) {
						Room room=getRoom(s3[j]);
						room.getStart_time().get(j).add(start);
						room.getEnd_time().get(j).add(end);
						temp.getTut().add(room);
					}
					Room room=getRoom(s4[0]);
					temp.getTut().add(getRoom(s4[0]));
				}
				
				if(!time[6].equals("")) {
					String[] s1=time[6].split("\\$");
					temp.setLab_day(s1[0].split(" ")[0]);
					String[] s2=s1[1].split("-");
					Date start=sdf.parse(s2[0]+":00");
					Date end=sdf.parse(s2[1]+":00");
					temp.getclass_start().set(6, start);
					temp.getclass_end().set(6, end);
					
					String[] s3=s1[2].split(";");
					for(int j=0;j<s3.length;++j) {
						Room room=getRoom(s3[j]);
						room.getStart_time().get(j).add(start);
						room.getEnd_time().get(j).add(end);
						temp.getLab().add(room);
					}
				}
				// add preconditions and postconditions
				String[] pre_a=pre.split("\n");
				courses.add(temp);
			}
			inputcourse.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("course error1");
		}
		catch(ParseException e) {
			System.out.println("course error2");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("course error3");
		}
		try {
			CsvReader inputusers=new CsvReader("C:\\Users\\Vaibhav\\Desktop\\users.csv");
			inputusers.readHeaders();
			while(inputusers.readRecord()) {
				String n=inputusers.get(0);
				String e=inputusers.get(1);
				String p=inputusers.get(2);
				String t=inputusers.get(3);
				if(t.equals("Student")) {
					Student temp=new Student(n,e,p,t);
					users.add(temp);
				}
				else if(t.equals("Faculty")) {
					Faculty temp=new Faculty(n,e,p,t);
					users.add(temp);
					//inform about rooms
				}
				else if(t.equals("Admin")) {
					Admin temp=new Admin(n,e,p,t);
					users.add(temp);
					//inform about rooms and requests
				}
			}
			inputusers.close();
		}
		catch(Exception e) {
			System.out.println("Users error");
		}
		
	}
	public static void serialize() {
		
	}
}