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

}

public class revisonbt {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bs = new BinaryTree();
        BinaryTree.Node root = bs.createTree(preorder);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
    }
}
