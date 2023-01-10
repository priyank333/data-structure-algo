package org.dsa.practice.array;

/**
 * Given an array of integers. All numbers occur twice except one number which occurs once.
 * Find the number in O(n) time & constant extra space.
 */
public class FindUnique {
    public static int findUnique(int[] arr) {
        int ans = arr[0];
        // Use XOR to find unique element
        for (int i = 1; i < arr.length; i++) {
            ans ^= arr[i];
        }
        return ans;
    }
}