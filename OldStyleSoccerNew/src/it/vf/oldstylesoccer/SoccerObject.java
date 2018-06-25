package it.vf.oldstylesoccer;

import it.vf.vectors.Vector2D;

public interface SoccerObject {
	
	public void exec();

	public double getSpeed();
	public Vector2D getPosition();
	public void setPosition(Vector2D position);
	public Vector2D getActualSpeed();
	public void setActualSpeed(Vector2D actualSpeed);
	public Vector2D getActualPower();
	public void setActualPower(Vector2D actualPower);
	public float getWeigth();
	public void setWeigth(float weigth);
	public int getRadius();
}
