package BinaryTrees;

import java.util.*;

public class Sheet3 {
    //
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    //Level Order Tranversal
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

    //Using level order transversal
    public static void printKthLevelNodes(Node root, int k) {
        if (root == null) {
            System.out.println("The tree is Empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    level++;
                    if (level > k) {
                        break;
                    }
                }
            } else { // but agar to actual node huyi then
                if (k == level) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }


    }

    // Using preOrder Transversal
    // order in preOrder is -  root left right
    public static void kthNode(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthNode(root.left, level + 1, k);
        kthNode(root.right, level + 1, k);
    }

    // Find the lowest common ancestor

    public static boolean findPath(Node root, int n, ArrayList<Node> list) {
        if (root == null) {
            return false;
        }
        list.add(root); // adding node in the arraylist

        if (root.data == n) {
            // found out node
            return true;
        }

        boolean checkLeft = findPath(root.left, n, list);
        boolean checkRight = findPath(root.right, n, list);

        if (checkLeft || checkRight) {
            return true;
        }
        list.removeLast();
        return false;
    }

    //    Time Complexity - O(3n) ~ O(N)
    //    Space complexity - O(n)
    public static int lca(Node root, int n1, int n2) {
        // creating two arraylist to store path of each node
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();

        findPath(root, n1, l1); // O(N)
        findPath(root, n2, l2); // O(N)

        // Find lca
        int i = 0;
        for (; i < l1.size() && i < l2.size(); i++) { // O(N)
            if (l1.get(i) != l2.get(i)) {
                break;
            }
        }

        return l1.get(i - 1).data;

    }

    public static Node lca1(Node root , int p , int q){
        if(root == null || root.data == p || root.data == q){
            return root;
        }


        Node findLeft = lca1(root.left , p , q );
        Node findRight = lca1(root.right , p , q );

        if(findLeft == null){
            return findRight;
        }
        if(findRight == null){
            return findLeft;
        }

        return root;
    }

    public static int minimumDistance(Node root , int node1 , int node2 ){
        if(root == null ){
            return -1 ;
        }
        if(root.data == node1 || root.data == node2){
            return 1;
        }

        int left = minimumDistance(root.left , node1 , node2 );
        int right = minimumDistance(root.right , node1 , node2 );

        if(left == -1 && right == -1){
            return -1;
        }

        if(left == -1 ){
            return ++right ;
        }

        if(right == -1 ){
            return ++left;
        }

        return left+right ;
    }

    public static int kthAncestor( Node root , int k , int target){
        if(root == null){
            // tree is empty ya reached to end
            return -1;
        }

        if(root.data == target){
            return 1 ;
        }

        int leftf = kthAncestor(root.left , k , target); // -1
        int rightf = kthAncestor(root.right , k , target); // 1

        if(leftf == -1 && rightf == -1){
            // na left me mila na right me mila
            return -1 ;
        }

        int max = Math.max(leftf , rightf);
        if( max == k  ){
            System.out.println(root.data);
        }
        return ++max;

    }

    public static void transformTree(Node root){
        if(root == null){
            return ;
        }

        root.data = allNodeSum(root)-root.data;

        transformTree(root.left);
        transformTree(root.right);

    }

    public static int allNodeSum(Node root){
        if(root == null ){
            return 0 ;
        }

        int leftSum = allNodeSum(root.left);
        int rightSum = allNodeSum(root.right);
        return root.data + leftSum + rightSum;

    }

    public static void main(String[] args) {

        //Formation of Binary Tree -  main tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        //Iterative approach
//        printKthLevelNodes(root, 3);
//        System.out.println();
        //recursive Approach
//        kthNode(root, 1, 3);

        // Lowest common ancestor
//        System.out.println(lca(root, 6, 8));
//        System.out.println(lca1(root,6,8).data);
//          System.out.println(minimumDistance(root , 4, 8 ));
//        kthAncestor(root,2,8);
        transformTree(root);
        levelOrderTraversal(root);
    }
}
