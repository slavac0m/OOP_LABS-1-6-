package org.example.labWork2.figures;

import org.example.Constants;
import org.example.MyPoint;

import java.awt.*;
import java.util.Arrays;

public class Triangle {
    private final MyPoint[] points;
    private Color color;
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

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() { return color; }
    public boolean isVisible() { return visible; }
    public MyPoint[] getPoints() { return points;}

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
        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(xPoints,yPoints,xPoints.length);
    }

    public void rotate(int angle) {
        int centerX = 0, centerY = 0;

        for (MyPoint point : points){
            centerX += point.getX();
            centerY += point.getY();
        }
        centerY /= 3;
        centerX /= 3;

        double angleRadians = Math.toRadians(angle);
        int [] newXPoints = new int[3];
        int [] newYPoints = new int[3];

        for (int i = 0; i < 3; i++){
            newXPoints[i] = (int) (centerX + (points[i].getX() - centerX) * Math.cos(angleRadians) - (points[i].getY() - centerY) * Math.sin(angleRadians));
            newYPoints[i] = (int) (centerY + (points[i].getX() - centerX) * Math.sin(angleRadians) + (points[i].getY() - centerY) * Math.cos(angleRadians));
        }

        for (int i = 0; i < 3; i++) {
            points[i].setX(newXPoints[i]);
            points[i].setY(newYPoints[i]);
        }
        System.out.println("[ROTATE] angle=" + angle + "\t" + this);
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
