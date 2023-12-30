package org.sid.neetcode;

public class TwoSumSorted {

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    public int[] twoSumSorted(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("Invalid input array");

        // Two Pointer technique.  Sorted array, so move pointer based on if the sum is less than or
        // greater than the target
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}
