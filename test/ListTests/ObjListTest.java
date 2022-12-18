/*Copyright (c) 2022. Do not use without permission. All Rights Reserved.
Simi Ojeyomi*/

package ListTests;

import Lists.ObjList.ObjList;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


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
    void iterator() {
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
        Assertions.assertEquals("ant bat cat dogs elephant fox goat",animal.toString());
        Assertions.assertEquals("goat fox elephant dogs cat bat ant",animal.toStringReversal());
    }

    @Test
    void length() {
    }

    @Test
    void testToString() {
    }

    @Test
    void toStringReversal() {
    }

    @Test
    void filtration() {
    }

    @Test
    void moveToEnd() {
    }

    @Test
    void moveLastToBegin() {
    }

    @Test
    void removeFromTo() {
    }
}