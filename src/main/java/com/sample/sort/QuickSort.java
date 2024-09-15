package com.sample.sort;

import java.util.Random;

import com.sample.AlgorithmBase;

public class QuickSort extends AlgorithmBase {

  private static int getPivot(int[] arr, int start, int end) {
    Random rand = new Random();
    int randIdx = rand.nextInt(end - start) + start;
    swap(arr, randIdx, end);
    return arr[end];
  }

  private static void swap(int[] arr, int index1, int index2) {
    if (index1 != index2) {
      int tmp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = tmp;
    }
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = getPivot(arr, start, end);
    int left = start;
    int right = end;
    while (left < right) {
      while (arr[left] <= pivot && left < right) {
        left++;
      }
      while (arr[right] >= pivot && left < right) {
        right--;
      }
      swap(arr, left, right);
    }
    swap(arr, left, end);
    return left;
  }

  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int pIndx = partition(arr, start, end);
    quickSort(arr, start, pIndx - 1);
    quickSort(arr, pIndx + 1, end);
  }

  public static void main(String[] args) {
    Random rand = new Random();
    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }

    System.out.println("Before: ");
    printArray(numbers);

    quickSort(numbers);

    System.out.println("After: ");
    printArray(numbers);
  }
}
