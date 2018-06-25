package it.vf.oldstylesoccer;

import it.vf.vectors.Vector2D;

public class Ball extends AbstractObject {// implements SoccerObject {// extends AbstractObject {
	private final int radius = 20;

//	private Vector2D position;
//	private Vector2D actualSpeed;
//	private Vector2D actualPower;
	
	private float weigth = 2;
	private float height = 0;
//	private float power = 20;

	public Ball(Vector2D position) {
		this.setPosition(position);
		this.setActualSpeed(new Vector2D(0, 0));
		this.setActualPower(new Vector2D(0, 0));
	}
	
	public void exec() {
		setActualPower(0, 0);
		Vector2D friction = getActualSpeed().reverse().multiply(weigth*(float)getActualSpeed().length() / 10);
		setActualPower(friction.sum(getActualPower()));
		this.setActualSpeed(this.getActualSpeed().sum(this.getActualPower().multiply(1/weigth)));
		this.setPosition(this.getPosition().sum(this.getActualSpeed()));
//		System.out.println("Speed: " + getSpeed());
	}


	public Ball clone() {
		Ball clonedBall = new Ball(getPosition());
		clonedBall.setActualPower(getActualPower());
		clonedBall.setActualSpeed(getActualSpeed());
		clonedBall.setWeigth(getWeigth());
//		clonedBall.setListener(getListener());
		return clonedBall;
	}
	
	public float getWeigth() {
		return weigth;
	}

	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}

	public int getRadius() {
		return radius;
	}

}
