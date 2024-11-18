package org.example.labWork3;

import org.example.Constants;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork3.figures.secLayer.Circle;
import org.example.labWork3.figures.secLayer.Quadrangle;
import org.example.labWork3.figures.thirdLayer.Ellipse;
import org.example.labWork3.figures.thirdLayer.Rectangle;
import org.example.labWork3.figures.thirdLayer.Rhombus;
import org.example.labWork3.figures.thirdLayer.Trapezoid;

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
        int r = utils.getRandomInt(20, 55);
        Color color = utils.getRandomColor();
        return new Circle(new MyPoint(x, y), r, color);
    }

    public Circle[] createRandomCircleList() {
        Circle[] circles = new Circle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < circles.length; i++) circles[i] = createRandomCircle();
        return circles;
    }

    public Ellipse createRandomEllipse() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int r = utils.getRandomInt(20, 55);
        int axis = utils.getRandomInt(55, 95);
        Color color = utils.getRandomColor();
        return new Ellipse(new MyPoint(x, y), r, axis, color);
    }

    public Ellipse[] createRandomEllipseList() {
        Ellipse[] ellipses = new Ellipse[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < ellipses.length; i++) ellipses[i] = createRandomEllipse();
        return ellipses;
    }

    public Quadrangle createRandomQuadrangle() {
        MyPoint[] points = new MyPoint[4];
        for (int i = 0; i < points.length ; i++) points[i] = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        return new Quadrangle(points, color);
    }

    public Quadrangle[] createRandomQuadrangleList() {
        Quadrangle[] quadrangles = new  Quadrangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < quadrangles.length; i++) quadrangles[i] = createRandomQuadrangle();
        return quadrangles;
    }

    public Rectangle createRandomRectangle() {
        MyPoint point = utils.getRandomPoint();
        int width = utils.getRandomInt(20, 100);
        int high = utils.getRandomInt(20, 100);
        Color color = utils.getRandomColor();
        return new Rectangle(point, width, high, color);
    }

    public Rectangle[] createRandomRectangleList() {
        Rectangle[] rectangles = new Rectangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < rectangles.length; i++) rectangles[i] = createRandomRectangle();
        return rectangles;
    }

    public Rhombus createRandomRhombus() {
        MyPoint center = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        int diagonal1 = utils.getRandomInt(20, 60);
        int diagonal2 = utils.getRandomInt(60, 130);
        return new Rhombus(center, diagonal1, diagonal2, color);
    }

    public Rhombus[] createRandomRhombusList() {
        Rhombus[] rhombuses = new Rhombus[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < rhombuses.length; i++) rhombuses[i] = createRandomRhombus();
        return rhombuses;
    }

    public Trapezoid createRandomTrapezoid() {
        MyPoint topLeft = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        int topWidth = utils.getRandomInt(30, 60);
        int bottomWidth = topWidth + utils.getRandomInt(20, 60);
        int height = utils.getRandomInt(20, 80);
        return new Trapezoid(topLeft, topWidth, bottomWidth, height, color);
    }

    public Trapezoid[] createRandomTrapezoidList() {
        Trapezoid[] trapezoids = new Trapezoid[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < trapezoids.length; i++) trapezoids[i] = createRandomTrapezoid();
        return trapezoids;
    }

}
