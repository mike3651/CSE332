/*
Michael Wilson
CSE 373
Assignment number 3
This will utilize the idea of a priority queue using a linked list
It will implement the priority queue interface
*/


public class MyPQ implements PriorityQueue {
   private ListNode front;
   private int size;
   
   // This will initialize MyPQ   
   public MyPQ() {
      front = null;
      size = 0;
   }
   
   // This is the ListNode class that will be used for the myPQ
   public class ListNode {
      public ListNode next;
      public double data;
     
      // This will construct a ListNode with just the data     
      public ListNode(double data) {
         this(data, null);
      }  
      
      // This will construct a ListNode with the data and a next pointer
      public ListNode(double data, ListNode next) {
         this.data = data;
         this.next = next;
      }
   } 
   
   // This will check if the queue is empty
   public boolean isEmpty(){
      return size == 0;
   }
   
   // returns the size of the queue
   public int size(){
      return size;
   }
   
   // returns the data field of the front of the list
   public double findMin() {
      return front.data;
   }
   
   // This will insert the value into the proper position of the list
   public void insert(double x) {
      if(front == null) 
         front = new ListNode(x);
      else if(front.data > x) 
         front = new ListNode(x, front);    
      else {
         ListNode current = front;
         while(current.next != null && current != null) {
            if(current.next.data > x) {
               ListNode temp = current;
               current = new ListNode(x, current.next);
               temp.next = current;
               current = current.next;
               break;
            }
            current = current.next;
         }
         if(current.data < x) 
            current.next = new ListNode(x);
      }
      size++;
   }
   
   // If the list is empty this will throw an EmptyPQException
   public double deleteMin() {
      double returned = front.data;
      if(front == null) 
         throw new EmptyPQException(); 
      if(front.next == null) 
         front = null;
      else
         front = front.next;
      size--;
      return returned;      
  }

   // This will give a nice version of our to linked
   // Returns a string representation of the list
   public String toString() {
      String list = "|";
      ListNode current = front;
      while(current != null) {
         list += current.data + "| -|--> | ";
         current = current.next;
      }
      list += "|";
      return list;
   }

    // This will clear the linked list
    public void makeEmpty(){
      front = null;
    }
}
