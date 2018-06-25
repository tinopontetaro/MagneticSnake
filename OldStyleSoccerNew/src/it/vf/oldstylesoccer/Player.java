package it.vf.oldstylesoccer;

import it.vf.vectors.Vector2D;

public class Player extends AbstractObject {// implements SoccerObject {
	private final int radius = 30;
	private SoccerKeyListener listener = null;

//	private Vector2D position;
//	private Vector2D actualSpeed;
//	private Vector2D actualPower;
	
//	private float maxSpeed = 5;
	private float weigth = 20;
	private float height = 0;
	private float power = 20;
	
	public Player(Vector2D position) {
//		this.position = position;
		this.setPosition(position);
		this.setActualSpeed(new Vector2D(0, 0));
		this.setActualPower(new Vector2D(0, 0));
	}
	
	public void exec()
	{
		setActualPower(0, 0);
		Vector2D friction = getActualSpeed().reverse().multiply(weigth*(float)getActualSpeed().length() / 10);
//		System.out.println("friction: " + friction.length());
//		System.out.println("actualSpeed: " + actualSpeed.length());
//		Vector2D tmpSpeed = new Vector2D(0, 0);
//		double tmpPower = 0;
//		if (this.getActualSpeed().length() < maxSpeed)
//		{
//			double v2v2 = this.getActualSpeed().length() * this.getActualSpeed().length() / (maxSpeed * maxSpeed);
//			System.out.println("v2v2: " + v2v2);
//			tmpPower = power * Math.sqrt(1 - v2v2);
//		}
//		else tmpPower = power;
//		tmpPower = power - this.getActualSpeed().length() * this.getActualSpeed().length();
//		tmpPower = power;
//		System.out.println("tmpPower: " + tmpPower);

		if (listener != null) setActualPower(listener.getVector(power));
		setActualPower(friction.sum(getActualPower()));
//		System.out.println("Vector: " + listener.getVector(tmpPower).angle());
		
		this.setActualSpeed(this.getActualSpeed().sum(this.getActualPower().multiply(1/weigth)));
		this.setPosition(this.getPosition().sum(this.getActualSpeed()));
	}


	public Player clone() {
		Player clonedPl = new Player(getPosition());
		clonedPl.setActualPower(getActualPower());
		clonedPl.setActualSpeed(getActualSpeed());
		clonedPl.setWeigth(getWeigth());
		clonedPl.setListener(getListener());
		return clonedPl;
	}
	
	
	public SoccerKeyListener getListener() {
		return listener;
	}

	public void setListener(SoccerKeyListener listener) {
		this.listener = listener;
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
