package org.example;

import java.awt.*;
import java.util.Random;

public class Utils {
    Random random;

    public Utils() {
        this.random = new Random();
    }
    public int getRandomInt(int min, int max){
        return random.nextInt(max - min) + min;
    }

    public int getRandomInt(int max){
        return random.nextInt(max);
    }

    public Color getRandomColor(){
        return Constants.colors[getRandomInt(Constants.colors.length)];
    }
}

