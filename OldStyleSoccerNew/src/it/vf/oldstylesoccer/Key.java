package it.vf.oldstylesoccer;

public class Key {
	private int keyCode;
	private boolean keyPressed;

	public Key(int keyCode) {
		this.keyCode = keyCode;
		this.keyPressed = false;
	}

	public boolean equals(Key k2) {
		return this.getKeyCode() == k2.getKeyCode();
	}
	
	public boolean isKeyPressed() {
		return keyPressed;
	}

	public void setKeyPressed(boolean keyPressed) {
		this.keyPressed = keyPressed;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}
}
