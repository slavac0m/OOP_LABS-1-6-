package org.example.labWork6.labWork6_linked;

import org.example.MyPoint;
import org.example.Utils;
import org.example.labWork6.figures.TFigure;

import java.awt.*;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public MyLinkedList() {
    }


    public void add(TFigure figure) {
        Node newNode = new Node(figure);
        if (size == 0) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAll(MyLinkedList list) {
        if (list == null || list.size == 0) return;
        if (size == 0) {
            head = list.head;
            tail = list.tail;
        } else {
            tail.next = list.head;
            tail = list.tail;
        }
        size += list.size;
    }

    public void moveF(int dX, int dY) {
        Node current = head;
        if (head != null) {
            while (current != null) {
                current.data.moveTo(dX, dY);
                current = current.next;
            }
        }
    }

    public void moveF() {
        Node current = head;
        if (head != null) {
            while (current != null) {
                int dX = new Utils().getRandomInt(-50, 50);
                int dY = new Utils().getRandomInt(-50, 50);
                current.data.moveTo(dX, dY);
                current = current.next;
                System.out.println(dX + " " + dY);
            }
        }
    }

    public void changeVisible() {
        Node current = head;
        if (head != null) {
            while (current != null) {
                current.data.setVisible(!current.data.isVisible());
                current = current.next;
            }
        }
    }

    public void paint(Graphics g) {
        Node current = head;
        if (head != null) {
            while (current != null) {
                current.data.paint(g);
                current = current.next;
            }
        }
    }

    public void moveToOnePoint(int x, int y) {
        Node current = head;
        if (head != null) {
            while (current != null) {
                current.data.setCenter(new MyPoint(x,y));
                current = current.next;
            }
        }
    }

    public void removeALl() {
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            size--;
        }
        tail = null;
    }

    public TFigure get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public int size() {
        return size;
    }

    static class Node {
        TFigure data;
        Node next;

        public Node(TFigure data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(TFigure data) {
            this(data, null);
        }

        public TFigure getData() {
            return data;
        }

        public void setData(TFigure data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
