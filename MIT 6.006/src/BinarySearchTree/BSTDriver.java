package BinarySearchTree;
import java.util.Random;
import java.util.Scanner;

public class BSTDriver {

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
		/*
		Node f = bst.RecursiveSearch(15);
		if (f == null) {
			System.out.println("Key not found");
		}
		else {
			System.out.println("Key found\n");
		}
		*/
		System.out.println("Inorder Traversal before delete: ");
		bst.InorderTraversal();
		System.out.println("\nHeight of the BST before delete is: " + bst.getHeightofBST());
		// bst.RepresentationInvariant();
		System.out.println("Enter the key you want to delete: ");
		Scanner in = new Scanner(System.in);
		int keyTobeDeleted = in.nextInt();
		bst.deleteNode(keyTobeDeleted);
		System.out.println("Inorder Traversal after delete: ");
		bst.InorderTraversal();
		System.out.println("\nHeight of the BST after delete is: " + bst.getHeightofBST());

		in.close();
	}
}
 