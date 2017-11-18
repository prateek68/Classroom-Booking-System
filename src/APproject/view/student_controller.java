package APproject.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import APproject.Courses;
import APproject.Main;
import APproject.Person;
import APproject.Student;
import APproject.courses_view;


/**
 * A class that creates a GUI page that enables the functionalities of a student
 *@author Prateek and Vaibhav
 */
public class student_controller {

	ArrayList<String> final_courses=new ArrayList<String>();
	static ArrayList<Courses> fcourse=new ArrayList<Courses>();
	
	@FXML
	TableView<String> courses_out;
	
	@FXML	
	TextField search;
	
	@FXML 
	Label user;
	
	@FXML
	Label type;
	
	@FXML
	public Button logout;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) logout.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * @throws IOException
	 * a function to check room availability
	 */
	@FXML
	private void room() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/Student_room_status.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		check_room_availability c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
	/**
	 * @throws IOException
	 * A function to search courses
	 */
	@FXML
	public void search_courses() throws IOException
	{
		String[] conditions=search.getText().split(" ");
		ArrayList<Courses> x=Main.IIITD.getCourses();
		fcourse=new ArrayList<Courses>();
		for(int i=0;i<conditions.length;i++)
		{
			for(int j=0;j<x.size();j++)
			{
				ArrayList<String> y=x.get(j).getPostcondiitions();
				for(int k=0;k<y.size();k++)
				{
					int flag=0;
					String[] course_cond=y.get(k).split(" ");
					for(int l=0;l<course_cond.length;l++)
					{
						if(conditions[i].equals(course_cond[l]))
						{
							final_courses.add(x.get(j).getCoursename());
							fcourse.add(x.get(j));
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
			}
		}
		//compare the above courses with the courses of the student and then use them
		//some how get a student
		String name=user.getText().split(": ")[1];
		Student temp=null;
		Iterator<Person> it=Main.IIITD.getUsers().iterator();
		while(it.hasNext()) {
			Person person=it.next();
			if(person.getCredentials().getUserType().equals("Student")) {
				if(person.getCredentials().getName().equals(name)) {
					temp=(Student) person;
				}
			}
		}
		//compare
		for(int k=0;k<fcourse.size();++k) {
			Courses comp=fcourse.get(k);
			Iterator<Courses> it2=temp.getPersonalizedTimetable().getCourses().iterator();
			while(it2.hasNext()) {
				Courses comp2=it2.next();
				for(int z=0;z<7;++z) {
					if(comp2.getClass_start().get(z)!=null) {
						if(comp.getClass_start().get(z)!=null) {
							if(comp.getClass_end().get(z).before(comp2.getClass_start().get(z)) ||
									comp2.getClass_end().get(z).before(comp.getClass_start().get(z))) {
								continue;
							}
							else {
								fcourse.remove(comp);
							}
						}
					}
				}
			}
		}
		final_courses=new ArrayList<String>();
		for(int k=0;k<fcourse.size();++k) {
			final_courses.add(fcourse.get(k).getCoursename());
	//		System.out.println(fcourse.get(k).getCoursename());
		}
		
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/search_display.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		search_page_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
		search.setText(null);
	//	for(int q=0;q<fcourse.size();q++)
		//{
			//c.cour.add(new courses_view(fcourse.get(q).getCoursename(),fcourse.get(q).getCourseCode()));
	//	}
		
	}
	
	/**
	 * @throws IOException
	 * A function to view all requests or cancel an existing request
	 */
	@FXML
	private void reques() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/all_request page.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		all_request_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
	
	
	/**
	 * @throws IOException
	 * A function to add or remove courses
	 */
	@FXML
	private void course() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/Course_page.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		course_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
	/**
	 * @throws IOException
	 * A function to view the general timetable
	 */
	@FXML
	private void view_time() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/view_timetable.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		timetable_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
	/**
	 * @throws IOException
	 * A function to view the personalized timetable of the student
	 */
	@FXML
	private void view_person_time() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/personalized_timetable.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		personalized_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
	@FXML
	private void initialize()	
	{
		user.setText("Username: "+Main.username);
	}
	
	
}
