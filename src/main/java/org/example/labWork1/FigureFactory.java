package org.example.labWork1;

import org.example.Constants;
import org.example.labWork1.figures.Circle;
import org.example.labWork1.figures.Rectangle;

import java.awt.*;
import java.util.Random;

public class FigureFactory {
    private Random rand = new Random();

    private final int frameWidth;
    private final int frameHeight;

    public FigureFactory() {
        this.frameWidth = Constants.FRAME_WIDTH;
        this.frameHeight = Constants.FRAME_HIGH;
    }


    public Circle createRandomCircle() {
        int r = rand.nextInt(100) + 20;
        int centerX = rand.nextInt(frameWidth);
        int centerY = rand.nextInt(frameHeight);

        Color color = Constants.colors[rand.nextInt(Constants.colors.length)];

        return new Circle(centerX, centerY, r, color);
    }

    public Rectangle createRandomRectangle() {
        int width = rand.nextInt(100) + 20;
        int high = rand.nextInt(100) + 20;
        int centerX = rand.nextInt(frameWidth);
        int centerY = rand.nextInt(frameHeight);

        Color color = Constants.colors[rand.nextInt(Constants.colors.length)];

        return new Rectangle(centerX, centerY, width, high,color);
    }


    public Circle[] createRandomCircleList() {
        Circle[] ellips = new Circle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < ellips.length; i++) {
            ellips[i] = createRandomCircle();
        }
        return ellips;
    }

    public Rectangle[] createRandomRectangularList() {
        Rectangle[] rectangles = new Rectangle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = createRandomRectangle();
        }
        return rectangles;
    }

}
