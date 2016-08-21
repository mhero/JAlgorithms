package com.mac.algorithms.BST;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(new Node(50, "test"));
        tree.addNode(new Node(25, "test1"));
        tree.addNode(new Node(15, "test2"));

        tree.inOrderTraverse(tree.getRoot());

        Node findNode = tree.findNode(25);

        if (findNode != null) {
            findNode.printNode();
        }
        
        System.out.println("");
    }

}