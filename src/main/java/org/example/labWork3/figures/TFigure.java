package org.example.labWork3.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;

public abstract class TFigure {
    private MyPoint point;
    private boolean visible = true;
    private Graphics graphics;
    private Color color;

    public TFigure(MyPoint point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyPoint getPoint() {
        return point;
    }

    public void setPoint(MyPoint point) {
        this.point = point;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void moveTo(int dX, int dY){
        point.setX(point.getX() + dX);
        point.setY(point.getY() + dY);
    }

    public void hide() {
        this.visible = false;
    }

    public abstract void paint(Graphics g);


    @Override
    protected void finalize() throws Throwable{
        point = null;
        System.gc();
    }
}
