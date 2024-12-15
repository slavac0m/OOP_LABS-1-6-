package org.example.labWork5;

import org.example.Constants;
import org.example.Constants.FigureType;
import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork5.figures.TFigure;
import org.example.labWork5.figures.secLayer.Circle;
import org.example.labWork5.figures.secLayer.Quadrangle;
import org.example.labWork5.figures.thirdLayer.Ellipse;
import org.example.labWork5.figures.thirdLayer.Rectangle;
import org.example.labWork5.figures.thirdLayer.Rhombus;
import org.example.labWork5.figures.thirdLayer.Trapezoid;

import java.awt.*;

public class CreateFigures {
    Utils utils = new Utils();

    private final int frameWidth;
    private final int frameHeight;

    public CreateFigures() {
        this.frameWidth = Constants.FRAME_WIDTH;
        this.frameHeight = Constants.FRAME_HIGH;
    }

    public TFigure[] getNewRandomFigures() {

        TFigure[] figures = new TFigure[utils.getRandomInt(20,30)];
        for (int i = 0; i < figures.length; i++) {
            
            FigureType type;
            type = FigureType.valueOf(
                    FigureType.getNames()[utils.getRandomInt(
                            FigureType.values().length -1
                    )]
            );

            switch (type) {
                case CIRCLE -> figures[i] = createRandomCircle();
                case ELLIPSE -> figures[i] = createRandomEllipse();
                case QUADRANGLE -> figures[i] = createRandomQuadrangle();
                case RECTANGLE -> figures[i] = createRandomRectangle();
                case RHOMBUS -> figures[i] = createRandomRhombus();
                case TRAPEZOID -> figures[i] = createRandomTrapezoid();
            }

        }

        return figures;
    }

    public Circle createRandomCircle() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int r = utils.getRandomInt(20, 55);
        Color color = utils.getRandomColor();
        return new Circle(new MyPoint(x, y), color,r);
    }







    public Ellipse createRandomEllipse() {
        int x = utils.getRandomInt(frameWidth);
        int y = utils.getRandomInt(frameHeight);
        int r = utils.getRandomInt(20, 55);
        int axis = utils.getRandomInt(55, 95);
        Color color = utils.getRandomColor();
        return new Ellipse(new MyPoint(x, y), r, axis, color);
    }
    

    public Quadrangle createRandomQuadrangle() {
        MyPoint[] points = new MyPoint[4];
        for (int i = 0; i < points.length; i++) points[i] = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        return new Quadrangle(points, color);
    }

  

    public Rectangle createRandomRectangle() {
        MyPoint point = utils.getRandomPoint();
        int width = utils.getRandomInt(20, 100);
        int high = utils.getRandomInt(20, 100);
        Color color = utils.getRandomColor();
        return new Rectangle(point, width, high, color);
    }


    public Rhombus createRandomRhombus() {
        MyPoint center = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        int diagonal1 = utils.getRandomInt(20, 60);
        int diagonal2 = utils.getRandomInt(60, 130);
        return new Rhombus(center, diagonal1, diagonal2, color);
    }


    public Trapezoid createRandomTrapezoid() {
        MyPoint topLeft = utils.getRandomPoint();
        Color color = utils.getRandomColor();
        int topWidth = utils.getRandomInt(30, 60);
        int bottomWidth = topWidth + utils.getRandomInt(20, 60);
        int height = utils.getRandomInt(20, 80);
        return new Trapezoid(topLeft, topWidth, bottomWidth, height, color);
    }
    

}
