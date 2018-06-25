package it.vf.oldstylesoccer;

//public class Viewer {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

import it.vf.vectors.Vector2D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class Viewer extends JPanel
{
	private ArrayList<AbstractObject> objectsOnField = new ArrayList<AbstractObject> ();
	private Player pl1 = new Player(new Vector2D(100, 100));
	private SoccerKeyListener listener = new SoccerKeyListener();
	private int counter = 0;
	
	public Viewer()
	{
		
	}
  
	public static void main(String[] arg)
	{
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	JFrame window = new JFrame();
                final Viewer splash = new Viewer();
                window.add(splash);
                window.setSize(600, 400);
                window.addKeyListener(splash.listener);
                window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                window.setVisible(true);

//                new Thread() {
//
//                    @Override
//                    public void run() {
                        splash.startt();
//                    }
//                }.start();
            }
        });
	}
	
	public void startt() {
		objectsOnField.add(new Player(new Vector2D(0, 0)));
		objectsOnField.add(new Ball(new Vector2D(200, 200)));

		((Player) objectsOnField.get(0)).setListener(listener);
	    
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
			@Override
			public void run() {
			    repaint();
			}
		}, 25, 25);
	}

	@Override
	public void paintComponent(Graphics g)
	{
        super.paintComponent(g);
//        Vector2D prova = new Vector2D(1, 1);
//        System.out.println("prova: " + prova.length());
//        System.out.println("Projection: " + prova.projectionOn(prova));
        AbstractObject obj1 = objectsOnField.get(0).clone();
        AbstractObject obj2 = objectsOnField.get(1).clone();
        objectsOnField.get(0).exec();
        objectsOnField.get(1).exec();
//		System.out.println("collTest: " + objectsOnField.get(0).collTest(objectsOnField.get(1)));

		if (/*counter == 0 && */objectsOnField.get(0).collTest(objectsOnField.get(1)))
		{
			obj1.collReaction(obj2);
	        objectsOnField.set(0, obj1);
	        objectsOnField.set(1, obj2);
			counter = 5;
		}
		//if (counter > 0) counter--;
		
		objectsOnField.get(0).paintObject(g);
		objectsOnField.get(1).paintObject(g);
	}
	
}