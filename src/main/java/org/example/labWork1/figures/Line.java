package org.example.labWork1.figures;

import org.example.Constants;

import java.awt.*;

public class Line {
    private int startX, startY, endX, endY;
    private Color color;
    private boolean visible = true;

    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

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
}
