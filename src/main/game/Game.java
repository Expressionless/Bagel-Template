package main.game;

import static main.game.Constants.FRAME_HEIGHT;
import static main.game.Constants.FRAME_TITLE;
import static main.game.Constants.FRAME_WIDTH;

import bagel.AbstractGame;
import bagel.Input;
import main.engine.state.GameState;
import main.engine.state.MenuState;
import main.engine.state.State;

/**
 * Basic Game Class that handles States and an entry point into the Game Loop
 * @author bmeachem
 *
 */
public class Game extends AbstractGame {

	public static final State menuState = new MenuState();
	public static final State gameState = new GameState();
	
	public Game() {
        super(FRAME_WIDTH, FRAME_HEIGHT, FRAME_TITLE);
	}

	@Override
	/**Game Loop.
	 * Update the current state, and then render it
	 */
	protected void update(Input input) {

	}
}
