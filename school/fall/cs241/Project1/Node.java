/**
 * *************************************************************
 * file: Node.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 1
 * date last modified: 10/16/2017
 *
 * purpose: class Node creates a node object with data, leftChild, and rightChild values. 
 * Contains access and mutator methods, and methods to return height and amount of nodes in the subtree
 * with the node as the root.s
 *
 ***************************************************************
 */
package cs241.project.pkg1;

class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;

    //Method: Node
    //Purpose: calls the next constructor
    public Node() {
        this(-1); //call next constructor with a temporary data item
    }

    //Method: Node
    //Purpose: calls the next constructor with a temporary data item, and two null children
    public Node(int dataPortion) {
        this(dataPortion, null, null); //call next constructor

    }

    //Method: Node
    //Purpose: inserts data into the node and sets the children
    public Node(int dataPortion, Node newLeftChild, Node newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    //Method: getData
    //Purpose: returns data of the Node
    public int getData() {
        return data;
    }

    //Method: setData
    //Purpose: sets the private data for the node
    public void setData(int newData) {
        data = newData;
    }

    //Method: getLeftChild
    //Purpose: returns the leftChild
    public Node getLeftChild() {
        return leftChild;
    }

    //Method: setLeftChild
    //Purpose: sets the leftChild
    public void setLeftChild(Node newLeftChild) {
        leftChild = newLeftChild;
    }

    //Method: hasLeftChild
    //Purpose: returns true if leftChild is not null
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    //Method: getRightChild
    //Purpose: returns the rightChild
    public Node getRightChild() {
        return rightChild;
    }

    //Method: setRightChild
    //Purpose: sets the right child
    public void setRightChild(Node newRightChild) {
        rightChild = newRightChild;
    }

    //Method: hasRightChild
    //Purpose: returns boolean, true if node has a rightChild
    public boolean hasRightChild() {
        return rightChild != null;
    }

    //Method: getRightMost
    //Purpose: gets the rightmost descendent
    public Node getRightMost() {
        Node current = rightChild;
        while (rightChild.rightChild != null) {
            current = rightChild.rightChild;
        }
        return current;
    }

    //Method: getLeftMost
    //Purpose: returns the leftmost descendent
    public Node getLeftMost() {
        Node current = leftChild;
        while (leftChild.leftChild != null) {
            current = leftChild.leftChild;
        }
        return current;
    }

    //Method: isLeaf
    //Purpose: returns a boolean true if the node has no children
    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    //Method: getNumberOfNodes
    //purpose: returns the number of nodes in the subtree
    public int getNumberOfNodes() {
        int leftNum = 0;
        int rightNum = 0;

        if (leftChild != null) {
            leftNum = leftChild.getNumberOfNodes();
        }
        if (rightChild != null) {
            rightNum = rightChild.getNumberOfNodes();
        }

        return 1 + leftNum + rightNum;
    }

    //Method: getHeight
    //Purpose: calls getHeight by passing itself
    public int getHeight() {
        return getHeight(this);
    }

    //Method: getHeight
    //Purpose: returns the height of the subtree
    private int getHeight(Node node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
        }
        return height;
    }

    //Method: copy
    //Purpose: copies the node and its children to a new node
    public Node copy() {
        Node newRoot = new Node(data);
        if (leftChild != null) {
            newRoot.setLeftChild(leftChild.copy());
        }
        if (rightChild != null) {
            newRoot.setRightChild(rightChild.copy());
        }

        return newRoot;
    }

}
