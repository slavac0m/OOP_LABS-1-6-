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

    public void createFiguresList() {
        figures = createFigures.getNewRandomFigures();
        repaint();
    }

    public void changeFiguresVisible() {
        figures.changeVisible();
        repaint();
    }


    public void moveFigures() {
        figures.moveF();
        repaint();
    }

    public void moveFigures(int dX, int dY) {
        figures.moveF(dX, dY);
        repaint();
    }

    public void moveToObePoint() {
        figures.moveToOnePoint(Constants.FRAME_WIDTH / 2,  Constants.FRAME_HIGH /2);
        repaint();
    }


    public void deleteFigures() {
        int i = 0;
        while (figures.size() > 0) {
            figures.get(i).erase();
            figures.remove(i);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        figures.paint(g);
    }
}
