/*
 * Copyright (c) 2022. Do not use without permission. All Rights Reserved. Simi Ojeyomi
 */

/*This class linkedList, is a generic class that stores data using
 * nodes. Any instance of this class will have a head and a tail, which are
 * node objects. It will also have variable to count element called elemCount.
 * Head will be a reference to the first node that is created, while tail
 * will be a reference to the last node created.
 * Head will be a final reference to a null object, as this employs the
 * dummyHeadNode strategy. elemCount will also represent the size as it
 * will keep track of current elements in the linkedList Object.
 * Fields in this class have protected access modifier
 * in order for the child class to access and modify
 * based on the operations it needs to do. Protected access modifier is used for fields
 * because of the use of inheritance for this project structure*/

package Lists.LinkedList;
import java.lang.IndexOutOfBoundsException;

public class LinkedList <T extends Comparable<T>> implements
        Comparable<LinkedList<T>>{
    protected Node head;//reference to first element in the object list
    protected Node tail;//reference to last element in the object list
    protected int elemCount;// keeps track of size or number of elements

    /**
     * This inner class represents a linked list node. This node class will
     * contain value and link. Value could be of any data type and would
     * contain information to be stored. Link will be a node type
     * that points to the next node in the linked list. elemCount will
     * help keep track of the current size of the linked list whenever a node
     * is created or a protected access modifier because inheritance
     * will be used and the child class needs to access node to function.
     */
    protected class Node {
        protected T value;// keeps track of data to be stored
        protected Node link;// points to the next node in the list

        /**
         * Default Constructor which sets value and link to null
         */
        public Node() {
            value = null;// value & link are set to null
            link = null;//
        }

        /**
         * Constructor that initializes the value in a node with a given value
         *
         * @param value (value to initialize node with)
         */
        public Node(T value) {
            this.value = value;// passes parameter value into this.value
            link = null;
        }
    }

    /**
     * Default Constructor for the LinkedList. This initializes head
     * and tail to be null. Also sets the element count to be zero because
     * nothing should be in the current object list
     */
    public LinkedList() {
        head = new Node();// To start, the reference for head will be null
        tail = head;// tail will also be null
        elemCount = 0;
    }

    /**
     * This method adds a new element called newValue to the linked list.
     * newValue is added to the end of the list only without regards for
     * other elements in the list current object. There is no specific
     * order to adding, just that a new element is added to the end of the
     * linked list.
     *
     * @param newValue (Value to be added to the linked list)
     */
    public void insertion(T newValue) {
        // checking if newValue is null and throwing an exception
        if (newValue == null) {
            throw new IllegalArgumentException("null values cannot be added");
        }

        Node temp = new Node(newValue);// creating a new Node to be added

        // if statement to check if list is empty
        if (elemCount == 0) {// if num of element is 0 & nothing has been added
            head.link = temp;// sets head to the temp, which would become
            //the first node in the linked list
        } else
            tail.link = temp;// if list is not empty, we set the tail link
        // to point to the new node created

        tail = temp;// new node becomes the tail or last element in linked list
        elemCount++;// after adding new node, number of node increases
    }

    /**
     * This method keeps track of the number of nodes that exist and is made.
     * This way, we can easily keep track of how many element is stored and
     * can easily access it. In a way, it returns the length of the current
     * linkedList object
     *
     * @return number of nodes that exist in the current linkedList
     * object
     */
    public int length() {
        return elemCount;//returns the number of element in linked list which
        //is the size
    }

    /**
     * This method returns the string representation of the current
     * linkedList object. This is an overridden method of the
     * Object class toString method. So for any data type, the
     * String representation will always be printed. Elements are also
     * printed with space in between them
     *
     * @return String representation of current object
     */
    @Override
    public String toString() {
        StringBuilder printList = new StringBuilder();// set to always print
        // empty string
        Node current = head.link;// Node object to keep track of node position
        //at any time if traversing

        /* the while loop below traverses the current object */
        while (current != tail.link) {// check if is not at end yet

            /*
             * if it is at the last element, it prints without space, else it
             * adds space after printing each element
             */
            if (current == tail) {// checks if it is at last element
                printList.append(current.value);// updates printList
            } else
                printList.append(current.value).append(" ");

            current = current.link;// current points to next element
        }

        return printList.toString();
    }

    /**
     * This method removes all values from the current object list. Remember
     * that head itself is final, so we cannot modify that. We simply just
     * modify its link This is done by changing the reference of head.link
     * from the pointing to the first node, to the tail reference
     * and changing the tail reference from pointing to the last element, to
     * pointing directly to head. Also,since length is tracked by the number
     * of nodes present, it is necessary to reset elemCount
     * (which keeps track of length) back to zero
     * since all the nodes that were formerly in between head and tail
     * have been de-referenced.
     */
    public void clear() {
        tail = head;// changes the tail reference to point directly to head
        head.link = tail;// the head links points to tail
        elemCount = 0;// the length of the linkedList object is reset
    }

    /**
     * This method returns the number of objects being stored in data list
     * that is the same as the parameter value. It uses compareTo() to check
     * if values are the same. This method loops through and then counts
     * how many times the value exist, if it does. This would help keep
     * track of how many times the value exist in the list
     *
     * @param value (Object to check to see if it exists )
     * @return frequency (number of times that value appears in the list)
     */
    public int valueFrequency(T value) {
        // checking if value is valid
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        int frequency = 0;// counts number of time value appears
        Node current = head.link;// current is set to first node in list

        /*looping to the end of the current object list since tail points to
         * the last node in the current object list
         */
        while (current != tail.link) {
            //checks to see if value is found
            if (current.value.compareTo(value) == 0) {
                frequency++;
            }
            current = current.link;// current changes to the next node
        }

        return frequency;
    }

    /**
     * This method returns the index of the first occurrence of value in the
     * current object list, and it returns -1 if it is not present. This method
     * treats the first position in the list to start as 0 instead of 1. This
     * means that when compared to the total number of values in the list, the
     * index will always be one less. This method finds the index
     * by checking if it exists first. if it does, then the method loops
     * through the current object list and finds the position of where
     * the value is in the object list.
     *
     * @param value (The value to search for and find the position)
     * @return Index (The index of value to be returned)
     */
    public int getIndex(T value) {
        // checking if value is valid
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        int index = 0;// to keep track of element position
        Node current = head.link;// current points to first element in the
        // current object list

        /*
         * before looping, it checks if the value does not occur in the current
         * linkedList object
         */
        if (valueFrequency(value) == 0)
            index = -1;
        else // if it occurs or is present in the list
        {

            //checking before loop if value is fist element (efficiency)
            if (current.value.compareTo(value)==0) {
                return index;
            }

            //checking if it is last element
            else if (tail.value.compareTo(value) == 0) {
                index = elemCount - 1;//set index to length - 1;
            } else {
			/* This loop quits when it reaches the end of the list, or
			when it finds the element,Value, in the list*/
                while (current != tail.link && current.value.compareTo(value) != 0)
                {
                    current = current.link;
                    index++;// index will keep increasing till it finds value
                }
            }
        }

        return index;
    }

    /**
     * This method returns the value that is at the index, position.
     * position is an arbitrary index in the current object list. This method
     * loops through the current object list to find the current element
     * that is at that position and then returns the element at that position.
     *
     * @param position (index of element to return)
     * @return element that is at index "position"
     */
    public T valueAtIndex(int position) {
        // checking if position can be a valid number to use.
        if (position < 0 || position > length() - 1)
            throw new IndexOutOfBoundsException("Invalid Position");

        T value = null;// create a value reference
        Node current = head.link;// reference to element in first position

        // checking if position is at the beginning
        if (position == 0) {
            value = current.value;// returns element in the first position
        } else {
            /*Loop that checks for the index of each value in the current
             * object list is the same as the position. If that index is found,
             * the loop quits and the value at that index is returned
             */

            while (current != tail.link &&
                    getIndex(current.value) != position) {
                current = current.link;// current points to the next element
                value = current.value;// value at current is stored
            }
        }

        return value;
    }

    /**
     * This method removes all the values from its current object that lies
     * between the first occurrence of fromValue to the first occurrence of
     * toValue with fromValue and toValue inclusive. toValue must also exist
     * only after fromValue in the object list. The method does this by looping
     * through and finding fromValue and toValue. It then removes the node that
     * contain values between fromValue and toValue.
     *
     * @param fromValue (value to start removing from)
     * @param toValue   (value to end removing)
     */
    public void removeFromTo(T fromValue, T toValue) {
        // check if fromValue and toValue are parameters that are valid
        if (fromValue == null || toValue == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        /*Count variable counts the number of removed element. i.e. number of
         * elements between fromValue and toValue */
        int count = 0;
        Node current = head.link;// points to the first Node in the list
        Node previous = head;// points to the dummyHeadNode, which is null

        Node begin = new Node();
        Node end = null;
        int indexBegin = -1;// tracks index of begin node. This is accessed
        // directly using indexOfValue()

        /*track index of end node. Set to -1 because index is one less than
         * length and indexEnd is used in a while loop. This is done in
         * case there are duplicate elements*/
        int indexEnd = -1;

        while (current != tail.link && end == null)
        {
            // finding the first occurrence of fromValue
            if (current.value.equals(fromValue) && begin.value == null)
            {
                begin = previous;// begin points to fromValue
                indexBegin = getIndex(current.value) ;//gets the index
            }

            // finding the first occurrence of toValue
            if (current.value.equals(toValue) && begin.value != null)
            {
				/*end points to the node after toValue,
				 because toValue has to also be removed*/
                end = current;
            }
            previous = current;// previous points to the current node
            current = current.link;// current points to next node in the list

            /*loop stops if end is not null. if end is not null, this
             *represents number of iteration required to get to end node
             * which is the same as position or index of end in the list*/
            indexEnd++;
        }


        /*if begin or end is null, then fromValue or toValue was not found We
         * also use index to find number of elements removed*/
        if (begin.value != null && end != null)
        {

			/* since index is always one less than length, we add one
			to find actual number of element removed*/
            count = (indexEnd - indexBegin) + 1;
            begin.link = end.link;// removes all values between begin and end
        }


        elemCount = elemCount - count;//updating the length
    }


    /**
     * The compareTo() method compares two LinkedList objects and
     * returns 0 if they are equal. If both objects have element in the
     * same order,
     * and elements are identical, zero is returned. If the list do not have
     * identical value in the same order, and the first element of the current
     * object is greater than that of the other object, it is being compared
     * to,a positive integer is returned. Otherwise, if the opposite occurs, a
     * negative integer is returned. Also, if both list are identical and have
     * elements in the same order, but one list has a longer length than the
     * other: a negative integer is returned if the current object list is
     * shorter, and a positive integer otherwise.
     *
     * @return result (value that defines how result are related to each other
     * when compared
     */
    @Override
    public int compareTo(LinkedList<T> otherList) {
        int result = 0;// keeps track of how they compare to each other

        /*These nodes help to keep track of the current node in the current
         * linkedList object and in another linkedList object*/
        Node current = head.link;
        Node otherListCurrent = otherList.head.link;

        // looping through both of the Linked objects at the same time
        while (current != tail.link &&
                otherListCurrent != otherList.tail.link) {
            if (result == 0)// result is 0 if they are equal.
            {
                // comparing the data in current object to another object

                if ((current.value.compareTo(otherListCurrent.value)) < 0) {
                    result = -1;// negative integer if current object is less
                }
                else if ((current.value.compareTo(otherListCurrent.value)) > 0)
                {
                    result = 1;// positive if current object is greater
                }

                /*this checks if they are equal and current list is shorter
                 * and if the current list reaches the tail first before
                 * the other list being compared*/
                else if ((current.value.compareTo(otherListCurrent.value)) == 0
                        && current.link == tail.link &&
                        otherListCurrent.link != otherList.tail.link)
                {
                    result = -1;// result becomes negative
                }

                /*this checks if they are equal and current list is longer and
                 * if the other list being compared, reaches the tail first
                 * before the current list*/
                else if ((current.value.compareTo(otherListCurrent.value)) == 0
                        && current.link != tail.link &&
                        otherListCurrent.link == otherList.tail.link) {
                    result = 1;
                }
                // else if it is equal...result remains unchanged and returns 0
            }

            // changes current to point to next node in the respective objects
            current = current.link;
            otherListCurrent = otherListCurrent.link;
        }

        return result;
    }

    /**This method removes element in every other node starting from the
     * second one.It removes alternate element. Modifies current object by
     * removing alternate elements starting with the second one*/
    public void removeEveryOther() {
        Node current = head,prev = current;
        int count = 0;// method similar to indexing

        while(current != null){
            /*checks if count is at and even number and removes the element.*/
            if(count % 2 ==0)
                prev.link = current.link;


            prev = current;
            current = current.link;
            count++;// count increase  at every iteration of while loop
        }
    }
}
