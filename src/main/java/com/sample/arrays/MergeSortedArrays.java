package com.sample.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
  /**
   * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing
   * order. Merge them in sorted order without using any extra space. Modify arr1
   * so that it contains the first N elements and modify arr2 so that it contains
   * the last M elements
   * 
   * @param arr1
   * @param arr2
   */
  public static void mergeSortedArrays(int[] arr1, int[] arr2) {
    int left = arr1.length - 1;
    int right = 0;

    while (left >= 0 && right < arr2.length) {
      if (arr1[left] > arr2[right]) {
        int tmp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = tmp;
        left--;
        right++;
      } else {
        left--;
      }
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }

  public static void main(String[] args) {
    int[] a1 = { 1, 4, 6, 9, 9, 13, 15 };
    int[] a2 = { 8, 9, 12, 14, 18, 19 };
    System.out.println("Before");
    Arrays.stream(a1).forEach(item -> System.out.print(item + " "));
    System.out.println("");
    Arrays.stream(a2).forEach(item -> System.out.print(item + " "));
    mergeSortedArrays(a1, a2);
    System.out.println("\nAfter");
    Arrays.stream(a1).forEach(item -> System.out.print(item + " "));
    System.out.println("");
    Arrays.stream(a2).forEach(item -> System.out.print(item + " "));
  }
}
