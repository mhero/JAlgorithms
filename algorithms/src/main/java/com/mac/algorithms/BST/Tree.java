package com.mac.algorithms.BST;

public class Tree {

    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addNode(Node newNode) {

        if (root == null) {

            root = newNode;

        } else {

            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (newNode.compareTo(focusNode) < 0) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }

    }

    public void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.getLeftChild());
            root.printNode();
            inOrderTraverse(root.getRightChild());
        }
    }

    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            focusNode.printNode();
            preorderTraverseTree(focusNode.getLeftChild());
            preorderTraverseTree(focusNode.getRightChild());
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.getLeftChild());
            postOrderTraverseTree(focusNode.getRightChild());
            focusNode.printNode();
        }
    }

    public Node findNode(int key) {

        Node focusNode = root;

        while (!focusNode.getKey().equals(key)) {
            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else {
                focusNode = focusNode.getRightChild();
            }
            if (focusNode == null) {
                return null;
            }
        }

        return focusNode;

    }

    public int findHeight(Node aNode) {
        if (aNode == null) {
            return -1;
        }

        int lefth = findHeight(aNode.getLeftChild());
        int righth = findHeight(aNode.getRightChild());

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

}
