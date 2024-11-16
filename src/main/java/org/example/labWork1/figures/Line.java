package org.example.labWork1.figures;

import org.example.Constants;

import java.awt.*;

public class Line {
    private int startX, startY, endX, endY;
    private final Color color;
    private boolean visible = true;

    public Line(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        System.out.println("[CREATE] " + this);
    }

    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = Constants.colors[0];
        System.out.println("[CREATE] " + this);
    }

    public void moveTo(int dX, int dY) {
        startX += dX;
        startY += dY;
        endY += dY;
        endX += dX;
        System.out.println("[MOVE] dX= " + dX + ", dY= " + dY + " " + this);
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Color getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startX=" + getStartX() +
                ", startY=" + getStartY() +
                ", endX=" + getEndX() +
                ", endY=" + getEndY() +
                ", color=" + getColor() +
                ", visible=" + isVisible() +
                '}';
    }


    public void erase() {
        visible = false;
        System.out.println("[ERASE] " + this);
    }

    public void show(Graphics g) {
        if (!visible) return;
        g.setColor(color);
        g.drawLine(startX, startY, endX, endY);
    }

    public void rotate(int angle) {
        int centerX = (startX + endX) / 2;
        int centerY = (startY + endY) / 2;

        double angleRadians = Math.toRadians(angle);
        int newStartX = (int) (centerX + (startX - centerX) * Math.cos(angleRadians) - (startY - centerY) * Math.sin(angleRadians));
        int newStartY = (int) (centerY + (startX - centerX) * Math.sin(angleRadians) + (startY - centerY) * Math.cos(angleRadians));
        int newEndX = (int) (centerX + (endX - centerX) * Math.cos(angleRadians) - (endY - centerY) * Math.sin(angleRadians));
        int newEndY = (int) (centerY + (endX - centerX) * Math.sin(angleRadians) + (endY - centerY) * Math.cos(angleRadians));


        startX = newStartX;
        startY = newStartY;
        endX = newEndX;
        endY = newEndY;
        System.out.println("[ROTATE] angle=" + angle + "\t" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }
}

