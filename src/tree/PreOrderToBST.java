package tree;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Stack;

/**
 * Given preorder traversal of a binary search tree, construct the BST.

 For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
      10
    /   \
   5     40
 /  \      \
 1    7      50


 Below is the Iterative Solution
 Find Recursive soution in PostOrderToBst
 */
public class PreOrderToBST {

    public static void main(String[] args) {

        int[] preOrder = {10, 5, 1, 7, 40, 50};

        PreOrderToBST preOrderToBST = new PreOrderToBST();

        Node root = preOrderToBST.doesIt(preOrder);

        preOrderToBST.InOrderTraversal(root);



    }

    Node doesIt(int[] preOrder) {
        Stack<Node> stack = new Stack<>();
        Node root = new Node(preOrder[0]);
        stack.push(root);

        for(int i=1;i<preOrder.length;i++) {
            Node n = null;
            while(!stack.isEmpty() && stack.peek().data<preOrder[i]) {

                n = stack.pop();
            }

            if(n!=null)
            {
                n.right = new Node(preOrder[i]);
                stack.push(n.right);
            }

            if(!stack.isEmpty() && n==null) {
               n = stack.peek();
               n.left = new Node(preOrder[i]);
                stack.push(n.left);
            }


        }
        return root;
    }

    void InOrderTraversal(Node root) {
        if(root ==null) return;

        InOrderTraversal(root.left);
        System.out.println(root.data);
        InOrderTraversal(root.right);
    }

}
