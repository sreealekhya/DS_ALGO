package linkedlist;

/**
 * Created by Sreemani Alekhya on 06/01/19.
 */
public class ReverseKNodes {

    private static Node h1;

    private static Node h2;
    public static void main(String[] args) {
        Node head = new Node(1,new Node(4,new Node(9,new Node(5,new Node(6)))));
        ReverseKNodes reverseKNodes = new ReverseKNodes();

        reverseKNodes.reverse(head, 3);

        Node n =h2;
        while (n!=null) {
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
        System.out.println("null");

    }

    void reverse(Node head, int k) {
        Node next = null;
        Node prev = null;
        while(head!=null) {
            int i = 0;
            //Node prev = next;

            next = head;
            while (i != k-1 && next.getNext() != null) {
                next = next.getNext();
                i++;
            }

            Node nextOfnext = next.getNext();

            reverse(head,next);


            if(prev!=null)
                prev.setNext(next);
            else
                h2 = next;

            head.setNext(nextOfnext);
            prev = head;
            head = nextOfnext;

        }


    }

    Node reverse (Node start,Node end) {
        if(start==end) {
            h1=end;
            return end;
        }

        Node next = reverse(start.getNext(),end);

        next.setNext(start);

        return start;
    }

}
