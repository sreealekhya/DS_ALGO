package linkedlist;

/**
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
 (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
 All linked lists are sorted. See the following example

 5 -> 10 -> 19 -> 28
 |    |     |     |
 V    V     V     V
 7    20    22    35
 |          |     |
 V          V     V
 8          50    40
 |                |
 V                V
 30               45
 Write a function flatten() to flatten the lists into a single linked list.
 The flattened linked list should also be sorted. For example, for the above input list,
 output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
 */
public class FlattenALinkedList {

    public static void main(String[] args) {

        LLWith2Pointer head = new LLWith2Pointer(5);
        head.down = new LLWith2Pointer(7);
        head.down.down = new LLWith2Pointer(8);
        head.down.down.down = new LLWith2Pointer(30);
        head.right =new LLWith2Pointer(10);
        head.right.down = new LLWith2Pointer(20);
        head.right.right = new LLWith2Pointer(19);

        FlattenALinkedList flattenALinkedList = new FlattenALinkedList();

        LLWith2Pointer res_head = flattenALinkedList.flatten(head);

        LLWith2Pointer n = res_head;

        while (n!=null) {
            System.out.print(n.data+"->");
            n = n.down;
        }
        System.out.println("null");
    }


    LLWith2Pointer flatten(LLWith2Pointer head) {
        if(head == null || head.right == null) {
            return head;
        }

        head.right = flatten(head.right);

        head = merge(head,head.right);

        return head;
    }


    LLWith2Pointer merge(LLWith2Pointer a, LLWith2Pointer b) {
        if(a==null) return b;

        if(b==null) return a;

        LLWith2Pointer res;

        if(a.data<b.data) {
            res = a;
            res.down = merge(a.down,b);
        }

        else{
            res=b;
            res.down = merge(a,b.down);
        }


        return res;
    }
}


class LLWith2Pointer{
    int data;
    LLWith2Pointer down,right;

    LLWith2Pointer(int data) {
        this.data = data;
    }
}
