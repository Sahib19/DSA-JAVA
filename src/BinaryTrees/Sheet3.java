package BinaryTrees;
import java.util.*;

public class Sheet3 {
    //
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data ;
            this.right = null ;
            this.left = null ;
        }
    }

    //Using level order transversal
    public static void printKthLevelNodes(Node root , int k){
        if(root == null){
            System.out.println("The tree is Empty");
            return;
        }
        Queue <Node> q = new LinkedList <>();
        int level = 1 ;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    level++;
                    if(level > k){
                        break;
                    }
                }
            }else{ // but agar to actual node huyi then
                if(k == level){
                    System.out.print(curr.data+" ");
                }
                if(curr.left != null ){
                    q.add(curr.left);
                }
                if(curr.right != null ){
                    q.add(curr.right);
                }
            }
        }


    }

    // Using preOrder Transversal
    // order in preOrder is -  root left right
    public static void kthNode(Node root , int level , int k){
        if( root == null ){
            return;
        }
        if(level == k){
            System.out.print(root.data+" " );
            return;
        }

        kthNode(root.left , level+1 , k);
        kthNode(root.right , level+1 , k);
    }

    public static void main(String[] args){

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
        printKthLevelNodes(root, 3);
System.out.println();
        //recursive Approach
        kthNode(root,1 , 3);

    }
}
