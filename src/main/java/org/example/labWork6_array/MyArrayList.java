package org.example.labWork6_array;

import org.example.labWork6_array.figures.TFigure;

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

    public MyArrayList forEach(Process process) {
        for (int i = 0; i < count; i++) process.process(elements[i]);
        return this;
    }

    public MyArrayList filter(Condition condition) {
        MyArrayList newList = new MyArrayList();
        for (int i = 0; i < count; i++) {
            if(condition.someCondition(elements[i]))
                newList.add(elements[i]);
        }
        return newList;
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
