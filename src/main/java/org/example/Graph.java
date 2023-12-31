package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Graph {

    private final Map<String, Map<String, Integer>> graph;
    private static Map<String, Map<String, List<Constraint>>> constraints;

    public Graph() {
        this.graph = new HashMap<>();
        constraints = new HashMap<>();
    }

    public static void readConstraintsFromFile(String f) throws IOException {
        Scanner s = new Scanner(new File(f));
        s.nextLine();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] parts = line.split(",");

            String placeA = parts[0];
            String placeB = parts[1];
            String constraint = parts[2];
            Double probability = Double.parseDouble(parts[3]);

            constraints.computeIfAbsent(placeA, k -> new HashMap<>());

            constraints.get(placeA).computeIfAbsent(placeB, k -> new ArrayList<>())
                    .add(new Constraint(constraint, probability));
        }

    }

    public List<String> getAllPlaces() {
        List<String> allPlaces = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> entry : graph.entrySet()) {
            String source = entry.getKey();
            if (!allPlaces.contains(source))
                allPlaces.add(source);

            for (String destination : entry.getValue().keySet())
                if (!allPlaces.contains(destination))
                    allPlaces.add(destination);

        }
        Collections.sort(allPlaces);

        return allPlaces;
    }

    public Map<String, Map<String, Integer>> getGraph() {
        return graph;
    }

    public static Graph readFromFile(String f) throws IOException {
        Graph graph = new Graph();
        Scanner s = new Scanner(new File(f));

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] parts = line.split("\\s+");

            String source = parts[0];
            String destination = parts[1];
            Integer time = Integer.parseInt(parts[2]);

            if (getPlaces().contains(source) && getPlaces().contains(destination))
                graph.addEdge(source, destination, time);
            else
                graph.addEdge(source, destination, -1);

        }
        return graph;
    }

    void addEdge(String source, String destination, Integer time) {
        graph.computeIfAbsent(source, k -> new HashMap<>()).put(destination, time);

    }

    static ArrayList<String> getPlaces() throws IOException {
        ArrayList<String> places = new ArrayList<>();
        Scanner s = new Scanner(new File("places.txt"));
        s.nextLine();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] parts = line.split(",");

            String place = parts[0];

            places.add(place);
        }
        return places;
    }

    public Integer shortestPath(String source, String destination, Map<String, String> allConstraints) throws IOException {
        return Dijkstra.shortestPath(this, source, destination, allConstraints);
    }

    void saveToReport(String file) throws IOException {
        FileWriter fw = new FileWriter(file);
        List<String> allPlaces = getAllPlaces();
        Map<String, String> allConstraints = new HashMap<>();

        for (String source : allPlaces) {
            for (String destination : allPlaces) {
                if (constraints.containsKey(source) && constraints.get(source).containsKey(destination)){
                    List<Constraint> constraintList = constraints.get(source).get(destination);
                    Constraint maxProbabilityConstraint = Collections.max(constraintList,
                            Comparator.comparing(Constraint::getProbability));
                    List<String> encounteredObstacles = new ArrayList<>();

                    Double variable = Math.random();
                    if (variable <= maxProbabilityConstraint.getProbability() ) {
                        fw.write("Obstacle on path " + source + " -> " + destination
                                + ": ");
                        int count = 0;
                        for (Constraint constraint : constraintList) {
                            if (variable <= constraint.getProbability() && variable != 0 &&
                                    !encounteredObstacles.contains(constraint.getConstraint())){
                                count++;
                                if (count > 1) fw.write(" or ");
                                fw.write(constraint.getConstraint());
                                encounteredObstacles.add(constraint.getConstraint());
                            }
                        }
                        fw.write("\n");

                        if (!allConstraints.containsKey(source) && !allConstraints.containsValue(destination))
                            allConstraints.put(source, destination);
                    }
                }
            }
        }
        for (String source : allPlaces) {
            fw.write("Source " + source + ":\n");
            for (String destination : allPlaces) {
                if (!(allConstraints.containsKey(source)
                        && Objects.equals(allConstraints.get(source), destination))) {
                    Integer time = shortestPath(source, destination, allConstraints);
                    fw.write(source + " -> " + destination + ": " + time + "s\n");
                }
            }
            fw.write("\n");
        }



        fw.close();
    }


}
