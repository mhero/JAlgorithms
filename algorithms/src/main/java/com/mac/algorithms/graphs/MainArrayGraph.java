package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class MainArrayGraph {

    public static void main(String[] args) {
        ArrayGraph<String> g = new ArrayGraph();
        g.addVertex("a");
        g.addVertex("a", new ArrayList<String>(Arrays.asList("b", "c")));
        g.addVertex("c", new ArrayList<String>(Arrays.asList("c")));

        System.out.println(Arrays.deepToString(g.getGraph()));
        System.out.println(g.getVertices());
    }

}
