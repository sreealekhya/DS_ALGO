package tree;

/**
 * Created by Sreemani Alekhya on 31/12/18.
 *
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

 Example:

 Input: Root of below tree
 1
 / \
 2   3
 Output: 6

 See below diagram for another example.
 1+2+3
 */
public class MaxSumPath {

    private static int res = 0;

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        MaxSumPath maxSumPath = new MaxSumPath();
        maxSumPath.calculate(root);
        System.out.println(res);

    }


    int calculate(Node root) {
        if(root ==null) return 0;

        int ld = calculate(root.left);
        int rd = calculate(root.right);

        // if it propogates to its parent
        int max_val = Math.max(root.data+Math.max(ld,rd),root.data);

        //if it does not include its parent's data
        int max_val_2 = Math.max(max_val,root.data+ld+rd);

        res = Math.max(res,max_val_2);

        return max_val;


    }
}
