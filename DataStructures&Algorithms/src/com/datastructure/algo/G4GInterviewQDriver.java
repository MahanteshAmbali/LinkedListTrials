package com.datastructure.algo;

public class G4GInterviewQDriver {

    public static void main(String[] args){

        SingleLinkedListOperations sllOperations = new SingleLinkedListOperations();

        // ADD ITEMS TO LINKED LIST
        /*sllOperations.add(10);
        sllOperations.add(44);
        sllOperations.add(20);
        sllOperations.add(12);
        sllOperations.add(30);
        sllOperations.add(61);
        sllOperations.add(40);
        sllOperations.add(50);
        sllOperations.add(90);
        sllOperations.add(61);
        sllOperations.add(60);
        sllOperations.add(23);
        sllOperations.add(70);
        sllOperations.add(23);
        sllOperations.add(130);
        sllOperations.add(12);
        sllOperations.add(61);*/

        sllOperations.add(1);
        sllOperations.add(9);
        sllOperations.add(1);
        sllOperations.add(1);

        // PRINT
        System.out.println(sllOperations);

        System.out.println("------------------------------------------------------------------------------");

        // PRINT MIDDLE ELEMENT  -- ITERATIVE METHOD.
        System.out.println("Using normal approach: "+sllOperations.printMiddleElement());

        System.out.println("------------------------------------------------------------------------------");

        // PRINT MIDDLE ELEMENT  -- SLOW FAST POINTER METHOD.
        System.out.println("Using Slow and Fast Pointers: "+sllOperations.printMiddleElementFastSlowNode());

        System.out.println("------------------------------------------------------------------------------");

        // CANCEL OUT THE ELEMENTS WHICH WILL ADD TO 0.
        //sllOperations.cancelOut();
        //System.out.println("Cancel Out Elements.!"+sllOperations);

        System.out.println("------------------------------------------------------------------------------");

        // DELETE MIDDLE ELEMENT OF LINKED LIST.
        //sllOperations.deleteMiddleElement();
        //System.out.println("After deleting the middle element of the Linked List.!"+sllOperations);
        System.out.println("------------------------------------------------------------------------------");

        // REMOVE DUPLICATES FROM SORTED LINKED LIST.

        // sllOperations.removeDuplicateElementsSortedList();
        System.out.println("After deleting the duplicate elements from the Sorted Linked List.!"+sllOperations);

        System.out.println("------------------------------------------------------------------------------");

        // REMOVE DUPLICATES FROM UNSORTED LINKED LIST.
        //sllOperations.removeDuplicateElementsUnsortedList();
        System.out.println("After deleting the duplicate elements from the Unsorted Linked List.!"+sllOperations);

        System.out.println("------------------------------------------------------------------------------");

        // REMOVE DUPLICATES FROM UNSORTED LINKED LIST.
        //sllOperations.removeDuplicateElementsUnsortedListUsingHashSet();
        System.out.println("After deleting the duplicate elements from the Unsorted Linked List using Hash Set.!"+sllOperations);
        System.out.println("------------------------------------------------------------------------------");

        // ADDING 1 TO INDIVIDUAL ELEMENTS OF THE LINKED LIST. -- BY REVERSING THE LIST AND RECURSION.
        //sllOperations.addOneToANumberOfLinkedList();
        System.out.println("Adding 1 to individual elements of the list(LIST REVERSE AND RECURSION): "+sllOperations);
        System.out.println("------------------------------------------------------------------------------");

        // ADDING 1 TO INDIVIDUAL ELEMENTS OF THE LINKED LIST. -- WITHOUT REVERSAL AND RECURSION OF LIST.
        sllOperations.addOneToLinkedListElements();
        System.out.println("Adding 1 to individual elements of the list(WITHOUT REVERSE AND RECURSION): "+sllOperations);
        System.out.println("------------------------------------------------------------------------------");
    }
}
