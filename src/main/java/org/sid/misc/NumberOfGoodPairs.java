package org.sid.misc;

import java.util.*;
import java.util.Map.*;

// https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63dac2b3bbc58b880202c251
public class NumberOfGoodPairs {
    public int numGoodPairs(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Null or empty array");

        int pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Entry<Integer, Integer> e : map.entrySet()) {
            var size = e.getValue();
            if (size <= 1) continue;

            pairCount = pairCount + (factorial(size) / (2 * factorial(size - 2)));
        }

        return pairCount;
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
