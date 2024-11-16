package org.example.labWork1.figures;

import org.example.Constants;

import java.awt.*;
import java.util.Arrays;

public class Triangle {
    private int[] xPoints;
    private int[] yPoints;
    private Color color;
    private boolean visible = true;

    public Triangle(int[] xPoints, int[] yPoints, Color color) {
        this.xPoints=xPoints;
        this.yPoints = yPoints;
        this.color = color;
        System.out.println("[Create] " + this);
    }

    public Triangle(int[] xPoints, int[] yPoints) {
        this.xPoints=xPoints;
        this.yPoints = yPoints;
        this.color = Constants.colors[0];
        System.out.println("[Create] " + this);
    }

    public void moveTo(int dX, int dY) {
        for (int i = 0; i < 3; i++) {
            xPoints[i] += dX;
            yPoints[i] += dY;
        }
        System.out.println("[MOVE] " + this);
    }

    public void erase() {
        visible = false;
        System.out.println("[ERASED] " + this);
    }

    public int[] getXPoints() { return xPoints; }
    public int[] getYPoints() { return yPoints; }
    public Color getColor() { return color; }
    public boolean isVisible() { return visible; }

    public void show(Graphics graphics) {
        if (!visible) return;
        graphics.setColor(color);
        graphics.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "xPoints=" + Arrays.toString(getXPoints()) +
                ", yPoints=" + Arrays.toString(getYPoints()) +
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
