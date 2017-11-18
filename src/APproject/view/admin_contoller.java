package APproject.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import APproject.Main;

/**
 * GUI class that enables all the functionalities of an Admin
 * @author Prateek and Vaibhav
 */
public class admin_contoller {
	@FXML 
	Label user;
	
	@FXML
	AnchorPane all;
	
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
	 * Funcation that creates GUI page where we can view all the requests and then can 
	 * either reject or accept the request
	 */
	@FXML
	private void requests() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/request_page.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		view_request_contoller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
	/**
	 * @throws IOException
	 * Function creates a GUI page that enables the functionality where an Admin can check available rooms
	 * and book a room for a particular time slot
	 */ 
	@FXML
	private void status() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/room_status.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		room_status_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
	}
	
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
	
	@FXML
	private void initialize()	
	{

	}
	
}
