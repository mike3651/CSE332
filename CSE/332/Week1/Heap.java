public class Heap {

	public static final int DEFAULT_SIZE = 10000;

	private int[] theHeap;

	private int size;

	public Heap() {
		theHeap = new int[DEFAULT_SIZE];
	}

	// deletes the minimum value in a heap
	public int deleteMin() {
		if (isEmpty())
			throw new IllegalStateException("Have an emtpy heap!");
		else {
			int delete = heap[1];
			size--;
			int newPosition = percolateDown(1, heap[size + 1]);
			heap[newPosition] = heap[size + 1];
			return delete;
		}
	}

	// private helper method that deals with deletion
	private int percolateDown(int hole, int value) {
		int target;
		while (2 * hole <= size) {
			int left = 2 * hole;
			int right = left + 1;
			if (right <= size && heap[right] < heap[left])
				target = left;
			else
				target = right;
			if (heap[target] < val) {
				heap[hole] = heap[target];
				hole = target;
			}
			else
				break;
		}
		return hole;
	}

	// inserts an element into the heap
	public void insert(int x) {
		if (isFull()) {
			throw new IllegalStateException("Can't add to a full heap");
		else {
			size++;
			newPosition = percolateUp(size, x);
			heap[newPosition] = x;
		}		
	}

	// private helper method for addition
	private int percolateUp(int hole, int x) {
		while (hole > 1 && val < heap[hole/2]) {
			heap[hole] = heap[hole/2]
			hole /= 2;			
		}
		return hole;
	}

	// checks if the heap is empty {
	public boolean isEmpty() {
		return size == 0;
	}

	// checks if the heap is full
	public boolean isFull() {
		return size == (DEFAULT_SIZE - 1);
	}
}