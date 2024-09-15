package com.sample.sort;

import com.sample.AlgorithmBase;

public class InsertSort extends AlgorithmBase {

  public static void sort(int[] arr) {
    int current;
    for (int i = 1; i < arr.length; i++) {
      current = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > current) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = current;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 8, 3, 6, 1, 4, 2, 10, 5, 7 };
    InsertSort.sort(arr);
    printArray(arr);
  }
}
