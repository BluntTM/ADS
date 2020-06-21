package Resit;

import java.util.*;

public class Solution2 {
    /**
     * @param g
     *     The graph to search in.
     * @param v
     *     The vertex to start searching from.
     * @param n
     *     The number of edges n that can be traversed from v.
     * @return The number of vertices that are reachable from v (including v), using at most n edges.
     */
    static int countVertices(Graph g, Vertex v, int n) {
        Set<Vertex> colored = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        colored.add(v);

        int count = 1;
        int loopCount = 0;
        while (loopCount++ < n) {
            Queue<Vertex> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                for (Vertex w : g.getNeighbours(queue.remove())) {
                    if (!colored.contains(w)) {
                        temp.add(w);
                        colored.add(w);
                        count++;
                    }
                }
            }
            queue = temp;
        }

        return count;
    }
}

/**
 * Library
 */
interface Vertex extends Comparable<Vertex> {
    int getId();
}

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface Graph {
    /**
     * Returns the neighbours in a sorted collection by id
     *
     * @param v
     *     node to get the neighbours of.
     * @return sorted collection of neighbours.
     */
    List<Vertex> getNeighbours(Vertex v);

    /**
     * @return an unsorted collection of all vertices in the graph.
     */
    Collection<Vertex> getAllVertices();
}

class VertexImpl implements Vertex {
    private int id;
    private Set<Vertex> neighbours;

    public VertexImpl(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Vertex: " + getId() + ">";
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Vertex) && (((Vertex) o).getId() == this.getId());
    }
}

class GraphImpl implements Graph {
    private Map<Integer, Vertex> vertices;

    public GraphImpl() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    @Override
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
        Collections.sort(neigh);
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        VertexImpl realV = (VertexImpl) v;
        VertexImpl realW = (VertexImpl) w;
        realV.addNeighbour(w);
        realW.addNeighbour(v);
    }
}