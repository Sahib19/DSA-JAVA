package BinaryTrees;

public class sheet2 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node( int data){
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam , int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static int height ( Node root){
        if( root == null){
            return 0 ;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.max(leftH,rightH)+1 ;
    }

    // Time complexity is O(n^2)
    public static int diameterOfTree(Node root){
        if(root == null){
            return 0; // null node have diameter as well as height = 0
        }
        int ld = diameterOfTree(root.left);
        int rd = diameterOfTree(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfD = lh+rh+1 ;

        return Math.max(selfD , Math.max(ld,rd));
    }

    public static Info Diameter ( Node root){
        if( root == null){
            return new Info( 0,0);
        }

        Info leftInfo = Diameter(root.left);
        Info rightInfo = Diameter(root.right);

        // calculating self diameter
        int diam = Math.max(leftInfo.ht+rightInfo.ht+1 , Math.max(leftInfo.diam,
                rightInfo.diam));

        int ht = Math.max(leftInfo.ht , rightInfo.ht) +1 ;

        return new Info(diam,ht);
    }
    public static void main(String [] args){

        //Formation of Binary Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);
        root.right.right.right = new Node (8);

        System.out.println("Height of the tree is "+ height(root));
        System.out.println("Diameter of the tree is "+ diameterOfTree(root));
        System.out.println("Diameter of the tree is "+ Diameter(root).diam);

    }
}
