package BinarySearchTree;

public class BST {
	node root;
	int heightOfBST = -1;
	
	public void insertKey(int k) {
		if (heightOfBST == -1) { // inserting the root node
			heightOfBST = 0 ; // because the only root node is a leaf node
			root = new node();
			root.key = k;
			root.leftChild = null;
			root.rightChild = null;
			root.parentNode = null;
			
		}
		else {
			node insertedNode = new node();
			insertedNode.parentNode = root;
			if (k <= root.key) {
		
				root.leftChild = insertedNode;
			}
			else {
				root.rightChild = insertedNode;
			}
			
		}
	}
	  
	private class node {
		int key ;
		int heightofNode = 0;
		node leftChild = null;
		node rightChild = null;
		node parentNode = null;
	}
}

