package org.example.labWork5.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork5.figures.secLayer.Circle;

import java.awt.*;

public class Ellipse extends Circle {
    private int smallAxis;
    private int largeAxis;

    public Ellipse(MyPoint point, int smallAxis, int largeAxis, Color color) {
        super(point, 0, color);
        this.smallAxis = smallAxis;
        this.largeAxis = largeAxis;
    }

    public void rotate() {
        int t = smallAxis;
        smallAxis = largeAxis;
        largeAxis = t;
    }

    @Override
    public void paint(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(getColor());
        g.fillOval(getPoints()[0].getX(), getPoints()[0].getY(), smallAxis * 2, largeAxis * 2);
        g.setColor(Color.BLACK);
        g.drawOval(getPoints()[0].getX(), getPoints()[0].getY(), smallAxis * 2, largeAxis * 2);
    }

    public int getLargeAxis() {
        return largeAxis;
    }

    public void setLargeAxis(int largeAxis) {
        this.largeAxis = largeAxis;
    }

    public int getSmallAxis() {
        return smallAxis;
    }

    public void setSmallAxis(int smallAxis) {
        this.smallAxis = smallAxis;
    }


    @Override
    public String toString() {
        return "Ellipse{" +
                "smallAxis=" + smallAxis +
                ", largeAxis=" + largeAxis +
                ", center=" + getPoints()[0] +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
