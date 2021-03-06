package tree;


import java.util.Scanner;
import java.util.*;

/*

Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL.
The order of nodes in DLL must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

 */

class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }

}

class BT_To_DLL {
    //Node head;


    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);


    }

    void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BT_To_DLL obj = new BT_To_DLL();
        //DLL d = new DLL();
        int t = sc.nextInt();
        while (t > 0) {
            HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
            int n = sc.nextInt();

            Node root = null;

            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                Node parent = hm.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    hm.put(n1, parent);
                    if (root == null) {
                        root = parent;
                        //d.head = root;
                    }

                }

                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;

                hm.put(n2, child);
                n--;
            }

            GfG g = new GfG();
            Node node = g.BToDLL(root);
            obj.printList(node);
            t--;
            System.out.println();
        }
    }
}



/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* class Node
class Node
{
	Node left, right;
	int data;

	Node(int d)
	{
		data = d;
		left = right = null;
	}

}*/
// This function should convert a given Binary tree to Doubly
// Linked List
// root --> Root of Binary Tree
// head --> head of created doubly linked list
class GfG {
    Node head;

    Node BToDLL(Node root) {
        if (root == null) {
            return null;
        }

        Node r = getDLL(root);

        while (r.left != null) {
            r = r.left;
        }

        return r;

        //  Your code here
    }


    Node getDLL(Node n) {

        if (n == null) {
            return null;
        }

        Node left_n = getDLL(n.left);
        //Node n = new Node(n.data);


        while (left_n != null && left_n.right != null) {
            left_n = left_n.right;
        }

        if (left_n != null) {
            left_n.right = n;
        }

        n.left = left_n;

        Node right_n = getDLL(n.right);



        while (right_n != null && right_n.left != null) {
            right_n = right_n.left;
        }
        if (right_n != null) {
            right_n.left = n;
        }
        n.right = right_n;

        return n;


    }


}