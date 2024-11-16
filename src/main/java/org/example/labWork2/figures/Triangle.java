package org.example.labWork2.figures;

import org.example.Constants;
import org.example.labWork2.MyPoint;

import java.awt.*;
import java.util.Arrays;

public class Triangle {
    private MyPoint[] points;
    private final Color color;
    private boolean visible = true;

    public Triangle(MyPoint[] points, Color color) {
        this.points = points;
        this.color = color;
        System.out.println("[Create] " + this);
    }

    public Triangle(MyPoint[] points) {
        this.points = points;
        this.color = Constants.colors[0];
        System.out.println("[Create] " + this);
    }

    public void moveTo(int dX, int dY) {
        for (MyPoint p: points) {
            p.setX(p.getX() + dX);
            p.setY(p.getY() + dY);
        }
        System.out.println("[MOVE] " + this);
    }

    public void erase() {
        visible = false;
        System.out.println("[ERASED] " + this);
    }

    public Color getColor() { return color; }
    public boolean isVisible() { return visible; }

    public void show(Graphics graphics) {
        if (!visible) return;
        graphics.setColor(color);
        int []xPoints = new int[3];
        int []yPoints = new int[3];
        for (int i = 0; i < 3; i++) {
            xPoints[i] = points[i].getX();
            yPoints[i] = points[i].getY();
        }
        graphics.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) +
                ", color=" + getColor() +
                ", visible=" + isVisible() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }
}
