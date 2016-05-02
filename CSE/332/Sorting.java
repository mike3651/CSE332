/**
 * Michael Wilson
 * Sorting algorithm UI program.
 */
import java.util.*; 
import java.io.*; 
 
/**
 * This class goes through multiple sorting algorithms and tests them.
 *
 * @author Michael Wilson
 * @version 1.0
 */
public class Sorting {
   /** The size of the array. */
   public static final int SIZE = 10;
   
   /** Allows us to add random numbers. */ 
   private static final Random RAND = new Random();
   
   /** Strin gof the sorting algorithms. */
   private static final String[] ALGORITHMS = {"Inserton", "Merge"};
   
   /** Scanner to be used throughout the program. */
   private static final Scanner scan = new Scanner(System.in);

   /** Array to sort.*/
   private static int[] numbers = new int[SIZE];
   
   /** Keeps track of the users responces. */
   private static int responce;

      
   /**
    * Executes the entire program.
    *
    * @param theArgs Arguments from the command line.
    */
   public static void main(String[] args) throws InterruptedException {    
      UI();     
   }
   
   /** 
    * Method that initializes the program.
    */
   private static void initialize() throws InterruptedException {
      fill();
      System.out.print("The original array : ");
      printArray();
   }
   
   /** 
    * Method that asks the user which algorithm he or she would like to use.
    */
   private static void UI() throws InterruptedException {            
      continuing();  
   }
   
   /**
     * Private method that deals with continuation of the program.
     */
   private static void continuing() throws InterruptedException {
      boolean stillRunning = true;
      while (stillRunning) {
         printAlgorithms();
         readInput();
         System.out.print("The sorted array   : ");
         printArray(); 
         System.out.print("\n0: quit\n1: continue\n");
         responce = scan.nextInt();
         switch(responce) {
            case 0:
               stillRunning = false;
               break;
            case 1:
               break;
            default:
               System.err.println("That is not a valid option!\n" 
               +  "Now terminating program");
               Thread.sleep(1000);
         }
      }    
   }
   
   /** 
    * Private method for reading user input.
    */
   private static void readInput() throws InterruptedException {      
      initialize();
      System.out.print("Please select an algorithm: ");
      responce = scan.nextInt();      
      
      switch(responce) {
         // insertion sort was selected
         case 0:
            insertionSort(numbers);
            break;
         case 1:
            mergeSort(numbers);
            break;
         default:
            System.err.println("That is not a valid option!\n" 
               +  "Now terminating program...");
            Thread.sleep(1000);
            System.exit(1);
            break;
      }
      System.out.println("Now using the " + ALGORITHMS[responce]
      + " sort algorithm to sort the array.\n");
   }
   
   /**
    * Method that randomly fills the array;
    */
   public static void fill() {
      for (int i = 0; i < SIZE; i++) {
         numbers[i] = RAND.nextInt(SIZE) + 1;
      }  
   }
   
   /** 
    * Method that prints out the appropriate algorithm choices.
    */
   public static void printAlgorithms() {  
      System.out.println("ALGORITHMS");    
      for (int i = 0; i < ALGORITHMS.length; i++) {
         System.out.println(i + ": "  + ALGORITHMS[i]);
      }       
      System.out.println();
   } 
    
    
   
   /**
    * Method that prints out the array.
    */
   public static void printArray() throws InterruptedException {
      if (SIZE == 0)
         printString("[]");
         
      final StringBuilder sb = new StringBuilder();
      sb.append("[");
      sb.append(numbers[0]);
      //System.out.print("[" + numbers[0]);
      for (int i = 1; i < SIZE; i++) {
         //System.out.print(", "  + numbers[i]);
         sb.append(", ");
         sb.append(numbers[i]); 
      }  
      sb.append("]");
      final String temp = sb.toString();
      printString(temp);
   }
   
   
   /**
    * This method sorts a collection using an insertion sorting algorithm.
    *
    * Best Case : O(N)
    * Avg Case  : O(N^2)
    * Worst Case: O(N^2)
    *
    * @param The array to be sorted.
    */
   public static void insertionSort(int[] a) {
      int j;
      for (int i = 1; i < a.length; i++) {
         int temp = a[i];
         for (j = i; j > 0 && temp < a[j - 1]; j--)
            a[j] = a[j-1];
         a[j] = temp;
      }
   }
   
   /**
    * This method sorts a collection using an insertion sorting algorithm.
    *
    * Best Case : O(NlogN)
    * Avg Case  : O(NlogN)
    * Worst Case: O(NlogN)
    *
    * @param The array to be sorted.
    */
   public static void mergeSort(int[] a) {
      int[] temp = new int[SIZE];
      mergeSort(a, temp, 0, a.length - 1);
   } 
   
  /** 
   * The recursive merging process.
   *
   * @param a The original array to be sorted
   * @param temp The temporary array
   * @param left The leftmost index
   * @param right The rightmost index
   */
   private static void mergeSort(int[] a, int[] temp, int left, int right) {
      // test to see that we haven't gone over the edge of the array
      if (left < right) {
         int mid = (left  + right) / 2;
         
         // sort the left part
         mergeSort(a, temp, left, mid);   
         
         // sort the right part
         mergeSort(a, temp, mid + 1, right);
         
         // the actual merging process
         merge(a, temp, left, mid + 1, right);
      }
   }
   
    
   /** 
    * This method will do the actual merging.
    * 
    * @param a original array
    * @param temp temporary array
    * @param leftPos the left most index of the subarray
    * @param rightPos the index of the start of the second half of the array
    * @param rightEnd the index of the ending point of the second half of the array
    */
   private static void merge(int[] a, int[] temp, int leftPos, int rightPos, int rightEnd) {
      // find the left boundary
      int leftEnd = rightPos - 1;
       
      int tempPos = leftPos;
      
      // total number of elements to sort in the array
      int numElements = rightEnd - leftPos + 1;
      
      // while we haven't overpassed the boundaries of the "Arrays"
      while (leftPos <= leftEnd && rightPos <= rightEnd) {
         if (a[leftPos] <= a[rightPos] )
            temp[tempPos++] = a[leftPos++];  // add left then move on
         else
            temp[tempPos++] = a[rightPos++]; // add right then move on
      }
      
      // deal with the left array still having elements
      while (leftPos <= leftEnd)
         temp[tempPos++] = a[leftPos++];
      
      // deal with the right array still having elements
      while (rightPos <= rightEnd)
         temp[tempPos++] = a[rightPos++];
      
      // replace the original array with the sorted values
      for (int i = 0; i < numElements; i++, rightEnd--)
         a[rightEnd] = temp[rightEnd];
   }
   
   /**
    * This is a special method for printing.
    *
    * @param theString The string to print out.
    */
   public static void printString(final String theString) throws InterruptedException {
      for (int i = 0; i < theString.length(); i++) {
         System.out.print(theString.charAt(i));
         Thread.sleep(50);
      }
      System.out.println();
   }
   
}