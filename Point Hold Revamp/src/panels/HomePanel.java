package panels;

import controllers.PHController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Panel for home menu
 * @author coltm
 *
 */
public class HomePanel extends Pane{

	private PHController controller;//controller
	
	/**
	 * Constructor for HomePanel
	 * @param controller
	 */
	public HomePanel(PHController controller) {
		this.controller = controller;
		ButtonSetup();
	}
	
	/**
	 * Setup buttons on home panel
	 */
	private void ButtonSetup() {
		Button button = new Button("Start");
		this.getChildren().add(button);
		button.setPrefSize(100, 50);
		button.setLayoutX(350);
		button.setLayoutY(275);
		button.setOnAction(controller);
		//button.setStyle("-fx-text-fill: transparent");
	}
	
}
