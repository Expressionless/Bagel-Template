package main.game;

import static main.game.Constants.FRAME_HEIGHT;
import static main.game.Constants.FRAME_TITLE;
import static main.game.Constants.FRAME_WIDTH;

import java.util.logging.Logger;

import bagel.AbstractGame;
import bagel.Input;
import bagel.Window;
import main.engine.state.State;
import main.engine.utils.ResourceManager;
import main.game.state.GameState;
import main.game.state.MenuState;

/**
 * Basic Game Class that handles States and an entry point into the Game Loop
 * @author bmeachem
 *
 */
public class Engine extends AbstractGame {
	private static final Logger log = Logger.getLogger(Engine.class.getName());
	public static final ResourceManager RES = new ResourceManager();
	
	private Thread resourceThread;

	public static final State menuState = new MenuState();
	public static final State gameState = new GameState();
	
	
	private static State currentState;
	
	/**
	 * Load resources here
	 */
	private void loadResources() {
		// Sprites
		RES.setActiveDir("\\res\\tiles\\");
		RES.addJob("Sprite", "grass.png");
		RES.setActiveDir("\\res\\menu\\");
		RES.addJob("Sprite", "button.png");
	}
	
	public Engine() {
        super(FRAME_WIDTH, FRAME_HEIGHT, FRAME_TITLE);
		Window.setClearColour(0.0, 0.0, 0.0);
		
		resourceThread = new Thread(RES);
		RES.run();
        setState(menuState);
		loadResources();
	}

	@Override
	/**Game Loop.
	 * Update the current state, and then render it
	 */
	protected void update(Input input) {
		if(currentState != null) {
			currentState.update();
			currentState.render();
		}
	}
	
	/**
	 * Set the State of the game and initialize it if not already initialized
	 * @param state
	 */
	public static void setState(State state) {
		if(state == null) {
			log.severe("Attempted to set state to null!");
			return;
		}
		if(!state.isInitialized()) {
			log.info("Initializing state: " + state.getName());
			state.init();
		}
		log.info("Setting state to: " + state.getName());
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
}
