package BinarySearchTree;

class Node {
	int key;
	int heightOfNode;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	public Node(int k) {
		this.key = k;
		this.heightOfNode = -1;
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
	}
}
