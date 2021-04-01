package main.game.state;

import java.util.HashMap;

import bagel.Font;
import main.engine.menu.Menu;
import main.engine.state.State;
import main.engine.utils.FontUtils;
import main.game.Constants;
import main.game.Engine;
import main.game.menu.MainMenu;
import main.game.menu.StartMenu;

public class MenuState extends State {
	private final HashMap<String, Menu> menus = new HashMap<>();
	
	Menu currentMenu;
	
	Font menuFont;
	
	public MenuState() {
		super("Menu State");
	}

	@Override
	public void init() {
		if(initialized)
			return;
		initialized = true;
		menuFont = Engine.RES.getFont("Menu Font");
		addMenus();
	}
	
	private void addMenus() {
		// Main
		addMenu("main", new MainMenu(this));
		addMenu("start", new StartMenu(this));
		setCurrentMenu("main");
	}
	

	@Override
	public void update() {
		if(currentMenu != null)
			currentMenu.updateElements();
	}

	@Override
	public void render() {
		if(currentMenu != null)
			currentMenu.renderElements();
		if(menuFont != null)
			FontUtils.drawStringCentered(menuFont, Constants.FRAME_TITLE, Constants.FRAME_WIDTH / 2, 180);
	}
	
	public void setCurrentMenu(String menu) {
		log.fine("Setting current menu to: " + menu);
		Menu newMenu = menus.get(menu);
		if(newMenu == null) {
			log.severe("Attempted to change menu to NULL menu: " + menu);
			return;
		}
		
		this.currentMenu = newMenu;
	}
	
	public Menu getCurrentMenu() {
		return currentMenu;
	}
	
	private void addMenu(String name, Menu m) {
		menus.put(name, m);
	}

}
