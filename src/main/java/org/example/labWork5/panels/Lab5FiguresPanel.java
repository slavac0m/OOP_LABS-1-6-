package org.example.labWork5.panels;

import org.example.Constants.FigureType;
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

    private ArrayList<TFigure> figures = new ArrayList<>();

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
        figures.stream().filter(e -> checking(type, e)).forEach(figure -> figure.setVisible(!figure.isVisible()));
        repaint();
    }
    public void moveFigures(FigureType type){
        figures.stream().filter(e -> checking(type, e)).forEach(figure ->
                figure.moveTo(
                        utils.getRandomInt(-50,50),
                        utils.getRandomInt(-50,50)
                )
        );
        repaint();
    }
    /*
    public void moveToObePoint(String c){
        Point newPoint = new Point(rand.nextInt(MainFrame.FRAME_WIDTH) - 50, rand.nextInt(100) - 50);
        figures.stream().filter(e -> checking(c, e)).forEach(f -> f.setCenter(newPoint));
        repaint();
    }
    */
    public void moveFigures(FigureType type, int diffX, int diffY){
        figures.stream().filter(e -> checking(type,e)).forEach(figure -> {
            figure.moveTo(diffX, diffY);
        });
        repaint();
    }

    public void deleteFigures(FigureType type){
        int i = 0;
        while(i < figures.size()){
            if(checking(type, figures.get(i))){
                figures.get(i).erase();
                figures.remove(i);
                i--;
            }
            i++;
        }
        repaint();
    }

    public void clearFrame(){
        figures.clear();
        repaint();
    }

    private boolean checking(FigureType figureType, TFigure e) {
        return switch (figureType) {
            case CIRCLE -> e instanceof Circle;
            case ELLIPSE -> e instanceof Ellipse;
            case QUADRANGLE -> e instanceof Quadrangle;
            case RECTANGLE -> e instanceof Rectangle;
            case RHOMBUS -> e instanceof Rhombus;
            case TRAPEZOID -> e instanceof Trapezoid;
            case ALL -> true;
            default -> false;
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        figures.forEach(figure -> figure.paint(g));
    }
}
