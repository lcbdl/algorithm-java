package com.sample.arrays;

import com.sample.AlgorithmBase;

/**
 * Given a sorted array of positive integers. Your task is to rearrange the
 * array elements alternatively i.e first element should be max value, second
 * should be min value, third should be second max, fourth should be second min
 * and so on.
 * 
 * Note: Modify the original array itself. Do it without using any extra space.
 * You do not have to return anything.
 * 
 * Example 1:
 * 
 * Input:
 * n = 6
 * arr[] = {1,2,3,4,5,6}
 * Output: 6 1 5 2 4 3
 * Explanation: Max element = 6, min = 1,
 * second max = 5, second min = 2, and so on...
 * Modified array is : 6 1 5 2 4 3.
 * 
 * Example 2:
 * 
 * Input:
 * n = 11
 * arr[]={10,20,30,40,50,60,70,80,90,100,110}
 * Output:110 10 100 20 90 30 80 40 70 50 60
 * Explanation: Max element = 110, min = 10,
 * second max = 100, second min = 20, and so on...
 * Modified array is :
 * 110 10 100 20 90 30 80 40 70 50 60.
 * 
 * Your Task:
 * The task is to complete the function rearrange() which rearranges elements as
 * explained above. Printing of the modified array will be handled by driver
 * code.
 * 
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 * 
 * Constraints:
 * 1 <= n <= 10^6
 * 1 <= arr[i] <= 10^7
 */
public class RearrangeArrayAlternately extends AlgorithmBase {
  public static void rearrangeArrayAlternately(int[] arr, int n) {
    int MAX = arr[n - 1] + 1;
    int high = n - 1;
    int low = 0;

    /*
     * This solution is based on this theory
     * let a and b are positive integer, and a < b
     * 
     * result = a+b%(b+1)*(b+1)
     * = a + b*(b+1) // because b<b+1, so b%(b+1) equals b
     * 
     * 1. Turn the result back to a
     * r1 = result%(b+1)
     * = (a+b*(b+1))%(b+1)
     * = a%(b+1) + b*(b+1)%(b+1)
     * = a + 0
     * = a
     * 
     * 2. Turn the result back to b
     * r2 = result/(b+1)
     * = (a + b*(b+1))/(b+1)
     * = a/(b+1) + b // because a < (b+1), so a/(b+1) < 1, then it will be 0 after
     * // casting it to int
     * = 0 + b
     * = b
     */

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        long val = arr[high] % MAX * MAX;
        arr[i] += val;
        high--;
      } else {
        long val = arr[low] % MAX * MAX;
        arr[i] += val;
        low++;
      }
    }

    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] / MAX;
    }
  }

  public static void main(String[] args) {
    int[] array = { 1, 4, 6, 9, 10, 13, 15 };
    System.out.println("Before");
    printArray(array);
    rearrangeArrayAlternately(array, array.length);
    System.out.println("\nAfter");
    printArray(array);
  }

}
