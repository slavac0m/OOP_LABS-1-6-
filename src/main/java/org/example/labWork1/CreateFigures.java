package org.example.labWork1;

import org.example.Constants;
import org.example.Utils;
import org.example.labWork1.figures.Circle;
import org.example.labWork1.figures.Line;
import org.example.labWork1.figures.Rectangle;
import org.example.labWork1.figures.Triangle;

import java.awt.*;

public class CreateFigures {
    Utils utils = new Utils();

    private final int frameWidth;
    private final int frameHeight;

    public CreateFigures() {
        this.frameWidth = Constants.FRAME_WIDTH;
        this.frameHeight = Constants.FRAME_HIGH;
    }

    public Circle createRandomCircle() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        Color color = utils.getRandomColor();
        return new Circle(x, y, color);
    }

    public Rectangle createRandomRectangle() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        Color color = utils.getRandomColor();
        return new Rectangle(x, y, color);
    }

    public Triangle createRandomTriangle() {
        int x1 = utils.getRandomInt(frameWidth);
        int x2 = utils.getRandomInt(frameWidth);
        int x3 = utils.getRandomInt(frameWidth);
        int y1 = utils.getRandomInt(frameHeight);
        int y2 = utils.getRandomInt(frameHeight);
        int y3 = utils.getRandomInt(frameHeight);
        return new Triangle(new int[]{x1, x2, x3}, new int[]{y1, y2, y3});
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
        for (int i = 0; i < circles.length; i++) {
            int x = utils.getRandomInt(frameWidth);
            int r = utils.getRandomInt(60);
            int y = utils.getRandomInt(frameHeight);
            Color color = utils.getRandomColor();
            circles[i] =  new Circle(x, y, color);;
        }
        return circles;
    }

    public Rectangle[] createRandomRectangleList() {
        Rectangle[] rectangles = new Rectangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < rectangles.length; i++) {
            int width = utils.getRandomInt(20, 100);
            int high = utils.getRandomInt(20, 100);
            int x = utils.getRandomInt(frameWidth);
            int y = utils.getRandomInt(frameHeight);
            Color color = utils.getRandomColor();
            rectangles[i] = new Rectangle(x, y, width, high, color);
        }
        return rectangles;
    }

    public Triangle[] createRandomTriangleList() {
        Triangle[] triangles = new Triangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < triangles.length; i++){
            int x1 = utils.getRandomInt(frameWidth);
            int x2 = utils.getRandomInt(frameWidth);
            int x3 = utils.getRandomInt(frameWidth);
            int y1 = utils.getRandomInt(frameHeight);
            int y2 = utils.getRandomInt(frameHeight);
            int y3 = utils.getRandomInt(frameHeight);
            Color color = new Utils().getRandomColor();
            triangles[i] =  new Triangle(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, color);
        }
        return triangles;
    }

    public Line[] createRandomLineList() {
        Line[] lines = new Line[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < lines.length; i++) {
            int startX = utils.getRandomInt(frameWidth);
            int endX = utils.getRandomInt(frameWidth);
            int startY = utils.getRandomInt(frameHeight);
            int endY = utils.getRandomInt(frameHeight);
            lines[i] = new Line(startX, startY, endX, endY);
        }
        return lines;
    }
}
