package org.example.labWork1.panels;

import org.example.Utils;
import org.example.labWork1.FigureFactory;
import org.example.labWork1.figures.Circle;
import org.example.labWork1.figures.Line;
import org.example.labWork1.figures.Rectangle;
import org.example.labWork1.figures.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Lab1FiguresPanel extends JPanel {

    private Circle circle;
    private Rectangle rectangle;
    private Line line;
    private Triangle triangle;

    private Circle[] circles;
    private Rectangle[] rectangles;
    private Line[] lines;
    private Triangle[] triangles;

    private FigureFactory figureFactory;

    private Utils utils = new Utils();

    public Lab1FiguresPanel() {
        figureFactory = new FigureFactory();
    }

    public void addOneCircle() {
        if (circle != null) {
            circle.erase();
            repaint();
            circle = null;
            System.gc();
        }
        circle = figureFactory.createRandomCircle();
        repaint();

    }

    public void addCircleList() {
        if (circles != null) {
            Arrays.stream(circles).forEach(Circle::erase);
            repaint();
            circles = null;
            System.gc();
        }
        circles = figureFactory.createRandomCircleList();
        repaint();

    }

    public void moveCircle() {
        if (circle != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            circle.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveCircleList() {
        if (circles != null) {
            for (Circle c : circles) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                c.moveTo(dX, dY);
            }
            ;
        }
        repaint();

    }

    public void changeCircle() {
        if (circle != null) {
            int r = utils.getRandomInt(20, 100);
            circle.changeRadius(r);
        }
        repaint();
    }

    public void changeCircleList() {
        if (circles != null) {
            for (Circle c : circles) {
                int r = utils.getRandomInt(-50, 50);
                c.changeRadius(r);
            }
            ;
        }
        repaint();
    }

    public void deleteCircle() {
        if (circle != null) {
            circle.erase();
            repaint();
            circle = null;
        }
    }

    public void deleteCircleList() {
        if (circles != null) {
            Arrays.stream(circles).forEach(Circle::erase);
            repaint();
            Arrays.fill(circles, null);
            circles = null;
        }
    }

    public void addOneLine() {
        if (line != null) {
            line.erase();
            repaint();
            line = null;
            System.gc();
        }
        line = figureFactory.createRandomLine();
        repaint();

    }

    public void addLineList() {
        if (lines != null) {
            Arrays.stream(lines).forEach(Line::erase);
            repaint();
            lines = null;
            System.gc();
        }
        lines = figureFactory.createRandomLineList();
        repaint();
    }

    public void moveLine() {
        if (lines != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            line.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveLineList() {
        if (lines != null) {
            for (Line l : lines) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                l.moveTo(dX, dY);
            }
        }
        repaint();

    }

    public void changeLine() {
        if (line != null) {
            int r = utils.getRandomInt(20, 100);
//            circle.changeRadius(r);
        }
        repaint();
    }

    public void changeLineList() {
        if (lines != null) {
            for (Line l: lines) {
                int r = utils.getRandomInt(-50, 50);
//                c.changeRadius(r);
            }
        }
        repaint();
    }

    public void deleteLine() {
        if (line != null) {
            line.erase();
            repaint();
            line = null;
        }
    }

    public void deleteLineList() {
        if (lines != null) {
            Arrays.stream(lines).forEach(Line::erase);
            repaint();
            Arrays.fill(lines, null);
            lines = null;
        }
    }

    public void addOneTriangle() {
        if (triangle != null) {
            triangle.erase();
            repaint();
            triangle = null;
            System.gc();
        }
        triangle = figureFactory.createRandomTriangle();
        repaint();
    }

    public void addTriangleList() {
        if (triangles != null) {
            for (Triangle t : triangles) t.erase();
            repaint();
            triangles = null;
            System.gc();
        }
        triangles = figureFactory.createRandomTriangleList();
        repaint();

    }

    public void moveTriangle() {
        if (triangle != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            triangle.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveTriangleList() {
        if (triangles != null) {
            for (Triangle t : triangles) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                t.moveTo(dX, dY);
            }
            ;
        }
        repaint();

    }

    public void changeTriangle() {
//        if (triangle != null) {
//            int .nextInt(100) + 20;
//            circle.changeRadius(r);
//        }
//        repaint();

    }

    public void changeTriangleList() {
        if (triangles != null) {
            for (Triangle t : triangles) {
//                int r = rand.nextInt(100) + 20;
//                e.changeRadius(r);
            }

        }
//        repaint();
    }

    public void deleteTriangle() {
        if (triangle != null) {
            triangle.erase();
            repaint();
            triangle = null;
        }
    }

    public void deleteTriangleList() {
        if (triangles != null) {
            Arrays.stream(triangles).forEach(Triangle::erase);
            repaint();
            Arrays.fill(triangles, null);
            triangles = null;
        }
    }


    public void addOneRectangle() {
        if (rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
            System.gc();
        }
        rectangle = figureFactory.createRandomRectangle();
        repaint();

    }

    public void addRectangleList() {
        if (rectangles != null) {
            Arrays.stream(rectangles).forEach(Rectangle::erase);
            repaint();
            rectangles = null;
            System.gc();
        }
        rectangles = figureFactory.createRandomRectangleList();
        repaint();

    }

    public void moveRectangle() {
        if (rectangle != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            rectangle.moveTo(dX, dY);
        }
        repaint();

    }

    public void moveRectangleList() {
        if (rectangles != null) {
            for (Rectangle r : rectangles) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                r.moveTo(dX, dY);
            }
            ;
        }
        repaint();

    }

    public void changeRectangle() {
        if (rectangle != null) {
            int diffWidth = utils.getRandomInt(20, 100);
            int diffHeight = utils.getRandomInt(20, 100);
            rectangle.changeForm(diffWidth, diffHeight);
        }
        repaint();

    }

    public void changeRectangleList() {
        if (rectangles != null) {
            Arrays.stream(rectangles).forEach(e -> {
                int diffWidth = utils.getRandomInt(20, 100);
                int diffHeight = utils.getRandomInt(20, 100);
                e.changeForm(diffWidth, diffHeight);
            });
        }
        repaint();
    }

    public void deleteRectangle() {
        if (rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
        }
    }

    public void deleteRectangleList() {
        Arrays.stream(rectangles).forEach(Rectangle::erase);
        repaint();
        Arrays.fill(rectangles, null);
        rectangles = null;
    }

    public void clearFrame() {
        if (circle != null) {
            circle.erase();
            repaint();
            circle = null;
        }
        if (rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
        }
        if (line != null) {
            line.erase();
            repaint();
            line = null;
        }
        if (triangle != null) {
            triangle.erase();
            repaint();
            triangle = null;
        }

        if (circles != null) {
            Arrays.stream(circles).forEach(Circle::erase);
            repaint();
            Arrays.fill(circles, null);
            circles = null;
        }
        if (triangles != null) {
            Arrays.stream(triangles).forEach(Triangle::erase);
            repaint();
            Arrays.fill(triangles, null);
            triangles = null;
        }
        if (lines != null) {
            Arrays.stream(lines).forEach(Line::erase);
            repaint();
            Arrays.fill(lines, null);
            lines = null;
        }
        if (rectangles != null) {
            Arrays.stream(rectangles).forEach(Rectangle::erase);
            repaint();
            Arrays.fill(rectangles, null);
            rectangles = null;
        }
        System.gc();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (circle != null) circle.paint(g);
        if (rectangle != null) rectangle.paint(g);
        if (triangle != null) triangle.paint(g);
        if (line != null) line.paint(g);

        if (triangles != null)
            Arrays.stream(triangles).forEach(triangle -> triangle.paint(g));
        if (circles != null)
            Arrays.stream(circles).forEach(circle -> circle.paint(g));
        if (rectangles != null)
            Arrays.stream(rectangles).forEach(rectangle -> rectangle.paint(g));

        if (lines != null)
            Arrays.stream(lines).forEach(line -> line.paint(g));
    }
}
