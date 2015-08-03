package BinarySearchTree;

class Node {
	int key;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	public Node(int k) {
		key = k;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
}
