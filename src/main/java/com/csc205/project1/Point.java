package com.csc205.project1;

import org.junit.jupiter.api.Assertions;

public class Point
{
    double x = 0.0;
    double y = 0.0;

    public Point() { x = 0.0;  y = 0.0; }
    public Point(double pointX, double pointY) { x = pointX; y = pointY; }

    //Uses pythagorean theorem to retrieve the distance between two points
    double distance(Point p2)
    {
        Assertions.assertNotNull(p2,"Point p2 does not exist.");
        return Math.sqrt(Math.pow(x-p2.getX(),2) + Math.pow(y-p2.getY(),2));
    }

    //Getter functions
    double getX() { return x; }
    void setX(double pointX) { x = pointX; }

    double getY() { return y; }
    void setY(double pointY) { y = pointY; }

    //These are basic coordinate manipulation methods
    void setPoint(double pointX, double pointY) { x = pointX; y = pointY; }
    void shiftX(double shiftX)
    {
        Assertions.assertNotEquals(0.0,shiftX,"There is no distance to shift X.");
        x += shiftX;
    }
    void shiftY(double shiftY)
    {
        Assertions.assertNotEquals(0.0,shiftY,"There is no distance to shift Y.");
        y += shiftY;
    }

    //Uses rotational matrix to determine the correct location after rotating the point along a unit circle
    void rotate(double angle)
    {
        Assertions.assertNotEquals(0.0,angle,"Attempted to rotate 0 degrees; this does nothing.");
        x = (x * Math.cos(angle)) - (y * Math.sin(angle));
        y = (x * Math.sin(angle)) + (y * Math.cos(angle));
    }

    //Bonus function! Angle between two points!
    double pointAngle(Point p2)
    {
        Assertions.assertNotNull(p2,"Point p2 does not exist.");
        return (Math.atan2(p2.getY()-y,p2.getX()-x)*180)/Math.PI;
    }

    public String toString()
    {
        return "Point{x = " + x + ", y = " + y + "}";
    }
}
