package APproject;

import java.io.Serializable;
import java.util.ArrayList;

public class TimeTable implements Serializable{
	private ArrayList<Courses> courses;
	public TimeTable(){
		courses=new ArrayList<Courses>();
	}
	public ArrayList<Courses> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Courses> courses) {
		this.courses = courses;
	}
}
