package main.game.state;

import bagel.Window;
import main.engine.state.State;
import main.game.Game;

public class GameState extends State {

	private Game game;
	
	public GameState() {
		super("Game State");
	}

	@Override
	public void init() {
		Window.setClearColour(0.5, 0.5, 0.5);
		game = new Game();
	}

	@Override
	public void update() {
		game.update();
	}

	@Override
	public void render() {
		game.render();
	}

}
