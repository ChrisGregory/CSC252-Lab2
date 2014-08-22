import java.util.Random;


public class Tester {
	static Random rand = new Random();
	public static void main(String[] args) {
		HeapBasedPriorityQueue<Integer> heapBasedPriorityQueue = new HeapBasedPriorityQueue<Integer>(Integer.class);
		for (int i = 20; i > 0; i--) {
			heapBasedPriorityQueue.offer(i);
		}
		System.out.println("Heap-PQueue's size after adding 20 items: " + heapBasedPriorityQueue.size());
		System.out.println(heapBasedPriorityQueue.heap.toString());
		
		System.out.println("Peek: " + heapBasedPriorityQueue.peek());

		System.out.print("Polling priorityQueue 20 times: ");
		for (int i = 0; i < 20; i++) {
			System.out.print(heapBasedPriorityQueue.poll() + ", ");
		}
		System.out.println();
		
		System.out.print("Polling priorityQueue when empty: ");
		System.out.print(heapBasedPriorityQueue.poll());
		System.out.println();
		
	}

}
