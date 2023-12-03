package org.sid.neetcode;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/description/

/**
 * Alternate solution is like bucket sort.  In O(n)
 */
public class ValidAnagram {

    // O(nlogn)
    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;

        var sChar = s.toCharArray();
        var tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }
}
