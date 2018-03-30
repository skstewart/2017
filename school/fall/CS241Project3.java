/**
 * *************************************************************
 * file: CS241Project3.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 3
 * date last modified: 11/14/2017
 *
 * purpose: Builds a binary tree and a red-black tree. Generated 100 random integers and inserts into both trees.
 * Allows traversals, deletions, insertions, and counts the number of leaves in both trees. Serves as a comparison between
 * the two types of trees.
 *
 ***************************************************************
 */
package cs241project3;

import java.util.*;

public class CS241Project3 {

    BinaryTree bt = new BinaryTree();
    RedBlackTrees rbt = new RedBlackTrees();

    //method: displayMenu
    //purpose: displays the menu and allows user to select options
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        String nums = "";
        int option = -1;
        int input = -1;
        int input2 = -1;
        /*
        Insert a new value (ignore repetitions, values should be added to both trees)
        Delete a value (values should be deleted from both trees)
        Return a count of the leaves of both trees
        Return a listing of all values in the tree between a and b, where a and b are input by
        the user.
        An option for the user to delete the first 20 entries in the trees encountered by a
        preorder traversal if possible. Once completed, this option will automatically display
        the new height of the tree, and the count of the remaining leaves in both trees.
         */

        System.out.print("Menu:"
                + "\n1. Insert a value"
                + "\n2. Delete a value"
                + "\n3. Count of leaves in both trees"
                + "\n4. Listing of values between two given values"
                + "\n5. Delete the first 20 entries ecountered by preorder traversal"
                + "\n0. Exit");
        option = sc.nextInt();
        switch (option) {
            case 0:
                System.out.println("Thanks for using my program!");
                System.exit(0);
            case 1:
                while (input < 0 || input > 999) {
                    System.out.println("Please enter an item between 0 and 999 to insert");
                    input = sc.nextInt();
                }

                bt.insertNode(input);
                rbt.insert(input);
                System.out.println(input + " has been inserted.");

                input = -1;
                break;
            case 2:

                while (input < 0 || input > 999) {
                    System.out.println("Please enter an item to delete.");
                    input = sc.nextInt();
                }
                if (rbt.search(rbt.getRoot(), input) && bt.search(bt.getRoot(), input)) {
                    if (bt.remove(bt.getRoot(), input) != null && rbt.remove(input));

                    System.out.println(input + " has been deleted.");
                } else {
                    System.out.println(input + " cannot be deleted as it is not inside the tree.");
                }
                input = -1;
                break;
            case 3:
                //count leaves in both trees
                System.out.println("Leaves in Red-Black Tree: " + rbt.countLeaves());
                System.out.println("Leaves in Binary Tree: " + bt.countLeaves());
                break;
            case 4:

                System.out.println("Please enter two numbers separated by spaces.");
                input = sc.nextInt();
                input2 = sc.nextInt();
                System.out.print("Values between" + input + " and " + input2 + " : ");
                for (int x = input; x < input2; x++) {
                    if (bt.search(bt.getRoot(),x) == true) {
                        System.out.print(x + " ");
                    }
                }
                System.out.println();

                input = -1;
                input2 = -1;
                break;
            case 5:
                //delete the first 20 entries encountered by a preorder traversal
                for (int x = 0; x < 20; x++) {
                    //rbt.remove(rbt.getRoot(), rbt.getRoot().getData());
                    bt.removeFromRoot(bt.getRoot());
                    rbt.remove(rbt.getRoot().getData());
                }
                break;
            //case 6:
            //  System.out.println("Secret test option");
            //rbt.inOrder(rbt.getRoot());
            // break;
            default:
                System.out.println("Please select a valid option.");

                break;
        }
        displayMenu();
    }

    //method: buildTrees
    //purpose: builds the initial trees, creating an array of 100 random integers and inserting
    //the values into both trees
    public void buildTrees() {

        Random rand = new Random();
        int[] randomInts = new int[100];
        for (int x = 0; x < 100; x++) {
            randomInts[x] = rand.nextInt(999);
            rbt.insert(randomInts[x]);
            bt.insertNode(randomInts[x]);
        }
    }

    //method: main
    //purpose: creats CS241Project3 object, initiates 
    public static void main(String[] args) {

        CS241Project3 project = new CS241Project3();

        project.buildTrees();
        project.displayMenu();

        // TODO code application logic here
    }

}
