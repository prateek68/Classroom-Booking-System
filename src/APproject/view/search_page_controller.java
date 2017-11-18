package APproject.view;

import java.io.IOException;

import APproject.Main;
import APproject.courses_view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A class that enables a student to search for courses based on some keywords
 *@author Prateek and Vaibhav
 */
public class search_page_controller {

	ObservableList<courses_view> cour=FXCollections.observableArrayList();
	
	@FXML
	Label user;
	
	@FXML
	Label type;
	
	@FXML
	TableView<courses_view> table;
	

	@FXML
	TableColumn<courses_view,String> Name;
	@FXML
	TableColumn<courses_view,String> Code;

	
	@FXML
	public Button back;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * @throws IOException
	 * A function to add or remove courses after searching for courses
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
		 Stage stage=(Stage) back.getScene().getWindow();
		    stage.close();
	}
	
	/**
	 * A funcction to initialise and display all the courses that satisfy search conditions
	 */
	@FXML
	private void initialize()
	{
		Name.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s1"));
		Code.setCellValueFactory(new PropertyValueFactory<courses_view,String>("s2"));
		for(int q=0;q<student_controller.fcourse.size();q++)
		{
				cour.add(new courses_view(student_controller.fcourse.get(q).getCoursename(),student_controller.fcourse.get(q).getCourseCode()));
		}
		table.setItems(cour);
	}
}
