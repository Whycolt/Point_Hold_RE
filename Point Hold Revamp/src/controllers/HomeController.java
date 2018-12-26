package controllers;

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
			model.ChangeState(1);
			System.out.println("start");
		}
	}

}
