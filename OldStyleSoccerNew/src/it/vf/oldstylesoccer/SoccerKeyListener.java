package it.vf.oldstylesoccer;

import it.vf.vectors.Vector2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SoccerKeyListener implements KeyListener
{
	private static double sin45 = Math.sin(Math.PI/4);
//	private Player pl;
	
	private Key keyDown = new Key(40);
	private Key keyLeft = new Key(39);
	private Key keyUp = new Key(38);
	private Key keyRight = new Key(37);
	
	public SoccerKeyListener() {
		super();
//		this.pl = pl;
	}

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
//		System.out.println("KeyListener: Premuto tasto "+e.getKeyChar()+" codice "+keyCode);
		if (keyCode == keyDown.getKeyCode()) keyDown.setKeyPressed(true);
		else if (keyCode == keyLeft.getKeyCode()) keyLeft.setKeyPressed(true);
		else if (keyCode == keyUp.getKeyCode()) keyUp.setKeyPressed(true);
		else if (keyCode == keyRight.getKeyCode()) keyRight.setKeyPressed(true);
	}
	
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
//		System.out.println("KeyListener: Rilasciato tasto "+e.getKeyChar()+" codice "+keyCode);
		if (keyCode == keyDown.getKeyCode()) keyDown.setKeyPressed(false);
		else if (keyCode == keyLeft.getKeyCode()) keyLeft.setKeyPressed(false);
		else if (keyCode == keyUp.getKeyCode()) keyUp.setKeyPressed(false);
		else if (keyCode == keyRight.getKeyCode()) keyRight.setKeyPressed(false);
	}
	
	public void keyTyped(KeyEvent e)
	{
		System.out.println("KeyListener: Stai premendo il tasto "+e.getKeyChar()+" codice "+e.getKeyCode());
	}

//	public Player getPl() {
//		return pl;
//	}
//
//	public void setPl(Player pl) {
//		this.pl = pl;
//	}
	
	public Vector2D getVector(double power)
	{
		if (keyDown.isKeyPressed() && !keyLeft.isKeyPressed() && !keyUp.isKeyPressed() && !keyRight.isKeyPressed()) return new Vector2D(0, (float)power);
		else if (keyLeft.isKeyPressed() && !keyDown.isKeyPressed() && !keyUp.isKeyPressed() && !keyRight.isKeyPressed()) return new Vector2D((float)power, 0);
		else if (keyUp.isKeyPressed() && !keyDown.isKeyPressed() && !keyLeft.isKeyPressed() && !keyRight.isKeyPressed()) return new Vector2D(0, -(float)power);
		else if (keyRight.isKeyPressed() && !keyDown.isKeyPressed() && !keyLeft.isKeyPressed() && !keyUp.isKeyPressed()) return new Vector2D(-(float)power, 0);
		else if (keyDown.isKeyPressed() && keyLeft.isKeyPressed() && !keyUp.isKeyPressed() && !keyRight.isKeyPressed()) return new Vector2D((float)(sin45 * power), (float)(sin45 * power));
		else if (keyLeft.isKeyPressed() && keyUp.isKeyPressed() && !keyDown.isKeyPressed() && !keyRight.isKeyPressed()) return new Vector2D((float)(sin45 * power), -(float)(sin45 * power));
		else if (keyUp.isKeyPressed() && keyRight.isKeyPressed() && !keyLeft.isKeyPressed() && !keyDown.isKeyPressed()) return new Vector2D(-(float)(sin45 * power), -(float)(sin45 * power));
		else if (keyRight.isKeyPressed() && keyDown.isKeyPressed() && !keyLeft.isKeyPressed() && !keyUp.isKeyPressed()) return new Vector2D(-(float)(sin45 * power), (float)(sin45 * power));
		else return new Vector2D(0, 0);
	}
}
