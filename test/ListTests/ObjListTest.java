/*Copyright (c) 2022. Do not use without permission. All Rights Reserved.
Simi Ojeyomi*/

package ListTests;

import Lists.ObjList.ObjList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// test for the objList class

class ObjListTest {
    // testing events where null could come up or as null parameters
    @Test
    void testNullEvents(){
        ObjList list = new ObjList();
        assertThrows(IllegalArgumentException.class, () ->{
            list.insertion(null);
            assertEquals(0, list.length());
           assertEquals("", list.toString());
            list.removeFromTo(null,"alpha");
            list.removeFromTo("beta", null);
        });
    }


    @Test
    void insertion() {
        ObjList animal = new ObjList();
        animal.insertion("ant");
        animal.insertion("bat");
        animal.insertion("cat");
        animal.insertion("dogs");
        animal.insertion("elephant");
        animal.insertion("fox");
        animal.insertion("goat");

        // to make sure insertion works, we can test length and toString
        Assertions.assertEquals(7, animal.length());
        Assertions.assertEquals("ant bat cat dogs elephant fox goat",
                animal.toString());
        Assertions.assertEquals("goat fox elephant dogs cat bat ant",
                animal.toStringReversal());
    }

    @Test
    void length() {
        ObjList prime = new ObjList();
        //adding to list
        prime.insertion(2);
        prime.insertion(3);
        prime.insertion(5);
        prime.insertion(7);
        prime.insertion(9);
        prime.insertion("Prime numbers");

        assertEquals(6, prime.length());

        // removing from list
        prime.removeFromTo(5,5);
        assertEquals(5, prime.length());

        // inserting more into the list
        prime.moveLastToBegin();
        prime.insertion(11);
        prime.insertion(13);
        assertEquals(7, prime.length());

        // clearing the list
        prime.clear();

        assertEquals(0, prime.length());
        assertEquals("", prime.toString());

        // adding back to list
        prime.insertion(2);
        prime.insertion(3);
        prime.insertion(5);
        prime.insertion(7);
        prime.insertion(9);
        prime.insertion(11);
        prime.insertion(13);
        prime.insertion("Prime numbers");
        prime.moveLastToBegin();

        assertEquals(8, prime.length());
    }

    @Test
    void testToString() {
        ObjList streaming = new ObjList();
        streaming.insertion("Netflix");
        streaming.insertion("Disney");
        streaming.insertion("Hulu");
        streaming.insertion("123Movies");
        streaming.insertion("Peacock");
        streaming.insertion("HBOMax");
        streaming.insertion("Prime Video");
        streaming.insertion("Crunchy-roll");

        assertEquals("Netflix Disney Hulu 123Movies Peacock HBOMax" +
                        " Prime Video Crunchy-roll", streaming.toString());
        assertEquals("Crunchy-roll Prime Video HBOMax Peacock 123Movies " +
                "Hulu Disney Netflix", streaming.toStringReversal());
    }


    @Test
    void filtration() {
        ObjList numbers = new ObjList();

        for(int i = 10; i >= 0;i--)
            numbers.insertion(i);

        // Using filtration to cutoff numbers in the objList
        assertEquals(11, numbers.length());
        numbers.intFilter(6);

        assertEquals(7, numbers.length());

        numbers.intFilter(4);
        assertEquals(5, numbers.length());

        numbers.intFilter(0);
        assertEquals(1, numbers.length());

        numbers.intFilter(-1);
        assertEquals(0, numbers.length());
    }

    @Test
    void moveToEnd() {
        ObjList alphabets = new ObjList();
        alphabets.insertion('A');
        alphabets.insertion('D');
        alphabets.insertion('C');
        alphabets.insertion('B');

        // checking to see if any change is made to the list if I try to make
        // 'A' first element
        alphabets.makeNewList(0);
        assertEquals("A D C B", alphabets.toString());

        // making B first  element
        alphabets.makeNewList(3);
        assertEquals("B A D C", alphabets.toString());
    }

    @Test
    void moveLastToBegin() {
        ObjList alphabets = new ObjList();
        alphabets.insertion('B');
        alphabets.insertion('C');
        alphabets.insertion('D');
        alphabets.insertion('A');

        alphabets.moveLastToBegin();
        assertEquals("A B C D", alphabets.toString());

    }

    @Test
    void removeFromTo() {
        ObjList streaming = new ObjList();
        streaming.insertion("Netflix");
        streaming.insertion("Disney");
        streaming.insertion("Hulu");
        streaming.insertion("123Movies");
        streaming.insertion("Peacock");
        streaming.insertion("HBOMax");
        streaming.insertion("Prime Video");
        streaming.insertion("Crunchy-roll");

        streaming.removeFromTo("Hulu", "HBOMax");
        assertEquals(4, streaming.length());

        streaming.removeFromTo("Netflix", "Netflix");
        assertEquals(3,streaming.length());
    }

    @Test
    public void search(){
        ObjList animal = new ObjList();
        animal.insertion("ant");
        animal.insertion("bat");
        animal.insertion("cat");
        animal.insertion("dogs");
        animal.insertion("elephant");
        animal.insertion("fox");
        animal.insertion("goat");
        animal.insertion("Donald Trump");
        animal.insertion("Java 101");

        // searching the list to see what is returned
        assertFalse(animal.search("Java101"));
        assertTrue(animal.search("Java 101"));
        assertTrue(animal.search("ant"));
        assertTrue(animal.search("cat"));
        assertTrue(animal.search("bat"));
        assertFalse(animal.search("turkey"));
    }
}