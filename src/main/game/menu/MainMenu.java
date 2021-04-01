package main.game.menu;

import main.engine.menu.Menu;
import main.game.Constants;
import main.game.Engine;
import main.game.state.MenuState;

public class MainMenu extends Menu {
	
	// Some arbitrary constant to space out the buttons
	public static final int BUTTON_MARGIN = 30;
	
	public MainMenu(MenuState menuState) {
		super("Main menu", menuState);
	}
	
	public void loadButtons() {
		
		final double x = Constants.FRAME_WIDTH / 2 - Engine.RES.getSprite("button.png").getWidth() / 2;
		final double y = Constants.FRAME_HEIGHT / 3;
		
		final double button_height = Engine.RES.getSprite("button.png").getHeight();
		final double margin = button_height + BUTTON_MARGIN;
		
		createButton("play", x, y, () -> {
			menuState.setCurrentMenu("start");
		});
		
		createButton("options", x, y + margin, () -> {
			menuState.setCurrentMenu("options");
		});
		
		createButton("quit", x, y + margin * 2, () -> {
			log.info("Stopping Game");
			System.exit(0);
		});
	}
}
