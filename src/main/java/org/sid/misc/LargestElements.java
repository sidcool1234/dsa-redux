package org.sid.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestElements {
    private final Integer[] input;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LargestElements(new Integer[]{1, 12, 5, 111, 200}).getKLargestMinHeap(3)));
    }

    public LargestElements(Integer[] input) {
        if (input == null || input.length == 0) throw new IllegalArgumentException("Invalid Input");
        this.input = input;
    }

    // O(n) - BEST APPROACH
    public Integer[] getKLargestMinHeap(int k) {
        if (k <= 0 || k > input.length) throw new IllegalArgumentException("Invalid Input");
        Integer[] result = new Integer[k];
        var minHeap = new PriorityQueue<Integer>();
        minHeap.addAll(Arrays.asList(input).subList(0, k));

        for (int i = k; i < input.length; i++) {
            if (minHeap.peek() == null) break;
            if (input[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(input[i]);
            }
        }

        return minHeap.toArray(new Integer[0]);

    }


    // O(n + klogn)
    public Integer[] getKLargest(int k) {
        if (k <= 0 || k > input.length) throw new IllegalArgumentException("Invalid Input");

        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        maxHeap.addAll(Arrays.asList(input));
        System.out.println(maxHeap);

        Integer[] result = new Integer[k];
        int counter = 0;
        while (!maxHeap.isEmpty() && counter < k) {
            result[counter] = maxHeap.poll();
            counter++;
        }
        return result;

    }

    // O(nlogn)
    private Integer[] getKLargestBruteForce(int k) {
        if (k <= 0 || k > input.length) throw new IllegalArgumentException("Invalid Input");

        Arrays.sort(input, Collections.reverseOrder());
        return Arrays.stream(input).limit(k).toList().toArray(new Integer[0]);
    }
}
