package APproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A timetable object is used to store the information of all the courses.
 * Courses tells us the time of the classes and thus we can get the timetable
 *
 *In order to get the personalized timetable we just need to add the courses of that student and
 *we will be bale to generate the timetable of that student
 *@author Prateek and Vaibhav
 */
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
