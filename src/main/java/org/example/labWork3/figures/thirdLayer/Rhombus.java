package org.example.labWork3.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork3.figures.secLayer.Quadrangle;

import java.awt.*;
import java.util.Arrays;

public class Rhombus extends Quadrangle {

    public Rhombus(MyPoint center, int diagonal1, int diagonal2, Color color) {
        super(new MyPoint[]{
                new MyPoint(center.getX(), center.getY() - diagonal1/2),
                new MyPoint(center.getX() + diagonal2 /2, center.getY()),
                new MyPoint(center.getX(), center.getY()+diagonal2/2),
                new MyPoint(center.getX() - diagonal2 / 2, center.getY())
        }, color);
        System.out.println("[CREATE] " + this);
    }

    @Override
    public String toString() {
        return ("Rhombus={" +
                "points=" + Arrays.toString(getPoints())+
                "}"
        );
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
