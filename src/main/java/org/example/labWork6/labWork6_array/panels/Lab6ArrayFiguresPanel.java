package org.example.labWork6.labWork6_array.panels;

import org.example.Constants;
import org.example.Constants.FigureType;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork6.labWork6_array.CreateFigures;
import org.example.labWork6.labWork6_array.MyArrayList;
import org.example.labWork6.figures.TFigure;
import org.example.labWork6.figures.secLayer.Circle;
import org.example.labWork6.figures.secLayer.Quadrangle;
import org.example.labWork6.figures.thirdLayer.Ellipse;
import org.example.labWork6.figures.thirdLayer.Rectangle;
import org.example.labWork6.figures.thirdLayer.Rhombus;
import org.example.labWork6.figures.thirdLayer.Trapezoid;

import javax.swing.*;
import java.awt.*;

public class Lab6ArrayFiguresPanel extends JPanel {

    private MyArrayList figures;
    private final CreateFigures createFigures;
    private final Utils utils;

    public Lab6ArrayFiguresPanel() {
        figures = new MyArrayList();
        createFigures = new CreateFigures();
        utils = new Utils();
    }

    public void createFiguresList(FigureType type) {
        figures = createFigures.getNewRandomFigures(type);
        repaint();
    }

    public void changeFiguresVisible(FigureType type) {
        figures.filter(e -> checking(type, e)).forEach(figure -> figure.setVisible(!figure.isVisible()));
        repaint();
    }

    public void moveFigures(FigureType type) {
        figures.filter(e -> checking(type, e)).forEach(figure ->
                figure.moveTo(
                        utils.getRandomInt(-50, 50),
                        utils.getRandomInt(-50, 50)
                )
        );
        repaint();
    }

    public void moveToObePoint(FigureType type) {
        MyPoint frameCenter = new MyPoint(Constants.FRAME_WIDTH / 2, Constants.FRAME_HIGH / 2);
        figures.filter(e -> checking(type, e)).forEach(f -> f.setCenter(frameCenter));
        repaint();
    }

    public void moveFigures(FigureType type, int diffX, int diffY) {
        figures.filter(e -> checking(type, e)).forEach(figure -> {
            figure.moveTo(diffX, diffY);
        });
        System.out.println("move");
        repaint();
    }

    public void resizeFigures(FigureType type) {
        figures.filter(e -> checking(type, e)).forEach(e -> {
            switch (type) {
                case CIRCLE:
                    ((Circle) e).setR(utils.getRandomInt(20, 100));
                    break;
                case ELLIPSE:
                    ((Ellipse) e).setLargeAxis(utils.getRandomInt(20, 100));
                    ((Ellipse) e).setLargeAxis(utils.getRandomInt(20, 100));
                    break;
                case QUADRANGLE:
                case RECTANGLE:
                case RHOMBUS:
                case TRAPEZOID:
                    ((Quadrangle) e).scale((double) utils.getRandomInt(60, 130) / 100);
                    break;

                case ALL:
                    if (e.getClass() == Circle.class) ((Circle) e).setR(utils.getRandomInt(20, 100));
                    else if (e.getClass() == Ellipse.class) {
                        ((Ellipse) e).setLargeAxis(utils.getRandomInt(20, 100));
                        ((Ellipse) e).setLargeAxis(utils.getRandomInt(20, 100));
                    } else if (e.getClass() == Quadrangle.class || e.getClass() == Rectangle.class || e.getClass() == Trapezoid.class || e.getClass() == Rhombus.class) {
                        ((Quadrangle) e).scale((double) utils.getRandomInt(60, 130) / 100);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }
        });
        repaint();
    }

    public void deleteFigures(FigureType type) {
        int i = 0;
        while (i < figures.size()) {
            if (checking(type, figures.get(i))) {
                figures.get(i).erase();
                figures.remove(i);
                i--;
            }
            i++;
        }
        repaint();
    }

    private boolean checking(FigureType figureType, TFigure e) {
        return switch (figureType) {
            case CIRCLE -> e.getClass() == Circle.class;
            case ELLIPSE -> e.getClass() == Ellipse.class;
            case QUADRANGLE -> e.getClass() == Quadrangle.class;
            case TRAPEZOID -> e.getClass() == Trapezoid.class;
            case RECTANGLE -> e.getClass() == Rectangle.class;
            case RHOMBUS -> e.getClass() == Rhombus.class;
            case ALL -> true;
        };
    }

    public void rotateEllipse() {
        figures.filter(e -> checking(FigureType.ELLIPSE, e)).forEach(figure -> ((Ellipse) figure).rotate());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        figures.forEach(figure -> figure.paint(g));
    }
}
