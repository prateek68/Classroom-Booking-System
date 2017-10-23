
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
import javafx.scene.control.ComboBox;

public class Student_page extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
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
	    // search bar
	    TextField search_box=new TextField();
	    search_box.setPromptText("Search your Course here");
	    search_box.setTranslateX(-650);
	    search_box.setTranslateY(110);
	    search_box.setPrefSize(450,40);
	    Button okay=new Button("OK");
	    okay.setTranslateX(-650);
	    okay.setTranslateY(110);
	    okay.setPrefSize(70, 40);	
	    okay.setOnAction(new EventHandler<ActionEvent>() 
			{

				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
//					Stage frame=new Stage();
//						
//				    frame.setScene(scene);
//				    frame.show();
				}
						
			});	    
	    
	    Button[] buttons=new Button[6];
	    //view room status button
	    buttons[0]=new Button("View Room Status");
	    buttons[0].setTranslateX(-1200);
	    buttons[0].setTranslateY(180);
	    buttons[0].setPrefSize(200, 40);
	    buttons[0].setOnAction(new EventHandler<ActionEvent>() 
	 			{

	 				public void handle(ActionEvent arg0) {
	 					// TODO Auto-generated method stub
	 					Stage frame=new Stage();
						frame.setTitle("Room Status");
						Scene scene=new Scene(new Group());
						Label user=new Label("Username: ");
						user.setMinWidth(170);
						user.setMaxWidth(170);
						Label type=new Label("Type: Student");
						user.setFont(Font.font("Serif",17));
						user.setTranslateX(600);
						user.setTranslateY(20);
						type.setFont(Font.font("Serif",17));
						type.setTranslateX(430);
					    type.setTranslateY(35);
					    
					    TextField room=new TextField();
					    room.setPromptText("Enter the room number");
					    room.setTranslateX(-200);
					    room.setTranslateY(150);
					    room.setPrefSize(300,40);					    
					    
					    Label status =new Label("Status");
					    status.setTranslateX(-200);
					    status.setTranslateY(150);
					    status.setPrefSize(300, 40);
					    Button get_status=new Button("Get Status");
					    get_status.setTranslateX(-800);
					    get_status.setTranslateY(250);
					    get_status.setPrefSize(200, 40);
					    get_status.setOnAction(new EventHandler<ActionEvent>() 
					    {

					    		public void handle(ActionEvent arg0) {
					    			// TODO Auto-generated method stub
					    			status.setText("Updated Status");
					    		}
	 						
					    });	 
					    
					    Button back=new Button("Back");
						back.setOnAction(new exit());
						back.setTranslateX(60);
						back.setTranslateY(450);
						back.setPrefSize(100,30);
					    frame.setWidth(800);
					    frame.setHeight(600);
					    HBox hbox=new HBox();
				        hbox.getChildren().add(user);
				        hbox.getChildren().add(type);
				        hbox.getChildren().add(room);
				        hbox.getChildren().add(back);
				        hbox.getChildren().add(status);
				        hbox.getChildren().add(get_status);
				        ((Group)scene.getRoot()).getChildren().add(hbox);
					    frame.setScene(scene);
				        frame.show();
	 				}
	 						
	 			});	 
	    
	  //Request button
	    buttons[1]=new Button("Request");
	    buttons[1].setTranslateX(-1400);
	    buttons[1].setTranslateY(250);
	    buttons[1].setPrefSize(200, 40);
	    buttons[1].setOnAction(new EventHandler<ActionEvent>() 
	 			{

	 				public void handle(ActionEvent arg0) {
	 					// TODO Auto-generated method stub
	 					Stage frame=new Stage();
						frame.setTitle("Requests");
						Scene scene=new Scene(new Group());
						Label user=new Label("Username: ");
						user.setMinWidth(170);
						user.setMaxWidth(170);
						Label type=new Label("Type: Student");
						user.setFont(Font.font("Serif",17));
						user.setTranslateX(600);
						user.setTranslateY(20);
						type.setFont(Font.font("Serif",17));
						type.setTranslateX(430);
					    type.setTranslateY(35);
					    Button new_request=new Button("Make new Request");
					    Button cancel_request=new Button("Cancel Existing Requests");
					    new_request.setTranslateX(-200);
					    new_request.setTranslateY(250);
					    new_request.setPrefSize(200, 40);
					    new_request.setOnAction(new EventHandler<ActionEvent>()
					    		{

									@Override
									public void handle(ActionEvent arg0) {
										// TODO Auto-generated method stub
										Stage frame=new Stage();
										frame.setTitle("Make new Request");
										Scene scene=new Scene(new Group());
										Label user=new Label("Username: ");
										user.setMinWidth(170);
										user.setMaxWidth(170);
										Label type=new Label("Type: Student");
										user.setFont(Font.font("Serif",17));
										user.setTranslateX(600);
										user.setTranslateY(20);
										type.setFont(Font.font("Serif",17));
										type.setTranslateX(430);
									    type.setTranslateY(35);
									    
									    Label info=new Label("Purpose  ");
									    Label prefRoom=new Label("Preferred Room Number");
									    Label expTurnout=new Label("Expected Turnout");
									    info.setPrefSize(300, 40);
									    prefRoom.setPrefSize(300, 40);
									    expTurnout.setPrefSize(300, 40);
									    info.setTranslateX(-250);
									    info.setTranslateY(130);
									    prefRoom.setTranslateX(-550);
									    prefRoom.setTranslateY(200);
									    expTurnout.setTranslateX(-850);
									    expTurnout.setTranslateY(270);
									    
									    TextField getinfo=new TextField();
									    TextField getprefRoom=new TextField();
									    TextField getexpTurnout=new TextField();
									    getinfo.setPromptText("Fill the Purspose for which you need the room");
									    getprefRoom.setPromptText("Fill the preferred room number");
									    getexpTurnout.setPromptText("Write expected turnout here");
									    getinfo.setPrefSize(350, 40);
									    getprefRoom.setPrefSize(350, 40);
									    getexpTurnout.setPrefSize(350, 40);
									    getinfo.setTranslateX(-900);
									    getinfo.setTranslateY(130);
									    getprefRoom.setTranslateX(-1250);
									    getprefRoom.setTranslateY(200);
									    getexpTurnout.setTranslateX(-1600);
									    getexpTurnout.setTranslateY(270);
									    
									    Button submit_request=new Button("Submit");
									    submit_request.setPrefSize(200, 40);
									    submit_request.setTranslateX(-2000);
									    submit_request.setTranslateY(380);
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
								        hbox.getChildren().add(info);
								        hbox.getChildren().add(prefRoom);
								        hbox.getChildren().add(expTurnout);
								        hbox.getChildren().add(getinfo);
								        hbox.getChildren().add(getprefRoom);
								        hbox.getChildren().add(getexpTurnout);
								        hbox.getChildren().add(submit_request);
								        ((Group)scene.getRoot()).getChildren().add(hbox);
									    frame.setScene(scene);
								        frame.show();
									}
					    	
					    		});
					    cancel_request.setTranslateX(-400);
					    cancel_request.setTranslateY(330);
					    cancel_request.setPrefSize(200, 40);
					    cancel_request.setOnAction(new EventHandler<ActionEvent>()
			    		{

							@Override
							public void handle(ActionEvent arg0) {
								// TODO Auto-generated method stub
								Stage frame=new Stage();
								frame.setTitle("Cancel Request");
								Scene scene=new Scene(new Group());
								Label user=new Label("Username: ");
								user.setMinWidth(170);
								user.setMaxWidth(170);
								Label type=new Label("Type: Student");
								user.setFont(Font.font("Serif",17));
								user.setTranslateX(600);
								user.setTranslateY(20);
								type.setFont(Font.font("Serif",17));
								type.setTranslateX(430);
							    type.setTranslateY(35);
							    
							    Label req=new Label();
							    ComboBox<String> all_requests = new ComboBox<String>();
							    all_requests.getItems().addAll("A","B","C","D","E");
							    all_requests.setVisibleRowCount(3);
							    all_requests.setPromptText("Select the request");
							    req.setText(all_requests.getPromptText());
							    // change String to Courses once we create the class
							    all_requests.setOnAction((ActionEvent e) -> {
							    	all_requests.setPromptText(all_requests.getSelectionModel().getSelectedItem().toString());
							    	req.setText(all_requests.getPromptText());
							    });
							    all_requests.setTranslateX(-250);
							    all_requests.setTranslateY(150);
							    all_requests.setPrefSize(300, 40);
							    req.setTranslateX(-150);
							    req.setTranslateY(150);
							    req.setPrefSize(300, 40);
							    
							    Button cancel=new Button("Cancel Request");
							    cancel.setTranslateX(-800);
							    cancel.setTranslateY(250);
							    cancel.setPrefSize(200, 40);
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
						        hbox.getChildren().add(all_requests);
						        hbox.getChildren().add(req);
						        hbox.getChildren().add(cancel);
//						        hbox.getChildren().add(back);
						        ((Group)scene.getRoot()).getChildren().add(hbox);
							    frame.setScene(scene);
						        frame.show();
							}
			    	
			    		});
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
				        hbox.getChildren().add(new_request);
				        hbox.getChildren().add(cancel_request);
				        ((Group)scene.getRoot()).getChildren().add(hbox);
					    frame.setScene(scene);
				        frame.show();
	 				}
	 						
	 			});	 
	  //View Timetable button
	    buttons[2]=new Button("View Timetable");
	    buttons[2].setTranslateX(-1600);
	    buttons[2].setTranslateY(320);
	    buttons[2].setPrefSize(200, 40);
	    buttons[2].setOnAction(new EventHandler<ActionEvent>() 
	 			{

	 				public void handle(ActionEvent arg0) {
	 					// TODO Auto-generated method stub
	 					Stage frame=new Stage();
						frame.setTitle("TimeTable");
						Scene scene=new Scene(new Group());
						Label user=new Label("Username: ");
						user.setMinWidth(170);
						user.setMaxWidth(170);
						Label type=new Label("Type: Student");
						user.setFont(Font.font("Serif",17));
						user.setTranslateX(600);
						user.setTranslateY(20);
						type.setFont(Font.font("Serif",17));
						type.setTranslateX(430);
					    type.setTranslateY(35);
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
				        ((Group)scene.getRoot()).getChildren().add(hbox);
					    frame.setScene(scene);
				        frame.show();
	 				}
	 						
	 			});	 
	  //View Personalized Timetable button
	    buttons[3]=new Button("View Personalized Timetable");
	    buttons[3].setTranslateX(-1800);
	    buttons[3].setTranslateY(390);
	    buttons[3].setPrefSize(200, 40);
	    buttons[3].setOnAction(new EventHandler<ActionEvent>() 
	 			{

	 				public void handle(ActionEvent arg0) {
	 					// TODO Auto-generated method stub
	 					Stage frame=new Stage();
						frame.setTitle("Personalized TimeTable");
						Scene scene=new Scene(new Group());
						Label user=new Label("Username: ");
						user.setMinWidth(170);
						user.setMaxWidth(170);
						Label type=new Label("Type: Student");
						user.setFont(Font.font("Serif",17));
						user.setTranslateX(600);
						user.setTranslateY(20);
						type.setFont(Font.font("Serif",17));
						type.setTranslateX(430);
					    type.setTranslateY(35);
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
				        ((Group)scene.getRoot()).getChildren().add(hbox);
					    frame.setScene(scene);
				        frame.show();
	 				}
	 						
	 			});	 
	  //Edit Course button
	    buttons[4]=new Button("Edit Course");
	    buttons[4].setTranslateX(-2000);
	    buttons[4].setTranslateY(460);
	    buttons[4].setPrefSize(200, 40);
	    buttons[4].setOnAction(new EventHandler<ActionEvent>() 
	 			{

	 				public void handle(ActionEvent arg0) {
	 					// TODO Auto-generated method stub
	 					Stage frame=new Stage();
						frame.setTitle("Edit Course");
						Scene scene=new Scene(new Group());
						Label user=new Label("Username: ");
						user.setMinWidth(170);
						user.setMaxWidth(170);
						Label type=new Label("Type: Student");
						user.setFont(Font.font("Serif",17));
						user.setTranslateX(600);
						user.setTranslateY(20);
						type.setFont(Font.font("Serif",17));
						type.setTranslateX(430);
					    type.setTranslateY(35);
					    
					    Label selected_course=new Label();
					    ComboBox<String> courses = new ComboBox<String>();
					    courses.getItems().addAll("A","B","C","D","E");
					    courses.setVisibleRowCount(3);
					    courses.setPromptText("Select your course");
					    selected_course.setText(courses.getPromptText());
					    // change String to Courses once we create the class
					    courses.setOnAction((ActionEvent e) -> {
					    	courses.setPromptText(courses.getSelectionModel().getSelectedItem().toString());
					    	selected_course.setText(courses.getPromptText());
					    });
					    courses.setTranslateX(-250);
					    courses.setTranslateY(150);
					    courses.setPrefSize(300, 40);
					    selected_course.setTranslateX(-150);
					    selected_course.setTranslateY(150);
					    selected_course.setPrefSize(300, 40);
					    
					    Button add=new Button("Add Course");
					    Button del=new Button("Delete course");
					    add.setTranslateX(-800);
					    add.setTranslateY(250);
					    add.setPrefSize(200, 40);
					    del.setTranslateX(-1000);
					    del.setTranslateY(350);
					    del.setPrefSize(200, 40);
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
				        hbox.getChildren().add(courses);
				        hbox.getChildren().add(selected_course);
				        hbox.getChildren().add(add);
				        hbox.getChildren().add(del);
//				        hbox.getChildren().add(back);
				        ((Group)scene.getRoot()).getChildren().add(hbox);
					    frame.setScene(scene);
				        frame.show();
	 				}
	 						
	 			});	 

	    
		frame.setWidth(800);
	    frame.setHeight(600);
	    HBox hbox=new HBox();
	    hbox.getChildren().add(label1);
	    hbox.getChildren().add(label2);
	    hbox.getChildren().add(search_box);
	    hbox.getChildren().add(okay);
        for(int i=0;i<5;++i) {

        	hbox.getChildren().add(buttons[i]);
        }

        ((Group)scene.getRoot()).getChildren().add(hbox);
        frame.setScene(scene);
        frame.show();
	}

}
