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
	
	public Node RecursiveSearch(BST b, int k) {
		Node x = b.current;
		// base case
		if  (x == null || k == x.key){
			current = root; // reset the current pointer
			return x;
		}
		// recursion
		if (k <  x.key){
			b.current = x.leftChild;
			return RecursiveSearch(b,k);
			}
		else {
			b.current = x.rightChild;
			return RecursiveSearch(b,k);
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
	
	public void RepresentationInvariant(){
		System.out.println();
		System.out.println("Root is " + this.root);
		System.out.println("Current is " + this.current);;
	}
	
}

