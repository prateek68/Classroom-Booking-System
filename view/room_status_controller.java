package APproject.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import com.bytecode.opencsv.CSVReader;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import APproject.Booked_rooms;
import APproject.Main;
import APproject.Room;
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

public class room_status_controller {
	
	ObservableList<Room> available_rooms=FXCollections.observableArrayList();
	
	@FXML 
	Label user;
	
	@FXML
	Label type;
	
	@FXML
	TextField start;
	
	@FXML
	TextField end;
	
	@FXML
	TableView<Room> rooms;
	@FXML
	TableColumn<Room,String> room_name;
	@FXML
	TableColumn<Room,Integer> room_capacity;
	
	@FXML
	TextField booking_date;
	
	@FXML
	public Button back;
	@FXML
	TextField getRoom;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void getavailable_rooms() throws IOException {
		available_rooms=FXCollections.observableArrayList();
		rooms.setItems(null);
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
			}
			if(available) {
				available_rooms.add(temp);
			}
		
		}	
//		CsvReader input=new CsvReader("C:\\Users\\prateekjain\\Desktop\\Booked_Rooms.csv");
//		Booked_rooms booking;
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
//			st_date.setSeconds(00);
//			
//			s1=e_date.split(" ");
//			s2=s1[0].split("\\/");
//			s3=s1[1].split("\\:");
//			en_date.setYear(Integer.parseInt(s2[0])-1900);
//			en_date.setMonth(Integer.parseInt(s2[1])-1);
//			en_date.setDate(Integer.parseInt(s2[2]));
//			en_date.setHours(Integer.parseInt(s3[0]));
//			en_date.setMinutes(Integer.parseInt(s3[1]));
//			en_date.setSeconds(00);
//			
//			Room temp=Main.IIITD.getRoom(room);
//			e.setDate(date.getDate());
//			e.setMonth(date.getMonth());
//			e.setYear(date.getYear());
//			s.setDate(date.getDate());
//			s.setMonth(date.getMonth());
//			s.setYear(date.getYear());
////			System.out.println(e.toString());
////			System.out.println(s.toString());
////			System.out.println(st_date);
////			System.out.println(en_date);
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
	@FXML
	public void book_room() throws IOException{
		
		
		String Room=getRoom.getText();
		String name=user.getText().split(": ")[1];
		Booked_rooms booking=new Booked_rooms(Room,name,"","");
		
//		CsvWriter input=new CsvWriter(new FileWriter("C:\\Users\\prateekjain\\Desktop\\Booked_Rooms.csv",true), ',');
//		input.write(Room);
//		input.write(name);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		String d=booking_date.getText();
		date.setDate(Integer.parseInt(d.split("\\/")[1]));
		date.setMonth(Integer.parseInt(d.split("\\/")[0])-1);
		date.setYear(Integer.parseInt(d.split("\\/")[2])-1900);
		String st=start.getText()+":00";
		date.setHours(Integer.parseInt(st.split("\\:")[0]));
		date.setMinutes(Integer.parseInt(st.split("\\:")[1]));
		date.setSeconds(Integer.parseInt(st.split("\\:")[2]));
//		input.write(sdf.format(date));
		st=sdf.format(date);
		booking.setStart_date(st);
		String en=end.getText()+":00";
		date.setHours(Integer.parseInt(en.split("\\:")[0]));
		date.setMinutes(Integer.parseInt(en.split("\\:")[1]));
		date.setSeconds(Integer.parseInt(en.split("\\:")[2]));
//		input.write(sdf.format(date));
		en=sdf.format(date);
		booking.setEnd_date(en);
		Main.IIITD.getBookedrooms().add(booking);
//		input.endRecord();
//		input.close();
		getRoom.setText(null);
		getavailable_rooms();
	}
	
	@FXML
	public void cancel_room() throws IOException {
//		String booked_rooms="C:\\Users\\prateekjain\\Desktop\\Booked_Rooms.csv";
//		//System.out.println("first");
//		CSVReader r=new CSVReader(new FileReader("C:\\Users\\prateekjain\\Desktop\\Booked_Rooms.csv"));
//		//System.out.println("second");
//		List<String[]> all_booked_rooms= r.readAll();
//		System.out.println(r.readAll());
//		int n=0;
		String Room=getRoom.getText();
		String name=login_controller.namee;
//		String ty=type.getText().split(": ")[1];
//		String[] newline;
//		System.out.println(r.readNext());
//		while((newline=r.readNext())!=null) {
//			System.out.println("in");
//			n++;
//			System.out.println(newline[0]);
//			if(newline[0].equals(Room)&&newline[1].equals(name)) {
//				all_booked_rooms.remove(n);
//				System.out.println("Cannceled room number");
//			}
//		}
		
		for(int i=0;i<Main.IIITD.getBookedrooms().size();++i) {
			if(Room.equals(Main.IIITD.getBookedrooms().get(i).getBooked_room()) && 
					name.equals(Main.IIITD.getBookedrooms().get(i).getBooked_by())) {
				Main.IIITD.getBookedrooms().remove(i);
				break;
			}
		}
		getRoom.setText(null);
		getavailable_rooms();
	}
	
	@FXML
	private void initialize()	
	{

	}
}
