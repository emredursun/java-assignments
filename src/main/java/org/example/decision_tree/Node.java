package org.example.decision_tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    private String name;
    private String question;
    private List<Edge> edges;

    public Node(String name, String question) {
        this.name = name;
        this.question = question;
        edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
