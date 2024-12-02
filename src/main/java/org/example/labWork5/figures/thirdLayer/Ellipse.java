package org.example.labWork5.figures.thirdLayer;

import org.example.MyPoint;
import org.example.labWork5.figures.secLayer.Circle;

import java.awt.*;

public class Ellipse extends Circle {
    private int largeAxis;

    public Ellipse(MyPoint point, int smallAxis, int largeAxis, Color color) {
        super(point, color, smallAxis);
        this.largeAxis = largeAxis;
    }

    public void rotate() {
        int t = getSmallAxis();
        setSmallAxis(largeAxis);
        largeAxis = t;

        System.out.println("[ROTATE] " + this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(getColor());
        g.fillOval(
                getCenter().getX() - getSmallAxis(),
                getCenter().getY() - getLargeAxis(),
                getSmallAxis() * 2,
                largeAxis * 2
        );
        g.setColor(Color.BLACK);
        g.drawOval(
                getCenter().getX() - getSmallAxis(),
                getCenter().getY() - getLargeAxis(),
                getSmallAxis() * 2,
                largeAxis * 2
        );
    }

    public int getLargeAxis() {
        return largeAxis;
    }

    public void setLargeAxis(int largeAxis) {
        this.largeAxis = largeAxis;
    }

    public int getSmallAxis() {
        return getR();
    }

    public void setSmallAxis(int smallAxis) {
        setR(smallAxis);
    }


    @Override
    public String toString() {
        return "Ellipse{" +
                "smallAxis=" + getSmallAxis() +
                ", largeAxis=" + largeAxis +
                ", center=" + getCenter() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}
