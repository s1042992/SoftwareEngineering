

class AvlTree {
	private AvlNode root;

	/* Constructor */
	public AvlTree() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Make the tree logically empty */
	public void makeEmpty() {
		root = null;
	}

	/* Function to insert data */
	public void insert(int data) {
		root = insert(data, root);
	}

	/* Function to get height of node */
	private int height(AvlNode t) {
		return t == null ? -1 : t.height;
	}

	/* Function to max of left/right node */
	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	/* Function to insert data recursively */
	private AvlNode insert(int x, AvlNode t) {
		if (t == null)
			t = new AvlNode(x);
		else if (x < t.data) {
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2)
				if (x < t.left.data)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x > t.data) {
			t.right = insert(x, t.right);
			if (height(t.right) - height(t.left) == 2)
				if (x > t.right.data)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			; // Duplicate; do nothing
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	/* Rotate binary tree node with left child */
	private AvlNode rotateWithLeftChild(AvlNode k2) {
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        return k1;
	}

	/* Rotate binary tree node with right child */
	private AvlNode rotateWithRightChild(AvlNode k1) {
		AvlNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.left), height(k1.right)) + 1;
		return k2;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child
	 */
	private AvlNode doubleWithLeftChild(AvlNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child
	 */
	private AvlNode doubleWithRightChild(AvlNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	/* Functions to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(AvlNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	/* Functions to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	private boolean search(AvlNode r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.data;
			if (val < rval)
				r = r.left;
			else if (val > rval)
				r = r.right;
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	/* Function for inorder traversal */
	public String inorder() {
		return inorder(root);
	}

	private String inorder(AvlNode r) {
		if (r != null) {
			String topRes = inorder(r.left);
			String bottomRes = inorder(r.right);
			String retRes = (topRes.isEmpty() ? "" : (topRes + " ")) +
					r.data +
					(bottomRes.isEmpty() ? "" : (" " + bottomRes));
			
			return retRes;
		}
		return "";
	}

	/* Function for preorder traversal */
	public String preorder() {
		return preorder(root);
	}

	private String preorder(AvlNode r) {
		if (r != null) {
			String topRes = preorder(r.left);
			String bottomRes = preorder(r.right);
			String retRes = r.data +
					(topRes.isEmpty() ? "" : (" " + topRes)) +
					(bottomRes.isEmpty() ? "" : (" " + bottomRes));
			
			return retRes;
		}
		return "";
	}

	/* Function for postorder traversal */
	public String postorder() {
		return postorder(root);
	}

	private String postorder(AvlNode r) {
		if (r != null) {
			String topRes = postorder(r.left);
			String bottomRes = postorder(r.right);
			String retRes =	(topRes.isEmpty() ? "" : (topRes + " ")) +
					(bottomRes.isEmpty() ? "" : (bottomRes + " ")) +
					r.data;
			
			return retRes;
		}
		return "";
	}
}
