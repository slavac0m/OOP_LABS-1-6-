package org.example.labWork2.figures.compositFigures;

import org.example.MyPoint;
import org.example.labWork2.figures.Rectangle;
import org.example.labWork2.figures.Triangle;

import java.awt.*;
import java.util.Arrays;

public class House {
    private final Rectangle base;
    private final Triangle roof;
    private final Rectangle[] windows;

    public House(int x, int y, int baseWidth, int baseHeight, int roofHeight, Color baseColor, Color roofColor) {
        this.base = new Rectangle(x,y,baseWidth,baseHeight, baseColor);
        MyPoint[] roofPoints = {
                new MyPoint(x, y),
                new MyPoint(x + baseWidth, y),
                new MyPoint(x + baseWidth / 2, y - roofHeight)
        };
        this.roof = new Triangle(roofPoints, roofColor);

        int windowWidth = baseWidth / 5;
        int windowHeight = baseHeight / 3;
        int windowSpacing = baseWidth / 10;
        int windowY = y + baseHeight / 3;

        Rectangle leftWindow = new Rectangle(
                x + windowSpacing,
                windowY,
                windowWidth,
                windowHeight,
                Color.cyan
        );

        Rectangle rightWindow = new Rectangle(
                x + baseWidth - windowSpacing - windowWidth,
                windowY,
                windowWidth,
                windowHeight,
                Color.cyan
        );

        this.windows = new Rectangle[]{leftWindow, rightWindow};
        System.out.println("[CREATE] " + this);

    }

    public void moveTo(int dX, int dY) {
        base.moveTo(dX, dY);
        roof.moveTo(dX, dY);
        for (Rectangle window : windows) window.moveTo(dX, dY);
        System.out.println("[MOVE] " + this);
    }

    public void editColor(Color baseColor, Color roofColor){
        base.setColor(baseColor);
        roof.setColor(roofColor);
    }

    public void erase() {
        base.erase();
        roof.erase();
        for (Rectangle window : windows) window.erase();
        System.out.println("[ERASED] " + this);
    }

    public void show(Graphics graphics) {
        if (!base.isVisible()) return;
        base.show(graphics);
        roof.show(graphics);
        for (Rectangle window : windows) window.show(graphics);
    }

    @Override
    public String toString() {
        return "House{" +
                "base=" + base +
                ", roof=" + roof +
                ", windows=" + Arrays.toString(windows) +
                '}';
    }
}
