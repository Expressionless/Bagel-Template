package main.engine.state;

import main.game.Engine;

public class MenuState extends State {

	public MenuState() {
		super("Menu State");
	}

	@Override
	public void init() {
		if(initialized)
			return;
		initialized = true;
		
		Engine.setState(Engine.gameState);
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {

	}

}
