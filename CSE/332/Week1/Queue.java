import java.util.*;

public class Queue {
	private Node front, back;

	public Queue() {
		front = back = null;
	}


	// enqueues an object;
	public void enqueue(int x) {
		if (isEmpty())
			front = back = new Node(x);
	}


	// private class for nodes
	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this(data, null);
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}