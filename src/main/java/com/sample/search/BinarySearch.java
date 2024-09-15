package com.sample.search;

import com.sample.AlgorithmBase;

public class BinarySearch extends AlgorithmBase {

  public static int search(int[] arr, int target) {
    return search(arr, 0, arr.length - 1, target);
  }

  private static int search(int[] arr, int start, int end, int target) {
    if (start == end) {
      if (arr[start] == target) {
        return start;
      } else {
        return -1;
      }
    }
    int mid = (end - start) / 2 + start;
    System.out.println("start=" + start + ", end=" + end + ", mid=" + mid);
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] > target) {
      return search(arr, start, mid - 1, target);
    } else {
      return search(arr, mid + 1, end, target);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 5, 6, 8, 10 };
    int result = search(arr, 10);
    System.out.println(result);
  }

}
