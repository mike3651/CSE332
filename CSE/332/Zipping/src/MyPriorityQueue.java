import java.util.List;

/**
 * 
 */

/**
 * @author Michael Wilson
 * @version 1.0
 *
 */
public class MyPriorityQueue<Type> {
	/** The default capacity. */
	private static final int DEFAULT_CAPACITY = 11;
	
	/** The collection for the priority queue. */
	private Type[] theList;
	
	/** Creates a priority queue with a default capacity. */
	public MyPriorityQueue() {		
		theList = (Type[])new Object[DEFAULT_CAPACITY];
	}

}
