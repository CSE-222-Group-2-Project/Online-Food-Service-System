package src.datastructures.graph;

import java.util.*;

/**
 * MyGraph implementation of the assignment
 * @author Aziz Can Akkaya
 *
 */
public abstract class MyGraph implements DynamicGraph {
	
	/**
	 * Presentation of all the edges
	 */
	private ArrayList<Edge> edges;
	
	/**
	 * Number of verties on the graph
	 */
	private int size;
	
	/**
	 * Constructor
	 * @param size of the vertices
	 */
	public MyGraph(int size) {
		
		this.size = size;
		
		edges = new ArrayList<Edge>();
	}
	
	/**
	 * Override of the interface functions
	 */
	@Override
	public void addEdge(int VertexID1, int VertexID2, double weight) {
		if( VertexID1 >= 0 && VertexID1 < size && VertexID2 >= 0 && VertexID2 < size && !(searchEdge(VertexID1,VertexID2)) ) {
			edges.add(new Edge(VertexID1,VertexID2,weight));
			return;
		}
		
		
	}
	
	/**
	 * Searches for an edge with the given source and destination
	 * @param vertexID1 source
	 * @param vertexID2 destination
	 * @return true if succeeded and vice versa
	 */
	public boolean searchEdge(int vertexID1, int vertexID2) {
		for(int i = 0; i < edges.size(); i++ ) {
			if( edges.get(i).getSource() == vertexID1 
					&& edges.get(i).getDest() == vertexID2 ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Override of the interface functions

	
	/**
	 * Override of the interface functions
	 */
	@Override
	public double[][] exportMatrix() {
		double[][] exp = new double[size][size];
		
		for(int i = 0; i < edges.size(); i++ ) {
			int x = edges.get(i).getDest(), 
					y = edges.get(i).getSource();
			
			exp[x][y] = edges.get(i).getWeight();
			exp[y][x] = edges.get(i).getWeight();
		}
		
		
		return exp;
	}
	 
	/**
	 * Getter for the size vertices
	 * @return size
	 */
	public int getSize() {
		return size;
	}
}
