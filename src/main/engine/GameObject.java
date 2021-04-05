package main.engine;

import java.util.ArrayList;
import java.util.logging.Logger;

import bagel.Input;
import main.engine.alarm.Alarm;
import main.engine.res.Sprite;
import main.engine.utils.Point;
import main.engine.utils.Rectangle;
import main.engine.view.Camera;

public abstract class GameObject {
	public static final int ALARM_COUNT = 10;
	public static final ArrayList<GameObject> OBJECTS = new ArrayList<>();
	
	protected static final Logger log = Logger.getLogger(GameObject.class.getName());
	
	protected abstract void step(Input input);
	protected abstract void draw();
	
	protected Alarm alarm[] = new Alarm[ALARM_COUNT];
	protected Sprite activeSprite;
	
	protected Point pos;
	protected Rectangle bounds;
	
	public GameObject(Point pos, Sprite sprite) {
		log.info("Created new Game Object at: (" + pos.getX() + ", " + pos.getY() + ")");
		this.pos = pos;
		this.activeSprite = sprite;
		
		for(int i = 0; i < ALARM_COUNT; i++){
			alarm[i] = new Alarm(null);
		}
		
		bounds = new Rectangle(pos.getX(), pos.getY(), sprite.getWidth(), sprite.getHeight());
	}
	
	public GameObject(Point pos) {
		this(pos, null);
	}
	
	public GameObject(float x, float y, Sprite sprite) {
		this(new Point(x, y), sprite);
	}
	
	public GameObject(float x, float y) {
		this(x, y, null);
	}
	
	/**
	 * Update the object and alarms
	 */
	public void update(Input input) {
		for(int i = 0; i < ALARM_COUNT; i++) {
			alarm[i].update();
		}
		
		// Object specific post update call
		step(input);
	}
	
	public void render() {
		
		// Post render object specific draw event
		draw();
	}
	
	public static void renderAll(Camera camera) {
		for(GameObject object : OBJECTS) {
			if(camera.shouldDoRender(object))
				object.render();
		}
	}
	
	public static void updateAll(Camera camera, Input input) {
		for(GameObject object : OBJECTS) {
			if(camera.shouldDoUpdate(object))
				object.update(input);
		}
	}
	
	public Point getPos() {
		return pos;
	}
	
	public Sprite getCurrentSprite() {
		return activeSprite;
	}
		
	public void setPos(Point p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}
}
