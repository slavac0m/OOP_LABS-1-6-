package org.example.labWork3.panels;

import org.example.Utils;
import org.example.labWork3.CreateFigures;
import org.example.labWork3.figures.secLayer.Circle;
import org.example.labWork3.figures.secLayer.Quadrangle;
import org.example.labWork3.figures.thirdLayer.Ellipse;
import org.example.labWork3.figures.thirdLayer.Rhombus;
import org.example.labWork3.figures.thirdLayer.Trapezoid;
import org.example.labWork3.figures.thirdLayer.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Lab3FiguresPanel extends JPanel {

    private Circle circle;
    private Ellipse ellipse;
    private Quadrangle quadrangle;
    private Rectangle rectangle;
    private Rhombus rhombus;
    private Trapezoid trapezoid;

    private Circle[] circles;
    private Ellipse[] ellipses;
    private Quadrangle[] quadrangles;
    private Rectangle[] rectangles;
    private Rhombus[] rhombuses;
    private Trapezoid[] trapezoids;

    private final CreateFigures createFigures;
    private final Utils utils = new Utils();

    public Lab3FiguresPanel() {
        createFigures = new CreateFigures();
    }

    public void addOneCircle() {
        if (circle != null) {
            circle.erase();
            repaint();
            circle = null;
            System.gc();
        }
        circle = createFigures.createRandomCircle();
        repaint();
    }

    public void addCircleList() {
        if (circles != null) {
            Arrays.stream(circles).forEach(Circle::erase);
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
            circle.setR(r);
        }
        repaint();
    }

    public void changeCircleList() {
        if (circles != null) {
            for (Circle c : circles) {
                int r = utils.getRandomInt(-50, 50);
                c.setR(r);
            }
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


    public void addOneEllipse() {
        if (ellipse != null) {
            ellipse.erase();
            repaint();
            ellipse = null;
            System.gc();
        }
        ellipse = createFigures.createRandomEllipse();
        repaint();
    }

    public void addEllipseList() {
        if (ellipses != null) {
            Arrays.stream(ellipses).forEach(Circle::erase);
            repaint();
            ellipses = null;
            System.gc();
        }
        ellipses = createFigures.createRandomEllipseList();
        repaint();
    }

    public void moveEllipse() {
        if (ellipse != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            ellipse.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveEllipseList() {
        if (ellipses != null) {
            for (Ellipse e : ellipses) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                e.moveTo(dX, dY);
            }
        }
        repaint();
    }

    public void changeEllipse() {
        if (ellipse != null) {
            ellipse.rotate();
        }
        repaint();
    }

    public void changeEllipseList() {
        if (ellipses != null) {
            for (Ellipse e : ellipses) e.rotate();
        }
        repaint();
    }

    public void deleteEllipse() {
        if (ellipse != null) {
            ellipse.erase();
            repaint();
            ellipse = null;
        }
    }

    public void deleteEllipseList() {
        if (ellipses != null) {
            Arrays.stream(ellipses).forEach(Circle::erase);
            repaint();
            Arrays.fill(ellipses, null);
            ellipses = null;
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
            rectangle.rotate();
        }
        repaint();
    }

    public void changeRectangleList() {
        if (rectangles != null) {
            Arrays.stream(rectangles).forEach(e -> {
                int diffWidth = utils.getRandomInt(20, 100);
                int diffHeight = utils.getRandomInt(20, 100);
//                e.changeForm(diffWidth, diffHeight);
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

    public void addOneRhombus() {
        if (rhombus != null) {
            rhombus.erase();
            repaint();
            rhombus = null;
            System.gc();
        }
        rhombus = createFigures.createRandomRhombus();
        repaint();
    }

    public void addRhombusList() {
        if (rhombuses != null) {
            Arrays.stream(rhombuses).forEach(Rhombus::erase);
            repaint();
            rhombuses = null;
            System.gc();
        }
        rhombuses = createFigures.createRandomRhombusList();
        repaint();
    }

    public void moveRhombus() {
        if (rhombus != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            rhombus.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveRhombusList() {
        if (rhombuses != null) {
            for (Rhombus r : rhombuses) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                r.moveTo(dX, dY);
            }
        }
        repaint();
    }

    public void changeRhombus() {
        if (rhombus != null) rhombus.rotate();
        repaint();
    }

    public void changeRhombusList() {
        if (rhombuses != null) Arrays.stream(rhombuses).forEach(Rhombus::rotate);
        repaint();
    }

    public void deleteRhombus() {
        if (rhombus != null) {
            rhombus.erase();
            repaint();
            rhombus = null;
        }
    }

    public void deleteRhombusList() {
        Arrays.stream(rhombuses).forEach(Rhombus::erase);
        repaint();
        Arrays.fill(rhombuses, null);
        rhombuses = null;
    }

    public void addOneQuadrangle() {
        if (quadrangle != null) {
            quadrangle.erase();
            repaint();
            quadrangle = null;
            System.gc();
        }
        quadrangle = createFigures.createRandomQuadrangle();
        repaint();

    }

    public void addQuadrangleList() {
        if (quadrangles != null) {
            Arrays.stream(quadrangles).forEach(Quadrangle::erase);
            repaint();
            quadrangles = null;
            System.gc();
        }
        quadrangles = createFigures.createRandomQuadrangleList();
        repaint();
    }

    public void moveQuadrangle() {
        if (quadrangle != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            quadrangle.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveQuadrangleList() {
        if (quadrangles != null) {
            for (Quadrangle q : quadrangles) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                q.moveTo(dX, dY);
            }
        }
        repaint();
    }

    public void changeQuadrangle() {
        if (quadrangle != null) quadrangle.rotate();
        repaint();
    }

    public void changeQuadrangleList() {
        if (quadrangles != null) Arrays.stream(quadrangles).forEach(Quadrangle::rotate);
        repaint();
    }

    public void deleteQuadrangle() {
        if (quadrangle != null) {
            quadrangle.erase();
            repaint();
            quadrangle = null;
        }
    }

    public void deleteQuadrangleList() {
        Arrays.stream(quadrangles).forEach(Quadrangle::erase);
        repaint();
        Arrays.fill(quadrangles, null);
        quadrangles = null;
    }

    public void addOneTrapezoid() {
        if (trapezoid != null) {
            trapezoid.erase();
            repaint();
            trapezoid = null;
            System.gc();
        }
        trapezoid = createFigures.createRandomTrapezoid();
        repaint();
    }

    public void addTrapezoidList() {
        if (trapezoids != null) {
            Arrays.stream(trapezoids).forEach(Trapezoid::erase);
            repaint();
            trapezoids = null;
            System.gc();
        }
        trapezoids = createFigures.createRandomTrapezoidList();
        repaint();
    }

    public void moveTrapezoid() {
        if (trapezoid != null) {
            int dX = utils.getRandomInt(-50, 50);
            int dY = utils.getRandomInt(-50, 50);
            trapezoid.moveTo(dX, dY);
        }
        repaint();
    }

    public void moveTrapezoidList() {
        if (trapezoids != null) {
            for (Trapezoid t : trapezoids) {
                int dX = utils.getRandomInt(-50, 50);
                int dY = utils.getRandomInt(-50, 50);
                t.moveTo(dX, dY);
            }
        }
        repaint();
    }

    public void changeTrapezoid() {
        if (trapezoid != null) trapezoid.rotate();
        repaint();
    }

    public void changeTrapezoidList() {
        if (trapezoids != null) Arrays.stream(trapezoids).forEach(Trapezoid::rotate);
        repaint();
    }

    public void deleteTrapezoid() {
        if (trapezoid != null) {
            trapezoid.erase();
            repaint();
            trapezoid = null;
        }
    }

    public void deleteTrapezoidList() {
        if (trapezoids != null) {
            Arrays.stream(trapezoids).forEach(Trapezoid::erase);
            repaint();
            Arrays.fill(trapezoids, null);
            trapezoids = null;
        }
    }


    public void clearFrame() {
        if (circle != null) deleteCircle();
        if (ellipse != null) deleteEllipse();
        if (rectangle != null) deleteRectangle();
        if (quadrangle != null) deleteQuadrangle();
        if (rhombus != null) deleteRhombus();
        if (trapezoid != null) deleteTrapezoid();

        if (circles != null) deleteCircleList();
        if (ellipses != null) deleteEllipseList();
        if (rectangles != null) deleteRectangleList();
        if (quadrangles != null) deleteQuadrangleList();
        if (rhombuses != null) deleteRhombusList();
        if (trapezoids != null) deleteTrapezoidList();
        System.gc();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (circle != null) circle.paint(g);
        if (ellipse != null) ellipse.paint(g);
        if (rectangle != null) rectangle.paint(g);
        if (quadrangle != null) quadrangle.paint(g);
        if (rhombus != null) rhombus.paint(g);
        if (trapezoid != null) trapezoid.paint(g);

        if (circles != null)
            Arrays.stream(circles).forEach(c -> c.paint(g));
        if (ellipses != null)
            Arrays.stream(ellipses).forEach(e -> e.paint(g));
        if (rectangles != null)
            Arrays.stream(rectangles).forEach(r -> r.paint(g));
        if (quadrangles != null)
            Arrays.stream(quadrangles).forEach(q -> q.paint(g));
        if (rhombuses != null)
            Arrays.stream(rhombuses).forEach(r -> r.paint(g));
        if (trapezoids != null)
            Arrays.stream(trapezoids).forEach(t -> t.paint(g));
    }
}
