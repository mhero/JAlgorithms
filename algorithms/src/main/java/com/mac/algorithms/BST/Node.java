package com.mac.algorithms.BST;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Node implements Comparable<Node> {

	private Integer value;
	private Node left;
	private Node right;

	public Node(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.value, o.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}

		Node rhs = (Node) obj;
		return new EqualsBuilder().append(this.value, rhs.getValue()).isEquals();
	}

	public void printNode() {
		System.out.println("key: " + this.value);
	}
}
