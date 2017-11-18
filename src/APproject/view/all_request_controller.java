package APproject.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import APproject.Admin;
import APproject.Booked_rooms;
import APproject.Main;
import APproject.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
  * GUI class that enables a user to view all request
 * @author Prateek and Vaibhav
 */
public class all_request_controller {
	
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
	 * Function is used to display all the request
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
	 * Function is used to cancel a request made by a student
	 */
	@FXML
	public void cancel_request() throws IOException
	{
		if(req.getValue()!=null)
		{
			String[] s1=req.getValue().split(" - ");
			ArrayList<Request> msg=Admin.getRequests();
			for(int i=0;i<msg.size();i++)
			{
				if(msg.get(i).getName().equals(s1[0]) && msg.get(i).getPreferredRoom().getName().equals(s1[1]) && msg.get(i).getStatus().equals(s1[2]))
				{
					if(s1[2].equals("Accepted"))
					{
						//room removal code here Main.IITD.getbookedrooms()
						ArrayList<Booked_rooms> crazy=Main.IIITD.getBookedrooms();
						for(int j=0;j<crazy.size();j++)
						{
							if(crazy.get(j).getBooked_room().equals(s1[1]))
							{
								crazy.remove(j);
							}
						}
					}
					msg.remove(i);
					break;
				}
			}
		}
		initialize();
	}
	
	@FXML
	public void clicked()
	{
		
	}
	
	/**
	 * @throws IOException
	 * Function initialises the page
	 */
	@FXML
	private void initialize() throws IOException	
	{
		room.setText("");
		purpose.setText("");
		audience.setText("");
		start.setText("");
		end.setText("");
		ArrayList<Request> msg=Admin.getRequests();
//		for(int i=0;i<Admin.getRequests().size();++i) {
//			System.out.println(Admin.getRequests().get(i).getName());
//		}
		reqs=FXCollections.observableArrayList();
		for(int i=0;i<msg.size();i++)
		{
			String q=login_controller.namee;
	//		System.out.println(q[1]);//+"   "+q[1]);
		//	System.out.println(msg.get(i).getName());
			if(msg.get(i).getName().equals(q))
			{
				String s1=msg.get(i).getName();
				String s2=msg.get(i).getPreferredRoom().getName();
				String s4=msg.get(i).getStatus();
				String s3=s1+" - "+s2+" - "+s4;
				reqs.add(s3);
			}
		}
//		for(int i=0;i<reqs.size();++i) {
//			System.out.println(reqs.get(i));
//		}
		req.setItems(reqs);
	}

}
