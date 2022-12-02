/*
 * Copyright (c) 2022. Do not use without permission. All Rights Reserved. Simi Ojeyomi
 */

package Lists.ObjList;

/*This class represents a doubly linked-list representation called ObjList.
This class also implements the iterable interface and creates an iterator.
The object list class has various methods that enable it to perform various
operations. This class uses object to implement linked-list
The objectList can be used to store data, very much like arrays, linked-list,
stacks, etc. The implementation of ObjList is much similar to linked-list.
An understanding of Linked List is necessary  in order to understand how this
class functions*/

import java.util.Iterator;
import java.util.NoSuchElementException;// This exception class is used in
// iterator for next method

// ObjList class implements iterable
public class ObjList implements Iterable<Object> {

    // private inner Node class. Helps to create the data structure if how
    // data is stored
    private static class Node {
        private Object data;// stores actual content of data
        private Node link;// points to the location where another data can be
        // readily stored
        private Node prev;// points to the previous location where data is
        // stored
    }

    // implementing the iterator interface which is a requirement after
    // implementing iterable
    private class linkedObjectList implements Iterator<Object> {
        private Node current = head;// current points to first node in
        // objectList
        private Node prev = null;// prev points to node before current
        private Node prev2 = null;// prev2 points to node before prev
        private boolean nextCalled = false;// boolean to make sure next() is
        // called before remove()

        @Override
        public boolean hasNext() {
            boolean status = false;

            // checks if first node is not empty, and checks if current node is
            // not at the end of list
            if (current != null && head != null) {
                status = true; // status is set to true
            }

            //if current node is not null, it returns the state of the node
            // after current and quits immediately
            else if (current != null)
                return current.link != null;

            return status;
        }

        @Override
        public Object next() throws NoSuchElementException {
            Object currentElem;// This returns the data of current element

            //Condition that takes care of when current is null
            if (current == null) {
                throw new NoSuchElementException();
            }

            currentElem = current.data;// stores the data of the current element
            prev2 = prev; // Node before previous is set to previous
            prev = current;// previous is set to current
            current = current.link;//current. to next element in objectList

            nextCalled = true;// if nextCalled is false, means link() wasn't
            // called
            return currentElem;
        }


        @Override
        public void remove() throws IllegalStateException {
            if (prev == null || !nextCalled)
                throw new IllegalStateException();

                //Makes sure that first element is removed
            else if (prev == head) {
                head = head.link;//moves head to the next position
                if (head != null)//makes sure that prev is set correctly
                    head.prev = null;
            } else //removes element at any position current is
            {
                prev2.link = current;
                prev = prev2;

                //checks if current is valid and legal before updating its previous
                if (current != null)
                    current.prev = prev2;
            }

            objCount--;//reducing the number of object present because it is removed
            nextCalled = false;//changes this to make sure next() is called properly
        }
    }

    private Node head;// tracks first element in ObjList
    private Node tail;
    private int objCount;// counts number of objects in ObjList. i.e.
    // length


    public ObjList() {
        head = tail = null;
        objCount = 0;
    }

    @Override
    public Iterator<Object> iterator() {
        return new linkedObjectList();
    }

    // appends newObject to the doubly nested list of objects being stored,
    // but just does nothing if newObject is null
    public void insertion(Object newObject) {
        Node newNode;

        if(newObject == null)
            throw new IllegalArgumentException("Object to be added, cannot be null");

        else
        {
            newNode = new Node();
            newNode.data = newObject;

            newNode.prev = tail;// Node before is set to tail

            //doubly linked-list after prev points to tail, tail points to
            // newNode
            if (tail != null)
                tail.link = newNode;
            else
                head = newNode;  // if the list is currently empty

            tail = newNode;

            objCount++;// increase length because element is added
        }
    }


    /**This method returns the number element that are present at anytime in the current objList
     *
     * @return length of objList
     */
    public int length() {
        return objCount;
    }


    /**This is an overridden method of the toString method in the object class.
     * This method simply prints all the element in the current objList object.
     * It prints each element with space between them
     *
     * @return String representation of all element in the objList
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        // starts printing from the head
        while (current != null) {
            // appends with space
            result.append(current != head ? " " : "").append(current.data);
            current = current.link;// current goes forward
        }

        return result.toString();
    }

    /**This method is the same as the toString() method, only that it prints backwards.
     * It starts from the last element in the current object, and then prints backwards,
     * till it gets to the first element.
     *
     * @return String representation of objList in reverse.
     */
    public String toStringReversal() {
        StringBuilder result = new StringBuilder();
        Node current = tail;// current starts from the tail element

        // starts printing from the tail
        while (current != null) {
            result.append(current != tail ? " " : "").append(current.data);
            current = current.prev;// current goes backwards
        }

        return result.toString();
    }

    /**
     * This method removes any element that is greater than the parameter boundary
     * from the nested list.As the list is traversed, each element is
     * compared to parameter and if it is greater than, it is removed from
     * the list, leaving all the elements in the list in the same order.
     *
     * @param boundary parameter to compare and serve as filter
     */
    public void filtration(int boundary) {
        /* local variables are used here, current is set to second element,
        while prev is set to first element*/
        Node current = head.link, prev = head;


        while (current != null) {
            if ((Integer) head.data > boundary) {// compares the first element
                head = head.link;
            }

            /*Compares every other element and removes if current element
             * is greater than the boundary*/
            else if ((Integer) current.data > boundary) {
                prev.link = current.link;
                current = current.link;
            }

            prev = current;// change prev to current
            current = current.link;// moves current to next one
        }
    }

    /**
     * This method modifies the current object list, by making the node at
     * numNodes, the new head in the list and moving all the element before
     * it to the back without changing the order.
     *
     * @param numNodes (The position at which to make the new head of the list)
     */
    public void moveToEnd(int numNodes) {
        Node current = head, prev = null, newHead;
        int i = 0;// to keep count of where the head to start, similar to
        // indexing

        // must be a valid position in objectList to change the head
        if (numNodes > 0) {
            // when we reach a position just before numNodes, we stop
            while (i < numNodes && current != null) {
                prev = current;// prev is now the node before numNodes
                current = current.link;// current is the node at numNodes
                i++;
            }

            /* check that first condition of while loop is what caused the loop
            to exit*/
            if (current != null) {
                newHead = current;// newHead of the list is set to current
                /* we detach the previous node from current since the
                previous node needs to be the new end of the list*/
                prev.link = null;
                tail.link = head;// set end of ObjList to head
                /*Changing head and tail reference to reflect modified
                objectList*/
                tail = prev;
                head = newHead;
            }
        }
    }


    /*This method modifies the current object list, by moving the
    last node to the beginning. This is the opposite of moveEnd*/
    public void moveLastToBegin() {
        //use of local variables instead of global ones
        Node current = tail, prev = tail.prev, newHead;

        /* sets the last element and the newHead and changes the pointer
         from null to the first element in the list. The actual head of the
         list is then changed newHead*/
        newHead = current;
        current.link = head;
        head = newHead;

        prev.link = null;//detaches the pointer of prev and changes it to null

    }

    /**
     * This method removes element in the list starting from x and up to y.
     * It removes X and Y inclusive. Checking begin == null prevents duplication
     * checking begins != null makes sure begin must be found
     *
     * @param x (position to begin removing)
     * @param y (position to stop removing)
     */
    public void removeFromTo(Object x, Object y) {
        //begin and end serve as placeholders to store the position of a
        // node when a certain object is found

        if(x == null || y == null)
            throw new IllegalArgumentException("Invalid object detected");

        Node current = head, prev = current, begin = null, end = null;

        while (current != null) {
            /* if it finds the position to start from, AND there are no
            duplicates of x in the list, begin stores the node position or
            the node BEFORE the node that contains object x*/
            if (current.data.equals(x) && begin == null)
                begin = prev;

            /* if it finds the position to start end, AND begin is not empty,
            which means the element to start from has been found, end
            the node that contains object y*/
            if (current.data.equals(y) && begin != null) {
                end = current;
            }

            prev = current;
            current = current.link;
        }

        // if both are not empty, which means begin and end position was found,
        // elements are removed
        if (begin != null && end != null)
            begin.link = end.link;
    }
}
