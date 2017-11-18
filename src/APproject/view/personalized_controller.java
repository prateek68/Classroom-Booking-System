package APproject.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import APproject.Courses;
import APproject.Main;
import APproject.Student;
import APproject.courses_view;
import APproject.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * An adapter class that display a student's personalized timetables based on his/her courses
 *@author  Prateek and Vaibhav
 */
public class personalized_controller {
	ObservableList<courses_view> cour=FXCollections.observableArrayList();
	
	@FXML
	Label user;
	@FXML
	Label type;
	
	@FXML
	public Button back;
	
	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	TableView<courses_view> rooms;
	@FXML
	TableColumn<courses_view,String> Mandatory;
	@FXML
	TableColumn<courses_view,String> Name;
	@FXML
	TableColumn<courses_view,String> Code;
	@FXML
	TableColumn<courses_view,String> Instructor;
	@FXML
	TableColumn<courses_view,String> Credits;
	@FXML
	TableColumn<courses_view,String> Acronym;
	@FXML
	TableColumn<courses_view,String> monday;
	@FXML
	TableColumn<courses_view,String> tuesday;
	@FXML
	TableColumn<courses_view,String> wednesday;
	@FXML
	TableColumn<courses_view,String> thursday;
	@FXML
	TableColumn<courses_view,String> friday;
	@FXML
	TableColumn<courses_view,String> tut;
	@FXML
	TableColumn<courses_view,String> lab;
	
	/**
	 * @param s
	 * Date type object that has the time when a course lecture will begin
	 * @param e
	 * Date type object that has the time when a course lecture will end
	 * @param str
	 * String that stores the venue of the course lecture
	 * @return
	 * returns a string in the following format "HH1:mm1-HH2:mm2/Venue" where
	 * HH1 and mm1 are the class start timings and HH2 and mm2 are the timings at which the class ends
	 */
	public String gettime(Date s, Date e,String str) {
		if(s.getHours()==0 && s.getMinutes()==0) {
			return " ";
		}
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
		return sdf.format(s)+"-"+sdf.format(e)+"/"+str;
	}
	/**
	 * @param s
	 * Date type object that has the time when a course lab/tut will begin
	 * @param e
	 * Date type object that has the time when a course lab/tut will end
	 * @param str
	 * String that stores the day of week when the course lab/tut is scheduled
	 * @param rooms
	 * An ArrayList of type rooms that stores the all the venue of lab/tut
	 * @return
	 * returns a string in the following format 
	 * "Day_of_week :/HH1:mm1-HH2:mm2/Venue1;venue2...;venueK"
	 * where HH1 and mm1 are the lab/tut start timings and HH2 and mm2 are the timings at 
	 * which the lab/tut ends and venueK is the kth venue of the lab/tut
	 */
	public String gettime2(Date s,Date e,String str, ArrayList<Room> rooms) {
		if(str==null) {
			return " ";
		}
		String r=str+" :/";
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
		r=r+sdf.format(s)+"-"+sdf.format(e)+"/";
		for(int i=0;i<rooms.size()-1;++i) {
			r+=rooms.get(i).getName()+";";
		}
		r+=rooms.get(rooms.size()-1).getName();
		return r;
		
	}
	/**
	 * Initialises the page and display students personalized timetable
	 */
	@FXML
	private void initialize()
	{
		String name=login_controller.namee;
		Student temp=null;
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(Main.IIITD.getUsers().get(i).getCredentials().getName().equals(name)) {
				if(Main.IIITD.getUsers().get(i).getCredentials().getUserType().equals("Student")) {
					temp=(Student) Main.IIITD.getUsers().get(i);
				}
			}
		}
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
		for(int j=0;j<temp.getPersonalizedTimetable().getCourses().size();j++)
		{
			
			Courses temp1=temp.getPersonalizedTimetable().getCourses().get(j);
//			System.out.println(sdf.format(temp1.getclass_start().get(2))+sdf.format(temp1.getclass_end().get(2)));
			cour.add(new courses_view(temp1.getType(),temp1.getCoursename(),
					temp1.getCourseCode(),temp1.getInstructor(),Integer.toString(temp1.getCredits()),
					temp1.getAcronym(),
					gettime(temp1.getclass_start().get(0),temp1.getclass_end().get(0),temp1.getClassrooms().get(0).getName()),
					gettime(temp1.getclass_start().get(1),temp1.getclass_end().get(1),temp1.getClassrooms().get(1).getName()),
					gettime(temp1.getclass_start().get(2),temp1.getclass_end().get(2),temp1.getClassrooms().get(2).getName()),
					gettime(temp1.getclass_start().get(3),temp1.getclass_end().get(3),temp1.getClassrooms().get(3).getName()),
					gettime(temp1.getclass_start().get(4),temp1.getclass_end().get(4),temp1.getClassrooms().get(4).getName()),
					gettime2(temp1.getclass_start().get(5),temp1.getclass_end().get(5),temp1.getTut_day(),temp1.getTut()),
					gettime2(temp1.getclass_start().get(6),temp1.getclass_end().get(6),temp1.getLab_day(),temp1.getLab())));
			
		}
		Mandatory.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s1"));
		Name.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s2"));
		Code.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s3"));
		Instructor.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s4"));
		Credits.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s5"));
		Acronym.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s6"));
		monday.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s7"));
		tuesday.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s8"));
		wednesday.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s9"));
		thursday.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s10"));
		friday.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s11"));
		tut.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s12"));
		lab.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s13"));
		rooms.setItems(cour);
	}
}
