package main.game.menu;

import java.util.ArrayList;

import main.engine.menu.Menu;
import main.game.menu.button.Button;

public class MainMenu extends Menu {
	
	private ArrayList<Button> buttons;
	
	public MainMenu() {
		super("Main menu");
		buttons = new ArrayList<>();
		
		loadButtons();
	}
	
	public void loadButtons() {
		createButton("play", 0, 200);
		createButton("options", 0, 230);
		createButton("quit", 0, 260);
	}

	public void createButton(String name, double x, double y) {
		Button button = new Button(this, name, x, y);
		buttons.add(button);
		addElement(button);
	}
}
