package main.game.menu;

import main.engine.menu.Menu;
import main.game.Constants;
import main.game.Engine;
import main.game.state.MenuState;

public class StartMenu extends Menu {

	public StartMenu(MenuState menuState) {
		super("Start Menu", menuState);
	}

	@Override
	public void loadButtons() {
		final double x = 0;
		final double y = Constants.FRAME_HEIGHT / 2;
		
		final double button_height = Engine.RES.getSprite("button.png").getHeight();
		final double margin = button_height + MainMenu.BUTTON_MARGIN;

		createButton("new game", x, y);
		createButton("load game", x, y + margin);
		createButton("back", x, y + margin * 2);
	}

}
