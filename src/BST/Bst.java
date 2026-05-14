package BST;

public class Bst {
    public static class Node{
        int data;
        Node left; // by deafult null ata hia inme
        Node right; // by default null come here

        Node( int data){
            this.data = data;
        }
    }

    public static Node createBST(Node root , int value){
        if( root == null){
            return new Node(value);
        }
        if(value < root.data){
            root.left = createBST(root.left , value);
        }else{
            root.right = createBST(root.right , value);
        }

        return root;
    }

    public static void inorder(Node root){
        if( root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main (String [] args){
        int [] values = {5,9,6,1,4,6,2};
        Node root = null ;
        for( int i = 0  ; i < values.length ; i++){
            root = createBST(root , values[i]);
        }

        inorder(root);

    }
}
