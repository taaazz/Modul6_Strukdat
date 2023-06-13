package trial1;

import java.util.*;

// Representasi graf menggunakan adjacency list
class Graph {
    private int V; // Jumlah simpul (vertices)
    private LinkedList<Integer>[] adjacencyList; // Array dari linked list

    Graph(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList();
        }
    }

    // Menambahkan edge pada graf
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Depth First Search (DFS)
    void DFS(int v) {
        boolean[] visited = new boolean[V]; // Array untuk melacak simpul yang dikunjungi

        // Panggil fungsi rekursif untuk DFS
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true; // Tandai simpul saat ini sebagai sudah dikunjungi
        System.out.print(v + " ");

        Iterator<Integer> iterator = adjacencyList[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                DFSUtil(n, visited); // Panggil rekursif untuk simpul yang belum dikunjungi
            }
        }
    }

    // Breadth First Search (BFS)
    void BFS(int v) {
        boolean[] visited = new boolean[V]; // Array untuk melacak simpul yang dikunjungi

        LinkedList<Integer> queue = new LinkedList<>(); // Antrian untuk BFS
        visited[v] = true;
        queue.add(v);

        while (queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> iterator = adjacencyList[v].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

// Kelas utama
public class DFSandBFS {
    public static void main(String args[]) {
        Graph graph = new Graph(7); // Buat objek graf dengan 7 simpul

        // Tambahkan edge pada graf
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Hasil DFS (mulai dari simpul 0):");
        graph.DFS(0);

        System.out.println("\n\nHasil BFS (mulai dari simpul 0):");
        graph.BFS(0);
    }
}
