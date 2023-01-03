/*
 * Copyright (c) 2022. Do not use without permission. All Rights Reserved. Simi Ojeyomi
 */

// Main to test linkedList implemented with objects
package Lists.ObjList;
import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        ObjList list = new ObjList();
        ObjList list1 = new ObjList();
        ObjList list2 = new ObjList();

        Iterator<Object> iter;

        list.insertion("giraffe");
        list.insertion((12345));
        list.insertion(('w'));
        list.insertion((false));
        list.insertion("gerbil");

        iter = list.iterator();
        iter.next();
        iter.remove();

        System.out.println("Iterator is: ");
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("-----------------------------------");

        int i = 10;
        while (i >= 1 ){
            list1.insertion(i);
            i--;
        }

        System.out.println("List1 is: ");
        System.out.println(list1);
        list1.intFilter(5);

        System.out.println(list1);
        System.out.println("Making the node at position 3 the end of the list");
        list1.makeNewList(3);
        System.out.println("List1: " + list1);

        System.out.println("Moving the last to the beginning");
        list1.moveLastToBegin();
        System.out.println("List1: " + list1);

        // simply adding integers to the list
        int j = 9;
        while (j >= 6 ){
            list2.insertion(j);
            j--;
        }
        list2.insertion(7);
        list2.insertion(1);
        list2.insertion(2);
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("List 2: " + list2);
        System.out.println("Removing elements from 6 to 6");
        list2.removeFromTo(6,6);
        System.out.println(list2);

        System.out.println("Removing elements from 8 to 7");
        list2.removeFromTo(8,7);
        System.out.println(list2);
    }
}
