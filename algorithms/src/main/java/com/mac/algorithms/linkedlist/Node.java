package com.mac.algorithms.linkedlist;

public class Node {

    private Integer value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void showNode() {
        System.out.println("v:" + this.value);
    }
}
