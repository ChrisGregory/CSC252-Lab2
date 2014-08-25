import java.util.Random;


public class Tester {
	static Random rand = new Random();
	public static void main(String[] args) {
		//Heap Time
		HeapBasedPriorityQueue<Integer> heapBasedPriorityQueue = new HeapBasedPriorityQueue<Integer>(Integer.class);
		for (int i = 20; i > 0; i--) {
			heapBasedPriorityQueue.offer(i);
		}
		System.out.println("Heap-PQueue's size after adding 20 items: " + heapBasedPriorityQueue.size());
		System.out.println(heapBasedPriorityQueue.heap.toString());
		
		System.out.println("Peek: " + heapBasedPriorityQueue.peek());

		System.out.println("Polling priorityQueue 20 times: ");
		for (int i = 0; i < 20; i++) {
			System.out.print(heapBasedPriorityQueue.poll() + ", ");
		}
		System.out.println();
		System.out.println("Heap-PQueue's size after removing 20 items: " + heapBasedPriorityQueue.size());

		System.out.println(heapBasedPriorityQueue.heap.toString());
		
		
		//AVL Time
		AVLBasedPriorityQueue<Integer> AVLBasedPriorityQueue = new AVLBasedPriorityQueue<Integer>();
		for (int i = 20; i > 0; i--) {
			AVLBasedPriorityQueue.offer(i);
		}
		System.out.println("AVL-PQueue's size after adding 20 items: " + AVLBasedPriorityQueue.size());
		System.out.println(AVLBasedPriorityQueue.tree.toString());
		
		System.out.println("Peek: " + AVLBasedPriorityQueue.peek());

		System.out.println("Polling priorityQueue 20 times: ");
		for (int i = 0; i < 20; i++) {
			System.out.print(AVLBasedPriorityQueue.poll() + ", ");
		}
		System.out.println();
		System.out.println("AVL-PQueue's size after removing 20 items: " + AVLBasedPriorityQueue.size());

		System.out.println(AVLBasedPriorityQueue.tree.toString());
		
		
	}

}
