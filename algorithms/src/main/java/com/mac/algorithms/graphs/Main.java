package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph<String> g = new Graph<>();

        g.addVertex("1", new ArrayList<>(Arrays.asList("2", "3", "4")));
        g.addVertex("1", new ArrayList<>(Arrays.asList("2", "3", "4", "5")));
        
        Pair<String> pair=new Pair<>("1","6");
        g.addEdge(pair);

        System.out.println(g.getVertices());
        g.printEdges(g.getEdges());
    }

}
