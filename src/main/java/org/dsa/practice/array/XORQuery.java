package org.dsa.practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume you initially have an empty array say ‘ARR’.
 * You need to return the updated array provided that some ‘Q’ number of queries were performed on this array.
 * The queries are of two types:
 * 1. 1 ‘VAL’, for this type of query, you need to insert the integer 'VAL' to the end of the array.
 * 2. 2 ‘VAL’, for this type of query, you need to take the bitwise XOR of all the elements of the array with 'VAL'
 * i.e each element of the array ‘ARR’ will be updated as ‘ARR[i]’ = ‘ARR[i]’ ^ ‘VAL’ ( ^ denotes the bitwise XOR operation).
 */
public class XORQuery {
    public static ArrayList<Integer> xorQuery(ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int xorValue = 0;
        for (List<Integer> query : queries) {
            if (query.get(0) == 1) {
                ans.add(query.get(1) ^ xorValue);
            } else {
                xorValue ^= query.get(1);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) ^ xorValue);
        }
        return ans;
    }
}
