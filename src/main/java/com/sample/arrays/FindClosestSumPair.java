package com.sample.arrays;

import java.util.Arrays;

import com.sample.AlgorithmBase;

public class FindClosestSumPair extends AlgorithmBase {

  public static int[] findClosestToZeroSumPair(int[] arr) {
    Arrays.sort(arr);
    int closestSum = Integer.MAX_VALUE;
    int left = 0, right = arr.length - 1;
    int[] closestSumPair = new int[2];
    while (left < right) {
      int sum = arr[left] + arr[right];
      int absSum = Math.abs(sum);
      if (closestSum > absSum) {
        closestSum = absSum;
        closestSumPair[0] = arr[left];
        closestSumPair[1] = arr[right];
      }
      if (sum > 0) {
        right--;
      } else if (sum < 0) {
        left++;
      } else {
        break;
      }
    }
    return closestSumPair;
  }

  public static void main(String[] args) {
    int[] nums = { -3, -4, 6, 8, 1, -5, 7 };
    System.out.print("The original array: ");
    printArray(nums);
    System.out.print("\n The closest to zero pair is: ");
    int[] result = findClosestToZeroSumPair(nums);
    System.out.println(result[0] + " " + result[1]);
  }
}