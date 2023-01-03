/* Copyright (c) 2022. Do not use without permission. All Rights Reserved.
Simi Ojeyomi*/

package Graphs.ListGraph;

import java.util.ArrayList;
import java.util.List;

/*This class, ListGraph, is a class that implements the graph data structure
using only list. Implementing graphs this way is definitely not efficient, as
using maps are way more efficient. This is done to see how maintaining two
lists can work to create a graph data structure. An arrayList is chosen to
store the vertices. This is because arrayList uses indexing, and it would be
faster and more efficient when checking to see if a specific vertex exists in
the graph. Edges of a vertex are also stored in an arraylist. In order to be
able to easily access a specific vertex and its neighbors, arrayList seems
more efficient because it uses indexing. The index of every vertex in an
arraylist will be the same as the index of the arraylist that stores the
adjacent vertices of that specific vertex. In this class, break statements
are not used and the minimum return statements are used*/


public class ListGraph<T> {
    // arrayList to keep track of all vertices in the current graph object
    private ArrayList<T> vertices;
    /*keeps track of the neighbors of a specific vertex. This
    in turn stores all the edges that exist in the graph*/
    private List<ArrayList<T>> neighbors;

    /**Default Constructor
     * Vertices and Neighbors are initialized
     */
    public ListGraph(){
        vertices = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    /**This method adds a vertex to the current ListGraph Object.  If
     * dataForVertex already exist as a vertex in the graph, false
     * is returned without modifying anything. However, if it does not,
     * dataForVertex is created and true is returned.
     *
     * @param vertex (vertex to add to the graph)
     * @return true if vertex was successfully added
     *          false otherwise
     */
    public boolean addVertex(T vertex){
        boolean status = false;

        // checks to make sure vertex is a valid parameter
        if(vertex == null)
            throw new IllegalArgumentException("Vertex to add cannot be null");

        /* checks if the vertex exist in the graph first, before adding vertex
        * to the graph*/
        if(!vertices.contains(vertex)){
            // adds vertex to graph if it did not previously exist
            vertices.add(vertex);
            /* arrayList to store adjacent vertices is created and stored in
            neighbors. For the index of every vertex in vertices, the index is
            the same for the arrayList that stores the adjacent vertices of
            that vertex in neighbors*/
            neighbors.add(new ArrayList<>());
            status = true;
        }

        return status;
    }

<<<<<<< Updated upstream
=======

    /**This method removes the parameter,"vertex" from the current objList.
     * It does this by first removing any edges that the vertx might have,
     * both outgoing and incoming, before removing the vertex. It uses the
     * index to remove the vertex from the current ListGraph object
     *
     * @param vertex (vertex to delete from current list graph object)
     * @return true of vertex and all its edges were successfully removed
     *          false otherwise
     */
    @Override
    public boolean deleteVertex(T vertex) {
        boolean remove = false;
        int index;

        // check for valid parameters
        if(vertex == null)
            throw new IllegalArgumentException();

        // check if vertex exist in the current ListGRAPH Object
        if(findVertex(vertex)){
            // find the position at which vertex is stored in the graph
            index = vertices.indexOf(vertex);
            /* Using that index, we get the neighbors of the parameter, "vertex"
            i.e. other vertices that have an edge connected to  parameter,
            "vertex". These are the adjacent vertices i.e. vertices that have
             an incoming edge from the parameter, vertex*/
            ArrayList<T> vertxNeighbors = neighbors.get(index);
            // Remove vertxNeighbors from the current graph object
            neighbors.remove(vertxNeighbors);

            /*Iterate through all the arrayList in the graph to find any
            arrayList that might store an outgoing edge to parameter, "vertex*/
            for(ArrayList<T> allEdges: neighbors) {
                allEdges.remove(vertex);
            }

            // removing the vertex itself from the current ListGraph object
            remove = vertices.remove(vertex);
        }

        return remove;
    }

>>>>>>> Stashed changes
    /**This method counts the number of vertex in the graph and returns it.
     * It checks for the total number of vertices in the graph and returns it.
     *
     * @return number of vertices in teh current graph
     */
    public int getVertexCount(){
        return vertices.size();
    }

    /**This method returns true if vertex is found in the current graph
     * object. It checks if vertex is part of the current ListGraph object by
     * iterating through every vertice present in graph. If vertex is found,
     * true is returned. A loop could be used in this method to iterate
     * through  vertices, but the contains method of the object class is used
     * instead for proper efficiency.
     *
     * @param vertexToFind (vertex to search for)
     * @return true if parameter, vertex is in the current graph object
     *          false otherwise.
     */
<<<<<<< Updated upstream
    public boolean isVertex(T vertexToFind){
        boolean found ;
=======
    @Override
    public boolean findVertex(T vertexToFind){
        boolean found;
>>>>>>> Stashed changes

        /* this line evaluates the arraylist of vertices, by using the
         * contains method to check if vertexToFind is in the graph. If it
         * is, found is updated to true. if not, found is false*/
        found = vertices.contains(vertexToFind);

        return found;
    }

    /**This method creates an edge between the two vertices specified in
     * parameter. If the source vertex has an outgoing edge to the destVertex,
     * this makes it a directed graph. If the destVertex also has an outgoing
     * vertex to the same source vertex, this makes the current ListGraph
     * object an undirected graph. We create an edge by getting the index of
     * the source vertex. The same index is used to access the neighbor
     * collection. The destVertex is then added to the arrayList that stores
     * the sourceVertex neighbors
     *
     * @param sourceVertex
     * @param destVertex
     * @return
     */
    public boolean addEdge(T sourceVertex, T destVertex){
        boolean createEdge = false;
        int index;

        // check for valid parameters first
        if(sourceVertex == null || destVertex == null)
            throw new IllegalArgumentException("Invalid parameters.Edge " +
                    "cannot be created");

        /* we check if the vertices exist in the graph first. We cannot make
         an edge without vertices that do not exist. If the vertices exist,
         we create the edge. If they do not, we create the vertices first, then
         create the edge. We can do this by simply calling the addVertex
         method*/
       addVertex(sourceVertex);// returns true if it did not exist
       addVertex(destVertex);

<<<<<<< Updated upstream
       // now we can create an edge
//        index = vertices.g

        return createEdge;
    }
=======
        // checking to see if there was already an existing edge
        if(!srcVertxNeighbors.contains(destVertex)) {
            // add dest vertex to srcVertxNeighbors
            createEdge = srcVertxNeighbors.add(destVertex);// creating edge...
        }

        return createEdge;
    }

    /**This method removes an edge between the two vertices specified in
     * parameter. If the source vertex has an outgoing edge to the destVertex,
     * the edge is removed by getting the index of the source vertex. The
     * same index is used to access the neighbor arrayList.In that arrayList,
     * if an edge ever existed between srcVertx and destVertx, destVertx will
     * be present in the arrayList and we simply remove it.
     *
     * @param srcVertx (vertex from which edge starts from)
     * @param destVertx (vertex to which edge ends)
     * @return true if edge was removed successfully or false otherwise
     */
    public boolean removeEdge(T srcVertx, T destVertx){
        boolean removed = false;

        // checking for valid parameters
        if(srcVertx == null && destVertx == null)
            throw new IllegalArgumentException();

        else{

            // check to see if both vertices exist in the current graph object
            if(vertices.contains(srcVertx) && vertices.contains(destVertx)){
                // get the index of where it is stored
                int index = vertices.indexOf(srcVertx);
                // using the same index, remove any edge with destVertx
                ArrayList<T> srcVertxNeighbor = neighbors.get(index);
                removed = srcVertxNeighbor.remove(destVertx);
            }
        }

        return removed;
    }

    /**This method returns an object of a class that implements the java
     * collection interface, that contains all the vertices that have an
     * outgoing edge to the parameter, vertex. i.e. All vertices that
     * parameter, vertex has an incoming edge from. If there is no vertex,
     * dataForVertex, in current object graph, null is returned. If it is
     * present, but has no neighbors, an empty collection is simply returned
     *
     * @param vertex (vertex to find all its predecessors)
     * @return Collection of vertices that have an outgoing edge to vertex
     */
    public Collection<T> predecessors(T vertex){
        Collection<T> vertexIncomingEdge = null;

        // check for valid parameters
        if(vertex == null)
            throw new IllegalArgumentException();

        // check to see that vertex is a valid vertex in the list graph object
        if(findVertex(vertex)){
            vertexIncomingEdge = new ArrayList<>();

            // Iterate through every arrayList that stores edges in the graph
            for(ArrayList<T> storeEdges : neighbors){

                /*if an arrayList that contains the parameter vertex is
                found, that means the vertex of that arraylist is a
                predecessor*/
                if(storeEdges.contains(vertex)){
                    //get index of where it is stored
                    int index = neighbors.indexOf(storeEdges);
                    /* the vertex at that index is added as a predecessor of
                    the parameter, "vertex"*/
                    vertexIncomingEdge.add(vertices.get(index));
                }
            }
        }

        return vertexIncomingEdge;
    }

    @Override
    public String toString() {
        return "The vertices are: " + vertices + ", and the edges are"
                + neighbors;
    }

    /**This method clears the entire current list graph object. It does this
     * by clearing the arraylist that stores the vertices of the current list
     * graph object and at the same time clears the list, that stores the
     * edges in the current list graph object
     *
     */
    public void clear(){
        // clears all the data structure in the list graph class
        vertices.clear();
        neighbors.clear();
    }

    /**This method returns the number of edges that are present at any time
     * in the current ListGraph Object. This is done by simply iterating
     * through the list, "neighbors", which stores all the edges of every
     * single vertex present in the current ListGraph object and return the
     * sum of their size. If there is no edge present in the graph, then zero
     * is returned
     *
     * @return The number of edges present in the current ListGraph object
     */
    public int getEdgesCount(){
        int numEdges = 0;

        // Iterating through neighbors
        for(ArrayList<T> storeEdge: neighbors)
            numEdges += storeEdge.size();// sums up the size of every arrayList

        return numEdges;
    }
>>>>>>> Stashed changes
}
