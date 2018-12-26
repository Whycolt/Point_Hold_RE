package panels;

import java.util.Observer;

import controllers.PHController;

import java.awt.TextField;
import java.util.Observable;
import javafx.scene.layout.Pane;
import models.PHModel;
import javafx.scene.*;
import javafx.scene.control.Button;

/**
 * Panel for presenting actual game of Point Hold
 * @author coltm
 *
 */

//TODO
public class GamePanel extends Pane implements Observer{

		private PHModel model;
		private PHController controller;
		
		public GamePanel(PHModel model, PHController controller) {
			this.setStyle("-fx-background-color: blue");
			this.setPrefSize(800,600);
			this.model = model;
			this.model.addObserver(this);
			this.controller = controller;
			Button button = new Button("STOP");
			button.setOnAction(controller);
			this.getChildren().add(button);
			button.setPrefSize(100, 50);
			button.setLayoutX(350);
			button.setLayoutY(275);
			//button.setStyle("-fx-text-fill: transparent");
			
		}

		public void repaint() {
			
		}
		
		@Override
		public void update(Observable arg0, Object arg1) {
			this.repaint();
			
		}
		
	}

