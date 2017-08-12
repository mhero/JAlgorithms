/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.algorithms.avl;

/**
 *
 * @author marco
 */
public class AVLTreeNode<K extends Comparable<K>> implements Comparable<AVLTreeNode<K>> {

    /**
     * The height of a left or right child node that doesn't exist.
     */
    private static final int NULL_NODE_HEIGHT = -1;

    private AVLTreeNode<K> left;
    private AVLTreeNode<K> right;
    private K key;
    private int height;

    public AVLTreeNode(K key) {
        this.key = key;
    }

    public boolean leftExists() {
        return left != null;
    }

    public boolean rightExists() {
        return right != null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public AVLTreeNode<K> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<K> left) {
        this.left = left;
    }

    public AVLTreeNode<K> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<K> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

/**
     * Performs a right rotate on this node.
     *
     *       b                           a
     *      / \                         / \
     *     a   e -> b.rotateRight() -> c   b
     *    / \                             / \
     *   c   d                           d   e
     *
     * @return The root of the sub-tree; the node where this node used to be.
     */
    public AVLTreeNode<K> rotateRight() {
        AVLTreeNode<K> other = getLeft();
        setLeft(other.getRight());
        other.setRight(this);
        setHeight(Math.max(this.getLeftHeight(), this.getRightHeight()) + 1);
        other.setHeight(Math.max(other.getLeftHeight(), this.getHeight()) + 1);
        return other;
    }

    /**
     * Performs a left rotate on this node.
     *
     *     a                              b
     *    / \                            / \
     *   c   b   -> a.rotateLeft() ->   a   e
     *      / \                        / \
     *     d   e                      c   d
     *
     * @return The root of the sub-tree; the node where this node used to be.
     */
    public AVLTreeNode<K> rotateLeft() {
        AVLTreeNode<K> other = getRight();
        setRight(other.getLeft());
        other.setLeft(this);
        setHeight(Math.max(this.getLeftHeight(), this.getRightHeight()) + 1);
        other.setHeight(Math.max(other.getRightHeight(), this.getHeight()) + 1);
        return other;
    }

    /**
     * Convenience function to get the height of the left child of the node,
     * returning {@link NULL_NODE_HEIGHT} if the node is null.
     *
     * @return The height of the left child, or {@link NULL_NODE_HEIGHT} if it
     * doesn't exist.
     */
    public int getLeftHeight() {
        if (!leftExists()) {
            return NULL_NODE_HEIGHT;
        }
        return getLeft().getHeight();
    }

    /**
     * Convenience function to get the height of the right child of the node,
     * returning {@link NULL_NODE_HEIGHT} if the node is null.
     *
     * @return The height of the right child, or {@link NULL_NODE_HEIGHT} if it
     * doesn't exist.
     */
    public int getRightHeight() {
        if (!rightExists()) {
            return NULL_NODE_HEIGHT;
        }
        return getRight().getHeight();
    }

    @Override
    public int compareTo(AVLTreeNode<K> o) {
        return key.compareTo(o.key);
    }
}
