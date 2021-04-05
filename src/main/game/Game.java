package main.game;

import java.util.logging.Logger;

import bagel.Input;
import main.engine.GameObject;
import main.engine.utils.Point;
import main.engine.view.Camera;

public class Game {
	private static final Logger log = Logger.getLogger(Game.class.getName());

	private Camera camera;

	public Game() {
	}

	/**
	 * Start a new Game
	 */
	public void start() {
		Point startPoint = new Point();
		camera = new Camera(startPoint);
		log.info("Starting new Game");
	}

	// Update all objects here
	public void update(Input input) {
		GameObject.updateAll(camera, input);
	}

	// Render all objects that need rendering here
	public void render() {
		GameObject.renderAll(camera);
	}
}
