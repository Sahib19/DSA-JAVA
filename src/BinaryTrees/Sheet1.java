package BinaryTrees;
import java.util.*;

public class Sheet1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Printer class
    static class BinaryTreePrinter {

        static final int SPACE = 5;

        static void printTree(Node root, int space) {

            if (root == null)
                return;

            space += SPACE;

            // Print right subtree first
            printTree(root.right, space);

            // Print current node
            System.out.println();

            for (int i = SPACE; i < space; i++)
                System.out.print(" ");

            System.out.println(root.data);

            // Print left subtree
            printTree(root.left, space);
        }
    }

    // Binary Tree Builder
    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int[] nodes) {

            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void main(String[] args) {

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree bs = new BinaryTree();
        Node root = bs.buildTree(nodes);

        System.out.println("Root Node: " + root.data);

        BinaryTreePrinter.printTree(root, 0);
    }
}