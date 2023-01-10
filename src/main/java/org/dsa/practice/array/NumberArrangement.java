package org.dsa.practice.array;

/**
 * Move All Negative Numbers To Beginning And Positive To End.
 * O(n) : Runtime Complexity
 * O(1) : Space Complexity
 */
public class NumberArrangement {
    public static void separateNegativeAndPositive(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] < 0 && arr[right] < 0) {
                //Case 1: If both ‘LEFT’ and ‘RIGHT’ pointers point to negative elements, then simply increment the
                //left pointer.
                left++;
            } else if (arr[left] >= 0 && arr[right] < 0) {
                //Case 2: If the ‘LEFT’ pointer points to positive element and ‘RIGHT’ pointer points to negative element,
                //then swap the two elements and increment the left pointer and decrement the right pointer.
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] >= 0 && arr[right] >= 0) {
                //Case 3: If both ‘LEFT’ and ‘RIGHT’ pointers point to positive elements, then simply decrement the
                //right pointer.
                right--;
            } else {
                //Case 4: Otherwise the ‘LEFT’ pointer points to the negative element and ‘RIGHT’ pointer points to the
                //positive element, then we increment the left pointer and decrement the right pointer.
                left++;
                right--;
            }
        }
    }
}
