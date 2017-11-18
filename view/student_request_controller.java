package APproject.view;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.csvreader.CsvWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import APproject.Admin;
import APproject.Main;
import APproject.Request;

public class student_request_controller {

	ObservableList<String> reqs=FXCollections.observableArrayList();
	
	@FXML 
	Label user;
	
	@FXML
	Label type;
	
	@FXML
	Label date;
	
	@FXML
	Label start_time;
	
	@FXML
	Label end_time;
	
	@FXML
	TextField purpose;
	
	@FXML
	TextField room;
	
	@FXML
	TextField audience;
	
	
	@FXML
	public Button back;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
//	public void make_request() throws IOException
//	{
//		CsvWriter outputfile=new CsvWriter(new FileWriter("C:\\\\Users\\\\prateekjain\\\\Desktop\\\\Request.csv",true),',');
//		String[] names=user.getText().split(" ");
//		String name="";
//		for(int i=1;i<(names.length-1);i++)
//			name=names[i]+" ";
//		name=name+names[(names.length-1)];
//		outputfile.write(name);
//		outputfile.write(purpose.getText());
//		outputfile.write(room.getText());
//		outputfile.write(audience.getText());
//		outputfile.write("Not Seen");
//		outputfile.write("false");
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date=new Date();
//		outputfile.write(dateFormat.format(date));
//		String star=start_time.getText()+":00";
//		String en=end_time.getText()+":00";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String[] start_hh=star.split(":");
//		String[] end_hh=en.split(":");
//		String getdate=this.date.getText();
//		date=new Date();
//		try {
//			String[] z=getdate.split("\\/");
//			date.setDate(Integer.parseInt(z[1]));
//			date.setMonth(Integer.parseInt(z[0])-1);
//			date.setYear(Integer.parseInt(z[2])-1900);
//			date.setHours(Integer.parseInt(start_hh[0]));
//			date.setMinutes(Integer.parseInt(start_hh[1]));
////			System.out.println(date.toString());
//	//		System.out.println(date.getDay());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		outputfile.write(sdf.format(date));
//		date=new Date();
//		try {
//			String[] z=getdate.split("\\/");
//			date.setDate(Integer.parseInt(z[1]));
//			date.setMonth(Integer.parseInt(z[0])-1);
//			date.setYear(Integer.parseInt(z[2])-1900);
//			date.setHours(Integer.parseInt(end_hh[0]));
//			date.setMinutes(Integer.parseInt(end_hh[1]));
////			System.out.println(date.toString());
//	//		System.out.println(date.getDay());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		outputfile.write(sdf.format(date));
//	//	Admin.getRequests().add(new Request(name,purpose.getText(),Main.IIITD.getRoom(room.getText()),audience.getText(),"Not Seen",false,new Date(),);
//		outputfile.endRecord();
//		outputfile.close();
		
//		Admin.add(new Request(login_controller.namee,purpose.getText(),Main.IIITD.getRoom(room.getText()
//				),Integer.parseInt(audience.getText()),"Not Seen","false",));
//	}
	
	public void make_request() throws IOException
	{
		
		if(Integer.parseInt(audience.getText())>Main.IIITD.getRoom(room.getText()).getCapacity())
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
			d.room.setText("Audience is more than room capacity");
			return;
		}
		//		CsvWriter outputfile=new CsvWriter(new FileWriter("C:\\\\Users\\\\prateekjain\\\\Desktop\\\\Request.csv",true),',');
		String[] names=user.getText().split(" ");
		String name="";
		for(int i=1;i<(names.length-1);i++)
			name=names[i]+" ";
		name=name+names[(names.length-1)];
//		outputfile.write(name);
//		outputfile.write(purpose.getText());
//		outputfile.write(room.getText());
//		outputfile.write(audience.getText());
//		outputfile.write("Not Seen");
//		outputfile.write("false");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date1=new Date();
//		outputfile.write(dateFormat.format(date1));
		String star=start_time.getText()+":00";
		String en=end_time.getText()+":00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String[] start_hh=star.split(":");
		String[] end_hh=en.split(":");
		String getdate=this.date.getText();
		Date date2=new Date();
		try {
			String[] z=getdate.split("\\/");
			date2.setDate(Integer.parseInt(z[1]));
			date2.setMonth(Integer.parseInt(z[0])-1);
			date2.setYear(Integer.parseInt(z[2])-1900);
			date2.setHours(Integer.parseInt(start_hh[0]));
			date2.setMinutes(Integer.parseInt(start_hh[1]));
			date2.setSeconds(Integer.parseInt(start_hh[2]));
//			System.out.println(date.toString());
	//		System.out.println(date.getDay());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		outputfile.write(sdf.format(date2));
		Date date3=new Date();
		try {
			String[] z=getdate.split("\\/");
			date3.setDate(Integer.parseInt(z[1]));
			date3.setMonth(Integer.parseInt(z[0])-1);
			date3.setYear(Integer.parseInt(z[2])-1900);
			date3.setHours(Integer.parseInt(end_hh[0]));
			date3.setMinutes(Integer.parseInt(end_hh[1]));
			date3.setSeconds(Integer.parseInt(end_hh[2]));
//			System.out.println(date.toString());
	//		System.out.println(date.getDay());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		outputfile.write(sdf.format(date3));
		Admin.getRequests().add(new Request(name,purpose.getText(),Main.IIITD.getRoom(room.getText()),Integer.parseInt(audience.getText()),"Not Seen",false,dateFormat.format(date1),sdf.format(date2),sdf.format(date3)));
//		outputfile.endRecord();
//		outputfile.close();
		FXMLLoader load1=new FXMLLoader();
		load1.setLocation(Main.class.getResource("view/request_accept.fxml"));
		AnchorPane mainlayout1=load1.load();
		Scene scene1=new Scene(mainlayout1);
		Stage pe1=new Stage();
		pe1.setScene(scene1);
		pe1.setTitle("Request Status");
		pe1.show();
		error_controller d=load1.getController();
		d.room.setText("Request has been sent to Admin");
		  Stage stage=(Stage) back.getScene().getWindow();
		    stage.close();
	}
	
	
	
	@FXML
	private void initialize() throws IOException	
	{
		ArrayList<Request> msg=Admin.getRequests();
		for(int i=0;i<msg.size();i++)
		{
				String s1=msg.get(i).getName();
				String s2=msg.get(i).isStatus();
				String s4=msg.get(i).getPreferredRoom().getName();
				String s3=s1+" - "+s4+" - "+s2;
				reqs.add(s3);
		}
//		allreq.setItems(reqs);
	}
	
}
