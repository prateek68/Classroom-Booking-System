package APproject.view;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

import APproject.Courses;
import APproject.Room;
import APproject.courses_view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class timetable_controller {
	
	ObservableList<courses_view> cour=FXCollections.observableArrayList();
	
	@FXML
	Label user;
	@FXML
	Label type;
	
	@FXML
	public Button back;
	
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

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void initialize() throws IOException
	{
		CsvReader inputcourse=new CsvReader("C:\\Users\\prateekjain\\Desktop\\courses.csv");
		inputcourse.readHeaders();
		while(inputcourse.readRecord()) {
			courses_view temp=new courses_view(inputcourse.get(0),inputcourse.get(1),inputcourse.get(2),inputcourse.get(3),inputcourse.get(4),inputcourse.get(5),inputcourse.get(6).replaceAll("\\$","/"),inputcourse.get(7).replaceAll("\\$","/"),inputcourse.get(8).replaceAll("\\$","/"),inputcourse.get(9).replaceAll("\\$","/"),inputcourse.get(10).replaceAll("\\$","/"),inputcourse.get(11).replaceAll("\\$","/"),inputcourse.get(12).replaceAll("\\$","/"));
			cour.add(temp);
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
