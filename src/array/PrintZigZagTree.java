package array;

import java.util.Stack;

/**
 *
 */
public class PrintZigZagTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        //root.right.right = new Node(7);

        PrintZigZagTree printZigZagTree = new PrintZigZagTree();
        printZigZagTree.printZigZag(root);

    }

    void printZigZag(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.empty()) {
            while(!s1.isEmpty()){
                Node pop = s1.pop();
                System.out.println(pop.data);
                if(pop.right!=null)
                    s2.push(pop.right);
                if(pop.left!=null)
                    s2.push(pop.left);
            }

            while(!s2.isEmpty()) {
                Node pop = s2.pop();
                System.out.println(pop.data);
                if(pop.left!=null) {
                    s1.push(pop.left);
                }
                if(pop.right!=null)
                    s1.push(pop.right);
            }
        }


    }


}


class Node  {
    Node left;
    Node right;
    int data;

    Node(int d) {
        this.data = d;
    }
}
