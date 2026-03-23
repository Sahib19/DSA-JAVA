package BinaryTrees;

import java.util.*;

public class problemSheet {
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

    public static void lot(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static boolean Unilateral(Node root, int temp) {
        if (root == null) {
            return true;
        }

        if (root.data == temp || temp == -1) {
            temp = root.data;
        } else {
            return false;
        }

        return Unilateral(root.left, temp) && Unilateral(root.right, temp);

    }

    public static void invertedTree(Node root) {
        if (root == null) return;

        // Swapping of link
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertedTree(root.left);
        invertedTree(root.right);

    }

    public static boolean deleteX(Node root, int x) {
        if (root == null) {
            return false;
        }

        boolean left = deleteX(root.left, x);
        boolean right = deleteX(root.right, x);

        if (!left && !right && root.data == x) { //  both ar null - delete the node
            return false; // mujhe delete krdo
        }
        if (!left && right) { // left me false and right me true
            root.left = null;
        } else if (left && !right) { // right me false and left me true
            root.right = null;
        } else { //  both are false
            root.left = root.right = null;
        }

        return true;
    }

    public static String duplicateSubtree(Node root,
                                          ArrayList<String> res,
                                          HashMap<String, Integer> map) {

        if (root == null) {
            return "N";   // VERY IMPORTANT (to maintain structure)
        }

        // get left and right subtree strings
        String left = duplicateSubtree(root.left, res, map);
        String right = duplicateSubtree(root.right, res, map);

        // create current subtree string
        String curr = root.data + "," + left + "," + right;

        // store in map
        if (!map.containsKey(curr)) {
            map.put(curr, 1);
        } else {
            if (map.get(curr) == 1 ) {

                res.add(curr);   // add only once
            }
            map.put(curr, map.get(curr) + 1);
        }


        return curr;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);

        ArrayList<String> res = new ArrayList<>();
        HashMap <String,Integer> map = new HashMap<>();
        duplicateSubtree(root, res, map);

        for (String re : res) {
            System.out.println(re);
        }


        //Formation of Binary Tree -  main tree
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.right.right.right = new Node(8);

        // Second Binary tree
       /* Node root2 =  new Node(1);
        root2.left = new Node(1);
        root2.left.left = new Node(1);
        root2.left.right = new Node(1);
        root2.right = new Node(1);
        root2.right.left = new Node(1);
        root2.right.right = new Node(1);*/

        //        System.out.println(Unilateral(root2,-1));
//        lot(root);
//        invertedTree(root); System.out.println();
//        lot(root);

        //Third binary tree
//        Node root3 = new Node(1);
//        root3.left = new Node(3);
//        root3.left.left = new Node(3);
//        root3.left.right = new Node(4);
//        root3.left.left.left = new Node(3);
//
//        root3.right = new Node(2);
//        root3.right.right = new Node(5);
//        root3.right.left = new Node(4);
//        root3.right.right.left = new Node(3);
//        lot(root3);
//        deleteX(root3,3); System.out.println();
//        lot(root3);


    }
}
