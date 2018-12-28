package tree;

/**
 * calculate height of BT
 */
public class HeightOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        /*root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);*/

        HeightOfTree heightOfTree = new HeightOfTree();
        System.out.println(heightOfTree.calculate(root));
    }


    int calculate(Node root) {
        if(root == null) return 0;

        return 1+ Math.max(calculate(root.left),calculate(root.right));
    }

}
