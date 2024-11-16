package org.example.labWork2.figures;

import org.example.Constants;
import org.example.MyPoint;

import java.awt.*;

public class Line {
    private MyPoint start, end;
    private final Color color;
    private boolean visible = true;

    public Line(int startX, int startY, int endX, int endY, Color color) {
        this.start = new MyPoint(startX, startY);
        this.end = new MyPoint(endX, endY);
        this.color = color;
        System.out.println("[CREATE] " + this);
    }

    public Line(int startX, int startY, int endX, int endY) {
        this.start = new MyPoint(startX, startY);
        this.end = new MyPoint(endX, endY);
        this.color = Constants.colors[0];
        System.out.println("[CREATE] " + this);
    }

    public void moveTo(int dX, int dY) {
        start.setX(start.getX() + dX);
        end.setX(end.getX() + dX);

        start.setY(start.getY() + dY);
        end.setY(end.getY() + dY);
        System.out.println("[MOVE] " + this);
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
                " start=" + start +
                ", end=" + end +
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
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    public void rotate(int angle) {
        int centerX = (start.getX() + end.getX()) / 2;
        int centerY = (start.getY() + end.getY()) / 2;

        double angleRadians = Math.toRadians(angle);
        int newStartX = (int) (centerX + (start.getX() - centerX) * Math.cos(angleRadians) - (start.getY() - centerY) * Math.sin(angleRadians));
        int newStartY = (int) (centerY + (start.getX() - centerX) * Math.sin(angleRadians) + (start.getY() - centerY) * Math.cos(angleRadians));
        int newEndX = (int) (centerX + (end.getX() - centerX) * Math.cos(angleRadians) - (end.getY() - centerY) * Math.sin(angleRadians));
        int newEndY = (int) (centerY + (end.getX() - centerX) * Math.sin(angleRadians) + (end.getY() - centerY) * Math.cos(angleRadians));


        start.setX(newStartX);
        start.setY(newStartY);
        end.setX(newEndX);
        end.setY(newEndY);
        System.out.println("[ROTATE] angle=" + angle + "\t" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }
}

