package APproject;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.csvreader.CsvReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {

	static Stage primarystage;
	static AnchorPane mainlayout;
	public static String username="";
	static public Management IIITD= new Management();
	
	public void start(Stage primarystage) throws IOException {
		this.primarystage=primarystage;
		this.primarystage.setTitle("Classroom Booking System");
		showMainView();
	}
	
	private void showMainView() throws IOException
	{
		FXMLLoader load=new FXMLLoader();
		load.setLocation(Main.class.getResource("view/login.fxml"));
		mainlayout=load.load();
		Scene scene=new Scene(mainlayout);
		primarystage.setScene(scene);
		primarystage.show();
		
	}
	
public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
		
		int i=0;
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\prateekjain\\Desktop\\iiitd.dat"));
		IIITD=(Management) in.readObject();
		in.close();
		i++;
		}
		catch(Exception e) {
			if(i==0) {
				IIITD.deserialize();
			}
		}
		
		
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\prateekjain\\Desktop\\requests.dat"));
			ArrayList<Request> readObject=(ArrayList<Request>) in.readObject();
				Admin.setRequests(readObject);
				in.close();
		}
		
		catch(Exception e) {
			
			
		}
		
		
		
		
		launch(args);
//		IIITD.serialize();
	}
}

