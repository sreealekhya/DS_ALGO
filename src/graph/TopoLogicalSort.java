package graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering
 * of vertices such that for every directed edge uv, vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 For example, a topological sorting of the following graph is “5 4 2 3 1 0”.
 There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).
 */
public class TopoLogicalSort {

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopoLogicalSort topoLogicalSort = new TopoLogicalSort();
        topoLogicalSort.sort(graph);


    }

    void sort(Graph g) {
        Stack<Integer> stack = new Stack<>();

        int[] visited = new int[g.V];

        for(int i =0;i<g.V;i++){
            if(visited[i]==0)
                sortUtil(g,visited,stack,i);
        }


        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+ " ");
        }

    }

    void sortUtil(Graph g,int[] visited,Stack s , int i) {
        visited[i] =1;

        for(int j=0;j<g.adj[i].size();j++) {
            if(visited[g.adj[i].get(j)]==0)
                sortUtil(g,visited,s,g.adj[i].get(j));
        }

        s.push(i);
    }
}





class Graph {
    int V;
    LinkedList<Integer> adj[] ;


    Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<>();
        }

    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }


}


