package org.example.labWork1.figures;

import org.example.Constants;

import java.awt.*;
import java.util.Arrays;

public class Triangle {
    private int[] xPoints;
    private int[] yPoints;
    private final Color color;
    private boolean visible = true;

    public Triangle(int[] xPoints, int[] yPoints, Color color) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.color = color;
        System.out.println("[Create] " + this);
    }

    public Triangle(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
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

    public int[] getXPoints() {
        return xPoints;
    }

    public int[] getYPoints() {
        return yPoints;
    }

    public Color getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void show(Graphics graphics) {
        if (!visible) return;
        graphics.setColor(color);
        graphics.fillPolygon(xPoints, yPoints, xPoints.length);
        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(xPoints,yPoints,xPoints.length);
    }

    public void rotate(int angle) {
        int centerX = 0, centerY = 0;

        for (int x : xPoints) centerX += x;
        for (int y : yPoints) centerY += y;
        centerY /= 3;
        centerX /= 3;

        double angleRadians = Math.toRadians(angle);
        int [] newXPoints = new int[3];
        int [] newYPoints = new int[3];

        for (int i = 0; i < 3; i++){
            newXPoints[i] = (int) (centerX + (xPoints[i] - centerX) * Math.cos(angleRadians) - (yPoints[i] - centerY) * Math.sin(angleRadians));
            newYPoints[i] = (int) (centerY + (xPoints[i] - centerX) * Math.sin(angleRadians) + (yPoints[i] - centerY) * Math.cos(angleRadians));

        }
        xPoints = newXPoints;
        yPoints = newYPoints;
        System.out.println("[ROTATE] angle=" + angle + "\t" + this);
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
