/*
 * Copyright (c) 2022. Do not use without permission. All Rights Reserved. Simi Ojeyomi
 */

package Graphs.MapGraph;

/*This class MapDWGraph represents a *Weighted Directed graph. This graph is
 * implemented using two hashMaps. dwGraphVertex and dwGraphEdge.
 * dwGraphVertex is a hashMap that stores the vertices in the graph, and its
 * corresponding neighbors. The neighbors are stored in a list structure
 * so dwGraphVertex has vertex and list pairs in its hashMap. dwGraphEdge
 * is a hashMap that stores all the edges in the graph, and the weight or cost
 * associated with it. dwGraphEdge contains String and Integer pairs stored
 * in the map. The String stored represents a string representation of edges
 * that exist in the graph. The string representation is in the form of
 * concatenation of the word, "edge", the source vertex of the edge, and the
 * destination vertex. Concatenating all three of this cases it to become
 * a string, and this is stored. The corresponding weight of each edge is also
 * stored in dwGraphEdge*/

import java.util.LinkedList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapGraph<V extends Comparable<V>> {
    /*dwGraphVertex stores all the vertices in the graph and its neighbors*/
    private Map<V, List<V>> dwGraphVertex;

    /*dwGraphEdge stores all the edges that exist in the graph and the
     * eight associated with each graph*/
    private Map<String, Integer> dwGraphEdge;

    /**Default Constructor that initializes dwGraphVertex and dwGraphEdge.
     * The structure to be used for the project is hashMap so dwGraphVertex
     * will be initialized to a hashMap and dwGraphEdge will also have a
     * hashMap structure
     */
    public MapGraph() {
        dwGraphVertex = new HashMap<>();// initialized to a hashMap
        dwGraphEdge = new HashMap<>();
    }

    /**This method adds a new vertex, "dataForVertex" to its current graph
     * object. If dataForVertex already exist as a vertex in the graph, false
     * is returned without changing anything. However, if it does not,
     * dataForVertex is created and true is returned.
     *
     * @param dataForVertex (vertex to create)
     * @return True if dataForVertex was not a key in the map (It then creates
     *         dataForVertex). Returns false if dataForVertex was already a key
     *         in the map(dataForVertex is not created)
     */

    public boolean makeVertex(V dataForVertex) {
        boolean vertexStatus = false;

        // checks for valid parameters
        if (dataForVertex == null)
            throw new IllegalArgumentException("Null value detected");

        // checks if the vertex is currently in the graph
        if (!findVertex(dataForVertex))
        {
            /* vertex is only added if the vertex did not previously exist in
             * the map, "dwGraphVertex"*/
            dwGraphVertex.put(dataForVertex, new LinkedList<>());
            vertexStatus = true;
        }

        return vertexStatus;
    }

    /**This method returns true if current object graph contains dataForVertex,
     * as a vertex in the graph. It returns false otherwise. This method
     * iterates through every vertex in the current object graph and checks
     * if dataForVertex is one of them
     *
     * @param dataForVertex (vertex to check if present in current object graph)
     * @return true if dataForVertex is found, or false otherwise
     */
    public boolean findVertex(V dataForVertex) {
        // checking for valid parameters
        if (dataForVertex == null)
            throw new IllegalArgumentException("Null value detected");

        // using the containsKey method to check whether that vertex
        // exists in dwGraphVertex
        return dwGraphVertex.containsKey(dataForVertex);
    }

    /**This method returns all the vertices in the current object graph in form
     * of a collection. The method returns an object of a class that implements
     * the collection interface, which contains all the vertices in the
     * current object graph. If the current object graph has no vertices, then
     * an empty collection is simply returned. There is no specific ordering
     * as to how vertices are positioned in this collection
     *
     * @return Collection of all vertices in current graph object
     */
    public Collection<V> getAllVertices() {
		/* vertexCollection represents collection to be returned. A linkedList
		object is returned*/

        // iterating through all vertices in current graph

        // Adding all the keys in the current map to vertexCollection
        // adds vertices to collection

        return new LinkedList<>(dwGraphVertex.keySet());
    }

    /**This method adds a new (directed) edge to its current object graph, that
     * goes from sourceVertex to destVertex, and this edge should have a
     * weight,"weight". This method returns false and is modified if weight is
     * negative, since edges cannot have a negative weight. If an edge already
     * exist between sourceVertex and destVertex, the weight is simply
     * changed, since multiple edges cannot exist, between 2 specific
     * vertices in a graph. if either sourceVertex or destVertex does not
     * exist in the graph, the vertices must be created first before an
     * edge is created between them.
     *
     * @param sourceVertex (Source vertex of edge to create)
     * @param destVertex (destination vertex of edge to create)
     * @param weight (weight associated with edge created)
     * @return True if edge was successfully created or false otherwise
     */
    public boolean makeEdge(V sourceVertex, V destVertex, int weight) {
        boolean status = false;

        // check for valid parameters to prevent null values
        if (sourceVertex == null || destVertex == null)
            throw new IllegalArgumentException();

        // checks to make sure the weight is not negative and therefore,
        // invalid
        if (weight >= 0) {
            /* we call createVertex on source and destination vertex to make sure
             * that they exist in the current graph object. Creating an edge
             * without vertices does not make sense since an edge connects two
             * vertices*/
            makeVertex(sourceVertex);// creates sourceVertex if it did not
            // previously exist
            makeVertex(destVertex);// if destVertex exists, nothing is done

            /*string representation of where the edge starts and end from will
             * only be created if both vertices exist */
            String edgeToCreate = "edge" + sourceVertex + destVertex;

            /* we get the value of the sourceVertex from the graph, i.e. the
             * LinkedList that belongs to the sourceVertex*/
            List<V> sourceVertexValue = dwGraphVertex.get(sourceVertex);

            /* adding destVertex to LinkedList of sourceVertex to create an
             * edge or a connection between source and destination vertex. We check
             * to see if an edge already exist between both source and destination
             * vertex. if not, we create an edge*/
            if(!sourceVertexValue.contains(destVertex))
                sourceVertexValue.add(destVertex);// destVertex becomes a
            // neighbor

            /* puts the string representation of vertices as the key, and the
             * corresponding weight of the edge becomes the value. Since
             * we are using put() of the Map class, if edgeToCreate already
             * exist, the weight is just simply changed
             * to the parameter, weight*/
            dwGraphEdge.put(edgeToCreate, weight);

            status = true;
        }

        return status;
    }

    /**This method returns the weight of the edge that exist between
     * sourceVertex and destVertex. If there is no edge between them, or
     * if sourceVertex or destVertex does not exist in the current object
     * graph, then -1 is simply returned
     *
     * @param sourceVertex (Source vertex of where edge starts)
     * @param destVertex (destination Vertex or neighbor of source vertex)
     * @return weight of edge or -1
     */
    public int edgeWeight(V sourceVertex, V destVertex) {
        int weight = -1;

        // check for valid parameters
        if (sourceVertex == null || destVertex == null)
            throw new IllegalArgumentException();

        // check to see if source and dest vertex actually exist in the graph
        if (findVertex(sourceVertex) && findVertex(destVertex))
        {
            // string representation of how edges are stored in graph
            String vertName = "edge" + sourceVertex + destVertex;

            // iterating through every edge present in the graph

            for (String s : dwGraphEdge.keySet()) {
                if (vertName.equals(s))// if the edge is found
                    /*We get the edgeCost of the edge that exist between
                     * source and destination vertex*/
                    if (dwGraphEdge.get(vertName) != null)// check if edge exist
                        weight = dwGraphEdge.get(vertName);
            }
        }

        return weight;
    }

    /**This method removes the edge going from sourceVertex to destVertex.
     * If sourceVertex or destVertex do not exist in the graph or if there
     * is no edge between them, false is simply returned without modifying
     * the current object graph, otherwise the edge is removed and true is
     * returned
     *
     * @param sourceVertex (source vertex from which edge starts)
     * @param destVertex (destination vertex from which edge ends)
     * @return true or false
     */
    public boolean removeEdge(V sourceVertex, V destVertex) {
        boolean status = false;

        // check for valid parameters
        if (sourceVertex == null || destVertex == null)
            throw new IllegalArgumentException();

        // string representation of how edges are stored in the graph
        String edgeToRemove = "edge" + sourceVertex + destVertex;

        // check to see source and dest vertex exist
        if(findVertex(sourceVertex) && findVertex(destVertex))
        {
            // we check if the edgeToRemove actually exist in the graph.
            // if it does, this means there is an edge between them
            if (dwGraphEdge.containsKey(edgeToRemove)) {
                /*we get the value of the sourceVertex from the graph, i.e. the
                 * LinkedList that belongs to the sourceVertex*/
                List<V> sourceVertexValue = dwGraphVertex.get(sourceVertex);
                /*
                 * removing destVertex from LinkedList of sourceVertex to
                 * break the connection between source and destination vertex.
                 */
                sourceVertexValue.remove(destVertex);

                // removing edgeToRemove from where edges of graphs are stored
                dwGraphEdge.remove(edgeToRemove);

                status = true;
            }
        }
        return status;
    }

    /**This method removes the vertex, dataForVertex from the current graph
     * object, and all its associated edges. if dataForVertex is not in the
     * current graph object, false is returned without changing anything.
     * However, if it does, all its associated edges, both incoming and
     * outgoing are removed first. Then the vertex itself, dataForVertex is
     * removed and true is returned
     *
     * @param dataForVertex (vertex to remove)
     * @return false if dataForVertex does not exist, true otherwise
     */
    public boolean removeVertex(V dataForVertex) {
        boolean vertexStatus = false;

        /*String representation of how dataForVertex is stored in the graph if
         *it has an edge*/
        String strngDataForVertex = "edge" + dataForVertex;

        // check for valid parameters
        if (dataForVertex == null)
            throw new IllegalArgumentException("Null value detected");


        // We check to see if dataForVertex is actually a vertex in the graph
        if (findVertex(dataForVertex))
        {
            /* if it is found, before removing dataForVertex, we remove every
             * edge associated with it first. This is by finding every
             * vertex that has an outgoing edge to dataForVertex*/

            // -----REMOVING ANY EDGE ASSOCIATED WITH DATAFORVERTEX-----

            // Iterate through all the vertices that have an incoming edge
            for (List<V> neighbor : dwGraphVertex.values()) {
				/* stores the LinkedList that contains the neighbors of any
				 vertex at any point in time*/
                /* checks if dataForVertex is found in that LinkedList. i.e. if
                 * dataForVertex is a neighbor of any vertex in the graph*/
                neighbor.remove(dataForVertex);// removes dataForVertex
            }

            // -----CHECK WHERE ALL EDGES THAT EXIST IN THE GRAPH, ARE STORED
            // -----AND REMOVING DATAFORVERTEX FROM IT

            // Iterating through every stored edge in the graph
            for (String existingEdge : dwGraphEdge.keySet()) {
                /* stores the string representation of whether an edge exist or
                 * not */
                /* Since the string representation of every edge that exist in
                 * the graph is a concatenation of "edge" and the sourceVector
                 * and the destVector, we simply check if any of the string
                 * representation contains the string "edge" and dataForVertex.
                 * This means that dataForVertex could have been source or
                 * dest vertex, but as long as it is found, we remove it */
                if (existingEdge.contains(strngDataForVertex))
                    strngDataForVertex = existingEdge;
            }

            // removing any edge associated with dataForVertex from where
            // all edges in the graph are stored
            dwGraphEdge.remove(strngDataForVertex);

            // ---NOW, REMOVING DATAFORVERTEX ITSELF FROM THE GRAPH
            dwGraphVertex.remove(dataForVertex);// removes dataForVertex
            vertexStatus = true;
        }

        return vertexStatus;
    }

    /**This method returns an object of a class that implements the java
     * collection interface, that contains all the neighbors that the vertex,
     * "dataForVertex" has in the current object graph. If there is no vertex,
     * dataForVertex, in current object graph, null is returned. If it is
     * present, but has no neighbors, an empty collection is simply returned
     *
     * @param dataForVertex (vertex to find its neighbors)
     * @return Collection of all neighbors of dataForVertex
     */
    public Collection<V> verticesNeighbors(V dataForVertex) {
        // check for valid parameters
        if (dataForVertex == null)
            throw new IllegalArgumentException("Null value detected");

        // collection to store neighbors/outgoing vertices from dataForVertex
        Collection<V> adjVertCollection = new LinkedList<>();

        // we check if dataForVertex is actually a vertex in the graph
        if (!findVertex(dataForVertex))
            adjVertCollection = null;// null is returned

        else {
			/*we find the value of dataForVertex(i.e. a linkedList that
			stores all its neighbors) and add it to adjVertCollection*/
            List<V> neighbors = dwGraphVertex.get(dataForVertex);
            adjVertCollection.addAll(neighbors);// adds to the collection
        }

        return adjVertCollection;
    }

    /**This method returns an object of a class that implements the java
     * collection interface, that contains all the vertices that have an
     * outgoing edge to the vertex, "destVertex" in the current object graph.
     * If there is no vertex,dataForVertex, in current object graph, null is
     * returned. If it is present, but has no incoming edge from other
     * vertices, an empty collection is simply returned.
     *
     * @param destVertex (vertex to find its predecessor)
     * @return Collection of all vertices that have an outgoing edge to
     * 			destVertex
     */
    public Collection<V> verticesPredecessors(V destVertex) {
        // checking if parameter is valid
        if (destVertex == null)
            throw new IllegalArgumentException("Null value detected");

        // collection to store predecessors of the vertex
        Collection<V> directedEdge = new LinkedList<>();

        // we check if destVertex is actually a vertex in the graph
        if (!findVertex(destVertex))
            directedEdge = null;// null is returned
        else {
            /* Iterate through all the keys to find keys that might have an
             * incoming edge to destVertex*/

            // stores each key while iterating
            for (V key : dwGraphVertex.keySet()) {
                /* Check the value (i.e. The linkedList that stores every
                 * vertex that has an edge with the key) of key.
                 * Check the linkedList to see if destVertex is in that
                 * linkedList. This would mean that destVertex is a
                 * neighbor of the current key and has an
                 * incoming vertex from current key */
                if (dwGraphVertex.get(key).contains(destVertex))
                    /*we add that key to the collection of keys that have an
                     * incoming edge to destVertex*/
                    directedEdge.add(key);
            }
        }

        return directedEdge;
    }

    /**This method splits the current graph into two. It returns a new graph,
     * which is a subgraph of the current graph. It creates a new graph,
     * consisting of vertices which are present in the parameter collection,
     * "verticesForNewGraph", and at the same time, present in the current
     * object graph. Whenever these vertices are added to the new graph, they
     * must also be removed from current object graph. The same applies to
     * the edges too. If the vertices added to new graph have edges, they
     * must also be added to the new graph, and corresponding edges in current
     * object graph should also be removed
     *
     * @param verticesForNewGraph (Parameter to get vertices from)
     * @return new graph consisting of some, none or all vertices from old
     * 			graph
     */
    public MapGraph<V> spiltGraph(Collection<V> verticesForNewGraph) {
        // checking to make sure we have valid parameters
        if (verticesForNewGraph == null)
            throw new IllegalArgumentException();

        MapGraph<V> newGraph = new MapGraph<>();// new graph to be returned

        // This collection stores vertices to be removed from current graph
        Collection<V> verticesToRemove = new LinkedList<>();

        /*
         * We iterate through all the vertices in the parameter collection to
         * determine which one to add or not to add to the new graph, and which
         * one to remove or not remove from old graph
         */
        // store each vertex at every iteration
        for (V vertex : verticesForNewGraph) {
            /*
             * first, we check if vertex is in the current graph. This is
             * necessary because we cannot add a vertex that does not exist to
             * the new graph, and we cannot remove a vertex that does not exist
             * from old graph
             */
            if (findVertex(vertex)) {
                newGraph.makeVertex(vertex);// adds vertex to new graph

                // NOW, ADD ALL EDGES ASSOCIATED WITH VERTEX TO THE NEW GRAPH
                /*
                 * We can achieve this in two-steps. First, we add all the
                 * vertex's neighbors, and then we add the associated cost of the
                 * edge
                 */

                // STEP 1 - Adding all neighbors of vertex
                // store each vertex at
                for (V vertexNeighb : verticesNeighbors(vertex)) {
                    // every iteration

                    /*
                     * all neighbors of the vertex must be added to new graph
                     * before we can create an edge. But we must check if that
                     * neighbor is part of the collection from which we can add
                     * vertex to the new graph (verticesForNewGraph)
                     */
                    if (verticesForNewGraph.contains(vertexNeighb)) {
                        newGraph.makeVertex(vertexNeighb);// adds vertex
                        // to new graph

                        // STEP 2 - SINCE KNOW THERE IS AN EDGE, THERE MUST
                        // BE A COST.NOW, FIND THE COST
                        String edge = "edge" + vertex + vertexNeighb;

                        /* store the cost, so we can add to new graph.
                         * This would never be null because vertex and
                         * vertexNeighb have an edge between them. So this
                         * means a string representation of this concept must
                         * exist too*/
                        int weight = dwGraphEdge.get(edge);

                        /* creates an edge in the new graph using current
                         * vertex, its neighbors and given cost*/
                        newGraph.makeEdge(vertex, vertexNeighb, weight);

                    }
                }
            }

            // After using vertex, add to the collection of vertices to be
            // removed from current graph
            verticesToRemove.add(vertex);
        }

        // ----REMOVES THE VERTEX AND EVERY EDGE ASSOCIATED WITH IT FROM
        //-----CURRENT GRAPH-------------------------------------------

        for (V v : verticesToRemove)
            removeVertex(v);// remove every vertex in
        // this collection from current
        // graph

        return newGraph;
    }
}
