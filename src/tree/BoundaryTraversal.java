package tree;

/**
 * Given a binary tree, print boundary nodes of the binary tree
 * Anti-Clockwise starting from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”


 */
public class BoundaryTraversal {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);


        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        boundaryTraversal.traverse(root);
    }

    void traverse(Node root) {

        if(root==null) return;
        if(root.left == null && root.right == null) {
            System.out.println(root.data);
            return;
        }

        printLeft(root);

        printLeaves(root);

        printRight(root.right);

    }

    void printLeft(Node root) {
        if(root == null) return;



        if(root.left!=null) {
            System.out.println(root.data);
            printLeft(root.left);
        }

        if(root.left==null && root.right!=null) {
            System.out.println(root.data);
            printLeft(root.right);}
    }

    void printLeaves(Node root) {

        if(root==null) return;
        printLeaves(root.left);

        if(root.left == null && root.right==null) {
            System.out.println(root.data);
        }

        printLeaves(root.right);
    }

    void printRight(Node root) {
        if(root==null) return;

        if(root.right!=null) { printRight(root.right);
            System.out.println(root.data);}

        if(root.right == null && root.left!=null) {printRight(root.left);
            System.out.println(root.data);
        }


    }
}
