package BinarySearchTree;


public class BST {
	Node root;
	Node current; 
	int numberOfNodes;
	int heightOfTree;
	
	public BST() {
		root = null;
		current = root;
		numberOfNodes = 0;
		heightOfTree = -2;
	}
	
	// Insertion
	public void insertNode (Node n){
		Node y = null;
		Node x = root; // pointer to find the position of insert
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
			root = n;
			current = n;
		}
		else if(n.key < y.key){
			y.leftChild = n;
		}
		else {
			y.rightChild = n;
		}
		System.out.printf("%02d key Inserted", n.key);
		System.out.println();
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
		Node x = current;
		// base case
		if  (x == null || k == x.key){
			current = root; // reset the current pointer
			return x;
		}
		// recursion
		if (k <  x.key){
			current = x.leftChild;
			return RecursiveSearch(k);
			}
		else {
			current = x.rightChild;
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
	
	// Inorder Traversal
	public void InorderTraversal(){
		 Node x = current;
		 if ( x != null){
			 current = x.leftChild;
			 InorderTraversal();
			 System.out.printf("%02d ", x.key);
			 current = x.rightChild;
			 InorderTraversal();
		 }
		 else {
			 // reset the current pointer
			 current = root;
		 }
	}
	// height of a node = length (# edges) of longest downward path to a leaf
	// height of a node = max{height of left child,height of right child} + 1
	// height of a leaf node = 0
	// height of a null node = -1
	public int getHeightofBST(){
		Node x = current;
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
	
	public void delete(Node n){
		Node temp = IterativeSearch(n.key);
		if (temp == null){
			System.out.println("No such key found");
			return;
		}
		if (temp.leftChild == null || temp.rightChild == null){
			// if a leaf node
			temp = null;
			return;
		}
		else {
			// not a leaf node
		}
		
	}
	
	public void RepresentationInvariant(){
		System.out.println();
		System.out.println("Root is " + this.root);
		System.out.println("Current is " + this.current);;
	}
	
}

