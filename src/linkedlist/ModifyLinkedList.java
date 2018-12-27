package linkedlist;

/**
 * Modify the value of first half nodes such that 1st node’s new value is equal to the last node’s value minus
 * first node’s current value, 2nd node’s new value is equal to the second last node’s value minus 2nd node’s
 * current value, likewise for first half nodes. If n is odd then the value of the middle node remains unchanged.
 *
 * Examples:

 Input : 10 -> 4 -> 5 -> 3 -> 6
 Output : 4 -> 1 -> 5 -> 3 -> 6

 Input : 2 -> 9 -> 8 -> 12 -> 7 -> 10
 Output : -8 -> 2 -> -4 -> 12 -> 7 -> 10


 I used recursive solution, but we can also use stack method where we can put the second half elements of list in stack
 and traverse the list from start with popping the elements from stack
 */
public class ModifyLinkedList {

    public static void main(String[] args) {
        Node last = new Node(10);
        Node last1 = new Node(7,last);
        Node last2 = new Node(12,last1);
        Node last3 = new Node(8,last2);
        Node last4 = new Node(9,last3);
        Node head = new Node(2,last4);
        ModifyLinkedList mll = new ModifyLinkedList();
        head = mll.modifyLinkedList(head);

        Node next = head;
        while(next!=null) {
            System.out.print(next.getData()+ "->");
            next = next.getNext();
        }
        System.out.print("null");


    }

    Node modifyLinkedList(Node head) {
        modifyLinkedListRecursively(head,head);
        return head;
    }

    Node modifyLinkedListRecursively(Node head,Node next) {

        if(next == null) {
            return head;
        }

        Node start = modifyLinkedListRecursively(head,next.getNext());

        if(start!=next && next.getNext()!=start) {
            start.setData(start.getData() - next.getData());
            return start.getNext();
        }

        return next;
    }


}

class Node {
    private int data;
    private Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
