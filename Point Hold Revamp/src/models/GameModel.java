package models;

import java.util.ArrayList;
import java.util.Observable;
import javafx.scene.canvas.GraphicsContext;


/**
 * Model of the actual game Point Hold
 * @author coltm
 *
 */
public class GameModel extends Observable{
	
	private ArrayList<Entity> e;//List of entities in game
	private ArrayList<Entity> f;//List of friendly entities in the game
	private ArrayList<Entity> removed;//list of removed elements
	private ArrayList<Entity> added;
	private ArrayList<Entity> addedF;
	private ArrayList<Entity> removedF;
	private Player player;
	private boolean isRunning;
	
	/**
	 * Constructor for GameModel
	 */
	public GameModel() {
		f = new ArrayList<Entity>();
		e = new ArrayList<Entity>();
		removed = new ArrayList<Entity>();
		added = new ArrayList<Entity>();
		removedF = new ArrayList<Entity>();
		addedF = new ArrayList<Entity>();
		player = new Player();
		f.add(player);
		isRunning = true;
	}
	
	public void end() {
		isRunning = false;
	}
	
	public boolean isGoing() {
		return isRunning;
	}
	
	public void add(Entity e) {
		added.add(e);
	}
	
	public void addF(Entity e){
		addedF.add(e);
	}
	
	public ArrayList<Entity> getF(){
		return f;
	}
	
	public void removeF(Entity e) {
		removedF.add(e);
	}
	
	/**
	 * Performs the actions of the entities in the game
	 */
	public void execute() {
		for (Entity i:e) {
			i.action(this);
		}
		for (Entity i:f) {
			i.action(this);
		}
		for (Entity i:removed) {
			e.remove(i);
		}
		for (Entity i:added) {
			e.add(i);
		}
		for (Entity i:removedF) {
			f.remove(i);
		}
		for (Entity i:addedF) {
			f.add(i);
		}
		removed.clear();
		added.clear();
		removedF.clear();
		addedF.clear();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void remove(Entity e) {
		removed.add(e);
	}
	
	/**
	 * Draws all items in the game
	 * @param g
	 */
	public void draw(GraphicsContext g) {
		for (Entity i:e) {
			i.draw(g);
		}
		for (Entity i:f) {
			i.draw(g);
		}
		player.draw(g);
	}
	
	public Player getPlayer() {
		return player;
	}
	
}

