package org.dsa.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> answers = new ArrayList<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int j = i + 1, k = N - 1;
                int tar = target - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == tar) {
                        answers.add(List.of(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < tar) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return answers;
    }
}
