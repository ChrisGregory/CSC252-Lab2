import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {
	/**
	 * "In a heap the highest (or lowest) priority element is always stored at
	 * the root, hence the name heap. A heap is not a sorted structure and can
	 * be regarded as partially ordered. As visible from the Heap-diagram, there
	 * is no particular relationship among nodes on any given level, even among
	 * the siblings. When a heap is a complete binary tree, it has a smallest
	 * possible height - a heap with N nodes always has O(log N) height. A heap
	 * is a useful data structure when you need to remove the object with the
	 * highest (or lowest) priority.
	 * 
	 * The heap is one maximally efficient implementation of an abstract data
	 * type called a priority queue, and in fact priority queues are often
	 * referred to as "heaps", regardless of how they may be implemented. Note
	 * that despite the similarity of the name "heap" to "stack" and "queue",
	 * the latter two are abstract data types, while a heap is a specific data
	 * structure, and "priority queue" is the proper term for the abstract data
	 * type." -Wikipedia
	 */

	private T[] heapArray;
	public int size;
	private Class<T> type;

	public Heap(Class<T> type) {
		this.size = 0;
		this.type = type;
		this.heapArray = (T[]) Array.newInstance(type, 2);
	}

	public Heap(Class<T> type, T[] inputArray) {
		this.size = inputArray.length;
		this.type = type;
		this.heapArray = (T[]) new Comparable[inputArray.length];
		System.arraycopy(inputArray, 0, heapArray, 0, inputArray.length);
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	public T getRootValue() {
		if (heapArray.length > 1) {
			return heapArray[1];
		} else {
			return null;
		}
	}

	private void percolatingDown(int k) {
		T tmp = heapArray[k];
		int child;

		while (2 * k <= size) {
			child = 2 * k;

			if (child != size
					&& heapArray[child].compareTo(heapArray[child + 1]) > 0) {
				child++;
			}
			if (tmp.compareTo(heapArray[child]) > 0) {
				heapArray[k] = heapArray[child];
			} else {
				break;
			}
			k = child;
		}
		heapArray[k] = tmp;
	}

	public void heapSort(T[] array) {
		size = array.length;
		heapArray = (T[]) new Comparable[size];
		System.arraycopy(array, 0, heapArray, 0, size);
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
		for (int i = size; i >= 0; i--) {
			// Swap the top node and the node at i's location, then percolate
			// down.
			T tmp = heapArray[i];
			heapArray[i] = heapArray[1];
			heapArray[1] = tmp;
			size--;
			percolatingDown(1);
		}
		for (int k = 0; k < heapArray.length; k++)
			array[k] = heapArray[heapArray.length - k];
	}

	public T deleteMin() {
		if (size == 0) {
			return null;
		} else {
			T min = heapArray[0];
			heapArray[0] = heapArray[size--];
			percolatingDown(1);
			return min;
		}
	}

	public boolean removeRoot() {
		T root = heapArray[1];
		T exchange = heapArray[heapArray.length - 1];
		heapArray[1] = exchange;
		heapArray[heapArray.length - 1] = root;
		size--;
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
		return false;
	}

	public void insert(T x) {
		if (size == heapArray.length - 1) {
			doubleSize();
		}
		int pos = ++size;

		for (; pos > 1 && x.compareTo(heapArray[pos / 2]) < 0; pos = pos / 2) {
			heapArray[pos] = heapArray[pos / 2];
		}

		System.out.println("inserted " + x + " at " + pos);
		heapArray[pos] = x;
	}

	private void doubleSize() {
		T[] old = heapArray;
		heapArray = (T[]) Array.newInstance(type, heapArray.length * 2);
		System.arraycopy(old, 1, heapArray, 1, size);
	}

	public String toString() {
		String out = "";
		for (int k = 1; k <= size; k++)
			out += heapArray[k] + " ";
		return out;
	}
}
