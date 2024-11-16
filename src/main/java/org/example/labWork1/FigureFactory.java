package org.example.labWork1;

import org.example.Constants;
import org.example.Utils;
import org.example.labWork1.figures.Circle;
import org.example.labWork1.figures.Line;
import org.example.labWork1.figures.Rectangle;
import org.example.labWork1.figures.Triangle;

import java.awt.*;

public class FigureFactory {
    Utils utils = new Utils();

    private final int frameWidth;
    private final int frameHeight;

    public FigureFactory() {
        this.frameWidth = Constants.FRAME_WIDTH;
        this.frameHeight = Constants.FRAME_HIGH;
    }

    public Circle createRandomCircle() {
        int r = utils.getRandomInt(20, 100);
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        Color color = utils.getRandomColor();
        return new Circle(x, y, r, color);
    }

    public Rectangle createRandomRectangle() {
        int width = utils.getRandomInt(20, 100);
        int high = utils.getRandomInt(20, 100);
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);

        Color color = utils.getRandomColor();
        return new Rectangle(x, y, width, high, color);
    }

    public Triangle createRandomTriangle() {
        int x1 = utils.getRandomInt(frameWidth);
        int x2 = utils.getRandomInt(frameWidth);
        int x3 = utils.getRandomInt(frameWidth);
        int y1 = utils.getRandomInt(frameHeight);
        int y2 = utils.getRandomInt(frameHeight);
        int y3 = utils.getRandomInt(frameHeight);
        Color color = new Utils().getRandomColor();
        return new Triangle(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, color);
    }

    public Line createRandomLine() {
        int startX = utils.getRandomInt(frameWidth);
        int endX = utils.getRandomInt(frameWidth);
        int startY = utils.getRandomInt(frameHeight);
        int endY = utils.getRandomInt(frameHeight);
        Color color = new Utils().getRandomColor();
        return new Line(startX, startY, endX, endY, color);
    }

    public Circle[] createRandomCircleList() {
        Circle[] circles = new Circle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < circles.length; i++) circles[i] = createRandomCircle();
        return circles;
    }

    public Rectangle[] createRandomRectangleList() {
        Rectangle[] rectangles = new Rectangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < rectangles.length; i++) rectangles[i] = createRandomRectangle();
        return rectangles;
    }

    public Triangle[] createRandomTriangleList() {
        Triangle[] triangles = new Triangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < triangles.length; i++) triangles[i] = createRandomTriangle();
        return triangles;
    }

    public Line[] createRandomLineList() {
        Line[] lines = new Line[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < lines.length; i++) lines[i] = createRandomLine();
        return lines;
    }
}
