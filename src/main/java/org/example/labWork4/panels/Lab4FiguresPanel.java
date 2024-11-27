package org.example.labWork4.panels;

import org.example.Constants.FigureType;
import org.example.Utils;
import org.example.labWork4.figures.secLayer.Quadrangle;
import org.example.labWork4.figures.thirdLayer.Ellipse;
import org.example.labWork4.figures.secLayer.Circle;
import org.example.labWork4.CreateFigures;
import org.example.labWork4.figures.TFigure;
import org.example.labWork4.figures.thirdLayer.Rectangle;
import org.example.labWork4.figures.thirdLayer.Rhombus;
import org.example.labWork4.figures.thirdLayer.Trapezoid;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Lab4FiguresPanel extends JPanel {

    private TFigure[] figure = new TFigure[6];
    private TFigure[][] figures = new TFigure[6][];


    private final CreateFigures createFigures;
    private final Utils utils = new Utils();

    public Lab4FiguresPanel() {
        createFigures = new CreateFigures();
    }

    public void addOneFigure(FigureType figureType) {
        int index = figureType.getIndex();
        deleteOneFigure(figureType);

        switch (figureType) {
            case CIRCLE -> figure[index] = createFigures.createRandomCircle();
            case ELLIPSE -> figure[index] = createFigures.createRandomEllipse();
            case QUADRANGLE -> figure[index] = createFigures.createRandomQuadrangle();
            case RECTANGLE -> figure[index] = createFigures.createRandomRectangle();
            case RHOMBUS -> figure[index] = createFigures.createRandomRhombus();
            case TRAPEZOID -> figure[index] = createFigures.createRandomTrapezoid();
        }
        repaint();
    }

    public void addArrayFigures(FigureType figureType) {
        int index = figureType.getIndex();
        deleteArrayFigure(figureType);

        switch (figureType) {
            case CIRCLE -> figures[index] = createFigures.createRandomCircleList();
            case ELLIPSE -> figures[index] = createFigures.createRandomEllipseList();
            case QUADRANGLE -> figures[index] = createFigures.createRandomQuadrangleList();
            case RECTANGLE -> figures[index] = createFigures.createRandomRectangleList();
            case RHOMBUS -> figures[index] = createFigures.createRandomRhombusList();
            case TRAPEZOID -> figures[index] = createFigures.createRandomTrapezoidList();
        }
        repaint();
    }

    public void moveOneFigure(FigureType figureType) {
        int index = figureType.getIndex();
        if (figure[index] != null) figure[index].moveTo(
                utils.getRandomInt(-50, 50),
                utils.getRandomInt(-50, 50)
        );
        repaint();
    }

    public void moveArrayFigure(FigureType figureType) {
        int index = figureType.getIndex();
        if (figures[index] != null) {
            for (int i = 0; i < figures[index].length; i++) {
                figures[index][i].moveTo(
                        utils.getRandomInt(-50, 50),
                        utils.getRandomInt(-50, 50)
                );
            }
        }
        repaint();
    }

    public void changeOneFigure(FigureType figureType) {
        int index = figureType.getIndex();
        if (figure[index] != null) {
            switch (figureType) {
                case CIRCLE -> ((Circle) figure[index]).setR(utils.getRandomInt(20, 30));
                case ELLIPSE -> ((Ellipse) figure[index]).rotate();
                case QUADRANGLE -> ((Quadrangle) figure[index]).rotate();
                case RECTANGLE -> ((Rectangle) figure[index]).rotate();
                case RHOMBUS -> ((Rhombus) figure[index]).rotate();
                case TRAPEZOID -> ((Trapezoid) figure[index]).rotate();
                default -> throw new IllegalStateException("Unexpected value: " + figureType);
            }
        }
        repaint();
    }


    public void changeArrayFigures(FigureType figureType) {
        int index = figureType.getIndex();
        if (figures[index] != null) {
            switch (figureType) {

                case CIRCLE -> {
                    for (int i = 0; i < figures[index].length; i++) {
                        if (figures[index][i] != null) ((Circle) figures[index][i]).setR(utils.getRandomInt(20, 30));
                    }
                }
                case ELLIPSE -> {
                    for (int i = 0; i < figures[index].length; i++) {
                        if (figures[index][i] != null) ((Ellipse) figures[index][i]).rotate();
                    }
                }
                case QUADRANGLE -> {
                    for (int i = 0; i < figures[index].length; i++) {
                        if (figures[index][i] != null) ((Quadrangle) figures[index][i]).rotate();
                    }
                }
                case RECTANGLE -> {
                    for (int i = 0; i < figures[index].length; i++) {
                        if (figures[index][i] != null) ((Rectangle) figures[index][i]).rotate();
                    }
                }
                case RHOMBUS -> {
                    for (int i = 0; i < figures[index].length; i++) {
                        if (figures[index][i] != null) ((Rhombus) figures[index][i]).rotate();
                    }
                }
                case TRAPEZOID -> {
                    for (int i = 0; i < figures[index].length; i++) {
                        if (figures[index][i] != null) ((Trapezoid) figures[index][i]).rotate();
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + figureType);
            }
        }
        repaint();
    }


    public void deleteOneFigure(FigureType figureType) {
        int index = figureType.getIndex();
        if (figure[index] != null) {
            figure[index].erase();
            repaint();
            figure[index] = null;
            System.gc();
        }
    }

    public void deleteArrayFigure(FigureType figureType) {
        int index = figureType.getIndex();
        if (figures[index] == null) return;
        Arrays.fill(figures[index], null);
        figures[index] = null;
        repaint();
    }


    public void clearFrame() {
        for (FigureType figureType : FigureType.values()) {
            deleteOneFigure(figureType);
            deleteArrayFigure(figureType);
        }
        repaint();
        System.gc();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Arrays.stream(figure).forEach(f -> {
            if (f != null) f.paint(g);
        });

        Arrays.stream(figures).forEach(f -> {
            if (f != null) {
                Arrays.stream(f).forEach(e -> {
                    if (e != null) e.paint(g);
                });
            }
        });
    }

}
