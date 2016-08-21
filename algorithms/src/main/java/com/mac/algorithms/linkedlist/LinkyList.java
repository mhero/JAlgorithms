package com.mac.algorithms.linkedlist;

public class LinkyList {

    private Node head;

    public LinkyList() {
        head = null;
    }

    public LinkyList(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void addNode(Node node) {
        if (head != null) {
            Node current = head;
            Node next = current;
            while (next != null) {
                current = next;
                next = current.getNext();
            }
            current.setNext(node);
        } else {
            head = node;
        }
    }

    public void printLinkedList() {
        Node node = head;
        while (node != null) {
            node.showNode();
            node = node.getNext();
        }
    }

    public static void reverseLinkedList(Node head, LinkyList reversed) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        reversed.setHead(head);
    }
}
