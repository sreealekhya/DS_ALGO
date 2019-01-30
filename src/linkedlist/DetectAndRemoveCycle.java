package linkedlist;

/**
 * Write a function detectAndRemoveLoop() that checks whether a given
 * Linked List contains loop and if loop is present then removes the
 * loop and returns true. And if the list doesn’t contain loop then returns false.
 * Below diagram shows a linked list with a loop. detectAndRemoveLoop() must change
 * the 1->2->3->4->5->2 list to 1->2->3->4->5->NULL.
 */
public class DetectAndRemoveCycle {

    public static void main(String[] args) {
        Node last  = new Node(3);
        Node secLast = new Node(2,last);
        Node head = new Node(1,secLast);
        last.setNext(secLast);

        DetectAndRemoveCycle detectAndRemoveCycle = new DetectAndRemoveCycle();
        head = detectAndRemoveCycle.dAndR(head);

        Node n = head;

        while (n!=null) {
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
        System.out.println("null");
    }

    Node dAndR(Node head) {
        if(head ==null) return null;
        if(head.getNext()==head) {
            head.setNext(null);
            return head;
        }

        Node slow = head.getNext(),fast=head.getNext().getNext();

        while(fast.getNext()!=null && fast.getNext().getNext()!=null && slow!=fast) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if(slow!=fast) return head;

        slow = head;

        while(slow.getNext()!=fast.getNext()) {
            slow=slow.getNext();
            fast = fast.getNext();

        }

        //if starting node is part of loop present in the LL.
        if(slow==fast) {
            while(fast.getNext()!=slow) {
                fast = fast.getNext();
            }
        }

        fast.setNext(null);
        return head;

    }
}
