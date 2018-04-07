package com.mac.algorithms.BST;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.addNode(new Node(50));
		tree.addNode(new Node(25));
		tree.addNode(new Node(15));
		tree.addNode(new Node(17));

		Tree mirror = TreeFunctions.mirror(tree);

		System.out.println("in-order tree");
		TreeFunctions.preOrderTraverseTree(tree.getRoot());
		System.out.println("mirror in-order tree");
		TreeFunctions.preOrderTraverseTree(mirror.getRoot());

		Node findNode = tree.findNode(25);
		if (findNode != null) {
			findNode.printNode();
		}

		System.out.println(TreeFunctions.findHeight(tree.getRoot()));

	}

}
