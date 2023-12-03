package org.sid.neetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public static boolean containsDuplicateSorting(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Invalid input array");

        if (nums.length == 1) return false;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicateHashing(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Invalid input array");

        if (nums.length == 1) return false;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
