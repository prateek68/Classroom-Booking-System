package APproject.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * class to display error messages
 * @author  Prateek and Vaibhav
 */
public class error_controller {

	@FXML
	Label room;
	@FXML
	public Button exit;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage=(Stage) exit.getScene().getWindow();
	    stage.close();
	}
	
}
