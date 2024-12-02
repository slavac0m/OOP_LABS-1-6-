package org.example.labWork6.labWork6_linked;

import org.example.labWork6.Condition;
import org.example.labWork6.figures.TFigure;

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

    public MyLinkedList forEach(Process process) {
        Node current = head;
        if (head != null) {
            while (current != null) {
                process.process(current.data);
                current = current.next;
            }
        }
        return this;
    }

    public MyLinkedList filter(Condition condition) {
        MyLinkedList filteredList = new MyLinkedList();
        Node current = head;
        while (current != null) {
            if (condition.someCondition(current.data))
                filteredList.add(current.data);
            current = current.next;
        }
        return filteredList;
    }

    public void removeIf(Condition condition) {
        while (head != null && condition.someCondition(head.data)) {
            head = head.next;
            size--;
        }

        if (head == null) {
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (condition.someCondition(current.next.data)) {
                current.next = current.next.next;
                size--;
            } else current = current.next;
        }
        tail = current;
    }

    public TFigure get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public int size() { return size; }
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
