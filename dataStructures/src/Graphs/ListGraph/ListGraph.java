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
    public boolean isVertex(T vertexToFind){
        boolean found ;

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

       // now we can create an edge
        index = vertices.g

        return createEdge;
    }
}
