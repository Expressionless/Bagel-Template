package main.engine;

import java.util.ArrayList;
import java.util.logging.Logger;

import main.engine.alarm.Alarm;
import main.engine.res.Sprite;
import main.engine.utils.Point;
import main.engine.view.Camera;

public abstract class GameObject {
	public static final int ALARM_COUNT = 10;
	public static final ArrayList<GameObject> OBJECTS = new ArrayList<>();
	
	protected static final Logger log = Logger.getLogger(GameObject.class.getName());
	
	protected abstract void step();
	protected abstract void draw();
	
	protected Alarm alarm[] = new Alarm[ALARM_COUNT];
	protected Sprite activeSprite;
	
	protected Point pos;
	
	public GameObject(Point pos) {
		log.info("Created new Game Object at: (" + pos.getX() + ", " + pos.getY() + ")");
		this.pos = pos;
		for(int i = 0; i < ALARM_COUNT - 1; i++){
			alarm[i] = new Alarm(null);
		}
	}
	
	/**
	 * Update the object and alarms
	 */
	private void update() {
		
		// Object specific post update call
		step();
	}
	
	private void render() {
		
		// Post render object specific draw event
		draw();
	}
	
	public static void renderAll(Camera camera) {
		for(GameObject object : OBJECTS) {
			if(camera.shouldDoRender(object))
				object.render();
		}
	}
	
	public static void updateAll(Camera camera) {
		for(GameObject object : OBJECTS) {
			if(camera.shouldDoUpdate(object))
				object.update();
		}
	}
	
	public Point getPos() {
		return pos;
	}
		
	public void setPos(Point p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}
}
