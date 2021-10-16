package com.dsa.undirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {

    private class Node{
        private String value;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, ArrayList<Edge>> adjacency = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.put(label, node);
        adjacency.put(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
    }
}
