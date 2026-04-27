package Revision;
import java.util.*;

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

    public static class Info {
        int dia;
        int height;

        Info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    public Info findDiameter(Node root) {
        if (root == null) {
            return new Info(0, 0); // (diameter , height )
        }

        Info leftD = findDiameter(root.left);
        Info rightD = findDiameter(root.right);

        int selfDiameter = leftD.height + rightD.height + 1;
        int resDia = Math.max(leftD.dia, Math.max(rightD.dia, selfDiameter));
        int height = Math.max(leftD.height, rightD.height) + 1;

        return new Info(resDia, height);

    }

    public Node findNode(Node root1, Node root2) {
        if (root1 == null) {
            return null;
        }

        if (root1.data == root2.data) {
            return root1;
        }

        Node findLeft = findNode(root1.left, root2);
        Node findRight = findNode(root1.right, root2);

        if (findLeft != null) return findLeft;
        else return findRight;
    }

    public boolean subtreeOfATree(Node root1, Node root2) {
        Node dest = findNode(root1, root2);
        if (dest == null) return false;
        else return checkSubtree(dest, root2);
    }

    public boolean checkSubtree(Node parent, Node subroot) {
        if (parent == null && subroot == null) {
            return true;
        }

        if (parent == null || subroot == null || parent.data != subroot.data) {
            return false;
        }

        if (!checkSubtree(parent.left, subroot.left)) {
            return false;
        }
        if (!checkSubtree(parent.right, subroot.right)) {
            return false;
        }

        return true;
    }

    public static class Info2{
        int hd ;
        Node node;

        Info2( int hd , Node node){
            this.hd = hd;
            this.node = node;
        }
    }

    public void topViewOfTree(Node root){
        Queue <Info2> q1 = new LinkedList<>();
        HashMap <Integer , Node> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        q1.add(new Info2(0,root));
        q1.add(null);

        while(!q1.isEmpty()){
            Info2 curr = q1.remove();
            if(curr == null){
              if(q1.isEmpty()){
                  break;
              }else{
                  q1.add(null);
              }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd , curr.node);
                }

                if(curr.node.left != null){
                    q1.add(new Info2(curr.hd-1 , curr.node.left));
                    min = Math.min(curr.hd-1 , min);
                }

                if(curr.node.right != null){
                    q1.add(new Info2(curr.hd+1 , curr.node.right));
                    max = Math.max(curr.hd+1 , max);
                }
            }

        }

        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
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
        root.left.right = new BinaryTree.Node(5);
        root.right.right = new BinaryTree.Node(6);

//        BinaryTree.Node root2 = new BinaryTree.Node(2);
//        root2.left = new BinaryTree.Node(4);
//        root2.left.left = new BinaryTree.Node(7);
//        root2.right = new BinaryTree.Node(5);

        bt.topViewOfTree(root);


    }
}
