package BinarySearchTree;

public class BST {
	Node root;
	Node current; 
	int numberOfNodes;
	int heightOfTree;
	
	private static BST bst = new BST();
	
	private BST() {
		// private constructor for creating singleton class
		root = null;
		current = root;
		numberOfNodes = 0;
		heightOfTree = -2;
	}
	
	public static BST getBST() {
		return bst;
	}
	
	// Insertion
	public void insertNode (Node n){
		Node y = null;
		Node x = this.root; // pointer to find the position of insert
		while (x != null){
			// find the position of insert
			y = x;
			if (n.key < x.key){
				x = x.leftChild;
			}
			else {
				x = x.rightChild;
			}
		}
		n.parent = y;
		if (y == null) {
			this.root = n;
			this.current = n;
		}
		else if(n.key < y.key){
			y.leftChild = n;
		}
		else {
			y.rightChild = n;
		}
		System.out.println("Inserting key: " + n.key);
	}
	
	public Node FindMin(){
		Node x = this.root;
		while (x.leftChild != null){
			x = x.leftChild;
		}
		return x;
	}
	
	public Node FindMax(){
		Node x = this.root;
		while (x.rightChild != null){
			x = x.rightChild;
		}
		return x;
	}
	
	public Node RecursiveSearch(int k) {
		Node x = this.current;
		// base case
		if  (x == null || k == x.key){
			this.current = this.root; // reset the current pointer
			return x;
		}
		// recursion
		if (k <  x.key){
			this.current = x.leftChild;
			return RecursiveSearch(k);
			}
		else {
			this.current = x.rightChild;
			return RecursiveSearch(k);
			}
	}
	
	public Node IterativeSearch(int k) {
		Node x = this.root;
		while (x != null && k != x.key){
			if (k < x.key){
				x = x.leftChild;
			}
			else {
				x = x.rightChild;
			}
		}
		return x;
	}
	
	// In-order Traversal
	public void InorderTraversal(){
		 Node x = this.current;
		 if ( x != null){
			 this.current = x.leftChild;
			 InorderTraversal();
			 System.out.printf("%02d ", x.key);
			 this.current = x.rightChild;
			 InorderTraversal();
		 }
		 else {
			 // reset the current pointer
			 this.current = root;
		 }
	}
	// height of a node = length (# edges) of longest downward path to a leaf
	// height of a node = max{height of left child,height of right child} + 1
	// height of a leaf node = 0
	// height of a null node = -1
	public int getHeightofBST(){
		Node x = this.current;
		// base case
		if ( x == null) {
			current = root; // reset the current pointer to root
			return -1;
		}
		else {
			current = x.leftChild;
		    int heightOfLeftChild = getHeightofBST();
		    current = x.rightChild;
		    int heightOfRightChild = getHeightofBST();
		    if (heightOfLeftChild > heightOfRightChild){
		    	return heightOfLeftChild + 1;
		    }
		    else {
		    	return heightOfRightChild + 1;
		    }
		}
	}
	
	// Finds the next node larger than key given
	// Case 1: x has a right sub-tree where all keys are larger than x.key. The next larger key will be
	// the minimum key of x’s right sub-tree.
	// Case 2: x has no right sub-tree. We can find the next larger key by traversing up x’s ancestry
	// until we reach a node that’s a left child. That node’s parent will contain the next larger key

	public Node nextLarger(int k){
		Node x = IterativeSearch(k);
		if (x == null){
			System.out.println("No such node found");
			return null;
		}
		// test if its the max node
		Node max = FindMax();
		if (max.key == x.key){
			System.out.println("Its the max key");
			return null;
		}
		if (x.rightChild instanceof Node) {
			// case 1
			Node temp = x.rightChild;
			while (temp.leftChild != null){
				temp = temp.leftChild;
			}
			return temp;
		}
		else {
			// case 2
			if (x.parent.leftChild instanceof Node) {
			// if its a leaf node and left child
				return x.parent;
			}
			Node temp = x.parent;
			while (temp.parent != null) {
				if (temp.parent.leftChild instanceof Node){
					// if its a left child return its parent
					return temp.parent;
				}
				temp = temp.parent;
			}
			// else its the root
			return temp;
    	}
	}
	
	public boolean checkLeftChild (Node n) {
		if (n.parent.leftChild instanceof Node) {
			if (n.parent.leftChild.key == n.key){
				return true;
			}
		}
		return false;
	}
	
	public void deleteNode(int k){
		Node nodeTobeDeleted = IterativeSearch(k);
		if (nodeTobeDeleted == null ) {
			System.out.println("No such node found");
			return;
		}

		if (nodeTobeDeleted.getLeft() == null && nodeTobeDeleted.getRight() == null) {
			System.out.println("Case 1: Leaf Node");
			nodeTobeDeleted = null;
			return;
		}
		else if (nodeTobeDeleted.getLeft() != null && nodeTobeDeleted.getRight() != null) {
			System.out.println("Case 1: Node has 2 children");
			return;
		}
		else {
			System.out.println("Case 1: Node has only 1 child");
			if (nodeTobeDeleted.getLeft() != null){
				// Node has a left Child
				nodeTobeDeleted.leftChild.parent = nodeTobeDeleted.parent;
				nodeTobeDeleted.resetChildPointers();
			}
			else {
				// Node has a right Child
				nodeTobeDeleted.rightChild.parent = nodeTobeDeleted.parent;
				nodeTobeDeleted.resetChildPointers();
			}
			nodeTobeDeleted = null;
			return;
			}
		}
			
			
			
			
			// case 2 - node has 2 children
//		if (nodeTobeDeleted.leftChild instanceof Node 
//					&& nodeTobeDeleted.rightChild instanceof Node) {
//				System.out.println("Case 2: Node with 2 children");
//				Node nextLarger = nextLarger(nodeTobeDeleted.key);
//				nextLarger.parent = nodeTobeDeleted.parent;		
//				if (checkLeftChild(nodeTobeDeleted)){
//					// its a left child
//					nodeTobeDeleted.parent.leftChild = nextLarger;
//				}
//				else {
//					// its a right child
//					nodeTobeDeleted.parent.rightChild = nextLarger;
//				}
//				nextLarger.leftChild = nodeTobeDeleted.leftChild;
//			return;
//			}
//			// case 3 - node has 1 child
//			else {
//				System.out.println("Case 2: Node with 1 child");
//				if (nodeTobeDeleted.leftChild != null){
//					// node has left child
//					nodeTobeDeleted.leftChild.parent = nodeTobeDeleted.parent;
//					if (checkLeftChild(nodeTobeDeleted)) {
//						nodeTobeDeleted.parent.leftChild = nodeTobeDeleted.leftChild;
//						nodeTobeDeleted = null;
//					}
//					else {
//						nodeTobeDeleted.parent.rightChild = nodeTobeDeleted.leftChild;
//						nodeTobeDeleted = null;
//					}
//				}
//				else {
//					// node has right child
//					nodeTobeDeleted.rightChild.parent = nodeTobeDeleted.parent;
//					if (checkLeftChild(nodeTobeDeleted)) {
//						nodeTobeDeleted.parent.leftChild = nodeTobeDeleted.rightChild;
//						nodeTobeDeleted = null;
//					}
//					else {
//						nodeTobeDeleted.parent.rightChild = nodeTobeDeleted.rightChild;
//						nodeTobeDeleted = null;
//					}
//				}
//			return;
//			}

	
	public void RepresentationInvariant(){
		System.out.println();
		System.out.println("Root is " + this.root);
		System.out.println("Current is " + this.current);;
	}
	
}

