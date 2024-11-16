package org.example.labWork3.figures.secLayer;

import org.example.MyPoint;
import org.example.labWork3.figures.TFigure;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Quadrangle extends TFigure {

    private MyPoint[] points;

    public Quadrangle(MyPoint[] points, Color color) {
        super(points[0], color);
        if (points.length != 4) throw new IllegalArgumentException("Четырехугольник должен иметь 4 вершины.");
        this.points = orderPoints(points);
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
            xPoints[i] = points[i].getX();
            yPoints[i] = points[i].getY();
        }
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 4);
    }

    public MyPoint[] getPoints() {
        return points;
    }

    public void setPoints(MyPoint[] points) {
        if (points.length != 4) throw new IllegalArgumentException("Четырехугольник должен иметь 4 вершины.");
        this.points = orderPoints(points);
    }

    private MyPoint[] orderPoints(MyPoint[] points) {
        int centerX = 0;
        int centerY = 0;
        for (MyPoint point : points) {
            centerX += point.getX();
            centerY += point.getY();
        }
        centerX /= 4;
        centerY /= 4;

        final int finalCenterX = centerX;
        final int finalCenterY = centerY;
        Arrays.sort(points, Comparator.comparingDouble(point -> Math.atan2(point.getY() - finalCenterY, point.getX() - finalCenterX)));
        return points;
    }

    @Override
    public void moveTo(int dX, int dY) {
        super.moveTo(dX, dY);
        for (int i =0; i < 4; i++)points[i].moveTo(dX, dY);
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
