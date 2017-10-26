package maincode;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage primarystage;
	AnchorPane mainlayout;
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

	public static void main(String[] args) {
		launch(args);
	}
}
