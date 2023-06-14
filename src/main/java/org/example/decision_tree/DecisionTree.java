package org.example.decision_tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecisionTree {
    private List<Node> nodes;
    private Node currentNode;

    public DecisionTree(String filename) throws IOException {
        nodes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length == 2) {
                nodes.add(new Node(parts[0], parts[1]));
            } else if (parts.length == 3) {
                Node origin = getNode(parts[0]);
                Node destination = getNode(parts[1]);
                origin.addEdge(new Edge(parts[2], destination));
            }
        }
        br.close();
        currentNode = nodes.get(0);
    }

    private Node getNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        Node node = new Node(name, "");
        nodes.add(node);
        return node;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(currentNode.getQuestion());
            for (Edge edge : currentNode.getEdges()) {
                System.out.println("- " + edge.getAnswer());
            }
            String answer = scanner.nextLine();
            boolean found = false;
            for (Edge edge : currentNode.getEdges()) {
                if (edge.getAnswer().equalsIgnoreCase(answer)) {
                    currentNode = edge.getDestination();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid answer, please try again.");
            }
            if (currentNode.getEdges().size() == 0) {
                System.out.println("Answer: " + currentNode.getQuestion());
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        DecisionTree tree = new DecisionTree("filename.txt");
        tree.start();
    }
}

