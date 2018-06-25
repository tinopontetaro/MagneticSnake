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
public abstract class BaseObject {
    private Vector pos = null;
    private Vector speed = null;
    private double radius;
    private double mass;

    public boolean collTest(BaseObject o)
    {
//        if (this instanceof Sphere) {
//            if (sobj2 instanceof Sphere) {
                double radiusSum = getRadius() + o.getRadius();
                if (getCenterDistance(o) >= radiusSum) return false;
//                if (getPos().distance(sobj2.getPos()) > radiusSum) return false;
                else return true;
//            }
//            else if (sobj2 instanceof Wall) {
//                double radiusSum = getRadius() + sobj2.getRadius();
//                if (getCenterDistance(sobj2)  > radiusSum) return false;
////                if (Math.abs(getPos().getX() - sobj2.getPos().getX())  > radiusSum) return false;
//                else return true;
//            }
//        }
//        return false;
    }

    public void collReaction(BaseObject o)
    {
        if (this instanceof Sphere) {
            if (o instanceof Sphere) {
                sSCollReaction(this, o);
            }
            else if (o instanceof HorizontalWall) {
                this.getSpeed().setY( - this.getSpeed().getY());
            }
            else if (o instanceof VerticalWall) {
                this.getSpeed().setX( - this.getSpeed().getX());
            }
        }
        else if (this instanceof HorizontalWall) {
            if (o instanceof Sphere) {
                o.getSpeed().setY( - o.getSpeed().getY());
            }
        }
        else if (this instanceof VerticalWall) {
            if (o instanceof Sphere) {
                o.getSpeed().setX( - o.getSpeed().getX());
            }
        }
    }

    private void sSCollReaction(BaseObject o1, BaseObject o2) {
        double m1 = o1.getMass();
        double m2 = o2.getMass();
        
        Vector dir = null;
        //        if (o1 instanceof Sphere) {
        //            if (sobj2 instanceof Sphere) {
        dir = o2.getPos().sum(o1.getPos().reverse());
        //            }
        //            else if (sobj2 instanceof HorizontalWall) {
        //                dir = sobj2.getPos().sum(o1.getPos().reverse());
        //            }
        //        }
        double distance = getCenterDistance(o2);
        
        double u1 = 0;
        Vector compOnDir1 = new Vector(0, 0);
        if (o1.getSpeed().length() != 0)
        {
            compOnDir1 = o1.getSpeed().projectionOn(dir);
            u1 = compOnDir1.length();
        }
        
        Vector compOnPerpendicular1 = o1.getSpeed().projectionOnPerpendicular(dir);
        
        double u2 = 0;
        Vector compOnDir2 = new Vector(0, 0);
        if (o2.getSpeed().length() != 0)
        {
            compOnDir2 = o2.getSpeed().projectionOn(dir);
            u2 = compOnDir2.length();
        }
        
        Vector compOnPerpendicular2 = o2.getSpeed().projectionOnPerpendicular(dir);
        
        double v1 = 0; //(u1*(m1-m2)+2*m2*u2)/(m1+m2);
        double v2 = 0; //(u2*(m2-m1)+2*m1*u1)/(m1+m2);

        //        if (o1 instanceof Sphere) {
        //            if (sobj2 instanceof Sphere) {
        v1 = (u1*(m1-m2)+2*m2*u2)/(m1+m2);
        v2 = (u2*(m2-m1)+2*m1*u1)/(m1+m2);
        //            }
        //            else if (sobj2 instanceof Wall) {
        //                v1 = 2*u2 - u1;
        //                v2 = u2 + 2*u1;
        //            }
        //        }
        
        Vector newCompOnDir1 = new Vector((float)v1*dir.getX()/(float)distance, (float)v1*dir.getY()/(float)distance);
        Vector newCompOnDir2 = new Vector((float)v2*dir.getX()/(float)distance, (float)v2*dir.getY()/(float)distance);
        
        o1.setSpeed(newCompOnDir1.sum(compOnPerpendicular1));
        o2.setSpeed(newCompOnDir2.sum(compOnPerpendicular2));
    }

    public double getCenterDistance(BaseObject o) {
        double distance = 0;
        if (this instanceof Sphere) {
            if (o instanceof Sphere) {
                Vector dir = o.getPos().sum(this.getPos().reverse());
                distance = dir.length();
            }
//            else if (o instanceof Wall) {
//                Wall w = (Wall) o;
//                double num = Math.abs(this.getPos().getY() - w.getPos().getX() * this.getPos().getX() - w.getPos().getY());
//                double den = Math.sqrt(1 + w.getPos().getX() * w.getPos().getX());
//                distance = num / den;
//            }
            else if (o instanceof HorizontalWall) {
                HorizontalWall w = (HorizontalWall) o;
                distance = Math.abs(this.getPos().getY() - w.getPos().getY());
//                double den = Math.sqrt(1 + w.getPos().getX() * w.getPos().getX());
//                distance = num / den;
            }
            else if (o instanceof VerticalWall) {
                VerticalWall w = (VerticalWall) o;
                distance = Math.abs(this.getPos().getX() - w.getPos().getX());
            }
        }
        else if (this instanceof HorizontalWall) {
            if (o instanceof Sphere) {
//                HorizontalWall w = (HorizontalWall) o;
                distance = Math.abs(o.getPos().getY() - this.getPos().getY());
            }
        }
        else if (this instanceof VerticalWall) {
            if (o instanceof Sphere) {
                distance = Math.abs(o.getPos().getX() - this.getPos().getX());
            }
        }
        
        return distance;
    }
    
    public abstract void draw(Graphics2D g2d);
    
    public abstract void move();
    
    /**
     * @return the pos
     */
    public Vector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(Vector pos) {
        this.pos = pos;
    }

    /**
     * @return the speed
     */
    public Vector getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double x, double y) {
        if (speed == null) speed = new Vector(x, y);
        else {
            this.speed.setX(x);
            this.speed.setY(y);
        }
    }
    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    
}
