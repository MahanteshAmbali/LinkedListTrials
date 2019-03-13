package com.leetcode.array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Initialize
        int[] arr0 = {5, 4, 3, 2, 1};

        int[] arr1 = new int[]{6, 7, 8, 9, 10};

        // Get Length
        System.out.println("Arr0 Length: "+arr0.length);
        System.out.println("Arr1 Length: "+arr1.length);

        // Access Element
        System.out.println("Element at index 0 of arr0: "+arr0[0]);
        System.out.println("Element at index 1 of arr1: "+arr1[1]);

        // Iterate
        System.out.println("Contents of arr0: ");
        for(Integer integer : arr0){
            System.out.print(" "+integer);
        }

        System.out.println();

        // Modify at index
        System.out.println("Before modifying element at index 4: "+arr0[4]);

        arr0[4] = 6;
        System.out.println("After modifying element at index 4: "+arr0[4]);

        // Sort
        Arrays.sort(arr0);
        for (int i = 0; i < arr0.length; i++)
            System.out.print(" "+arr0[i]);
    }
}
