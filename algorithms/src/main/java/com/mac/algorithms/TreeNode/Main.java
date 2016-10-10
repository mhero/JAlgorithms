package com.mac.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) {

        List<TreeNode> child = new ArrayList<>();
        child.add(new TreeNode("b", null));
        child.add(new TreeNode("c", null));

        TreeNode treeNode = new TreeNode("a", child);

        treeNode.print();
    }

}
