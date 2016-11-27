package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph<String>();

        g.addVertex("1", new ArrayList<>(Arrays.asList("2", "3", "4")));
        System.out.println(g.getAdjacents("1"));

        g.addVertex("1", new ArrayList<>(Arrays.asList("2", "3", "4", "5")));
        System.out.println(g.getAdjacents("1"));

        System.out.println(g.getVertices());
        g.printEdges(g.getEdges());
    }

}
