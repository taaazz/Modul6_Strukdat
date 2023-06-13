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

    /**
     *  fungsi DFS akan mengunjungi semua simpul yang terhubung dengan simpul awal secara rekursif,
     *  dengan cara melanjutkan ke simpul-simpul yang belum dikunjungi secara berurutan.
     *  Hasilnya adalah pencetakan urutan traversal DFS dari simpul awal.
     * @param vertex
     */
    void DFS(int vertex) {
        visited[vertex] = true; //Menandai simpul vertex telah dikunjungi
        System.out.print(vertex + " ");

        Iterator<Integer> it = adj[vertex].listIterator(); //mengiterasi melalui daftar (adjacency list) simpul-simpul terhubung dengan simpul vertex.
        while (it.hasNext()) {
            int n = it.next(); //Mengambil simpul berikutnya dari iterator.
            if (!visited[n])
                DFS(n);
        }
    }

    /**
     * fungsi BFS akan melakukan traversal BFS pada graph,
     * yaitu mengunjungi semua simpul yang terhubung dengan simpul awal secara berurutan mulai dari simpul terdekat hingga simpul terjauh.
     * Hasilnya adalah pencetakan urutan traversal BFS dari simpul awal.
     * @param n
     */
    void BFS(int n) {
        boolean nodes[] = new boolean[node]; // digunakan untuk melacak simpul mana yang sudah dikunjungi selama traversal BFS
        int a = 0;
        nodes[n] = true;
        que.add(n);
        while (!que.isEmpty()) {
            n = que.poll(); //mengambil simpul pertama dari queue dan menghapus antrian
            System.out.print(n + " ");
            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i); // mengambil simpul terhubung dengan simpul n di adjacency list
                if (!nodes[a]) { // Memeriksa apakah simpul a belum dikunjungi.
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
