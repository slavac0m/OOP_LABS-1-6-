package org.example.labWork2.figures;

import org.example.Constants;
import org.example.labWork2.MyPoint;

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


    public Color getColor() { return color; }
    public boolean isVisible() { return visible; }

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
        g.drawLine(start.getX(),start.getY(),end.getX(),end.getY());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }
}

