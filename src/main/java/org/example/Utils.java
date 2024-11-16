package org.example;

import java.awt.*;
import java.util.Random;

public class Utils {
    Random random;

    public Utils() {
        this.random = new Random();
    }
    public int getRandomInt(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }

    public int getRandomInt(int max){
        return random.nextInt(max+1);
    }

    public Color getRandomColor(){
        return Constants.colors[getRandomInt(Constants.colors.length - 1)];
    }

    public MyPoint getRandomPoint(){
        int x = getRandomInt(Constants.FRAME_WIDTH);
        int y = getRandomInt(Constants.FRAME_HIGH);
        return new MyPoint(x,y);
    }
}

