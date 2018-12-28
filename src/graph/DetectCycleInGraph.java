package graph;

/**
 * Given a directed graph, check whether the graph contains a cycle or not.
 * Your function should return true if the given graph contains at least one cycle, else return false.
 *
 *
 * Solution: Below is DFS approach with
 * TC: O(E+V)
 * SC: O(2V) => O(V)
 */
public class DetectCycleInGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);


        Graph graph1 = new Graph(3);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 1);

        DetectCycleInGraph detectCycleInGraph = new DetectCycleInGraph();

        boolean isCyclic = detectCycleInGraph.detect(graph1);

        System.out.println(isCyclic);

    }

    boolean detect(Graph g) {
        int[] visited = new int[g.V];
        int[] recStack = new int[g.V];

        for(int i=0;i<g.V;i++) {
            if(visited[i]==0) {
                //boolean isCyclic  = detectUtil(g,visited,recStack,i);
                if(detectUtil(g,visited,recStack,i))
                    return true;
            }
        }

        return false;


    }

    boolean detectUtil(Graph g,int[] visited,int[] recStack , int v) {
        if(recStack[v] ==1 ) return true;

        if(visited[v] ==1) return false;

        visited[v] =1;
        recStack[v]=1;

        for(int i=0;i<g.adj[v].size();i++) {
            //boolean isCyclic = detectUtil(g,visited,recStack,g.adj[v].get(i));
            if(detectUtil(g,visited,recStack,g.adj[v].get(i))) return true;
        }

        recStack[v] = 0;

        return false;

    }
}
