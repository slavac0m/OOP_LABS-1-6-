package org.example.labWork2;

import org.example.Constants;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork2.figures.Circle;
import org.example.labWork2.figures.Line;
import org.example.labWork2.figures.Rectangle;
import org.example.labWork2.figures.Triangle;
import org.example.labWork2.figures.compositFigures.House;
import org.example.labWork2.figures.compositFigures.Ring;

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

    public House createRandomHouse() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int baseWidth = utils.getRandomInt(50,150);
        int baseHeight = utils.getRandomInt(50,150);
        int roofHeight = utils.getRandomInt(20,55);
        Color baseColor = utils.getRandomColor();
        Color roofColor = utils.getRandomColor();
        return new House(x, y, baseWidth,baseHeight,roofHeight,baseColor, roofColor);
    }

    public House[] createHouseList(){
        House[] houses = new House[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < houses.length; i++) houses[i] = createRandomHouse();
        return houses;
    }

    public Rectangle createRandomRectangle() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        Color color = utils.getRandomColor();
        return new Rectangle(x, y, color);
    }

    public Triangle createRandomTriangle() {
        MyPoint point1 = new MyPoint(
                utils.getRandomInt(frameWidth),
                utils.getRandomInt(frameHeight)
        );
        MyPoint point2 = new MyPoint(
                utils.getRandomInt(frameWidth),
                utils.getRandomInt(frameHeight)
        );
        MyPoint point3 = new MyPoint(
                utils.getRandomInt(frameWidth),
                utils.getRandomInt(frameHeight)
        );

        return new Triangle(new MyPoint[]{point1, point2, point3});
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
            circles[i] =  new Circle(x, y, r, color);;
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
            MyPoint point1 = new MyPoint(
                    utils.getRandomInt(frameWidth),
                    utils.getRandomInt(frameHeight)
            );
            MyPoint point2 = new MyPoint(
                    utils.getRandomInt(frameWidth),
                    utils.getRandomInt(frameHeight)
            );
            MyPoint point3 = new MyPoint(
                    utils.getRandomInt(frameWidth),
                    utils.getRandomInt(frameHeight)
            );
            Color color = new Utils().getRandomColor();
            triangles[i] =  new Triangle(new MyPoint[]{point1, point2, point3}, color);
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

    public Ring createRing(){
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int innerR = utils.getRandomInt(20,50);
        int outerR = innerR + utils.getRandomInt(10, 40);
        Color color = utils.getRandomColor();
        return new Ring(new MyPoint(x,y),innerR, outerR,color);
    }

    public Ring[] createRingList(){
        Ring[] rings = new Ring[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < rings.length; i++) {
            int x = utils.getRandomInt(frameWidth);
            int y = utils.getRandomInt(frameHeight);
            int innerR = utils.getRandomInt(20,50);
            int outerR = innerR + utils.getRandomInt(10, 40);
            Color color = utils.getRandomColor();
            rings[i] = new Ring(new MyPoint(x,y),innerR, outerR,color);
        }
        return rings;
    }
}
