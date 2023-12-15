package org.sid.misc;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Two pointer technique
public class ReverseVowels {
    public String reverseVowels(String s) {

        IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        if (s == null || s.isEmpty()) return s;

        Set<Character> vowels = getVowels();
        var charArray = s.toCharArray();

        int leftPointer = 0;
        int rightPointer = charArray.length - 1;

        while (leftPointer < rightPointer) {
            if (vowels.contains(charArray[leftPointer]) && vowels.contains(charArray[rightPointer])) {
                swap(charArray, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
                continue;
            }

            if (!vowels.contains(charArray[leftPointer])) {
                leftPointer++;
            }

            if (!vowels.contains(charArray[rightPointer])) {
                rightPointer--;
            }

        }

        return String.valueOf(charArray);
    }

    private Set<Character> getVowels() {
        return Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    }

    private void swap(char[] charArray, int leftPointer, int rightPointer) {
        var temp = charArray[leftPointer];
        charArray[leftPointer] = charArray[rightPointer];
        charArray[rightPointer] = temp;
    }
}

