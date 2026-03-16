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

    // DFS transversal Techniques - post , in , pre - order

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


    public static void  preOrder (Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    // BFS transversal Techniques - level order Technique
    public static void levelOrderTraversal(Node root) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);   // level separator

        while (!q.isEmpty()) {

            Node currNode = q.remove();

            if (currNode == null) {

                System.out.println(); // move to next level

                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {

                System.out.print(currNode.data + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int heightOfBS  ( Node root){
        if( root == null){
            return 0 ;
        }
        int leftH = heightOfBS(root.left);
        int rightH = heightOfBS(root.right);

        return Math.max(leftH,rightH) +1 ;
    }

    public static int countNodes ( Node root){
        if( root == null){
            return 0 ;
        }

        int leftCount = countNodes (root.left);
        int rightCount = countNodes (root.right);

        return leftCount+rightCount+1;
    }

    public static int sumOfNodes( Node root){
        if(root ==  null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes( root.right);

        return leftSum+rightSum+root.data;
    }

    public static void main(String[] args) {

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree bs = new BinaryTree();
        Node root = bs.buildTree(nodes);

        System.out.println("Root Node: " + root.data);

//        BinaryTreePrinter.printTree(root, 0);
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        //
        levelOrderTraversal(root);
        System.out.print("height of Binary tree is = ");
        System.out.println(heightOfBS(root));
        System.out.println("No. of nodes in binary tree is "+countNodes(root));
        System.out.println("The sum of Nodes is = "+sumOfNodes(root));
    }
}