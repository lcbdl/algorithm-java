package com.sample.arrays;

import java.util.ArrayList;
import java.util.Arrays;

import com.sample.AlgorithmBase;

public class FindDuplicates extends AlgorithmBase {
  /*
   * Find duplicates in an array
   * 
   * Given an array a of size N which contains elements from 0 to N-1, you need to
   * find all the elements occurring more than once in the given array. Return the
   * answer in ascending order. If no such element is found, return list
   * containing [-1].
   * 
   * Note: The extra space is only for the array to be returned. Try and perform
   * all operations within the provided array.
   */

  // Solution 1
  public static ArrayList<Integer> findDuplicates(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    Arrays.sort(arr);
    int i = 0;
    while (i < arr.length - 1) {
      int j = i + 1;
      while (j < arr.length && arr[i] == arr[j]) {
        j++;
      }
      if (j > i + 1) {
        result.add(arr[i]);
      }
      i = j;
    }
    if (result.size() == 0) {
      result.add(-1);
    }
    return result;
  }

  // Solution 2
  public static ArrayList<Integer> findDuplicates2(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int index = Math.abs(arr[i]);
      if (arr[index] < 0) {
        result.add(index);
      } else {
        arr[index] = -arr[index];
      }
    }
    if (result.size() == 0) {
      result.add(-1);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] c = { 0 };
    // findDuplicates(a).forEach(item -> System.out.println(item));
    printArray(findDuplicates2(c).toArray());
    int[] a = { 0, 3, 1, 2 };
    // findDuplicates(a).forEach(item -> System.out.println(item));
    printArray(findDuplicates2(a).toArray());
    int[] b = { 0, 0, 2, 4, 3, 5, 1, 3, 5, 6 };
    // findDuplicates(b).forEach(item -> System.out.println(item));
    printArray(findDuplicates2(b).toArray());
  }
}
