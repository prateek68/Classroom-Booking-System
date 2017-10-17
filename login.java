import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class login extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage frame) throws Exception {
		// TODO Auto-generated method stub
		frame.setTitle("Classroom Booking System");
		Scene scene=new Scene(new Group());
		Label label1=new Label("Welcome to IIITD Classroom");
		Label label2=new Label("Booking System");
		label1.setFont(Font.font("Serif",40));
		label1.setTranslateX(150);
		label1.setTranslateY(10);
		label1.setAlignment(Pos.CENTER);
		label2.setFont(Font.font("Serif",40));
		label2.setTranslateX(-240);
	    label2.setTranslateY(53);
	    label2.setAlignment(Pos.CENTER);
	    Label non_member_title=new Label("Not a Member? Sign Up!");
		Label member_title=new Label("Already a Member? Sign In!");
		non_member_title.setFont(Font.font("Serif",26));
		non_member_title.setTranslateX(-710);
		non_member_title.setTranslateY(125);
		member_title.setFont(Font.font("Serif",26));
		member_title.setTranslateX(-555);
		member_title.setTranslateY(125);
		TextField[] login_text=new TextField[6];
		login_text[0]=new TextField("Username");
		login_text[0].setPromptText("Enter Username");
		login_text[0].setTranslateX(-1250);
		login_text[0].setTranslateY(200);
		login_text[0].setPrefWidth(200);
		login_text[1]=new TextField("Type of User");
		login_text[1].setPromptText("Enter Type of User");
		login_text[1].setTranslateX(-1450);
		login_text[1].setTranslateY(275);
		login_text[1].setPrefWidth(200);
		login_text[2]=new TextField("Password");
		login_text[2].setPromptText("Enter Password");
		login_text[2].setTranslateX(-1650);
		login_text[2].setTranslateY(350);
		login_text[2].setPrefWidth(200);
		login_text[3]=new TextField("Username");
		login_text[3].setPromptText("Enter Username");
		login_text[3].setTranslateX(-1450);
		login_text[3].setTranslateY(200);
		login_text[3].setPrefWidth(200);
		login_text[4]=new TextField("Type of User");
		login_text[4].setPromptText("Enter Type of User");
		login_text[4].setTranslateX(-1650);
		login_text[4].setTranslateY(275);
		login_text[4].setPrefWidth(200);
		login_text[5]=new TextField("Password");
		login_text[5].setPromptText("Enter Password");
		login_text[5].setTranslateX(-1850);
		login_text[5].setTranslateY(350);
		login_text[5].setPrefWidth(200);
		Button Sign_up=new Button("Sign Up");
		Sign_up.setTranslateX(-2450);
		Sign_up.setTranslateY(400);
		Button Log_in=new Button("Log In");
		Log_in.setTranslateX(-2110);
		Log_in.setTranslateY(400);
		frame.setWidth(800);
	    frame.setHeight(600);
	    HBox hbox=new HBox();
	    //hbox.setSpacing(10);
        hbox.getChildren().add(label1);
        hbox.getChildren().add(label2);
        hbox.getChildren().add(non_member_title);
        hbox.getChildren().add(member_title);
        HBox.setHgrow(Sign_up,null);
        HBox.setHgrow(Log_in,null);
        for(int i=0;i<6;i++)
        	hbox.getChildren().add(login_text[i]);
        hbox.getChildren().add(Sign_up);
        hbox.getChildren().add(Log_in);
        ((Group)scene.getRoot()).getChildren().add(hbox);
        frame.setScene(scene);
        frame.show();
	}

}
