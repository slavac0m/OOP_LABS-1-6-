package org.example.labWork3.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork3.figures.secLayer.Quadrangle;

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
