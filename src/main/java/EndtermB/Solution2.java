package EndtermB;

import java.util.*;

public class Solution2 {
    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using breadth first search.
     *
     * Returns 0 if the graph or vertex is null
     *
     * @param g
     *     The graph to count vertices in.
     * @param v
     *     The vertex to start counting at.
     * @return the number of vertices in the same connected component.
     */
    public static int countVertices(Graph g, Graph.Vertex v) {
        if (g == null || v == null) return 0;
        Set<Graph.Vertex> colored = new HashSet<>();
        Queue<Graph.Vertex> queue = new LinkedList<>();
        queue.add(v);
        colored.add(v);

        while (!queue.isEmpty()) {
            for (Graph.Vertex n : g.getNeighbours(queue.remove())) {
                if (!colored.contains(n)) {
                    colored.add(n);
                    queue.add(n);
                }
            }
        }

        return colored.size();
    }
}

/**
 * Library
 */
class Graph {
    static class Vertex {
        private int id;
        private Set<Vertex> neighbours;

        public Vertex(int id) {
            this.id = id;
            neighbours = new HashSet<>();
        }

        public void addNeighbour(Vertex v) {
            neighbours.add(v);
        }

        private Collection<Vertex> getNeighbours() {
            return new ArrayList<>(this.neighbours);
        }

        public int getId() {
            return this.id;
        }
    }

    Map<Integer, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((Vertex) v).getNeighbours());
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        v.addNeighbour(w);
        w.addNeighbour(v);
    }
}
