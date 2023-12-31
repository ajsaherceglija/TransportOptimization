package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph1 = Graph.readFromFile("all_places_a.txt");
        Graph graph2 = Graph.readFromFile("all_places_b.txt");
        Graph graph3 = Graph.readFromFile("complex.txt");
        Graph graph4 = Graph.readFromFile("simple.txt");
        Graph graph5 = Graph.readFromFile("five_places.txt");
        Graph graph6 = Graph.readFromFile("ten_places.txt");

        Graph.readConstraintsFromFile("constraints.txt");


        graph1.saveToReport("graph1.txt");
        graph2.saveToReport("graph2.txt");
        graph3.saveToReport("graph3.txt");
        graph4.saveToReport("graph4.txt");
        graph5.saveToReport("graph5.txt");
        graph6.saveToReport("graph6.txt");

    }

}