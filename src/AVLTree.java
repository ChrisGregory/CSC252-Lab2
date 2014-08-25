public class AVLTree<T extends Comparable<T>> {
	/**
	 * an AVL tree (Adelson-Velskii and Landis' tree, named after the inventors)
	 * is a self-balancing binary search tree. It was the first such data
	 * structure to be invented. In an AVL tree, the heights of the two child
	 * subtrees of any node differ by at most one; if at any time they differ by
	 * more than one, rebalancing is done to restore this property. Lookup,
	 * insertion, and deletion all take O(log n) time in both the average and
	 * worst cases, where n is the number of nodes in the tree prior to the
	 * operation. Insertions and deletions may require the tree to be rebalanced
	 * by one or more tree rotations.
	 */

	public Node root;

	public AVLTree() {
		root = null;
	}
	
	public void insert(T x) {
		root = insert(x, root);
	}

	private Node insert(T value, Node node) {
		//recursive inserter
		return node;
	}
	
	public void remove(T value){
		//Find the value rectursively.
		//Rebalance after finding it.
	}

	public T findMin() {
		return (T) findMin(root).data;
	}
	
	private Node findMin(Node node) {
		if (node == null)
			return node;

		while (node.left != null)
			node = node.left;
		return node;
	}

	public T findMax() {
		return (T) findMax(root).data;
	}
	
	private Node findMax(Node t) {
		if (t == null) {
			return t;
		}
		while (t.right != null) {
			t = t.right;
		}
		return t;
	}

	private Node find(T value, Node node) {
		while (node != null) {
			if (value.compareTo((T) node.data) < 0) {
				node = node.left;
			} else if (value.compareTo((T) node.data) > 0) {
				node = node.right;
			} else {
				return node;
			}
		}
		return null; // No match
	}

	private static int height(Node t) {
		return t == null ? -1 : t.height;
	}

	private static Node leftRotation(Node root) {
		Node pivot = root.left;
		root.left = pivot.right;
		pivot.right = root;
		root.height();
		pivot.height();
		return pivot;
	}

	private static Node rightRotation(Node root) {
		Node pivot = root.right;
		root.right = pivot.left;
		pivot.left = root;
		root.height();
		pivot.height();
		return pivot;
	}

	private static Node doubleLeftRotation(Node root) {
		root.left = rightRotation(root.left);
		return leftRotation(root);
	}

	private static Node doubleRightRotation(Node root) {
		root.right = leftRotation(root.right);
		return rightRotation(root);
	}

}
