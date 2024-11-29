package org.example.labWork5.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork5.figures.secLayer.Quadrangle;

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

    public void rotate(){
        MyPoint topLeft = getPoints()[0];
        for (int i = 1; i < getPoints().length; i++) {
            MyPoint point = getPoints()[i];
            int newX = topLeft.getX() + (point.getY() - topLeft.getY());
            int newY = topLeft.getY() - (point.getX() - topLeft.getX());
            point.setX(newX);
            point.setY(newY);
        }
        System.out.println("[ROTATE] " + this);
    }

    @Override
    public String toString() {
        return "Rectangle={" +
                "points=" + Arrays.toString(getPoints()) +
                "}";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[Delete] " + this);
    }
}
