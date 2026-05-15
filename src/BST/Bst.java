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
    public static Node deleteNode(Node root , int val){ // val is the
        // value that we want to delete from the tree
        if( root == null){
            // no such node exist;
            return null;
        }
        if( root.data > val){
            root.left  =  deleteNode(root.left , val);
        }else if(root.data < val){
            root.right = deleteNode(root.right , val);
        }else{
            // root.data == val -> issi node ko delete krna hai

            // Case 1 -> Node have no child
            if(root.left == null && root.right == null){
                return null;
            }

            // Case 2 -> Node have one child
            if(root.left == null){
                return root.right;
            }else if ( root.right == null){
                return root.left;
            }

            // Case 3 -> Having two child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right , IS.data);

        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while( root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void main (String [] args){
        int [] values = {5,9,6,1,4,2, 15,14,0};
        Node root = null ;
        for( int i = 0  ; i < values.length ; i++){
            root = createBST(root , values[i]);
        }

        inorder(root); System.out.println();
        deleteNode(root,41);
        inorder(root);

    }
}
