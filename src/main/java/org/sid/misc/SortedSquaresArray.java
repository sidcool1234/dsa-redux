package org.sid.misc;


// https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638e39bd1756319ef156bebc
// Two Pointer
public class SortedSquaresArray {
    public static int[] makeSquares(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        int n = arr.length;
        int[] squares = new int[n];
        int left = 0;
        int right = n - 1;
        int pointer = n - 1;

        while (left <= right) {
            if (Math.abs(arr[left]) < Math.abs(arr[right])) {
                squares[pointer] = arr[right] * arr[right];
                right--;
            } else {
                squares[pointer] = arr[left] * arr[left];
                left++;
            }
            pointer--;
        }
        return squares;
    }
}
