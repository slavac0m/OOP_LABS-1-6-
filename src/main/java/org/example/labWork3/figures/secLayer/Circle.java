package org.example.labWork3.figures.secLayer;

import org.example.MyPoint;
import org.example.labWork3.figures.TFigure;

import java.awt.*;


public class Circle extends TFigure {
    private int r;

    public Circle(MyPoint point, int r, Color color) {
        super(point, color);
        this.r = r;
        System.out.println("[CREATE] " + this);
    }

    public Circle(MyPoint point, int r) {
        this(point, r, Color.BLUE);
    }

    public Circle(MyPoint point) {
        this(point, 50);
    }


    @Override
    public void paint(Graphics g) {
        setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!isVisible()) return;
        g.setColor(getColor());
        g.fillOval(
                getPoint().getX() - r,
                getPoint().getY() - r,
                r * 2,
                r * 2
        );
        g.setColor(lineColor);
        g.drawOval(
                getPoint().getX() - r,
                getPoint().getY() - r,
                r * 2,
                r * 2
        );
    }

    @Override
    public void moveTo(int dX, int dY) {
        getPoint().moveTo(dX,dY);
    }


    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }

    public void erase(){
        setVisible(false);
        System.out.println("[ERASE] "+ this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] "+ this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", center=" + getPoint().toString() +
                '}';
    }
}
