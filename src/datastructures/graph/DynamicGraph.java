package src.datastructures.graph;

import java.util.*;

/**
 * Graph interface of the assignment
 * @author Aziz Can Akkaya
 *
 */
public interface DynamicGraph {
	/**
	 * Returns the adjacency matrix
	 * @return 2D adjacency matrix
	 */
	public double[][] exportMatrix();
	

	/**
	 * Adds an edge between two vertex
	 * @param VertexID1 source
	 * @param VertexID2 destination
	 * @param weight weight
	 */
	void addEdge(int VertexID1, int VertexID2, double weight);
}