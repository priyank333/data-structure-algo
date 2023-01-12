package org.dsa.practice.array;

/**
 * You are given an array "ARR" of size N. Your task is to find out summation of maximum and minimum number.
 * Try to use minimum comparisons.
 * <p>
 * <p>
 * Solution: Divide and Conquer
 * The idea is to use a divide and conquer approach in order to reduce the number of comparisons.
 * We divide the array into two equal parts and find the maximum and minimum element of each part recursively.
 * Then we compare the maximum and minimum of both parts in order to find the maximum and minimum element of the whole array.
 * <p>
 * Steps:
 * <p>
 * Create a data type that contains two integers as maximum and minimum. The first integer denotes the maximum value
 * whereas the second one denotes the minimum value. Let’s denote the name of this variable as maxMin.
 * Implement a recursive function say findMaxMin(arr, 0, N-1).
 * Finally, return the sum of maximum and minimum.
 * pair<int, int> findMaxMin(arr, left, right):
 * If left == right, i.e. only one element is present in the array, then return {arr[left], arr[right]}.
 * If right == left + 1, i.e. only two elements are present in the array, then:
 * If arr[left] > arr[right], then return {arr[left], arr[right]}.
 * Else, return {arr[right], arr[left]}.
 * Create a mid variable and make mid = (left + right) / 2.
 * Create two more pairs of integers, say leftAns and rightAns in order to store the result of the left half and right
 * half respectively. Call the recursive function from left to mid for the leftAns and mid + 1 to right for the rightAns,
 * i.e. leftAns = findMaxMin(arr, left, mid) and rightAns = findMaxMin(arr, mid+1, right).
 * Finally, return the maximum among the maximum of leftAns and rightAns and minimum among the minimum of leftAns and
 * rightAns i.e. {max(leftAns.first, rightAns.first), min(leftAns.second, rightAns.second)}.
 * Time Complexity
 * O(N), where N is the size of the given array.
 * <p>
 * In the worst case, we will be traversing the whole array, hence the time complexity is O(N).
 * The number of comparisons can be calculated by the recurrence relation,
 * T(N) = T(floor(N / 2)) + T(Ceil(N / 2)) + 2
 * T(1) = 0, T(2) = 1
 * So, if N is a power of 2, we can represent T(N) = 2T(N / 2) + 2
 * So, by solving the above relation, we get T(N) = (3 * N) / 2 - 2
 * So, if N is a power of 2, then the total number of comparisons is (3 * N) / 2 - 2 and if it is not a power of 2,
 * then it will take a few more comparisons, but the difference is not so significant.
 * Space Complexity
 * O(log N), where N is the size of the given array.
 * <p>
 * In the worst case, the number of recursive calls can go up to log N. Hence, the overall space complexity is O(log N).
 */
class Pair<T1, T2> {
    T1 first;
    T2 second;

    Pair(T1 a, T2 b) {
        first = a;
        second = b;
    }
}

public class FindSumMaxMin {
    public static int sumOfMaxMin(int[] arr, int n) {

        /*
            Create a pair of integers maxMin. The first
            integer stores the maximum and the second
            integer stores the minimum element.
        */
        Pair<Integer, Integer> maxMin;

        // Call the recursive function to get the result.
        maxMin = findMaxMin(arr, 0, n - 1);

        // Return the sum of maximum and minimum.
        return maxMin.first + maxMin.second;
    }

    private static Pair<Integer, Integer> findMaxMin(int[] arr, int left, int right) {

        // Base case.
        if (left == right) {
            return new Pair(arr[left], arr[right]);
        }

        /*
            If only two elements are present in the array "arr",
            then compare arr[left] with arr[right] directly.
        */
        else if (right == left + 1) {

            /*
            	If arr[left] > arr[right], then
                return {arr[left], arr[right]}.
            */
            if (arr[left] > arr[right]) {
                return new Pair(arr[left], arr[right]);
            }

            // Else, return {arr[right], arr[left]}.
            else {
                return new Pair(arr[right], arr[left]);
            }
        }

        int mid = (left + right) / 2;

        /*
        	Call the function recursively in the left helf
            and right half of the array.
        */
        Pair<Integer, Integer> leftAns = findMaxMin(arr, left, mid);
        Pair<Integer, Integer> rightAns = findMaxMin(arr, mid + 1, right);

        /*
            Finally, return the maximum among the maximum of leftAns
            and rightAns and minimum among the minimum of
            leftAns and rightAns.
        */
        return new Pair(Math.max(leftAns.first, rightAns.first), Math.min(leftAns.second, rightAns.second));
    }

}
