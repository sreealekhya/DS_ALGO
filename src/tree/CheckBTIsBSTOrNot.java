package tree;

/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 • The left subtree of a node contains only nodes with keys less than the node’s key.
 • The right subtree of a node contains only nodes with keys greater than the node’s key.
 • Both the left and right subtrees must also be binary search trees.

 From the above properties it naturally follows that:
 • Each node (item in the tree) has a distinct key.
 */
public class CheckBTIsBSTOrNot {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left= new Node(0);

        CheckBTIsBSTOrNot checkBTIsBSTOrNot = new CheckBTIsBSTOrNot();
        System.out.println(checkBTIsBSTOrNot.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    boolean isBST(Node root,int min,int max) {
       if(root==null) {
           return true;
       }

       if(root.data<min || root.data>max) {
           return false;
       }

       return isBST(root.left,min,root.data-1) && isBST(root.right,root.data+1,max);
    }
}
