package Week8;

import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {
    private Graph g;
    private Vertex v;
    private Stack<Vertex> stack;
    private Set<Vertex> colored;
    private int graphSize;

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        this.stack = new Stack<>();
        this.colored = new TreeSet<>();
        this.graphSize = g.getAllVertices().size();
    }

    @Override
    public boolean hasNext() {
        return v != null && colored.size() != graphSize;
    }

    @Override
    public Vertex next() {
        if (!hasNext()) return null;

        Vertex next = v;
        colored.add(v);

        List<Vertex> neighbours = g.getNeighbours(next);
        neighbours.sort(Collections.reverseOrder());

        for (Vertex v : neighbours) {
            if (!colored.contains(v)) {
                stack.push(v);
            }
        }

        this.v = stack.empty() ? null : stack.pop();
        return next;
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
        return this.vertices.values();
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
