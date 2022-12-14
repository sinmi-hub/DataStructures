/*
 * Copyright (c) 2022. Do not use without permission. All Rights Reserved. Simi Ojeyomi
 */
// Main to test LinkedList files
package Lists.LinkedList;

public class Driver {
    public static void main(String[] args) {
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
        LinkedList<Integer> list1 = new SortedLinkedList<>();
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

        System.out.println("--------TESTING BASIC FUNCTIONALITY--------");
        System.out.println("Content of the list include:");
        System.out.println("List: "+list);
        System.out.println("The length of the current list is " +list.length());
        System.out.println("92 occurs " + list.valueFrequency(92)+" times");
        System.out.println("96 occurs " + list.valueFrequency(96)+" times");
        System.out.println("--------------------------------------------");


        System.out.println("Removing values between 64 and 34..");
        list.removeFromTo(64,34);
        System.out.println("List: "+list);
        System.out.println("The length of the current list is " +list.length());
        System.out.println("--------------------------------------------");

        list.clear();
        for (int j : testArray) {
            list.insertion(j);
        }
        System.out.println("Removing values between 64 and 92..");
        list.removeFromTo(64,92);
        System.out.println("List: "+list);
        System.out.println("The length of the current list is " +list.length());

        System.out.println("--------------------------------------------");
        System.out.println("Clearing the list.....");
        list.clear();
        System.out.println("Printing out the length of list after clearing..");
        System.out.println("List: "+list);
        System.out.println("The length of list is "+list.length());
        System.out.println("--------------------------------------------");


        for (int j : testArray) {
            list.insertion(j);
        }
        System.out.println("Finding the index of 10 and 100..");
        System.out.println(list.getIndex(10));
        System.out.println(list.getIndex(100));
        System.out.println("Finding the index of 92 which occurs more than once..");
        System.out.println(list.getIndex(92));

        System.out.println("The value at index 0,1,10, and 12 and 18 is..");
        System.out.println(list.valueAtIndex(0));
        System.out.println(list.valueAtIndex(1));
        System.out.println(list.valueAtIndex(10));
        System.out.println(list.valueAtIndex(12));
        System.out.println(list.valueAtIndex(18));
        System.out.println();

        System.out.println("-------TESTING SortedLINKEDLIST---------");
        System.out.println("Printing list1 in order ...");
        for (int j : testArray) {
            list1.insertion(j);
        }

        System.out.println(list1);
        System.out.println("The length of list is "+list1.length());
        System.out.println("92 occurs " + list1.valueFrequency(92)+" times");
        System.out.println("96 occurs " + list1.valueFrequency(96)+" times");
        System.out.println();

        System.out.println("Removing values between 64 and 92..");
        list1.removeFromTo(64,92);
        System.out.println("List: "+list1);
        System.out.println("The length of the current list is " +list1.length());
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("--------TESTING COMPARETO() METHOD---------");
        System.out.println("Comparing elephant to elephant...");
        System.out.println(animal.compareTo(animalTest));

        animalTest.clear();
        for (String j : testWords1) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing elephant to yak...");
        System.out.println(animal.compareTo(animalTest));

        animalTest.clear();
        for (String j : testWords2) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing elephant to elegant...");
        System.out.println(animal.compareTo(animalTest));

        animalTest.clear();
        for (String j : testWords3) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing elephant to camel...");
        System.out.println(animal.compareTo(animalTest));

        animal.clear();
        for (String j : testWords4) {
            animal.insertion(j);
        }

        animalTest.clear();
        for (String j : testWords5) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing arm to armadillo...");
        System.out.println(animal.compareTo(animalTest));

        animal.clear();
        for (String j : testWords5) {
            animal.insertion(j);
        }

        animalTest.clear();
        for (String j : testWords4) {
            animalTest.insertion(j);
        }

        System.out.println("Comparing armadillo to arm.");
        System.out.println(animal.compareTo(animalTest));

        animal.removeEveryOther();
    }
}
