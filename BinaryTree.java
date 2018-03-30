/**
 * *************************************************************
 * file: BinaryTree.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 1
 * date last modified: 10/15/2017
 *
 * purpose: Creates a binary tree object with node objects. Allows inorder, postorder, and preorder
 * traversal of the tree. Also allows adding new nodes and removal of nodes. Displays a menu to the user 
 * and takes in input for decisions.
 *
 ***************************************************************
 */
package cs241.project.pkg1;

import java.util.*;
//import StackAndQueuePackage.*;

public class BinaryTree {

    private Node root;

    //Method: BinaryTree()
    //Purpose: constructor for an empty BinaryTree object
    public BinaryTree() {
        root = null;
    }

    //Method: newNode()
    //Purpose: creates a new node object
    private Node newNode(int data) {
        Node newNode = new Node();    // make new node
        newNode.setData(data);           // insert data
        return newNode;
    }

    //Method: getHeight
    //Purpose: returns the height of the tree
    public int getHeight() {
        return root.getHeight();
    }

    //Method: getNumberOfNodes
    //Purpose: returns the number of nodes in the tree
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    //Method: findSuccessor
    //Purpose: finds the successor to the node with a given data value
    /**
     * public Node findSuccessor(int key) { Node tempNode = find(key);
     *
     * if (tempNode == null) { return tempNode; }
     *
     * if (tempNode.getRightChild() != null) { return
     * (tempNode.getRightChild().getLeftMost()); }
     *
     * while (null != node.parent) {
     *
     * tempNode = node.parent; }
     *
     * return node.getLeftChild();
    }*
     */
    //Method: find
    //Purpose: finds the node with a given data value
    private Node find(int key) {
        Node current = root;
        while (current.getData() != key) {
            if (key < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) // if no child,
            {
                return null;                 // didn't find it
            }
        }
        return current;                    // found it
    }

    //Method: getRootData
    //Purpose: returns the root's data
    public int getRootData() {
        int rootData = -1;

        if (root != null) {
            rootData = root.getData();
        }
        return rootData;

    }

    //Method: boolean isEmpty
    //returns a boolean, true if the root is empty (and thus the tree) and false if it is not empty
    public boolean isEmpty() {
        return root == null;
    }

    //Method: clear
    //purpose: deletes the root and all other nodes in the tree with it
    public void clear() {
        root = null;
    }

    //Method: preOrder
    //Purpose: recursively traverses the tree in preOrder order
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getData() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    //Method: inOrder
    //Purpose: recursively traversees the tree in inOrder order
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    //Method: postOrder
    //purpose: recursively traverses the tree in postOrder order
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getData() + " ");
        }
    }

    //Method: command
    //Purpose: takes in a command from a user and acts based on it
    public void command() {
        System.out.println("Command?");
        Scanner scanner = new Scanner(System.in);
        char command = scanner.next().charAt(0);
        Node tempNode = null;
        int x;

        if (command == 'I' || command == 'i') {

            if (tempNode == null) {
                System.out.print("Please enter a number to insert");
                tempNode = new Node(scanner.nextInt());
            }
            insertNode(root, tempNode);
        } /**
         * else if(command == 'D' || command == 'd') delete();
         *
         * else if(command == 'P' || command == 'p') findPredecessor();
         *
         */
        /**
         * else if (command == 'S' || command == 's') { System.out.print("Please
         * enter the value to find the successor of: "); x = scanner.nextInt();
         * System.out.println(findSuccessor(x).getData());
        }*
         */
        else if (command == 'T' || command == 't') {
            Scanner sc = new Scanner(System.in);
            System.out.println("1 for Preorder, 2 for Inorder, 3 for Postorder: ");
            traverse(sc.nextInt());
        } else if (command == 'E' || command == 'e') {
            System.out.println("Thanks for using my program!");
            System.exit(0);
        } else if (command == 'H' || command == 'h') {
            displayMenu();
        } else {
            System.out.println("Please enter a valid command.");
            command();
        }
        command();
    }

    //Method: displayMenu
    //Purpose: displays a menu to the user, then calls the command method
    public void displayMenu() {
        System.out.println("Menu:\n"
                + " I Insert a value\n"
                + " D Delete a value\n"
                + " P Find predecessor\n"
                + " S Find successor\n"
                + " T Traverse tree\n"
                + " E Exit the program\n"
                + " H Display this message");
        command();
    }

    //Method: traverse
    //purpose: to call the individual traversal method based on chosen option 
    public void traverse(int traverseType) {

        switch (traverseType) {
            case 1: {
                System.out.print("Preorder traversal: ");
                preOrder(root);
                System.out.println();
                break;
            }
            case 2: {
                System.out.print("Inorder traversal:  ");
                inOrder(root);
                System.out.println();
                break;
            }
            case 3: {
                System.out.print("Postorder traversal: ");
                postOrder(root);
                System.out.println();
                break;
            }
        }

    }

    //Method: insertNode
    //Purpose: creates a temporary node and inserts it into the root if it is null
    //otherwise calls a second insertNode method
    private Node insertNode(BinaryTree tree, int data) {
        Node temp = new Node(data);

        if (root == null) {
            root = temp;
            return root;
        } else {
            return insertNode(root, temp);
        }
    }

    //Method: insertNode(Node localRoot, Node newNode)
    //Purpose: finds and places the new node to be inserted
    private Node insertNode(Node localRoot, Node newNode) {

        if (localRoot == null) {
            return newNode;
        } else if (newNode.getData() > localRoot.getData()) {
            localRoot.setRightChild(insertNode(localRoot.getRightChild(), newNode));
        } else if (newNode.getData() < localRoot.getData()) {
            localRoot.setLeftChild(insertNode(localRoot.getLeftChild(), newNode));
        }

        return localRoot;
    }

    //Method: remove
    //Purpose: removes a node from the tree
    private Node remove(Node rootNode, int data) {
        Node tempNode = new Node();
        if (root == null) {
            System.out.println("Element is not in the tree");
            return null;
        }

        if (root != null) {
            data = rootNode.getData();
            int comparison = rootNode.getData() - data;
            if (comparison == 0) {
                tempNode.setData(rootNode.getData());
                rootNode = removeFromRoot(rootNode);
            } else if (comparison < 0) {
                Node leftChild = rootNode.getLeftChild();
                Node subtreeRoot = remove(leftChild, data);
                rootNode.setLeftChild(subtreeRoot);
            } else {
                Node rightChild = rootNode.getRightChild();
                rootNode.setRightChild(remove(rightChild, data));

            }
        }
        return rootNode;
    }

    //Method: removeFromRoot
    //Purpse: removes node from root
    private Node removeFromRoot(Node rootNode) {
        if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
            Node leftSubtreeRoot = rootNode.getLeftChild();
            Node largestNode = findLargest(leftSubtreeRoot);
            rootNode.setData(largestNode.getData());
            rootNode.setLeftChild(removeLargest(leftSubtreeRoot));

        } else if (rootNode.hasRightChild()) {
            rootNode = rootNode.getRightChild();
        } else {
            rootNode = rootNode.getLeftChild();
        }

        return rootNode;
    }

    //Method: findLargest
    //Purpose: finds largest in subtree
    private Node findLargest(Node rootNode) {
        if (rootNode.hasRightChild()) {
            rootNode = findLargest(rootNode.getRightChild());
        }
        return rootNode;
    }

    //Method: removeLargest
    //Purpose: removes node containing largest entry in subtree
    private Node removeLargest(Node rootNode) {
        if (rootNode.hasRightChild()) {
            Node rightChild = rootNode.getRightChild();
            rightChild = removeLargest(rightChild);
            rootNode.setRightChild(rightChild);

        } else {
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }

    //method: display
    //Purpose: displays all traversals of the tree
    public void display() {
        traverse(1);
        traverse(2);
        traverse(3);
        command();
    }

    //Method: main
    //Purpose: constructs the tree object then displays the traversals
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.print("Please enter values separated by spaces.");

        String lines = scanner.nextLine();

        String[] strs = lines.trim().split("\\s+");

        for (String str : strs) {
            try {
                int x = Integer.parseInt(str);
                tree.insertNode(tree, x);
            } catch (NumberFormatException ex) {

            }
        }

        tree.display();
    }

}
