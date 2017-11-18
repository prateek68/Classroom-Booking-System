package APproject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Courses implements Serializable{
	private String coursename;
	private ArrayList<String> postcondiitions;
	private ArrayList<String> preconditions;
	private ArrayList<Date> class_start;
	private ArrayList<Date> class_end;
	private ArrayList<Room> classrooms;
	private String tut_day;
	private String lab_day;
	private ArrayList<Room> tut;
	private ArrayList<Room> lab;
	//6th and 7th entry is for tuts and labs respectively
	private Date classduration;
	private String type;//Mandatory or elective
	private String courseCode,Instructor,Acronym;
	private int credits;
	// define a constructor here
	Courses(String m,String name,String code,String i,String acry,String credits,ArrayList<String> pre, ArrayList<String> post){
		type=m;
		coursename=name;
		courseCode=code;
		Instructor=i;
		Acronym=acry;
		this.credits=Integer.parseInt(credits);
		classrooms=new ArrayList<Room>(7);
		class_start=new ArrayList<Date>(7);
		class_end=new ArrayList<Date>(7);
		for(int j=0;j<7;++j) {
			Date x=new Date();
			x.setDate(0);
			x.setHours(0);
			x.setYear(0);
			x.setMinutes(0);
			x.setMonth(0);
			x.setSeconds(0);
			class_start.add( x);
			x=new Date();
			x.setDate(0);
			x.setHours(0);
			x.setYear(0);
			x.setMinutes(0);
			x.setMonth(0);
			x.setSeconds(0);
			class_end.add(x);
			classrooms.add(new Room(" ",0));
			tut=new ArrayList<Room>();
			lab=new ArrayList<Room>();
		}
		this.postcondiitions=post;
		this.preconditions=pre;
	}
	public String getType() {
		return type;
	}
	public ArrayList<Date> getClass_start() {
		return class_start;
	}
	public void setClass_start(ArrayList<Date> class_start) {
		this.class_start = class_start;
	}
	public ArrayList<Date> getClass_end() {
		return class_end;
	}
	public void setClass_end(ArrayList<Date> class_end) {
		this.class_end = class_end;
	}
	public String getTut_day() {
		return tut_day;
	}
	public void setTut_day(String tut_day) {
		this.tut_day = tut_day;
	}
	public String getLab_day() {
		return lab_day;
	}
	public void setLab_day(String lab_day) {
		this.lab_day = lab_day;
	}
	public ArrayList<Room> getTut() {
		return tut;
	}
	public void setTut(ArrayList<Room> tut) {
		this.tut = tut;
	}
	public ArrayList<Room> getLab() {
		return lab;
	}
	public void setLab(ArrayList<Room> lab) {
		this.lab = lab;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getInstructor() {
		return Instructor;
	}

	public void setInstructor(String instructor) {
		Instructor = instructor;
	}

	public String getAcronym() {
		return Acronym;
	}

	public void setAcronym(String acronym) {
		Acronym = acronym;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Date getClassduration() {
		return classduration;
	}

	public void setClassduration(Date classduration) {
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

	public ArrayList<Date> getclass_start() {
		return class_start;
	}

	public void setclass_start(ArrayList<Date> classTimings) {
		this.class_start = classTimings;
	}
	
	public ArrayList<Date> getclass_end() {
		return class_end;
	}

	public void setclass_end(ArrayList<Date> classTimings) {
		this.class_end = classTimings;
	}

	public ArrayList<Room> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(ArrayList<Room> classrooms) {
		this.classrooms = classrooms;
	}

}