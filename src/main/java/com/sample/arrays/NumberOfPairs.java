package com.sample.arrays;

import java.util.Arrays;

/**
 * Given two arrays X and Y of positive integers, find the number of pairs such
 * that x^y > y^x (raised to power of) where x is an element from X and y is an
 * element from Y.
 * 
 * Example 1:
 * 
 * Input:
 * M = 3, X[] = [2 1 6]
 * N = 2, Y[] = [1 5]
 * Output: 3
 * Explanation:
 * The pairs which follow xy > yx are
 * as such: 2^1 > 1^2, 2^5 > 5^2 and 6^1 > 1^6.
 * 
 * Example 2:
 * 
 * Input:
 * M = 4, X[] = [2 3 4 5]
 * N = 3, Y[] = [1 2 3]
 * Output: 5
 * Explanation:
 * The pairs for the given input are
 * 2^1 > 1^2 , 3^1 > 1^3 , 3^2 > 2^3 , 4^1 > 1^4 , 5^1 > 1^5
 * 
 * Your Task:
 * This is a function problem. You only need to complete the function
 * countPairs() that takes X, Y, M, N as parameters and returns the total number
 * of pairs.
 * 
 * Expected Time Complexity: O((N + M)log(N)).
 * Expected Auxiliary Space: O(1).
 * 
 * Constraints:
 * 1 ≤ M, N ≤ 105
 * 1 ≤ X[i], Y[i] ≤ 103
 */
public class NumberOfPairs {

  // Function to return count of pairs with x as one
  // element of the pair. It mainly looks for all values
  // in Y[] where x ^ Y[i] > Y[i] ^ x
  static int count(int x, int Y[], int n, int NoOfY[]) {
    // If x is 0, then there cannot be any value in Y
    // such that x^Y[i] > Y[i]^x
    if (x == 0)
      return 0;

    // If x is 1, then the number of pais is equal to
    // number of zeroes in Y[]
    if (x == 1)
      return NoOfY[0];

    // Find number of elements in Y[] with values
    // greater than x getting upperbound of x with
    // binary search
    int idx = Arrays.binarySearch(Y, x);

    int ans;

    if (idx < 0) {
      idx = Math.abs(idx + 1);
      ans = Y.length - idx;
    } else {
      while (idx < n && Y[idx] == x) {
        idx++;
      }
      ans = Y.length - idx;
    }

    // If we have reached here, then x must be greater
    // than 1, increase number of pairs for y=0 and y=1
    ans += (NoOfY[0] + NoOfY[1]);

    // Decrease number of pairs for x=2 and (y=4 or y=3)
    if (x == 2)
      ans -= (NoOfY[3] + NoOfY[4]);
    // Increase number of pairs for x=3 and y=2
    if (x == 3)
      ans += NoOfY[2];
    return ans;
  }

  // Function to returns count of pairs (x, y) such that
  // x belongs to X[], y belongs to Y[] and x^y > y^x

  static long countPairs(int X[], int Y[], int m, int n) {
    // To store counts of 0, 1, 2, 3 and 4 in array Y
    int NoOfY[] = new int[5];
    for (int i = 0; i < n; i++)
      if (Y[i] < 5)
        NoOfY[Y[i]]++;
    // Sort Y[] so that we can do binary search in it
    Arrays.sort(Y);
    long total_pairs = 0; // Initialize result
    // Take every element of X and count pairs with it
    for (int i = 0; i < m; i++)
      total_pairs += count(X[i], Y, n, NoOfY);
    return total_pairs;
  }

  // Driver method
  public static void main(String args[]) {
    int X[] = { 2, 1, 6 };
    int Y[] = { 1, 5 };
    System.out.println("Total pairs = " + countPairs(X, Y, X.length, Y.length));
  }
}