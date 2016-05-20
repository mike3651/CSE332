/*
Michael Wilson
CSE 373
Assignment number 3
This class will use a binary heap for organization and implement the priority queue interface
*/

public class BinaryHeap implements PriorityQueue {
   private int size;
   private double[] heap;
   public static int DEFAULT_SIZE = 10;

   public BinaryHeap() {
      heap = new double[DEFAULT_SIZE];
      size = 0;
   }

   // returns the number of elements in the priorityqueue
   // throws an EmptyPQException if there are no elements in the prioirty queue
   public int size() {
      if(isEmpty())
         throw new EmptyPQException();
      return size;
   }

   // throws an EmptyPQException if there are no elements in the priority queue
   // returns the minimum value in the priority queue
   public double findMin() {
      if(isEmpty())
         throw new EmptyPQException();
      return heap[0];
   }

   // Empties out the elements in the priority queue
   public void makeEmpty() {
      heap = new double[DEFAULT_SIZE];
      size = 0;
   }

   // This method will allow us to add something to the trinary heap
   public void insert(double value) {
      if(size == heap.length - 1) 
         resize();
      size++;
      int i = percolateUp(size, value);
      heap[i] = value;
   }
   
   // This method will resize the tinary heap
   public void resize() {
      double[] temp = heap;
      DEFAULT_SIZE *= 2;
      heap = new double[DEFAULT_SIZE];
      for(int i = 0; i < temp.length; i++) {
         heap[i] = temp[i];
      }
   }
   
   // This method will loop up through our heap to organize it all based off of priority
   // This will return the spot of where the 'hole' that was created was
   public int percolateUp(int size, double value) {
      while(size > 1 && value < heap[size/2]) {
         heap[size] = heap[size/2];
         size /= 2;
      }
      return size;
   }

   // This method will percolate down the trinary heap
   // This returns the value of the 'hole'
   public int percolateDown(int hole, double value) {
      int target = 0;
      while(2 * hole <= size) {
         int left = 2 * hole; // i * d - d + 2, d = 2 --> i * 2 - 2 + 2 = i * 2
         int right = left + 1; // i * d + 1, d = 2 --> i * 2 + 1 = 2 * i + 1 || left + 1
         if(right > size || heap[left] < heap[right]) {
            target = left;
         } else {
            target = right;
         } if(heap[target] < value) {
            heap[hole] = heap[target];
            hole = target;
         } else {
            break;
         }
         String array = "[";
         array += "X";
         for(int j = 1; j < heap.length; j++) {
            array += ", ";
            if(heap[j] == 0.0) {
               array += "X";
            } else {
               array += heap[j];  
            }
         }
         array += "]";
         System.out.println(array);
      }
      return hole;
   }
   
   // This will delete the minimum value from the heap
   // This will return the value of the minimum that was removed from the heap
   public double deleteMin() {
      if(isEmpty())
         throw new EmptyPQException();
      double min = heap[1];
      int hole = percolateDown(1, heap[size]);
      heap[hole] = heap[size];
      size--;
      return min;
   }
   
   
   // This method will check to see if the heap is empty
   public boolean isEmpty() {
      return size == 0;
   }
   
   // This will be used to print out a nice string representation
   // of the elements that are in our threeheap
   // This method will print an X in the slots that are not in use
   public String toString() {
      String array = "[";
      array += "X";
      for(int i = 1; i < heap.length; i++) {
         array += ", ";
         if(heap[i] == 0.0) {
            array += "X";
         } else {
            array += heap[i];  
         }
      }
      array += "]";
      return array;
   }
   
}