package org.dsa.practice.array;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 */
public class MaxProduct {
    public int findMaxProduct(int[] arr) {
        int N = arr.length;
        int min = arr[0], max = arr[0], ans = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], arr[i] * max);
            min = Math.min(arr[i], arr[i] * min);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
