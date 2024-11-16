package org.example.labWork3.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;

public class Ellipse extends Circle {
    private int axis;

    public Ellipse(MyPoint point, int r, int axis, Color color) {
        super(point, r, color);
        this.axis = axis;
    }

    public Ellipse(MyPoint point, int r) {
        this(point, r, 15, Color.red);
    }

    public Ellipse(MyPoint point) {
        this(point, 35);
    }

    public void change(int smallAxis, int largeAxis) {
        this.r = smallAxis;
        this.axis = largeAxis;
    }

    public void rotate(){
        int t = axis;
        axis= getR();
        setR(t);
    }

    @Override
    public void paint(Graphics g){
        if (!isVisible())return;;
        g.setColor(getColor());
        g.drawOval(getPoint().getX(), getPoint().getY(),r*2,axis*2);
    }

    public int getLargeAxis() { return axis; }
    public void setLargeAxis(int largeAxis) { this.axis = axis; }
    public int getSmallAxis() { return getR(); }
    public void setSmallAxis( int smallAxis){ setR(smallAxis);}

}
