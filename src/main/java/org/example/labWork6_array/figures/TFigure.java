package org.example.labWork6_array.figures;


import org.example.MyPoint;

import java.awt.*;

public abstract class TFigure {
    private MyPoint center;
    private Color color;
    private boolean visible = true;
    private Graphics graphics;

    public TFigure(MyPoint center, Color color) {
        this.center = center;
        this.color = color;
    }

    public abstract void paint(Graphics g);

    public void erase() {
        setVisible(false);
    }

    public final void moveTo(int dX, int dY) {
        center.moveTo(dX, dY);
        paint(graphics);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
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
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
