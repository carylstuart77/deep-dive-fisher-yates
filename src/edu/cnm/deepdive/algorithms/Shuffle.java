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
  private static final String NO_INPUT_MESSAGE = "No size specified; using";
  private static final String BAD_INPUT_MESSAGE = "Could not parse \"%s\" as";
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
    
    int size = DEFAULT_SIZE;
    try {
      size = getSize(args);
    }
    catch (NumberFormatException ex) {
      System.out.printf(BAD_INPUT_MESSAGE, args[0], DEFAULT_SIZE);
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.printf(NO_INPUT_MESSAGE, DEFAULT_SIZE);
    }

    int[] values = generate(size);
    //returns all of the array
    System.out.println(Arrays.toString(values));
    shuffle(values);
    System.out.println(Arrays.toString(values));

  }
  /*private static int getSize(String[] args) {
    int size = DEFAULT_SIZE;
    //try-catch clause is to handle exception; try is : (try) this is what I want to do BUT need to do another thing (catch).
    try {
      size = Integer.parseInt(args[0]);
    } catch (NumberFormatException ex) {
      System.out.printf("Could not parse \"%s\" as an int; using default value (%d).%n", args[0], DEFAULT_SIZE);
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.printf("No size specified; using default value (%d).%n", DEFAULT_SIZE);
    }
    return size;
  }*/
  private static int getSize(String[] args) 
   throws ArrayIndexOutOfBoundsException, NumberFormatException {
    return Integer.parseInt(args[0]);
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

