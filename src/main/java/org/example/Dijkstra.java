package org.example;

import java.io.IOException;
import java.util.*;

public class Dijkstra {

    public static Integer shortestPath(Graph graph, String source, String destination, Map<String, String> allConstraints) throws IOException {
        Map<String, Integer> times = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getTime));
        Set<String> visited = new HashSet<>();

        if (!Graph.getPlaces().contains(source) || !Graph.getPlaces().contains(destination)) {
            return -1;
        }

        times.put(source, 0);
        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            String current = priorityQueue.poll().getNode();
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<String, Integer> neighbor : graph.getGraph().getOrDefault(current, Collections.emptyMap()).entrySet()) {
                String nextNode = neighbor.getKey();
                Integer newTime = times.get(current) + neighbor.getValue();

                if (!(allConstraints.containsKey(current) && Objects.equals(allConstraints.get(current), nextNode)) &&
                        neighbor.getValue() >= 0 && (!times.containsKey(nextNode) || newTime < times.get(nextNode))) {
                    times.put(nextNode, newTime);
                    priorityQueue.add(new Node(nextNode, newTime));
                }
            }
        }

        return times.getOrDefault(destination, -1);
    }




}
