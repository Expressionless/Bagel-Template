package main.game;

import static main.game.Constants.FRAME_HEIGHT;
import static main.game.Constants.FRAME_TITLE;
import static main.game.Constants.FRAME_WIDTH;

import java.util.logging.Logger;

import bagel.AbstractGame;
import bagel.Input;
import bagel.Window;
import main.engine.state.GameState;
import main.engine.state.MenuState;
import main.engine.state.State;

/**
 * Basic Game Class that handles States and an entry point into the Game Loop
 * @author bmeachem
 *
 */
public class Engine extends AbstractGame {
	private static final Logger log = Logger.getLogger(Engine.class.getName());

	public static final State menuState = new MenuState();
	public static final State gameState = new GameState();
	
	private static State currentState;
	
	public Engine() {
        super(FRAME_WIDTH, FRAME_HEIGHT, FRAME_TITLE);
		Window.setClearColour(0.0, 0.0, 0.0);
        setState(menuState);
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
		if(!state.isInitialized())
			state.init();
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
}
