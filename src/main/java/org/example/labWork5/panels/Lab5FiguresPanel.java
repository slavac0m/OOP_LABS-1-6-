package org.example.labWork5.panels;

import org.example.Constants;
import org.example.Constants.FigureType;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork5.figures.TFigure;
import org.example.labWork5.CreateFigures;
import org.example.labWork5.figures.secLayer.Circle;
import org.example.labWork5.figures.secLayer.Quadrangle;
import org.example.labWork5.figures.thirdLayer.Ellipse;
import org.example.labWork5.figures.thirdLayer.Rectangle;
import org.example.labWork5.figures.thirdLayer.Rhombus;
import org.example.labWork5.figures.thirdLayer.Trapezoid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lab5FiguresPanel extends JPanel {

    private TFigure[] figures = null;

    private final CreateFigures createFigures;
    private final Utils utils = new Utils();

    public Lab5FiguresPanel() {
        createFigures = new CreateFigures();
    }

    public void createFiguresList() {
        figures = createFigures.getNewRandomFigures();
        repaint();
    }

    public void changeFiguresVisible(FigureType type) {
        if (figures == null) return;
        for (TFigure figure : figures) {
            if (checking(type, figure)) figure.setVisible(!figure.isVisible());
        }
        repaint();
    }

    public void moveFigures(FigureType type) {
        if (figures == null) return;
        for (TFigure figure : figures) {
            if (checking(type, figure))
                figure.moveTo(
                        utils.getRandomInt(-50, 50),
                        utils.getRandomInt(-50, 50)
                );
        }
        repaint();
    }

    public void moveToObePoint(FigureType type) {
        if (figures == null) return;
        for (TFigure figure : figures) {
            if (checking(type, figure))
                figure.setCenter(new MyPoint(Constants.FRAME_WIDTH / 2, Constants.FRAME_HIGH / 2));
        }
        repaint();
    }

    public void moveFigures(FigureType type, int diffX, int diffY) {
        if (figures == null) return;
        for (TFigure figure : figures) {
            if (checking(type, figure)) figure.moveTo(diffX, diffY);
        }
        System.out.println("move");
        repaint();
    }

    public void resizeFigures(FigureType type) {
        if (figures == null) return;
        for (TFigure figure : figures) {
            if (checking(type, figure)) {
                switch (type) {
                    case CIRCLE:
                        ((Circle) figure).setR(utils.getRandomInt(20, 100));
                        break;
                    case ELLIPSE:
                        ((Ellipse) figure).setLargeAxis(utils.getRandomInt(20, 100));
                        ((Ellipse) figure).setLargeAxis(utils.getRandomInt(20, 100));
                        break;
                    case QUADRANGLE:
                    case RECTANGLE:
                    case RHOMBUS:
                    case TRAPEZOID:
                        ((Quadrangle) figure).scale((double) utils.getRandomInt(60, 130) / 100);
                        break;
                    case ALL:
                        if (figure.getClass() == Circle.class) ((Circle) figure).setR(utils.getRandomInt(20, 100));
                        else if (figure.getClass() == Ellipse.class) {
                            ((Ellipse) figure).setLargeAxis(utils.getRandomInt(20, 100));
                            ((Ellipse) figure).setLargeAxis(utils.getRandomInt(20, 100));
                        } else if (
                                figure.getClass() == Quadrangle.class
                                        || figure.getClass() == Rectangle.class
                                        || figure.getClass() == Trapezoid.class
                                        || figure.getClass() == Rhombus.class
                        ) {
                            ((Quadrangle) figure).scale((double) utils.getRandomInt(60, 130) / 100);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + type);
                }
            }
        }
        repaint();
    }

    public void deleteFigures(FigureType type) {
        int i = 0;
        if (figures == null) return;
        while (i < figures.length) {
            if (checking(type, figures[i])) {
                figures[i] = null;
            }
            i++;
        }
        if (type == FigureType.ALL) figures= null;
        repaint();
    }

    private boolean checking(FigureType figureType, TFigure e) {
        if (e == null) return false;
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
        if (figures == null) return;
        for (TFigure figure : figures) {
            if (checking(FigureType.ELLIPSE, figure))
                ((Ellipse) figure).rotate();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (figures == null) return;
        for (TFigure figure : figures)
            if (figure != null) figure.paint(g);
    }

}
