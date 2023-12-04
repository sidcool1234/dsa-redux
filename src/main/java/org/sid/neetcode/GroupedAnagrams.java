package org.sid.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupedAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

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
