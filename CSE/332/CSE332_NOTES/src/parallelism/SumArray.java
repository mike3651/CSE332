package parallelism;
//Michael Wilson
//CSE 332



import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Class that sums up the values of an array using Fork-Join.
 * Too many threads in java is a bad idea and overheats the system.
 * 
 * @author Michael Wilson
 * @version 1.0
 */
public class SumArray extends RecursiveTask<Integer>{
	/** Default Serial number. */
	private static final long serialVersionUID = 1L;

	/** Cutoff point. */
	private static final int SEQUENTIAL_CUTOFF = 1000;
	
	// shared fields
	private int lo;
	private int hi;
	private int[] arr;
	
	/**
	 * Constructor for the FJ framework.
	 * 
	 * @param a The array.
	 * @param l The low point.
	 * @param h The high point.
	 */
	public SumArray(int[] a, int l, int h) {
		arr = a; lo = l; hi = h;
	}
	
	/**
	 * Computational method that takes place of run.
	 */
	protected Integer compute() {
		if (hi - lo < SEQUENTIAL_CUTOFF) {
			int ans = 0;
			for (int i = lo; i < hi; i++)
				ans += arr[i];
			return ans;		
		} else {
			SumArray left = new SumArray(arr, lo, (hi + lo)  /2);
			SumArray right = new SumArray(arr, (hi + lo)  /2, hi);
			// creates a new process
			left.fork();
			int rightAns = right.compute();
			int leftAns = left.join();
			return leftAns + rightAns;
		}
	}
	public static final ForkJoinPool fjPool = new ForkJoinPool();
	
	/** 
	 * method that calculates the sum in an array.
	 * 
	 * @param arr The array that we are dealing with
	 */
	public int sum(int[] arr) {
		// returns that value that compute returns.
		return fjPool.invoke(new SumArray(arr, 0, arr.length));
	}
}
