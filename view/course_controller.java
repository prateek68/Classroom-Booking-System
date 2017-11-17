package APproject.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import APproject.Courses;
import APproject.Main;
import APproject.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class course_controller {
	
	ObservableList<String> allcourselist=FXCollections.observableArrayList();
	ObservableList<String> mycourselist=FXCollections.observableArrayList();
	
	@FXML 
	Label user;
	
	@FXML
	Label type;
	
	@FXML
	Button add_course;
	
	@FXML
	public Button back;
	@FXML
	ComboBox<String> allcourses;
	
	@FXML
	ComboBox<String> mycourses;
	

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	public Courses getcourse(String s) {
		Courses temp2=null;
		for(int i=0;i<Main.IIITD.getCourses().size();++i) {
			if(Main.IIITD.getCourses().get(i).getCoursename().equals(s)) {
				temp2=Main.IIITD.getCourses().get(i);
			}
		}
		return temp2;
	}
	@FXML
	public void addcourses() throws IOException {
		
		if(mycourselist.size()>5)
		{
			add_course.setDisable(true);
			FXMLLoader load1=new FXMLLoader();
			load1.setLocation(Main.class.getResource("view/request_accept.fxml"));
			AnchorPane mainlayout1=load1.load();
			Scene scene1=new Scene(mainlayout1);
			Stage pe1=new Stage();
			pe1.setScene(scene1);
			pe1.setTitle("Warning");
			pe1.show();
			error_controller d=load1.getController();
			d.room.setText("More than 6 courses cannot be added!");
			return;
		}
		
		add_course.setDisable(false);
		String name=user.getText().split(": ")[1];
		Student temp=null;
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(Main.IIITD.getUsers().get(i).getCredentials().getName().equals(name)) {
				if(Main.IIITD.getUsers().get(i).getCredentials().getUserType().equals("Student")) {
					temp=(Student) Main.IIITD.getUsers().get(i);
				}
			}
		}
//		System.out.println(allcourselist.size());
//		System.out.println();
		String course_name=allcourses.getValue();
//		System.out.println("course name" + course_name);
		Courses temp2=getcourse(course_name);
		temp.getPersonalizedTimetable().getCourses().add(temp2);
		
		allcourselist.remove(allcourses.getValue());
//		System.out.println(allcourselist.size());
//		System.out.println();
		ArrayList<String> toremove=new ArrayList<String>();
		for(int i=0;i<allcourselist.size();++i) {
			String compare_to=allcourselist.get(i);
//			System.out.println(i+" " +compare_to);
			Courses compare_to_course=getcourse(compare_to);
			boolean removevalue=false;
			for(int j=0;j<5;++j) {
				Date d1=compare_to_course.getClass_start().get(j);
				Date d2=compare_to_course.getClass_end().get(j);
				Date d3=temp2.getClass_start().get(j);
				Date d4=temp2.getClass_end().get(j);
				d1.setSeconds(5);
				d2.setSeconds(0);
				d3.setSeconds(5);
				d4.setSeconds(0);
//				if(compare_to.equals("Introduction to Media in Society : A Public Sphere Approach")) {
//					System.out.println(j);
//					System.out.println(d1);
//					System.out.println(d2);
//					System.out.println(d3);
//					System.out.println(d4);
//				}
				if(d2.before(d3)||d4.before(d1)) {
				}
				else {
					removevalue=true;
					continue;
				}
			}
			
			if((temp2.getTut_day()!=null && compare_to_course.getTut_day()!=null) &&
					temp2.getTut_day().equals(compare_to_course.getTut_day())){
				Date d1=compare_to_course.getClass_start().get(5);
				Date d2=compare_to_course.getClass_end().get(5);
				Date d3=temp2.getClass_start().get(5);
				Date d4=temp2.getClass_end().get(5);
				d1.setSeconds(5);
				d2.setSeconds(0);
				d3.setSeconds(5);
				d4.setSeconds(0);
				if(d2.before(d3)||d4.before(d1)) {
				}
				else {
					removevalue=true;
					continue;
					
				}
			}
			if((temp2.getLab_day()!=null && compare_to_course.getLab_day()!=null) &&
					temp2.getLab_day().equals(compare_to_course.getLab_day())){
				Date d1=compare_to_course.getClass_start().get(6);
				Date d2=compare_to_course.getClass_end().get(6);
				Date d3=temp2.getClass_start().get(6);
				Date d4=temp2.getClass_end().get(6);
				d1.setSeconds(5);
				d2.setSeconds(0);
				d3.setSeconds(5);
				d4.setSeconds(0);
				if(d2.before(d3)||d4.before(d1)) {
				}
				else {
					removevalue=true;
					continue;
				}
			}
			
//			compare_to_course.get
			if(removevalue==true) {
				toremove.add(compare_to);
			}
		}
		
//		System.out.println("To remove Courses");
		for(int i=0;i<toremove.size();++i) {
//			System.out.println(toremove.get(i));
			allcourselist.remove(toremove.get(i));
		}
		mycourselist=FXCollections.observableArrayList();
		for(int j=0;j<temp.getPersonalizedTimetable().getCourses().size();j++)
		{
			mycourselist.add(temp.getPersonalizedTimetable().getCourses().get(j).getCoursename());
		}
		mycourses.setItems(mycourselist);
		allcourses.setValue(null);
		mycourses.setValue(null);
	}
	public boolean contains(String s) {
		for(int i=0;i<allcourselist.size();++i) {
			if(allcourselist.get(i).equals(s)) {
				return true;
			}
		}
		return false;
	}
	@FXML
	public void remove()
	{
		String name=user.getText().split(": ")[1];
		Student temp=null;
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(Main.IIITD.getUsers().get(i).getCredentials().getName().equals(name)) {
				if(Main.IIITD.getUsers().get(i).getCredentials().getUserType().equals("Student")) {
					temp=(Student) Main.IIITD.getUsers().get(i);
				}
			}
		}
		
		Courses temp2=null;
		String course_name=mycourses.getValue();
		for(int i=0;i<temp.getPersonalizedTimetable().getCourses().size();++i) {
			if(temp.getPersonalizedTimetable().getCourses().get(i).getCoursename().equals(course_name)) {
				temp2=temp.getPersonalizedTimetable().getCourses().get(i);
			}
		}
		temp.getPersonalizedTimetable().getCourses().remove(temp2);
		
//		allcourselist.add(mycourses.getValue());
		mycourselist.remove(mycourses.getValue());
		allcourselist=FXCollections.observableArrayList();
		for(int i=0;i<Main.IIITD.getCourses().size();i++)
		{
			if(!hascourse(Main.IIITD.getCourses().get(i).getCoursename()) && !check_clash(Main.IIITD.getCourses().get(i).getCoursename())) {
				allcourselist.add(Main.IIITD.getCourses().get(i).getCoursename());
			}
			
		}
		
		
		allcourses.setItems(allcourselist);
		mycourses.setItems(mycourselist);
		
		allcourses.setValue(null);
		mycourses.setValue(null);
		
		if(mycourselist.size()<6)
		{
			add_course.setDisable(false);
		}
	}
	
	public boolean hascourse(String course_name) {
		boolean t=false;
		String name=login_controller.namee;
		Student temp=null;
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(Main.IIITD.getUsers().get(i).getCredentials().getName().equals(name)) {
				if(Main.IIITD.getUsers().get(i).getCredentials().getUserType().equals("Student")) {
					temp=(Student) Main.IIITD.getUsers().get(i);
				}
			}
		}
		
		for(int i=0;i<temp.getPersonalizedTimetable().getCourses().size();++i) {
			if(temp.getPersonalizedTimetable().getCourses().get(i).getCoursename().equals(course_name)) {
				t=true;
			}
		}
		return t;
	}
	public boolean check_clash(String s) {
		boolean clash=false;
		
		String name=login_controller.namee;
		Student temp=null;
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(Main.IIITD.getUsers().get(i).getCredentials().getName().equals(name)) {
				if(Main.IIITD.getUsers().get(i).getCredentials().getUserType().equals("Student")) {
					temp=(Student) Main.IIITD.getUsers().get(i);
				}
			}
		}
		
		Courses temp2=null;
		String course_name=s;
		for(int i=0;i<Main.IIITD.getCourses().size();++i) {
			if(Main.IIITD.getCourses().get(i).getCoursename().equals(course_name)) {
				temp2=Main.IIITD.getCourses().get(i);
			}
		}
		
		for(int i=0;i<temp.getPersonalizedTimetable().getCourses().size();++i) {
				for(int j=0;j<5;++j) {
					Date d1=temp.getPersonalizedTimetable().getCourses().get(i).getClass_start().get(j);
					Date d2=temp.getPersonalizedTimetable().getCourses().get(i).getClass_end().get(j);
					Date d3=temp2.getClass_start().get(j);
					Date d4=temp2.getClass_end().get(j);
					d1.setSeconds(5);
					d2.setSeconds(0);
					d3.setSeconds(5);
					d4.setSeconds(0);
					if(d2.before(d3)||d4.before(d1)) {
					}
					else {
						return true;
					}
				}
				if((temp2.getTut_day()!=null && temp.getPersonalizedTimetable().getCourses().get(i).getTut_day()!=null) &&
						temp2.getTut_day().equals(Main.IIITD.getCourses().get(i).getTut_day())){
					Date d1=temp.getPersonalizedTimetable().getCourses().get(i).getClass_start().get(5);
					Date d2=temp.getPersonalizedTimetable().getCourses().get(i).getClass_end().get(5);
					Date d3=temp2.getClass_start().get(5);
					Date d4=temp2.getClass_end().get(5);
					d1.setSeconds(5);
					d2.setSeconds(0);
					d3.setSeconds(5);
					d4.setSeconds(0);
					if(d2.before(d3)||d4.before(d1)) {
					}
					else {
						return true;
					}
				}
				if((temp2.getLab_day()!=null && temp.getPersonalizedTimetable().getCourses().get(i).getLab_day()!=null) &&
						temp2.getLab_day().equals(Main.IIITD.getCourses().get(i).getLab_day())){
					Date d1=temp.getPersonalizedTimetable().getCourses().get(i).getClass_start().get(6);
					Date d2=temp.getPersonalizedTimetable().getCourses().get(i).getClass_end().get(6);
					Date d3=temp2.getClass_start().get(6);
					Date d4=temp2.getClass_end().get(6);
					d1.setSeconds(5);
					d2.setSeconds(0);
					d3.setSeconds(5);
					d4.setSeconds(0);
					if(d2.before(d3)||d4.before(d1)) {
					}
					else {
						return true;
					}
				}
			
		}
		return false;
	}
	@FXML
	private void initialize()
	{
		for(int i=0;i<Main.IIITD.getCourses().size();i++)
		{
			if(!hascourse(Main.IIITD.getCourses().get(i).getCoursename()) && !check_clash(Main.IIITD.getCourses().get(i).getCoursename())) {
				allcourselist.add(Main.IIITD.getCourses().get(i).getCoursename());
			}
			
		}
		allcourses.setItems(allcourselist);
		String name=login_controller.namee;
		Student temp=null;
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(Main.IIITD.getUsers().get(i).getCredentials().getName().equals(name)) {
				if(Main.IIITD.getUsers().get(i).getCredentials().getUserType().equals("Student")) {
					temp=(Student) Main.IIITD.getUsers().get(i);
				}
			}
		}
		
		for(int j=0;j<temp.getPersonalizedTimetable().getCourses().size();j++)
		{
			mycourselist.add(temp.getPersonalizedTimetable().getCourses().get(j).getCoursename());
		}
		mycourses.setItems(mycourselist);
		if(mycourselist.size()>5)
		{
			add_course.setDisable(true);
		}
	}
}
