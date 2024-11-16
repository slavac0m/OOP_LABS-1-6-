package org.example.labWork2.figures.compositFigures;

import org.example.labWork1.figures.Circle;
import org.example.labWork2.MyPoint;

import java.awt.*;

public class Ring {
    private Circle innerCircle;
    private Circle outerCircle;


    public Ring(MyPoint center, int innerR, int outerR, Color color){
        outerCircle = new Circle(center.getX(),center.getY(),outerR, color);
        innerCircle = new Circle(center.getX(),center.getY(),innerR, Color.WHITE);
        System.out.println("[CREATE] " + this);
    }

    public void moveTo(int dX, int dY) {
        innerCircle.moveTo(dX, dY);
        outerCircle.moveTo(dX, dY);
        System.out.println("[MOVE] " + this);
    }

    public void changeSize(int innerR, int outerR){
        innerCircle.setRadius(innerR);
        outerCircle.setRadius(outerR);

        System.out.println("[EDIT] " + this);
    }

    public void hide(){
        innerCircle.hide();
        outerCircle.hide();
        System.out.println("[RING HIDE]");
    }

    public void show(Graphics g){
        outerCircle.show(g);
        innerCircle.show(g);
    }

    @Override
    public String toString() {
        return "Ring{" +
                "innerCircle=" + innerCircle +
                ", outerCircle=" + outerCircle +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        innerCircle = null;
        outerCircle = null;
        System.out.println("[FINALIZED RING]");
    }

}
