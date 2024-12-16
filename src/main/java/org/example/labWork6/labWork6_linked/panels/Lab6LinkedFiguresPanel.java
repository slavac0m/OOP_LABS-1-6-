package org.example.labWork6.labWork6_linked.panels;

import org.example.Constants;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork6.labWork6_linked.CreateFigures;
import org.example.labWork6.labWork6_linked.MyLinkedList;

import javax.swing.*;
import java.awt.*;

public class Lab6LinkedFiguresPanel extends JPanel {

    private MyLinkedList figures = new MyLinkedList();

    private final CreateFigures createFigures;
    private final Utils utils = new Utils();

    public Lab6LinkedFiguresPanel() {
        createFigures = new CreateFigures();
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

    public void moveToObePoint() {
        figures.moveToOnePoint(Constants.FRAME_WIDTH / 2, Constants.FRAME_HIGH / 2);
        repaint();
    }

    public void moveFigures(int dX, int dY) {
        figures.moveF(dX, dY);
        System.out.println("move");
        repaint();
    }

  
    public void deleteFigures() {
        figures.removeALl();
        repaint();
    }

   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        figures.paint(g);
    }
}
