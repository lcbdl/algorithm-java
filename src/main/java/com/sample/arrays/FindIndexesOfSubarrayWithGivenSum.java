package com.sample.arrays;

import java.util.ArrayList;
import java.util.List;

import com.sample.AlgorithmBase;

/**
 * 
 * Given an unsorted array A of size N that contains only non negative integers,
 * find a continuous sub-array that adds to a given number S and return the left
 * and right index(1-based indexing) of that subarray.
 * 
 * In case of multiple subarrays, return the subarray indexes which comes first
 * on moving from left to right.
 * 
 * Note:- You have to return an ArrayList consisting of two elements left and
 * right. In case no such subarray exists return an array consisting of element
 * -1.
 */

public class FindIndexesOfSubarrayWithGivenSum extends AlgorithmBase {

  public static void main(String[] args) {
    int[] A = { 1, 4, 20, 3, 10, 5, 18 };
    int S = 33;
    List<Integer> result = findIndexesOfSubarrayWithGivenSum2(A, S);
    printArray(result.toArray());
  }

  public static List<Integer> findIndexesOfSubarrayWithGivenSum2(int[] arr, int s) {
    List<Integer> result = new ArrayList<>();
    int left = 0;
    int right = left + 1;
    int sum = 0;
    while (right < arr.length) {
      sum = arr[left];
      while (sum < s && right < arr.length) {
        sum += arr[right];
        right++;
      }
      if (sum > s) {
        left++;
        right = left + 1;
      } else { // sum == s
        result.add(left);
        result.add(right - 1);
        return result;
      }
    }
    result.add(-1);
    return result;

  }

  public static ArrayList<Integer> findIndexesOfSubarrayWithGivenSum(int[] arr, int s) {
    ArrayList<Integer> result = new ArrayList<>();
    int left = 0, right = 0;
    int sum = 0;
    while (right < arr.length) {
      sum += arr[right];
      while (sum > s) {
        sum -= arr[left];
        left++;
      }
      if (s == sum) {
        result.add(left);
        result.add(right);
        return result;
      }
      right++;
    }
    result.add(-1);
    return result;
  }

}
