package Latihan;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int node;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;
    BFSTraversal(int v){
        node = v;
        adj = new LinkedList[node];
        for (int i=0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<Integer>();
    }

    void insertRdge(int v, int w){
        adj[v].add(w);
    }
    void BFS (int n){
        boolean nodes[] = new boolean[node];
        int a=0;
        nodes[n] = true;
        que.add(n);
        while (que.size() != 0){
            n =que.poll();
            System.out.println(n+ " ");
            for (int i=0; i < adj[n].size(); i++){
                a = adj[n].get(i);
                if (!nodes[a]){
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);
        graph.insertRdge(0,1);
        graph.insertRdge(0,3);
        graph.insertRdge(0,4);
        graph.insertRdge(5,4);
        graph.insertRdge(3,5);
        graph.insertRdge(1,2);
        graph.insertRdge(1,0);
        graph.insertRdge(2,1);
        graph.insertRdge(4,1);
        graph.insertRdge(3,1);
        graph.insertRdge(5,4);
        graph.insertRdge(5,3);
        System.out.println("Breadth First Traversal for the graph is : ");
        graph.BFS(0);
    }
}
