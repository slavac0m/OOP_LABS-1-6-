package org.example.labWork1.figures;

import org.example.Constants;

import java.awt.*;

public class Line {
    private int startX, startY, endX, endY;
    private Color color;
    private boolean visible = true;

    public Line(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        System.out.println("Line created ( " + this.toString() + " )");
    }

    public Line(Color color) {
        this.color = color;
        this.startX = 0;
        this.startY = 0;
        this.endX = Constants.FRAME_WIDTH;
        this.endY = Constants.FRAME_HIGH;

        System.out.println("Line created ( " + this.toString() + " )");
    }

    public void moveTo(int dX, int dY){
        startX += dX;
        startY += dY;
        endY += dY;
        endX += dX;
        System.out.println("Line moved at " + dX + ", " + dY);
    }


    @Override
    public String toString() {
        return "Line{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", color=" + color +
                '}';
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void erase() {
        visible = false;
        System.out.println("Triangle erased");
    }

    public void paint(Graphics g){
        if (visible){
            g.setColor(color);
            g.drawLine(startX,startY,endX,endY);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Line finalized");
    }
}

