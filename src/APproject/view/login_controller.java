package APproject.view;
import com.csvreader.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import APproject.Admin;
import APproject.Faculty;
import APproject.Main;
import APproject.Request;
import APproject.Student;


/**
 * Class that enables an existing user to sign in based on his/her credentials and enables a new
 * use to signup
 *@author  Prateek and Vaibhav
 */
public class login_controller {
	private Main main;
	ObservableList<String> typelist=FXCollections.observableArrayList("Admin","Faculty","Student");
	static String namee=new String();
	@FXML
	PasswordField login_pass;
	
	@FXML 
	Button log;
	
	@FXML 
	TextField email;
	
	@FXML
	PasswordField pass;
	
	@FXML
	TextField name;
	
	@FXML
	private ComboBox<String> log_in;
	
	@FXML
	private ComboBox<String> sign_up;
	
	@FXML
	private TextField user;
	
	@FXML
	public Button exit;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) throws FileNotFoundException, IOException {
	    Stage stage=(Stage) exit.getScene().getWindow();
	    stage.close();
	    ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Vaibhav\\Desktop\\iiitd.dat"));
	    out.writeObject(Main.IIITD);
	    out.close();
	    out=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Vaibhav\\Desktop\\requests.dat"));
	    out.writeObject(Admin.getRequests());
	    out.close();
	}
	
	/**
	 * @throws IOException
	 * A function that enables an existing user to sign in based on his/her credentials
	 */
	@FXML
	private void login() throws IOException
	{
		String e=user.getText();
		String passw=login_pass.getText();
		String t=log_in.getValue();
		String name="";
		boolean validate=false;
//		CsvReader inputfile=new CsvReader("C:\\Users\\prateekjain\\Desktop\\users.csv");
//		inputfile.readHeaders();
//		while(inputfile.readRecord()) {
//			if(e.equals(inputfile.get(1)) && passw.equals(inputfile.get(2)) && t.equals(inputfile.get(3)) ) {
//				validate=true;
//				name=inputfile.get(0);
//				namee=name;
//				break;
//			}
//		}
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(e.equals(Main.IIITD.getUsers().get(i).getCredentials().getEmailId())
					&& passw.equals(Main.IIITD.getUsers().get(i).getCredentials().getPassword())
					&& t.equals(Main.IIITD.getUsers().get(i).getCredentials().getUserType())) {
				validate=true;
				name=Main.IIITD.getUsers().get(i).getCredentials().getName();
				namee=name;
			}
		}
		if(validate==false) {
			//error
			FXMLLoader load=new FXMLLoader();
			load.setLocation(Main.class.getResource("view/Error_log_in.fxml"));
			AnchorPane mainlayout=new AnchorPane();
			mainlayout=load.load();
			Scene scene=new Scene(mainlayout);
			Stage pe=new Stage();
			pe.setScene(scene);
			pe.setTitle("Error");
			pe.show();
			return;
		}
//		inputfile.close();
		if(t.equals("Admin"))
		{
			FXMLLoader load=new FXMLLoader();
			load.setLocation(Main.class.getResource("view/Admin_page.fxml"));
			AnchorPane mainlayout=new AnchorPane();
			mainlayout=load.load();
			Scene scene=new Scene(mainlayout);
			Stage pe=new Stage();
			pe.setScene(scene);
			pe.setTitle("Classroom Booking System");
			pe.show();
			admin_contoller c=load.getController();
			c.user.setText("Username: "+name);
			c.type.setText("Type: "+t);
			
ArrayList<Request> msg=Admin.getRequests();
			
			for(int i=0;i<msg.size();i++)
			{
				if(msg.get(i).isStatus().equals("Not Seen"))
				{
					FXMLLoader load1=new FXMLLoader();
					load1.setLocation(Main.class.getResource("view/request_accept.fxml"));
					AnchorPane mainlayout1=load1.load();
					Scene scene1=new Scene(mainlayout1);
					Stage pe1=new Stage();
					pe1.setScene(scene1);
					pe1.setTitle("Request Status");
					pe1.show();
					error_controller d=load1.getController();
					d.room.setText("You have new Requests");
					break;
				}
			}	
		}
		else if(t.equals("Faculty"))
		{
			FXMLLoader load=new FXMLLoader();
			load.setLocation(Main.class.getResource("view/Faculty_page.fxml"));
			AnchorPane mainlayout = load.load();
			Scene scene=new Scene(mainlayout);
			Stage pe=new Stage();
			pe.setScene(scene);
			pe.setTitle("Classroom Booking System");
			pe.show();
			admin_contoller c=load.getController();
			c.user.setText("Username: "+name);
			c.type.setText("Type: "+t);
		}
		else if(t.equals("Student"))
		{
			FXMLLoader load=new FXMLLoader();
			load.setLocation(Main.class.getResource("view/Student_page.fxml"));
			AnchorPane mainlayout=load.load();
			Scene scene=new Scene(mainlayout);
			Stage pe=new Stage();
			pe.setScene(scene);
			pe.setTitle("Classroom Booking System");
			pe.show();
			student_controller c=load.getController();
			c.user.setText("Username: "+name);
			c.type.setText("Type: "+t);
			ArrayList<Request> msg=Admin.getRequests();
			
			for(int i=0;i<msg.size();i++)
			{
				if(msg.get(i).isStatus().equals("Accepted") && msg.get(i).isMessage()==false)
				{
					msg.get(i).setMessage(true);
					FXMLLoader load1=new FXMLLoader();
					load1.setLocation(Main.class.getResource("view/request_accept.fxml"));
					AnchorPane mainlayout1=load1.load();
					Scene scene1=new Scene(mainlayout1);
					Stage pe1=new Stage();
					pe1.setScene(scene1);
					pe1.setTitle("Request Status");
					pe1.show();
					error_controller d=load1.getController();
					d.room.setText("Room "+msg.get(i).getPreferredRoom().getName()+" has been Booked!");
				}
				else if(msg.get(i).isStatus().equals("Rejected") && msg.get(i).isMessage()==false)	
				{
					msg.get(i).setMessage(true);
					FXMLLoader load1=new FXMLLoader();
					load1.setLocation(Main.class.getResource("view/request_accept.fxml"));
					AnchorPane mainlayout1=load1.load();
					Scene scene1=new Scene(mainlayout1);
					Stage pe1=new Stage();
					pe1.setScene(scene1);
					pe1.setTitle("Request Status");
					pe1.show();
					error_controller d=load1.getController();
					d.room.setText("Room "+msg.get(i).getPreferredRoom().getName()+" has not been booked!");
				}
			}	
		}
		user.clear();
		login_pass.clear();
		log_in.setValue(null);
	}
	
	/**
	 * @throws IOException
	 * a function that enables a new user to register and sign up
	 */
	@FXML
	private void signup() throws IOException
	{
		String n=name.getText();
		String t=sign_up.getValue();
		String passw=pass.getText();
		String e=email.getText();
		String[] em=e.split("@");
		if(em.length>1&&em[1].equals("iiitd.ac.in")){		
		}
		else {
			//error
			FXMLLoader load=new FXMLLoader();
			load.setLocation(Main.class.getResource("view/error_iiitd.fxml"));
			AnchorPane mainlayout=new AnchorPane();
			mainlayout=load.load();
			Scene scene=new Scene(mainlayout);
			Stage pe=new Stage();
			pe.setScene(scene);
			pe.setTitle("Error");
			return;
		}
//		CsvReader inputfile=new CsvReader("C:\\Users\\prateekjain\\Desktop\\users.csv");
//		inputfile.readHeaders();
//		while(inputfile.readRecord()) {
//			if(e.equals(inputfile.get(1))||passw.equals(inputfile.get(2))) {
//				//error
//				FXMLLoader load=new FXMLLoader();
//				load.setLocation(Main.class.getResource("view/Error_sign_in.fxml"));
//				AnchorPane mainlayout=new AnchorPane();
//				mainlayout=load.load();
//				Scene scene=new Scene(mainlayout);
//				Stage pe=new Stage();
//				pe.setScene(scene);
//				pe.setTitle("Error");
//				pe.show();
//				return;
//			}
//		}
//		inputfile.close();
//		CsvWriter outputfile=new CsvWriter(new FileWriter("C:\\\\Users\\\\prateekjain\\\\Desktop\\\\users.csv",true),',');
//		outputfile.write(n);
//		outputfile.write(e);
//		outputfile.write(passw);
//		outputfile.write(t);
//		outputfile.endRecord();
//		outputfile.close();
		
		for(int i=0;i<Main.IIITD.getUsers().size();++i) {
			if(e.equals(Main.IIITD.getUsers().get(i).getCredentials().getEmailId()) ||
					passw.equals(Main.IIITD.getUsers().get(i).getCredentials().getPassword())) {
				//error
				FXMLLoader load=new FXMLLoader();
				load.setLocation(Main.class.getResource("view/Error_sign_in.fxml"));
				AnchorPane mainlayout=new AnchorPane();
				mainlayout=load.load();
				Scene scene=new Scene(mainlayout);
				Stage pe=new Stage();
				pe.setScene(scene);
				pe.setTitle("Error");
				pe.show();
				return;
			}
		}
		
		if(t.equals("Student")) {
			Main.IIITD.getUsers().add(new Student(n,e,passw,t));
		}
		else if(t.equals("Faculty")) {
			Main.IIITD.getUsers().add(new Faculty(n,e,passw,t));
		}
		else if(t.equals("Admin")) {
			Main.IIITD.getUsers().add(new Admin(n,e,passw,t));
		}
		
		user.setText(e);
		login_pass.setText(passw);
		log_in.setValue(t);
		email.clear();
		name.clear();
		pass.clear();
		sign_up.setValue(null);
		login();
		
	}	
		
	@FXML
	private void initialize()
	{
		log_in.setItems(typelist);
		sign_up.setItems(typelist);
	}

}
