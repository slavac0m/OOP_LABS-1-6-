package org.example.labWork6_array.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork6_array.figures.secLayer.Quadrangle;

import java.awt.*;
import java.util.Arrays;

public class Trapezoid extends Quadrangle {

    public Trapezoid(MyPoint topLeft, int topWidth, int bottomWidth, int height, Color color) {
        super(new MyPoint[]{
                topLeft,
                new MyPoint(topLeft.getX() + topWidth, topLeft.getY()),
                new MyPoint(topLeft.getX() + (bottomWidth - topWidth) / 2, topLeft.getY() + height),
                new MyPoint(topLeft.getX() - (bottomWidth - topWidth), topLeft.getY() + height),
        }, color);
        System.out.println("[CREATE] " + this);
    }

    public void rotate() {
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
        return "Trapezoid={" +
                "points=" + Arrays.toString(getPoints()) +
                "}";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
