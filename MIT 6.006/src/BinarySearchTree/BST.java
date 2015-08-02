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
	
	// inserts a new node into the BST
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
		numberOfNodes++;
		System.out.printf("%02d key Inserted", n.key);
		System.out.println();
	}
	
	public Node BSTMin(){
		Node x = this.root;
		while (x.leftChild != null){
			x = x.leftChild;
		}
		return x;
	}
	
	public Node BSTMax(){
		Node x = root;
		while (x.rightChild != null){
			x = x.rightChild;
		}
		return x;
	}
	

}

