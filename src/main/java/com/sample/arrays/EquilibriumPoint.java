package com.sample.arrays;

import com.sample.AlgorithmBase;

/**
 * Given an array arr of non-negative numbers. The task is to find the first
 * equilibrium point in an array. The equilibrium point in an array is an index
 * (or position) such that the sum of all elements before that index is the same
 * as the sum of elements after it.
 * 
 * Note: Return equilibrium point in 1-based indexing. Return -1 if no such
 * point exists.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 3, 5, 2, 2]
 * Output: 3
 * Explanation: The equilibrium point is at position 3 as the sum of elements
 * before it (1+3) = sum of elements after it (2+2).
 * 
 * Input: arr[] = [1]
 * Output: 1
 * Explanation: Since there's only one element hence it's only the equilibrium
 * point.
 * 
 * Input: n = 3, arr[] = [1, 2, 3]
 * Output: -1
 * Explanation: There is no equilibrium point in the given array.
 * 
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 * 
 * Constraints:
 * 1 <= arr.size <= 105
 * 0 <= arr[i] <= 109
 */
public class EquilibriumPoint extends AlgorithmBase {

  public static int findEquilibriumPoint(long[] arr) {
    if (arr.length == 1) {
      return 1;
    }

    long sum = 0;
    for (long i : arr) {
      sum += i;
    }

    long leftSum = 0;
    int i = 0;
    long rightSum = sum - arr[i];
    while (leftSum != rightSum && i < arr.length - 1) {
      i++;
      leftSum += arr[i - 1];
      rightSum -= arr[i];
    }
    int point = leftSum == rightSum && i < arr.length ? i + 1 : -1;
    return point;
  }

  public static void main(String[] args) {
    long[] arr = { 4, 5, 7 };
    int point = findEquilibriumPoint(arr);

    System.out.print("The array is: ");
    printArray(arr);
    System.out.println("The equilibrium point is: " + point);

    arr = new long[] { 1, 3, 5, 2, 2 };
    point = findEquilibriumPoint(arr);

    System.out.print("The array is: ");
    printArray(arr);
    System.out.println("The equilibrium point is: " + point);
  }

}
