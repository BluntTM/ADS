package Week8;

import java.util.*;

public class Solution3 {
    /**
     * Find the shortest path between v and u in the graph g.
     *
     * @param g
     *     graph to search in.
     * @param v
     *     node to start from.
     * @param u
     *     node to reach.
     * @return the nodes you that form the shortest path, including v and u. An
     * empty list iff there is no path between v and u.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        Map<Vertex, Vertex> predecessors = new TreeMap<>();
        new GraphIterator(g, v).forEachRemaining(w -> {
            for (Vertex v1 : g.getNeighbours(w)) {
                if (!predecessors.containsKey(v1)) {
                    predecessors.put(v1, w);
                }
            }
        });

        LinkedList<Vertex> list = new LinkedList<>();
        while (u != v) {
            if (!predecessors.containsKey(u)) return new ArrayList<>();
            list.addFirst(u);
            u = predecessors.get(u);
        }
        list.addFirst(v);
        return list;
    }
}
