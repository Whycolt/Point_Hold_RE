package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import models.PHModel;

public class InstructionController extends MenuController{

	private PHModel model;//model
	
	/**
	 * Constructor for start controller
	 * @param model of Point Hold
	 */
	public InstructionController(PHModel model) {
		this.model = model;
	}

	/**
	 * Acts on model given events
	 */
	@Override
	public void handle(ActionEvent arg0) {
		String task = ((Button) arg0.getSource()).getText();
		if (task.compareTo("Back") == 0) {
			System.out.println("Back");
			model.ChangeState(0);
		}
	}


}
