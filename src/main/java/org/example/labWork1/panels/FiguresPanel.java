package org.example.labWork1.panels;

import org.example.labWork1.FigureFactory;
import org.example.labWork1.figures.Circle;
import org.example.labWork1.figures.Line;
import org.example.labWork1.figures.Rectangle;
import org.example.labWork1.figures.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class FiguresPanel extends JPanel {

    private Circle circle;
    private Rectangle rectangle;
    private Line line;
    private Triangle triangle;

    private Circle[] circles;
    private Rectangle[] rectangles;
    private Line[] lines;
    private Triangle[] triangles;

    private FigureFactory figureFactory;

    private final Random rand = new Random();

    public FiguresPanel() {
        figureFactory = new FigureFactory();
    }

    public void addOneCircle() {
        if(circle != null) {
            circle.erase();
            repaint();
            circle = null;
            System.gc();
        }
        circle = figureFactory.createRandomCircle();
        repaint();

    }
    public void addCircleList(){
        if(circles != null) {
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
            int diffX = rand.nextInt(80) - 40;
            int diffY = rand.nextInt(80) - 40;
            circle.moveTo(diffX, diffY);
        }

        repaint();

    }
    public void moveCircleList() {
        if (circles != null) {
            for(Circle c: circles){
                int diffX = rand.nextInt(80) - 40;
                int diffY = rand.nextInt(80) - 40;
                c.moveTo(diffX, diffY);
            };
        }
        repaint();

    }
    public void changeCircle() {
        if (circle != null) {
            int r = rand.nextInt(100) + 20;
            circle.changeRadius(r);
        }
        repaint();

    }
    public void changeCircleList() {
        if (circles != null) {
            Arrays.stream(circles).forEach(e -> {
                int r = rand.nextInt(100) + 20;
                e.changeRadius(r);
            });
        }
        repaint();
    }
    public void deleteCircle(){
        if (circle!= null) {
            circle.erase();
            repaint();
            circle = null;
        }
    }
    public void deleteCircles(){
        if (circles!= null) {
            Arrays.stream(circles).forEach(Circle::erase);
            repaint();
            Arrays.fill(circles, null);
            circles = null;
        }
    }


    public void addOneRectangle() {
        if(rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
            System.gc();
        }
        rectangle = figureFactory.createRandomRectangle();
        repaint();

    }
    public void addRectangleList(){
        if(rectangles != null) {
            Arrays.stream(rectangles).forEach(Rectangle::erase);
            repaint();
            rectangles = null;
            System.gc();
        }
        rectangles = figureFactory.createRandomRectangularList();
        repaint();

    }
    public void moveRectangle() {
        if (rectangle != null) {
            int diffX = rand.nextInt(80) - 40;
            int diffY = rand.nextInt(80) - 40;
            rectangle.moveTo(diffX, diffY);
        }
        repaint();

    }
    public void moveRectangleList() {
        if (rectangles != null) {
            for (Rectangle r:rectangles){
                int diffX = rand.nextInt(80) - 40;
                int diffY = rand.nextInt(80) - 40;
                r.moveTo(diffX, diffY);
            };
        }
        repaint();

    }
    public void changeRectangle() {
        if (rectangle != null) {
            int diffWidth = rand.nextInt(100) + 20;
            int diffHeight = rand.nextInt(100) + 20;
            rectangle.changeForm(diffWidth, diffHeight);
        }
        repaint();

    }
    public void changeRectangleList() {
        if (rectangles != null) {
            Arrays.stream(rectangles).forEach(e -> {
                int diffWidth = rand.nextInt(100) + 20;
                int diffHeight = rand.nextInt(100) + 20;
                e.changeForm(diffWidth, diffHeight);
            });
        }
        repaint();
    }
    public void deleteRectangle(){
        if (rectangle!= null) {
            rectangle.erase();
            repaint();
            rectangle = null;
        }
    }
    public void deleteRectangles(){
        Arrays.stream(rectangles).forEach(Rectangle::erase);
        repaint();
        Arrays.fill(rectangles, null);
        rectangles = null;
    }

    public void clearFrame(){
        if(circle != null) {
            circle.erase();
            repaint();
            circle = null;
        }
        if(rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
        }

        if(circles != null) {
            Arrays.stream(circles).forEach(Circle::erase);
            repaint();
            Arrays.fill(circles, null);
            circles = null;
        }
        if(rectangles != null) {
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

        if(circle != null) circle.paint(g);
        if(rectangle != null) rectangle.paint(g);

        if(circles != null)
            Arrays.stream(circles).forEach(circle -> circle.paint(g));
        if(rectangles != null) Arrays.stream(rectangles).forEach(rectangle -> rectangle.paint(g));

    }


}
