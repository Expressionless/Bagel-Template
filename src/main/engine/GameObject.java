package main.engine;

import java.util.ArrayList;

import main.engine.alarm.Alarm;
import main.engine.res.Sprite;
import main.engine.utils.Point;

public abstract class GameObject {
	public static final int ALARM_COUNT = 10;
	public static final ArrayList<GameObject> OBJECTS = new ArrayList<>();
	
	protected abstract void step();
	protected abstract void draw();
	
	protected Alarm alarm[] = new Alarm[ALARM_COUNT];
	protected Sprite activeSprite;
	
	protected Point pos;
	
	public GameObject(Point pos) {
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
	
	public void renderAll() {
		for(GameObject object : OBJECTS) {
			object.render();
		}
	}
	
	public void updateAll() {
		for(GameObject object : OBJECTS) {
			object.update();
		}
	}
	
	public Point getPos() {
		return pos;
	}
	
	/**
	 * Integration into bagel library
	 * @return Returns an immutable bagel Point
	 */
	public bagel.util.Point getImmutablePos() {
		return new bagel.util.Point(pos.getX(), pos.getY());
	}
	
	public void setPos(Point p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}
}
