package org.example.labWork2.figures;

import org.example.Constants;
import org.example.labWork2.MyPoint;

import java.awt.*;


public class Circle {
    private final MyPoint center;
    private int r;
    private final Color color;
    private boolean visible = true;

    public Circle(int x, int y, int r, Color color) {
        this.center = new MyPoint(x, y);
        this.r = r;
        this.color = color;
        validSize();
        System.out.println("[CREATE] " + this);
    }


    public Circle(int x, int y, Color color) {
        this.center = new MyPoint(x,y);
        this.r = 20;
        this.color = color;
        validSize();
        System.out.println("[CREATE] " + this);
    }

    public void moveTo(int dX, int dY) {
        center.setX(center.getX() + dY);
        center.setY(center.getY() + dY);
        System.out.println("[MOVE] " + this);
    }

    public void setRadius(int newR) {
        r = newR;
        System.out.println("[EDIT RADIUS] " + this);
    }

    public void show(Graphics graphics) {
        if (!visible) return;
        Color lineColor = Color.BLACK;
        graphics.setColor(color);
        graphics.fillOval(center.getX() - r, center.getY() - r, r * 2, r * 2);
        graphics.setColor(lineColor);
        graphics.drawOval(center.getX()- r, center.getY() - r, r * 2, r * 2);
        System.out.println("[SHOW] " + this);
    }


    public int getR() { return r; }

    public Color getColor() { return color; }

    public boolean isVisible() { return visible; }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", r=" + getR() +
                ", color=" + getColor() +
                ", visible=" + isVisible()+
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }

    private void validSize(){
        if(center.getX() + r > Constants.FRAME_WIDTH) setRadius(Constants.FRAME_WIDTH - center.getX());
        if(center.getX() - r < 0) setRadius(center.getX());
        if(center.getY() + r > Constants.FRAME_HIGH) setRadius(Constants.FRAME_HIGH - center.getY());
        if(center.getY() - r < 0) setRadius(center.getY());
    }

    public void hide() {
        visible = false;
        System.out.println("[HIDE] " + this);
    }
}
