package org.dsa.practice.array.algo;

/**
 * The idea of Kadane’s algorithm is to maintain a variable maxEndingHere that stores the maximum sum contiguous subarray
 * ending at current index and a variable maxSoFar stores the maximum sum of contiguous subarray found so far,
 * Everytime there is a positive-sum value in maxEndingHere compare it with maxSoFar and update maxSoFar
 * if it is greater than maxSoFar.
 */
public class KadaneAlgorithm {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int val : arr) {
            maxEndingHere += val;
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
