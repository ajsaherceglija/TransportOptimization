package org.example;

public class Node {
        private final String node;
        private final Integer time;

        Node(String node, Integer time) {
            this.node = node;
            this.time = time;
        }

    public String getNode() {
        return node;
    }

    public int getTime() {
        return time;
    }

}

