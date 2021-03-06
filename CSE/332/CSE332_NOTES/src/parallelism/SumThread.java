package parallelism;


/**
 * This class makes use of threads to add the values of an array up.
 * 
 * @author Michael Wilson
 * @version 1.0
 */
public class SumThread extends java.lang.Thread {
	/** This is the sequential cutoff to eliminate small threads. */
	private static final int SEQUENTIAL_CUTOFF = 1000;
	
	// These fields will communicate across the threads.
	private int lo;
	private int hi;
	private int[] arr;
	private int ans = 0;

	
	/**
	 * Creates the thread.
	 *  
	 * @param a The array of numbers
	 * @param l The low end of the array.
	 * @param h The high end of the array.
	 */
	public SumThread(int[] a, int l, int h)
	{
		lo = l; hi = h; arr = a;
	}
	
//	/**
//	 * Method that we need.
//	 */
//	public void run() {
//		for (int i = lo; i < hi; i++)
//			ans += arr[i];
//	}
//	
//	/**
//	 * Sums up the values in the array.
//	 * 
//	 * @param arr The array to sum up.
//	 * @throws InterruptedException 
//	 */
//	public int sum(int[] arr) throws InterruptedException {
//		int len = arr.length;
//		int ans = 0;
//		// creates an array of 4 threads to work on the sum
//		SumThread[] ts = new SumThread[4];
//		
//		// This does the parallel computations
//		for (int i = 0; i < 4; i++) {
//			// because there are four threads, each thread does a quarter
//			// of the work
//			ts[i] = new SumThread(arr, i * len / 4, (i + 1) * len / 4);
//			ts[i].start();
//		}
//		
//		// Bring all the answers together
//		for (int i = 0; i < 4; i++) {
//			ts[i].join();
//			ans += ts[i].ans;
//		}		
//		return ans;
//	}
//	
//	/** 
//	 * Sums up the values in the array with N Threads
//	 * 
//	 * @param arr The array to sum up
//	 * @param numTs The number of threads
//	 * @throws InterruptedException 
//	 */
//	public int sum(int[] arr, int numTs) throws InterruptedException {
//		int ans = 0;
//		SumThread[] ts = new SumThread[numTs];
//		for (int i = 0; i < numTs; i++) {
//			ts[i] = new SumThread(arr, (i * arr.length) / numTs, (i + 1) * arr.length / numTs);
//			ts[i].start();
//		}
//		
//		for (int i = 0; i < numTs; i++) {
//			ts[i].join();
//			ans += ts[i].ans;
//		}
//		return ans;
//	}

	/**
	 * Recursive threading.
	 */
	public void run() {
		if (hi - lo < SEQUENTIAL_CUTOFF)
			for (int i = lo; i < hi; i++)
				ans += arr[i];
		else {
			// deal with left part of array
			SumThread left = new SumThread(arr, lo, (hi + lo) / 2);
			// deal with right part of array
			SumThread right = new SumThread(arr, (hi + lo) / 2, hi);
			left.start();
			right.start();
			try {
				left.join();
				right.join();
			} catch (InterruptedException e) {
				System.err.println("Something went wrong here!");
				e.printStackTrace();			
			}			
			ans = left.ans + right.ans;
		}
	}
	
	/** 
	 * Method that sums up the values in an array.
	 * Note: This method only creates one thread.
	 * 
	 * @param arr The array
	 */
	public int sum(int[] arr) {
		SumThread t = new SumThread(arr, 0, arr.length);
		t.run();
		return t.ans;
	}
}
