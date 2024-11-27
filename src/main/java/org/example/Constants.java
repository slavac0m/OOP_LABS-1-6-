package org.example;

import java.awt.*;
import java.util.Arrays;

public class Constants {
    public final static int FRAME_WIDTH = 1000 + 20;
    public final static int FRAME_HIGH = 600 + 78;

    public final static int COUNT_OF_FIGURES = 10;


    public static final Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE,Color.CYAN, Color.DARK_GRAY, Color.ORANGE, Color.YELLOW};

    public enum FigureType {
        CIRCLE("CIRCLE", 0),
        ELLIPSE("ELLIPSE", 1),
        QUADRANGLE("QUADRANGLE", 2),
        RECTANGLE("RECTANGLE", 3),
        RHOMBUS("RHOMBUS", 4),
        TRAPEZOID("TRAPEZOID", 5);

        private final String name;
        private final int index;

        FigureType(String name, int index) {
            this.name = name;
            this.index = index;
        }
        public String getName() {return name;}
        public int getIndex() {return index;}
        public static String[] getNames() {
            return Arrays.stream(FigureType.values())
                    .map(FigureType::getName)
                    .toArray(String[]::new);
        }
    }
}
