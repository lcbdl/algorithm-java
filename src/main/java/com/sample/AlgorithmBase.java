package com.sample;

import java.util.Arrays;

public class AlgorithmBase {
  public static void printArray(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  public static void printArray(Object[] arr) {
    System.out.println(Arrays.deepToString(arr));
  }

  public static void main(String[] args) {
    int[][][] arr = { { { 1, 2, 3 }, { 2, 3, 4 } }, { { 9, 8, 7 }, { 8, 7, 6 } } };
    System.out.println(Arrays.deepToString(arr));
  }
}
