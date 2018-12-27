package linkedlist;

/**
 * Given a singly linked list, swap kth node from beginning with kth node from end.
 * Swapping of data is not allowed, only pointers should be changed.
 * This requirement may be logical in many situations where the linked list data part is huge
 * (For example student details line Name, RollNo, Address, ..etc).
 * The pointers are always fixed (4 bytes for most of the compilers).
 */
public class SwapKthNodeFromStartEnd {

    public static void main(String[] args) {

        Node last  = new Node(3);
        Node secLast = new Node(2,last);
        Node head = new Node(1,secLast);

        //Node head = new Node(1);
        Node n = head;
        while (n!=null) {
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
        System.out.println("null");

        SwapKthNodeFromStartEnd swapKthNodeFromStartEnd = new SwapKthNodeFromStartEnd();
        head = swapKthNodeFromStartEnd.swapIt(head,1);
        n = head;
        while (n!=null) {
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
        System.out.println("null");
    }

    private Node swapIt(Node head, int k) {
        if(k<=0) return head;
        int i = 1;
        Node startK = head;
        Node startKPrev = null;

        while(i<k && startK.getNext()!=null) {
            startKPrev = startK;
            startK = startK.getNext();
            i++;
        }

        if(i!=k) return head;

        Node endK = head;
        Node endKPrev = null;
        Node end = startK;


        while(end.getNext()!=null) {
            end = end.getNext();
            endKPrev = endK;
            endK = endK.getNext();
        }


        if(startK == endK || startK.getNext() == endK) return head;

        Node endNext = endK.getNext();
        if(startKPrev!=null)
            startKPrev.setNext( endK);


        Node startNext = startK.getNext();

        endK.setNext(startNext);

        if(endKPrev!=null)
            endKPrev.setNext(startK);
        startK.setNext(endNext);


        if(startK == head) {
            head = endK;
        }
        if(startK == end){
            head = startK;
        }

        return head;

    }
}
