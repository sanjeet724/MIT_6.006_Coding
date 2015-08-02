package BinarySearchTree;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		
		BST bst = new BST();
		Random randomGenerator = new Random();
		for (int i = 0; i < 10; i++){
			Node n = new Node(randomGenerator.nextInt(100));
			bst.insertNode(n);
		}
		Node min = bst.BSTMin();
		System.out.println();
		System.out.printf("Minimum of the BST is %d ", min.key);
		Node max = bst.BSTMax();
		System.out.println();
		System.out.printf("Maximum of the BST is %d ", max.key);
	}

}
