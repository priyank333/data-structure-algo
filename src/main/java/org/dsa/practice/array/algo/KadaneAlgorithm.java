package org.dsa.practice.array.algo;

/**
 * The idea of Kadane’s algorithm is to maintain a variable maxEndingHere that stores the maximum sum contiguous subarray
 * ending at current index and a variable maxSoFar stores the maximum sum of contiguous subarray found so far,
 * Everytime there is a positive-sum value in maxEndingHere compare it with maxSoFar and update maxSoFar
 * if it is greater than maxSoFar.
 */
public class KadaneAlgorithm {
    public static long maxSubArraySum(int[] arr) {
        long maxSoFar = Long.MIN_VALUE;
        long maxEndingHere = 0;
        for (long val : arr) {
            maxEndingHere += val;
            maxEndingHere = maxEndingHere < 0 ? 0 : maxEndingHere;
            maxSoFar = maxSoFar < maxEndingHere ? maxEndingHere : maxSoFar;
        }
        return maxSoFar;
    }
}
