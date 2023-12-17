package org.sid.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63daaa1a0d01fe363b68c8d4
public class WordDistanceSimple {
    public int shortestDistance(String[] words, String word1, String word2) {
        int position1 = -1;
        int position2 = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                position1 = i;
            }

            if (words[i].equals(word2)) {
                position2 = i;
            }

            if (position1 != -1 && position2 != -1) {
                minDist = Math.min(minDist, Math.abs(position1 - position2));
            }
        }
        return minDist;
    }

    public static int shortestDistance(List<String> words, String word1, String word2) {
        // Create a map to store the indices of each word.
        HashMap<String, List<Integer>> wordIndices = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!wordIndices.containsKey(word)) {
                wordIndices.put(word, new ArrayList<>());
            }
            wordIndices.get(word).add(i);
        }

        // Get the indices of the two words.
        List<Integer> word1Indices = wordIndices.get(word1);
        List<Integer> word2Indices = wordIndices.get(word2);

        // Initialize the shortest distance to the length of the list.
        int shortestDistance = Integer.MAX_VALUE;

        // Iterate over the indices of the first word.
        for (int i : word1Indices) {
            // Iterate over the indices of the second word.
            for (int j : word2Indices) {
                // Update the shortest distance to the minimum of the current shortest distance and the distance between the two indices.
                shortestDistance = Math.min(shortestDistance, Math.abs(i - j));
            }
        }
        return shortestDistance;
    }
}
