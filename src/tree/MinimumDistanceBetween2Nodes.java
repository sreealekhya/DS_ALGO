package tree;

/**
 * Find the distance between two keys in a binary tree, no parent pointers are given.
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
 */
public class MinimumDistanceBetween2Nodes {

    public static boolean v1=false,v2=false;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        MinimumDistanceBetween2Nodes minimumDist = new MinimumDistanceBetween2Nodes();


        int dist = minimumDist.getMinimumDist(root,5,1) ;

        System.out.println(dist);

    }


    int getMinimumDist(Node root, int a ,int b){
        Node n = LCA(root,a,b);

        if(!v1 || !v2) return 0;

        int depthOfA = getDepth( n, a, 0);
        int depthOfB = getDepth(n,b, 0);

        return depthOfA+depthOfB;
    }


    int getDepth(Node n, int a, int depth) {
        if(n == null) return -1;

        if(n.data==a) return depth;

        int left_depth = getDepth(n.left, a, depth+1);

        if(left_depth==-1)
            return getDepth(n.right,a,depth+1);

        return left_depth;

    }


    Node LCA(Node root, int a , int b) {
        if(root == null) return null;
        Node temp = null;
        if(root.data == a ) {
            v1 =true;
            temp =  root;
        }

        if(root.data == b) {
            v2 = true;
            temp =  root;
        }

        Node left_lca = LCA(root.left,a,b);
        Node right_lca = LCA(root.right,a,b);

        if(temp!=null) return temp;

        if(left_lca !=null && right_lca!=null) return root;

        return left_lca!=null ? left_lca : right_lca;
    }
}
