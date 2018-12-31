package linkedlist;

/**
 * Given two numbers represented by two linked lists, write a function that returns sum list. The sum list is linked list representation of addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).

 Example

 Input:
 First List: 5->6->3  // represents number 563
 Second List: 8->4->2 //  represents number 842
 Output
 Resultant list: 1->4->0->5  // represents number 1405
 */
public class AddTwoLL {

    private static int carry = 0;

    public static void main(String[] args) {
        Node head1 = new Node(9,new Node(9,new Node(9)));

        Node head2 = new Node(5,new Node(8));

        int s1 = 0;
        Node n = head1;
        while (n!=null) {
            s1++;
            n = n.getNext();
        }

        int s2 =0;
        n = head2;
        while (n!=null) {
            s2++;
            n = n.getNext();
        }

        AddTwoLL addTwoLL = new AddTwoLL();
        Node head  = addTwoLL.add(head1,head2,s1,s2);

        n = head;

        while (n!=null) {
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
        System.out.println("null");

    }

    Node add(Node head1,Node head2,int s1,int s2){
        int k = s1-s2;
        Node res;
        if(k<0) {
            int k1 = -k;
            Node n = head2;
            while(k!=0) {
                n=n.getNext();
                k++;
            }
            res = addUtil(head1,n);

            res = addUtilLeft(head2,res,k1);


        }
        else {
            int k1 =k;
            Node n = head1;
            while(k!=0){
                n=n.getNext();
                k--;
            }

            res = addUtil(n,head2);
            res = addUtilLeft(head1,res,k1);
        }

        if(carry!=0)
            res = new Node(carry,res);


        return res;
    }

    Node addUtil(Node h1,Node h2){
        if(h1==null) return null;

        Node n = addUtil(h1.getNext(),h2.getNext());
        int curr = h1.getData()+h2.getData()+carry;

        int prev_int = curr%10;
        carry = curr/10;
        Node prev = new Node(prev_int);

        prev.setNext(n);

        return prev;
    }

    Node addUtilLeft(Node head,Node next,int k){
        if(k==0) return next;

        Node n = addUtilLeft(head.getNext(),next,k-1);

        int curr = head.getData()+carry;

        int prev_int = curr%10;
        carry = curr/10;
        Node prev = new Node(prev_int);

        prev.setNext(n);

        return prev;

    }
 }
