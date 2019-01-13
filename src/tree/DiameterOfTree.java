package tree;

/**
 * The diameter of a tree is the number of nodes on the
 * longest path between two leaves in the tree.
 * The diagram below shows two trees each with diameter nine,
 * the leaves that form the ends of a longest path are colored
 * (note that there may be more than one path in tree of same diameter).


 Examples:

 Input :
 1
 /   \
 2      3
 /  \
 4     5

 Output : 4

 Input :
 1
 /   \
 2      3
 /  \ .    \
 4     5 .    6

 Output : 5
 */
public class DiameterOfTree {

    private static int diameter = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);

        DiameterOfTree diameterOfTree = new DiameterOfTree();
        diameterOfTree.calculate(root);
        System.out.println(diameter);

    }

    int calculate(Node root) {
        if(root ==null) return 0;

        int lh = calculate(root.left);

        int rh = calculate(root.right);

        diameter = Math.max(diameter,1+lh+rh);

        return 1+Math.max(lh,rh);
    }
}
