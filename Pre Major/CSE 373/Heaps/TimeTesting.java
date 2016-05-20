import java.util.*;
import java.applet.*;
import java.net.*;

/*
* Michael Wilson
* CSE 373
* This class will test the run times of each one of the classes methods
* while supplying soothing background music
* NOTE: I used print statements to indicate implied commentary
*/

public class TimeTesting {
   public static long start;
   public static double diff;
   
   public static void main(String[] args) throws Exception {
      URL url = TimeTesting.class.getResource("wake me up.wav");
      AudioClip clip = Applet.newAudioClip(url);
      Random rnd = new Random();
      try {
         clip.loop();
         System.out.println("We shall first test the run times of the Binary Heap methods");
         System.out.println();
         BinaryHeap(rnd);
         System.out.println("We shall first test the run times of the Three Heap methods");
         System.out.println();
         ThreeHeap(rnd);
         System.out.println("We shall first test the run times of the MyPQ methods");
         System.out.println();
         MyPQ(rnd);
         clip.stop();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 
   // This method will test the timing of several parts of the Binary Heap class
   // This will take in a random object as a parameter
   public static void BinaryHeap(Random rnd) throws Exception{
      BinaryHeap test = new BinaryHeap();
      int number = 4;
      // This shall test the insert method
      while(number < 9) {
         System.out.println("Inserting " + number + " objects");   // crucial to have this before the start time
                                                      // as to not give us incorrect errors  for the 
                                                      // RTE of our methods
         start = System.nanoTime();
         for(int i = 0; i < number; i++) {
            int random = rnd.nextInt(number) + 1 ;
            test.insert(random);
         }
         number++;
         diff = (System.nanoTime() - start) / (1000000000.0);
         System.out.println(test.toString());
         System.out.println("The time it took to complete this method was " + diff + " seconds");
         test = new BinaryHeap();
         System.out.println();
      }
      
      System.out.println("Seems good!");
      System.out.println("We're going to kill two birds with one stone!");
      System.out.println("Now we shall test the resize and makeEmpty methods");
      System.out.println("The array should double in size once we reach the maximum initial capacity!");
      System.out.println("After we double the size of the array we will clear all the elements in the array!");
      System.out.println();
      while(number < 15) {
         test = new BinaryHeap();
         System.out.println("Test number: " + (number - 8));
         for(int i = 1; i <= 10; i++) {
            if(i == 10) {
               System.out.println(test.toString());
               System.out.println("We've hit the max capacity, so the size of this collection space should double!");
               start = System.nanoTime();
               test.insert(rnd.nextInt(12) + 1);
               diff = (System.nanoTime() - start) / (1000000000.0);
               System.out.println(test.toString());
               System.out.println("The time it took to complete this method was " + diff + " seconds");            
            }         
            test.insert(rnd.nextInt(12) + 1);
         }
         System.out.println();
         System.out.println("We are going to clear all of the elements");
         start = System.nanoTime();
         test.makeEmpty();
         diff = (System.nanoTime() - start) / (1000000000.0);
         System.out.println(test.toString());
         System.out.println("The time it took to complete this method was " + diff + " seconds");  
         System.out.println();          
         number++;
      }
      test.insert(3);
      test.insert(2);
      test.insert(2);
      System.out.println(test.toString());
      
      // This will test the RT of findMin
      System.out.println("Now we shall test the run times of findMin() and deleteMin() ");
      start = System.nanoTime();
      test.findMin();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
      
      // This will test the RT of the deletemin
      start = System.nanoTime();
      test.deleteMin();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println(test.toString());
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
      
      // This will test for the size function
      start = System.nanoTime();
      test.size();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println(test.toString());
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
   }
   
   // This method will test the timing of several parts of the Three Heap class
   // This will take in a random object as a parameter
   public static void ThreeHeap(Random rnd) throws Exception {
      ThreeHeap test = new ThreeHeap();
      // This shall test the insert method four times
      int number = 4;
      while(number < 9) {
         System.out.println("Inserting " + number + " objects");
         start = System.nanoTime();
         for(int i = 0; i < number; i++) {
            int random = rnd.nextInt(number) + 1;
            test.insert(random);
         }
         number++;
         diff = (System.nanoTime() - start) / (1000000000.0);
         System.out.println(test.toString());
         System.out.println("The time it took to complete this method was " + diff + " seconds");
         test = new ThreeHeap();
         System.out.println();
      }
            
      System.out.println("Seems good!");
      System.out.println("We're going to kill two birds with one stone!");
      System.out.println("Now we shall test the resize and makeEmpty methods");
      System.out.println("The array should double in size once we reach the maximum initial capacity!");
      System.out.println("After we double the size of the array we will clear all the elements in the array!");
      System.out.println();
      while(number < 15) {
         test = new ThreeHeap();
         System.out.println("Test number: " + (number - 8));
         for(int i = 1; i <= 10; i++) {
            if(i == 10) {
               System.out.println(test.toString());
               System.out.println("We've hit the max capacity, so the size of this collection space should double!");
               start = System.nanoTime();
               test.insert(rnd.nextInt(12) + 1);
               diff = (System.nanoTime() - start) / (1000000000.0);
               System.out.println(test.toString());
               System.out.println("The time it took to complete this method was " + diff + " seconds");            
            }         
            test.insert(rnd.nextInt(12) + 1);
         }
         System.out.println();
         System.out.println("We are going to clear all of the elements");
         start = System.nanoTime();
         test.makeEmpty();
         diff = (System.nanoTime() - start) / (1000000000.0);
         System.out.println(test.toString());
         System.out.println("The time it took to complete this method was " + diff + " seconds");  
         System.out.println();          
         number++;
      }
      test.insert(3);
      test.insert(2);
      test.insert(2);
      System.out.println(test.toString());
      
      // This will test the RT of findMin
      System.out.println("Now we shall test the run times of findMin() and deleteMin() ");
      start = System.nanoTime();
      test.findMin();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
      
      // This will test the RT of the deletemin
      start = System.nanoTime();
      test.deleteMin();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println(test.toString());
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
      
      // This will test for the size function
      start = System.nanoTime();
      test.size();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println(test.toString());
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
   }
   
   // This method will test the timing of several parts of the MyPq class
   // This will take in a random object as a parameter
   public static void MyPQ(Random rnd) throws Exception {
      start = System.nanoTime();
      MyPQ test = new MyPQ();
      // This shall test the insert method four times
      int number = 4;
      while(number < 9) {
      System.out.println("Inserting " + number + " objects");
      start = System.nanoTime();
         for(int i = 0; i < number; i++) {
            int random = rnd.nextInt(number) + 1;
            test.insert(random);
         }
         number++;   
         diff = (System.nanoTime() - start) / (1000000000.0);
         print(test.toString());
         System.out.println("The time it took to complete this method was " + diff + " seconds");
         test = new MyPQ();  
         System.out.println();
      }
            
      System.out.println("Seems good!");
      System.out.println("We're going to kill two birds with one stone!");
      System.out.println("Now we shall test the resize and makeEmpty methods");
      System.out.println("The array should double in size once we reach the maximum initial capacity!");
      System.out.println("After we double the size of the array we will clear all the elements in the array!");
      System.out.println();
      while(number < 15) {
         test = new MyPQ();
         print("Test number: " + (number - 8));
         for(int i = 1; i <= 10; i++) {
            if(i == 10) {
               print(test.toString());
               System.out.println("We've hit the max capacity, but we are using a linkedlist so we don't need to double capacity.");
               start = System.nanoTime();
               test.insert(rnd.nextInt(12) + 1);
               diff = (System.nanoTime() - start) / (1000000000.0);
               print(test.toString());
               System.out.println("The time it took to complete this method was " + diff + " seconds");            
            }         
            test.insert(rnd.nextInt(12) + 1);
         }
         System.out.println();
         System.out.println("We are going to clear all of the elements");
         start = System.nanoTime();
         test.makeEmpty();
         diff = (System.nanoTime() - start) / (1000000000.0);
         print(test.toString());
         System.out.println("The time it took to complete this method was " + diff + " seconds");  
         System.out.println();          
         number++;
      }
      test.insert(3);
      test.insert(2);
      test.insert(2);
      print(test.toString());
      
      // This will test the RT of findMin
      System.out.println("Now we shall test the run times of findMin() and deleteMin() ");
      start = System.nanoTime();
      test.findMin();
      diff = (System.nanoTime() - start) / (1000000000.0);
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
      
      // This will test the RT of the deletemin
      start = System.nanoTime();
      test.deleteMin();
      diff = (System.nanoTime() - start) / (1000000000.0);
      print(test.toString());
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
      
      // This will test for the size function
      start = System.nanoTime();
      test.size();
      diff = (System.nanoTime() - start) / (1000000000.0);
      print(test.toString());
      System.out.println("The time it took to complete this method was " + diff + " seconds");  
      System.out.println();
   }
      
   public static void print(String s) throws InterruptedException {
      for(int i = 0; i < s.length(); i++) {
         System.out.print(s.charAt(i));
         Thread.sleep(30);
      }
      System.out.println();
   }

}