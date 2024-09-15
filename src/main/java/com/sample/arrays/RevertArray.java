package com.sample.arrays;

import com.sample.AlgorithmBase;

public class RevertArray extends AlgorithmBase {

  public static void revert(String[] arr) {
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      String tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
  }

  public static void main(String[] args) {
    String[] arr = { "This", "is", "absolutely", "a", "good", "story" };
    revert(arr);
    printArray(arr);
  }
}
