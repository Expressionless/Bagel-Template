package main.engine.utils;

import bagel.util.Vector2;

/**
 * Copied from: https://github.com/eleanor-em/bagel/blob/master/src/main/java/bagel/util/Point.java
 * which was made by Eleanor McMurtry. Made mutable
 * @author bmeachem
 *
 */
public class Point {
	
	private double x;
	private double y;

	/**
	 * Create the point (0, 0).
	 */
	public Point() {
		this(0, 0);
	}
	
	public Point(bagel.util.Point pos) {
		this(pos.x, pos.y);
	}

	/**
	 * Create the point (x, y).
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Converts this point to a {@link Vector2} with the same x and y values.
	 */
	public Vector2 asVector() {
		return new Vector2(this.x, this.y);
	}

	/**
	 * Performs <b>exact</b> equality checking.
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Point) {
			Point rhs = (Point) other;
			return x == rhs.x && y == rhs.y;
		} else {
			return false;
		}
	}

	public double distanceTo(Point b) {
		return asVector().sub(b.asVector()).length();
	}
	
	/**
	 * Integration into bagel library
	 * @return Returns an immutable bagel Point
	 */
	public bagel.util.Point toBagelPos() {
		return new bagel.util.Point(x, y);
	}

	@Override
	public String toString() {
		return String.format("Point: (%.2f, %.2f)", x, y);
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getY() {
		return y;
	}
}
