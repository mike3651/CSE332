import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CodingTree {
	/** EOF character, determined by the highest char value in theCounts. */
	private char EOF;
	
	/** The message to encode. */
	private String theMessage;
	
	/** The mapping of characters to binary codes. */
	private Map<Character, String> codes;
	
	/** Mapping of characters and their respective frequencies. */
	private Map<Character, Integer> theCounts;
	
	/** The message encoded. */
	private List<Byte> bits;
	
	/** The overallRoot. */
	private CodingNode root;
	
	/** Keeps track of all of the nodes. */
	private PriorityQueue<CodingNode> theNodes;
	
	/** 
	 * Creates a coding tree with the correct message.
	 * 
	 * @param message The message to be compressed.
	 */
	public CodingTree(String message) {
		theMessage = message; 
		codes = new HashMap<Character, String>();
		root = null;
		bits = new ArrayList<Byte>();
		theNodes = new PriorityQueue();
		theCounts = new HashMap<Character, Integer>();
		firstRead();
		makeTheQueue();
	}
	
	/** 
	 * This will keep track of the characters and their frequencies
	 */
	private void firstRead() {
		for (int i = 0; i < theMessage.length(); i++) {
			if (!theCounts.containsKey(theMessage.charAt(i))) {
				theCounts.put(theMessage.charAt(i), 0);
			} else {
				theCounts.put(theMessage.charAt(i), theCounts.get(theMessage.charAt(i))+ 1);
			}				
		}
	}
	
	/** 
	 * This method makes use of the mapping of characters and frequencies.
	 * It creates a priority queue with a lot of Coding nodes.
	 */
	private void makeTheQueue() {
		// go through the map of characters
		
		// set the max char value to the lowest possible
		char max = '\0';
		for(char value : theCounts.keySet()) {
			int freq = theCounts.get(value);
		
			// check for the largest character
			if (max < value) 
				max = value;
				
			// make the node
			CodingNode temp = new CodingNode(value, freq);
			
			// add that to the queue
			theNodes.add(temp);
		}
		
		// set the EOF
		EOF = (char) (max + 1);
		// make EOF node, only seen once
		CodingNode temp = new CodingNode(EOF, 1);
		theNodes.add(temp);
	}
	
	/** 
	 * This method will make the tree.	
	 */
	private void makeTheTree() {
		
	}
	
	
	/**
	 * Private inner class that creates a huffman node.
	 */
	private class CodingNode implements Comparable<CodingNode> {
		/** The character that we are dealing with. */
		private char theChar;
		
		/** The frequency of the particular node. */
		private int frequency;
		
		/** Reference to the left child. */
		private CodingNode left;
		
		/** Reference to the right child. */
		private CodingNode right;
		
		/** 
		 * Creates a generic coding node.
		 *
		 * @param theChar The current character.
		 * @param frequency The frequency of this character
		 */
		public CodingNode(char character, int amount) {
			this(character, amount, null, null);
		}
		
		/** 
		 * Creates a generic coding node.
		 *
		 * @param theChar The current character.
		 * @param frequency The frequency of this character
		 * @param theLeft The left subtree
		 * @param theRight The right subtree
		 */
		public CodingNode(char character, int amount, CodingNode theLeft, 
				CodingNode theRight) {
			theChar = character;
			frequency = amount;
			left = theLeft;
			right = theRight;
		}

		@Override
		public int compareTo(CodingNode o) {		
			return this.frequency - o.frequency;
		}
	}
	
}
