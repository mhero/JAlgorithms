package com.mac.algorithms.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkyList l = new LinkyList();
        l.addNode(new Node(0));
        l.addNode(new Node(1));
        l.addNode(new Node(2));
        l.addNode(new Node(3));

        l.printLinkedList();

        LinkyList l1 = new LinkyList();
        LinkyList.reverseLinkedList(l.getHead(), l1);
        l1.printLinkedList();

    }

}
