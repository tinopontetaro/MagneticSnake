/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magneticsnake.physic;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tino
 */
public class PhysicSystem {
    
    private LinkedList<BaseObject> objects = null;
    
    public PhysicSystem () {
        objects = new LinkedList<BaseObject>();
        Sphere s = new Sphere(20, 20, 20);
        s.setSpeed(2, 2);
        objects.add(s);
//        s2 = new Sphere(100, 120, 20);
        objects.add(new Sphere(100, 120, 20));
//        hw1 = new HorizontalWall(0);
        objects.add(new HorizontalWall(0));
//        hw2 = new HorizontalWall(400);
        objects.add(new HorizontalWall(400));
//        vw1 = new VerticalWall(0);
        objects.add(new VerticalWall(0));
//        vw2 = new VerticalWall(600);
        objects.add(new VerticalWall(600));
    }
    
    public void draw (Graphics2D g2) {
        for (BaseObject o : objects) 
            o.draw(g2);
    }
    
    public void move () {
        for (BaseObject o : objects) 
            o.move();
    }
    
    public void manageCollisions () {
        for (int i = 0; i < objects.size(); i++) {
            BaseObject o1 = objects.get(i);
            for (int j = i+1; j <objects.size(); j++) {
                BaseObject o2 = objects.get(j);
                if (o1.collTest(o2)) o1.collReaction(o2);
            }
        }
    }
}
