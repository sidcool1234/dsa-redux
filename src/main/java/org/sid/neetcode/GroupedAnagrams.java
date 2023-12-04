package org.sid.neetcode;

import java.util.*;

public class GroupedAnagrams {

    // O(n * m log m) -> n is the size of array, m is the average length of individual string
    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("Invalid input array, either null or empty");
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = String.valueOf(strChars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // O(n^2 * k) -> n is the size of array, k is the average size of string (Timelimit exceeded in LC)
    public List<List<String>> groupAnagramsBruteForce(String[] strs) {

        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException("Invalid input array, either null or empty");
        }

        List<List<String>> groupedList = new ArrayList<>(strs.length);
        boolean[] isChecked = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>(strs.length);
            if (isChecked[i]) continue;
            list.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (ValidAnagram.isAnagramOptimised(strs[i], strs[j])) {
                    isChecked[j] = true;
                    list.add(strs[j]);
                }
            }
            groupedList.add(list);
        }

        return groupedList;
    }
}
