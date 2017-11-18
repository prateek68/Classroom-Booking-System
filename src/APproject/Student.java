package APproject;

import java.util.ArrayList;
/**
 *Student class extends Person and is used to create a Student who can check available rooms at a particular
 *time slot and then can make a request for a room. A student can also check and view the Timetable and 
 *also personalized timetable. A student can also add a maximum of six courses and then remove an unwanted
 *course. A student can also search courses on the basis of some keywords.
 *@author Prateek and Vaibhav 
 */
public class Student extends Person{
	private TimeTable personalizedTimetable;
	/**
	 * @param n
	 * Denotes the name of the Student
	 * @param e
	 * Denotes the EmailID of the Student
	 * @param p
	 * Denotes the Password of the Student
	 * @param t
	 * Denotes the Type of the Student
	 * 
	 * Constructor function to generate Student Object with parameters n,e,p,t
	 */
	public Student(String n,String e,String p,String t){
		super();
		credentials.setEmailId(e);
		credentials.setName(n);
		credentials.setPassword(p);
		credentials.setUserType(t);
		personalizedTimetable=new TimeTable();
	}
	public TimeTable getPersonalizedTimetable() {
		return personalizedTimetable;
	}
	public void setPersonalizedTimetable(TimeTable personalizedTimetable) {
		this.personalizedTimetable = personalizedTimetable;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Courses> searchcourses(ArrayList<String> keywords){
		return null;
		
	}
}