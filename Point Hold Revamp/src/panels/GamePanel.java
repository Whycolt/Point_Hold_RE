package panels;

import java.util.Observer;

import Point_Hold_RE.Size;
import controllers.GameTimer;
import controllers.KeyPressed;
import controllers.KeyReleased;
import controllers.PHController;
import java.util.Observable;
import javafx.scene.layout.Pane;
import models.Entity;
import models.GameModel;
import models.PHModel;
import javafx.animation.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.input.KeyEvent; 
import javafx.scene.*;

/**
 * Panel for presenting actual game of Point Hold
 * @author coltm
 *
 */

public class GamePanel extends Pane implements Observer{

		private PHModel model;
		private GameModel game;
		private PHController controller;
		private Canvas canvas;
		private KeyPressed keyP;
		private KeyReleased keyR;
		private Scene scene;

		
		public GamePanel(PHModel model, PHController controller, Scene scene) {
			setStyle("-fx-background-color: grey");
			setPrefSize(Size.x,Size.y);
			this.model = model;
			this.controller = controller;
			this.scene = scene;
			canvas = new Canvas(Size.x,Size.y);
			this.getChildren().add(canvas);
			}
		
		public void gameInit() {
			game = model.getGame();
			game.addObserver(this);
			keyP = new KeyPressed(game);
			keyR = new KeyReleased(game);
			scene.setOnKeyPressed(keyP);
			scene.setOnKeyReleased(keyR);
			System.out.println("keyadded");
		}
		
		public void repaint() {
			GraphicsContext g =	this.canvas.getGraphicsContext2D();
			g.clearRect(0, 0, Size.x, Size.y);
			game.draw(g);
		}
		
		@Override
		public void update(Observable arg0, Object arg1) {
			this.repaint();
		}
	}

