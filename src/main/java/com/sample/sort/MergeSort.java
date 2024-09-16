package com.sample.sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.sample.AlgorithmBase;

public class MergeSort extends AlgorithmBase {

  private static int[] merge(int[] arr1, int[] arr2) {
    int[] arr = new int[arr1.length + arr2.length];
    int i = 0;
    int j = 0;
    int idx = 0;
    while (idx < arr1.length + arr2.length) {
      if (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
          arr[idx] = arr1[i];
          i++;
        } else {
          arr[idx] = arr2[j];
          j++;
        }
      } else {
        if (i < arr1.length) {
          arr[idx] = arr1[i];
          i++;
        } else {
          arr[idx] = arr2[j];
          j++;
        }
      }
      idx++;
    }
    return arr;
  }

  private static int[] merge2(int[] arr1, int[] arr2) {
    int[] arr = new int[arr1.length + arr2.length];

    int i = 0;
    int x = 0;
    int y = 0;
    while (x < arr1.length && y < arr2.length) {
      if (arr1[x] < arr2[y]) {
        arr[i] = arr1[x];
        x++;
        i++;
      } else if (arr2[y] < arr1[x]) {
        arr[i] = arr2[y];
        y++;
        i++;
      } else {
        arr[i] = arr1[x];
        i++;
        arr[i] = arr1[x];
        i++;
        x++;
        y++;
      }
    }
    while (x < arr1.length) {
      arr[i] = arr1[x];
      i++;
      x++;
    }
    while (y < arr2.length) {
      arr[i] = arr2[y];
      i++;
      y++;
    }
    return arr;
  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length > 1) {
      int halfLen = arr.length / 2;
      int[] arr1 = Arrays.copyOfRange(arr, 0, halfLen);
      int[] arr2 = Arrays.copyOfRange(arr, halfLen, arr.length);
      if (arr1.length > 1) {
        arr1 = mergeSort(arr1);
      }
      if (arr2.length > 1) {
        arr2 = mergeSort(arr2);
      }
      arr = merge(arr1, arr2);
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = new int[9];
    Random rand = new Random();
    for (int i = 0; i < 9; i++) {
      arr[i] = rand.nextInt(20);
    }
    System.out.print("\nBefore: ");
    Date start = new Date();
    printArray(arr);

    arr = mergeSort(arr);
    Date end = new Date();
    System.out.print("After: ");
    printArray(arr);
    System.out.println((end.getTime() - start.getTime()) + " ms");
  }

}
