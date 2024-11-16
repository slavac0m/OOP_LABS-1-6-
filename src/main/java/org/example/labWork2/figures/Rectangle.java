package org.example.labWork2.figures;

import org.example.MyPoint;

import java.awt.*;

public class Rectangle {
    private final MyPoint start;

    private int width;
    private int height;

    private Color color;
    private boolean visible = true;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.start = new MyPoint(x,y);
        this.width = width;
        this.height = height;
        this.color = color;
        System.out.println("[Create] " + this);
    }

    public Rectangle(int x, int y, Color color) {
        this.start = new MyPoint(x,y);
        this.color = color;
        this.width = 10;
        this.height = 20;
        System.out.println("[Create] " + this);
    }

    public void erase(){
        visible = false;
        System.out.println("[ERASED] " + this);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void moveTo(int dX, int dY){
        start.setX(start.getX() + dX);
        start.setY(start.getY() + dY);
        System.out.println("[MOVE] " + this);
    }

    public void changeForm(int width, int high){
        this.width = width;
        this.height = high;
        System.out.println("[CHANGED] " + this);
    }

    public MyPoint getStart() {
        return start;
    }

    public void show(Graphics graphics){
        if(!visible) return;
        graphics.setColor(color);
        graphics.fillRect(start.getX(), start.getY(), width, height);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(start.getX(), start.getY(), width, height);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Color getColor() { return color; }
    public boolean isVisible() { return visible; }

    @Override
    public String toString() {
        return "Rectangle{" +
                "start=" + start +
                ", width=" + getWidth() +
                ", high=" + getHeight() +
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
