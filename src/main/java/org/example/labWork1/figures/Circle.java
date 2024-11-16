package org.example.labWork1.figures;

import java.awt.*;

public class Circle {
    private int x;
    private int y;

    private int r;

    private final Color color;
    private boolean visible = true;

    public Circle(int x, int y, int r, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
        System.out.println("[CREATE] " + this);
    }


    public Circle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.r = 20;
        this.color = color;
        System.out.println("[CREATE] " + this);
    }

    public void moveTo(int dX, int dY) {
        x += dX;
        y += dY;
        System.out.println("[MOVE] dX=" + dX + ", dY=" + "\t" + this);
    }

    public void setRadius(int newR) {
        r = newR;
        System.out.println("[EDIT RADIUS] newR=" + r + "\t" + this);
    }

    public void show(Graphics graphics) {
        if (!visible) return;
        Color lineColor = Color.BLACK;
        graphics.setColor(color);
        graphics.fillOval(x - r, y - r, r * 2, r * 2);
        graphics.setColor(lineColor);
        graphics.drawOval(x - r, y - r, r * 2, r * 2);
        System.out.println("[SHOW] " + this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public Color getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerX=" + getX() +
                ", centerY=" + getY() +
                ", r=" + getR() +
                ", color=" + getColor() +
                ", visible=" + isVisible() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }

    public void hide() {
        visible = false;
        System.out.println("[HIDE] " + this);
    }
}
