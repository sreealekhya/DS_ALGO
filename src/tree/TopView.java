package tree;

import java.util.*;

public class TopView {

    public static void main(String args[]) {
        NodeWithHD root =  new NodeWithHD(1,0);
        root.n.left = new Node(2);
        //root.n.right = new Node(3);

        root.n.left.right = new Node(4);
        root.n.left.right.right = new Node(5);
        root.n.left.left = new Node(6);
        root.n.left.left.left = new Node(7);

        Queue<NodeWithHD> linkedList = new LinkedList<>();
        TreeMap<Integer, NodeWithHD> mapWithHd = new TreeMap<>();

        linkedList.add(root);
        //mapWithHd.put(0,root);

        while(!linkedList.isEmpty()) {
            NodeWithHD nodeWithHD = linkedList.poll();

            if(!mapWithHd.containsKey(nodeWithHD.hd)){
                mapWithHd.put(nodeWithHD.hd,nodeWithHD);
            }

            if(nodeWithHD.n.left!=null)
                linkedList.add(new NodeWithHD(nodeWithHD.n.left,nodeWithHD.hd-1));
            if(nodeWithHD.n.right!=null) {
                linkedList.add(new NodeWithHD(nodeWithHD.n.right,nodeWithHD.hd+1));
            }


        }

        Set<Map.Entry<Integer, NodeWithHD>> entries = mapWithHd.entrySet();
        for(Map.Entry<Integer, NodeWithHD> entry: entries) {
            System.out.print(entry.getValue().n.data + " ");
        }
        System.out.println();



    }
}

class NodeWithHD {
    Node n;
    int hd;

    NodeWithHD(int d) {
        n = new Node(d);
    }

    NodeWithHD(int d, int hd) {
        n = new Node(d);
        this.hd = hd;
    }

    NodeWithHD(Node n, int hd){
        this.n = n;
        this.hd = hd;
    }

}
