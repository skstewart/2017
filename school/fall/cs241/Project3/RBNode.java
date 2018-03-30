/**
 * *************************************************************
 * file: RBNode.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 3
 * date last modified: 11/14/2017
 *
 * purpose: Creates an RBNode object, a node of the redblack tree. contains data, and references
 * for leftchild, rightchild, parent, as well as information about the color
 * of the node.
 ***************************************************************
 */
package cs241project3;

class RBNode {

    private RBNode leftChild;
    private RBNode rightChild;
    private RBNode parent;  

    private int data;

    private int color;

    //method: RBNode
    //purpose: constructor for RBNode object, sets leftChild, rightChild, data, and color values
    public RBNode(int newData, RBNode left, RBNode right) {

        leftChild = left;
        rightChild = right;
        data = newData;
        color = 1;

    }

//method: getData
    //purpose: returns the data value for the RBNode object
    public int getData() {
        return data;
    }

    //method: getRightChild
    //purpose: returns the rightChild of the RBNode object
    public RBNode getRightChild() {
        return rightChild;
    }

    //method: getLeftChild
    //purpose: returns the leftChild of the RBNode object
    public RBNode getLeftChild() {
        return leftChild;
    }

    //method: getParent
    //purpose: returns the parent of the RBNode object
    public RBNode getParent() {

        return parent;
    }

    //method: getColor
    //purpose: returns the color of the RBNode object (as an int, 1 for black 0 for red)
    public int getColor() {
        return color;
    }

    //method: setData
    //purpose: assigns a given value as the data integer value
    public void setData(int x) {
        data = x;
    }

    //method: setLeftChild
    //purpose: sets the leftchild of the RBNode object
    public void setLeftChild(RBNode x) {
        leftChild = x;
    }

    //method: setRightChild
    //purpose: sets the rightChild of the RBNode object
    public void setRightChild(RBNode x) {
        rightChild = x;
    }

    //method: setColor
    //purpose: sets the color as an int value
    public void setColor(int x) {
        color = x;
    }

    
    //method: setParent
    //purpose: sets the parent of the RBNode object
    public void setParent(RBNode x) {
        parent = x;
    }

}
