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
		// find the minimum
		Node min = bst.FindMin();
		System.out.printf("Minimum of the BST is %d \n", min.key);
		// find the maximum
		Node max = bst.FindMax();
		System.out.printf("Maximum of the BST is %d \n", max.key);
		// find key 15
		Node f = bst.IterativeSearch(15);
		if (f == null) {
			System.out.println("Key not found\n");
		}
		else {
			System.out.println("Key found\n");
		}
	}

}
