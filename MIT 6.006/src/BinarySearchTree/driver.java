package BinarySearchTree;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		
		BST bst = new BST();
		Random randomGenerator = new Random();
		// insert some nodes
		for (int i = 0; i < 10; i++){
			Node n = new Node(randomGenerator.nextInt(100));
			bst.insertNode(n);
		}
		Node min = bst.FindMin();
		System.out.printf("Minimum of the BST is %02d \n", min.key);
		Node max = bst.FindMax();
		System.out.printf("Maximum of the BST is %02d \n", max.key);
		// find a given key - we have 2 implementations for search
		// iterative and recursive
		// Node f = bst.IterativeSearch(15);
		Node f = bst.RecursiveSearch(15);
		if (f == null) {
			System.out.println("Key not found");
		}
		else {
			System.out.println("Key found\n");
		}
		System.out.println("Inorder Traversal: ");
		bst.InorderTraversal();
		System.out.println("\nHeight of the BST is: " + bst.getHeightofBST());
		// bst.RepresentationInvariant();
	}
}
