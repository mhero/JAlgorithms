package com.mac.algorithms.BST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TreeFunctions {

	public static void inOrderTraverse(Node root) {
		if (root != null) {
			inOrderTraverse(root.getLeft());
			root.printNode();
			inOrderTraverse(root.getRight());
		}
	}

	public static void preOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			focusNode.printNode();
			preOrderTraverseTree(focusNode.getLeft());
			preOrderTraverseTree(focusNode.getRight());
		}
	}

	public static void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.getLeft());
			postOrderTraverseTree(focusNode.getRight());
			focusNode.printNode();
		}
	}

	public static int findHeight(Node aNode) {
		if (aNode == null) {
			return -1;
		}

		int lefth = findHeight(aNode.getLeft());
		int righth = findHeight(aNode.getRight());

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
		Node left = mirror(node.getLeft());
		Node right = mirror(node.getRight());

		/* swap the left and right pointers */
		node.setLeft(right);
		node.setRight(left);

		return node;
	}

	public static Tree mirror(Tree tree) {
		Tree result = new Tree();
		Node newRoot = mirror(tree.getRoot());
		result.setRoot(newRoot);
		return result;
	}

	public static Integer height(Node root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
		}
	}

	public static void printLevelOrder(Node root) {
		Integer h = height(root);
		List<Integer> listOfNodes = new ArrayList<>();
		for (int i = 1; i <= h; i++)
			getGivenLevel(root, i, listOfNodes);
	}

	public static void getGivenLevel(Node node, Integer level, List<Integer> listOfNodes) {
		if (node == null)
			return;
		if (level == 1)
			listOfNodes.add(node.getValue());
		else if (level > 1) {
			getGivenLevel(node.getLeft(), level - 1, listOfNodes);
			getGivenLevel(node.getRight(), level - 1, listOfNodes);
		}
	}

	public static void findSum(Integer originalSum, Integer sum, Set<List<Integer>> result, List<Integer> currentList,
			Node node) {

		if (node == null)
			return;

		Integer nodeValue = node.getValue();
		currentList.add(nodeValue);

		if (Objects.equals(sum, nodeValue)) {
			result.add(new ArrayList<>(currentList));
		}

		// as the BST may contain negative values we have to iterate it all
		findSum(originalSum, originalSum, result, new ArrayList<>(), node.getRight());

		findSum(originalSum, originalSum, result, new ArrayList<>(), node.getLeft());

		int remaining = sum - nodeValue;
		findSum(originalSum, remaining, result, new ArrayList<>(currentList), node.getLeft());

		findSum(originalSum, remaining, result, new ArrayList<>(currentList), node.getRight());

	}

	public static void findSum(Integer sum, Node root) {
		Set<List<Integer>> result = new HashSet<>();
		findSum(sum, sum, result, new ArrayList<>(), root);
		System.out.println(result);
		System.out.println(result.size());
	}
}
