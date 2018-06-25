/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magneticsnake.physic;

/**
 *
 * @author Tino
 */
public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector reverse() {
        return new Vector(-x, -y);
    }

    public Vector nextPerpendicular() {
        return new Vector(-y, x);
    }

    public Vector prevPerpendicular() {
        return new Vector(y, -x);
    }

    public Vector sum(Vector v2) {
        return new Vector(x + v2.getX(), y + v2.getY());
    }

    public Vector sum(float xcomp, float ycomp) {
        return new Vector(x + xcomp, y + ycomp);
    }

    public Vector multiply(float scalar) {
        return new Vector(x * scalar, y * scalar);
    }

    public double length() {
        return Math.sqrt((x * x) + (y * y));
    }

    public double distance(Vector v2) {
        return this.sum(v2.reverse()).length();
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    public Vector projectionOn(Vector v2) {
//		System.out.println("this.angle(): " + this.angle());
//		System.out.println("v2.angle(): " + v2.angle());
        double angleBetween = this.angle() - v2.angle();
//		System.out.println("angleBetween: " + angleBetween);
        double projectionLength = this.length() * Math.cos(angleBetween);
        return new Vector((float) projectionLength * (float) Math.cos(v2.angle()), (float) projectionLength * (float) Math.sin(v2.angle()));
//		return this.length()*Math.cos(angleBetween);
    }

    public Vector projectionOnPerpendicular(Vector v2) {
        double angleBetween = this.angle() - v2.angle();
//		return this.length()*Math.sin(angleBetween);
        double projectionLength = this.length() * Math.sin(angleBetween);
        return new Vector(-(float) projectionLength * (float) Math.sin(v2.angle()), (float) projectionLength * (float) Math.cos(v2.angle()));
    }

    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

}
