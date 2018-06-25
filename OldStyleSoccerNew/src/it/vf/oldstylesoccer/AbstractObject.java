package it.vf.oldstylesoccer;

import java.awt.Graphics;

import it.vf.vectors.Vector2D;

public abstract class AbstractObject {
	private int radius;

	private Vector2D position;
	private Vector2D actualSpeed;
	private Vector2D actualPower;
	
	private float weigth;
//	private float height = 0;
//	private float power = 20;
	
	abstract public void exec();

//	public AbstractObject (Vector2D position) {
////		this.position = position;
//		this.setPosition(position);
//		this.setActualSpeed(new Vector2D(0, 0));
//		this.setActualPower(new Vector2D(0, 0));
//	}
	
	public boolean collTest(AbstractObject sobj2)
	{
		int radiusSum = getRadius() + sobj2.getRadius();
		if (getPosition().distance(sobj2.getPosition()) > radiusSum) return false;
		else return true;
	}
	
	public void collReaction(AbstractObject sobj2)
	{
//		System.out.println("Collision!");
		float e = 1;
		double m1 = this.getWeigth();
		double m2 = sobj2.getWeigth();
		Vector2D v1i = this.getActualSpeed();
		Vector2D v2i = sobj2.getActualSpeed();
		Vector2D v12 = v1i.sum(v2i.reverse());
		Vector2D dir = sobj2.getPosition().sum(this.getPosition().reverse());
		double distance = dir.length();
		
		double u1 = 0;
		Vector2D compOnDir1 = new Vector2D(0, 0);
		if (this.getSpeed() != 0)
		{
			compOnDir1 = this.getActualSpeed().projectionOn(dir);
			u1 = compOnDir1.length();
		}
//			compOnDir1.print();
		Vector2D compOnPerpendicular1 = this.getActualSpeed().projectionOnPerpendicular(dir);
//			this.getActualSpeed().print();
		double u2 = 0;
		Vector2D compOnDir2 = new Vector2D(0, 0);
		if (sobj2.getSpeed() != 0)
		{
			compOnDir2 = sobj2.getActualSpeed().projectionOn(dir);
			u2 = compOnDir2.length();
		}
//			compOnDir1.print();
		Vector2D compOnPerpendicular2 = sobj2.getActualSpeed().projectionOnPerpendicular(dir);
//			compOnDir1.sum(compOnPerpendicular1).print();
		double v1 = (u1*(m1-m2)+2*m2*u2)/(m1+m2);
		double v2 = (u2*(m2-m1)+2*m1*u1)/(m1+m2);
		Vector2D newCompOnDir1 = new Vector2D((float)v1*dir.getX()/(float)distance, (float)v1*dir.getY()/(float)distance);
		Vector2D newCompOnDir2 = new Vector2D((float)v2*dir.getX()/(float)distance, (float)v2*dir.getY()/(float)distance);

		this.setActualSpeed(newCompOnDir1.sum(compOnPerpendicular1));
		sobj2.setActualSpeed(newCompOnDir2.sum(compOnPerpendicular2));
		
		
	}

	public void paintObject(Graphics g)
	{
	    g.fillOval((int)getPosition().getX() - getRadius(), (int)getPosition().getY() - getRadius(), getRadius() * 2, getRadius() * 2);
	}
	
	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public double getSpeed() {
		return actualSpeed.length();
	}
	
	public Vector2D getActualSpeed() {
		return actualSpeed;
	}

	public void setActualSpeed(Vector2D actualSpeed) {
		this.actualSpeed = actualSpeed;
	}

	public Vector2D getActualPower() {
		return actualPower;
	}

	public void setActualPower(Vector2D actualPower) {
		this.actualPower = actualPower;
	}
	
	public void setActualPower(float x, float y) {
		this.getActualPower().setX(x);
		this.getActualPower().setY(y);
	}

//	abstract public double getSpeed();
	abstract public AbstractObject clone();
	abstract public float getWeigth();
	abstract public void setWeigth(float weigth);
	abstract public int getRadius();
}
