package org.sid.lc;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return nums;

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int productPrefix = 1;
        int productPostfix = 1;

        for (int i = 0; i < nums.length; i++) {
            productPrefix = productPrefix * nums[i];
            prefix[i] = productPrefix;

            int j = nums.length - i - 1;
            productPostfix = productPostfix * nums[j];
            postfix[j] = productPostfix;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) result[i] = postfix[i + 1];
            else if (i == nums.length - 1) result[i] = prefix[i - 1];
            else {
                result[i] = prefix[i - 1] * postfix[i + 1];
            }
        }
        return result;
    }
}
