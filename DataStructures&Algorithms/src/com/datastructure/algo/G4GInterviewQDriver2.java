package com.datastructure.algo;

public class G4GInterviewQDriver2 {

    public static void main(String[] args){

        SingleLinkedListOperations sllOperations =
                new SingleLinkedListOperations();

        sllOperations.add(10);
        sllOperations.add(90);
        sllOperations.add(30);
        sllOperations.add(40);
        sllOperations.add(50);
        sllOperations.add(40);
        sllOperations.add(30);
        sllOperations.add(90);
        sllOperations.add(10);

        sllOperations.add(10);

        //sllOperations.reverseLinkedListOfGivenSize(3);
        //System.out.println("Linked List after reversing the list in sizes of 3 "+sllOperations);

        int n = 3;
        int m = 2;

        //System.out.println(n+"th Node from End in the list is: "+sllOperations.findNthNodeFromEnd(n-1));

        //System.out.println("Is given List Palindrome: "+sllOperations.isListPalindrome());

        int elementToRemove = 40;

        //sllOperations.removeLastOccurrenceOf(elementToRemove);
        //System.out.println("List Elements after deleting last occurrence of: "+elementToRemove+": -> "+sllOperations);

        // ROTATE A LINKED LIST AFTER K NODES.
        //sllOperations.rotateLinkedListAfterNNodes(n-1);

        //System.out.println("Linked List Elements Rotating after k Nodes: "+sllOperations);

        // DELETE N NODES AFTER M NODES IN A LINKED LIST
        sllOperations.deleteNNodesAfterMNodes(n, m);

        System.out.println("Linked List Elements after deleting "+n+" nodes after "+m+" nodes: "+sllOperations);
    }
}
