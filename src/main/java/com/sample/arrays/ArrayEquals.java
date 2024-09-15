package com.sample.arrays;

import java.util.Arrays;

import com.sample.AlgorithmBase;

public class ArrayEquals extends AlgorithmBase {

  public void arrayEquals() {
    String[] s1 = { "java", "j2ee", "struts", "hibernate" };

    String[] s2 = { "jsp", "spring", "jdbc", "hibernate" };

    String[] s3 = { "java", "j2ee", "struts", "hibernate" };

    String[] s4 = { "j2ee", "java", "struts", "hibernate" };

    System.out.println(Arrays.equals(s1, s2)); // Output : false

    System.out.println(Arrays.equals(s1, s3)); // Output : true

    System.out.println(Arrays.equals(s1, s4)); // Output : false

    ///////// DeepEquals

    String[][] s5 = { { "java", "swings", "j2ee" }, { "struts", "jsp", "hibernate" } };

    String[][] s6 = { { "java", "swings", "j2ee" }, { "struts", "jsp", "hibernate" } };

    System.out.println(Arrays.deepEquals(s5, s6)); // Output : true

    // Calling equals() method on same arrays will return false

    System.out.println(Arrays.equals(s5, s6)); // Output : false

    // That's why use deepEquals() method to compare multidimensional arrays

  }

  public static void main(String[] args) {
    ArrayEquals test = new ArrayEquals();
    test.arrayEquals();
  }
}
