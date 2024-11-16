package org.example.labWork2.panels;

import org.example.Utils;
import org.example.labWork2.CreateFigures;
import org.example.labWork2.figures.Circle;
import org.example.labWork2.figures.Line;
import org.example.labWork2.figures.Rectangle;
import org.example.labWork2.figures.Triangle;
import org.example.labWork2.figures.compositFigures.House;
import org.example.labWork2.figures.compositFigures.Ring;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Lab2FiguresPanel extends JPanel {

    private Circle circle;
    private Rectangle rectangle;
    private Line line;
    private Triangle triangle;

    private Ring ring;
    private House house;

    private Circle[] circles;
    private Rectangle[] rectangles;
    private Line[] lines;
    private Triangle[] triangles;
    private Ring[] rings;
    private House[] houses;

    private final CreateFigures createFigures;
    private final Utils utils = new Utils();

    public Lab2FiguresPanel() {
        createFigures = new CreateFigures();
    }

    public void addOneHouse() {
        if (house != null) {
            house.erase();
            repaint();
            house = null;
            System.gc();
        }
        house = createFigures.createRandomHouse();
        repaint();
    }

    public void addHouseList() {
        if (houses != null) {
            Arrays.stream(houses).forEach(House::erase);
            repaint();
            houses = null;
            System.gc();
        }
        houses = createFigures.createHouseList();
        repaint();
    }

    public void moveHouse() {
        if (house != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            house.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveHouseList() {
        if (houses != null) {
            for (House h : houses) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                h.moveTo(dX, dY);
            }
        }
        repaint();
    }

    public void changeHouse() {
        if (house != null) {
            Color baseColor = utils.getRandomColor();
            Color roofColor = utils.getRandomColor();
            house.editColor(baseColor, roofColor);
        }
        repaint();
    }

    public void changeHouseList() {
        if (houses != null) {
            for (House h : houses) {
                Color baseColor = utils.getRandomColor();
                Color roofColor = utils.getRandomColor();
                h.editColor(baseColor, roofColor);
            }
        }
        repaint();
    }

    public void deleteHouse() {
        if (house != null) {
            house.erase();
            repaint();
            house = null;
        }
    }

    public void deleteHouseList() {
        if (houses != null) {
            Arrays.stream(houses).forEach(House::erase);
            repaint();
            Arrays.fill(houses, null);
            houses = null;
        }
    }

    public void addOneCircle() {
        if (circle != null) {
            circle.hide();
            repaint();
            circle = null;
            System.gc();
        }
        circle = createFigures.createRandomCircle();
        repaint();
    }

    public void addCircleList() {
        if (circles != null) {
            Arrays.stream(circles).forEach(Circle::hide);
            repaint();
            circles = null;
            System.gc();
        }
        circles = createFigures.createRandomCircleList();
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
        }
        repaint();
    }

    public void changeCircle() {
        if (circle != null) {
            int r = utils.getRandomInt(20, 100);
            circle.setRadius(r);
        }
        repaint();
    }

    public void changeCircleList() {
        if (circles != null) {
            for (Circle c : circles) {
                int r = utils.getRandomInt(-50, 50);
                c.setRadius(r);
            }
        }
        repaint();
    }

    public void deleteCircle() {
        if (circle != null) {
            circle.hide();
            repaint();
            circle = null;
        }
    }

    public void deleteCircleList() {
        if (circles != null) {
            Arrays.stream(circles).forEach(Circle::hide);
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
        line = createFigures.createRandomLine();
        repaint();

    }

    public void addLineList() {
        if (lines != null) {
            Arrays.stream(lines).forEach(Line::erase);
            repaint();
            lines = null;
            System.gc();
        }
        lines = createFigures.createRandomLineList();
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
            int angle = utils.getRandomInt(360);
            line.rotate(angle);
        }
        repaint();
    }

    public void changeLineList() {
        if (lines != null) {
            for (Line l : lines) {
                int angle = utils.getRandomInt(360);
                l.rotate(angle);
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
        triangle = createFigures.createRandomTriangle();
        repaint();
    }

    public void addTriangleList() {
        if (triangles != null) {
            for (Triangle t : triangles) t.erase();
            repaint();
            triangles = null;
            System.gc();
        }
        triangles = createFigures.createRandomTriangleList();
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
        if (triangle != null) {
            int angle = utils.getRandomInt(360);
            triangle.rotate(angle);
        }
        repaint();
    }

    public void changeTriangleList() {
        if (triangles != null) {
            for (Triangle t : triangles) {
                int angle = utils.getRandomInt(360);
                t.rotate(angle);
            }
        }
        repaint();
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
        rectangle = createFigures.createRandomRectangle();
        repaint();

    }

    public void addRectangleList() {
        if (rectangles != null) {
            Arrays.stream(rectangles).forEach(Rectangle::erase);
            repaint();
            rectangles = null;
            System.gc();
        }
        rectangles = createFigures.createRandomRectangleList();
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

    public void addOneRing() {
        if (ring != null) {
            ring.hide();
            repaint();
            ring = null;
            System.gc();
        }
        ring = createFigures.createRing();
        repaint();
    }

    public void addRingList() {
        if (rings != null) {
            Arrays.stream(rings).forEach(Ring::hide);
            repaint();
            rings = null;
            System.gc();
        }
        rings = createFigures.createRingList();
        repaint();
    }

    public void moveRing() {
        if (ring != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            ring.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveRingList() {
        if (rings != null) {
            for (Ring r : rings) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                r.moveTo(dX, dY);
            }
        }
        repaint();
    }

    public void changeRing() {
        if (ring != null) {
            int innerR = utils.getRandomInt(20, 50);
            int outerR = innerR + utils.getRandomInt(10, 40);
            ring.changeSize(innerR, outerR);
        }
        repaint();
    }

    public void changeRingList() {
        if (rings != null) {
            Arrays.stream(rings).forEach(r -> {
                int innerR = utils.getRandomInt(20, 50);
                int outerR = innerR + utils.getRandomInt(10, 40);
                r.changeSize(innerR, outerR);
            });
        }
        repaint();
    }

    public void deleteRing() {
        if (ring != null) {
            ring.hide();
            repaint();
            ring = null;
        }
    }

    public void deleteRingList() {
        Arrays.stream(rings).forEach(Ring::hide);
        repaint();
        Arrays.fill(rings, null);
        rings = null;
    }

    public void clearFrame() {
        if (line != null) deleteLine();
        if (circle != null)  deleteCircle();
        if (rectangle != null) deleteRectangle();
        if (triangle != null) deleteRectangle();
        if (ring != null) deleteRing();
        if (house != null) deleteHouse();

        if (lines != null) deleteLineList();
        if (circles != null) deleteCircleList();
        if (rectangles != null) deleteRectangleList();
        if (triangles != null) deleteTriangleList();
        if (rings != null) deleteRingList();
        if (houses != null) deleteHouseList();
        System.gc();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (circle != null) circle.show(g);
        if (rectangle != null) rectangle.show(g);
        if (triangle != null) triangle.show(g);
        if (line != null) line.show(g);
        if (ring != null) ring.show(g);
        if (house != null) house.show(g);

        if (triangles != null)
            Arrays.stream(triangles).forEach(triangle -> triangle.show(g));
        if (circles != null)
            Arrays.stream(circles).forEach(circle -> circle.show(g));
        if (rectangles != null)
            Arrays.stream(rectangles).forEach(rectangle -> rectangle.show(g));
        if (lines != null)
            Arrays.stream(lines).forEach(line -> line.show(g));
        if (rings != null)
            Arrays.stream(rings).forEach(ring -> ring.show(g));
        if(houses != null)
            Arrays.stream(houses).forEach(house -> house.show(g));
    }
}
