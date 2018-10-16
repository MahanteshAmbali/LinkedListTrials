package com.datastructure.algo;

public class SingleLinkedListDriver {

    public static void main (String[] args) {

        int index  = 5;

        SingleLinkedListOperations sllOperations = new SingleLinkedListOperations();

        // ADD ITEMS TO LINKED LIST
        sllOperations.add(10);
        sllOperations.add(20);
        sllOperations.add(30);
        sllOperations.add(40);
        sllOperations.add(50);
        sllOperations.add(60);
        sllOperations.add(70);
        sllOperations.add(80);
        sllOperations.add(90);
        sllOperations.add(100);

        // PRINT
        System.out.println(sllOperations);

        System.out.println("------------------------------------------------------------------------------");


        // GET ITEM AT INDEX
        System.out.println("Get of index "+ index +" from above list: "+sllOperations.get(index-1));

        System.out.println("------------------------------------------------------------------------------");

        // REMOVE ITEM AT INDEX
        System.out.println("Item from index: "+index+" removal status: "+sllOperations.remove(index-1));

        // PRINT AFTER REMOVING ITEM AT INDEX
        System.out.println(sllOperations);

        System.out.println("------------------------------------------------------------------------------");

        // REMOVE ITEM FROM FIRST
        sllOperations.removeFirst();

        // PRINT
        System.out.println("List Elements after first element removal from Linked List.");
        System.out.println(sllOperations);
        System.out.println("------------------------------------------------------------------------------");

        // REMOVE ITEM FROM FIRST
        sllOperations.removeLast();

        // PRINT
        System.out.println("List Elements after last element removal from Linked List.");
        System.out.println(sllOperations);
        System.out.println("------------------------------------------------------------------------------");

        // ADD ELEMENT AT BEGINNING
        sllOperations.addFront(110);

        //PRINT
        System.out.println("List Elements after adding element at front of Linked List.");
        System.out.println(sllOperations);
        System.out.println("------------------------------------------------------------------------------");

        // ADD ELEMENT AT INDEX
        sllOperations.addAtIndex(50, index-1);
        sllOperations.addAtIndex(120, 20);

        //PRINT
        System.out.println("List Elements after adding element at index "+index+" of Linked List.");
        System.out.println(sllOperations);
        System.out.println("------------------------------------------------------------------------------");
    }
}
