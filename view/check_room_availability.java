package APproject.view;

import APproject.Main;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.csvreader.CsvReader;

import APproject.Admin;
import APproject.Room;

public class check_room_availability {
	
	ObservableList<Room> available_rooms=FXCollections.observableArrayList();
	
	
	@FXML
	Button request;
	
	@FXML
	TextField start;
	
	@FXML
	Label user;
	@FXML
	Label type;
	
	@FXML
	TextField end;
	
	@FXML
	public Button back;
	@FXML
	Button check;
	@FXML
	TableView<Room> rooms;
	@FXML
	TableColumn<Room,String> room_name;
	@FXML
	TableColumn<Room,Integer> room_capacity;
	
	
	@FXML
	TextField booking_date;
	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	
	@FXML
	public void getavailable_rooms() throws IOException {
		available_rooms=FXCollections.observableArrayList();
		if(start.getText().isEmpty() || end.getText().isEmpty() || booking_date.getText().isEmpty())
		{
			request.setDisable(true);
		}
		else
		{
			request.setDisable(false);
		String start_time=start.getText()+":00";
		String end_time=end.getText()+":00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date s=null;;
		Date e=null;
		try {
			s = sdf.parse(start_time);
			e=sdf.parse(end_time);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String getdate=booking_date.getText();
		Date date=new Date();
		try {
			String[] z=getdate.split("\\/");
			date.setDate(Integer.parseInt(z[1]));
			date.setMonth(Integer.parseInt(z[0])-1);
			date.setYear(Integer.parseInt(z[2])-1900);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int d=date.getDay()-1;

		int l=Main.IIITD.getRooms().size();
		for(int j=0;j<l;++j) {
			Room temp=Main.IIITD.getRooms().get(j);
			int n=temp.getStart_time().get(d).size();

			boolean available=true;
			
			for(int k=0;k<n;++k) {
				e.setSeconds(0);
				temp.getStart_time().get(d).get(k).setSeconds(5);
				temp.getEnd_time().get(d).get(k).setSeconds(0);
				s.setSeconds(5);
				if(e.before(temp.getStart_time().get(d).get(k)) || temp.getEnd_time().get(d).get(k).before(s)) {
					continue;
				}
				else {
					available=false;
				}
//				System.out.println(temp.getStart_time().get(d).get(k).toString());
//				System.out.println(temp.getEnd_time().get(d).get(k).toString());
//				System.out.println();
			}
			if(available) {
				available_rooms.add(temp);
			}
			//System.out.println(available_rooms.size());
		
		}
		Date st_date=new Date();
		Date en_date=new Date();
		for(int j=0;j<Main.IIITD.getBookedrooms().size();++j) {
			String room=Main.IIITD.getBookedrooms().get(j).getBooked_room();//input.get(0);
			String s_date=Main.IIITD.getBookedrooms().get(j).getStart_date();//input.get(2);
			String e_date=Main.IIITD.getBookedrooms().get(j).getEnd_date();//input.get(3);
			
			String[] s1=s_date.split(" ");
			String[] s2=s1[0].split("\\/");
			String[] s3=s1[1].split("\\:");
			st_date.setYear(Integer.parseInt(s2[0])-1900);
			st_date.setMonth(Integer.parseInt(s2[1])-1);
			st_date.setDate(Integer.parseInt(s2[2]));
			st_date.setHours(Integer.parseInt(s3[0]));
			st_date.setMinutes(Integer.parseInt(s3[1]));
			st_date.setSeconds(00);
			
			s1=e_date.split(" ");
			s2=s1[0].split("\\/");
			s3=s1[1].split("\\:");
			en_date.setYear(Integer.parseInt(s2[0])-1900);
			en_date.setMonth(Integer.parseInt(s2[1])-1);
			en_date.setDate(Integer.parseInt(s2[2]));
			en_date.setHours(Integer.parseInt(s3[0]));
			en_date.setMinutes(Integer.parseInt(s3[1]));
			en_date.setSeconds(00);
			
			Room temp=Main.IIITD.getRoom(room);
			e.setDate(date.getDate());
			e.setMonth(date.getMonth());
			e.setYear(date.getYear());
			s.setDate(date.getDate());
			s.setMonth(date.getMonth());
			s.setYear(date.getYear());
//			System.out.println(e.toString());
//			System.out.println(s.toString());
//			System.out.println(st_date);
//			System.out.println(en_date);
			e.setSeconds(0);
			s.setSeconds(5);
			st_date.setSeconds(5);
			en_date.setSeconds(0);
			if(e.before(st_date)||en_date.before(s)) {
			}
			else {
				available_rooms.remove(temp);
			}
		}
//		CsvReader input=new CsvReader("C:\\Users\\prateekjain\\Desktop\\Booked_Rooms.csv");
//		input.readHeaders();
//		Date st_date=new Date();
//		Date en_date=new Date();
//		while(input.readRecord()) {
//			String room=input.get(0);
//			String s_date=input.get(2);
//			String e_date=input.get(3);
//			
//			String[] s1=s_date.split(" ");
//			String[] s2=s1[0].split("\\/");
//			String[] s3=s1[1].split("\\:");
//			st_date.setYear(Integer.parseInt(s2[0])-1900);
//			st_date.setMonth(Integer.parseInt(s2[1])-1);
//			st_date.setDate(Integer.parseInt(s2[2]));
//			st_date.setHours(Integer.parseInt(s3[0]));
//			st_date.setMinutes(Integer.parseInt(s3[1]));
//			
//			s1=e_date.split(" ");
//			s2=s1[0].split("\\/");
//			s3=s1[1].split("\\:");
//			en_date.setYear(Integer.parseInt(s2[0])-1900);
//			en_date.setMonth(Integer.parseInt(s2[1])-1);
//			en_date.setDate(Integer.parseInt(s2[2]));
//			en_date.setHours(Integer.parseInt(s3[0]));
//			en_date.setMinutes(Integer.parseInt(s3[1]));
//			
//			Room temp=Main.IIITD.getRoom(room);
//			e.setDate(date.getDate());
//			e.setMonth(date.getMonth());
//			e.setYear(date.getYear());
//			s.setDate(date.getDate());
//			s.setMonth(date.getMonth());
//			s.setYear(date.getYear());
//			if(e.before(st_date)||en_date.before(s)) {
//			}
//			else {
//				available_rooms.remove(temp);
//			}
//		}
//		input.close();
		room_name.setCellValueFactory(new PropertyValueFactory<Room,String>("name"));
		room_capacity.setCellValueFactory(new PropertyValueFactory<Room,Integer>("Capacity"));	
		rooms.setItems(available_rooms);
	}
	}	
	
	@FXML
	private void reques() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/Student_request_page.fxml"));
		AnchorPane mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		Stage pe=new Stage();
		pe.setScene(scene);
		pe.setTitle("Classroom Booking System");
		pe.show();
		student_request_controller c=load.getController();
		c.user.setText(user.getText());
		c.type.setText(type.getText());
		c.date.setText(booking_date.getText());
		c.start_time.setText(start.getText());
		c.end_time.setText(end.getText());
		Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void initialize()
	{
		request.setDisable(true);
	}
}
