package BinarySearchTree;


public class BST {
	Node root;
	int numberOfNodes;
	int heightOfTree;
	
	public BST() {
		root = null;
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
		Node x = b.root;
		if  (x == null || k == x.key){
			return x;
		}
		if (k <  x.key){
			b.root = x.leftChild;
			return RecursiveSearch(b,k);
			}
		else {
			b.root = x.rightChild;
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
	public void InorderTraversal(BST b){
		 Node x = b.root;
		 if ( x != null){
			 b.root = x.leftChild;
			 InorderTraversal(b);
			 System.out.printf("%02d ", x.key);
			 b.root = x.rightChild;
			 InorderTraversal(b);
		 }
	}
	
}

