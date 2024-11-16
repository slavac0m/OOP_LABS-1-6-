package org.example.labWork1.figures;

import java.awt.*;
import java.util.Arrays;

public class Triangle {
    private int[] xPoints;
    private int[] yPoints;
    private Color color;
    private boolean visible = true;

    public Triangle(int[] xPoints, int[] yPoints, Color color) {
        this.xPoints=xPoints;
        this.yPoints = yPoints;
        this.color = color;

        System.out.println("Triangle created (" + this.toString() + ")");
    }

    public void moveTo(int dX, int dY) {
        for (int i = 0; i < 3; i++) {
            xPoints[i] += dX;
            yPoints[i] += dY;
        }
//        System.out.println("Triangle moved to vertices (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")");
    }

    public void erase() {
        visible = false;
        System.out.println("Triangle erased");
    }

    public void paint(Graphics graphics) {
        if (visible) {
            graphics.setColor(color);
            graphics.fillPolygon(xPoints, yPoints, 3);
        } else
            System.out.println("Triangle is invisible and will not be painted");
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "xPoints=" + Arrays.toString(xPoints) +
                ", yPoints=" + Arrays.toString(yPoints) +
                ", color=" + color +
                ", visible=" + visible +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Triangle finalized");
    }
}
