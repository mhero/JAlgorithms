package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class MainSimpleGraph {

    public static void main(String[] args) {
        SimpleGraph<String> g = new SimpleGraph<>();

        g.addVertex("1", new ArrayList<>(Arrays.asList("2", "3", "4", "5")));
        g.addEdge(new Pair<>("1", "6"));
        g.addEdge(new Pair<>("7", "6"));
        g.addEdge(new Pair<>("7", "8"));

        System.out.println(g.getVertices());
        g.printEdges(g.getEdges());
    }

}
