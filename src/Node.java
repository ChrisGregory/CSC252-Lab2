public class Node<T extends Comparable<T>> implements Comparable {
	public final T data;
	public Node left;
	public Node right;
	public Node parent; // This is only really neccesary because I wanted a
						// simple "Node.level()" method.
						// After additional research, this is also neccesary for
						// removal. So it's in forever now.
	public int weight;// huffman nodes all appear to have a weight value. Look
						// into this.
	public int height;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	public Node(T data, Node parent) {
		this.data = data;
		this.parent = parent;
	}

	public Node(T data, int weight, Node parent) {
		this.data = data;
		this.weight = weight;
		this.parent = parent;
	}

	public Node(Node<T> node1, Node<T> node2) {
		this.data = null;
		this.parent = null;
		this.left = node1.compareTo(node2) < 0 ? node1 : node2;
		this.right = node1.compareTo(node2) < 0 ? node2 : node1;
		this.left.parent = this;
		this.right.parent = this;
		this.weight = node1.weight + node2.weight;
	}

	public int balanceFactor() {
		int lengthOfLeftSide = height(left);
		int lengthOfRightSide = height(right);
		return lengthOfLeftSide - lengthOfRightSide;
	}

	public int height() {
		height = height(this);
		return height;
	}

	public int level() {
		return parent == null ? 0 : parent.level() + 1;
	}

	private int height(Node node) {
		if(node != null){
			int leftHeight = 0;
			int rightHeight = 0;
			if (node.left != null) {
				leftHeight = height(node.left);
			}
			if (node.right != null) {
				rightHeight = height(node.right);
			}
			return Math.max(leftHeight, rightHeight) + 1;
		}
		else {
			return -1;
		}
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	@Override
	public int compareTo(Object arg0) {
		Node otherNode = (Node) arg0;
		int result = weight - otherNode.weight;
		return result;
	}
}
