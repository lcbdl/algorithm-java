package com.sample.arrays;

import java.util.Arrays;

import com.sample.AlgorithmBase;

public class FindThePairs extends AlgorithmBase {

  public static void findThePairs(int[] arr, int x) {
    Arrays.sort(arr);
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      if (arr[i] + arr[j] == x) {
        System.out.println("Found pairs: " + arr[i] + " " + arr[j]);
        i++;
        j--;
      } else if (arr[i] + arr[j] > x) {
        j--;
      } else {
        i++;
      }
    }

  }

  public static void main(String[] args) {
    System.out.println("First: ");
    findThePairs(new int[] { 4, 6, 5, -10, 8, 5, 20 }, 10);
    System.out.println("Second: ");
    findThePairs(new int[] { 4, -5, 9, 11, 25, 13, 12, 8 }, 20);
    System.out.println("Third: ");
    findThePairs(new int[] { 12, 13, 10, 15, 8, 40, -15 }, 25);
    System.out.println("Fourth: ");
    findThePairs(new int[] { 12, 23, 10, 41, 15, 38, 27 }, 50);
  }
}
