package org.example.labWork4.figures.secLayer;

import org.example.MyPoint;
import org.example.labWork4.figures.TFigure;

import java.awt.*;
import java.util.Arrays;

public class Quadrangle extends TFigure {

    public Quadrangle(MyPoint[] points, Color color) {
        super(points, color);
        if (points.length != 4) throw new IllegalArgumentException("Четырехугольник должен иметь 4 вершины.");
        System.out.println("[CREATE] " + this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(getColor());

        int[] xPoints = new int[4];
        int[] yPoints = new int[4];

        for (int i = 0; i < 4; i++) {
            xPoints[i] = getPoints()[i].getX();
            yPoints[i] = getPoints()[i].getY();
        }
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 4);
    }

    public void rotate() {
        MyPoint[] points = getPoints();
        MyPoint center = getCenter();

        for (MyPoint point : points) {
            int newX = center.getX() + (point.getY() - center.getY());
            int newY = center.getY() - (point.getX() - center.getX());
            point.setX(newX);
            point.setY(newY);
        }
        System.out.println("[ROTATE] " + this);
    }
    private MyPoint getCenter() {
        int sumX = 0, sumY = 0;
        for (MyPoint point : getPoints()) {
            sumX += point.getX();
            sumY += point.getY();
        }
        return new MyPoint(sumX / 4, sumY / 4);
    }


    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + Arrays.toString(getPoints()) +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
