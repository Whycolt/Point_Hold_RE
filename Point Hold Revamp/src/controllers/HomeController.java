package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import models.PHModel;

/**
 * Controller for start menu
 * @author coltm
 *
 */

public class HomeController extends MenuController {

	private PHModel model;//model
	
	/**
	 * Constructor for start controller
	 * @param model of Point Hold
	 */
	public HomeController(PHModel model) {
		this.model = model;
	}

	/**
	 * Acts on model given events
	 */
	@Override
	public void handle(ActionEvent arg0) {
		String task = ((Button) arg0.getSource()).getText();
		if (task.compareTo("Start") == 0) {
			System.out.println("start");
			model.createGame();
		}
		if (task.compareTo("Instructions") == 0) {
			System.out.println("Instructions");
			model.ChangeState(2);
		}
		if (task.compareTo("Exit") == 0) {
			System.out.println("Exit");
			Platform.exit();
		}
	}

}
