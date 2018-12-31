package linkedlist;

/**
 * Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing links between nodes.

 Examples:

 Input : Head of following linked list
 1->2->3->4->NULL
 Output : Linked list should be changed to,
 4->3->2->1->NULL

 Input : Head of following linked list
 1->2->3->4->5->NULL
 Output : Linked list should be changed to,
 5->4->3->2->1->NULL

 Input : NULL
 Output : NULL

 Input  : 1->NULL
 Output : 1->NULL
 */
public class ReverseALLInPlace {

    public static Node rev_head;
    public static void main(String[] args) {
        Node head = new Node(1,new Node(4,new Node(9)));

        ReverseALLInPlace reverseALLInPlace = new ReverseALLInPlace();

        //recursive
        reverseALLInPlace.reverse(head).setNext(null);


        Node n =rev_head;
        while (n!=null) {
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
        System.out.println("null");

        //iterative

    }

    Node reverse(Node n){
        if(n==null) return null;

        Node n1 = reverse(n.getNext());

        if(n1!=null)
            n1.setNext(n);

        if(n1 == null)
            rev_head= n;
        return n;

    }
}
