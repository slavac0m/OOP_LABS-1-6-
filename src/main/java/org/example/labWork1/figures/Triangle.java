package org.example.labWork1.figures;

import java.awt.*;

public class Triangle {
    private int x1, y1;
    private int x2, y2;
    private int x3, y3;
    private final Color color;
    private boolean visible = true;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = color;

        System.out.println("Triangle created with vertices (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")");
    }

    public void moveTo(int dX, int dY) {
        x1 += dX;
        y1 += dY;
        x2 += dX;
        y2 += dY;
        x3 += dX;
        y3 += dY;

        System.out.println("Triangle moved to vertices (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")");
    }

    public void erase() {
        visible = false;
        System.out.println("Triangle erased");
    }

    public void paint(Graphics graphics) {
        if (visible) {
            graphics.setColor(color);
            int[] xPoints = { x1, x2, x3 };
            int[] yPoints = { y1, y2, y3 };
            graphics.fillPolygon(xPoints, yPoints, 3);
        } else {
            System.out.println("Triangle is invisible and will not be painted");
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getX3() {
        return x3;
    }

    public int getY3() {
        return y3;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Triangle finalized");
    }
}
