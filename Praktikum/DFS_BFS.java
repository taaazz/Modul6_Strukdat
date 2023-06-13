package Praktikum;
import java.util.*;

class Graph {
    private int node;
    private LinkedList<Integer> adj[];
    private boolean visited[];
    private Queue<Integer> que;

    Graph(int v) {
        node = v;
        adj = new LinkedList[node];
        visited = new boolean[node];
        que = new LinkedList<Integer>();

        for (int i = 0; i < node; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void insertEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFS(n);
        }
    }

    void BFS(int n) {
        boolean nodes[] = new boolean[node];
        int a = 0;
        nodes[n] = true;
        que.add(n);
        while (!que.isEmpty()) {
            n = que.poll();
            System.out.print(n + " ");
            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i);
                if (!nodes[a]) {
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }
}

public class DFS_BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(12);

        graph.insertEdge(1, 2);
        graph.insertEdge(1, 4);
        graph.insertEdge(2, 5);
        graph.insertEdge(5, 3);
        graph.insertEdge(5, 9);
        graph.insertEdge(5, 7);
        graph.insertEdge(9, 8);
        graph.insertEdge(4, 6);
        graph.insertEdge(6, 7);
        graph.insertEdge(7, 11);
        graph.insertEdge(8, 11);
        graph.insertEdge(11, 10);

        System.out.println("Hasil DFS (mulai dari simpul 1):");
        graph.DFS(1);

        System.out.println("\n\nHasil BFS (mulai dari simpul 1):");
        graph.BFS(1);
    }
}
