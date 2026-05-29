package BST;

public class Avl {
    static class Node {
        int data, ht;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.ht = 1;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.ht;
    }

    public static int bf(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node rotateRight(Node x) {
        Node y = x.left;
        Node T = y.right;

        y.right = x;
        x.left = T;

        //updating height;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node rotateLeft(Node x) {
        Node y = x.right;
        Node t1 = y.left;

        y.left = x;
        x.right = t1;

        //updating height;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // in case key became equal to the node then it will be duplicate cae os we have t ignore the node
        }
        // updating the height of the node because ek node add huyi hia
        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        // calculating current node balancing factor
        int bf = bf(root);

        // identifying the case
        if (bf > 1 && key < root.left.data) {
            //left left case hai
            root = rotateRight(root);
        } else if (bf > 1 && root.left.data < key) {
            // left right case hai
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (bf < -1 && key > root.right.data) {
            // right right case

            root = rotateLeft(root);

        } else if (bf < -1 && key < root.right.data) {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }


        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    public static void main(String[] args) {
        Node root = insert(null ,10);
        root = insert(root ,20);
        root = insert(root ,30);
        root = insert(root ,40);
        root = insert(root ,50);
        inorder(root);

    }
}
