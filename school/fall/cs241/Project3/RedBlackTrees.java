/**
 * *************************************************************
 * file: RedBlackTrees.java
 * author: Shayna Stewart
 * class: CS 241
 *
 * assignment: program 3
 * date last modified: 11/14/2017
 *
 * purpose: Builds a red-black tree object, allows inorder traversal, insertion, removal, and rotations of nodes
 *
 ***************************************************************
 */
package cs241project3;

import java.util.*;

public class RedBlackTrees {

    private RBNode current;
    private RBNode parent;
    private RBNode grandParent;
    private RBNode greatGrandParent;
    private RBNode initialEmptyNode;
    private static RBNode nullNode;
    private static final int BLACK = 1;
    private static final int RED = 0;
    
    //method: main
    //purpose: initializes nullNode, which avoids nullpointers 
    static {

        nullNode = new RBNode(0, null, null);
        nullNode.setLeftChild(nullNode);
        nullNode.setRightChild(nullNode);

    }


    
    //method: RBTree
    //purpose: constructor
    RedBlackTrees() {

        initialEmptyNode = new RBNode(-1, nullNode, nullNode);

    }

    //method: getRoot
    //purpose: returns the root note
    public RBNode getRoot() {
        if (initialEmptyNode.getRightChild() != nullNode) {
            return initialEmptyNode.getRightChild();
        } else {
            return nullNode;
        }
    }
    
    //method: inOrder
    //purpose: traverses inorder
    public void inOrder(RBNode localRoot) {

        if (localRoot != nullNode) {

            inOrder(localRoot.getLeftChild());

            System.out.print(localRoot.getData() + " ");

            inOrder(localRoot.getRightChild());

        }

    }

    //method: insert
    //purpose: inserts a value into the true (not allowing duplicates)
    public void insert(int item) {
        current = parent = grandParent = nullNode;
        nullNode.setData(item);
        while (current.getData() != item) {

            greatGrandParent = grandParent;
            grandParent = parent;
            parent = current;
            if (item < current.getData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }

            if (current.getLeftChild().getColor() == RED && current.getRightChild().getColor() == RED) {
                initiateRotation(item);
            }

        }

        if (current.getData() != item) {
            return;
        }
        
        if (item < parent.getData()) {
            parent.setLeftChild(current);
        } else {
            parent.setRightChild(current);
        }

        initiateRotation(item);

    }

//method: initiateRotation
    //purpose: helps rotate/find which way to rotate
    private void initiateRotation(int item) {

        current.setColor(RED);
        if (current.getLeftChild() != nullNode) {
            current.getLeftChild().setColor(BLACK);
        }
        if (current.getRightChild() != nullNode) {
            current.getRightChild().setColor(BLACK);
        }

        if (parent.getColor() == RED) {
            grandParent.setColor(RED);

            if ((item < grandParent.getData()) && !(item < parent.getData())
                    || !(item < grandParent.getData()) && (item < parent.getData())) {

                {
                    current = rotate(item, grandParent);
                }
                current.setColor(BLACK);
                current = rotate(item, greatGrandParent);

            }
            initialEmptyNode.getRightChild().setColor(BLACK);

        }
    }
    //method: rotate
    //purpose: performs necessary rotations

    private RBNode rotate(int item, RBNode parent) {
        RBNode temp = nullNode;
        if (item < parent.getData()) {
            if (item < parent.getLeftChild().getData()) {
                temp = rotateRight(parent.getLeftChild());
            } else {
                temp = rotateLeft(parent.getLeftChild());
            }

            parent.setLeftChild(temp);
            return parent.getLeftChild();
        } else {
            if (item < parent.getRightChild().getData()) {
                temp = rotateRight(parent.getRightChild());
            } else {
                temp = rotateLeft(parent.getRightChild());
            }

            parent.setRightChild(temp);
            return parent.getRightChild();

        }

    }

    //method: rotateRight
    //purpose: rotates node with its left child
    private RBNode rotateRight(RBNode n) {

        RBNode c = n.getLeftChild();

        n.setLeftChild(c.getRightChild());

        c.setRightChild(n);

        return c;

    }

    //method: rotateLeft
    //purpose: rotate node with its right child (right child goes up & left)
    private RBNode rotateLeft(RBNode n) {

        RBNode c = n.getRightChild();

        n.setRightChild(c.getLeftChild());

        c.setLeftChild(n);

        return c;

    }

    public boolean remove(int data) {
        if (search(initialEmptyNode.getRightChild(), data) != true) {
            return false;
        } else {
            return remove(initialEmptyNode.getRightChild(), data);

        }

    }
    //method: remove
    //purpose: removes from tree
    private boolean remove(RBNode localRoot, int data) {
        boolean removed = false;
        current = greatGrandParent = grandParent = parent;
        //find the node w/ the value
        while (current.getData() != data) {
            greatGrandParent = grandParent;
            grandParent = parent;
            parent = current;
            if (data < current.getData()) {
                current = current.getLeftChild();
            } else if (data > current.getData()) {
                current = current.getRightChild();
            }
        }

        RBNode lc = current.getLeftChild();
        RBNode rc = current.getRightChild();

        parent.setRightChild(lc);
        RBNode farRight = lc.getRightChild();
        while (farRight != nullNode) {
            farRight = farRight.getRightChild();
        }
        farRight.setRightChild(rc);

        initiateRotation(lc.getData());

        return removed;

    }

    //method: countLeaves
    //purpose: calls the private countLeaves
    public int countLeaves() {

        return countLeaves(initialEmptyNode.getRightChild());

    }

    //method: countLeaves
    //private method counts leaves in tree (nodes with null children)
    private int countLeaves(RBNode localRoot) {

        if (localRoot == nullNode) {
            return 0;

        } else if (localRoot.getLeftChild() == nullNode && localRoot.getRightChild() == nullNode) {
            return 1;
        }
        return countLeaves(localRoot.getLeftChild()) + countLeaves(localRoot.getRightChild());

    }

    //method: search
    //purpose: searches for a value and returns a boolean true if it is found false if not
    public boolean search(RBNode localRoot, int value) {

        boolean found = false;

        while ((localRoot != nullNode) && found == false) {

            if (value < localRoot.getData()) {
                localRoot = localRoot.getLeftChild();
            } else if (value > localRoot.getData()) {
                localRoot = localRoot.getRightChild();
            } else {

                found = true;

break;
            }

            found = search(localRoot, value);
        }

        return found;

    }

  
    
    
}
