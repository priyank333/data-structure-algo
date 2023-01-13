package org.dsa.practice.array;

/**
 * For a given array of size N contains all distinct value. Find total number of inversions.
 * Following conditions are met to make inversion.
 * 1. ARR[i] > ARR[j]
 * 2. i < j
 * <p>
 * Solution: Apply to merge sort technique. While merging count total number of inversions.
 */
public class InversionCount {
    public static long merge(long[] arr, int left, int mid, int right) {
        long inversionCount = 0;
        long[] temp = new long[(right - left + 1)];
        int i = left, j = mid, k = 0;
        while ((i < mid) && (j <= right)) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
                inversionCount += (mid - i);
            }
        }
        while (i < mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
        return inversionCount;
    }

    public static long mergeSort(long[] arr, int left, int right) {
        long inversionCount = 0;
        if (right > left) {
            int mid = (left + right) / 2;
            inversionCount = mergeSort(arr, left, mid);
            inversionCount += mergeSort(arr, mid + 1, right);
            inversionCount += merge(arr, left, mid + 1, right);
        }
        return inversionCount;
    }

    public static long getInversion(long[] arr, int n) {
        return mergeSort(arr, 0, n - 1);
    }
}
