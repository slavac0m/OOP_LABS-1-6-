package org.example.labWork3.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;

public class Rectangle extends Square{
    private int width;

    public Rectangle(MyPoint point, int width, int height, Color color){
        super(point,color,width);
        this.width = width;
        this.setColor(color);
    }

    public Rectangle(MyPoint point, int width, int height){
        this(point, width, height, Color.YELLOW);
    }

    public void changeSize(int width, int height){
        setHeight(width);
        setWidth(width);
    }

    @Override
    public void paint(Graphics g){
        if (!isVisible()) return;
        g.setColor(Color.ORANGE);
        g.drawRect(getPoint().getX(),getPoint().getY(),getWidth(),getHeight());
    }

    public int getHeight() { return getSide(); }
    public void setHeight(int height) { setSide(height); }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
}
