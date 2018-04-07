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
					focusNode = focusNode.getLeft();
					if (focusNode == null) {
						parent.setLeft(newNode);
						return;
					}
				} else {
					focusNode = focusNode.getRight();
					if (focusNode == null) {
						parent.setRight(newNode);
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

		while (focusNode.getValue() != key) {
			parent = focusNode;

			if (key < focusNode.getValue()) {
				isItALeftChild = true;
				focusNode = focusNode.getLeft();
			} else {
				isItALeftChild = false;
				focusNode = focusNode.getRight();
			}
			if (focusNode == null) {
				return false;
			}
		}

		if (focusNode.getLeft() == null && focusNode.getRight() == null) {
			if (focusNode == root) {
				root = null;
			} else if (isItALeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		} else if (focusNode.getRight() == null) {
			if (focusNode == root) {
				root = focusNode.getLeft();
			} else if (isItALeftChild) {
				parent.setLeft(focusNode.getLeft());
			} else {
				parent.setRight(focusNode.getLeft());
			}
		} else if (focusNode.getLeft() == null) {
			if (focusNode == root) {
				root = focusNode.getRight();
			} else if (isItALeftChild) {
				parent.setLeft(focusNode.getRight());
			} else {
				parent.setRight(focusNode.getRight());
			}
		} else {
			Node replacement = getReplacementNode(focusNode);
			if (focusNode == root) {
				root = replacement;
			} else if (isItALeftChild) {
				parent.setLeft(replacement);
			} else {
				parent.setRight(replacement);
			}
			replacement.setLeft(focusNode.getLeft());
		}
		return true;
	}

	private Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		Node focusNode = replacedNode.getRight();

		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.getLeft();

		}
		if (replacement != replacedNode.getRight()) {
			replacementParent.setLeft(replacement.getRight());
			replacement.setRight(replacedNode.getRight());
		}
		return replacement;
	}

	public Node findNode(int key) {

		Node focusNode = root;

		while (!focusNode.getValue().equals(key)) {
			if (key < focusNode.getValue()) {
				focusNode = focusNode.getLeft();
			} else {
				focusNode = focusNode.getRight();
			}
			if (focusNode == null) {
				return null;
			}
		}

		return focusNode;

	}

}
