/*
 *Shuffle.java 
 */
package edu.cnm.deepdive.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Implements the Fisher Yates shuffle for an 
 * @author caryl
 *
 */
public class Shuffle {

  //constant 
  private static final int DEFAULT_SIZE = 50;
  
  /**
   * Reads a command line argument to create an array of the specified size,
   * then generates sequential values in the array and shuffles them, println
   * out values before and after the shuffle.
   * 
   * @param args command line arguments; first value is the array size default = 50
   */
  public static void main(String[] args) {
    //Terinary 3 parts Boolean arg, value is the integer , DEFAULT_SIZE  result is put into size
    int size = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_SIZE;
    int[] values = generate(size);
    //returns all of the array
    System.out.println(Arrays.toString(values));
    shuffle(values);
    System.out.println(Arrays.toString(values));

    

  }
  //create an array
  //new to create new object
  private static int[] generate(int size) {
    int[] data = new int[size];
    //for loop
    for (int i = 0; i < data.length; i++) {
      data[i] = i + 1;
  }
  return data;
}
  /**
   * Uses the Fisher yates algorithm to shuffle the <code>data</code> array
   * in place.
   * @param data
   */
  public static void shuffle(int[] data) {
    //Random number generate
    Random rng = new Random();
    for (int i = data.length -1; i > 0; i--) {
      //random index for swapping includes 0 but not bound; upper limit
      int source = rng.nextInt(i + 1);
      //take what is in one card num to temp area then move 
      if (source != i) {
        int temp = data[i];
        data[i] = data[source];
        data[source] = temp;
      }
    }
  }
    
}

