package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph1 = Graph.readFromFile("input/all_places_a.txt");
        Graph graph2 = Graph.readFromFile("input/all_places_b.txt");
        Graph graph3 = Graph.readFromFile("input/complex.txt");
        Graph graph4 = Graph.readFromFile("input/simple.txt");
        Graph graph5 = Graph.readFromFile("input/five_places.txt");
        Graph graph6 = Graph.readFromFile("input/ten_places.txt");

        Graph.readConstraintsFromFile("input/constraints.txt");


        graph1.saveToReport("reports/graph1.txt");
        graph2.saveToReport("reports/graph2.txt");
        graph3.saveToReport("reports/graph3.txt");
        graph4.saveToReport("reports/graph4.txt");
        graph5.saveToReport("reports/graph5.txt");
        graph6.saveToReport("reports/graph6.txt");

    }

}