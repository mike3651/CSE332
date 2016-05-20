/*
* Michael Wilson
* CSE 373
* Assignment number 3
* This class will test the methods of all three of the heaps
*/
public class test {
   
   public static void main(String[] args) throws Exception {
      testMYPQ();
      testBinaryHeap();
      testThreeHeap();
   }

   // This will run the tests for MyPQ
   public static void testMYPQ() throws Exception{
      System.out.println("Now testing MyPQ );");
      MyPQ mine = new MyPQ();
      // The following tests multiple cases of the insert method, including duplicates!
      try {
         if(mine.isEmpty())
            System.out.println("This PQ is empty ):<");
         mine.deleteMin();
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("There was an error somewhere? @_@");
      }
      try {
         System.out.println("The size is: " + mine.size());
         mine.insert(1.0);
         System.out.println("The minimum deleted was: " + mine.deleteMin());
      } catch (Exception e) {
         e.printStackTrace();
         print("There was another error?!");
      }
         System.out.println("The size is: " + mine.size());
         mine.insert(3.0);
         print(mine.toString());
         System.out.println("The size is: " + mine.size());
         mine.insert(4.0);
         print(mine.toString());
         System.out.println("The size is: " + mine.size());
         mine.insert(2.0);
         print(mine.toString());
         System.out.println("The size is: " + mine.size());
         mine.insert(3.0);
         System.out.println("The size is: " + mine.size());
         print(mine.toString());
         mine.makeEmpty();
         System.out.println("The list is now empty :)");
         print(mine.toString());
   }
   
   // This will run the threeHeap tests
   public static void testThreeHeap() throws Exception {
      System.out.println("----------------------------------------------------------------------");
      print("Now testing testThreeHeap );");
      ThreeHeap three = new ThreeHeap();
      // This will test our error cases for the three heap
      try {
         System.out.println(three.size());
         System.out.println(three.deleteMin());
         System.out.println(three.findMin());
      } catch (Exception e) {
         e.printStackTrace();
         print("Error, there are no elements in the queue\nTherefore size(), deleteMin(), and " + 
         "findMin() will not work!!!!!!");
      }
      
      // This will test for the addition of  duplicates
      for(int i = 0; i < 5; i++) {
         three.insert(1.0);
         System.out.println(three.toString());
      }
      
      // This will check to see that our 'clear' method works
      three.makeEmpty();
      System.out.println(three.toString());

      // This will check to see that the resize works, expect to see double the size
      for(int i = 0; i < 11; i++) {
         three.insert(i * 1.0 + 1);
         System.out.println(three.toString());
      }      
      
      // This will check to see that the deleteMin functionality works
      System.out.println("The X's represent a void.");
      three.deleteMin();
      System.out.println(three.toString());
   }
   
   // This will run the binaryHeap tests
   public static void testBinaryHeap() throws Exception {
      System.out.println("----------------------------------------------------------------------");
      print("Now testing BinaryHeap );");
      BinaryHeap two = new BinaryHeap();
      // This will test our error cases for the three heap
      try {
         System.out.println(two.size());
         System.out.println(two.deleteMin());
         System.out.println(two.findMin());
      } catch (Exception e) {
         e.printStackTrace();
         print("Error, there are no elements in the queue\nTherefore size(), deleteMin(), and " +
               "findMin() will not work!!!!!!");
      }
      
      // This will test for the addition of  duplicates
      for(int i = 0; i < 5; i++) {
         two.insert(1.0);
         System.out.println(two.toString());
      }
      
      // This will check to see that our 'clear' method works
      two.makeEmpty();
      System.out.println(two.toString());

      // This will check to see that the resize works, expect to see double the size
      for(int i = 0; i < 11; i++) {
         two.insert(i * 1.0 + 1);
         System.out.println(two.toString());
      }      
      
      // This will check to see that the deleteMin functionality works
      System.out.println("The X's represent a void.");
      two.deleteMin();
      System.out.println(two.toString());
   }

   // This is just a short method I generated to make printing a lot more appealing to me
   public static void print(String s) throws Exception {
      for(int i = 0; i < s.length(); i++) {
         System.out.print(s.charAt(i));
         Thread.sleep(30);
      }
      System.out.println();
   }  
}