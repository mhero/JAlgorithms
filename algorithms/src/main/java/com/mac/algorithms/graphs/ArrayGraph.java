package com.mac.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayGraph<T> {

    private Map<T, Integer> vertices;
    private Integer[][] graph = null;
    private static int index = 0;

    public ArrayGraph() {
        vertices = new HashMap<>();
    }

    public Set<T> getVertices() {
        return vertices.keySet();
    }

    public Integer[][] getGraph() {
        return graph;
    }

    public void addVertex(T vertex) {
        if (!this.vertices.containsKey(vertex)) {
            if (this.graph != null) {
                Integer[][] newGraph = new Integer[this.graph.length + 1][this.graph.length + 1];
                this.graph = copyArray(newGraph, this.graph);
                this.graph = setColumnTo(this.graph, index, 0);
                this.graph = setRowTo(this.graph, index, 0);
            } else {
                this.graph = new Integer[1][1];
                this.graph[index][index] = 0;
            }
            vertices.put(vertex, index);
            index++;
        }
    }

    public void addVertex(T newVertex, List<T> adjacents) {
        addVertex(newVertex);
        if (adjacents != null && !adjacents.isEmpty()) {
            adjacents.stream().map((adjacent) -> {
                addVertex(adjacent);
                return adjacent;
            }).forEachOrdered((adjacent) -> {
                this.graph[this.vertices.get(newVertex)][this.vertices.get(adjacent)] = 1;
            });
        }
    }

    public void addEdge(Pair<T> edge) {
        addVertex(edge.getFirst());
        addVertex(edge.getFirst(), new ArrayList<T>(Arrays.asList(edge.getSecond())));
    }

    private Integer[][] setColumnTo(Integer[][] dest, int column, int number) {
        for (int i = 0; i < dest.length; i++) {
            dest[i][column] = number;
        }
        return dest;
    }

    private Integer[][] setRowTo(Integer[][] dest, int row, int number) {
        for (int i = 0; i < dest.length; i++) {
            dest[row][i] = number;
        }
        return dest;
    }

    private Integer[][] copyArray(Integer[][] dest, Integer[][] src) {
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src.length);
        }

        return dest;
    }
}
