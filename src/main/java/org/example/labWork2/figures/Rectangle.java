package org.example.labWork2.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;

public class Rectangle {
    private MyPoint start;

    private int width;
    private int high;

    private Color color;
    private boolean visible = true;

    public Rectangle(int x, int y, int width, int high, Color color) {
        this.start = new MyPoint(x,y);
        this.width = width;
        this.high = high;
        this.color = color;
        System.out.println("[Create] " + this);
    }

    public Rectangle(int x, int y, Color color) {
        this.start = new MyPoint(x,y);
        this.color = color;
        this.width = 10;
        this.high = 20;
        System.out.println("[Create] " + this);
    }

    public void erase(){
        visible = false;
        System.out.println("[ERASED] " + this);
    }

    public void moveTo(int dX, int dY){
        start.setX(start.getX() + dX);
        start.setY(start.getY() + dX);
        System.out.println("[MOVE] " + this);
    }

    public void changeForm(int width, int high){
        this.width = width;
        this.high = high;
        System.out.println("[CHANGED] " + this);
    }

    public void show(Graphics graphics){
        if(!visible) return;
        graphics.setColor(color);
        graphics.drawRect(start.getX(), start.getY(), width, high);
    }

    public int getWidth() { return width; }
    public int getHigh() { return high; }
    public Color getColor() { return color; }
    public boolean isVisible() { return visible; }

    @Override
    public String toString() {
        return "Rectangle{" +
                "start=" + start +
                ", width=" + getWidth() +
                ", high=" + getHigh() +
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
