/*
 * Copyright (c) 2022. Do not use without permission. All Rights Reserved. Simi Ojeyomi
 */
// Main to test LinkedList files
package Lists;

import Lists.LinkedList.LinkedList;
import Lists.LinkedList.SortedLinkedList;
import Lists.ObjList.ObjList;

import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Main method tests the linked-list class and " +
                "obj-list class");
        System.out.println("Starting with linked list: \n");

        System.out.println("Testing the Linked-List class.... ");
        int[] testArray = {52, 66, 10, 92, 81, 89,
                64, 33, 34, 92,  9, 58,
                96, 92, 92, 35, 24, 96,22};

        String[] testWords = {"e","l","e","p","h","a","n","t"};
        String [] testWords1 = {"y","a","k"};
        String[] testWords2 = {"e","l","e","g","a","n","t"};
        String[] testWords3 = {"c","a","m","e","l"};
        String[] testWords4 = {"a","r","m"};
        String[] testWords5 = {"a","r","m","a","d","i","l","l","o"};

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list0 = new SortedLinkedList<>();
        LinkedList<String> animal = new LinkedList<>();
        LinkedList<String> animalTest = new LinkedList<>();

        for (int j : testArray) {
            list.insertion(j);
        }

        for (String j : testWords) {
            animal.insertion(j);
        }

        for (String j : testWords) {
            animalTest.insertion(j);
        }

        System.out.print("Content of the list include: ");
        System.out.println(list);
        System.out.println("The length of the current list is: " +list.length());
        System.out.println("92 occurs " + list.valueFrequency(92)+" times");
        System.out.println("96 occurs " + list.valueFrequency(96)+" times");
        System.out.println("--------------------------------------------");


        System.out.println("Removing values between 64 and 34...");
        list.removeFromTo(64,34);
        System.out.println("Current list: "+list);
        System.out.println("The length of the current list is: " +list.length());
        System.out.println("--------------------------------------------");

        list.clear();
        for (int j : testArray) {
            list.insertion(j);
        }
        //TODO Bugfix
        System.out.println("Removing values between 64 and 92...");
        list.removeFromTo(64,92);
        System.out.println("Current list: "+list);
        System.out.println("The length of the current list is " +list.length());

        System.out.println("--------------------------------------------");
        System.out.println("Clearing the list.....");
        list.clear();
        System.out.println("Printing out the length of list after clearing...");
        System.out.println("Current list: " +list);
        System.out.println("The length of list is "+list.length());
        System.out.println("--------------------------------------------");


        for (int j : testArray) {
            list.insertion(j);
        }
        System.out.println("Finding the index of 10 and 100...");
        System.out.println("Index of 10 is: " +list.getIndex(10));
        System.out.println("Index of 100 is: " +list.getIndex(100));
        System.out.println("Finding the index of 92 which occurs more than " +
                "once...");
        System.out.println("Index of 92 is: " +list.getIndex(92));

        System.out.println("The value at index 0, 1, 10, 12 and 18 are...");
        System.out.print("[" + list.valueAtIndex(0) + "]");
        System.out.print("[" + list.valueAtIndex(1) + "]");
        System.out.print("[" + list.valueAtIndex(10) + "]");
        System.out.print("[" + list.valueAtIndex(12) + "]");
        System.out.print("[" + list.valueAtIndex(18) + "]");
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("\nTesting Sorted Linked List....");
        System.out.println("Printing list in order ...");
        for (int j : testArray) {
            list0.insertion(j);
        }

        System.out.print(list0);
        System.out.println("\nThe length of list is "+list0.length());
        System.out.println("92 occurs " + list0.valueFrequency(92)+" times");
        System.out.println("96 occurs " + list0.valueFrequency(96)+" times");

        System.out.println("--------------------------------------------");
        System.out.println("Removing values between 64 and 92..");
        list0.removeFromTo(64,92);
        System.out.println("List: "+list0);
        System.out.println("The length of the current list is " +list0.length());
        System.out.println("--------------------------------------------");

        System.out.println("Testing the Compare To method...");
        System.out.println("Comparing elephant to elephant: "+
                            animal.compareTo(animalTest));


        animalTest.clear();
        for (String j : testWords1) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing elephant to yak: "+
                animal.compareTo(animalTest));


        animalTest.clear();
        for (String j : testWords2) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing elephant to elegant: "+
                animal.compareTo(animalTest));


        animalTest.clear();
        for (String j : testWords3) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing elephant to camel: "+
                animal.compareTo(animalTest));


        animal.clear();
        for (String j : testWords4) {
            animal.insertion(j);
        }

        animalTest.clear();
        for (String j : testWords5) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing arm to armadillo: "+
                animal.compareTo(animalTest));


        animal.clear();
        for (String j : testWords5) {
            animal.insertion(j);
        }

        animalTest.clear();
        for (String j : testWords4) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing armadillo to arm: "+
                animal.compareTo(animalTest));

        System.out.println();
        System.out.println("Testing Obj List class... ");

        ObjList aList = new ObjList();
        ObjList list1 = new ObjList();
        ObjList list2 = new ObjList();

        Iterator<Object> iter;

        aList.insertion("giraffe");
        aList.insertion((12345));
        aList.insertion(('w'));
        aList.insertion((false));
        aList.insertion("gerbil");

        iter = aList.iterator();
        iter.next();
        iter.remove();

        System.out.print("Current Obj List contains: ");
        while (iter.hasNext()){
            System.out.print(iter.next() +" ");
        }
        System.out.println("\n-----------------------------------");

        int i = 10;
        while (i >= 1 ){
            list1.insertion(i);
            i--;
        }

        System.out.print("New list created. New List contains: ");
        System.out.print(list1);
        System.out.println("\n--------------------------------------------");
        list1.filtration(5);
        System.out.println("Removing any element greater than 5: ");
        System.out.print("Current list: "+list1);
        System.out.println("\n--------------------------------------------");
        System.out.println("Making the element at position 3 the end of the " +
                "list: ");
        list1.moveToEnd(3);
        System.out.println("Current List: " + list1);
        System.out.println("--------------------------------------------");

        System.out.println("Moving the last to the beginning:");
        list1.moveLastToBegin();
        System.out.println("Current List: " + list1);

        // simply adding integers to the list
        int j = 9;
        while (j >= 6 ){
            list2.insertion(j);
            j--;
        }
        list2.insertion(7);
        list2.insertion(1);
        list2.insertion(2);
        System.out.println("-----------------------------------");
        System.out.println("New List created: " + list2);
        System.out.println("Removing elements from 6 to 6 from new list: ");
        list2.removeFromTo(6,6);
        System.out.print(list2);
        System.out.println("\n--------------------------------------------");
        System.out.println("Removing elements from 8 to 7: ");
        list2.removeFromTo(8,7);
        System.out.print(list2);
    }
}
