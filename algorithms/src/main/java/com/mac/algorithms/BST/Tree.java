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

    public boolean remove(int key) {

        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while (focusNode.getKey() != key) {
            parent = focusNode;

            if (key < focusNode.getKey()) {
                isItALeftChild = true;
                focusNode = focusNode.getLeftChild();
            } else {
                isItALeftChild = false;
                focusNode = focusNode.getRightChild();
            }
            if (focusNode == null) {
                return false;
            }
        }

        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (focusNode.getRightChild() == null) {
            if (focusNode == root) {
                root = focusNode.getLeftChild();
            } else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getLeftChild());
            } else {
                parent.setRightChild(focusNode.getLeftChild());
            }
        } else if (focusNode.getLeftChild() == null) {
            if (focusNode == root) {
                root = focusNode.getRightChild();
            } else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getRightChild());
            } else {
                parent.setRightChild(focusNode.getRightChild());
            }
        } else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root) {
                root = replacement;
            } else if (isItALeftChild) {
                parent.setLeftChild(replacement);
            } else {
                parent.setRightChild(replacement);
            }
            replacement.setLeftChild(focusNode.getLeftChild());
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.getRightChild();

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();

        }
        if (replacement != replacedNode.getRightChild()) {
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replacedNode.getRightChild());
        }
        return replacement;
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

    public static void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.getLeftChild());
            root.printNode();
            inOrderTraverse(root.getRightChild());
        }
    }

    public static void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            focusNode.printNode();
            preOrderTraverseTree(focusNode.getLeftChild());
            preOrderTraverseTree(focusNode.getRightChild());
        }
    }

    public static void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.getLeftChild());
            postOrderTraverseTree(focusNode.getRightChild());
            focusNode.printNode();
        }
    }

    public static int findHeight(Node aNode) {
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

    private static Node mirror(Node node) {
        if (node == null) {
            return node;
        }

        /* do the subtrees */
        Node left = mirror(node.getLeftChild());
        Node right = mirror(node.getRightChild());

        /* swap the left and right pointers */
        node.setLeftChild(right);
        node.setRightChild(left);

        return node;
    }

    public static Tree mirror(Tree tree) {
        Tree result = new Tree();
        Node newRoot = mirror(tree.getRoot());
        result.setRoot(newRoot);
        return result;
    }

}
