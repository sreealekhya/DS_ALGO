package tree;

/* Given a binary tree (not a binary search tree)
and two values say n1 and n2, write a program
        to find the least common ancestor.
        n1 or n2 can also be LCA
        */
public class LeastCommonAncestor {

    public static boolean v1=false,v2 = false;

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();

        Node lca = leastCommonAncestor.LCA(root,root.left.left,root.left);

        if(v1 == v2 == true)
            System.out.print(lca.data);


    }


    Node LCA(Node root, Node n1, Node n2) {
        if(root == null) return null;
        Node temp = null;
        if(root == n1) {
            v1= true;
            temp =  root;

        }


        if(root == n2) {
            v2 = true;
            temp = root;
        }

        Node left_lca = LCA(root.left , n1,n2);

        Node right_lca = LCA(root.right,n1,n2);

        if(temp!=null) return temp;

        if (left_lca!=null && right_lca!=null) {
            return root;
        }

        return left_lca == null ? right_lca : left_lca;

    }
}

