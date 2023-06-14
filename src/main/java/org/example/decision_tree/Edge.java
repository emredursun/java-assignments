package org.example.decision_tree;


class Edge {
    private String answer;
    private Node destination;

    public Edge(String answer, Node destination) {
        this.answer = answer;
        this.destination = destination;
    }

    public String getAnswer() {
        return answer;
    }

    public Node getDestination() {
        return destination;
    }
}