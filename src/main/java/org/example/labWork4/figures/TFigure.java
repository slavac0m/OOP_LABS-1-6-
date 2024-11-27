package org.example.labWork4.figures;


import org.example.MyPoint;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public abstract class TFigure {
    private MyPoint[] points;
    private Color color;
    private boolean visible = true;
    private Graphics graphics;

    public TFigure(MyPoint[] points, Color color) {
        this.points = orderPoints(points);
        this.color = color;
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


    public abstract void paint(Graphics g);

    public void erase() {
        setVisible(false);
    }

    public final void moveTo(int dX, int dY) {
        for (MyPoint point : points) point.moveTo(dX, dY);
        paint(graphics);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyPoint[] getPoints() {
        return points;
    }

    public void setPoints(MyPoint[] points) {
        this.points = points;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }


    @Override
    protected void finalize() throws Throwable {
        Arrays.fill(points, null);
        points = null;
        System.gc();
    }
}
