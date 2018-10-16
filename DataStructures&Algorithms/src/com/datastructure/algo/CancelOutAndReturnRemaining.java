package com.datastructure.algo;

public class CancelOutAndReturnRemaining {

    public static void main(String[] args){

        SingleLinkedListOperations sllOperations = new SingleLinkedListOperations();

        // ADD ITEMS TO LINKED LIST
        sllOperations.add(10);
        sllOperations.add(20);
        sllOperations.add(-30);
        sllOperations.add(40);
        sllOperations.add(50);
        sllOperations.add(-90);
        sllOperations.add(70);
        sllOperations.add(80);
        sllOperations.add(90);
        sllOperations.add(-170);
        sllOperations.add(100);

        // PRINT
        System.out.println("Before cancelling elements with same sum: "+sllOperations);

        sllOperations.cancelOut();

        System.out.println("After cancelling elements with same sum: "+sllOperations);
    }
}
