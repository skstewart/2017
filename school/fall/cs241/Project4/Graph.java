/**
 * *************************************************************
 * file: Road.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 4
 * date last modified: 11/27/2017
 *
 * purpose: Creates a graph, which contains distances from start city (row) to end city (column).
 * Contains method to find a shortest distance path from one city to another using Dijkstra's algorithm.
 *
 *
 *
 ***************************************************************
 */
package csproject4;

import java.util.*;

public class Graph {

    private int[] parent;
    private int[][] theGraph;
    private City[] cities;
    private int[] distance;
    private City[] previous;
    private final int INFINITY = Integer.MAX_VALUE;

    //method: Graph()
    //purpose: constructor; initializes arrays, values, and fills the arrays
    Graph() {

        theGraph = new int[21][21];
        for (int[] row : theGraph) {
            Arrays.fill(row, INFINITY);
        }
        cities = new City[21];
        distance = new int[21];
        Arrays.fill(distance, INFINITY);
        previous = new City[21];

        parent = new int[21];

    }

    //method: getParents
    //purpose: gets the parent array
    public int[] getParents() {
        return parent;
    }

    //method: getGraph
    //returns theGraph[][]
    public int[][] getGraph() {
        return theGraph;
    }

    //method: setCity
    //sets a city into the cities[] array
    public void setCity(int x, City city) {
        cities[x] = city;
    }

    //method: getCity
    //returns the city using int
    public City getCity(int x) {
        return cities[x];
    }

    //method: getCity
    //purpose: retrieves a city, finding it with its two letter city code
    public City getCity(String code) {
        int cityToReturn = 0;
        for (int z = 1; z < 21; z++) {
            if (code == null ? cities[z].getCityCode() == null : code.equals(cities[z].getCityCode())) {
                cityToReturn = z;
                break;
            }
        }
        if (cityToReturn == 0) {
            return null;
        } else {
            return cities[cityToReturn];
        }
    }

    //method: cityExists
    //purpose: makes sure a city with a given city code exists
    public boolean cityExists(String code) {
        boolean exists = false;
        for (int z = 1; z < 21; z++) {
            if (code == null ? cities[z].getCityCode() == null : code.equals(cities[z].getCityCode())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    //method: getCityCode
    //purpose: returns the two letter code for a city retrieved using city number
    public String getCityCode(int x) {
        return cities[x].getCityCode();
    }

    //method: setRoad
    //purpose: inserts a road into the graph, and creates road object and inserts into
    //array of roads inside City object
    public void setRoad(int cityNumFrom, int cityNumTo, int distance) {
        theGraph[cityNumFrom][cityNumTo] = distance;
        Road road = new Road();
        road.setDistance(distance);
        road.setTo(cities[cityNumTo]);
        road.setFrom(cities[cityNumFrom]);
        cities[cityNumFrom].setRoad(road);
    }

    //method: getCities
    //purpose: returns the cities[] array
    public City[] getCities() {
        return cities;
    }

    //method: dijkstra
    //purpose: finds the shortest distance to all cities from a source city using dijkstra's algorithm.
    //stores the distances in an array, as well as the parents of each city (the path to get to each one)
    public int[] dijkstra(int src) {

        boolean[] visited = new boolean[21];

        for (int i = 1; i < 20; i++) {

            parent[i] = -1;

            distance[i] = INFINITY;

            visited[i] = false;

        }

        // Distance of source vertex from itself is always 0
        distance[src] = 0;

        for (int count = 1; count < 20; count++) {
            int u = minDistance(distance, visited);

            visited[u] = true;

            for (int v = 1; v < 20; v++) {
                if (!visited[v] && theGraph[u][v] != INFINITY && distance[u] + theGraph[u][v] < distance[v]) {

                    parent[v] = u;

                    distance[v] = distance[u] + theGraph[u][v];

                }
            }

        }

        return distance;
    }

    //method: minDistance
    //purpose: finds the index of the vertex with the smallest distance 
    int minDistance(int[] dist, boolean[] visited) {

        int min = INFINITY;
        int minIndex = -1;

        for (int v = 1; v < 20; v++) {

            if (visited[v] == false && dist[v] <= min) {
                min = distance[v];
                minIndex = v;
            }

        }

        return minIndex;

    }

    //method: getPath
    //purpose: prints the path of the current usage of dijkstra() (ie, from the source currently
    //most recently used by the dijkstra method) to the given vertex. Stops upon reaching a -1.
    public void getPath(int j) {

        // Base Case : If j is source
        if (parent[j] == -1) {
            return;
        }

        getPath(parent[j]);

        System.out.print(cities[j].getCityCode() + " ");

    }
}
