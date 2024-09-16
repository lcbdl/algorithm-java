package com.sample.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given an array arr containing only 0s, 1s, and 2s. Sort the array in
 * ascending order.
 * 
 * Examples:
 * 
 * Input: arr[]= [0, 2, 1, 2, 0]
 * Output: 0 0 1 2 2
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 * 
 * Input: arr[] = [0, 1, 0]
 * Output: 0 0 1
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 * 
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class Sort012 {
  // Function to sort an array of 0s, 1s, and 2s
  public static void sort012(List<Integer> arr) {
    Map<Integer, Long> countMap = arr.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    System.out.println(countMap.toString());
    int zeros = (Optional.ofNullable(countMap.get(0)).orElse(0l)).intValue();
    int ones = Optional.ofNullable(countMap.get(1)).orElse(0l).intValue();
    int twos = Optional.ofNullable(countMap.get(2)).orElse(0l).intValue();

    while (zeros-- > 0)
      System.out.print("0 ");
    while (ones-- > 0)
      System.out.print("1 ");
    while (twos-- > 0)
      System.out.print("2 ");
  }

  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(1, 2, 0, 2, 1, 0, 2, 1, 0);
    sort012(arr);

  }
}
