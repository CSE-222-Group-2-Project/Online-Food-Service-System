package src.datastructures.graph;
/**
 * child class of abstract MyGraph calss
 * @author AzizCan
 *
 */
public class Graph extends MyGraph {
	
	/**
	 * Constructor
	 * @param size vertex size
	 */
	public Graph(int size) {
		super(size);
	}
	
	
	/**
	 * Override of parent 
	 */
	@Override
	public void addEdge(int VertexID1, int VertexID2, double weight) {
		super.addEdge(VertexID1, VertexID2, weight);
	}

}
