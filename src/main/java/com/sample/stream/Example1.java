package com.sample.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Example1 {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 2, 1, 3, 4, 5 };
    Set<Integer> duplicateSet = new HashSet<>();
    Arrays.stream(arr)
        // .distinct()
        .filter(e -> !duplicateSet.add(e))
        .peek(System.out::println)
        .boxed()
        .sorted((a, b) -> a.intValue() - b.intValue())
        .peek(System.out::print)
        .collect(Collectors.toList());
  }
}
