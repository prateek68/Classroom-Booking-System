import java.util.*;
public class Courses {
	private String coursename;
	private String coursedescription;
	private ArrayList<String> postcondiitions;
	private ArrayList<String> preconditions;
	private ArrayList<Time> classTimings;
	private ArrayList<Room> classrooms;
	private Time classduration;
	// define a constructor here
	public Time getClassduration() {
		return classduration;
	}

	public void setClassduration(Time classduration) {
		this.classduration = classduration;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public ArrayList<String> getPostcondiitions() {
		return postcondiitions;
	}

	public void setPostcondiitions(ArrayList<String> postcondiitions) {
		this.postcondiitions = postcondiitions;
	}

	public ArrayList<String> getPreconditions() {
		return preconditions;
	}

	public void setPreconditions(ArrayList<String> preconditions) {
		this.preconditions = preconditions;
	}

	public ArrayList<Time> getClassTimings() {
		return classTimings;
	}

	public void setClassTimings(ArrayList<Time> classTimings) {
		this.classTimings = classTimings;
	}

	public ArrayList<Room> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(ArrayList<Room> classrooms) {
		this.classrooms = classrooms;
	}
	
	public String getCoursedescription() {
		return coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
