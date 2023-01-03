package Graphs;

import java.util.Collection;

abstract public class Graphs<V> {
    abstract public boolean addVertex(V vertex);
    abstract public boolean deleteVertex(V vertex);
    abstract public boolean findVertex(V vertex);
    abstract public Collection<V> verticesNeighbors(V vertex);
    abstract public int getVertexCount();
}
