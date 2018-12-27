package tree;

/**
 * Given a binary tree, we need to find maximum value we can get
 * by subtracting value of node B from value of node A,
 * where A and B are two nodes of the binary tree and A is an ancestor of B.
 * Expected time complexity is O(n).
 */
public class MaximumDifferenceBWNodeAndAncestors {

    public static int diff = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(8);
        root.right = new Node(0);
        root.right.left = new Node(-2);

        MaximumDifferenceBWNodeAndAncestors maxDiff = new MaximumDifferenceBWNodeAndAncestors();
        maxDiff.getMaxiDiff(root);
        System.out.println(diff);

    }

    int getMaxiDiff(Node root) {

        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null) {
            return root.data;
        }


        int min_val = Math.min(getMaxiDiff(root.left),getMaxiDiff(root.right));

        diff = Math.max(diff,root.data-min_val);


        return Math.min(min_val,root.data);

    }
}
