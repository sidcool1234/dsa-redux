package org.sid.neetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LongestCommonSubsequence {

    // https://leetcode.com/problems/longest-consecutive-sequence/

    public int longestConsecutive(int[] nums) {
        if (nums == null) throw new IllegalArgumentException("Null input array");

        if (nums.length <= 1) return nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        int prevNum = pq.poll();
        int count = 1;
        int finalCount = 1;
        while (!pq.isEmpty()) {
            var num = pq.poll();
            if (num - prevNum == 1) count++;
            else {
                if (num != prevNum) {
                    finalCount = Math.max(count, finalCount);
                    count = 1;
                }
            }
            prevNum = num;
        }

        return Math.max(finalCount, count);

    }

    /**
     * Approach:
     */
    public int longestConsecutiveBruteForce(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums); // Sort the array
        int count = 1;
        int finalCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                if (nums[i] != nums[i - 1]) {
                    finalCount = Math.max(count, finalCount);
                    count = 1;
                }
            }
        }

        return Math.max(count, finalCount);
    }


}
