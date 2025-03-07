//Bellman Ford Algorithm   TC: 0(V*E)

import java.util.*;

public class fourteen {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
        
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dis[] = new int[graph.length];
        for(int i=0; i<dis.length; i++) {
            if(i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        //algo
        for(int i=0; i<V-1; i++) {
            //edges - 0(E)
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    //u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //relaxation
                    if(dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                        dis[v] = dis[u] + wt;
                    }
                }
            }
        }

        //print
        for(int i=0; i<dis.length; i++) {
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V]; 
        createGraph(graph); 
        
        int src = 0;
        bellmanFord(graph, src);
        
    }
}

//OUTPUT : 0 2 -2 0 4 





//-------------------------------------Simpler Way------------------------------------------
//Bellman Ford Algorithm   TC: 0(V*E)
/* 
import java.util.*;

public class fourteen {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dis[] = new int[V];
        for(int i=0; i<dis.length; i++) {
            if(i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0; i<V-1; i++) {
            //edges - 0(E)
            for(int j=0; j<graph.size(); j++) {
                Edge e = graph.get(j);
                //u, v, wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                //relaxation
                if(dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                }
            }
        }

        //print
        for(int i=0; i<dis.length; i++) {
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>(); 
        createGraph(graph); 
        
        int src = 0;
        bellmanFord(graph, src, V);
        
    }
}

//OUTPUT: 0 2 -2 0 4 
*/





//--------------------------------------------GFG------------------------------------------
/* 
class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int INF = 100000000; // 10^8
        int[] dis = new int[V];
        
        // Initialize distances
        for (int i = 0; i < V; i++) {
            dis[i] = (i == src) ? 0 : INF;
        }
        
        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if (dis[u] != INF && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                }
            }
        }
        
        // Nth relaxation to check Negative Cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if (dis[u] != INF && dis[u] + wt < dis[v]) {
                return new int[]{-1}; // Negative cycle detected so return -1
                //(or)
                // int temp[] = new int[1];
                // temp[0] = -1;
                // return temp;
            }
        }
        
        return dis;
    }
}
*/