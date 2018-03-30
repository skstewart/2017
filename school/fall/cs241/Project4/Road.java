/**
 * *************************************************************
 * file: Road.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 4
 * date last modified: 11/27/2017
 *
 * purpose: creates a Road object, which is a directed edge from one city vertex to another.
 * Contains distance, where the road goes to, and where the road is from.
 *
 *
 *
 ***************************************************************
 */
package csproject4;

public class Road {

    private int distance;
    private City to;
    private City from;

    //method: Road()
    //purpose: constructor, initializes values
    Road() {
        distance = Integer.MAX_VALUE;
        to = null;
        from = null;

    }

    //method: setDistance
    //purpose: sets the distance
    public void setDistance(int x) {
        distance = x;
    }

    //method: getDistance
    //purpose: gets the distance from a city to a city
    public int getDistance() {
        return distance;
    }

    //method: setTo
    //purpose: sets where the road goes
    public void setTo(City x) {
        to = x;
    }

    //method: getTo
    //purpose: gets where the road goes
    public City getTo() {
        return to;
    }

    //method: setfrom
    //purpose: sets where the road starts
    public void setFrom(City x) {
        from = x;
    }

    //method: getFrom
    //purpose: gets where the road starts
    public City getFrom() {

        return from;
    }

}
