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


    // Optimised code for O(n)
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

    //Subtree of another tree
    public static boolean subTree( Node root , Node subRoot){
        // chekcing if the main tree is empty
        if( root ==  null){
             return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        return subTree(root.left , subRoot) || subTree(root.right,subRoot);
    }

    public static boolean isIdentical ( Node root , Node subRoot){
        if(root == null && subRoot ==  null){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }

        if(!isIdentical(root.left , subRoot.left)){
            return false;
        }
        if(!isIdentical(root.right , subRoot.right)){
            return false;
        }
        return true;
    }

    public static void main(String [] args){

        //Formation of Binary Tree -  main tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.right = new Node (7);
        root.right.right.right = new Node (8);

        // Subtree
        Node subRoot =  new Node (3);
        subRoot.left = new Node(6);
        subRoot.right = new Node(7);
        subRoot.right.right = new Node(8);

        System.out.println("Height of the tree is "+ height(root));
        System.out.println("Diameter of the tree is "+ diameterOfTree(root));
        System.out.println("Diameter of the tree is "+ Diameter(root).diam);

        // Subtree in a tree
        System.out.println("Subtree if a tree "+subTree(root,subRoot));

    }
}
