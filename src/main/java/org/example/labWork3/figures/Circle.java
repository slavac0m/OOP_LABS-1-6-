package org.example.labWork3.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;


public class Circle extends TFigure{
    int r;

    public Circle(MyPoint point, int r, Color color) {
        super(point, color);
        this.r = r;
    }

    public Circle(MyPoint point, int r) {
        this(point, r, Color.BLUE);
    }

    public Circle(MyPoint point){
        this(point, 50);
    }


    @Override
    public void paint(Graphics g) {
        setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!isVisible()) return;
        g.setColor(getColor());
        g.fillOval(
                this.getPoint().getX() - r,
                this.getPoint().getY() - r,
                r*2,
                r*2
        );
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.gc();
    }
}
