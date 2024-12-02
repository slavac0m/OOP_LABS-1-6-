package org.example.labWork5.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork5.figures.secLayer.Quadrangle;

import java.awt.*;

public class Rectangle extends Quadrangle {
    private int width, height;

    public Rectangle(MyPoint topLeft, int width, int height, Color color) {
        super(
                new MyPoint[]{
                        topLeft,
                        new MyPoint(topLeft.getX() + width, topLeft.getY()),
                        new MyPoint(topLeft.getX() + width, topLeft.getY() + height),
                        new MyPoint(topLeft.getX(), topLeft.getY() + height),
                },
                color);
        this.width = width;
        this.height = height;
        System.out.println("[CREATE] " + this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
        MyPoint[] points = getPoints();
        setPoints(new MyPoint[]{
                points[0],
                new MyPoint(points[0].getX() + width, points[0].getY()),
                new MyPoint(points[0].getX() + width, points[2].getY()),
                new MyPoint(points[0].getX(), points[2].getY())
        });
    }


    public void setHeight(int height) {
        this.height = height;
        MyPoint[] points = getPoints();
        setPoints(new MyPoint[]{
                points[0],
                new MyPoint(points[0].getX() + width, points[0].getY()),
                new MyPoint(points[0].getX() + width, points[0].getY() + height),
                new MyPoint(points[0].getX(), points[0].getY() + height)
        });
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
