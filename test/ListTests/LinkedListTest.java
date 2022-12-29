/*Copyright (c) 2022. Do not use without permission. All Rights Reserved.
Simi Ojeyomi*/

// This class contains test written for implementation of linkedList
package ListTests;

// importing all necessary libraries
import Lists.LinkedList.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    // testing addSorted. This tests the SortedLinkedList to see if objects
    // are added in ascending order
    @Test
    public void testAddSorted() {
        int[] testArray = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        // even if we have a linkedList reference, the object being called upon
        // is an orderedlinkedlist
        LinkedList<Integer> list1 = new SortedLinkedList<>();

        for (int j : testArray) {
            list1.insertion(j);// inserting....
        }

        assertEquals("9 10 22 24 33 34 35 52 58 64 66 81 89 92 92 92"
                + " 92 96 96",list1.toString());
    }

    // This tests removing from a specific value to another specific value
    // as specified by parameter.
    // Both starting value and ending value are also removed
    @Test
    public void testRemoveFromTo() {
        int[] testArray = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        LinkedList<Integer> list1 = new LinkedList<>();

        for (int j : testArray) {
            list1.insertion(j);
        }

        list1.removeFromTo(64, 34);// removing from specific range
        assertEquals(16, list1.length());// checking length to reflect removal

        assertEquals("52 66 10 92 81 89 92 9 58 96 "
                + "92 92 35 24 96 22",list1.toString());// checking values left

        //----PROCESS IS REPEATED AGAIN----------
        list1.removeFromTo(92, 92);
        assertEquals("52 66 10 81 89 92 9 58 96 "
                + "92 92 35 24 96 22",list1.toString());
        assertEquals(15, list1.length());

        //----PROCESS IS REPEATED AGAIN----------
        list1.removeFromTo(92, 100);
        assertEquals("52 66 10 81 89 92 9 58 96 "
                + "92 92 35 24 96 22",list1.toString());

        //----PROCESS IS REPEATED AGAIN----------
        list1.removeFromTo(60, 24);
        assertEquals("52 66 10 81 89 92 9 58 96 "
                + "92 92 35 24 96 22",list1.toString());

        //----PROCESS IS REPEATED AGAIN----------
        list1.removeFromTo(34, 52);
        assertEquals("52 66 10 81 89 92 9 58 96 "
                + "92 92 35 24 96 22",list1.toString());

    }
    // tests how many times  data occurs
    @Test
    public void testOccurrence() {
        int[] testArray = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        LinkedList<Integer> list1 = new LinkedList<>();
        for (int j : testArray) {
            list1.insertion(j);
        }

        assertEquals(4, list1.valueFrequency(92));
        assertEquals(2, list1.valueFrequency(96));
        assertEquals(1, list1.valueFrequency(34));
        assertEquals(0, list1.valueFrequency(100));
    }

    // testing structure of code
    @Test
    public void testStructure() {
        String[] testArray = {"solid","white","hot","sticky"};
        int[] testArray2 = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        // adding into the list
        for (String j : testArray) {
            list1.insertion(j);
        }
        for (int j : testArray2) {
            list2.insertion(j);
        }

        // getting a value from list through index
        assertEquals(0, list1.getIndex("solid"));
        assertEquals(1, list1.getIndex("white"));
        assertEquals(-1, list1.getIndex("white "));

        assertEquals(0, list2.getIndex(52));
        assertEquals(18, list2.getIndex(22));
        assertEquals(3, list2.getIndex(92));
        assertEquals(-1, list2.getIndex(102));
    }

    // another structure test
    @Test
    public void testStructure1() {
        int[] testArray = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        // using a sortedLinkedList
        LinkedList<Integer> list = new SortedLinkedList<>();

        // adding to list
        for (int j : testArray) {
            list.insertion(j);
        }

        // checking if items was successfully added to list
        assertEquals("9 10 22 24 33 34 35 52 58 64 66 81 89 "
                + "92 92 92 92 96 96",list.toString());
        assertEquals(19, list.length());

        // clearing the list and confirming it is cleared
        list.clear();
        assertEquals("",list.toString());
        assertEquals(0, list.length());

        // adding to it again
        for (int j : testArray) {
            list.insertion(j);
        }
        // validating that it can be added to again
        assertEquals("9 10 22 24 33 34 35 52 58 64 66 81 89 "
                + "92 92 92 92 96 96",list.toString());
        assertEquals(19, list.length());

        // removing from list
        list.removeFromTo(24, 58);
        assertEquals("9 10 22 64 66 81 89 "
                + "92 92 92 92 96 96",list.toString());
        assertEquals(13, list.length());

        list.removeFromTo(66,92);

        assertEquals("9 10 22 64 92 92 92 96 96",list.toString());
        assertEquals(9, list.length());

        // checking occurrence of specific data
        assertEquals(3, list.valueFrequency(92));
        assertEquals(2, list.valueFrequency(96));
        assertEquals(1, list.valueFrequency(9));
    }

    // testing structure for linked list, not sorted
    @Test
    public void testLinkedListClass() {
        int[] testArray = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        LinkedList<Integer> list = new LinkedList<>();
        // inserting
        for (int j : testArray) {
            list.insertion(j);
        }

        // validating insertion
        assertEquals("52 66 10 92 81 89 "
                + "64 33 34 92 9 58 "
                + "96 92 92 35 24 96 22",list.toString());
        assertEquals(19, list.length());
        // clearing the list
        list.clear();
        // validating empty list after it is cleared
        assertEquals("",list.toString());
        assertEquals(0, list.length());

        // inserting again and validating
        for (int j : testArray) {
            list.insertion(j);
        }
        assertEquals("52 66 10 92 81 89 "
                + "64 33 34 92 9 58 "
                + "96 92 92 35 24 96 22",list.toString());
        assertEquals(19, list.length());

        // removing and validating removal
        list.removeFromTo(24, 58);
        assertEquals("52 66 10 92 81 89 "
                + "64 33 34 92 9 58 "
                + "96 92 92 35 24 96 22",list.toString());
        assertEquals(19, list.length());

        list.removeFromTo(9, 35);
        assertEquals("52 66 10 92 81 89 "
                + "64 33 34 92 24 96 22",list.toString());

        // checking that after removal, some values cannot occur twice
        assertEquals(2, list.valueFrequency(92));
        assertEquals(1, list.valueFrequency(96));
        assertEquals(0, list.valueFrequency(9));
    }

    // testing null or invalid input detection
    @Test
    public void testNullEvent() {
        assertThrows(IllegalArgumentException.class, () -> {
            // making a sorted and unsorted linked-list
            LinkedList<Integer> list = new LinkedList<>();
            LinkedList<Integer> list1 = new SortedLinkedList<>();

            // testing for an unsorted linkedList
            list.insertion(null);
            list.valueFrequency(null);
            list.getIndex(null);
            list.removeFromTo(null, null);
            list.removeFromTo(1, null);
            list.removeFromTo(null, 5);

            // testing for a sorted linked-list
            list1.insertion(null);
            list1.valueFrequency(null);
            list1.getIndex(null);
            list1.removeFromTo(null, null);
            list1.removeFromTo(1, null);
            list1.removeFromTo(null, 5);
        });
    }

    // testing error handling for valueAtIndex method
    @Test
    public void testIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            LinkedList<Integer> list = new LinkedList<>();
            LinkedList<Integer> list1 = new SortedLinkedList<>();

            int[] testArray = {52, 66, 10, 92, 81, 89, 64, 33, 34, 92, 9, 58,
                    96, 92, 92, 35, 24, 96, 22};

            for (int j : testArray) {
                list.insertion(j);
                list1.insertion(j);
            }

            list.valueAtIndex(-1);
            list.valueAtIndex(19);

            list1.valueAtIndex(-1);
            list1.valueAtIndex(19);
        });
    }

    // testing what happens when an empty List exists
    @Test
    public void testEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            LinkedList<String> list = new LinkedList<>();
            LinkedList<String> list1 = new SortedLinkedList<>();


            assertEquals(0, list1.length());
            assertEquals("", list1.toString());
            list1.clear();
            assertEquals("", list1.toString());
            assertEquals(0, list1.valueFrequency("daddy"));
            assertEquals(-1, list1.getIndex("Chill"));
            assertEquals("", list1.valueAtIndex(4));
            assertEquals(0, list.compareTo(list1));

            assertEquals("", list.toString());
            assertEquals(0, list.length());
            list.clear();
            assertEquals("", list.toString());
            assertEquals(0, list.valueFrequency("daddy"));
            assertEquals(-1, list.getIndex("Chill"));
            assertEquals("", list.valueAtIndex(4));
        });
    }
}
