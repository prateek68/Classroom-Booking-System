
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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
		final TextField[] login_text=new TextField[6];
		login_text[0]=new TextField();
		login_text[0].setPromptText("Enter Username");
		login_text[0].setTranslateX(-1250);
		login_text[0].setTranslateY(200);
		login_text[0].setPrefWidth(200);
		login_text[1]=new TextField();
		login_text[1].setPromptText("Enter Type of User");
		login_text[1].setTranslateX(-1450);
		login_text[1].setTranslateY(275);
		login_text[1].setPrefWidth(200);
		login_text[2]=new TextField();
		login_text[2].setPromptText("Enter Password");
		login_text[2].setTranslateX(-1650);
		login_text[2].setTranslateY(350);
		login_text[2].setPrefWidth(200);
		login_text[3]=new TextField();
		login_text[3].setPromptText("Enter Username");
		login_text[3].setTranslateX(-1450);
		login_text[3].setTranslateY(200);
		login_text[3].setPrefWidth(200);
		login_text[4]=new TextField();
		login_text[4].setPromptText("Enter Type of User");
		login_text[4].setTranslateX(-1650);
		login_text[4].setTranslateY(275);
		login_text[4].setPrefWidth(200);
		login_text[5]=new TextField();
		login_text[5].setPromptText("Enter Password");
		login_text[5].setTranslateX(-1850);
		login_text[5].setTranslateY(350);
		login_text[5].setPrefWidth(200);
		Button Sign_up=new Button("Sign Up");
		Sign_up.setTranslateX(-2450);
		Sign_up.setTranslateY(400);
		Button Log_in=new Button("Log In");
		Log_in.setOnAction(new EventHandler<ActionEvent>() 
		{

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				final String username=login_text[3].getText();
				if(login_text[4].getText().equals("Admin"))
				{
					Stage frame=new Stage();
					frame.setTitle("Classroom Booking System");
					Scene scene=new Scene(new Group());
					Label user=new Label("Username: "+username);
					user.setMinWidth(170);
					user.setMaxWidth(170);
					Label type=new Label("Type: Admin");
					user.setFont(Font.font("Serif",17));
					user.setTranslateX(600);
					user.setTranslateY(20);
					type.setFont(Font.font("Serif",17));
					type.setTranslateX(430);
				    type.setTranslateY(35);
					Button view_request=new Button("View Requests");
					view_request.setTranslateX(-139);
					view_request.setTranslateY(150);
					view_request.setPrefSize(200,60);
					view_request.setOnAction(new EventHandler<ActionEvent>() 
					{

						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							Stage frame=new Stage();
							frame.setTitle("Classroom Booking System");
							Scene scene=new Scene(new Group());
							Label user=new Label("Username: "+username);
							user.setMinWidth(170);
							user.setMaxWidth(170);
							Label type=new Label("Type: Admin");
							user.setFont(Font.font("Serif",17));
							user.setTranslateX(600);
							user.setTranslateY(20);
							type.setFont(Font.font("Serif",17));
							type.setTranslateX(430);
						    type.setTranslateY(35);
						    Button accept_request=new Button("Accept Request");
						    accept_request.setTranslateX(-139);
						    accept_request.setTranslateY(150);
						    accept_request.setPrefSize(200,60);
							Button reject_request=new Button("Reject Request");
							reject_request.setTranslateX(-339);
							reject_request.setTranslateY(260);
							reject_request.setPrefSize(200,60);
							Button back=new Button("Back");
							back.setOnAction(new exit());
							back.setTranslateX(-539);
							back.setTranslateY(370);
							back.setPrefSize(200,60);
							frame.setWidth(800);
						    frame.setHeight(600);
						    HBox hbox=new HBox();
					        hbox.getChildren().add(user);
					        hbox.getChildren().add(type);
							hbox.getChildren().add(accept_request);
						    hbox.getChildren().add(reject_request);
						    hbox.getChildren().add(back);
					        ((Group)scene.getRoot()).getChildren().add(hbox);
						    frame.setScene(scene);
					        frame.show();
						}
						
					});
					Button view_timetable=new Button("View Room Status");
					view_timetable.setOnAction(new EventHandler<ActionEvent>() 
					{

						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							Stage frame=new Stage();
							frame.setTitle("Classroom Booking System");
							Scene scene=new Scene(new Group());
							Label user=new Label("Username: "+username);
							user.setMinWidth(170);
							user.setMaxWidth(170);
							Label type=new Label("Type: Admin");
							user.setFont(Font.font("Serif",17));
							user.setTranslateX(600);
							user.setTranslateY(20);
							type.setFont(Font.font("Serif",17));
							type.setTranslateX(430);
						    type.setTranslateY(35);
						    TextField room_no=new TextField();
						    room_no.setPromptText("Enter Room Number");
						    room_no.setTranslateX(-250);
						    room_no.setTranslateY(400);
						    room_no.setPrefWidth(200);
						    Button book_room=new Button(" Book Room ");
						    book_room.setTranslateX(-245);
						    book_room.setTranslateY(400);
						    Button cancel_room=new Button("Cancel Room");
						    cancel_room.setTranslateX(-240);
						    cancel_room.setTranslateY(400);
						    Button back=new Button("Back");
							back.setOnAction(new exit());
							back.setTranslateX(360);
							back.setTranslateY(490);
							back.setPrefSize(100,30);
						    frame.setWidth(800);
						    frame.setHeight(600);
						    HBox hbox=new HBox();
					        hbox.getChildren().add(user);
					        hbox.getChildren().add(type);
					        hbox.getChildren().add(back);
					        hbox.getChildren().add(room_no);
					        hbox.getChildren().add(book_room);
					        hbox.getChildren().add(cancel_room);
					        ((Group)scene.getRoot()).getChildren().add(hbox);
						    frame.setScene(scene);
					        frame.show();
						}
						
					});
					view_timetable.setTranslateX(-339);
					view_timetable.setTranslateY(260);
					view_timetable.setPrefSize(200,60);
					Button log_out=new Button("Log Out");
					log_out.setOnAction(new exit());
					log_out.setTranslateX(-539);
					log_out.setTranslateY(370);
					log_out.setPrefSize(200,60);
					frame.setWidth(800);
				    frame.setHeight(600);
				    HBox hbox=new HBox();
			        hbox.getChildren().add(user);
			        hbox.getChildren().add(type);
			        hbox.getChildren().add(view_request);
			        hbox.getChildren().add(view_timetable);
			        hbox.getChildren().add(log_out);
			        ((Group)scene.getRoot()).getChildren().add(hbox);
			        frame.setScene(scene);
			        frame.show();
				}
				
				else if(login_text[4].getText().equals("Faculty"))
				{
					Stage frame=new Stage();
					frame.setTitle("Classroom Booking System");
					Scene scene=new Scene(new Group());
					Label user=new Label("Username: "+username);
					user.setMinWidth(170);
					user.setMaxWidth(170);
					Label type=new Label("Type: Faculty");
					user.setFont(Font.font("Serif",17));
					user.setTranslateX(600);
					user.setTranslateY(20);
					type.setFont(Font.font("Serif",17));
					type.setTranslateX(430);
				    type.setTranslateY(35);
					Button view_timetable=new Button("View Room Status");
					view_timetable.setOnAction(new EventHandler<ActionEvent>() 
					{

						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							Stage frame=new Stage();
							frame.setTitle("Classroom Booking System");
							Scene scene=new Scene(new Group());
							Label user=new Label("Username: "+username);
							user.setMinWidth(170);
							user.setMaxWidth(170);
							Label type=new Label("Type: Faculty");
							user.setFont(Font.font("Serif",17));
							user.setTranslateX(600);
							user.setTranslateY(20);
							type.setFont(Font.font("Serif",17));
							type.setTranslateX(430);
						    type.setTranslateY(35);
						    TextField room_no=new TextField();
						    room_no.setPromptText("Enter Room Number");
						    room_no.setTranslateX(-250);
						    room_no.setTranslateY(400);
						    room_no.setPrefWidth(200);
						    Button book_room=new Button(" Book Room ");
						    book_room.setTranslateX(-245);
						    book_room.setTranslateY(400);
						    Button cancel_room=new Button("Cancel Room");
						    cancel_room.setTranslateX(-240);
						    cancel_room.setTranslateY(400);
						    Button back=new Button("Back");
							back.setOnAction(new exit());
							back.setTranslateX(360);
							back.setTranslateY(490);
							back.setPrefSize(100,30);
						    frame.setWidth(800);
						    frame.setHeight(600);
						    HBox hbox=new HBox();
					        hbox.getChildren().add(user);
					        hbox.getChildren().add(type);
					        hbox.getChildren().add(back);
					        hbox.getChildren().add(room_no);
					        hbox.getChildren().add(book_room);
					        hbox.getChildren().add(cancel_room);
					       ((Group)scene.getRoot()).getChildren().add(hbox);
						    frame.setScene(scene);
					        frame.show();
						}
						
					});
					view_timetable.setTranslateX(-139);
					view_timetable.setTranslateY(200);
					view_timetable.setPrefSize(200,60);
					Button log_out=new Button("Log Out");
					log_out.setOnAction(new exit());
					log_out.setTranslateX(-339);
					log_out.setTranslateY(350);
					log_out.setPrefSize(200,60);
					frame.setWidth(800);
				    frame.setHeight(600);
				    HBox hbox=new HBox();
			        hbox.getChildren().add(user);
			        hbox.getChildren().add(type);
			        hbox.getChildren().add(view_timetable);
			        hbox.getChildren().add(log_out);
			        ((Group)scene.getRoot()).getChildren().add(hbox);
			        frame.setScene(scene);
			        frame.show();
				}
				else if(login_text[4].getText().equals("Student"))
				{
					
				}
			}
			
		});
		Log_in.setTranslateX(-2110);
		Log_in.setTranslateY(400);
		Button exit=new Button("   Exit   ");
		exit.setOnAction(new exit());
		exit.setTranslateX(-1940);
		exit.setTranslateY(500);
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
        HBox.setHgrow(exit,null);
        for(int i=0;i<6;i++)
        	hbox.getChildren().add(login_text[i]);
        hbox.getChildren().add(Sign_up);
        hbox.getChildren().add(Log_in);
        hbox.getChildren().add(exit); 
        ((Group)scene.getRoot()).getChildren().add(hbox);
        frame.setScene(scene);
        frame.show();
	}

}


