package org.example.labWork4.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork4.figures.secLayer.Quadrangle;

import java.awt.*;
import java.util.Arrays;

public class Rectangle extends Quadrangle {


    public Rectangle(MyPoint topLeft, int width, int height, Color color) {
        super(
                new MyPoint[]{
                        topLeft,
                        new MyPoint(topLeft.getX() + width, topLeft.getY()),
                        new MyPoint(topLeft.getX() + width, topLeft.getY() + height),
                        new MyPoint(topLeft.getX(), topLeft.getY() + height),
                },
                color);
        System.out.println("[CREATE] " + this);
    }
    public int getWidth() {
        MyPoint[] points = getPoints();
        return Math.abs(points[1].getX() - points[0].getX());
    }

    public int getHeight() {
        MyPoint[] points = getPoints();
        return Math.abs(points[2].getY() - points[1].getY());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", center=" + getCenter() +
                ", color=" + getColor() +
                '}';
    }



    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[Delete] " + this);
    }
}
