package main.game.state;

import main.engine.menu.Menu;
import main.engine.res.Sprite;
import main.engine.state.State;
import main.game.menu.MainMenu;

public class MenuState extends State {

	Menu mainMenu;
	
	public MenuState() {
		super("Menu State");
	}

	@Override
	public void init() {
		if(initialized)
			return;
		initialized = true;
		mainMenu = new MainMenu();
	}

	@Override
	public void update() {
		if(mainMenu != null)
			mainMenu.updateElements();
	}

	@Override
	public void render() {
		if(mainMenu != null)
			mainMenu.renderElements();
	}

}
