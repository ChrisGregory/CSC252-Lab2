public class Project {

	/**
	 * Milestone 1
	 * 
	 * Create a class called AVLBasedPriorityQueue that remains unbalanced. It
	 * should implement the following two methods:
	 * 
	 * boolean offer(T data); // add value into the right place in the AVL tree
	 * boolean peek(); // see, but do not remove the highest priority value
	 * 
	 * Create a class called HeadBasedPriorityQueue. It should implement the
	 * following two methods:
	 * 
	 * boolean offer(T data); // add value into the right place in the heap
	 * boolean peek(); // see, but do not remove the highest priority value
	 * 
	 * Questions I'm likely to ask: How does the efficiency class of each
	 * compare? Under what circumstances will these data structures exhibit
	 * similar performance?
	 */

	/**
	 * Milestone 2
	 * 
	 * Add the poll() method to both implementations of PriorityQueue. (AVL
	 * still does not need to balance.)
	 * 
	 * Questions I am likely to ask: What advantages does poll have in a heap
	 * over an AVL tree other than the lack of rebalancing? Removal in a BST is
	 * theoretically 3 cases; show how your code keeps to those three cases.
	 */

	public static void main(String[] args) {
		System.out.println("Queued Lab");
	}

}
