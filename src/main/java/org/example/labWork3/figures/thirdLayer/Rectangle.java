package org.example.labWork3.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork3.figures.secLayer.Quadrangle;

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
