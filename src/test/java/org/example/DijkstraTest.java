package org.example;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class DijkstraTest extends TestCase {

    public void testShortestPath() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 7);

        int result = Dijkstra.shortestPath(graph, "C", "A", new HashMap<>());
        assertEquals(-1, result);
    }

    public void testShortestPathWithConstraints() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 7);

        Map<String, String> constraints = new HashMap<>();
        constraints.put("A", "B");

        int result1 = Dijkstra.shortestPath(graph, "A", "C", constraints);
        assertEquals(7, result1);

    }


    public void testShortestPathWithInvalidPoint() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "Q", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 5);

        int result = Dijkstra.shortestPath(graph, "A", "Q", new HashMap<>());
        assertEquals(-1, result);
    }

    public void testShortestPathWithNodeNotPresent() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 7);

        int result = Dijkstra.shortestPath(graph, "A", "Q", new HashMap<>());
        assertEquals(-1, result);
    }


    public void testShortestPathWithNegativeWeights() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "B", -1);
        graph.addEdge("B", "C", -1);

        int result = Dijkstra.shortestPath(graph, "A", "C", new HashMap<>());
        assertEquals(-1, result);
    }


    public void testShortestPathWithMultiplePaths() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", -3);
        graph.addEdge("B", "C", 1);

        int result = Dijkstra.shortestPath(graph, "A", "C", new HashMap<>());
        assertEquals(3, result);
    }

    public void testShortestPathWithEmptyGraph() throws Exception {
        Graph graph = new Graph();
        int result = Dijkstra.shortestPath(graph, "A", "C", new HashMap<>());
        assertEquals(-1, result);
    }

    public void testShortestPathWithSingleNodeGraph() throws Exception {
        Graph graph = new Graph();
        graph.addEdge("A", "A", 0);
        int result = Dijkstra.shortestPath(graph, "A", "A", new HashMap<>());
        assertEquals(0, result);
    }
}
