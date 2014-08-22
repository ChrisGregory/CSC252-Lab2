public class HeapBasedPriorityQueue<T extends Comparable<T>> {
	Heap heap;

	public HeapBasedPriorityQueue(Class<T> type) {
		heap = new Heap<T>(type);
	}

	// Add value into the right place in the Heap.
	// Returns true if it works.
	// Efficiency Class: Theta()
	public boolean offer(T data) {
		System.out.println("Adding " + data);
		boolean result = false;
		heap.insert(data);
		result = true;
		return result;
	}

	// Get the highest priority value, but do not remove it.
	// The documentation wants me to return boolean, but I don't know why. T makes more sense.
	// Efficiency Class: Theta()
	public T peek() {
		T result = (T) heap.getRootValue();
		return result;
	}

	// Get the highest priority value both return and remove it.
	// Efficiency Class: Theta()
	public T poll() {
		T result = (T) heap.getRootValue();
		System.out.println(result);
		heap.removeRoot();
		return result;
	}
	
	public int size() {
		return heap.size;
	}
}
