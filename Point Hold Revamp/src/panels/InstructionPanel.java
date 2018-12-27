package panels;

import java.util.ArrayList;

import Point_Hold_RE.Size;
import controllers.PHController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Panel for home menu
 * @author coltm
 *
 */
public class InstructionPanel extends Pane{

	private PHController controller;//controller
	
	/**
	 * Constructor for HomePanel
	 * @param controller
	 */
	public InstructionPanel(PHController controller) {
		this.controller = controller;
		ArrayList<String> buttonNames = new ArrayList<String>();
		buttonNames.add("Back");
		ButtonSetup(buttonNames);
	}
	
	/**
	 * Setup buttons on home panel
	 */
	private void ButtonSetup(ArrayList<String> buttonNames) {
		for (String s: buttonNames) {
			Button button = new Button(s);
			this.getChildren().add(button);
			button.setPrefSize(100, 50);
			button.setLayoutX(Size.x/2-50);
			button.setLayoutY(Size.y/2 + 80*buttonNames.indexOf(s)-25);
			button.setOnAction(controller);
		}
		//button.setStyle("-fx-text-fill: transparent"); for images on the button
	}
	
}
