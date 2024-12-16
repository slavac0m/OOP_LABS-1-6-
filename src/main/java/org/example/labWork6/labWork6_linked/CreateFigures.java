package org.example.labWork6.labWork6_linked;

import org.example.Constants;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork6.figures.secLayer.Circle;
import org.example.labWork6.figures.secLayer.Quadrangle;
import org.example.labWork6.figures.thirdLayer.Ellipse;
import org.example.labWork6.figures.thirdLayer.Rectangle;
import org.example.labWork6.figures.thirdLayer.Rhombus;
import org.example.labWork6.figures.thirdLayer.Trapezoid;

import java.awt.*;

public class CreateFigures {
    Utils utils = new Utils();

    private final int frameWidth;
    private final int frameHeight;

    public CreateFigures() {
        this.frameWidth = Constants.FRAME_WIDTH;
        this.frameHeight = Constants.FRAME_HIGH;
    }

    public MyLinkedList getNewRandomFigures() {
        MyLinkedList figures = new MyLinkedList();

        figures.addAll(createRandomCircleList(utils.getRandomInt(4, 13)));
        figures.addAll(createRandomEllipseList(utils.getRandomInt(4, 13)));
        figures.addAll(createRandomQuadrangleList(utils.getRandomInt(4, 13)));
        figures.addAll(createRandomRectangleList(utils.getRandomInt(4, 13)));
        figures.addAll(createRandomRhombusList(utils.getRandomInt(4, 13)));
        figures.addAll(createRandomTrapezoidList(utils.getRandomInt(4, 13)));
            

        return figures;
    }

    public Circle createRandomCircle() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int r = utils.getRandomInt(20, 55);
        Color color = utils.getRandomColor();
        return new Circle(new MyPoint(x, y), color, r);
    }

    public MyLinkedList createRandomCircleList(int count) {
        MyLinkedList circles = new MyLinkedList();
        for (int i = 0; i < count; i++) circles.add(createRandomCircle());
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

    public MyLinkedList createRandomEllipseList(int count) {
        MyLinkedList ellipses = new MyLinkedList();
        for (int i = 0; i < count; i++) ellipses.add(createRandomEllipse());
        return ellipses;
    }

    public Quadrangle createRandomQuadrangle() {
        MyPoint[] points = new MyPoint[4];
        for (int i = 0; i < points.length; i++) points[i] = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        return new Quadrangle(points, color);
    }

    public MyLinkedList createRandomQuadrangleList(int count) {
        MyLinkedList quadrangles = new MyLinkedList();
        for (int i = 0; i < count; i++) quadrangles.add(createRandomQuadrangle());
        return quadrangles;
    }

    public Rectangle createRandomRectangle() {
        MyPoint point = utils.getRandomPoint();
        int width = utils.getRandomInt(20, 100);
        int high = utils.getRandomInt(20, 100);
        Color color = utils.getRandomColor();
        return new Rectangle(point, width, high, color);
    }

    public MyLinkedList createRandomRectangleList(int count) {
        MyLinkedList rectangles = new MyLinkedList();
        for (int i = 0; i < count; i++) rectangles.add(createRandomRectangle());
        return rectangles;
    }

    public Rhombus createRandomRhombus() {
        MyPoint center = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        int diagonal1 = utils.getRandomInt(20, 60);
        int diagonal2 = utils.getRandomInt(60, 130);
        return new Rhombus(center, diagonal1, diagonal2, color);
    }

    public MyLinkedList createRandomRhombusList(int count) {
        MyLinkedList rhombuses = new MyLinkedList();
        for (int i = 0; i < count; i++) rhombuses.add(createRandomRhombus());
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

    public MyLinkedList createRandomTrapezoidList(int count) {
        MyLinkedList trapezoids = new MyLinkedList();
        for (int i = 0; i < count; i++) trapezoids.add(createRandomTrapezoid());
        return trapezoids;
    }

}
