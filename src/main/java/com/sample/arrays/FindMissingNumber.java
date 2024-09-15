package com.sample.arrays;

import java.util.Arrays;

/**
 * If ‘n‘ is the positive number and ‘a‘ is an array of integers of length ‘n-1’
 * containing elements from 1 to n. Then find the missing number in ‘a’ in the
 * range from 1 to n. Occurrence of each element is only once. For example, If n
 * = 8, then array ‘a’ will have 7 elements in the range from 1 to 8. For
 * example {1, 4, 5, 3, 7, 8, 6}. One number will be missing in ‘a’ (2 in this
 * case). You have to find out that missing number.
 */
public class FindMissingNumber {

  public static int findMissingNumber(int[] arr, int n) {
    int sum = n * (n + 1) / 2;
    int realSum = Arrays.stream(arr).sum();
    return sum - realSum;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 4, 5, 3, 7, 8, 6 };
    System.out.println(findMissingNumber(arr, 8));
  }
}
