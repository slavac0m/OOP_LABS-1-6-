package org.example.labWork3.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;

public class Line extends TFigure {

    private MyPoint endPoint;

    public Line(MyPoint point, MyPoint endPoint, Color color) {
        super(point, color);
        this.endPoint = endPoint;
    }

    public Line(MyPoint startPoint, MyPoint endPoint) {
        this(startPoint, endPoint, Color.BLACK);
    }

    public Line(MyPoint point) {
        this(point, new MyPoint(point.getX() + 123, point.getY() + 234));
    }

    public void change(MyPoint newEndPoint) {
        endPoint = newEndPoint;
    }


    @Override
    public void paint(Graphics g) {
        setGraphics(g);
        if (!isVisible()) return;
        g.setColor(getColor());
        g.drawLine(getPoint().getX(), getPoint().getY(), endPoint.getX(),endPoint.getY());
    }

    public MyPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(MyPoint endPoint) {
        this.endPoint = endPoint;
    }
}

