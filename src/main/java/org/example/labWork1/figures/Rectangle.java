package org.example.labWork1.figures;

import java.awt.*;

public class Rectangle {
    private int x;
    private int y;

    private int width;
    private int height;

    private Color color;
    private boolean visible = true;

    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        System.out.println("[Create] " + this);
    }

    public Rectangle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = 10;
        this.height = 20;

        System.out.println("[Create] " + this);
    }

    public void erase() {
        visible = false;
        System.out.println("[ERASED] " + this);
    }

    public void moveTo(int dX, int dY) {
        x += dX;
        y += dY;
        System.out.println("[MOVE] " + this);
    }

    public void changeForm(int width, int high) {
        this.width = width;
        this.height = high;
        System.out.println("[CHANGED] " + this);
    }

    public void show(Graphics graphics) {
        if (!visible) return;
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + getX() +
                ", y=" + getY() +
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
