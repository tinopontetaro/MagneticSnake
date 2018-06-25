package magneticsnake.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import magneticsnake.physic.BaseObject;
import magneticsnake.physic.HorizontalWall;
import magneticsnake.physic.PhysicSystem;
import magneticsnake.physic.Sphere;
import magneticsnake.physic.VerticalWall;
import magneticsnake.physic.Wall;


public class MagneticSnakePanel extends JPanel implements ActionListener {

    Timer t = new Timer(5, this);
    private List<BaseObject> objects = null;
    private PhysicSystem system = null;
    private Sphere s = null;
    private Sphere s2 = null;
    private HorizontalWall hw1 = null;
    private HorizontalWall hw2 = null;
    private VerticalWall vw1 = null;
    private VerticalWall vw2 = null;
    
    public MagneticSnakePanel() {
        system = new PhysicSystem();
//        objects = new ArrayList<BaseObject>();
////        objects.add(new Sphere(20, 20, 20));
//        s = new Sphere(20, 20, 20);
//        s.setSpeed(2, 2);
//        objects.add(s);
//        s2 = new Sphere(100, 120, 20);
//        objects.add(s2);
//        hw1 = new HorizontalWall(0);
//        objects.add(hw1);
//        hw2 = new HorizontalWall(400);
//        objects.add(hw2);
//        vw1 = new VerticalWall(0);
//        objects.add(vw1);
//        vw2 = new VerticalWall(600);
//        objects.add(vw2);
    }

//    @Override
//    public void update(Graphics g) {
//        paint(g);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        g.setColor(Color.red);
//        g.drawRect(x,y,1,1);
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        system.draw(g2);
//        for (BaseObject o : objects) 
//            o.draw(g2);
//        
        system.manageCollisions();
//        if (s.collTest(s2)) 
//            s.collReaction(s2);
//        if (s.collTest(hw1)) 
//            s.collReaction(hw1);
//        if (s.collTest(hw2)) 
//            s.collReaction(hw2);
//        if (s.collTest(vw1)) 
//            s.collReaction(vw1);
//        if (s.collTest(vw2)) 
//            s.collReaction(vw2);
////        if (s2.collTest(w)) 
////            s2.collReaction(w);
//        
        system.move();
//        for (BaseObject o : objects) 
//            o.move();
        
        t.start();
    }
    
    
//    public void keyPressed(KeyEvent e) {
//        int k = e.getKeyCode();
//
//        switch (k) {
//            case KeyEvent.VK_D:
//                x++;
//                break;
//            case KeyEvent.VK_A:
//                x--;
//                break;
//            case KeyEvent.VK_W:
//                y--;
//                break;
//            case KeyEvent.VK_S:
//                y++;
//                break;
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}