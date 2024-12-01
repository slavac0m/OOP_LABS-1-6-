package org.example.labWork4.figures.secLayer;

import org.example.MyPoint;
import org.example.labWork4.figures.TFigure;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Quadrangle extends TFigure {
    private MyPoint[] points = new MyPoint[4];

    public Quadrangle(MyPoint[] points, Color color) {
        if (points.length != 4) throw new IllegalArgumentException("Четырехугольник должен иметь 4 вершины.");
        int centerX = 0, centerY = 0;

        for (int i = 0; i < 4; i++) {
            centerX += points[0].getX();
            centerY += points[0].getY();
        }

        centerX /= 4;
        centerY /= 4;

        super(new MyPoint(centerX, centerY), color);

        for (int i = 0; i < 4; i++)
            this.points[i] = new MyPoint(
                    points[i].getX() - centerX,
                    points[i].getY() - centerY
            );

        this.points = orderPoints(this.points);

        System.out.println("[CREATE] " + this);
    }

    private MyPoint[] orderPoints(MyPoint[] points) {
        int centerX = 0, centerY = 0;
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
    public void paint(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(getColor());

        int[] xPoints = new int[4];
        int[] yPoints = new int[4];

        for (int i = 0; i < 4; i++) {
            xPoints[i] = points[i].getX() + getCenter().getX();
            yPoints[i] = points[i].getY() + getCenter().getY();
        }
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 4);
    }

    public void rotate() {
        for (MyPoint point : points) {
            int relativeX = point.getX();
            int relativeY = point.getY();

            point.setX(-relativeY);
            point.setY(relativeX);
        }
        System.out.println("[ROTATE] " + this);
    }

    public MyPoint[] getPoints() {
        return points;
    }

    public void setPoints(MyPoint[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + Arrays.toString(points) +
                ", center=" + getCenter() +
                ", color=" + getColor() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
