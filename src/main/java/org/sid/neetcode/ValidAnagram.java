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

    // O(n)
    public static boolean isAnagramOptimised(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
