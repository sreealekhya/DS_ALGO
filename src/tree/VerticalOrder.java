package tree;

import java.util.*;

/**
 *
 */
public class VerticalOrder {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        VerticalOrder verticalOrder = new VerticalOrder();
        verticalOrder.printVO(root);
    }

    void printVO(Node root) {
        Queue<NodeWithHD> nodes = new LinkedList<>();
        TreeMap<Integer, List<Node>> integerListTreeMap = new TreeMap<>();

        nodes.add(new NodeWithHD(root,0));

        while(!nodes.isEmpty()) {
            NodeWithHD poll = nodes.poll();
            if(integerListTreeMap.containsKey(poll.hd)) {
                List<Node> nodes1 = integerListTreeMap.get(poll.hd);
                nodes1.add(poll.n);
            }
            else{
                ArrayList<Node> nodes1 = new ArrayList<>();
                nodes1.add(poll.n);
                integerListTreeMap.put(poll.hd,nodes1);
            }

            if(poll.n.left!=null)
                nodes.add(new NodeWithHD(poll.n.left,poll.hd-1));
            if(poll.n.right!=null)
                nodes.add(new NodeWithHD(poll.n.right,poll.hd+1));
        }


        //Set<Map.Entry<Integer, List<Node>>> entries = integerListTreeMap.entrySet();
        for(Map.Entry<Integer, List<Node>> entry : integerListTreeMap.entrySet()){
            for(Node node:entry.getValue()) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }


    }
}
