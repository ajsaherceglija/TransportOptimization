# Transport Optimization

## Overview
The Transport Optimization project aims to improve travel efficiency between various key points in Sarajevo by utilizing a unique transportation system involving glass balls and cannons. This project employs directed weighted graphs to represent the city’s transportation network and implements algorithms to determine the shortest travel times between locations.

## Project Structure
This project consists of several tasks designed to model the transportation system and calculate optimal paths between various locations in Sarajevo. 

### Tasks
1. **Graph Representation**: Create a program that maintains a directed weighted graph based on input data, where each edge represents a route between two locations and the weight represents travel time.
   
2. **Shortest Path Algorithm**: Implement a class to solve the shortest path problem between any two nodes in the graph, covering this functionality with unit tests for various graph configurations.
   
3. **Travel Time Calculation**: Given a file (e.g., `X.txt`), compute the travel times between all specified locations. The input format should list pairs of locations and their respective travel times.
   
4. **Probabilistic Constraints**: Enhance the model to include probability weights for certain routes based on conditions like construction. These probabilities will affect travel time calculations.


## Input Format
The program accepts input files in the following formats:

### Directed Weighted Edges
```A B 10```

This indicates that the travel time from point A (Alipašino) to point B (Baščaršija) is 10 seconds.

### Travel Time Calculation
Input files for calculating travel times should list multiple edges:

```A B 10```

```B C 20```

```C A 5```


### Probability Constraints
The program can also ingest a CSV file defining probability weights:

```A, B, high constructions, 0.2```
