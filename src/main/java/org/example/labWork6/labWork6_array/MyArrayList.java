package org.example.labWork6.labWork6_array;

import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork6.figures.TFigure;

import java.awt.*;
import java.util.Arrays;

public class MyArrayList {
    private TFigure[] elements;
    private int capacity;
    private double ratio;
    private int count;

    public MyArrayList() {
        this.capacity = 10;
        this.ratio = 1.5;
        elements = new TFigure[capacity];
    }

    private void ensureCapacity() {
        if (count >= capacity) {
            expandCapacity();
        }
    }


    private void expandCapacity() {
        int newCapacity = (int) (capacity * ratio);
        elements = Arrays.copyOf(elements, newCapacity);
        capacity = newCapacity;
    }

    public void add(TFigure figure) {
        ensureCapacity();
        elements[count++] = figure;
    }

    public void addAll(MyArrayList arrayList) {
        while (capacity < count + arrayList.count) expandCapacity();
        System.arraycopy(arrayList.elements, 0, elements, count, arrayList.getCount());
        count += arrayList.size();
    }

    public void moveF(int dX, int dY) {
        for (int i = 0; i < count; i++) elements[i].moveTo(dX, dY);
    }

    public void moveF() {
        for (int i = 0; i < count; i++) {
            int dX = new Utils().getRandomInt(-50, 50);
            int dY = new Utils().getRandomInt(-50, 50);
            elements[i].moveTo(dX, dY);
        }
    }

    public void changeVisible() {
        for (int i = 0; i < count; i++) elements[i].setVisible(!elements[i].isVisible());
    }

    public void paint(Graphics g) {
        for (int i = 0; i < count; i++) elements[i].paint(g);
    }


    public void moveToOnePoint(int x, int y) {
        for (int i = 0; i < count; i++) elements[i].setCenter(new MyPoint(x, y));
    }


    public TFigure get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        return elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        System.arraycopy(elements, index + 1, elements, index, count - index - 1);
        elements[--count] = null;
    }

    public int size() {
        return count;
    }

    public int getCount() {
        return count;
    }
}
