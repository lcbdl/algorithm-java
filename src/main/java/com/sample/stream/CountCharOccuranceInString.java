package com.sample.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountCharOccuranceInString {

  public static Map<String, Long> countOccurance(String str) {
    Map<String, Long> result = str.chars().mapToObj(c -> String.valueOf((char) c))
        .filter(s -> !s.equals(" "))
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    return result;
  }

  public static void createStreams() {
    Stream<Integer> stream = Arrays.stream(new Integer[] { 1, 2, 3, 5 });
    IntStream stream2 = IntStream.of(1, 2, 3);
  }

  public static void main(String[] args) {
    System.out.println(countOccurance("Java is good programming language."));
  }
}
