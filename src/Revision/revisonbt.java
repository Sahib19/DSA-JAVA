package Revision;

class BinaryTree {
    static int idx = -1;

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

    public Node createTree(int[] preorder) {
        idx++;
        if (preorder[idx] == -1) {
            return null;
        }
        Node newNode = new Node(preorder[idx]);
        newNode.left = createTree(preorder);
        newNode.right = createTree(preorder);

        return newNode;
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);

        return lc + rc + 1;
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfD = lh + rh + 1;

        return Math.max(selfD, Math.max(ld, rd));

    }

    public static class Info{
        int dia ;
        int height ;

        Info( int dia , int height){
            this.dia = dia ;
            this.height = height ;
        }
    }

    public Info findDiameter(Node root){
        if(root ==  null ){
            return new Info(0,0); // (diameter , height )
        }

        Info leftD = findDiameter(root.left);
        Info rightD = findDiameter(root.right);

        int selfDiameter = leftD.height + rightD.height +1 ;
        int resDia = Math.max(leftD.dia , Math.max(rightD.dia , selfDiameter));
        int height = Math.max(leftD.height ,rightD.height)+1;

        return new Info(resDia , height);

    }

}

public class revisonbt {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = new BinaryTree.Node(1);

        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);

        root.left.left = new BinaryTree.Node(4);
        root.left.left.left = new BinaryTree.Node(7);
        root.left.left.left.left = new BinaryTree.Node(8);
        root.left.right = new BinaryTree.Node(5);

        root.right.right = new BinaryTree.Node(6);

        System.out.println(bt.findDiameter(root).dia);


    }
}
