package Point_Hold_RE;

import controllers.PHController;
import javafx.application.*;
import javafx.stage.*;
import models.PHModel;
import panels.PHView;

/**
 * Point Hold Revamped: A newer, more elegant version of Point Hold - A simple top down shooter 
 * @author coltm
 *
 */

public class Point_Hold_RE extends Application{

	private PHModel model; //Model
	private PHView view; //View
	private PHController controller; //Controller
	
	/**
	 * Main method
	 * @param args Main arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Start of application
	 */
	@Override
	public void start(Stage stage) throws Exception {
		this.model = new PHModel();
		this.controller = new PHController(model,stage);
		this.view = new PHView(controller,model, stage);
		
	}

	
}
