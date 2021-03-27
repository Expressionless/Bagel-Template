package main.game.state;

import java.io.File;

import main.engine.res.Sprite;
import main.engine.state.State;

public class MenuState extends State {

	private Sprite sprite;
	public MenuState() {
		super("Menu State");
	}

	@Override
	public void init() {
		if(initialized)
			return;
		initialized = true;
		sprite = Sprite.createSprite(new File("").getAbsolutePath() + "\\res\\tiles\\grass.png");
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		sprite.draw(300, 300);
	}

}
