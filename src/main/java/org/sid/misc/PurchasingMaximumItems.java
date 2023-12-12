package org.sid.misc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PurchasingMaximumItems {
    private final int[] input;

    public PurchasingMaximumItems(int[] input) {
        if (input == null || input.length == 0) throw new IllegalArgumentException("Invalid Input");
        this.input = input;
    }

    public static void main(String[] args) {
        System.out.println(new PurchasingMaximumItems(new int[]{1, 12, 5, 111, 200}).bruteForceMaxNumberOfItems(32));
    }

    private int bruteForceMaxNumberOfItems(int targetSum) {
        Arrays.sort(input);
        int residue = targetSum;
        int counter = 0;
        for (int item : input) {
            if (item <= residue) {
                residue = residue - item;
                counter++;
            } else {
                break;
            }
        }

        return counter;
    }

    public int maxNumberOfItems(int targetSum) {
        var minHeap = new PriorityQueue<Integer>();
        for (int num : input) {
            minHeap.add(num);
        }

        int residue = targetSum;
        int counter = 0;
        while (!minHeap.isEmpty()) {
            var item = minHeap.poll();
            if (item <= residue) {
                residue = residue - item;
                counter++;
            } else {
                return counter;
            }
        }

        return counter;
    }
}
