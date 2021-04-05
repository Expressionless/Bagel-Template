package main.engine.utils;

public class Rectangle extends bagel.util.Rectangle {

	public Rectangle(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	public Rectangle(Point pos, double width, double height) {
		super(pos.getX(), pos.getY(), width, height);
	}
	
	public boolean intersects(Point point) {
		return point.getX() >= left() && point.getX() <= right()
	            && point.getY() >= top() && point.getY() <= bottom();
	}

}
