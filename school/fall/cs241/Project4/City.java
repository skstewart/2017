/**
 * *************************************************************
 * file: City.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 4
 * date last modified: 11/27/2017
 *
 * purpose: class to create a City object, which contains a city number, two letter code,
 * city name, population, and elevation. Also contains array of roads which are neighbors of the city
 * (where one may go in the directed graph of cities).
 *
 *
 ***************************************************************
 */
package csproject4;

public class City {

    private int number;
    private String cityCode;
    private String cityName;
    private int population;
    private int elevation;
    private Road[] roads;
    int roadCount;

    //method: City()
    //purpose: constructor, initializes roadCount and roads array.
    City() {
        roads = new Road[8];

        roadCount = -1;

    }

    //method setNumber()
    //purpose: set the number of the city
    public void setNumber(int x) {
        number = x;
    }

    //method: getNumber
    //purpose: get the number of the city
    public int getNumber() {
        return number;
    }

    //method: setCityCode
    //purpose: set the two letter city code
    public void setCityCode(String x) {
        cityCode = x;

    }

    //method: getCityCode
    //purpose: get the two letter city code
    public String getCityCode() {
        return cityCode;
    }

    //method: setCityName(String x)
    //purpose: set the city name 
    public void setCityName(String x) {
        cityName = x;
    }

    //method: getCityName
    //purpose: get the city name (returns string)
    public String getCityName() {
        return cityName;
    }

    //method: setPopulation
    //purpose: sets the population size
    public void setPopulation(int x) {
        population = x;
    }

    //method: getPopulation
    //purpose: gets the population size
    public int getPopulation() {
        return population;
    }

    //method: setElevation
    //purpose: sets the elevation data int
    public void setElevation(int x) {
        elevation = x;
    }

    //method: getElevation
    //purpose: gets the elevation data
    public int getElevation() {
        return elevation;
    }

    //method: setRoad
    //purpose: sets a road (a road is an edge from this city to its neighbor)
    public void setRoad(Road r) {
        roads[++roadCount] = r;
    }

    //method: getRoad
    //purpose: gets a road
    public Road getRoad(int x) {
        return roads[x];
    }

    //method: getRoads
    //purpose: gets the roads[] array
    public Road[] getRoads() {
        return roads;
    }

    //method: getNumberOfRoads()
    //purpose: gets the number of roads/edges to neighbors
    public int getNumberOfRoads() {
        return roadCount;
    }

    //method: getDistanceTo
    //purpose: gets the distance to a city (if an edge to that city exists)
    public int getDistanceTo(int x) {
        int found = -1;
        for (int y = 0; y < roadCount; y++) {
            if (roads[y].getTo().getNumber() == x) {
                found = y;
            }
        }
        return found;
    }

    //method: toString
    //purpose: returns all data information about the city
    @Override
    public String toString() {
        return number + " " + cityCode + " " + cityName + " " + population + " "
                + elevation + " ";

    }
}
