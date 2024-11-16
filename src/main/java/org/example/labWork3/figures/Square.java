package org.example.labWork3.figures;

import org.example.labWork2.MyPoint;

import java.awt.*;

public class Square  extends TFigure{

    private int side;

    public Square(MyPoint point, Color color, int side) {
        super(point,color);
        this.side = side;
    }

    public Square(MyPoint point,int side){
        this(point, Color.CYAN, side);
    }


    public Square(MyPoint point){
        this(point, Color.CYAN, 40);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void paint(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(getColor());
        g.drawRect(getPoint().getX(), getPoint().getY(), side,side);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[FINALIZE] " + this);
    }
}
