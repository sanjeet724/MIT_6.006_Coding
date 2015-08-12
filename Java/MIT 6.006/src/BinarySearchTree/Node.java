package BinarySearchTree;

class Node {
	int key;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	public Node(int k) {
		this.key = k;
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Node getLeft (){
		if (this.leftChild instanceof Node) {
			return this.leftChild;
		}
		return null;
	}
	
	public Node getRight (){
		if (this.rightChild instanceof Node) {
			return this.rightChild;
		}
		return null;
	}
	
	public Node getParent (){
		if (this.parent instanceof Node){
			return this.parent;
		}
		return null;
	}
	
	public void resetChildPointers(){
		if (this.getParent().getLeft() != null) {
			// it was a left child
			this.parent.leftChild = this.leftChild;
		}
		else {
			// it was a right child
			this.parent.rightChild = this.leftChild;
		}
	}
}
