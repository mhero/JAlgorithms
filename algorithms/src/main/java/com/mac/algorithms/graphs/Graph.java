package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

    private Map<T, Set<T>> graph;

    public Graph() {
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
                this.graph.put(newNode, new HashSet<>(adjacents));

            } else {
                this.graph.get(newNode).addAll(adjacents);
            }
            adjacents.stream().filter((adjacent) -> (!this.graph.containsKey(adjacent))).forEachOrdered((adjacent) -> {
                addVertex(adjacent);
            });
        }
    }

    public void addEdge(Pair<T> edge) {

    }

    public List<T> getAdjacents(T node) {
        Set<T> adjacents = this.graph.get(node);
        return adjacents == null ? null : new ArrayList<T>(adjacents);
    }

    public List<T> getVertices() {
        return new ArrayList(graph.keySet());
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
            System.out.print("{" + edge.first + "," + edge.second + "}");
            if (i < edges.size() - 1) {
                System.out.print(",");
                i++;
            }
        }
        System.out.print("}");
    }

    public class Pair<T> {

        private T first;
        private T second;

        public Pair() {
        }

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }

    }

}
