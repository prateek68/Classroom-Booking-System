package APproject.view;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import APproject.Admin;
import APproject.Booked_rooms;
import APproject.Main;
import APproject.Request;

/**
 *A class that enables an Admin to view all pending requests and either reject or 
 *accept the request
 *@author Prateek and Vaibhav
 */
public class view_request_contoller {
	
	ObservableList<String> reqs=FXCollections.observableArrayList();

	@FXML 
	ComboBox<String> req;
	
	@FXML
	Label room;
	
	@FXML
	Label purpose;
	
	@FXML
	Label audience;
	
	@FXML 
	Label user;
	
	@FXML
	Label type;
	
	
	@FXML
	Label start;
	
	@FXML 
	Label end;
	
	@FXML
	public Button back;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) back.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * A function to display all the pending request
	 */
	@FXML
	public void display()
	{
		if(req.getValue()!=null)
		{
			String[] s1=req.getValue().split(" - ");
			ArrayList<Request> msg=Admin.getRequests();
			for(int i=0;i<msg.size();i++)
			{
				if(msg.get(i).getName().equals(s1[0]) && msg.get(i).getPreferredRoom().getName().equals(s1[1]))
				{
					purpose.setText(msg.get(i).getInfo());
					room.setText(msg.get(i).getPreferredRoom().getName());
					audience.setText(Integer.toString(msg.get(i).getExpectedTurnout()));
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
					start.setText(sdf.format(msg.get(i).getBooking_date_start()));
					end.setText(sdf.format(msg.get(i).getBooking_date_end()));
					break;
				}
			}
		}
	}
	
	/**
	 * @throws IOException
	 * A function to accept a selected request
	 */
	@FXML
	public void accept() throws IOException
	{
		String[] s1=req.getValue().split(" - ");
		ArrayList<Request> msg=Admin.getRequests();
		for(int i=0;i<msg.size();i++)
		{
			if(msg.get(i).getName().equals(s1[0]) && msg.get(i).getPreferredRoom().getName().equals(s1[1]))
			{
				msg.get(i).setStatus("Accepted");
				try {
//					CsvWriter input=new CsvWriter(new FileWriter("C:\\Users\\prateekjain\\Desktop\\Booked_Rooms.csv",true), ',');
//					input.write(msg.get(i).getPreferredRoom().getName());
//					input.write(msg.get(i).getName());
					
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//					input.write(sdf.format(msg.get(i).getBooking_date_start()));
//					input.write(sdf.format(msg.get(i).getBooking_date_end()));
					Main.IIITD.getBookedrooms().add(new Booked_rooms(msg.get(i).getPreferredRoom().getName(),
							msg.get(i).getName(),sdf.format(msg.get(i).getBooking_date_start()),
							sdf.format(msg.get(i).getBooking_date_end())));
//					input.endRecord();
//					input.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		reqs=FXCollections.observableArrayList();
		req.setItems(null);
		purpose.setText("");
		room.setText("");
		audience.setText("");
		start.setText("");
		end.setText("");
		for(int i=0;i<msg.size();i++)
		{
			if(msg.get(i).isStatus().equals("Not Seen"))
			{
				String s0=msg.get(i).getName();
				String s2=msg.get(i).getPreferredRoom().getName();
				String s3=s0+" - "+s2;
				reqs.add(s3);
			}
		}
		req.setItems(reqs);
	}
	
	/**
	 * A function to reject a selected request
	 */
	@FXML
	public void reject()
	{
		String[] s1=req.getValue().split(" - ");
		ArrayList<Request> msg=Admin.getRequests();
		for(int i=0;i<msg.size();i++)
		{
			if(msg.get(i).getName().equals(s1[0]) && msg.get(i).getPreferredRoom().getName().equals(s1[1]))
			{
				msg.get(i).setStatus("Rejected");
				break;
			}
		}
		reqs=FXCollections.observableArrayList();
		req.setItems(null);
		purpose.setText("");
		room.setText("");
		audience.setText("");
		start.setText("");
		end.setText("");
		for(int i=0;i<msg.size();i++)
		{
			if(msg.get(i).isStatus().equals("Not Seen"))
			{
				String s0=msg.get(i).getName();
				String s2=msg.get(i).getPreferredRoom().getName();
				String s3=s0+" - "+s2;
				reqs.add(s3);
			}
		}
		req.setItems(reqs);
	}
	
	/**
	 * @throws IOException
	 * A function to initialize and display the requests
	 * @throws ParseException 
	 */
	@FXML
	private void initialize() throws IOException, ParseException	
	{
		ArrayList<Request> msg=Admin.getRequests();
//		for(int i=0;i<Admin.getRequests().size();++i) {
//			System.out.println(Admin.getRequests().get(i).getName());
//		}
		SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ArrayList<Booked_rooms> checker=Main.IIITD.getBookedrooms();
		for(int i=0;i<msg.size();i++)
		{
			if(msg.get(i).isStatus().equals("Not Seen"))
			{
				for(int j=0;j<checker.size();j++)
				{
				//	System.out.println(sdf.format(msg.get(i).getBooking_date_start()));
					Date newstart=df.parse(checker.get(j).getStart_date());
					//System.out.println(sdf.format(newstart));
					Date newend=df.parse(checker.get(j).getEnd_date());
					if(msg.get(i).getPreferredRoom().getName().equals(checker.get(j).getBooked_room()) && sdf.format(newstart).compareTo(sdf.format(msg.get(i).getBooking_date_start()))==0 && sdf.format(newend).compareTo(sdf.format(msg.get(i).getBooking_date_end()))==0)
					{
						//System.out.println("TIME TO REJECT REQUEST");
						msg.get(i).setStatus("Rejected");
						break;
					}
				}
				Date d1=msg.get(i).getTime();
				Date d2=new Date();
				int days=(int)( (d2.getTime()-d1.getTime())/(1000*60*60*24));
				if(days>5)
				{
					msg.get(i).setStatus("Rejected");
				}
			}
			if(msg.get(i).isStatus().equals("Not Seen"))
			{
				String s1=msg.get(i).getName();
				String s2=msg.get(i).getPreferredRoom().getName();
				String s3=s1+" - "+s2;
				reqs.add(s3);
			}
		}
//		for(int i=0;i<reqs.size();++i) {
//			System.out.println(reqs.get(i));
//		}
		req.setItems(reqs);
	}
	
}
