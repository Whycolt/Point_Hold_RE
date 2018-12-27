package panels;

import java.util.Observer;

import Point_Hold_RE.Size;
import controllers.PHController;

import java.awt.TextField;
import java.util.Observable;
import javafx.scene.layout.Pane;
import models.PHModel;
import javafx.scene.*;
import javafx.scene.control.Button;

/**
 * Panel for presenting menus
 * @author coltm
 *
 */
public class MenuPanel extends Pane implements Observer{
	
	private PHModel model;//model
	private PHController controller;//controller
	private Pane current;//active panel
	private HomePanel home;//home panel
	private InstructionPanel instruction;//instruction panel
	
	/**
	 * Constructor for MenuPanel
	 * @param model
	 * @param controller
	 */
	public MenuPanel(PHModel model, PHController controller) {
		this.setStyle("-fx-background-color: blue");
		this.setPrefSize(Size.x,Size.y);
		this.model = model;
		this.model.addObserver(this);
		this.controller = controller;
		menuSetup();
		current = home;
		this.getChildren().add(current);
	}
	
	/**
	 * Setup panels
	 */
	private void menuSetup() {
		home = new HomePanel(controller);
		instruction = new InstructionPanel(controller);
	}
	
	/**
	 * Changes menu panels
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		this.getChildren().remove(current);
		switch(model.getState()) {
			case 0:
				current = home;
				break;
			case 2:
				current = instruction;
				break;
		}
		this.getChildren().add(current);
	}
	
}
