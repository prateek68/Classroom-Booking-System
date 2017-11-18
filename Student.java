package APproject;

import java.util.ArrayList;

public class Student extends Person{
	private TimeTable personalizedTimetable;
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