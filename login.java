import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
					Stage frame=new Stage();
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
//								Stage frame=new Stage();
//									
//							    frame.setScene(scene);
//							    frame.show();
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
//									        hbox.getChildren().add(back);
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
//							        hbox.getChildren().add(back);
							        ((Group)scene.getRoot()).getChildren().add(hbox);
								    frame.setScene(scene);
							        frame.show();
				 				}
				 						
				 			});	 

				    
					frame.setWidth(800);
				    frame.setHeight(600);
				    HBox hbox=new HBox();
				    Button logout=new Button("LogOut");
					logout.setOnAction(new exit());
					logout.setTranslateX(-1700);
					logout.setTranslateY(490);
					logout.setPrefSize(200,40);
				    hbox.getChildren().add(label1);
				    hbox.getChildren().add(label2);
				    hbox.getChildren().add(search_box);
				    hbox.getChildren().add(okay);
			        for(int i=0;i<5;++i) {

			        	hbox.getChildren().add(buttons[i]);
			        }
			        hbox.getChildren().add(logout);
			        ((Group)scene.getRoot()).getChildren().add(hbox);
			        frame.setScene(scene);
			        frame.show();

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


class exit implements EventHandler<ActionEvent>
{

	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		((Node)(arg0.getSource())).getScene().getWindow().hide();
	}
	
}