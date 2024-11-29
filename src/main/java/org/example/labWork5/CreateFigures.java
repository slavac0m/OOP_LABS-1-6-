package org.example.labWork5;

import org.example.Constants;
import org.example.Constants.FigureType;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork5.figures.TFigure;
import org.example.labWork5.figures.secLayer.Circle;
import org.example.labWork5.figures.secLayer.Quadrangle;
import org.example.labWork5.figures.thirdLayer.Ellipse;
import org.example.labWork5.figures.thirdLayer.Rectangle;
import org.example.labWork5.figures.thirdLayer.Rhombus;
import org.example.labWork5.figures.thirdLayer.Trapezoid;

import java.awt.*;
import java.util.ArrayList;

public class CreateFigures {
    Utils utils = new Utils();

    private final int frameWidth;
    private final int frameHeight;

    public CreateFigures() {
        this.frameWidth = Constants.FRAME_WIDTH;
        this.frameHeight = Constants.FRAME_HIGH;
    }

    public ArrayList<TFigure> getNewRandomFigures() {

        int count = utils.getRandomInt(4,13);
        ArrayList<TFigure> figures = new ArrayList<>(createRandomCircleList(count));

        count = utils.getRandomInt(4,13);
        figures.addAll(createRandomEllipseList(count));

        count = utils.getRandomInt(4,13);
        figures.addAll(createRandomQuadrangleList(count));

        count = utils.getRandomInt(4,13);
        figures.addAll(createRandomRectangleList(count));

        count = utils.getRandomInt(4,13);
        figures.addAll(createRandomRhombusList(count));

        count = utils.getRandomInt(4,13);
        figures.addAll(createRandomTrapezoidList(count));

        return figures;
    }

    public Circle createRandomCircle() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int r = utils.getRandomInt(20, 55);
        Color color = utils.getRandomColor();
        return new Circle(new MyPoint(x, y), r, color);
    }

    public ArrayList<Circle> createRandomCircleList(int count) {
        ArrayList<Circle> circles = new ArrayList<>();
        for (int i = 0; i < count; i++)circles.add(createRandomCircle());
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

    public ArrayList<Ellipse> createRandomEllipseList(int count) {
        ArrayList<Ellipse> ellipses = new ArrayList<>();
        for (int i = 0; i < count; i++) ellipses.add(createRandomEllipse());
        return ellipses;
    }

    public Quadrangle createRandomQuadrangle() {
        MyPoint[] points = new MyPoint[4];
        for (int i = 0; i < points.length; i++) points[i] = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        return new Quadrangle(points, color);
    }

    public ArrayList<Quadrangle> createRandomQuadrangleList(int count) {
        ArrayList<Quadrangle> quadrangles = new ArrayList<>();
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

    public ArrayList<Rectangle> createRandomRectangleList(int count) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
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

    public ArrayList<Rhombus> createRandomRhombusList(int count) {
        ArrayList<Rhombus> rhombuses = new ArrayList<>();
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

    public ArrayList<Trapezoid> createRandomTrapezoidList(int count) {
        ArrayList<Trapezoid> trapezoids = new ArrayList<>();
        for (int i = 0; i < count; i++) trapezoids.add(createRandomTrapezoid());
        return trapezoids;
    }

}
