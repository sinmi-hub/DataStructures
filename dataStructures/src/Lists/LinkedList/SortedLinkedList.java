/*Copyright (c) 2022. Do not use without permission. All Rights Reserved.
Simi Ojeyomi*/


/*This class represents a class that stores data the way a LinkedList
 * does, but it only stores or adds the element in order. As a result,
 * all the nodes are in order. This class is a child class of LinkedList,
 * and it inherits most of the methods from a LinkedList class,
 *although some are overridden to actually enhance efficiency. The add method
 * is overridden to actually add the elements in order unlike the
 * LinkedList class*/
package Lists.LinkedList;


public class SortedLinkedList<T extends Comparable<T>>
        extends LinkedList<T> {

    /**Default Constructor for the SortedLinkedList. This initializes head
     * and tail to be null. Also sets the element count to be zero because
     *nothing should be in the current object list*/
    public SortedLinkedList() {
        super();//calls superclass constructor
    }

    @Override
    /*
     * This method adds a new element called newValue to the linked list.
     * newValue is added an ascending order. This means after newValue has
     * been added, all values before newValue must be less than
     * newValue and all values after newValue must be greater than newValue
     *
     * @param newValue (Value to be added to the linked list)
     */
    public void insertion(T newValue) {
        // checking if newValue is null and throwing an exception
        if (newValue == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        /*Prev node is created to keep track of the node before current*/
        Node prev = head;// prev points to head
        Node current = head.link;// points to the current node in the list
        Node temp = new Node(newValue);// creating a new node based on newValue

        // if statement to check if list is empty
        if (elemCount == 0) {
            head.link = temp;// sets head to the temp, which would become
            tail = temp; // the first node in the linked list
        }

        else
        {
            /*loop checks if current node has a value that is greater
             * than newValue and exits if that condition is true*/
            while (current != tail.link &&
                    current.value.compareTo(newValue) < 0)
            {

                prev = current;// sets previous to current
                current = current.link;//current points to next node in list.
            }

            prev.link = temp;// previous points to temp
            temp.link = current;//temp points to current

            /*if the loop exits because it got to the end of the list, and current
             *became null, then a bigger value than the current tail was added to
             * the list, according to the second while loop condition*/
            if (current == null)
                tail = temp;//we change the reference of the current tail to the
            //bigger value
        }

        elemCount++;// elemCount increases by one. This is also used
        // to keep track of length
    }

    @Override
    /*This method is overridden because in an increasing list,
     * we do not need to completely loop to the end of the list to find a value
     * Since the value is in increasing order, it is possible that it might
     * be found quicker.
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

        /*Instead of looping to end of list, loop becomes shorter and exits
         * if a value greater than the value being searched for is found
         */
        while (current != tail.link  && current.value.compareTo(value) <= 0) {
            //checks to see if value is found
            if (current.value.compareTo(value) == 0) {
                frequency++;
            }
            current = current.link;// current changes to the next node
        }

        return frequency;
    }
    @Override
    public void removeFromTo(T fromValue, T toValue) {
        // check if fromValue and toValue are parameters that are valid
        if (fromValue == null || toValue == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        /*Count variable counts the number of removed element.
         * i.e. number of elements between fromValue and toValue */
        int count = 0;
        Node current = head.link;// points to the first Node in the list
        Node previous = head;// points to the dummyHeadNode, which is null

        Node begin = new Node();
        Node end = null;
        int indexBegin = 0;// tracks index of begin node. This is accessed
        //directly using indexOfValue()


        int indexEnd = 0;

        while (current != tail.link
                && current.value.compareTo(toValue) <= 0)
        {
            // finding the first occurrence of fromValue
            if (current.value.equals(fromValue))
            {
                begin = previous;// begin points to fromValue
                indexBegin = getIndex(current.value);//gets the index
            }

            // finding the first occurrence of toValue
            if (current.value.equals(toValue)
                    && previous.value.compareTo(current.value) < 0)
            {
					/*end points to the node after toValue,
					 because toValue has to also be removed*/
                end = current.link;
                indexEnd = getIndex(current.value);//gets the index
            }
            previous = current;// previous points to the current node
            current = current.link;// current points to next node in
            //the list
        }


        /*if begin or end is null, then fromValue or toValue was not found.
         * We also use index to find number of elements removed*/
        if (begin.value != null && end != null)
        {

				/* since index is always one less than length, we add one
				to find actual number of element removed*/
            count = (indexEnd - indexBegin) + 1;
            begin.link = end;// removes all values between begin and end
        }

        super.elemCount = super.elemCount - count;//updating the length
    }
}
