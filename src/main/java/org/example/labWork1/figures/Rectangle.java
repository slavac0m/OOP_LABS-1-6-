package org.example.labWork1.figures;

import java.awt.*;

public class Rectangle {
    private int x;
    private int y;

    private int width;
    private int high;

    private Color color;
    private boolean visible = true;

    public Rectangle(int x, int y, int width, int high, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.high = high;
        this.color = color;

        System.out.println("Rectangle created " + this.toString());
    }

    public Rectangle(int x, int y, Color color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = 10;
        this.high = 20;

        System.out.println("Rectangle created " + this.toString());
    }
    public Rectangle(){
        this.x = 0;
        this.y = 0;
        this.width = 10;
        this.high = 20;

        System.out.println("Rectangle created " + this.toString());
    }

    public void erase(){
        visible = false;
        System.out.println("Rectangle erased");
    }

    public void moveTo(int diffX, int diffY){
        x += diffX;
        y += diffY;
        System.out.println("Rectangle moved at " + x + ", " + y);
    }

    public void changeForm(int width, int high){
        this.width = width;
        this.high = high;
        System.out.println("Rectangle changed width: " + this.width + ", high: " + this.high);
    }

    public void paint(Graphics graphics){
        Color lineColor = Color.BLACK;
        if(!visible){
            lineColor = Color.WHITE;
            color = Color.WHITE;
        }

        graphics.setColor(color);
        graphics.fillRect(x,y, width, high);
        graphics.setColor(lineColor);
        graphics.drawRect(x, y, width, high);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", high=" + high +
                ", color=" + color +
                ", visible=" + visible +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Rectangle finalized");
    }
}
