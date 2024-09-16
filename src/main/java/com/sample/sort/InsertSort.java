package com.sample.sort;

import com.sample.AlgorithmBase;

public class InsertSort extends AlgorithmBase {

  public static void inserSort(int[] arr) {
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

  public static void bubbleSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i - 1;
      while (j >= 0 && arr[j] > arr[j + 1]) {
        int tmp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = tmp;
        j--;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = { 8, 3, 6, 1, 4, 2, 10, 5, 7 };
    InsertSort.bubbleSort(arr);
    printArray(arr);
  }
}
