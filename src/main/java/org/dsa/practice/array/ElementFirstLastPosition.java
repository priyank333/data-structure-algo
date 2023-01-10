package org.dsa.practice.array;

import java.util.ArrayList;

/**
 * First and Last Position of an Element In Sorted Array.
 * You have been given a sorted array ARR consisting of n elements. You are also given an integer K.
 * Your task is to find the first and last occurrence of K in arr.
 */
public class ElementFirstLastPosition {
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int[] ans = new int[]{-1, -1};
        int lower = 0, high = arr.size() - 1;
        int middle;
        // Apply Binary Search
        while (lower <= high) {
            middle = (lower + high) / 2;
            // If middle element is found as K, then go towards left and right to find element start and end index.
            if (arr.get(middle) == k) {
                int iterIdx = middle;
                while (iterIdx <= high && arr.get(iterIdx) == k) {
                    ans[1] = iterIdx;
                    iterIdx++;
                }
                iterIdx = middle;
                while (iterIdx >= lower && arr.get(iterIdx) == k) {
                    ans[0] = iterIdx;
                    iterIdx--;
                }
                return ans;
            } else if (arr.get(middle) < k) {
                lower = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return ans;
    }
}
