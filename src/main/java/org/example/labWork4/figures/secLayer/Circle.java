package org.example.labWork4.figures.secLayer;

import org.example.MyPoint;
import org.example.labWork4.figures.TFigure;

import java.awt.*;


public class Circle extends TFigure {
    int r;

    public Circle(MyPoint center, Color color, int r) {
        super(center, color);
        this.r = r;
    }

    @Override
    public void paint(Graphics g) {
        setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!isVisible()) return;
        g.setColor(getColor());
        g.fillOval(
                getCenter().getX() - r,
                getCenter().getY() - r,
                r * 2,
                r * 2
        );
        g.setColor(lineColor);
        g.drawOval(
                getCenter().getX() - r,
                getCenter().getY() - r,
                r * 2,
                r * 2
        );
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public void erase() {
        setVisible(false);
        System.out.println("[ERASE] " + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", center=" + getCenter() +
                '}';
    }
}
