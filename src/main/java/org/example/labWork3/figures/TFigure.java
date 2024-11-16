package org.example.labWork3.figures;

import org.example.MyPoint;

import java.awt.*;

public abstract class TFigure {
    private MyPoint point;
    private Graphics graphics;
    private Color color;
    private boolean visible = true;

    public TFigure(MyPoint point, Color color) {
        this.point = point;
        this.color = color;
    }

    public void erase() {
        this.visible = false;
    }
    public abstract void paint(Graphics g);
    public void moveTo(int dX, int dY){
        point.setX(point.getX() + dX);
        point.setY(point.getY() + dY);
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


    @Override
    protected void finalize() throws Throwable{
        point = null;
        System.gc();
    }

    @Override
    public String toString() {
        return "TFigure{" +
                "point=" + point +
                ", graphics=" + graphics +
                ", color=" + color +
                ", visible=" + visible +
                '}';
    }
}
