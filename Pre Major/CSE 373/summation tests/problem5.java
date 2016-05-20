/*
* Michael Wilson, UW #:1242639, UW ID: mike365
* CSE 373, Assignment #2
* Problem 5
* This class is just for the assistance purposes
* of helping with the runtimes of the given sub problems
* in problem 5
*/
import java.util.*;
import java.lang.*;

public class problem5 {
   public static void main(String[] args) throws Exception {
      intro();
      helper(0, 1);
   }

   // This is just a simple intro to the program
   public static void intro() throws Exception {
      print("This is the intro to the second assignment.");
      Thread.sleep(1000);
      print("This program will deal with analysis of algorithms.");
   }
   
   // This method is used to allow for a nicer print
   public static void print(String s) throws Exception {
      for(int i = 0; i < s.length(); i++) {
         System.out.print(s.charAt(i));
         Thread.sleep(30);
      }
      System.out.println();
   }
   
   // This method is used to allow us to see the runtimes of our individual methods
   public static void helper(int sum, int i) throws Exception {
      for(int k = 0; k < 11; k++) {
         i += (i^k)^k;
         int test = 0;
         System.out.println("This is test number; " + ++test);
         test1(sum, i);
         System.out.println();
         System.out.println("This is test number; " + ++test);
         test2(sum, i);
         System.out.println();
         System.out.println("This is test number; " + ++test);
         test3(sum, i);
         System.out.println();
         System.out.println("This is test number; " + ++test);
         test4(sum, i);
         System.out.println();
         System.out.println("This is test number; " + ++test);
         test5(sum, i);
         System.out.println();
         System.out.println("This is test number; " + ++test);
         test6(sum, i);
         System.out.println();
      }

   }
   
   public static void test1(int sum, int n) {
      long start = System.nanoTime(); //Keeps time for first start
      for(int i = 0; i < n; i++) {
         sum++;
      }
      System.out.println("The sum is: " + sum);
      long end = System.nanoTime(); // Keeps ending time
      double diff = (end - start)/1000000000.0; // Allows for a conversion to seconds
      System.out.println("The time it took to complete this method is: " + diff + "s");
   }
  
   public static void test2(int sum, int n) {
      long start = System.nanoTime(); //Keeps time for first start
      for (int i = 0; i < n; i++) {
         for(int j = 0; j < n; j++) {
            sum++;
         }
      }
      System.out.println("The sum is: " + sum);
      long end = System.nanoTime(); // Keeps ending time
      double diff = (end - start)/1000000000.0; // Allows for a conversion to seconds
      System.out.println("The time it took to complete this method is: " + diff + "s");
   }
   
   public static void test3(int sum, int n) {
      long start = System.nanoTime(); //Keeps time for first start
      for(int i = 0; i < n; i++) {
         for(int j = 0; j < i; j++) {
            sum++;
         }
      }
      System.out.println("The sum is: " + sum);
      long end = System.nanoTime(); // Keeps ending time
      double diff = (end - start)/1000000000.0; // Allows for a conversion to seconds
      System.out.println("The time it took to complete this method is: " + diff + "s");

   }
   
   public static void test4(int sum, int n) {
      long start = System.nanoTime(); //Keeps time for first start 
      for(int i = 0; i < n; i++) {
         for(int j = 0; j < n * n; j++) {
            sum++;
         }
      }
      System.out.println("The sum is: " + sum);
      long end = System.nanoTime(); // Keeps ending time
      double diff = (end - start)/1000000000.0; // Allows for a conversion to seconds
      System.out.println("The time it took to complete this method is: " + diff + "s");

   }
   
   public static void test5(int sum, int n) {
      long start = System.nanoTime(); //Keeps time for first start
      for(int i = 0; i < n; i++) {
         for(int j = 0; j < i; j++) {
            sum++;
         }
         for(int k = 0; k < 8000; k++) {
            sum++;
         }
      }
      System.out.println("The sum is: " + sum);
      long end = System.nanoTime(); // Keeps ending time
      double diff = (end - start)/1000000000.0; // Allows for a conversion to seconds
      System.out.println("The time it took to complete this method is: " + diff + "s");

   }
   
   public static void test6(int sum, int n) {
      long start = System.nanoTime(); //Keeps time for first start
      for(int i = 0; i < n; i++) {
         for(int j = 0; j < i * i; j++) {
            if(j % i == 0) {
               for(int k = 0; k < j; k++) {
                  sum++;
               }
            }
         }
      }
      System.out.println("The sum is: " + sum);
      long end = System.nanoTime(); // Keeps ending time
      double diff = (end - start)/1000000000.0; // Allows for a conversion to seconds
      System.out.println("The time it took to complete this method is: " + diff + "s");

   }
}
