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
	
	// Successor and Predecessor can be found using iterative search
	// No need to duplicate code
	
	public void deleteNode(int k){
		Node nodeTobeDeleted = IterativeSearch(k);
		if (nodeTobeDeleted == null ) {
			System.out.println("No such node found");
			return;
		}
		else {
			if (nodeTobeDeleted.leftChild == null && nodeTobeDeleted.leftChild == null) {
				// leaf node
				if (nodeTobeDeleted.parent.leftChild instanceof Node ){
					// node to be deleted was left child
					nodeTobeDeleted.parent.leftChild = null;
					nodeTobeDeleted = null;
				}
				else {
					// node to be deleted was right child;
					nodeTobeDeleted.parent.rightChild = null;
					nodeTobeDeleted = null;
				}
		}	
		}
		/*
		if (nodeTobeDeleted != null ){
			Node parentNode = nodeTobeDeleted.parent;
			// leaf node
			if (nodeTobeDeleted.leftChild == null && nodeTobeDeleted.rightChild == null){
				if (parentNode.leftChild != null){
					parentNode.leftChild = null;
					nodeTobeDeleted.parent = null;
				}
				else {
					parentNode.rightChild = null;
					nodeTobeDeleted.parent = null;
				}
			return;
			}
			
			// non-leaf node having 1 child
			if (nodeTobeDeleted.leftChild == null || nodeTobeDeleted.rightChild == null) {
				// the node doesn't have a left child
				if (nodeTobeDeleted.leftChild == null) {
					Node successor = nodeTobeDeleted.rightChild;
					if (parentNode.leftChild != null ){
						parentNode.leftChild = successor;
						successor.parent = parentNode;
						nodeTobeDeleted.parent = null;
					}
					else {
						parentNode.rightChild = successor;
						successor.parent = parentNode;
						nodeTobeDeleted.parent = null;
					}
				}
			   else {
				// the node doesn't have a right child
				   Node successor = nodeTobeDeleted.leftChild;
				   if (parentNode.leftChild != null){
					  parentNode.rightChild = successor;
					  successor.parent = parentNode;
					  nodeTobeDeleted.parent = null;
				   }
				   else {
					  parentNode.leftChild = successor;
					  successor.parent = parentNode;
					  nodeTobeDeleted.parent = null;
				  }
			   }
			 return;
			}
			// non-leaf node having 2 children
	
			Node successor = nodeTobeDeleted.rightChild;
			if (successor.leftChild != null) {
				// the successor has a left child
				if (parentNode.leftChild.key == nodeTobeDeleted.key){
					parentNode.leftChild = successor;
					successor.parent = parentNode;
					successor.leftChild.leftChild = nodeTobeDeleted.leftChild;
					nodeTobeDeleted.leftChild.parent = successor.leftChild;
				}
				else {
					parentNode.rightChild = successor;
					successor.parent = parentNode;
					successor.leftChild = nodeTobeDeleted.leftChild;
					nodeTobeDeleted.leftChild.parent = successor;
				}
			}
			}
			*/


	}
	
	public void RepresentationInvariant(){
		System.out.println();
		System.out.println("Root is " + this.root);
		System.out.println("Current is " + this.current);;
	}
	
}

