package org.dsa.practice.array;

import java.util.*;

/**
 * Given an array of N integers, and an integer K, find the pairs of elements in the array whose sum is equal to K.
 */
public class FindPair {
    public static List<int[]> pairSum(int[] arr, int K) {
        Arrays.sort(arr);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : arr) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.get(arr[i]) - 1);
            int findVal = K - arr[i];
            int keyVal = countMap.getOrDefault(findVal, -1);
            while (keyVal > 0) {
                int[] pair = new int[2];
                pair[0] = arr[i];
                pair[1] = findVal;
                ans.add(pair);
                keyVal--;
            }
        }
        return ans;
    }
}
