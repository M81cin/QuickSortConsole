package com.mcz;

import javax.swing.*;
import java.util.Arrays;

/**
 * Creates array and initializes with random numbers,
 * Then sorts the array using Quick Sort algorithm.
 */
public class QuickSort {

    private int sizeOfArray;
    private int[] arr;
    private int noOfExecutions;

    /**
     * Accepts size of the array to create.
     * Creates array of the given size and fills with random numbers.
     */
    public QuickSort(int sizeOfArray) {

        this.sizeOfArray = sizeOfArray;

        arr = new int[sizeOfArray];
        for(int i=0; i<sizeOfArray; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        noOfExecutions = 0;
    }

    /**
     * Executes Quick Sort on the array.
     * Accepts: start and end index determining which part of the array is to be sorted.
     * The pivot point is always considered to be at the end index.
     */
    public void execute(int start, int end) {
        int firstGreater;
        int current;

        System.out.println("[" + noOfExecutions + "]" + this.toString());

        firstGreater = start;
        for(current = start; current < end; current++) {
            if (arr[current] <= arr[end]) {
                if (current != firstGreater){
                    swap(current, firstGreater);
                }
                firstGreater++;
            }

            noOfExecutions++;
            System.out.println("[" + noOfExecutions + "]" + this.toString() + "; pivot=" + end + "; current=" + current);
        }

        // move pivot to target position
        if (firstGreater != end) {
            swap(firstGreater, end);

            noOfExecutions++;
            System.out.println("[" + noOfExecutions + "]" + this.toString() + "; new pivot=" + firstGreater);

            // recursive call for left and right side
            if (firstGreater - 1 > start) {
                execute(start, firstGreater - 1);
            }
            if (firstGreater + 1 < end) {
                execute(firstGreater + 1, end);
            }
        } else {
            // pivot still at end - move it one index to the left
            if (end -1 > start) {
                execute(start, end - 1);
            }
        }

    }

    /**
     * Swaps number at given indexes
     */
    private void swap(int index1, int index2) {
        int temp;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Converts array to string
     */
    @Override
    public String toString() {
        return "QuickSort{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
