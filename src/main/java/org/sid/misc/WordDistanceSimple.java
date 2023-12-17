package org.sid.misc;

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
}
