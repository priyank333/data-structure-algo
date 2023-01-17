package org.dsa.practice.array;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int k : nums) {
            if (k <= i) {
                i = k;
            } else if (k <= j) {
                j = k;
            } else {
                return true;
            }
        }
        return false;
    }
}
