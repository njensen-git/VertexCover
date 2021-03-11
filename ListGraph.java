import java.util.LinkedList;
import java.util.*;

public class ListGraph {
    int verts; // # of vertices on the graph
    LinkedList<Integer> adjacency[];// top level list of lists

    // Constructor
    ListGraph(int numverts) {
        verts = numverts;
        // intitialize list for holding the adj lists
        adjacency = new LinkedList[numverts];
        for (int i = 0; i < verts; i++) {
            // initialize empty adj list at each node
            adjacency[i] = new LinkedList();
        }
    }

    // add an edge from u -> v and v-> u (undirected graph)
    void addEdge(int u, int v) {
        adjacency[u].add(v);
        adjacency[v].add(u);
    }
}


