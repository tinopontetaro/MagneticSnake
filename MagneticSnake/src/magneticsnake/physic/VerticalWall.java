/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magneticsnake.physic;

import java.awt.Graphics2D;

/**
 *
 * @author Tino
 */
public class VerticalWall extends BaseObject {
    
//    private Ellipse2D circle = null;
    
    public VerticalWall(double x) {
//        this.circle = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);
        this.setPos(new Vector(x, 0));
        this.setSpeed(0, 0);
        this.setRadius(0);
        this.setMass(Double.MAX_VALUE);
    }
    
    public void move(double speedX, double speedY) {
//        this.getPos().setX(this.getPos().getX() + speedX);
//        this.getPos().setY(this.getPos().getY() + speedY);
//        this.circle = new Ellipse2D.Double(this.getPos().getX() - getRadius(), this.getPos().getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
    }
    
    public void move() {
//        this.getPos().setX(this.getPos().getX() + this.getSpeed().getX());
//        this.getPos().setY(this.getPos().getY() + this.getSpeed().getY());
//        this.circle = new Ellipse2D.Double(this.getPos().getX() - getRadius(), this.getPos().getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
    }
    
    public void draw(Graphics2D g2d) {
//        g2d.fill(circle);
    }
    
    
}
