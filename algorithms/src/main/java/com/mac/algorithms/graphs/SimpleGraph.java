package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGraph<T> {

    private Map<T, Set<T>> graph;

    public SimpleGraph() {
        this.graph = new HashMap<>();
    }

    public void addVertex(T newNode) {
        this.graph.put(newNode, null);
    }

    public void addVertex(T newNode, List<T> adjacents) {
        if (adjacents == null || adjacents.isEmpty()) {
            addVertex(newNode);
        } else {
            if (this.graph.get(newNode) == null) {
                this.graph.put(newNode, new HashSet<T>(adjacents));

            } else {
                this.graph.get(newNode).addAll(adjacents);
            }
            adjacents.stream().filter((adjacent) -> (!this.graph.containsKey(adjacent))).forEachOrdered((adjacent) -> {
                addVertex(adjacent);
            });
        }
    }

    public void addEdge(Pair<T> edge) {
        if (edge.getSecond() == null) {
            addVertex(edge.getFirst());
        } else {
            addVertex(edge.getFirst(), new ArrayList<T>(Arrays.asList(edge.getSecond())));
        }
    }

    public List<T> getAdjacents(T node) {
        Set<T> adjacents = this.graph.get(node);
        return adjacents == null ? null : new ArrayList<T>(adjacents);
    }

    public List<T> getVertices() {
        return new ArrayList(graph.keySet());
    }

    public int getOrder() {
        return getVertices().size();
    }

    public int getSize() {
        return getEdges().size();
    }

    public List<Pair<T>> getEdges() {
        List<Pair<T>> edges = new ArrayList<>();
        this.graph.entrySet().stream().filter((vertex) -> (vertex.getValue() != null)).forEachOrdered((vertex) -> {
            vertex.getValue().forEach((adjacent) -> {
                edges.add(new Pair<T>(vertex.getKey(), adjacent));
            });
        });
        return edges;

    }

    public void printEdges(List<Pair<T>> edges) {
        System.out.print("{");
        int i = 0;
        for (Pair edge : edges) {
            System.out.print("{" + edge.getFirst() + "," + edge.getSecond() + "}");
            if (i < edges.size() - 1) {
                System.out.print(",");
                i++;
            }
        }
        System.out.print("}");
    }

}
