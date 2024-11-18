package org.example.labWork3.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork3.figures.secLayer.Circle;

import java.awt.*;

public class Ellipse extends Circle {
    private int smallAxis;
    private int largeAxis;

    public Ellipse(MyPoint point, int smallAxis, int largeAxis, Color color) {
        super(point, 0, color);
        this.smallAxis = smallAxis;
        this.largeAxis = largeAxis;
        System.out.println("[CREATE] " + this);
    }

    public void change(int smallAxis, int largeAxis) {
        setLargeAxis(largeAxis);
        setSmallAxis(smallAxis);
    }

    public void rotate() {
        int t = smallAxis;
        smallAxis = largeAxis;
        largeAxis = t;
    }

    @Override
    public void paint(Graphics g) {
        if (!isVisible()) return;
        g.setColor(getColor());
        g.fillOval(getPoint().getX(), getPoint().getY(), smallAxis * 2, largeAxis * 2);
        g.setColor(Color.BLACK);
        g.drawOval(getPoint().getX(), getPoint().getY(), smallAxis * 2, largeAxis * 2);
    }

    public int getLargeAxis() {
        return largeAxis;
    }

    public void setLargeAxis(int largeAxis) {
        this.largeAxis = largeAxis;
    }

    public int getSmallAxis() {
        return getSmallAxis();
    }

    public void setSmallAxis(int smallAxis) {
        this.smallAxis = smallAxis;
    }


    @Override
    public String toString() {
        return "Ellipse{" +
                "smallAxis=" + smallAxis +
                ", largeAxis=" + largeAxis +
                ", center=" + getPoint() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
