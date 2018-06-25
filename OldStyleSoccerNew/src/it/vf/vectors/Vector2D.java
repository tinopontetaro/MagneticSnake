package it.vf.vectors;

public class Vector2D {

	private float x;
	private float y;

	public Vector2D(float x, float y) {
		this.setX(x);
		this.setY(y);
	}

	public Vector2D reverse()
	{
		return new Vector2D(-x, -y);
	}
	
	public Vector2D nextPerpendicular()
	{
		return new Vector2D(-y, x);
	}

	public Vector2D prevPerpendicular()
	{
		return new Vector2D(y, -x);
	}

	public Vector2D sum(Vector2D v2)
	{
		return new Vector2D(x + v2.getX(), y + v2.getY());
	}

	public Vector2D sum(float xcomp, float ycomp)
	{
		return new Vector2D(x + xcomp, y + ycomp);
	}

	public Vector2D multiply(float scalar)
	{
		return new Vector2D(x * scalar, y * scalar);
	}

	public double length()
	{
		return Math.sqrt((x*x)+(y*y));
	}
	
	public double distance(Vector2D v2)
	{
		return this.sum(v2.reverse()).length();
	}
	
	public double angle()
	{
		return Math.atan2(y, x);
	}
	
	public Vector2D projectionOn(Vector2D v2)
	{
//		System.out.println("this.angle(): " + this.angle());
//		System.out.println("v2.angle(): " + v2.angle());
		double angleBetween = this.angle() - v2.angle();
//		System.out.println("angleBetween: " + angleBetween);
		double projectionLength = this.length()*Math.cos(angleBetween);
		return new Vector2D((float)projectionLength*(float)Math.cos(v2.angle()), (float)projectionLength*(float)Math.sin(v2.angle()));
//		return this.length()*Math.cos(angleBetween);
	}

	public Vector2D projectionOnPerpendicular(Vector2D v2)
	{
		double angleBetween = this.angle() - v2.angle();
//		return this.length()*Math.sin(angleBetween);
		double projectionLength = this.length()*Math.sin(angleBetween);
		return new Vector2D(-(float)projectionLength*(float)Math.sin(v2.angle()), (float)projectionLength*(float)Math.cos(v2.angle()));
	}
	
	public void print()
	{
		System.out.println("(" + x + ", " + y + ")");
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}

}
