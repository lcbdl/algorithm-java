package com.sample;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

/**
 * Least Recently Used Cache
 * 
 */
public class LRUCache {
  private final int capacity = 5;
  // LinkedHashSet maintains the order of elements
  private LinkedHashSet<String> cache = new LinkedHashSet<>(capacity);

  public void put(String value) {
    if (cache.contains(value)) {
      cache.remove(value);
    } else if (cache.size() == capacity) {
      try {
        cache.removeFirst();
      } catch (NoSuchElementException e) {

      }
    }
    cache.add(value);
  }

  public String toString() {
    return String.join("-", this.cache);
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache();
    String[] input = new String[] { "A", "D", "C", "B", "C", "A" };
    Arrays.stream(input).forEach(item -> cache.put(item));
    System.out.println(cache.toString());
  }
}
