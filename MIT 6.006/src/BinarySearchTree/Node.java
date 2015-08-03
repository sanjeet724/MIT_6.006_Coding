package BinarySearchTree;

class Node {
	int key;
	int heightOfNode;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	public Node(int k) {
		key = k;
		heightOfNode = -1;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
}
