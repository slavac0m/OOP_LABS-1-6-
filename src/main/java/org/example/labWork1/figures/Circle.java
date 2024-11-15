package org.example.labWork1.figures;

import java.awt.*;

public class Circle {
    private int centerX;
    private int centerY;

    private int r;

    private Color color;
    private boolean visible = true;

    public Circle(int centerX, int centerY, int r, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.r = r;
        this.color = color;

        System.out.println("Circle created " + this.toString());
    }

    public Circle(Color color) {
        this.centerX = 0;
        this.centerY = 0;
        this.r = 5;
        this.color = color;

        System.out.println("Circle created " + this.toString());
    }

    public Circle(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.r = 20;

        System.out.println("Circle created " + this.toString());
    }

    public void moveTo(int dX, int dY){
        centerX += dX;
        centerY += dY;

        System.out.println("Circle moved at " + centerX + ", " + centerY);
    }

    public void changeRadius(int newR){
        r = newR;
        System.out.println("Circle changed r: " + r);
    }

    public void paint(Graphics graphics) {
        Color lineColor = Color.BLACK;
        if (!visible) {
            color = Color.WHITE;
            lineColor = Color.WHITE;
        }
        graphics.setColor(color);
        graphics.fillOval(centerX - r, centerY - r, r * 2, r * 2);
        graphics.setColor(lineColor);
        graphics.drawOval(centerX - r, centerY - r, r * 2, r * 2);
    }

    public int getCenterX() {
        return centerX;
    }
    public int getCenterY() {
        return centerY;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", r=" + r +
                ", color=" + color +
                ", visible=" + visible +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Ellipse finalized");
    }

    public void erase() {
        visible = false;
        System.out.println("Circle erased");
    }
}
