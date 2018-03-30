/**
 * *************************************************************
 * file: BinaryTree.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 3
 * date last modified: 11/14/2017
 *
 * purpose: Creates a binary stree object with node objects. Allows inorder, postorder, and preorder
 * traversal of the tree. Also allows adding new nodes and removal of nodes. Displays a menu to the user
 * and takes in input for decisions.
 *
 ***************************************************************
 */
package cs241project3;

import java.util.*;

public class BinaryTree {

    

    private Node root;
    private int leaves;

    //Method: BinaryTree()
    //Purpose: constructor for an empty BinaryTree object
    public BinaryTree() {
        root = null;
    }

    //Method: getNumberOfNodes
    //Purpose: returns the number of nodes in the tree
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    //method: getRoot
    //purpose: returns the root node object
    public Node getRoot() {

        return root;
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
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getData() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    //method: search
    //purpose: returns a boolean, true if the value is already inside the tree, false if it is not
    public boolean search(Node localRoot, int num) {
        if(localRoot==null)
            return false;
        if (localRoot.getData() == num) {
            return true;
        } else if ((localRoot.getLeftChild() != null && search(localRoot.getLeftChild(), num))
                || (localRoot.getRightChild() != null && search(localRoot.getRightChild(), num))) {
            return true;

        } else {
            return false;
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
                insertNode(scanner.nextInt());
            } else {
                insertNode(scanner.nextInt());
            }
        } /**
         * else if(command == 'D' || command == 'd') delete();
         *
         * else if(command == 'P' || command == 'p') findPredecessor();
         *
         */
        /**
         * else if (command == 'S' || command == 's') { System.out.print("Please
         * enter the value to find the successor of: "); x = scanner.nextInt();
         * System.out.println(findSuccessor(x).getData()); }*
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
    public Node insertNode(int data) {
        Node temp = new Node(data, null, null, null);

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
            localRoot = newNode;
            return newNode;
        } else if (newNode.getData() > localRoot.getData()) {
            newNode.setParent(localRoot);
            localRoot.setRightChild(insertNode(localRoot.getRightChild(), newNode));

        } else if (newNode.getData() < localRoot.getData()) {
            newNode.setParent(localRoot);
            localRoot.setLeftChild(insertNode(localRoot.getLeftChild(), newNode));
        }

        return localRoot;
    }

    public int countLeaves() {

        return countLeaves(root);

    }

    private int countLeaves(Node r) {

        if (r == null) {
            return 0;
            
        } else if(r.getLeftChild()==null && r.getRightChild()==null){
            return 1;
        }
        return  countLeaves(r.getLeftChild()) + countLeaves(r.getRightChild());

    }

    //Method: remove
    //Purpose: removes a node from the tree
    public Node remove(Node localRoot, int data) {
        Node tempNode = new Node(data, null, null, null);
        

        if (root != null) {
            data = localRoot.getData();
            
            if (localRoot.getData() - data== 0) {
                tempNode.setData(localRoot.getData());
                localRoot = removeFromRoot(localRoot);
            } else if (localRoot.getData() - data < 0) {
                Node leftChild = localRoot.getLeftChild();
                Node subtreeRoot = remove(leftChild, data);
                localRoot.setLeftChild(subtreeRoot);
            } else {
                Node rightChild = localRoot.getRightChild();
                localRoot.setRightChild(remove(rightChild, data));

            }
        }
        return localRoot;
    }

    //Method: removeFromRoot
    //Purpse: removes node from root
    public Node removeFromRoot(Node localRoot) {
        if (localRoot.getLeftChild()!=null && localRoot.getRightChild()!=null) {
            Node leftSubtreeRoot = localRoot.getLeftChild();
            Node largestNode = findLargest(leftSubtreeRoot);
            localRoot.setData(largestNode.getData());
            localRoot.setLeftChild(removeLargest(leftSubtreeRoot));

        } else if (localRoot.getRightChild()!= null) {
            localRoot = localRoot.getRightChild();
        } else {
            localRoot = localRoot.getLeftChild();
        }

        return localRoot;
    }

    //Method: findLargest
    //Purpose: finds largest in subtree
    private Node findLargest(Node localRoot) {
        if (localRoot.getRightChild()!=null) {
            localRoot = findLargest(localRoot.getRightChild());
        }
        return localRoot;
    }

    //Method: removeLargest
    //Purpose: removes node containing largest entry in subtree
    private Node removeLargest(Node localRoot) {
        if (localRoot.getRightChild() !=null) {
            Node rightChild = localRoot.getRightChild();
            rightChild = removeLargest(rightChild);
            localRoot.setRightChild(rightChild);

        } else {
            localRoot = localRoot.getLeftChild();
        }
        return localRoot;
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
                tree.insertNode(x);
            } catch (NumberFormatException ex) {

            }
        }

        tree.display();
    }

}
