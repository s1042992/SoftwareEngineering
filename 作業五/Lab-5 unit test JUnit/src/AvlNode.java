

public class AvlNode {
	public AvlNode left, right;
	public int data;
	public int height;

	/* Constructor */
	public AvlNode() {
		left = null;
		right = null;
		data = 0;
		height = 0;
	}

	/* Constructor */
	public AvlNode(int n) {
		left = null;
		right = null;
		data = n;
		height = 0;
	}
}
