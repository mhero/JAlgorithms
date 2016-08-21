package com.mac.algorithms.BST;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Node<T> implements Comparable<Node> {

    private Integer key;
    private T data;
    private Node leftChild;
    private Node rightChild;

    public Node(Integer key, T data) {
        this.key = key;
        this.data = data;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.key, o.getKey());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }

        Node rhs = (Node) obj;
        return new EqualsBuilder().append(this.key, rhs.getKey()).isEquals();
    }

    public void printNode() {
        System.out.println("key: " + this.key + ", data: " + this.data);
    }
}
