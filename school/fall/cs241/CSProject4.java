/**
 * *************************************************************
 * file: CSProject4.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 4
 * date last modified: 11/27/2017
 *
 * purpose: Creates a project object, creates a graph, initializes by inserting data from city.dat and roads.dat
 * offers a menu to the user with options to insert a road, remove a road, find the shortest path from one city
 * to another city, retrieve the information of a city, display the menu, and exit the program.
 *
 *
 *
 ***************************************************************
 */
package csproject4;

import java.io.*;
import java.util.*;

public class CSProject4 {

    private final int INFINITY = Integer.MAX_VALUE;

    //method: menu
    //purpose: displays the menu, allows input from the user to choose an option.
    //progam only closes upon choosing the exit option. The full menu is only displayed upon entering H.
    public void menu(Graph graph, CSProject4 proj) {
        System.out.println("Please select an option. ");
        String code1;
        String code2;
        int intCode;
        Scanner sc = new Scanner(System.in);

        switch (sc.next()) {
            case "Q": {
                System.out.print("City code: ");
                code1 = sc.next();
                if (graph.getCity(code1) != null) {
                    System.out.println(graph.getCity(code1).toString());
                } else {
                    System.out.println("City not found.");
                }

            }
            case "q": {
                System.out.print("City code: ");
                code1 = sc.next();
                if (graph.getCity(code1) != null) {
                    System.out.println(graph.getCity(code1).toString());
                } else {
                    System.out.println("City not found.");
                }

            }
            break;
            case "D": {
                System.out.print("City codes: ");
                sc.nextLine();
                code1 = sc.nextLine();
                String[] parts = code1.split("\\s");
                int start = graph.getCity(parts[0]).getNumber();
                int end = graph.getCity(parts[1]).getNumber();
                if (graph.cityExists(parts[0]) && graph.cityExists(parts[1])) {
                    if (graph.dijkstra(start)[end] != INFINITY) {
                        System.out.print("The minimum distance between " + graph.getCities()[start].getCityName()
                                + " and " + graph.getCities()[end].getCityName() + " is " + graph.dijkstra(start)[end]);
                        System.out.print(" through the route: " + graph.getCities()[start].getCityCode() + " ");

                        graph.getPath(15);
                        
                        System.out.println();
                    }
                } else {
                    System.out.println("Path from " + graph.getCities()[start].getCityCode()
                            + " to " + graph.getCities()[end].getCityName() + " does not exist.");
                }
            }
            break;
            case "d": {
                System.out.print("City codes: ");
                sc.nextLine();
                code1 = sc.nextLine();
                String[] parts = code1.split("\\s");
                int start = graph.getCity(parts[0]).getNumber();
                int end = graph.getCity(parts[1]).getNumber();
                if (graph.cityExists(parts[0]) && graph.cityExists(parts[1])) {
                    if (graph.dijkstra(start)[end] != INFINITY) {
                        System.out.print("The minimum distance between " + graph.getCities()[start].getCityName()
                                + " and " + graph.getCities()[end].getCityName() + " is " + graph.dijkstra(start)[end]);
                        System.out.print(" through the route: " + graph.getCities()[start].getCityCode() + " ");

                        graph.getPath(15);
                        System.out.println();
                    }
                } else {
                    System.out.println("Path from " + graph.getCities()[start].getCityCode()
                            + " to " + graph.getCities()[end].getCityName() + " does not exist.");
                }
            }
            break;
            case "I": {
                System.out.println("City codes and distance: ");
                sc.nextLine();
                code1 = sc.nextLine();
                String[] parts = code1.split("\\s");
                int dist = Integer.parseInt(parts[2]);
                if (dist > 0 && graph.cityExists(parts[0]) && graph.cityExists(parts[1])) {
                    graph.getGraph()[graph.getCity(parts[0]).getNumber()][graph.getCity(parts[1]).getNumber()] = dist;
                    System.out.println("You have inserted a road from " + graph.getCity(parts[0]).getCityName() + " "
                            + "to " + graph.getCity(parts[1]).getCityName() + " with a distance of " + dist);
                } else {
                    System.out.println("Insertion unsuccessful.");
                }
            }
            break;
            case "i": {
                System.out.println("City codes and distance: ");
                sc.nextLine();
                code1 = sc.nextLine();
                String[] parts = code1.split("\\s");
                int dist = Integer.parseInt(parts[2]);
                if (dist > 0 && graph.cityExists(parts[0]) && graph.cityExists(parts[1])) {
                    graph.getGraph()[graph.getCity(parts[0]).getNumber()][graph.getCity(parts[1]).getNumber()] = dist;
                    System.out.println("You have inserted a road from " + graph.getCity(parts[0]).getCityName() + " "
                            + "to " + graph.getCity(parts[1]).getCityName() + " with a distance of " + dist);
                } else {
                    System.out.println("Insertion unsuccessful.");
                }
            }
            break;
            case "R": {
                System.out.print("City codes: ");
                sc.nextLine();
                code1 = sc.nextLine();
                String[] parts = code1.split("\\s");
                if (graph.cityExists(parts[0]) && graph.cityExists(parts[1])) {
                    graph.getGraph()[graph.getCity(parts[0]).getNumber()][graph.getCity(parts[1]).getNumber()] = Integer.MAX_VALUE;
                    System.out.println("Road successfully removed.");
                } else {
                    System.out.println("Removal unsuccessful.");
                }
            }
            break;
            case "r": {
                System.out.print("City codes: ");
                sc.nextLine();
                code1 = sc.nextLine();
                String[] parts = code1.split("\\s");
                if (graph.cityExists(parts[0]) && graph.cityExists(parts[1])) {
                    graph.getGraph()[graph.getCity(parts[0]).getNumber()][graph.getCity(parts[1]).getNumber()] = Integer.MAX_VALUE;
                    System.out.println("Road successfully removed.");
                } else {
                    System.out.println("Removal unsuccessful.");
                }
            }
            break;
            case "H": {
                System.out.print("Q Query the city information by entering the city code."
                        + "\nD Find the minimum distance between two cities."
                        + "\nI Insert a road by entering two city codes and a distance."
                        + "\nR Remove an existing road by entering two city codes."
                        + "\nH Display this message."
                        + "\nE Exit\n");
            }
            break;
            case "h": {
                System.out.print("Q Query the city information by entering the city code."
                        + "\nD Find the minimum distance between two cities."
                        + "\nI Insert a road by entering two city codes and a distance."
                        + "\nR Remove an existing road by entering two city codes."
                        + "\nH Display this message."
                        + "\nE Exit\n");
            }
            break;
            case "E": {
                System.out.println("Thank you for using my program!");
                System.exit(0);
            }
            case "e": {
                System.out.println("Thank you for using my program!");
                System.exit(0);
            }
            case "Z": {
                //secret option for debugging purposes

            }
            break;
            default: {
                System.out.println("please enter a valid command.");
            }
            break;

        }
        proj.menu(graph, proj);
    }

    //method: main
    //purpose: static method main constructs the program, creates the graph and enters the values
    //from city.dat and road.dat
    public static void main(String[] args) throws Exception {
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        System.out.println(alphabet.indexOf("a"));
        CSProject4 proj = new CSProject4();
        Graph graph = new Graph();

        {
            try (Scanner cityIn = new Scanner(new File("city.dat")).useDelimiter(")(")) {

                for (int x = 1; x < 21; x++) {
                    if (cityIn.hasNextLine()) {

                        City temp = new City();
                        temp.setNumber(Integer.parseInt(cityIn.next().trim()));
                        temp.setCityCode(cityIn.next());
                        temp.setCityName(cityIn.next());
                        temp.setPopulation(Integer.parseInt(cityIn.next().trim()));
                        temp.setElevation(Integer.parseInt(cityIn.nextLine().trim()));
                        graph.setCity(x, temp);

                    }

                }
                cityIn.close();

            }

        }

        try (Scanner roadIn = new Scanner(new File("road.dat")).useDelimiter("\\s{2,}")) {

            while (roadIn.hasNextLine()) {

                Road tempRoad = new Road();
                tempRoad.setFrom(graph.getCity(Integer.parseInt(roadIn.next().trim())));
                tempRoad.setTo(graph.getCity(Integer.parseInt(roadIn.next().trim())));
                tempRoad.setDistance(Integer.parseInt(roadIn.next().trim()));
                graph.getGraph()[tempRoad.getFrom().getNumber()][tempRoad.getTo().getNumber()] = tempRoad.getDistance();
                graph.getCity(tempRoad.getFrom().getNumber()).setRoad(tempRoad);

            }
            roadIn.close();
        }
        proj.menu(graph, proj);
    }
}
