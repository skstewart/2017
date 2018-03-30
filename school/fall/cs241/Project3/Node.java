/**
 * *************************************************************
 * file: Node.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 3
 * date last modified: 11/14/2017
 *
 * purpose: Creates a Node object containing information about the leftChild, rightChild, parent, and data for
 * the node.
 *
 ***************************************************************
 */
package cs241project3;

class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    //Method: Node
    //Purpose: calls the next constructor
    public Node(int initalData, Node initalLeft, Node initalRight, Node initalParent) {
        data = initalData;
        leftChild = initalLeft;
        rightChild = initalRight;
        parent = initalParent;
    }
    
 

    //method: getParent
    //purpose: returns the parent of the node
    public Node getParent() {
        return parent;
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

//method: setParent
  //purpose: sets the parent of the node object
    public void setParent(Node p) {
        parent = p;
    }

}
