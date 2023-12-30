package org.sid.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;

            var res = twoSumSorted(numbers, numbers[i] * -1, i + 1, numbers.length - 1);
            if (res != null && !res.isEmpty()) {
                for (var x : res) {
                    x.add(numbers[i]);
                }
                result.addAll(res);
            }
        }

        return result;
    }

    public List<List<Integer>> twoSumSorted(int[] numbers, int target, int left, int right) {
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                var r = new ArrayList<Integer>();
                r.add(numbers[left]);
                r.add(numbers[right]);
                res.add(r);
                right--;
                left++;
                while (left < right && numbers[left] == numbers[left - 1]) left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
