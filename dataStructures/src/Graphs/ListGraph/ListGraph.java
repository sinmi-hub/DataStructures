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
adjacent vertices of that specific vertex*/


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

    /**This method adds a vertex to the current ListGraph Object
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

    /**This method counts the number of vertex in the graph and returns it
     *
     * @return number of vertices in teh current graph
     */
    public int getVertexCount(){
        return vertices.size();
    }

    /**This method returns true if vertex is found in the current graph object
     *
     * @param vertex (vertex to search for)
     * @return true if parameter, vertex is in the current graph object
     *          false otherwise.
     */
    public boolean isVertex(T vertex){
        boolean found = false;

        return found;
    }
}
