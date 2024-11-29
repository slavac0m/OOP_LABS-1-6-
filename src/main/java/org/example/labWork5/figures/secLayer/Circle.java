package org.example.labWork5.figures.secLayer;

import org.example.MyPoint;
import org.example.labWork5.figures.TFigure;

import java.awt.*;


public class Circle extends TFigure {
    int r;

    public Circle(MyPoint[] point, int r, Color color) {
        super(point, color);
        this.r = r;
        System.out.println("[CREATE] " + this);
    }

    public Circle(MyPoint point, int r, Color color) {
        super(new MyPoint[]{point}, color);
        this.r = r;
        System.out.println("[CREATE] " + this);
    }

    @Override
    public void paint(Graphics g) {
        setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!isVisible()) return;
        g.setColor(getColor());
        g.fillOval(
                getPoints()[0].getX() - r,
                getPoints()[0].getY() - r,
                r * 2,
                r * 2
        );
        g.setColor(lineColor);
        g.drawOval(
                getPoints()[0].getX() - r,
                getPoints()[0].getY() - r,
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
    public void erase(){
        setVisible(false);
        System.out.println("[ERASE] "+ this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
//        System.out.println("[DELETE] "+ this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", center=" + getPoints()[0] +
                '}';
    }
}
