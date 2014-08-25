public class AVLBasedPriorityQueue<T extends Comparable<T>> {
	/**
	 * Observations:
	 * 
	 * Based on my research, AVL trees are NOT the best thing to use for this. A
	 * Heap is pretty much designed for this job.
	 */

	AVLTree<T> tree;
	int size;

	public AVLBasedPriorityQueue() {
		tree = new AVLTree<T>();
		size = 0;
	}

	// Add value into the right place in the AVL tree.
	// Returns true if it works.
	// Efficiency Class: Theta()
	public boolean offer(T data) {
		boolean result = false;
		tree.insert(data);
		size++;
		result = true;
		return result;
	}

	// Get the highest priority value, but do not remove it.
	// The documentation wants me to return boolean, but I don't know why. T
	// makes more sense.
	// Efficiency Class: Theta()
	public T peek() {
		T result = tree.findMax();
		return result;
	}

	// Get the highest priority value both return and remove it.
	// Efficiency Class: Theta()
	public T poll() {
		T result = tree.findMax();
		tree.remove(result);
		size--;
		return result;
	}

	public int size() {
		return size;
	}

}
