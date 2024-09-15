package com.sample.arrays;

import com.sample.AlgorithmBase;

public class FindSecondLargestNumber extends AlgorithmBase {

  public static int findSecondLargestNumber(int[] arr) {
    int firstLargest;
    int secondLargest;
    if (arr[0] >= arr[1]) {
      firstLargest = arr[0];
      secondLargest = arr[1];
    } else {
      firstLargest = arr[1];
      secondLargest = arr[0];
    }
    for (int i = 2; i < arr.length; i++) {
      if (arr[i] >= firstLargest) {
        secondLargest = firstLargest;
        firstLargest = arr[i];
      } else if (arr[i] < firstLargest && arr[i] >= secondLargest) {
        secondLargest = arr[i];
      }
    }
    return secondLargest;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 5, 1, 7, 4, 9 };
    System.out.println(findSecondLargestNumber(arr));
  }
}
